-- -  InstallPubli.SQL  
-- Modifiée par Régis Lécu en janvier 2004 pour compatibilité avec SQL Server 2000
-- Ajout d'une ligne à la table ventes par PG pour illustrer les ventes 
-- multiple d'un même livre dans un mêmme magasin commande "GAR001"
go
set nocount    on
set dateformat mdy

USE master
GO

declare @dttm varchar(55)
select  @dttm=convert(varchar,getdate(),113)
raiserror('Début de InstallPubli.SQL à %s ....',1,1,@dttm) with nowait
if exists (select * from sysdatabases where name='publi')
  DROP database publi
GO

CHECKPOINT
GO

CREATE DATABASE publi  
GO

CHECKPOINT
GO

USE publi
GO

if db_name() = 'publi'
   raiserror('Base de données Version Française ''PUBLI'' créée et contexte actuellement utilisé.',1,1)
else
   raiserror('Erreur dans InstallPubli.SQL, ''USE publi'' a échoué!  Arrêt immédiat du SPID.'
            ,22,127) with log

go

execute sp_dboption 'publi' ,'trunc. log on chkpt.' ,'true'

EXECUTE sp_addtype id, 'varchar(11)', 'NOT NULL'
EXECUTE sp_addtype idt, 'varchar(6)', 'NOT NULL'
EXECUTE sp_addtype empid, 'char(9)', 'NOT NULL'
go

raiserror('Etape de création de la section de table ....',1,1)
GO

CREATE TABLE auteurs
(
	id_auteur   id
		CHECK (id_auteur like '[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]')
		CONSTRAINT UPKCL_auidind PRIMARY KEY CLUSTERED,
	nom_auteur        varchar(40)     NOT NULL,
	pn_auteur        varchar(20)     NOT NULL,
	téléphone   char(12)        NOT NULL
		DEFAULT ('INCONNU'),
	adresse varchar(40)     NULL,
	ville    varchar(20)     NULL,
	pays   char(2) NULL,
	code_postal     char(5) NULL
		CHECK (code_postal like '[0-9][0-9][0-9][0-9][0-9]'),
	contrat        bit     NOT NULL
)
go

CREATE TABLE éditeurs
(
	id_éditeur  char(4) NOT NULL
		CONSTRAINT UPKCL_pubind PRIMARY KEY CLUSTERED
		CHECK (id_éditeur in ('1389', '0736', '0877', '1622', '1756')
			OR id_éditeur like '99[0-9][0-9]'),
	nom_éditeur        varchar(40)     NULL,
	ville    varchar(20)     NULL,
	région   char(2) NULL,
	pays varchar(30)     NULL
		DEFAULT('FR')
);
go

create table tot2
(id int);

CREATE TABLE titres
(
	id_titre        idt
		CONSTRAINT UPKCL_titleidind PRIMARY KEY CLUSTERED,
	titre   varchar(80)     NOT NULL,
	type    char(12)        NOT NULL
		DEFAULT ('SANS TITRE'),
	id_éditeur  char(4) NULL
		REFERENCES éditeurs(id_éditeur),
	prix   money   NULL,
	avance money   NULL,
	droits int     NULL,
	cumulannuel_ventes       int     NULL,
	notes   varchar(200)    NULL,
	datepub datetime        NOT NULL
		DEFAULT (getdate())
)
go

CREATE TABLE titreauteur
(
	id_auteur   id
		REFERENCES auteurs(id_auteur),
	id_titre        idt
		REFERENCES titres(id_titre),
	cmd_auteur  tinyint NULL,
	droits_pourcent      int     NULL,
	CONSTRAINT UPKCL_taind PRIMARY KEY CLUSTERED(id_auteur, id_titre)
)
go


CREATE TABLE magasins
(
	id_mag char(4) NOT NULL
		CONSTRAINT UPK_storeid PRIMARY KEY CLUSTERED,
	nom_mag       varchar(40)     NULL,
	adresse_mag    varchar(40)     NULL,
	ville    varchar(20)     NULL,
	pays   char(2) NULL,
	code_postal     char(5) NULL
)
go

CREATE TABLE ventes
(
	id_mag   char(4) NOT NULL
		  REFERENCES magasins(id_mag),
	num_cmd   varchar(20)     NOT NULL,
	date_cmd  datetime        NOT NULL,
	qt       smallint        NOT NULL,
	modepaiements  varchar(12)     NOT NULL,
	id_titre  idt
		  REFERENCES titres(id_titre),
	CONSTRAINT UPKCL_sales PRIMARY KEY CLUSTERED (id_mag, num_cmd, id_titre)
)
go


CREATE TABLE droits_prévus
(
	id_titre        idt
		REFERENCES titres(id_titre),
	minimum int     NULL,
	maximum int     NULL,
	droits int     NULL
)
go


CREATE TABLE remises
(
	typeremise    varchar(40)     NOT NULL,
	id_mag char(4) NULL
		REFERENCES magasins(id_mag),
	qtémin  smallint        NULL,
	qtémax smallint        NULL,
	remise dec(4,2) NOT NULL
)
go


CREATE TABLE emplois
(
	id_emploi  smallint
		IDENTITY(1,1)
		PRIMARY KEY CLUSTERED,
	desc_emploi        varchar(50)     NOT NULL
		DEFAULT 'Nouveau poste - pas de dénomination officielle',
	niv_min tinyint NOT NULL
		CHECK (niv_min >= 10),
	niv_max tinyint NOT NULL
		CHECK (niv_max <= 250)
)
go

CREATE TABLE pub_info
(
	pub_id char(4) NOT NULL
		REFERENCES éditeurs(id_éditeur)
		CONSTRAINT UPKCL_pubinfo PRIMARY KEY CLUSTERED,
	logo    image   NULL,
	pr_info text	 NULL
)
go


CREATE TABLE employé
(
	id_employé  empid
		CONSTRAINT PK_id_employé PRIMARY KEY NONCLUSTERED
		CONSTRAINT CK_id_employé CHECK (id_employé LIKE
			'[A-Z][A-Z][A-Z][1-9][0-9][0-9][0-9][0-9][FM]' or
			id_employé LIKE '[A-Z]-[A-Z][1-9][0-9][0-9][0-9][0-9][FM]'),
		
	pn_employé   varchar(20)     NOT NULL,
	init_centrale   char(1) NULL,
	nom_employé   varchar(30)     NOT NULL,
	id_emploi  smallint        NOT NULL
		DEFAULT 1
		
		REFERENCES emplois(id_emploi),
	position_employé tinyint
		DEFAULT 10,
		
	id_éditeur  char(4) NOT NULL
		DEFAULT ('9952')
		REFERENCES éditeurs(id_éditeur),
		
	date_embauche       datetime        NOT NULL
		DEFAULT (getdate())
)

go

raiserror('Etape de création de la section de trigger ....',1,1)
GO

CREATE TRIGGER employé_insupd
ON employé
FOR INSERT, UPDATE
AS
--Get the range of level for this job type from the jobs table.
DECLARE @niv_min tinyint,
	@niv_max tinyint,
	@niv_emploi tinyint,
	@id_emploi smallint
SELECT @niv_min = niv_min,
	@niv_max = niv_max,
	@niv_emploi = i.position_employé,
	@id_emploi = i.id_emploi
FROM employé e, emplois j, inserted i
WHERE e.id_employé = i.id_employé AND i.id_emploi = j.id_emploi
IF (@id_emploi = 1) and (@niv_emploi <> 10)
BEGIN
	RAISERROR ('L''identificateur d''emploi 1 attend le niveau par défaut 10.',16,-1)
	ROLLBACK TRANSACTION
END
ELSE
IF NOT (@niv_emploi BETWEEN @niv_min AND @niv_max)
BEGIN
	RAISERROR ('Le niveau de id_emploi:%d doit se situer entre %d et %d.',
		16, -1, @id_emploi, @niv_min, @niv_max)
	ROLLBACK TRANSACTION
END
go


raiserror('Etape d''insertion des auteurs ....',1,1)
GO

INSERT auteurs
	VALUES('409-56-7008','Bucchia','Patrice','42.01.84.27','201, boulevard de Clichy', 
	'Bordeaux','FR','33000',1)

INSERT auteurs
	VALUES ('213-46-8915','Mathieu','Charles','93.11.73.35','18, avenue Arbabi',
	'Paris','FR','78003',1)

INSERT auteurs
	VALUES('238-95-7766','Chartier','Laurent','38.66.24.53','4, impasse Lamoix',
	'Bordeaux','FR','33000',1)

INSERT auteurs
	VALUES('998-72-3567','Chevalier','Bernard','20.24.54.20','48, rue de Valmy',
	'Genève','CH','91712',1)

INSERT auteurs
	VALUES('899-46-2035','Chevalier','Anne','20.24.54.21','48, rue de Valmy',
	'Genève','CH','91712',1)

INSERT auteurs
	VALUES('722-51-5454','Hall','Catherine','54.43.36.78','12, rue Astarte',
	'Luxembourg','LU','02016',1)

INSERT auteurs
	VALUES('807-91-6654','Bec','Arthur','22.47.87.11','4, chemin de la Tour de Campel',
	'Bruges','BE','05006',1)

INSERT auteurs
	VALUES('893-72-1158','Facq','Jean-Rémy','56.48.05.44','59, rue Lisleferme',
	'Paris','FR','33000',0)

INSERT auteurs
	VALUES('724-08-9931','D''Autricourt','Alain','46.36.37.99','75, rue des Couronnes',
	'Paris','FR','75017',0)

INSERT auteurs
	VALUES('274-80-9391','Merrell','Patricia','42.27.44.35','2, place du Général Catroux',
	'Paris','FR','75015',1)

INSERT auteurs
	VALUES('756-30-7391','Jalabert','Marc','45.22.88.91','94, rue de la Condamine',
	'Paris','FR','75020',1)

INSERT auteurs
	VALUES('724-80-9391','Lacouture','Gilles','45.04.48.78','20, rue de la Pompe',
	'Marseille','FR','13016',1)

INSERT auteurs
	VALUES('427-17-2319','Logerot','Philippe','42.24.89.91','2, rue de l''Amiral Cloué',
	'Luxembourg','LU','01016',1)

INSERT auteurs
	VALUES('672-71-3249','De Verne','Vincent','45.48.12.23','113, rue du Cherche-Midi',
	'Vers-La-Petite','FR','91712',1)

INSERT auteurs
	VALUES('267-41-2394','Médina','Marguerite','48.96.77.44','48, passage Sainte Anne',
	'Toulouse','FR','31002',1)

INSERT auteurs
	VALUES('472-27-2349','Schildwachter','Xavier','47.07.44.77','11, rue Buffon',
	'Bruxelles','BE','02530',3)

INSERT auteurs
	VALUES('527-72-3246','Posey','William','69.15.11.00','57, avenue des tapis',
	'Zurich','CH','91450',0)

INSERT auteurs
	VALUES('172-32-1176','Bourne','Stéphanie','45.33.08.49','4, square Gauguin',
	'Nice','FR','06014',1)

INSERT auteurs
	VALUES('712-45-1867','Vilc','Benjamin','93.30.24.68','18, faubourg Saint Jean',
	'Monte Carlo','MC','98000',1)

INSERT auteurs
	VALUES('846-92-7186','Letournec','Benoît','48.54.31.99','32, rue du Mont Thabor',
	'Lille','FR','59000',1)

INSERT auteurs
	VALUES('486-29-1786','Vue','Jessica','42.71.09.71','62-64, rue Vieille du Temple',
	'Chevrette','FR','91450',1)

INSERT auteurs
	VALUES('648-92-1872','Sorense','Christophe','56.79.96.29',
	'55, rue Pierre-Louis Coll','Zurich','CH','91450',1)

INSERT auteurs
	VALUES('341-22-1782','Lorense','Danielle','02.32.89.34','14, impasse Lacarte',
	'Liège','BE','01548',0)
go

raiserror('Etape d''insertion des éditeurs ....',1,1)

GO

INSERT éditeurs VALUES('0736','New Moon Books','Boston', 'MA','USA' )
INSERT éditeurs VALUES('0877','Binnet & Hardley ','Washington','DC','USA' )
INSERT éditeurs VALUES('1389','Algodata Infosystems','Bruxelles',NULL,'BE' )
INSERT éditeurs VALUES('9952', 'Scootney Books', 'New york', 'NY', 'USA')
INSERT éditeurs VALUES('1622', 'Five Lakes Publishing', 'Chicago', 'IL', 'USA')
INSERT éditeurs VALUES('1756', 'Ramona, éditeur', 'Lausanne', NULL, 'CH')
INSERT éditeurs VALUES('9901', 'GGG&G', 'Munich', NULL, 'GER')
INSERT éditeurs VALUES('9999', 'Editions Lucerne', 'Paris', NULL, 'FR')
go

raiserror('Etape d''insertion des pub_info ....',1,1)

GO

INSERT pub_info VALUES('0736', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('0877', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('1389', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('9952', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('1622', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('1756', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('9901', 0xFFFFFFFF, 'Aucune information actuellement')
INSERT pub_info VALUES('9999', 0xFFFFFFFF, 'Aucune information actuellement')
go


raiserror('Etape d''insertion des titres ....',1,1)
GO

INSERT titres VALUES('PC8888','Les secrets de la Silicon Valley','informatique','1389',$136.00,$54000.00,10,4095,
'Deux femmes courageuses dévoilent tous les scandales qui jonchent l''irrésistible ascension des pionniers de l''informatique. Matériel et logiciel : personne n''est épargné.',
'12/06/85' )
go

INSERT titres VALUES('BU1032','Guide des bases de données du gestionnaire pressé','gestion','1389', $140.00,$35000.00,10,4095,
'Vue d''ensemble illustrée des systèmes de gestion de base de données disponibles sur le marché. L''accent est mis sur les applications de gestion courantes.','12/06/85' )
go

INSERT titres VALUES('PS7777','Equilibre émotionnel : un nouvel algorithme','psychologie','0736',$54.00,$27000.00,10,3336,
'Comment se protéger contre le stress exagéré du monde moderne. Parmi les remèdes proposés : utilisation de l''ordinateur et alimentation judicieusement choisie.','12/06/85' )
go

INSERT titres VALUES('PS3333','Privation durable d''informations : étude de quatre cas représentatifs','psychologie','0736',$136.00,$14000.00,10,4072,
'Que se passe-t-il quand les données viennent à manquer ? Analyse scientifique des effets du manque d''information sur les grands consommateurs.','12/06/85' )
go

INSERT titres VALUES('BU1111','La cuisine - l''ordinateur : bilans clandestins','gestion','1389',
$82.00,$34000.00,10,3876,
'Conseils utiles vous permettant de tirer le meilleur parti possible de vos ressources informatiques.','09/06/85' )
go

INSERT titres VALUES('MC2222','Les festins de Parly 2','cui_moderne','0877',$136.00,$0.00,12,2032,
'Recueil de recettes rapides, faciles et élégantes, testées et goûtées par des gens qui n''ont jamais le temps de manger. Aide précieuse pour le cuisinier occasionnel.','09/06/85' )
go

INSERT titres VALUES('PC1035','Est-ce vraiment convivial ?','informatique','1389',$156.00,$48000.00,16,8780,
'Etude comparative des progiciels les plus répandus. S''adressant aux utilisateurs débutants, cet ouvrage établit un palmarès des logiciels en fonction de leur convivialité.','12/06/85' )
go

INSERT titres VALUES('BU2075','Le stress en informatique n''est pas une fatalité !','gestion','0736',$24.00,$69000.00,24,18722,'Exposé des techniques médicales et psychologiques les plus récentes permettant de survivre dans le bureau électronique. Explications claires et détaillées.','12/06/85' )

INSERT titres VALUES('PS2091','La colère : notre ennemie ?','psychologie','0736',$76.00,$15000.00,12,2045,'Etude approfondie des conséquences somatiques des émotions fortes. De nombreux schémas du métabolisme illustrent l''exposé et en facilitent la compréhension.','11/06/85' )

INSERT titres VALUES('PS2106','Vivre sans crainte','psychologie','0736',$49.00,$41000.00,10,111,
'Comment amortir le choc des interactions quotidiennes par la gymnastique, la méditation et la diététique (nombreux exemples de menus). Bandes vidéo sur commande pour les exercices physiques.','05/10/85' )

INSERT titres VALUES('MC3021','Les micro-ondes par gourmandise','cui_moderne','0877',$21.00,$102000.00,24,22246,'Adaptation de recettes traditionnelles des provinces fran‡aises - la cuisine au micro-ondes.','11/06/85' )
go

INSERT titres (id_titre, titre, id_éditeur) VALUES('MC3026','La psychologie des ordinateurs de cuisine','0877')
go
INSERT titres VALUES  ('BU7832','Toute la vérité sur les ordinateurs','gestion','1389',$136.00,$34000.00,10,4095,'Analyse commentée des possibilités offertes par les ordinateurs : un guide impartial pour l''utilisateur critique','12/06/85' )
go
INSERT titres VALUES('PS1372','Phobie et passion informatique : éventail de comportements','psychologie','0877',$147,$48000.00,10,375,'Lecture indispensable pour le spécialiste : cet ouvrage étudie les différences entre ceux qui détestent et craignent les ordinateurs et ceux qui les trouvent épatants.','11/10/85' )
go
INSERT titres (id_titre, titre, type, id_éditeur, notes) VALUES('PC9999','Guide des bonnes manières sur un réseau','informatique','1389','La bible des débutants dans un environnement réseau.')
go


raiserror('Etape d''insertion de titreauteur ....',1,1)

GO

INSERT titreauteur VALUES('409-56-7008', 'BU1032', 1, 60)
go
INSERT titreauteur VALUES('486-29-1786', 'PS7777', 1, 100)
go
INSERT titreauteur VALUES('486-29-1786', 'PC9999', 1, 100)
go
INSERT titreauteur VALUES('712-45-1867', 'MC2222', 1, 100)
go
INSERT titreauteur VALUES('172-32-1176', 'PS3333', 1, 100)
go
INSERT titreauteur VALUES('213-46-8915', 'BU1032', 2, 40)
go
INSERT titreauteur VALUES('238-95-7766', 'PC1035', 1, 100)

INSERT titreauteur VALUES('213-46-8915', 'BU2075', 1, 100)
INSERT titreauteur VALUES('998-72-3567', 'PS2091', 1, 50)
INSERT titreauteur VALUES('899-46-2035', 'PS2091', 2, 50)
INSERT titreauteur VALUES('998-72-3567', 'PS2106', 1, 100)
INSERT titreauteur VALUES('722-51-5454', 'MC3021', 1, 75)
INSERT titreauteur VALUES('899-46-2035', 'MC3021', 2, 25)
INSERT titreauteur VALUES('274-80-9391', 'BU7832', 1, 100)
INSERT titreauteur VALUES('427-17-2319', 'PC8888', 1, 50)
INSERT titreauteur VALUES('846-92-7186', 'PC8888', 2, 50)
INSERT titreauteur VALUES('756-30-7391', 'PS1372', 1, 75)
INSERT titreauteur VALUES('724-80-9391', 'PS1372', 2, 25)
INSERT titreauteur VALUES('724-80-9391', 'BU1111', 1, 60)
INSERT titreauteur VALUES('267-41-2394', 'BU1111', 2, 40)


go

raiserror('Etape d''insertion des magasins ....',1,1)

GO

INSERT magasins VALUES('7066','Librairie spécialisée','567, Av. de la Victoire','Paris','FR','75016')
INSERT magasins VALUES('7067','Moissons livresques','577, Boulevard Anspach.','Bruxelles','BE','1000')
INSERT magasins VALUES('7131','Doc-U-Mat: Quality Laundry and Books',
		'24-A Avogadro Way','Remulade','WA','98014')
INSERT magasins VALUES('8042','Bookbeat','679 Carson St.','Portland','OR','89076')
INSERT magasins VALUES('6380','Eric the Read Books','788 Catamaugus Ave.',
		'Seattle','WA','98056')
INSERT magasins VALUES('7896','Fricative Bookshop','89 Madison St.','Fremont','CA','90019')
go

raiserror('Etape d''insertion des ventes ....',1,1)

GO

INSERT ventes VALUES('7066', 'QA7442.3', '11/09/94', 75, 'Comptant','PS2091')
INSERT ventes VALUES('7067', 'D4482', '12/09/94', 10, 'Net 60','PS2091')
INSERT ventes VALUES('7131', 'N914008', '12/09/94', 20, 'Net 30','PS2091')
INSERT ventes VALUES('7131', 'N914014', '12/09/94', 25, 'Net 30','MC3021')
INSERT ventes VALUES('8042', '423LL922', '12/09/94', 15, 'Comptant','MC3021')
INSERT ventes VALUES('8042', '423LL930', '12/09/94', 10, 'Comptant','BU1032')
INSERT ventes VALUES('6380', '722a', '11/09/94', 3, 'Net 60','PS2091')
INSERT ventes VALUES('6380', '6871', '12/09/94', 5, 'Net 60','BU1032')
INSERT ventes VALUES('8042','P723', '11/03/93', 25, 'Net 30', 'BU1111')
INSERT ventes VALUES('7896','X999', '11/02/93', 35, 'Comptant', 'BU2075')
INSERT ventes VALUES('7896','QQ2299', '12/10/93', 15, 'Net 60', 'BU7832')
INSERT ventes VALUES('7896','TQ456', '12/12/93', 10, 'Net 60', 'MC2222')
INSERT ventes VALUES('8042','QA879.1', '10/05/93', 30, 'Net 30', 'PC1035')
INSERT ventes VALUES('7066','A2976', '12/05/93', 50, 'Net 30', 'PC8888')
INSERT ventes VALUES('7131','P3087a', '12/05/93', 20, 'Net 60', 'PS1372')
INSERT ventes VALUES('7131','P3087a', '12/05/93', 25, 'Net 60', 'PS2106')
INSERT ventes VALUES('7131','P3087a', '12/05/93', 15, 'Net 60', 'PS3333')
INSERT ventes VALUES('7131','P3087a', '12/05/93', 25, 'Net 60', 'PS7777')
--Ajout GARRAUD
INSERT ventes VALUES('7066','GAR001', '10/03/04', 25, 'Net 60', 'PS2091')

go

raiserror('Etape d''insertion de droits_prévus ....',1,1)

GO

INSERT droits_prévus VALUES('BU1032', 0, 5000, 10)
INSERT droits_prévus VALUES('BU1032', 5001, 50000, 12)
INSERT droits_prévus VALUES('PC1035', 0, 2000, 10)
INSERT droits_prévus VALUES('PC1035', 2001, 3000, 12)
INSERT droits_prévus VALUES('PC1035', 3001, 4000, 14)
INSERT droits_prévus VALUES('PC1035', 4001, 10000, 16)
INSERT droits_prévus VALUES('PC1035', 10001, 50000, 18)
INSERT droits_prévus VALUES('BU2075', 0, 1000, 10)
INSERT droits_prévus VALUES('BU2075', 1001, 3000, 12)
INSERT droits_prévus VALUES('BU2075', 3001, 5000, 14)
go
INSERT droits_prévus VALUES('BU2075', 5001, 7000, 16)
INSERT droits_prévus VALUES('BU2075', 7001, 10000, 18)
INSERT droits_prévus VALUES('BU2075', 10001, 12000, 20)
INSERT droits_prévus VALUES('BU2075', 12001, 14000, 22)
INSERT droits_prévus VALUES('BU2075', 14001, 50000, 24)
INSERT droits_prévus VALUES('PS2091', 0, 1000, 10)
INSERT droits_prévus VALUES('PS2091', 1001, 5000, 12)
INSERT droits_prévus VALUES('PS2091', 5001, 10000, 14)
INSERT droits_prévus VALUES('PS2091', 10001, 50000, 16)
INSERT droits_prévus VALUES('PS2106', 0, 2000, 10)
go
INSERT droits_prévus VALUES('PS2106', 2001, 5000, 12)
INSERT droits_prévus VALUES('PS2106', 5001, 10000, 14)
INSERT droits_prévus VALUES('PS2106', 10001, 50000, 16)
INSERT droits_prévus VALUES('MC3021', 0, 1000, 10)
INSERT droits_prévus VALUES('MC3021', 1001, 2000, 12)
INSERT droits_prévus VALUES('MC3021', 2001, 4000, 14)
INSERT droits_prévus VALUES('MC3021', 4001, 6000, 16)
INSERT droits_prévus VALUES('MC3021', 6001, 8000, 18)
INSERT droits_prévus VALUES('MC3021', 8001, 10000, 20)
INSERT droits_prévus VALUES('MC3021', 10001, 12000, 22)
go
INSERT droits_prévus VALUES('MC3021', 12001, 50000, 24)
INSERT droits_prévus VALUES('PC8888', 0, 5000, 10)
INSERT droits_prévus VALUES('PC8888', 5001, 10000, 12)
go
INSERT droits_prévus VALUES('PC8888', 10001, 15000, 14)
INSERT droits_prévus VALUES('PC8888', 15001, 50000, 16)
INSERT droits_prévus VALUES('PS7777', 0, 5000, 10)
INSERT droits_prévus VALUES('PS7777', 5001, 50000, 12)
INSERT droits_prévus VALUES('PS3333', 0, 5000, 10)
INSERT droits_prévus VALUES('PS3333', 5001, 10000, 12)
INSERT droits_prévus VALUES('PS3333', 10001, 15000, 14)
INSERT droits_prévus VALUES('PS3333', 15001, 50000, 16)
INSERT droits_prévus VALUES('BU1111', 0, 4000, 10)
INSERT droits_prévus VALUES('BU1111', 4001, 8000, 12)
INSERT droits_prévus VALUES('BU1111', 8001, 10000, 14)
go
INSERT droits_prévus VALUES('BU1111', 12001, 16000, 16)
INSERT droits_prévus VALUES('BU1111', 16001, 20000, 18)
INSERT droits_prévus VALUES('BU1111', 20001, 24000, 20)
INSERT droits_prévus VALUES('BU1111', 24001, 28000, 22)
INSERT droits_prévus VALUES('BU1111', 28001, 50000, 24)

go
INSERT droits_prévus VALUES('BU7832', 0, 5000, 10)
INSERT droits_prévus VALUES('BU7832', 5001, 10000, 12)
INSERT droits_prévus VALUES('BU7832', 10001, 15000, 14)
INSERT droits_prévus VALUES('BU7832', 15001, 20000, 16)
INSERT droits_prévus VALUES('BU7832', 20001, 25000, 18)
INSERT droits_prévus VALUES('BU7832', 25001, 30000, 20)
INSERT droits_prévus VALUES('BU7832', 30001, 35000, 22)
INSERT droits_prévus VALUES('BU7832', 35001, 50000, 24)
go
INSERT droits_prévus VALUES('PS1372', 0, 10000, 10)
INSERT droits_prévus VALUES('PS1372', 10001, 20000, 12)
INSERT droits_prévus VALUES('PS1372', 20001, 30000, 14)
INSERT droits_prévus VALUES('PS1372', 30001, 40000, 16)
INSERT droits_prévus VALUES('PS1372', 40001, 50000, 18)
go

raiserror('Etape d''insertion des remises ....',1,1)

GO

INSERT remises VALUES('Remise initiale', NULL, NULL, NULL, 10.5)
INSERT remises VALUES('Remise volume', NULL, 100, 1000, 6.7)
INSERT remises VALUES('Remise client', '8042', NULL, NULL, 5.0)
go

raiserror('Etape d''insertion des emplois ....',1,1)

GO

INSERT emplois VALUES ('Nouveau collaborateur - Poste non spécifié', 10, 10)
INSERT emplois VALUES ('Directeur général', 200, 250)
INSERT emplois VALUES ('Directeur des opérations commerciales', 175, 225)
INSERT emplois VALUES ('Responsable financier', 175, 250)
INSERT emplois VALUES ('Editeur', 150, 250)
INSERT emplois VALUES ('Editeur en chef', 140, 225)
INSERT emplois VALUES ('Directeur du marketing', 120, 200)
INSERT emplois VALUES ('Directeur des relations publiques', 100, 175)
INSERT emplois VALUES ('Directeur des achats', 75, 175)
INSERT emplois VALUES ('Directeur de la production', 75, 165)
INSERT emplois VALUES ('Directeur des opérations', 75, 150)
INSERT emplois VALUES ('Rédacteur', 25, 100)
INSERT emplois VALUES ('Représentant commercial', 25, 100)
INSERT emplois VALUES ('Graphiste', 25, 100)
go

raiserror('Etape d''insertion des employés....',1,1)

GO

INSERT employé VALUES ('PTC11962M', 'Philip', 'T', 'Cramer', 2, 215, '9952', '11/11/89')
INSERT employé VALUES ('AMD15433F', 'Ann', 'M', 'Devon', 3, 200, '9952', '12/07/91')
INSERT employé VALUES ('F-C16315M', 'Francisco', '', 'Chang', 4, 227, '9952', '03/11/90')
INSERT employé VALUES ('LAL21447M', 'Laurence', 'A', 'Lebihan', 5, 175, '0736',
'03/06/90')
INSERT employé VALUES ('PXH22250M', 'Paul', 'X', 'Henriot', 5, 159, '0877', '11/08/93')
INSERT employé VALUES ('SKO22412M', 'Sven', 'K', 'Ottlieb', 5, 150, '1389', '05/04/91')
INSERT employé VALUES ('LCQ23061M', 'Luc', 'C', 'Querton', 5, 198, '1622', '09/10/93')
INSERT employé VALUES ('PJD25939M', 'Philippe', 'J', 'De Bueger', 5, 246, '1756', '01/03/89')
INSERT employé VALUES ('JYL26161F', 'Janine', 'Y', 'Labrune', 5, 172, '9901', '12/05/91')
INSERT employé VALUES ('CAS28514M', 'Carlos', 'A', 'Santana', 5, 211, '9999',
'11/04/89')
INSERT employé VALUES ('VPA30890F', 'Victoria', 'P', 'Ashworth', 6, 140, '0877',
'11/09/90')
INSERT employé VALUES ('L-B31947F', 'Lesley', '', 'Brown', 7, 120, '0877', '11/02/91')
INSERT employé VALUES ('ARD36773F', 'Anabela', 'R', 'Domingues', 8, 100, '0877',
'12/01/93')
INSERT employé VALUES ('M-R38834F', 'Martine', '', 'Rancé', 9, 75, '0877', '05/02/92')
INSERT employé VALUES ('PHF38899M', 'Peter', 'H', 'Franken', 10, 75, '0877', '12/05/92')
INSERT employé VALUES ('DBT39435M', 'Daniel', 'B', 'Tonini', 11, 75, '0877', '01/01/90')
INSERT employé VALUES ('R-D39728F', 'Renelde', '', 'Depré', 12, 35, '0877', '11/09/89')
INSERT employé VALUES ('PMA42628M', 'Paolo', 'M', 'Accorti', 13, 35, '0877', '12/08/92')
INSERT employé VALUES ('ENL44273F', 'Elizabeth', 'N', 'Lincoln', 14, 35, '0877',
'12/07/90')
INSERT employé VALUES ('MGK44605M', 'Matti', 'G', 'Karttunen', 6, 220, '0736',
'01/05/94')
INSERT employé VALUES ('PDI47470M', 'Palle', 'D', 'Ibsen', 7, 195, '0736', '09/05/93')
INSERT employé VALUES ('MMS49649F', 'Mary', 'M', 'Saveley', 8, 175, '0736', '12/06/93')
INSERT employé VALUES ('PHB50241M', 'Patrick', 'H', 'Brognon', 9, 170, '0736', '09/08/88')
INSERT employé VALUES ('MFS52347M', 'Martin', 'F', 'Sommer', 10, 165, '0736', '11/04/90')
INSERT employé VALUES ('R-M53550M', 'Roland', '', 'Mendel', 11, 150, '0736', '05/09/91')
INSERT employé VALUES ('HAS54740M', 'Howard', 'A', 'Snyder', 12, 100, '0736', '11/11/88')
INSERT employé VALUES ('TPO55093M', 'Timothy', 'P', 'O''Rourke', 13, 100, '0736',
'11/06/88')
INSERT employé VALUES ('KFJ64308F', 'Karin', 'F', 'Josephs', 14, 100, '0736', '12/10/92')
INSERT employé VALUES ('DWR65030M', 'Diego', 'W', 'Roel', 6, 192, '1389', '12/12/91')
INSERT employé VALUES ('M-L67958F', 'Maria', '', 'Larsson', 7, 135, '1389', '12/03/92')
INSERT employé VALUES ('PSP68661F', 'Paula', 'S', 'Parente', 8, 125, '1389', '12/01/94')
INSERT employé VALUES ('MAS70474F', 'Margaret', 'A', 'Smith', 9, 78, '1389', '12/09/88')
INSERT employé VALUES ('A-C71970F', 'Aria', '', 'Cruz', 10, 87, '1389', '12/10/91')
INSERT employé VALUES ('MAP77183M', 'Miguel', 'A', 'Paolino', 11, 112, '1389',
'07/12/92')
INSERT employé VALUES ('Y-L77953M', 'Yoshi', '', 'Latimer', 12, 32, '1389', '11/06/89')
INSERT employé VALUES ('CGS88322F', 'Carine', 'G', 'Schmitt', 13, 64, '1389', '07/07/92')
INSERT employé VALUES ('PSA89086M', 'Pedro', 'S', 'Alfonso', 14, 89, '1389', '12/12/90')
INSERT employé VALUES ('A-R89858F', 'Annette', '', 'Roulet', 6, 152, '9999', '11/02/90')
INSERT employé VALUES ('HAN90777M', 'Helvetius', 'A', 'Nagy', 7, 120, '9999', '11/03/93')
INSERT employé VALUES ('M-P91209M', 'Manuel', '', 'Pereira', 8, 101, '9999', '09/01/89')
INSERT employé VALUES ('LJR92907F', 'Laurence', 'J', 'Radoux', 9, 170, '9999',
'11/03/94')
INSERT employé VALUES ('POK93028M', 'Pirkko', 'O', 'Koskitalo', 10, 80, '9999',
'11/11/93')
INSERT employé VALUES ('PCM98509F', 'Patricia', 'C', 'McKenna', 11, 150, '9999',
'01/08/89')
go

raiserror('Etape de création de la section d''index ....',1,1) with nowait

GO

CREATE CLUSTERED INDEX employé_ind ON employé(nom_employé, pn_employé, init_centrale)
go

CREATE NONCLUSTERED INDEX aunmind ON auteurs (nom_auteur, pn_auteur)
go
CREATE NONCLUSTERED INDEX titleidind ON ventes (id_titre)
go
CREATE NONCLUSTERED INDEX titleind ON titres (titre)
go
CREATE NONCLUSTERED INDEX auidind ON titreauteur (id_auteur)
go
CREATE NONCLUSTERED INDEX titleidind ON titreauteur (id_titre)
go
CREATE NONCLUSTERED INDEX titleidind ON droits_prévus (id_titre)
go

raiserror('Etape de création de la section d''view ....',1,1) with nowait
GO

CREATE VIEW vuetitre
AS
SELECT titre, cmd_auteur, nom_auteur, prix, cumulannuel_ventes, id_éditeur
FROM auteurs, titres, titreauteur
WHERE auteurs.id_auteur = titreauteur.id_auteur
	AND titres.id_titre = titreauteur.id_titre
go

raiserror('Etape de création de la section de procedure ....',1,1) with nowait

GO

CREATE PROCEDURE pardroits @pourcentage int
AS
SELECT id_auteur FROM titreauteur
WHERE titreauteur.droits_pourcent = @pourcentage
go

raiserror('(Ensuite, premier octroi incorporé dans la section de proc.)',1,1)

GRANT EXECUTE ON pardroits TO public
go

CREATE PROCEDURE reptq1 AS
SELECT id_éditeur, id_titre, prix, datepub
FROM titres
WHERE prix is NOT NULL
ORDER BY id_éditeur
COMPUTE avg(prix) BY id_éditeur
COMPUTE avg(prix)
go

GRANT EXECUTE ON reptq1 TO public
go

CREATE PROCEDURE reptq2 AS
SELECT type, id_éditeur, titres.id_titre, cmd_auteur,
	Name = substring (nom_auteur, 1,15), cumulannuel_ventes
FROM titres, auteurs, titreauteur
WHERE titres.id_titre = titreauteur.id_titre AND auteurs.id_auteur = titreauteur.id_auteur
	AND id_éditeur is NOT NULL
ORDER BY id_éditeur, type
COMPUTE avg(cumulannuel_ventes) BY id_éditeur, type
COMPUTE avg(cumulannuel_ventes) BY id_éditeur
go

GRANT EXECUTE ON reptq2 TO public
go

CREATE PROCEDURE reptq3 @limite_inférieure money, @limite_supérieure money, @type char(12)
AS
SELECT id_éditeur, type, id_titre, prix
FROM titres
WHERE prix > @limite_inférieure AND prix <@limite_supérieure AND type = @type OR type LIKE '%cui%'
ORDER BY id_éditeur, type
COMPUTE count(id_titre) BY id_éditeur, type
go

GRANT EXECUTE ON reptq3 TO public

go
GRANT CREATE PROCEDURE TO public
go

raiserror('Etape de la section de GUEST ....',1,1)

GO

EXECUTE sp_adduser guest
go

GRANT ALL ON éditeurs TO guest
GRANT ALL ON pub_info TO guest
GRANT ALL ON employé TO guest
GRANT ALL ON emplois TO guest
GRANT ALL ON titres TO guest
GRANT ALL ON auteurs TO guest
GRANT ALL ON titreauteur TO guest
GRANT ALL ON ventes TO guest
GRANT ALL ON droits_prévus TO guest
GRANT ALL ON magasins TO guest
GRANT ALL ON remises TO guest
GRANT ALL ON vuetitre TO guest

GRANT EXECUTE ON pardroits TO guest

GRANT CREATE TABLE TO guest
GRANT CREATE VIEW TO guest
GRANT CREATE RULE TO guest
GRANT CREATE DEFAULT TO guest
GRANT CREATE PROCEDURE TO guest
go


UPDATE STATISTICS éditeurs
UPDATE STATISTICS employé
UPDATE STATISTICS emplois
UPDATE STATISTICS pub_info
UPDATE STATISTICS titres
UPDATE STATISTICS auteurs
UPDATE STATISTICS titreauteur
UPDATE STATISTICS ventes
UPDATE STATISTICS droits_prévus
UPDATE STATISTICS magasins
UPDATE STATISTICS remises

GO

CHECKPOINT
go

declare @dttm varchar(55)
select  @dttm=convert(varchar,getdate(),113)
raiserror('Fin de InstPubs.SQL … %s ....',1,1,@dttm) with nowait

GO
-- -
