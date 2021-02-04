use publi
select nom_auteur,pays,adresse
from auteurs
where pays in ('FR','CH','BE') order by pays