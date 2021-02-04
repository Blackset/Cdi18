Structurer des donn�es associ�es � des pi�ces
// Une usine fabrique des pi�ces : sph�riques, cubiques et cylindriques.
// Pour chaque pi�ce produite on veut conna�tre ses dimensions,
// sa couleur (jaune, vert, bleu, rouge, orange, mauve),
// son num�ro de s�rie et sa date de fabrication.
// DONNEZ une structure de donn�es permettant de stocker toutes les informations sur les pi�ces produites par l'usine.


N = 100  // nombre maximum de pi�ces

tableauPieces [N] pieces	

types
		
		forme = (sph�riques, cubiques, cylindriques)   //(sph�re, cube, culindre)
		couleur_piece = (jaune, vert, bleu, rouge, orange, mauve)
		date_mois = ( janvier, f�vrier, mars, avril, mai, juin, juillet, ao�t, septembre, octobre, novembre, d�cembre)
		date_jour = ( lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche ) 
		
		
		
		date = Enregistrement   // au format mercredi 4 juin 2016
			jour_semaine : date_jour
			jour : entier
			mois : date_mois
			ann�e : entier
		Finenregistrement

		dimension = Enregistrement
			cylindrique : hauteur : reel // donn�es utiles
						: diametre : reel // donn�es utiles ( ou rayon )
			sph�rique : diam�tre : r�el  // donn�es utiles ( ou rayon )
			cubique : cot� : r�el // cot� * cot� *cot�
		Finenregistrement

		
		piece = Enregistrement
			couleur : couleur_piece  // piece.couleur
			serie : chaine/entier  // A d�finir
			datefabrication : date  // piece.date
			dim : dimension
					
		Finenregistrement

