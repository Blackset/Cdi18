use publi

select nom_�diteur, ville, r�gion
from �diteurs

select titre 
from titres
where prix > 100 

select nom_employ�, pn_employ�, date_embauche
from employ�
where year(date_embauche) ='1990' and  nom_employ� like 'L%'  and position_employ� between 10 and 100

select nom_employ�, date_embauche, id_�diteur
from employ�
order by id_�diteur, nom_employ�

select nom_auteur, pays, adresse
from auteurs
where pays in ('fr', 'ch', 'be')
order by pays

select year (date_embauche)  
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine'
  
select MONTH ( date_embauche)
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine' 
 
select DAY ( date_embauche)
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine'  

select CONVERT (char, date_embauche, 101)
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine'
 
select CONVERT (char, date_embauche, 105)
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine' 

select CONVERT (char, date_embauche, 104)
from employ�
where nom_employ� = 'Labrune'and pn_employ� = 'Janine'

select nom_employ�, pn_employ�, date_embauche
from employ�
where DATEDIFF (dd, '24/03/1991', date_embauche)>0 

select SUBSTRING(code_postal,1, 2)
from auteurs

select UPPER(nom_auteur)
from auteurs

select REPLACE( nom_auteur, '�' , 'e'  ) 
from auteurs

select REPLACE( pn_auteur, '�' , 'e'  ) 
from auteurs

select pays, COUNT (id_auteur) 
from auteurs
group by pays

select id_mag, SUM (qt)
from ventes
group by id_mag 

select count (nom_employ�), (position_employ�), MIN(date_embauche), MAX ( date_embauche)  
from employ�
group by position_employ�

select pays, COUNT (id_�diteur) 
from �diteurs
group by pays
HAVING pays like '%R%' or pays like '%S%'

select pays, count (id_auteur)
from auteurs
group by pays
having COUNT ( id_auteur) >3

select nom_�diteur, titre, prix
from �diteurs, titres
where �diteurs.id_�diteur = titres.id_�diteur and �diteurs.ville = 'paris'

select nom_�diteur, titre, prix
from �diteurs
join titres on titres.id_�diteur= �diteurs.id_�diteur
where �diteurs.ville = 'paris'

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

select nom_�diteur, titre, nom_mag, qt
from �diteurs
join titres on titres.id_�diteur= �diteurs.id_�diteur
join ventes on ventes.id_titre = titres.id_titre 
join magasins on magasins.id_mag = ventes.id_mag
order by nom_�diteur 
        
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

select nom_�diteur,code_postal
from �diteurs
join titres on titres.id_�diteur = �diteurs.id_�diteur
join titreauteur on titreauteur.id_titre= titres.id_titre
join auteurs on titreauteur.id_auteur = auteurs.id_auteur 
where �diteurs. pays= auteurs.pays

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


select distinct nom_�diteur, �diteurs.id_�diteur 
from �diteurs, titres
where titres.id_�diteur = �diteurs.id_�diteur and  'gestion'= any (select type from titres where �diteurs.id_�diteur = titres.id_�diteur )
and 'informatique' not in (select type from titres where �diteurs.id_�diteur = titres.id_�diteur) 


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
from �diteurs
where titres.id_�diteur = �diteurs.id_�diteur and nom_�diteur = 'Algodata Infosystems'

select *
from �diteurs,titres
where titres.id_�diteur = �diteurs.id_�diteur and nom_�diteur = 'Algodata Infosystems'

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











