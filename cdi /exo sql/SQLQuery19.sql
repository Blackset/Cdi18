select pays,count(nom_éditeur)
from éditeurs
group by pays 
having pays like '%S%' OR pays like '%R%'