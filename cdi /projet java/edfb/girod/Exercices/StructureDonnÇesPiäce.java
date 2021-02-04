Structurer des données associées à des pièces
// Une usine fabrique des pièces : sphériques, cubiques et cylindriques.
// Pour chaque pièce produite on veut connaître ses dimensions,
// sa couleur (jaune, vert, bleu, rouge, orange, mauve),
// son numéro de série et sa date de fabrication.
// DONNEZ une structure de données permettant de stocker toutes les informations sur les pièces produites par l'usine.


N = 100  // nombre maximum de pièces

tableauPieces [N] pieces	

types
		
		forme = (sphériques, cubiques, cylindriques)   //(sphère, cube, culindre)
		couleur_piece = (jaune, vert, bleu, rouge, orange, mauve)
		date_mois = ( janvier, février, mars, avril, mai, juin, juillet, août, septembre, octobre, novembre, décembre)
		date_jour = ( lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche ) 
		
		
		
		date = Enregistrement   // au format mercredi 4 juin 2016
			jour_semaine : date_jour
			jour : entier
			mois : date_mois
			année : entier
		Finenregistrement

		dimension = Enregistrement
			cylindrique : hauteur : reel // données utiles
						: diametre : reel // données utiles ( ou rayon )
			sphérique : diamètre : réel  // données utiles ( ou rayon )
			cubique : coté : réel // coté * coté *coté
		Finenregistrement

		
		piece = Enregistrement
			couleur : couleur_piece  // piece.couleur
			serie : chaine/entier  // A définir
			datefabrication : date  // piece.date
			dim : dimension
					
		Finenregistrement

