use publi

select nom_éditeur, ville, région
from éditeurs

select titre 
from titres
where prix > 100 

select nom_employé, pn_employé, date_embauche
from employé
where year(date_embauche) ='1990' and  nom_employé like 'L%'  and position_employé between 10 and 100

select nom_employé, date_embauche, id_éditeur
from employé
order by id_éditeur, nom_employé

select nom_auteur, pays, adresse
from auteurs
where pays in ('fr', 'ch', 'be')
order by pays

select year (date_embauche)  
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine'
  
select MONTH ( date_embauche)
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine' 
 
select DAY ( date_embauche)
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine'  

select CONVERT (char, date_embauche, 101)
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine'
 
select CONVERT (char, date_embauche, 105)
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine' 

select CONVERT (char, date_embauche, 104)
from employé
where nom_employé = 'Labrune'and pn_employé = 'Janine'

select nom_employé, pn_employé, date_embauche
from employé
where DATEDIFF (dd, '24/03/1991', date_embauche)>0 

select SUBSTRING(code_postal,1, 2)
from auteurs

select UPPER(nom_auteur)
from auteurs

select REPLACE( nom_auteur, 'é' , 'e'  ) 
from auteurs

select REPLACE( pn_auteur, 'é' , 'e'  ) 
from auteurs

select pays, COUNT (id_auteur) 
from auteurs
group by pays

select id_mag, SUM (qt)
from ventes
group by id_mag 

select count (nom_employé), (position_employé), MIN(date_embauche), MAX ( date_embauche)  
from employé
group by position_employé

select pays, COUNT (id_éditeur) 
from éditeurs
group by pays
HAVING pays like '%R%' or pays like '%S%'

select pays, count (id_auteur)
from auteurs
group by pays
having COUNT ( id_auteur) >3

select nom_éditeur, titre, prix
from éditeurs, titres
where éditeurs.id_éditeur = titres.id_éditeur and éditeurs.ville = 'paris'

select nom_éditeur, titre, prix
from éditeurs
join titres on titres.id_éditeur= éditeurs.id_éditeur
where éditeurs.ville = 'paris'

select nom_auteur, titre, prix
from auteurs
join titreauteur on auteurs.id_auteur = titreauteur.id_auteur
join titres on titres.id_titre = titreauteur.id_titre
where auteurs.ville = 'paris'


select  count (distinct titres.id_titre)
from auteurs
join titreauteur on auteurs.id_auteur = titreauteur.id_auteur
join titres on titres.id_titre = titreauteur.id_titre
where auteurs.contrat = '1'

select nom_éditeur, titre, nom_mag, qt
from éditeurs
join titres on titres.id_éditeur= éditeurs.id_éditeur
join ventes on ventes.id_titre = titres.id_titre 
join magasins on magasins.id_mag = ventes.id_mag
order by nom_éditeur 
        
select nom_auteur,  SUM(qt)  
from auteurs 
join titreauteur on  titreauteur.id_auteur = auteurs.id_auteur
join titres on  titres.id_titre = titreauteur.id_titre 
join ventes on   ventes.id_titre = titres.id_titre 
group by nom_auteur,  auteurs.id_auteur
having SUM(qt) > 20  

select nom_auteur, titre
from auteurs
join titreauteur on  titreauteur.id_auteur = auteurs.id_auteur
join titres on  titres.id_titre = titreauteur.id_titre 
join ventes on   ventes.id_titre = titres.id_titre 
join magasins on magasins.id_mag = ventes.id_mag
where magasins.ville = auteurs.ville

select nom_éditeur,code_postal
from éditeurs
join titres on titres.id_éditeur = éditeurs.id_éditeur
join titreauteur on titreauteur.id_titre= titres.id_titre
join auteurs on titreauteur.id_auteur = auteurs.id_auteur 
where éditeurs. pays= auteurs.pays

select titre 
from titres
join titreauteur on  titres.id_titre = titreauteur.id_titre
join auteurs on auteurs.id_auteur = titreauteur.id_auteur
where auteurs.ville in  ( select ville from magasins
join ventes on ventes.id_mag = magasins.id_mag
where ventes.id_titre = titres.id_titre)

select distinct nom_auteur, pn_auteur, droits_pourcent 
from auteurs 
join titreauteur on  titreauteur.id_auteur = auteurs.id_auteur
where exists( select id_auteur from titreauteur)
and 100 = all( select droits_pourcent from titreauteur where titreauteur.id_auteur = auteurs.id_auteur  )
order by nom_auteur

select titre, prix
from titres 
where prix = (select MAX (prix) from titres)


select titre , (select SUM(qt) from ventes where  ventes.id_titre = titres.id_titre   )
from titres
where exists (select qt from ventes where  ventes.id_titre = titres.id_titre   )
order by titre


select distinct titre, nom_mag, max (qt)
from titres 
join ventes on ventes.id_titre = titres.id_titre
join magasins on magasins.id_mag = ventes.id_mag
where qt = ( select MAX (qt) from ventes where magasins.id_mag = ventes.id_mag  )
group by nom_mag, titre


select distinct nom_éditeur, éditeurs.id_éditeur 
from éditeurs, titres
where titres.id_éditeur = éditeurs.id_éditeur and  'gestion'= any (select type from titres where éditeurs.id_éditeur = titres.id_éditeur )
and 'informatique' not in (select type from titres where éditeurs.id_éditeur = titres.id_éditeur) 


select nom_auteur, pn_auteur, code_postal
from auteurs
where code_postal like '75%'

--EXO35
insert into auteurs (id_auteur, nom_auteur, pn_auteur, ville, contrat)
values ('502-45-4511', 'ALLAOUA','Halim', 'Lyon', '100')

--EXO36

insert into titres ( id_titre, titre, type, datepub)
values ( 'pk1254', 'sql2','informatique', '10/02/1999') 

select id_titre, titre, type from titres
select id_auteur from auteurs

select id_auteur, nom_auteur, pn_auteur, ville, adresse, contrat
from auteurs

-- EXO 37

insert into auteurs ( id_auteur, nom_auteur, pn_auteur, ville, contrat)
select  '233-89-4517', 'LOLO', pn_auteur, ville, contrat 
from auteurs
where nom_auteur = 'Robin'

--EXO 38

update titres
set prix  = (prix * 1.1 )
from éditeurs
where titres.id_éditeur = éditeurs.id_éditeur and nom_éditeur = 'Algodata Infosystems'

select *
from éditeurs,titres
where titres.id_éditeur = éditeurs.id_éditeur and nom_éditeur = 'Algodata Infosystems'

--EXO 39
update auteurs
set adresse = ('rue bouvier 69100')
from auteurs, titres, titreauteur
where  titreauteur.id_auteur = auteurs.id_auteur and  titreauteur.id_auteur = auteurs.id_auteur
and titre = 'vivre sans crainte'
  
select *
from auteurs, titres, titreauteur
where  titreauteur.id_auteur = auteurs.id_auteur and  titreauteur.id_auteur = auteurs.id_auteur
and titre = 'vivre sans crainte'
  

 --EXO 40
 
DELETE from auteurs 
where id_auteur = '502-45-4511'

delete from auteurs
where nom_auteur = 'Robin'

--EXO 41











