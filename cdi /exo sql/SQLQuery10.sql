use publi
select nom_employ�,pn_employ�,convert(char, date_embauche,105)
from employ�
where pn_employ� like 'Janine' and nom_employ� like 'Labrune' 