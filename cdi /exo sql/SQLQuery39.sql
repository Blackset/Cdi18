use publi
select titre,adresse
from titres
join titreauteur on titreauteur.id_titre =titres.id_titre
join auteurs on titreauteur.id_auteur=auteurs.id_auteur
where titre='Vivre sans crainte'

Update auteurs
set adresse ='15 rue du sql'
from titres
join titreauteur on titreauteur.id_titre =titres.id_titre
join auteurs on titreauteur.id_auteur=auteurs.id_auteur
where titre='Vivre sans crainte'

select titre,adresse
from titres
join titreauteur on titreauteur.id_titre =titres.id_titre
join auteurs on titreauteur.id_auteur=auteurs.id_auteur
where titre='Vivre sans crainte'



