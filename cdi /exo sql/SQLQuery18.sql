select count(position_employ�),position_employ�,max(date_embauche),min(date_embauche)
from employ�
group by position_employ�
