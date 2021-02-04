use publi
select nom_employé,datepart(year, date_embauche),pn_employé
from employé
where pn_employé like 'Janine' and nom_employé like 'Labrune' 