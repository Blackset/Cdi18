select nom_employé, pn_employé,date_embauche
from employé
where datediff(dd,date_embauche, cast ('24/03/1991' as datetime)) < 0

