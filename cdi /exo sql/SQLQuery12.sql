select nom_employ�, pn_employ�,date_embauche
from employ�
where datediff(dd,date_embauche, cast ('24/03/1991' as datetime)) < 0

