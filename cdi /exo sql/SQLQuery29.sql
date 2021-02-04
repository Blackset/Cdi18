use publi
select nom_éditeur,nom_auteur
from auteurs
join titreauteur on auteurs.id_auteur=titreauteur .id_auteur
join titres on titreauteur.id_titre=titres.id_titre
join éditeurs on titres.id_éditeur=éditeurs.id_éditeur
where éditeurs.pays=auteurs.pays