use publi
select nom_employ�,convert(char, date_embauche,103),pn_employ�
from employ�
where pn_employ� like 'Janine' and nom_employ� like 'Labrune' 