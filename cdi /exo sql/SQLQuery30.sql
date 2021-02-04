use publi
select nom_auteur,pn_auteur
from auteurs
where exists(select droits_pourcent from titreauteur where titreauteur.id_auteur= auteurs.id_auteur ) and 100 = all (select droits_pourcent from titreauteur where titreauteur.id_auteur= auteurs.id_auteur)