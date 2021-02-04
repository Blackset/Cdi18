use publi
select titre,nom_auteur,qt
from auteurs
join titreauteur on auteurs.id_auteur=titreauteur.id_auteur
join titres on titreauteur.id_titre=titres.id_titre
join ventes on titres.id_titre=ventes.id_titre
join magasins on ventes.id_mag=magasins.id_mag

where auteurs.ville=magasins.ville
