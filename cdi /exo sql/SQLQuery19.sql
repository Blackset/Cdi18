select pays,count(nom_�diteur)
from �diteurs
group by pays 
having pays like '%S%' OR pays like '%R%'