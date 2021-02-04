use publi
select nom_éditeur,titre,nom_mag, sum(qt)
from éditeurs
join titres on éditeurs.id_éditeur=titres.id_éditeur
join ventes on titres.id_titre=ventes.id_titre
join magasins on ventes.id_mag=magasins.id_mag
group by nom_éditeur,titre,nom_mag
