use publi
select titre,nom_mag,qt
from titres
join ventes on ventes.id_titre=titres.id_titre
join magasins on magasins.id_mag=ventes.id_mag
where (qt = (select max(qt) from ventes where magasins.id_mag = ventes.id_mag))
