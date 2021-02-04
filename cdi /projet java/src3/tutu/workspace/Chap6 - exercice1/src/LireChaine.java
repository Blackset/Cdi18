// Class LireChaine
//
//
// public static void LireChaine(char [] leTableau, int tailleTab)
	// Cette procédure lit une chaine terminée par un TestLireChaine.POINT, et la stock dans le tableau de caractères leTableau.
	// Si la phrase rentrée par l'utilisateur n'a pas de TestLireChaine.POINT terminal, nous en ajoutons un.
	// Si la phrase tapée par l'utilisateur est trop longue, elle est tronquée et nous ajoutons le TestLireChaine.POINT final
	// Entrée leTableau : le tableau que l'on doit remplir et renvoyer.
	// Entrée int tailleTab


// public static void afficherChaine(char [] leTableau, int tailleTab)
	// Cette procédure affiche une chaine terminée par un TestLireChaine.POINT.
	// Entrée leTableau : le tableau que l'on doit afficher.
	// Entrée tailleTab : la taille totale allouée du tableau.


// Jeu de test :
// Chaine							Tableau
// ""								[., ? * tailleTab - 1]								!!!
// "."								[., ? * tailleTab - 1]
// "zoulou."						[z, o, u, l, o, u, ., ? * tailleTab - 7]
// "zoulou"							[z, o, u, l, o, u, ., ? * tailleTab - 7]			!!!
// "z.z"							[z, ., ? * tailleTab - 2]





public class LireChaine
{
	public static void lireChaine(char [] leTableau, int tailleTab, char CarStop)
	{
		// Cette procédure lit une chaine terminée par un CarStop, et la stock dans le tableau de caractères leTableau.
		// Si la phrase rentrée par l'utilisateur n'a pas de CarStop terminal, nous en ajoutons un.
		// Si la phrase tapée par l'utilisateur est trop longue, elle est tronquée et nous ajoutons le CarStop final
		// Entrée leTableau : le tableau que l'on doit remplir et renvoyer.
		// Entrée tailleTab : taille max du tableau
		// entrée CarStop : caractère terminateur de la phrase
		
		String chaine ;			// Chaine utilisée pour la lecture clavier via Lire.Chaine()
		int longueurChaine ;	// Longueur de la chaine saisie.
		char [] tmp ;			// Tableau temporaire pour saisir la chaine, que l'on recopie ensuite dansleTableau.
		int i ;					// Compteur de parcours.
				
		System.out.print ("Tapez votre chaîne de caractères, puis tapez sur entrée : ");
		chaine = Lire.Chaine() ;		//On lit la chaine de caractère entrée
		longueurChaine = chaine.length();		//On récuppère la longueur de la chaine. On s'en servira pour placer le caractère terminateur s'il n'y est pas.
				
		tmp = chaine.toCharArray();		// Conversion du type string vers un tableau de caractère : char []
		// Obliger de recopier le tableau, sinon, il pointe sur un nouveau et non sur leTableau ! Sinon, il redimensionne le tableau trop petit. Sinon, le copier.
		
		//Recopie du tableau :
		i = 0 ;
		while (i < longueurChaine && i < tailleTab)
			{
				leTableau[i] = tmp[i] ;
				i = i + 1 ;
			}
		
		// LeTableau est maintenant renseigné avec la chaine utilisateur.

		// On va chercher le caractère terminateur TestLireChaine.CARTERMINATEUR, ou l'ajouter s'il n'y est pas.
		if (longueurChaine >= tailleTab)			// La chaine déborde du tableau, on la tronque en plaçant le caractère terminateur en bout.
		{
			leTableau[tailleTab - 1] = CarStop ;		//caractère terminateur en dernière case du tableau
		}
		else if (leTableau[longueurChaine] != CarStop)		//Cas longueurChaine < tailleTab on teste le dernier caractère de a chaine,
		{																				// si ce n'est pas le caractère terminateur, on le rajoute à la case d'après.
			// Au pire, le point est avant, on en aura 2 mais c'est valide.
			// On ne déborde pas du tableau car longueurChaine < tailleTab
			leTableau[longueurChaine] = CarStop ;
		}
		
		// On devrait avoir un caractère terminateur bien placé maintenant.
		
		
	}
	
	
	public static void afficherChaine(char [] leTableau, int tailleTab, char carStop)
	{
		// Cette procédure affiche une chaine terminée par un caractère carStop.
		// Entrée leTableau : le tableau que l'on doit afficher.
		// Entrée tailleTab : la taille totale allouée du tableau.
		// entrée CarStop : le caractère terminateur de la phrase

		 int i = 0 ;		//Compteur de parcours, fixé à 0 : début de tableau
		 
		 System.out.println ();
		 System.out.print ("Votre tableau : [");
		 
		 do
		 {															
			 System.out.print (leTableau[i] + ", ");
			 i = i + 1;
		 } while (i < tailleTab && leTableau[i - 1] != carStop) ; 	// On parcours jusqu'à ce que :
		 																				// i >= tailleTab || leTableau[i] = TestLireChaine.CARTERMINATEUR
		
		 System.out.println ("]");
		
		
	}
	
}
