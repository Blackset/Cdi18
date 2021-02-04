use publi
select nom_employé,datename(month, date_embauche),pn_employé
from employé
where pn_employé like 'Janine' and nom_employé like 'Labrune' 