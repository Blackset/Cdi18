use publi
select nom_�diteur, titre, prix
from �diteurs, titres
where �diteurs.id_�diteur = titres.id_�diteur and �diteurs.ville = 'paris'