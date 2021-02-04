use airlinair
go

insert into PILOTE ( NomPilote, PrenomPilote)
 values ('GAINSBOURG','Serge'),('FERRAT','Jean'), 
        ('NOUGARO','Claude' ), ('SCHUMMAN',' Robert'),
        ('STROGOFF','Michel'), ('SORREL','Lucien'),
        ('TAVARNIER',' Bertrand'), ('FAYOLLE','Marc'),
        ('LECU', 'Régie');


insert into AEROPORT ( IdAeroport ,NomAeroport ,NomVilleDesservie)
values ('BAS', 'Poretta', 'Bastia'), ('BLA','Blagnac','toulouse'),
        ('BRI', 'Brive', 'Brive'), ( 'CDG','Roissy', 'Paris'),
        ('GRE', 'Saint Geoir','Grenoble'), ('LYS','Saint exupéry','Lyon'),
        ('NAN', 'SaintHerblain','Nantes'), ('NIC','Nice cote dazur' ,'Nice'),
        ('ORL', 'Orly', 'Paris');

 
 insert into Constructeur (   NomConstructeur) 
 values (' Aérospatiale'),('Boeing'), ('Cessna'), ('Douglas');
     
insert TYPE
 values 
 ('A320','300','1'),
 ('A340','350','1'),
 ('ATR42','50','1'),
 ('B707','250','2'),
 ('B727','300','2'), 
 ('B747','400','2'),
 ('DC10','200','4');

 
 insert into  AVION ( Type_Avion,BaseAeroport)
 values ('A320','NIC'),('B707','CDG'),('A320','BLA'),('DC10','BLA'),('B747','ORL'),
        ('A320','GRE'),('ATR42','CDG'),('B727','LYS'),('B727','NAN'),('A340','BAS');
  select*
 FROM AVION	
 
 
 
 
 insert into  VOL ( NumVol, Aeroportdept, Hdépart, AeroportArr, HArrivée )
 values 
 ('IT100','NIC','7:00','CDG','9:00'),
 ('IT101','ORL','11:00','BLA','12:00'),
 ('IT102','CDG','12:00','NIC','14:00'),
 ('IT103','GRE','9:00','BLA','11:00'),
 ('IT104','BLA','17:00','GRE','19:00'),
 ('IT105','LYS','06:00','ORL','7:00'),
 ('IT106','BAS','10:00','ORL','13:00'),
 ('IT107','NIC','7:00','BRI','8:00'),
 ('IT108','BRI','19:00','ORL','20:00'),
 ('IT109','NIC','18:00','ORL','19:00'),
 ('IT110','ORL','15:00','ORL','16:00'),
 ('IT111','NIC','17:00','NIC','19:00');
 select*
 FROM VOL
 
 insert AFFECTATION
 values 
 ('IT100','6 avril 2001','100',1),
 ('IT100','7 avril 2001','101',2),
 ('IT101','6 avril 2001','100',2),
 ('IT101','7 avril 2001','103',4),
 ('IT102','6 avril 2001','101',1),
 ('IT102','7 avril 2001','102',3),
 ('IT103','6 avril 2001','105',3),
 ('IT103','7 avril 2001','104',2),
 ('IT104','6 avril 2001','105',3),
 ('IT104','7 avril 2001','107',8),
 ('IT105','6 avril 2001','107',7),
 ('IT105','7 avril 2001','106',7),
 ('IT106','6 avril 2001','109',8),
 ('IT106','7 avril 2001','104',5),
 ('IT107','6 avril 2001','106',9),
 ('IT107','7 avril 2001','103',8),
 ('IT108','6 avril 2001','106',9),
 ('IT108','7 avril 2001','106',5),
 ('IT109','6 avril 2001','107',7),
 ('IT109','7 avril 2001','105',1),
 ('IT110','6 avril 2001','102',2),
 ('IT110','7 avril 2001','104',3),
 ('IT111','6 avril 2001','101',4),
 ('IT111','7 avril 2001','100',8);
 

 
 CREATE VIEW DEPART
 AS
 select VOL.NumVol as 'NumVol ', VOL.AeroportDept as 'DE' , VOL.aeroportArr as 'A', DATENAME(hh, Hdépart)+'H00' as 'heure de Départ',
        DATENAME(hh, Harrivée)+'H00' as 'heure arrivée' 
 from VOL, AEROPORT, AFFECTATION
 where  AFFECTATION.NumVol= VOL.NumVol and VOL.AeroportDept = AEROPORT.IdAeroport and DateVol = '06 avril 2001' and  NomVilleDesservie ='Paris'
 
 select*
 FROM DEPART
 */
 exec sp_adduser 'Crastes', ResponsableAFPA
 exec sp_adduser 'Bouyadel', ResponsableBDD 
 exec sp_adduser 'Addaboudjellal', Usager
 
 GRANT select on DEPART to Usager
 
 grant select on VOL to ResponsableAFPA
 grant select on Avion to ResponsableAFPA  
 grant select on Aeroport to ResponsableAFPA  
 grant select on Type to ResponsableAFPA
 
 grant select on AFFECTATION to ResponsableBDD
 grant update on AFFECTATION to ResponsableBDD 
 grant delete on  AFFECTATION to ResponsableBDD  
 grant insert on  AFFECTATION to ResponsableBDD
   
 grant select on VOL to ResponsableBDD 
 grant select on Avion to ResponsableBDD  
 grant select on Pilote to ResponsableBDD
 grant select on Type to ResponsableBDD

GRANT create view to Usager

    
    