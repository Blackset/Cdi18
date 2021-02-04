use publi
select nom_auteur,titre,prix
from auteurs
join titreauteur on auteurs.id_auteur=titreauteur .id_auteur
join titres on titreauteur.id_titre=titres.id_titre
where auteurs.ville='paris'