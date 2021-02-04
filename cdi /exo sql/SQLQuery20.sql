select count(pays),pays
from auteurs
group by pays
having count(pays)>3



