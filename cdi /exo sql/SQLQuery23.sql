select  count (distinct titres.id_titre)
from auteurs
join titreauteur on auteurs.id_auteur = titreauteur.id_auteur
join titres on titres.id_titre = titreauteur.id_titre
where auteurs.contrat = '1'