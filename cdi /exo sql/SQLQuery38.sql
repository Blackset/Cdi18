select*
from "éditeurs"

update titres
set prix = prix*1.1
where id_éditeur = '1389'

Select prix,nom_éditeur
from éditeurs,titres
order by nom_éditeur
