use publi
select nom_employé,convert(char, date_embauche,103),pn_employé
from employé
where pn_employé like 'Janine' and nom_employé like 'Labrune' 