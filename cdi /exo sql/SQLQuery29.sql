use publi
select nom_�diteur,nom_auteur
from auteurs
join titreauteur on auteurs.id_auteur=titreauteur .id_auteur
join titres on titreauteur.id_titre=titres.id_titre
join �diteurs on titres.id_�diteur=�diteurs.id_�diteur
where �diteurs.pays=auteurs.pays