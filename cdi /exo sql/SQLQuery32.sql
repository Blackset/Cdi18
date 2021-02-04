use publi
select titre,(select sum(qt) from ventes where ventes.id_titre=titres.id_titre)
from titres
where exists (select qt from ventes where ventes.id_titre=titres.id_titre)
order by titre