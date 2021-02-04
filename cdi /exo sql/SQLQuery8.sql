use publi
select DAY (date_embauche),pn_employé,nom_employé
from employé
where pn_employé like 'Janine' and nom_employé like 'Labrune' 