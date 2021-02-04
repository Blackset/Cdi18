use airlinair

create type TypeDate 
from datetime
not null 

create type TypesHoraire
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

create type TypeldConstructeur
from smallint 
not null

create type TypesldAeroport 
from char (3)
not null

create type TypesIdPilote 
from smallint
not null

create type TypeNumVol
from char(5)
not null

create type TypeVille 
from varchar (50)
null

create table Constructeur
(
IdConstructeur   TypeldConstructeur identity (1,1) primary key,  
NomConstructeur TypeNom not null,
--0
)
create table PILOTE
(
IdPilote TypesIdPilote identity (1,1) primary key,
NomPilote TypeNom not null,
PrenomPilote TypePrenom not null,
--0
)

create table AEROPORT
(
IdAeroport TypesldAeroport check ( IdAeroport like '[A-Z][A-Z][A-Z]') primary key, 
NomAeroport  TypePrenom not null,
NomVilleDesservie TypeVille null,
--0
)

create table TYPE
(
TypeAvion TypeAvion primary key check (TypeAvion like '[A-Z]%'),
capacite smallint not null check (capacite >= 50 and capacite <= 400) default '100',
idConstructeur  TypeldConstructeur references CONSTRUCTEUR(IdConstructeur) not null,
--1
)

create table AVION
(
NumAvion smallint identity (100,1) primary key,
TypeAvion TypeAvion  not null,
BaseAeroport  TypesldAeroport not null foreign key (BaseAeroport)  references AEROPORT(IdAeroport),
--1 
)


create table VOL
(
 NumVol TypeNumVol not null primary key,
 constraint CK_NumVol check(NumVol like 'IT[0-9][0-9][0-9]'), 
 Aeroportdept TypesldAeroport not null foreign key (Aeroportdept)references AEROPORT (IdAeroport), 
 Hdépart TypesHoraire not null,
 AeroportArr TypesldAeroport not null foreign key (AeroportArr) references  AEROPORT (IdAeroport) , 
 HArrivée TypesHoraire not null,
 --2
 )

 
create table AFFECTATION
 (
 NumVol TypeNumVol  references VOL (numVol), 
 DateVol TypeDate, 
 constraint clédoubles primary key (NumVol, DateVol ),   
 NumAvion  smallint not null references AVION( NumAvion),
 IdPilote TypesIdPilote null references PILOTE (IdPilote),
 --2
 )
 