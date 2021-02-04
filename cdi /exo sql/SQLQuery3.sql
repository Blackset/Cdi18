use publi
select nom_employé,pn_employé,date_embauche,position_employé
from employé
where nom_employé like 'L%' AND position_employé between 10 AND 100 AND year(date_embauche) = 1990 