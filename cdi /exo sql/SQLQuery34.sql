use publi

select distinct nom_�diteur,type
from �diteurs edt
JOIN titres ON edt.id_�diteur = titres.id_�diteur
where type like 'gestion'

-- il n'existe pas de livre de type 'informatique' pour cet �diteur
select distinct nom_�diteur, type
from titres
join �diteurs ON �diteurs.id_�diteur = titres.id_�diteur
WHERE type='informatique'

select distinct nom_�diteur,type
from �diteurs edt
JOIN titres ON edt.id_�diteur = titres.id_�diteur
where type like 'gestion' and not exists (	select distinct id_titre, type, nom_�diteur
											from titres
											WHERE type='informatique' and titres.id_�diteur = edt.id_�diteur)
