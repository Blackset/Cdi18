create database AirCat2
go

use AirCat2
go



/* étape 1 */
/* Création des types utilisateurs */
create TYPE TypeDate
from datetime not null

create Type TypeHoraire
from smalldatetime not null

create Type TypeNom
from varchar(50) not null

create type TypePrenom
from varchar(30)  null

create type TypeAvion
from varchar(20) not null

create type TypeIdConstructeur
from smallint not null

create type TypeIdAeroport
from char(3) not null

create type TypeIdPilote
from smallint not null

create type TypeNumVol
from char(5) not null

create type TypeVille
from varchar(50) null

go

/* creation des tables et des contraintes */
create TABLE CONSTRUCTEUR
(
	IdConstructeur	TypeIdConstructeur primary key identity (1,1),
	NomConstructeur TypeNom 
)

create TABLE PILOTE
(
	IdPilote TypeIdPilote primary key identity (1,1),
	NomPilote TypeNom, 
	PrenomPilote TypePrenom,
	unique(NomPilote,PrenomPilote)
)

create TABLE AEROPORT
(
	IdAeroport TypeIdAeroport primary key check(IdAeroport like '[a-zA-Z][a-zA-Z][a-zA-Z]'),
	NomAeroport TypeNom not null,
	NomVilleDesservie TypeNom null
)
go
create TABLE TYPE
(
	TypeAvion TypeAvion primary key check(TypeAvion like '[a-zA-Z]%'),
	Capacite smallint not null default 100 check (Capacite >=50 and Capacite <= 400),
	IdConstructeur TypeIdConstructeur not null references CONSTRUCTEUR(IdConstructeur)
)
create TABLE VOL
(
	NumVol TypeNumVol primary key check(NumVol like '[I][T][0-9][0-9][0-9]'),
	AeroportDept TypeIdAeroport,
	Hdépart TypeHoraire,
	AeroportArr TypeIdAeroport,
	HArrivée TypeHoraire
	foreign key (AeroportDept) references AEROPORT(IdAeroport),
	foreign key (AeroportArr) references AEROPORT(IdAeroport),
)

create TABLE AVION
(
	NumAvion smallint primary key identity(100,1),
	TypeAvion TypeAvion,
	BaseAeroport TypeIdAeroport,
	foreign key (TypeAvion) references TYPE(TypeAvion),
	foreign key (BaseAeroport) references AEROPORT(IdAeroport),
)
create TABLE AFFECTATION
(
	NumVol TypeNumVol not null ,
	DateVol  TypeDate not null ,
	primary key(NumVol,DateVol),
	NumAvion smallint  ,
	IdPilote TypeIdPilote null ,
	foreign key (NumAvion) references AVION(NumAvion),
	foreign key (IdPilote) references PILOTE(IdPilote),
	foreign key (NumVol) references VOL(NumVol),
	
)
/*---------------------------------------------------
insert CONSTRUCTEUR
values('Aérospatiale')
insert CONSTRUCTEUR
values('Boeing')
go
---------------------------------------------------
insert PILOTE
values('GAINSBOURG','Serge')
insert PILOTE
values('FERRAT','Jean')
go
---------------------------------------------------
insert AEROPORT
values ('ORL','Orly','Paris')
insert AEROPORT
values ( 'GRE','Saint Geoir','Grenoble')
insert AEROPORT
values ('CDG','Roissy','Paris')
insert AEROPORT
values ('LYS','Saint Exupéry','Lyon')
go
---------------------------------------------------
insert TYPE
values ('A320',300,1)
insert TYPE
values ('B707',250,2)
go
---------------------------------------------------
insert VOL
values('IT001','ORL','09:00:00','GRE','19:00:00')
insert VOL
values('IT002','ORL','10:16:00','LYS','15:00:00')
insert VOL
values ('IT003','GRE','19:00:00','LYS','23:00:00')
insert VOL
values ('IT004','CDG','19:00:00','GRE','23:00:00')
go
-------------------------------------------------
insert AVION
values('A320','GRE')
insert AVION
values('B707','CDG')
-------------------------------------------------
insert AFFECTATION
values('IT001',GETDATE(),101,1)
insert AFFECTATION
values('IT002',GETDATE(),102,2)
insert AFFECTATION
values('IT003',GETDATE(),101,2)
insert AFFECTATION
values('IT004',GETDATE(),102,1)
insert AFFECTATION
values('IT004','10-03-2013',102,1)
go
-----------------------------------------*/
INSERT PILOTE
VALUES ('GAINSBOURG', 'Serge')
INSERT PILOTE
VALUES ('FERRAT', 'Jean')
INSERT PILOTE
VALUES ('NOUGARO', 'Claude')
INSERT PILOTE
VALUES ('SCHUMMAN', 'Robert')
INSERT PILOTE
VALUES ('STROGOFF', 'Michel')
INSERT PILOTE
VALUES ('SORREL', 'Lucien')
INSERT PILOTE
VALUES ('TAVERNIER', 'Bertrand')
INSERT PILOTE
VALUES ('FAYOLLE', 'Marc')
INSERT PILOTE
VALUES ('LECU',	'Régis')
go
------------------------------------------------
INSERT CONSTRUCTEUR
VALUES ('Aérospatiale')
INSERT CONSTRUCTEUR
VALUES ('Boeing')
INSERT CONSTRUCTEUR
VALUES ('Cessna')
INSERT CONSTRUCTEUR
VALUES ('Douglas')
-----------------------------------------------
INSERT AEROPORT
VALUES ('BAS', 'Poretta', 'Bastia')
INSERT AEROPORT
VALUES ('BRI', 'Brive', 'Brive')
INSERT AEROPORT
VALUES ('GRE', 'Saint Geoir', 'Grenoble')		 	 
INSERT AEROPORT
VALUES ('LYS', 'Saint exupéry', 'Lyon')			 	
INSERT AEROPORT
VALUES ('NAN', 'Saint Herblain', 'Nantes')				 	
INSERT AEROPORT
VALUES ('NIC', 'Nice cote d''azur', 'Nice')	
INSERT AEROPORT
VALUES ('CDG', 'Roissy', 'Paris')				
INSERT AEROPORT
VALUES ('BLA', 'Blagnac', 'Toulouse')				
INSERT AEROPORT
VALUES ('ORL', 'Orly', 'Paris')		
go		
----------------------------------------------------------
INSERT VOL
VALUES ('IT100', 'NIC', '07:00', 'CDG', '09:00')
INSERT VOL
VALUES('IT101', 'ORL', '11:00', 'BLA', '12:00')
INSERT VOL
VALUES('IT102', 'CDG', '12:00', 'NIC', '14:00')	 				
INSERT VOL
VALUES('IT103', 'GRE', '09:00:00', 'BLA', '11:00:00')	 	
INSERT VOL
VALUES('IT104', 'BLA', '17:00:00', 'GRE', '19:00:00')	
INSERT VOL
VALUES('IT105', 'LYS', '06:00:00', 'ORL', '07:00:00')	
INSERT VOL
VALUES('IT106', 'BAS', '10:00:00', 'ORL', '13:00:00')	
INSERT VOL
VALUES('IT107', 'NIC', '07:00:00', 'BRI', '08:00:00')	
INSERT VOL
VALUES('IT108', 'BRI', '19:00:00', 'ORL', '20:00:00')	
INSERT VOL
VALUES('IT109', 'NIC', '18:00:00', 'ORL', '19:00:00')	
INSERT VOL
VALUES('IT110', 'ORL', '15:00:00', 'NIC', '16:00:00')		
INSERT VOL
VALUES('IT111', 'NIC', '17:00:00', 'NAN', '19:00:00')			
go
-------------------------------------------------------------
INSERT TYPE
VALUES('A320', 300, 1)	
INSERT TYPE
VALUES('B707', 250, 2)
INSERT TYPE
VALUES('DC10', 200, 4)
INSERT TYPE
VALUES('B747', 400, 2)
INSERT TYPE
VALUES('ATR42', 50, 1)	
INSERT TYPE
VALUES('B727', 300, 2)			              	
INSERT TYPE
VALUES('A340', 350, 1)		
go	
---------------------------------------------
INSERT AVION
VALUES ('A320', 'NIC')                			
INSERT AVION
VALUES ('B707', 'CDG')
INSERT AVION
VALUES ('A320', 'BLA')
INSERT AVION
VALUES ('DC10', 'BLA')
INSERT AVION
VALUES ('B747', 'ORL')
INSERT AVION
VALUES ('A320', 'GRE')
INSERT AVION
VALUES ('ATR42', 'CDG')
INSERT AVION
VALUES ('B727', 'LYS')                	
INSERT AVION
VALUES ('B727', 'NAN')
INSERT AVION
VALUES ('A340', 'BAS')
go
---------------------------------------------
INSERT AFFECTATION
VALUES ('IT100', '06/04/01',100 ,1 )
INSERT AFFECTATION
VALUES ('IT101', '06/04/01',100 , 2)
INSERT AFFECTATION
VALUES ('IT102', '06/04/01',101 ,1 )
INSERT AFFECTATION
VALUES ('IT103', '06/04/01',105 ,3 )
INSERT AFFECTATION
VALUES ('IT104', '06/04/01',105 , 3)
INSERT AFFECTATION
VALUES ('IT106', '06/04/01',109 , 8)
INSERT AFFECTATION
VALUES ('IT107', '06/04/01',106 ,9 )	
INSERT AFFECTATION
VALUES ('IT108', '06/04/01',106, 9  )	
INSERT AFFECTATION
VALUES ('IT109', '06/04/01', 107, 7 )	
INSERT AFFECTATION
VALUES ('IT110', '06/04/01', 102, 2 )	
INSERT AFFECTATION
VALUES ('IT111', '06/04/01', 101, 4 )	
INSERT AFFECTATION
VALUES ('IT105', '06/04/01', 107, 7 )	
INSERT AFFECTATION
VALUES ('IT100', '07/04/01',101 , 2 )	
INSERT AFFECTATION
VALUES ('IT101', '07/04/01',103 , 4 )	
INSERT AFFECTATION
VALUES ('IT102', '07/04/01',102 , 3 )	
INSERT AFFECTATION
VALUES ('IT103', '07/04/01',104 , 2 )	
INSERT AFFECTATION
VALUES ('IT104', '07/04/01',107 , 8 )	
INSERT AFFECTATION
VALUES ('IT105', '07/04/01',106 , 7 )	
INSERT AFFECTATION
VALUES ('IT106', '07/04/01',104 , 5 )	
INSERT AFFECTATION
VALUES ('IT107', '07/04/01',103 , 8 )	
INSERT AFFECTATION
VALUES ('IT108', '07/04/01',106 , 5 )	
INSERT AFFECTATION
VALUES ('IT109', '07/04/01',105 , 1 )	     			
INSERT AFFECTATION
VALUES ('IT110', '07/04/01',104 , 3 )	
INSERT AFFECTATION
VALUES ('IT111', '07/04/01',100 , 8 )	
go
---------------------------------------------------------	     					            
/* creation d'une vue*/
create view Départ (NumVol,De,A,Heure_de_Départ,Heure_Arrivée)
as
select vo.NumVol,vo.AeroportDept,vo.AeroportArr,
				DATENAME(hh,vo.Hdépart)+'H'+DATENAME(mi,vo.Hdépart),-- pb heure pas 09
				DATENAME(hh,vo.HArrivée)+'H'+DATENAME(mi,vo.HArrivée)-- pb minute pas 00
from VOL vo
join AEROPORT ae on ae.IdAeroport = vo.AeroportDept
join AFFECTATION af on af.NumVol = vo.NumVol
where ae.NomVilleDesservie like 'Paris'
and DateName(dayofyear,af.DateVol) = DateName(dayofyear,'07/04/01')

go
/* affichage de la vue */
SELECT [NumVol]
      ,[De]
      ,[A]
      ,[Heure_de_Départ]
      ,[Heure_Arrivée]
  FROM [AirCat2].[dbo].[Départ]
go
/*
--exec sp_dropuser visiteur


create user visiteur1 for login visiteur
go
create user  Responsable_planification for login hellebois
--exec sp_adduser , Responsable_horaires
go
exec sp_adduser dicapua, Responsable_planification
go
create role Production

exec sp_addrolemember 'Production', 'Responsable_planification'

grant select on Départ
to visiteur1
go

grant all on VOL
to Responsable_horaires

grant create view
to Responsable_horaires

grant select on TYPE
to Responsable_horaires
grant select on AVION
to Responsable_horaires
grant select on AEROPORT
to Responsable_horaires

go

grant select,insert,update,delete on AFFECTATION
to Responsable_planification

grant create view
to Responsable_planification

grant select on AVION
to Responsable_planification
grant select on VOL
to Responsable_planification
grant select on PILOTE
to Responsable_planification
grant select on TYPE
to Responsable_planification

go
*/
/* Création d'une fonction scalaire*/
/* Faire un select qui affiche la somme des heures de vol d'un pilote donné,
pour un numéro de semaine donné, avec la présentation suivante
-------------------------------------------------------------
Semaine 49, Heures de Vols de LECU Regis = 3*/

go
alter FUNCTION fnHeuresDeVol(@npilote TypeNom,@ppilote TypePrenom,@numsem int)
returns int
as
begin
	declare @retour int;
	if @npilote is null or @ppilote is null
	   set @retour = -1;
	else if not exists (select * from PILOTE where NomPilote=@npilote and PrenomPilote= @ppilote )
	   set @retour = -2;
	else
	begin
		select @retour = sum(DATEDIFF(hh,vo.Hdépart,vo.Harrivée))
		from VOL vo
		join AFFECTATION af on af.NumVol = vo.NumVol
		join PILOTE pil on pil.IdPilote = af.IdPilote
		where DATEPART(ww,DateVol) = @numsem
				and pil.NomPilote = @npilote
				and pil.PrenomPilote = @ppilote;
				
		if @retour is null
			set @retour = 0;
	end    
    return @retour;
end
go

-- MAIN test fonction scalaire
declare @nom TypeNom ;
declare @prenom TypePrenom;
declare @semaine int;

-- test avec valeur correct 
set @nom = 'LECU';
set @prenom = 'Régis';
set @semaine = 14;

print 'Semaine '+ convert(varchar(2),@semaine)+', Heures de Vols de '+@nom+' '+@prenom+
	' = '+  convert (varchar(50), dbo.fnHeuresDeVol (@nom, @prenom,@semaine) );


-- test avec valeur null
set @nom = null;
set @prenom = 'Régis';
declare @ret int;
set @ret = dbo.fnHeuresDeVol (@nom, @prenom,@semaine);

if @ret = -1
   print  'Nom ou prénom non défini';
else if @ret= -2
     print @nom + '  ' + @prenom + ' n''existe pas ';
else
print 'Semaine '+ convert(varchar(2),@semaine)+', Heures de Vols de '+@nom+' '+@prenom+
	' = '+  convert (varchar(50), @ret );


-- test avec une valeur incorrect

set @nom = 'xxxx';
set @prenom = 'Régis';

set @ret = dbo.fnHeuresDeVol (@nom, @prenom,@semaine);

if @ret = -1
   print @nom + '  ' + @prenom + 'non défini';
else if @ret= -2
     print @nom + '  ' + @prenom + ' n''existe pas ';
else
print 'Semaine '+ convert(varchar(2),@semaine)+', Heures de Vols de '+@nom+' '+@prenom+
	' = '+  convert (varchar(50), @ret );

go




				

