-- -  InstallPubli.SQL  
-- Modifi�e par R�gis L�cu en janvier 2004 pour compatibilit� avec SQL Server 2000
-- Ajout d'une ligne � la table ventes par PG pour illustrer les ventes 
-- multiple d'un m�me livre dans un m�mme magasin commande "GAR001"
go
set nocount    on
set dateformat mdy

USE master
GO

declare @dttm varchar(55)
select  @dttm=convert(varchar,getdate(),113)
raiserror('D�but de InstallPubli.SQL � %s ....',1,1,@dttm) with nowait
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
   raiserror('Base de donn�es Version Fran�aise ''PUBLI'' cr��e et contexte actuellement utilis�.',1,1)
else
   raiserror('Erreur dans InstallPubli.SQL, ''USE publi'' a �chou�!  Arr�t imm�diat du SPID.'
            ,22,127) with log

go

execute sp_dboption 'publi' ,'trunc. log on chkpt.' ,'true'

EXECUTE sp_addtype id, 'varchar(11)', 'NOT NULL'
EXECUTE sp_addtype idt, 'varchar(6)', 'NOT NULL'
EXECUTE sp_addtype empid, 'char(9)', 'NOT NULL'
go

raiserror('Etape de cr�ation de la section de table ....',1,1)
GO

CREATE TABLE auteurs
(
	id_auteur   id
		CHECK (id_auteur like '[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]')
		CONSTRAINT UPKCL_auidind PRIMARY KEY CLUSTERED,
	nom_auteur        varchar(40)     NOT NULL,
	pn_auteur        varchar(20)     NOT NULL,
	t�l�phone   char(12)        NOT NULL
		DEFAULT ('INCONNU'),
	adresse varchar(40)     NULL,
	ville    varchar(20)     NULL,
	pays   char(2) NULL,
	code_postal     char(5) NULL
		CHECK (code_postal like '[0-9][0-9][0-9][0-9][0-9]'),
	contrat        bit     NOT NULL
)
go

CREATE TABLE �diteurs
(
	id_�diteur  char(4) NOT NULL
		CONSTRAINT UPKCL_pubind PRIMARY KEY CLUSTERED
		CHECK (id_�diteur in ('1389', '0736', '0877', '1622', '1756')
			OR id_�diteur like '99[0-9][0-9]'),
	nom_�diteur        varchar(40)     NULL,
	ville    varchar(20)     NULL,
	r�gion   char(2) NULL,
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
	id_�diteur  char(4) NULL
		REFERENCES �diteurs(id_�diteur),
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


CREATE TABLE droits_pr�vus
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
	qt�min  smallint        NULL,
	qt�max smallint        NULL,
	remise dec(4,2) NOT NULL
)
go


CREATE TABLE emplois
(
	id_emploi  smallint
		IDENTITY(1,1)
		PRIMARY KEY CLUSTERED,
	desc_emploi        varchar(50)     NOT NULL
		DEFAULT 'Nouveau poste - pas de d�nomination officielle',
	niv_min tinyint NOT NULL
		CHECK (niv_min >= 10),
	niv_max tinyint NOT NULL
		CHECK (niv_max <= 250)
)
go

CREATE TABLE pub_info
(
	pub_id char(4) NOT NULL
		REFERENCES �diteurs(id_�diteur)
		CONSTRAINT UPKCL_pubinfo PRIMARY KEY CLUSTERED,
	logo    image   NULL,
	pr_info text	 NULL
)
go


CREATE TABLE employ�
(
	id_employ�  empid
		CONSTRAINT PK_id_employ� PRIMARY KEY NONCLUSTERED
		CONSTRAINT CK_id_employ� CHECK (id_employ� LIKE
			'[A-Z][A-Z][A-Z][1-9][0-9][0-9][0-9][0-9][FM]' or
			id_employ� LIKE '[A-Z]-[A-Z][1-9][0-9][0-9][0-9][0-9][FM]'),
		
	pn_employ�   varchar(20)     NOT NULL,
	init_centrale   char(1) NULL,
	nom_employ�   varchar(30)     NOT NULL,
	id_emploi  smallint        NOT NULL
		DEFAULT 1
		
		REFERENCES emplois(id_emploi),
	position_employ� tinyint
		DEFAULT 10,
		
	id_�diteur  char(4) NOT NULL
		DEFAULT ('9952')
		REFERENCES �diteurs(id_�diteur),
		
	date_embauche       datetime        NOT NULL
		DEFAULT (getdate())
)

go

raiserror('Etape de cr�ation de la section de trigger ....',1,1)
GO

CREATE TRIGGER employ�_insupd
ON employ�
FOR INSERT, UPDATE
AS
--Get the range of level for this job type from the jobs table.
DECLARE @niv_min tinyint,
	@niv_max tinyint,
	@niv_emploi tinyint,
	@id_emploi smallint
SELECT @niv_min = niv_min,
	@niv_max = niv_max,
	@niv_emploi = i.position_employ�,
	@id_emploi = i.id_emploi
FROM employ� e, emplois j, inserted i
WHERE e.id_employ� = i.id_employ� AND i.id_emploi = j.id_emploi
IF (@id_emploi = 1) and (@niv_emploi <> 10)
BEGIN
	RAISERROR ('L''identificateur d''emploi 1 attend le niveau par d�faut 10.',16,-1)
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
	'Gen�ve','CH','91712',1)

INSERT auteurs
	VALUES('899-46-2035','Chevalier','Anne','20.24.54.21','48, rue de Valmy',
	'Gen�ve','CH','91712',1)

INSERT auteurs
	VALUES('722-51-5454','Hall','Catherine','54.43.36.78','12, rue Astarte',
	'Luxembourg','LU','02016',1)

INSERT auteurs
	VALUES('807-91-6654','Bec','Arthur','22.47.87.11','4, chemin de la Tour de Campel',
	'Bruges','BE','05006',1)

INSERT auteurs
	VALUES('893-72-1158','Facq','Jean-R�my','56.48.05.44','59, rue Lisleferme',
	'Paris','FR','33000',0)

INSERT auteurs
	VALUES('724-08-9931','D''Autricourt','Alain','46.36.37.99','75, rue des Couronnes',
	'Paris','FR','75017',0)

INSERT auteurs
	VALUES('274-80-9391','Merrell','Patricia','42.27.44.35','2, place du G�n�ral Catroux',
	'Paris','FR','75015',1)

INSERT auteurs
	VALUES('756-30-7391','Jalabert','Marc','45.22.88.91','94, rue de la Condamine',
	'Paris','FR','75020',1)

INSERT auteurs
	VALUES('724-80-9391','Lacouture','Gilles','45.04.48.78','20, rue de la Pompe',
	'Marseille','FR','13016',1)

INSERT auteurs
	VALUES('427-17-2319','Logerot','Philippe','42.24.89.91','2, rue de l''Amiral Clou�',
	'Luxembourg','LU','01016',1)

INSERT auteurs
	VALUES('672-71-3249','De Verne','Vincent','45.48.12.23','113, rue du Cherche-Midi',
	'Vers-La-Petite','FR','91712',1)

INSERT auteurs
	VALUES('267-41-2394','M�dina','Marguerite','48.96.77.44','48, passage Sainte Anne',
	'Toulouse','FR','31002',1)

INSERT auteurs
	VALUES('472-27-2349','Schildwachter','Xavier','47.07.44.77','11, rue Buffon',
	'Bruxelles','BE','02530',3)

INSERT auteurs
	VALUES('527-72-3246','Posey','William','69.15.11.00','57, avenue des tapis',
	'Zurich','CH','91450',0)

INSERT auteurs
	VALUES('172-32-1176','Bourne','St�phanie','45.33.08.49','4, square Gauguin',
	'Nice','FR','06014',1)

INSERT auteurs
	VALUES('712-45-1867','Vilc','Benjamin','93.30.24.68','18, faubourg Saint Jean',
	'Monte Carlo','MC','98000',1)

INSERT auteurs
	VALUES('846-92-7186','Letournec','Beno�t','48.54.31.99','32, rue du Mont Thabor',
	'Lille','FR','59000',1)

INSERT auteurs
	VALUES('486-29-1786','Vue','Jessica','42.71.09.71','62-64, rue Vieille du Temple',
	'Chevrette','FR','91450',1)

INSERT auteurs
	VALUES('648-92-1872','Sorense','Christophe','56.79.96.29',
	'55, rue Pierre-Louis Coll','Zurich','CH','91450',1)

INSERT auteurs
	VALUES('341-22-1782','Lorense','Danielle','02.32.89.34','14, impasse Lacarte',
	'Li�ge','BE','01548',0)
go

raiserror('Etape d''insertion des �diteurs ....',1,1)

GO

INSERT �diteurs VALUES('0736','New Moon Books','Boston', 'MA','USA' )
INSERT �diteurs VALUES('0877','Binnet & Hardley ','Washington','DC','USA' )
INSERT �diteurs VALUES('1389','Algodata Infosystems','Bruxelles',NULL,'BE' )
INSERT �diteurs VALUES('9952', 'Scootney Books', 'New york', 'NY', 'USA')
INSERT �diteurs VALUES('1622', 'Five Lakes Publishing', 'Chicago', 'IL', 'USA')
INSERT �diteurs VALUES('1756', 'Ramona, �diteur', 'Lausanne', NULL, 'CH')
INSERT �diteurs VALUES('9901', 'GGG&G', 'Munich', NULL, 'GER')
INSERT �diteurs VALUES('9999', 'Editions Lucerne', 'Paris', NULL, 'FR')
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
'Deux femmes courageuses d�voilent tous les scandales qui jonchent l''irr�sistible ascension des pionniers de l''informatique. Mat�riel et logiciel : personne n''est �pargn�.',
'12/06/85' )
go

INSERT titres VALUES('BU1032','Guide des bases de donn�es du gestionnaire press�','gestion','1389', $140.00,$35000.00,10,4095,
'Vue d''ensemble illustr�e des syst�mes de gestion de base de donn�es disponibles sur le march�. L''accent est mis sur les applications de gestion courantes.','12/06/85' )
go

INSERT titres VALUES('PS7777','Equilibre �motionnel : un nouvel algorithme','psychologie','0736',$54.00,$27000.00,10,3336,
'Comment se prot�ger contre le stress exag�r� du monde moderne. Parmi les rem�des propos�s : utilisation de l''ordinateur et alimentation judicieusement choisie.','12/06/85' )
go

INSERT titres VALUES('PS3333','Privation durable d''informations : �tude de quatre cas repr�sentatifs','psychologie','0736',$136.00,$14000.00,10,4072,
'Que se passe-t-il quand les donn�es viennent � manquer ? Analyse scientifique des effets du manque d''information sur les grands consommateurs.','12/06/85' )
go

INSERT titres VALUES('BU1111','La cuisine - l''ordinateur : bilans clandestins','gestion','1389',
$82.00,$34000.00,10,3876,
'Conseils utiles vous permettant de tirer le meilleur parti possible de vos ressources informatiques.','09/06/85' )
go

INSERT titres VALUES('MC2222','Les festins de Parly 2','cui_moderne','0877',$136.00,$0.00,12,2032,
'Recueil de recettes rapides, faciles et �l�gantes, test�es et go�t�es par des gens qui n''ont jamais le temps de manger. Aide pr�cieuse pour le cuisinier occasionnel.','09/06/85' )
go

INSERT titres VALUES('PC1035','Est-ce vraiment convivial ?','informatique','1389',$156.00,$48000.00,16,8780,
'Etude comparative des progiciels les plus r�pandus. S''adressant aux utilisateurs d�butants, cet ouvrage �tablit un palmar�s des logiciels en fonction de leur convivialit�.','12/06/85' )
go

INSERT titres VALUES('BU2075','Le stress en informatique n''est pas une fatalit� !','gestion','0736',$24.00,$69000.00,24,18722,'Expos� des techniques m�dicales et psychologiques les plus r�centes permettant de survivre dans le bureau �lectronique. Explications claires et d�taill�es.','12/06/85' )

INSERT titres VALUES('PS2091','La col�re : notre ennemie ?','psychologie','0736',$76.00,$15000.00,12,2045,'Etude approfondie des cons�quences somatiques des �motions fortes. De nombreux sch�mas du m�tabolisme illustrent l''expos� et en facilitent la compr�hension.','11/06/85' )

INSERT titres VALUES('PS2106','Vivre sans crainte','psychologie','0736',$49.00,$41000.00,10,111,
'Comment amortir le choc des interactions quotidiennes par la gymnastique, la m�ditation et la di�t�tique (nombreux exemples de menus). Bandes vid�o sur commande pour les exercices physiques.','05/10/85' )

INSERT titres VALUES('MC3021','Les micro-ondes par gourmandise','cui_moderne','0877',$21.00,$102000.00,24,22246,'Adaptation de recettes traditionnelles des provinces fran�aises - la cuisine au micro-ondes.','11/06/85' )
go

INSERT titres (id_titre, titre, id_�diteur) VALUES('MC3026','La psychologie des ordinateurs de cuisine','0877')
go
INSERT titres VALUES  ('BU7832','Toute la v�rit� sur les ordinateurs','gestion','1389',$136.00,$34000.00,10,4095,'Analyse comment�e des possibilit�s offertes par les ordinateurs : un guide impartial pour l''utilisateur critique','12/06/85' )
go
INSERT titres VALUES('PS1372','Phobie et passion informatique : �ventail de comportements','psychologie','0877',$147,$48000.00,10,375,'Lecture indispensable pour le sp�cialiste : cet ouvrage �tudie les diff�rences entre ceux qui d�testent et craignent les ordinateurs et ceux qui les trouvent �patants.','11/10/85' )
go
INSERT titres (id_titre, titre, type, id_�diteur, notes) VALUES('PC9999','Guide des bonnes mani�res sur un r�seau','informatique','1389','La bible des d�butants dans un environnement r�seau.')
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

INSERT magasins VALUES('7066','Librairie sp�cialis�e','567, Av. de la Victoire','Paris','FR','75016')
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

raiserror('Etape d''insertion de droits_pr�vus ....',1,1)

GO

INSERT droits_pr�vus VALUES('BU1032', 0, 5000, 10)
INSERT droits_pr�vus VALUES('BU1032', 5001, 50000, 12)
INSERT droits_pr�vus VALUES('PC1035', 0, 2000, 10)
INSERT droits_pr�vus VALUES('PC1035', 2001, 3000, 12)
INSERT droits_pr�vus VALUES('PC1035', 3001, 4000, 14)
INSERT droits_pr�vus VALUES('PC1035', 4001, 10000, 16)
INSERT droits_pr�vus VALUES('PC1035', 10001, 50000, 18)
INSERT droits_pr�vus VALUES('BU2075', 0, 1000, 10)
INSERT droits_pr�vus VALUES('BU2075', 1001, 3000, 12)
INSERT droits_pr�vus VALUES('BU2075', 3001, 5000, 14)
go
INSERT droits_pr�vus VALUES('BU2075', 5001, 7000, 16)
INSERT droits_pr�vus VALUES('BU2075', 7001, 10000, 18)
INSERT droits_pr�vus VALUES('BU2075', 10001, 12000, 20)
INSERT droits_pr�vus VALUES('BU2075', 12001, 14000, 22)
INSERT droits_pr�vus VALUES('BU2075', 14001, 50000, 24)
INSERT droits_pr�vus VALUES('PS2091', 0, 1000, 10)
INSERT droits_pr�vus VALUES('PS2091', 1001, 5000, 12)
INSERT droits_pr�vus VALUES('PS2091', 5001, 10000, 14)
INSERT droits_pr�vus VALUES('PS2091', 10001, 50000, 16)
INSERT droits_pr�vus VALUES('PS2106', 0, 2000, 10)
go
INSERT droits_pr�vus VALUES('PS2106', 2001, 5000, 12)
INSERT droits_pr�vus VALUES('PS2106', 5001, 10000, 14)
INSERT droits_pr�vus VALUES('PS2106', 10001, 50000, 16)
INSERT droits_pr�vus VALUES('MC3021', 0, 1000, 10)
INSERT droits_pr�vus VALUES('MC3021', 1001, 2000, 12)
INSERT droits_pr�vus VALUES('MC3021', 2001, 4000, 14)
INSERT droits_pr�vus VALUES('MC3021', 4001, 6000, 16)
INSERT droits_pr�vus VALUES('MC3021', 6001, 8000, 18)
INSERT droits_pr�vus VALUES('MC3021', 8001, 10000, 20)
INSERT droits_pr�vus VALUES('MC3021', 10001, 12000, 22)
go
INSERT droits_pr�vus VALUES('MC3021', 12001, 50000, 24)
INSERT droits_pr�vus VALUES('PC8888', 0, 5000, 10)
INSERT droits_pr�vus VALUES('PC8888', 5001, 10000, 12)
go
INSERT droits_pr�vus VALUES('PC8888', 10001, 15000, 14)
INSERT droits_pr�vus VALUES('PC8888', 15001, 50000, 16)
INSERT droits_pr�vus VALUES('PS7777', 0, 5000, 10)
INSERT droits_pr�vus VALUES('PS7777', 5001, 50000, 12)
INSERT droits_pr�vus VALUES('PS3333', 0, 5000, 10)
INSERT droits_pr�vus VALUES('PS3333', 5001, 10000, 12)
INSERT droits_pr�vus VALUES('PS3333', 10001, 15000, 14)
INSERT droits_pr�vus VALUES('PS3333', 15001, 50000, 16)
INSERT droits_pr�vus VALUES('BU1111', 0, 4000, 10)
INSERT droits_pr�vus VALUES('BU1111', 4001, 8000, 12)
INSERT droits_pr�vus VALUES('BU1111', 8001, 10000, 14)
go
INSERT droits_pr�vus VALUES('BU1111', 12001, 16000, 16)
INSERT droits_pr�vus VALUES('BU1111', 16001, 20000, 18)
INSERT droits_pr�vus VALUES('BU1111', 20001, 24000, 20)
INSERT droits_pr�vus VALUES('BU1111', 24001, 28000, 22)
INSERT droits_pr�vus VALUES('BU1111', 28001, 50000, 24)

go
INSERT droits_pr�vus VALUES('BU7832', 0, 5000, 10)
INSERT droits_pr�vus VALUES('BU7832', 5001, 10000, 12)
INSERT droits_pr�vus VALUES('BU7832', 10001, 15000, 14)
INSERT droits_pr�vus VALUES('BU7832', 15001, 20000, 16)
INSERT droits_pr�vus VALUES('BU7832', 20001, 25000, 18)
INSERT droits_pr�vus VALUES('BU7832', 25001, 30000, 20)
INSERT droits_pr�vus VALUES('BU7832', 30001, 35000, 22)
INSERT droits_pr�vus VALUES('BU7832', 35001, 50000, 24)
go
INSERT droits_pr�vus VALUES('PS1372', 0, 10000, 10)
INSERT droits_pr�vus VALUES('PS1372', 10001, 20000, 12)
INSERT droits_pr�vus VALUES('PS1372', 20001, 30000, 14)
INSERT droits_pr�vus VALUES('PS1372', 30001, 40000, 16)
INSERT droits_pr�vus VALUES('PS1372', 40001, 50000, 18)
go

raiserror('Etape d''insertion des remises ....',1,1)

GO

INSERT remises VALUES('Remise initiale', NULL, NULL, NULL, 10.5)
INSERT remises VALUES('Remise volume', NULL, 100, 1000, 6.7)
INSERT remises VALUES('Remise client', '8042', NULL, NULL, 5.0)
go

raiserror('Etape d''insertion des emplois ....',1,1)

GO

INSERT emplois VALUES ('Nouveau collaborateur - Poste non sp�cifi�', 10, 10)
INSERT emplois VALUES ('Directeur g�n�ral', 200, 250)
INSERT emplois VALUES ('Directeur des op�rations commerciales', 175, 225)
INSERT emplois VALUES ('Responsable financier', 175, 250)
INSERT emplois VALUES ('Editeur', 150, 250)
INSERT emplois VALUES ('Editeur en chef', 140, 225)
INSERT emplois VALUES ('Directeur du marketing', 120, 200)
INSERT emplois VALUES ('Directeur des relations publiques', 100, 175)
INSERT emplois VALUES ('Directeur des achats', 75, 175)
INSERT emplois VALUES ('Directeur de la production', 75, 165)
INSERT emplois VALUES ('Directeur des op�rations', 75, 150)
INSERT emplois VALUES ('R�dacteur', 25, 100)
INSERT emplois VALUES ('Repr�sentant commercial', 25, 100)
INSERT emplois VALUES ('Graphiste', 25, 100)
go

raiserror('Etape d''insertion des employ�s....',1,1)

GO

INSERT employ� VALUES ('PTC11962M', 'Philip', 'T', 'Cramer', 2, 215, '9952', '11/11/89')
INSERT employ� VALUES ('AMD15433F', 'Ann', 'M', 'Devon', 3, 200, '9952', '12/07/91')
INSERT employ� VALUES ('F-C16315M', 'Francisco', '', 'Chang', 4, 227, '9952', '03/11/90')
INSERT employ� VALUES ('LAL21447M', 'Laurence', 'A', 'Lebihan', 5, 175, '0736',
'03/06/90')
INSERT employ� VALUES ('PXH22250M', 'Paul', 'X', 'Henriot', 5, 159, '0877', '11/08/93')
INSERT employ� VALUES ('SKO22412M', 'Sven', 'K', 'Ottlieb', 5, 150, '1389', '05/04/91')
INSERT employ� VALUES ('LCQ23061M', 'Luc', 'C', 'Querton', 5, 198, '1622', '09/10/93')
INSERT employ� VALUES ('PJD25939M', 'Philippe', 'J', 'De Bueger', 5, 246, '1756', '01/03/89')
INSERT employ� VALUES ('JYL26161F', 'Janine', 'Y', 'Labrune', 5, 172, '9901', '12/05/91')
INSERT employ� VALUES ('CAS28514M', 'Carlos', 'A', 'Santana', 5, 211, '9999',
'11/04/89')
INSERT employ� VALUES ('VPA30890F', 'Victoria', 'P', 'Ashworth', 6, 140, '0877',
'11/09/90')
INSERT employ� VALUES ('L-B31947F', 'Lesley', '', 'Brown', 7, 120, '0877', '11/02/91')
INSERT employ� VALUES ('ARD36773F', 'Anabela', 'R', 'Domingues', 8, 100, '0877',
'12/01/93')
INSERT employ� VALUES ('M-R38834F', 'Martine', '', 'Ranc�', 9, 75, '0877', '05/02/92')
INSERT employ� VALUES ('PHF38899M', 'Peter', 'H', 'Franken', 10, 75, '0877', '12/05/92')
INSERT employ� VALUES ('DBT39435M', 'Daniel', 'B', 'Tonini', 11, 75, '0877', '01/01/90')
INSERT employ� VALUES ('R-D39728F', 'Renelde', '', 'Depr�', 12, 35, '0877', '11/09/89')
INSERT employ� VALUES ('PMA42628M', 'Paolo', 'M', 'Accorti', 13, 35, '0877', '12/08/92')
INSERT employ� VALUES ('ENL44273F', 'Elizabeth', 'N', 'Lincoln', 14, 35, '0877',
'12/07/90')
INSERT employ� VALUES ('MGK44605M', 'Matti', 'G', 'Karttunen', 6, 220, '0736',
'01/05/94')
INSERT employ� VALUES ('PDI47470M', 'Palle', 'D', 'Ibsen', 7, 195, '0736', '09/05/93')
INSERT employ� VALUES ('MMS49649F', 'Mary', 'M', 'Saveley', 8, 175, '0736', '12/06/93')
INSERT employ� VALUES ('PHB50241M', 'Patrick', 'H', 'Brognon', 9, 170, '0736', '09/08/88')
INSERT employ� VALUES ('MFS52347M', 'Martin', 'F', 'Sommer', 10, 165, '0736', '11/04/90')
INSERT employ� VALUES ('R-M53550M', 'Roland', '', 'Mendel', 11, 150, '0736', '05/09/91')
INSERT employ� VALUES ('HAS54740M', 'Howard', 'A', 'Snyder', 12, 100, '0736', '11/11/88')
INSERT employ� VALUES ('TPO55093M', 'Timothy', 'P', 'O''Rourke', 13, 100, '0736',
'11/06/88')
INSERT employ� VALUES ('KFJ64308F', 'Karin', 'F', 'Josephs', 14, 100, '0736', '12/10/92')
INSERT employ� VALUES ('DWR65030M', 'Diego', 'W', 'Roel', 6, 192, '1389', '12/12/91')
INSERT employ� VALUES ('M-L67958F', 'Maria', '', 'Larsson', 7, 135, '1389', '12/03/92')
INSERT employ� VALUES ('PSP68661F', 'Paula', 'S', 'Parente', 8, 125, '1389', '12/01/94')
INSERT employ� VALUES ('MAS70474F', 'Margaret', 'A', 'Smith', 9, 78, '1389', '12/09/88')
INSERT employ� VALUES ('A-C71970F', 'Aria', '', 'Cruz', 10, 87, '1389', '12/10/91')
INSERT employ� VALUES ('MAP77183M', 'Miguel', 'A', 'Paolino', 11, 112, '1389',
'07/12/92')
INSERT employ� VALUES ('Y-L77953M', 'Yoshi', '', 'Latimer', 12, 32, '1389', '11/06/89')
INSERT employ� VALUES ('CGS88322F', 'Carine', 'G', 'Schmitt', 13, 64, '1389', '07/07/92')
INSERT employ� VALUES ('PSA89086M', 'Pedro', 'S', 'Alfonso', 14, 89, '1389', '12/12/90')
INSERT employ� VALUES ('A-R89858F', 'Annette', '', 'Roulet', 6, 152, '9999', '11/02/90')
INSERT employ� VALUES ('HAN90777M', 'Helvetius', 'A', 'Nagy', 7, 120, '9999', '11/03/93')
INSERT employ� VALUES ('M-P91209M', 'Manuel', '', 'Pereira', 8, 101, '9999', '09/01/89')
INSERT employ� VALUES ('LJR92907F', 'Laurence', 'J', 'Radoux', 9, 170, '9999',
'11/03/94')
INSERT employ� VALUES ('POK93028M', 'Pirkko', 'O', 'Koskitalo', 10, 80, '9999',
'11/11/93')
INSERT employ� VALUES ('PCM98509F', 'Patricia', 'C', 'McKenna', 11, 150, '9999',
'01/08/89')
go

raiserror('Etape de cr�ation de la section d''index ....',1,1) with nowait

GO

CREATE CLUSTERED INDEX employ�_ind ON employ�(nom_employ�, pn_employ�, init_centrale)
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
CREATE NONCLUSTERED INDEX titleidind ON droits_pr�vus (id_titre)
go

raiserror('Etape de cr�ation de la section d''view ....',1,1) with nowait
GO

CREATE VIEW vuetitre
AS
SELECT titre, cmd_auteur, nom_auteur, prix, cumulannuel_ventes, id_�diteur
FROM auteurs, titres, titreauteur
WHERE auteurs.id_auteur = titreauteur.id_auteur
	AND titres.id_titre = titreauteur.id_titre
go

raiserror('Etape de cr�ation de la section de procedure ....',1,1) with nowait

GO

CREATE PROCEDURE pardroits @pourcentage int
AS
SELECT id_auteur FROM titreauteur
WHERE titreauteur.droits_pourcent = @pourcentage
go

raiserror('(Ensuite, premier octroi incorpor� dans la section de proc.)',1,1)

GRANT EXECUTE ON pardroits TO public
go

CREATE PROCEDURE reptq1 AS
SELECT id_�diteur, id_titre, prix, datepub
FROM titres
WHERE prix is NOT NULL
ORDER BY id_�diteur
COMPUTE avg(prix) BY id_�diteur
COMPUTE avg(prix)
go

GRANT EXECUTE ON reptq1 TO public
go

CREATE PROCEDURE reptq2 AS
SELECT type, id_�diteur, titres.id_titre, cmd_auteur,
	Name = substring (nom_auteur, 1,15), cumulannuel_ventes
FROM titres, auteurs, titreauteur
WHERE titres.id_titre = titreauteur.id_titre AND auteurs.id_auteur = titreauteur.id_auteur
	AND id_�diteur is NOT NULL
ORDER BY id_�diteur, type
COMPUTE avg(cumulannuel_ventes) BY id_�diteur, type
COMPUTE avg(cumulannuel_ventes) BY id_�diteur
go

GRANT EXECUTE ON reptq2 TO public
go

CREATE PROCEDURE reptq3 @limite_inf�rieure money, @limite_sup�rieure money, @type char(12)
AS
SELECT id_�diteur, type, id_titre, prix
FROM titres
WHERE prix > @limite_inf�rieure AND prix <@limite_sup�rieure AND type = @type OR type LIKE '%cui%'
ORDER BY id_�diteur, type
COMPUTE count(id_titre) BY id_�diteur, type
go

GRANT EXECUTE ON reptq3 TO public

go
GRANT CREATE PROCEDURE TO public
go

raiserror('Etape de la section de GUEST ....',1,1)

GO

EXECUTE sp_adduser guest
go

GRANT ALL ON �diteurs TO guest
GRANT ALL ON pub_info TO guest
GRANT ALL ON employ� TO guest
GRANT ALL ON emplois TO guest
GRANT ALL ON titres TO guest
GRANT ALL ON auteurs TO guest
GRANT ALL ON titreauteur TO guest
GRANT ALL ON ventes TO guest
GRANT ALL ON droits_pr�vus TO guest
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


UPDATE STATISTICS �diteurs
UPDATE STATISTICS employ�
UPDATE STATISTICS emplois
UPDATE STATISTICS pub_info
UPDATE STATISTICS titres
UPDATE STATISTICS auteurs
UPDATE STATISTICS titreauteur
UPDATE STATISTICS ventes
UPDATE STATISTICS droits_pr�vus
UPDATE STATISTICS magasins
UPDATE STATISTICS remises

GO

CHECKPOINT
go

declare @dttm varchar(55)
select  @dttm=convert(varchar,getdate(),113)
raiserror('Fin de InstPubs.SQL � %s ....',1,1,@dttm) with nowait

GO
-- -
