CREATE database airlinair
go
use airlinair
go

create type TypeDate 
from datetime
not null 

create type TypeHoraire
from smalldatetime
not null

create type TypeNom
from varchar (50)
not null

create type TypePrenom
from varchar(30)
null

create type TypeAvion 
from varchar (20)
not null

create type TypeIdConstructeur
from smallint 
not null

create type TypeIdAeroport 
from char (3)
not null

create type TypeIdPilote 
from smallint
not null

create type TypeNumVol
from char(5)
not null

create type TypeVille 
from varchar (50)
null
go
create table Constructeur
(
IdConstructeur   TypeIdConstructeur identity (1,1) primary key,  
NomConstructeur TypeNom not null,
--0
)
create table PILOTE
(
IdPilote TypeIdPilote identity (1,1) primary key,
NomPilote TypeNom not null,
PrenomPilote TypePrenom not null,
--0
)

create table AEROPORT
(
IdAeroport TypeIdAeroport check ( IdAeroport like '[A-Z][A-Z][A-Z]') primary key, 
NomAeroport  TypeNom not null,
NomVilleDesservie TypeVille null,
--0
)

create table TYPE
(
Type_Avion TypeAvion check (Type_Avion like '[A-Z]%') primary key,
capacite smallint not null check (capacite >= 50 and capacite <= 400) default '100',
idConstructeur  TypeIdConstructeur references CONSTRUCTEUR(IdConstructeur) not null,
--1
)

create table AVION
(
NumAvion smallint identity (100,1) primary key,
Type_Avion TypeAvion  references TYPE(Type_Avion),
BaseAeroport TypeIdAeroport not null foreign key (BaseAeroport)  references AEROPORT(IdAeroport),
--1 
)


create table VOL
(
 NumVol TypeNumVol not null primary key,
 constraint CK_NumVol check(NumVol like 'IT[0-9][0-9][0-9]'), 
 Aeroportdept TypeIdAeroport not null foreign key (Aeroportdept)references AEROPORT (IdAeroport), 
 Hdépart TypeHoraire not null,
 AeroportArr TypeIdAeroport not null foreign key (AeroportArr) references  AEROPORT (IdAeroport) , 
 HArrivée TypeHoraire not null,
 --2
 )

 
create table AFFECTATION
 (
 NumVol TypeNumVol foreign key (NumVol) references VOL (numVol), 
 DateVol TypeDate, 
 constraint clefdouble primary key (NumVol, DateVol ),   
 NumAvion  smallint not null references AVION( NumAvion),
 IdPilote TypeIdPilote null references PILOTE (IdPilote),
 --2
 )
 