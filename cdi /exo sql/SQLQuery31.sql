use publi
select titre, prix
from titres 
where prix = (select MAX (prix) from titres)