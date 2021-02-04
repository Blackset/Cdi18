use publi
select nom_auteur,titre,sum(qt)
from auteurs
join titreauteur on auteurs.id_auteur=titreauteur .id_auteur
join titres on titreauteur.id_titre=titres.id_titre
join ventes on titres.id_titre=ventes.id_titre
group by nom_auteur,titre
having sum(qt)<20

