use publi
select nom_�diteur,titre,nom_mag, sum(qt)
from �diteurs
join titres on �diteurs.id_�diteur=titres.id_�diteur
join ventes on titres.id_titre=ventes.id_titre
join magasins on ventes.id_mag=magasins.id_mag
group by nom_�diteur,titre,nom_mag
