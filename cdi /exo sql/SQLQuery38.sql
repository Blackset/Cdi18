select*
from "�diteurs"

update titres
set prix = prix*1.1
where id_�diteur = '1389'

Select prix,nom_�diteur
from �diteurs,titres
order by nom_�diteur
