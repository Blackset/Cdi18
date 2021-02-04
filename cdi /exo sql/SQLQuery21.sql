use publi
select nom_éditeur, titre, prix
from éditeurs, titres
where éditeurs.id_éditeur = titres.id_éditeur and éditeurs.ville = 'paris'