use publi
select nom_employ�,pn_employ�,date_embauche,position_employ�
from employ�
where nom_employ� like 'L%' AND position_employ� between 10 AND 100 AND year(date_embauche) = 1990 