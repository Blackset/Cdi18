use publi
select nom_employé,pn_employé,convert(char, date_embauche,105)
from employé
where pn_employé like 'Janine' and nom_employé like 'Labrune' 