select count(position_employé),position_employé,max(date_embauche),min(date_embauche)
from employé
group by position_employé
