use publi

select distinct nom_éditeur,type
from éditeurs edt
JOIN titres ON edt.id_éditeur = titres.id_éditeur
where type like 'gestion'

-- il n'existe pas de livre de type 'informatique' pour cet éditeur
select distinct nom_éditeur, type
from titres
join éditeurs ON éditeurs.id_éditeur = titres.id_éditeur
WHERE type='informatique'

select distinct nom_éditeur,type
from éditeurs edt
JOIN titres ON edt.id_éditeur = titres.id_éditeur
where type like 'gestion' and not exists (	select distinct id_titre, type, nom_éditeur
											from titres
											WHERE type='informatique' and titres.id_éditeur = edt.id_éditeur)
