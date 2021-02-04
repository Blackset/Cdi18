select titre 
from titres
join titreauteur on  titres.id_titre = titreauteur.id_titre
join auteurs on auteurs.id_auteur = titreauteur.id_auteur
where auteurs.ville in  ( select ville from magasins
join ventes on ventes.id_mag = magasins.id_mag
where ventes.id_titre = titres.id_titre)