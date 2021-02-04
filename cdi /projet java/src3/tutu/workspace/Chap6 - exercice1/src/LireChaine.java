// Class LireChaine
//
//
// public static void LireChaine(char [] leTableau, int tailleTab)
	// Cette proc�dure lit une chaine termin�e par un TestLireChaine.POINT, et la stock dans le tableau de caract�res leTableau.
	// Si la phrase rentr�e par l'utilisateur n'a pas de TestLireChaine.POINT terminal, nous en ajoutons un.
	// Si la phrase tap�e par l'utilisateur est trop longue, elle est tronqu�e et nous ajoutons le TestLireChaine.POINT final
	// Entr�e leTableau : le tableau que l'on doit remplir et renvoyer.
	// Entr�e int tailleTab


// public static void afficherChaine(char [] leTableau, int tailleTab)
	// Cette proc�dure affiche une chaine termin�e par un TestLireChaine.POINT.
	// Entr�e leTableau : le tableau que l'on doit afficher.
	// Entr�e tailleTab : la taille totale allou�e du tableau.


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
		// Cette proc�dure lit une chaine termin�e par un CarStop, et la stock dans le tableau de caract�res leTableau.
		// Si la phrase rentr�e par l'utilisateur n'a pas de CarStop terminal, nous en ajoutons un.
		// Si la phrase tap�e par l'utilisateur est trop longue, elle est tronqu�e et nous ajoutons le CarStop final
		// Entr�e leTableau : le tableau que l'on doit remplir et renvoyer.
		// Entr�e tailleTab : taille max du tableau
		// entr�e CarStop : caract�re terminateur de la phrase
		
		String chaine ;			// Chaine utilis�e pour la lecture clavier via Lire.Chaine()
		int longueurChaine ;	// Longueur de la chaine saisie.
		char [] tmp ;			// Tableau temporaire pour saisir la chaine, que l'on recopie ensuite dansleTableau.
		int i ;					// Compteur de parcours.
				
		System.out.print ("Tapez votre cha�ne de caract�res, puis tapez sur entr�e : ");
		chaine = Lire.Chaine() ;		//On lit la chaine de caract�re entr�e
		longueurChaine = chaine.length();		//On r�cupp�re la longueur de la chaine. On s'en servira pour placer le caract�re terminateur s'il n'y est pas.
				
		tmp = chaine.toCharArray();		// Conversion du type string vers un tableau de caract�re : char []
		// Obliger de recopier le tableau, sinon, il pointe sur un nouveau et non sur leTableau ! Sinon, il redimensionne le tableau trop petit. Sinon, le copier.
		
		//Recopie du tableau :
		i = 0 ;
		while (i < longueurChaine && i < tailleTab)
			{
				leTableau[i] = tmp[i] ;
				i = i + 1 ;
			}
		
		// LeTableau est maintenant renseign� avec la chaine utilisateur.

		// On va chercher le caract�re terminateur TestLireChaine.CARTERMINATEUR, ou l'ajouter s'il n'y est pas.
		if (longueurChaine >= tailleTab)			// La chaine d�borde du tableau, on la tronque en pla�ant le caract�re terminateur en bout.
		{
			leTableau[tailleTab - 1] = CarStop ;		//caract�re terminateur en derni�re case du tableau
		}
		else if (leTableau[longueurChaine] != CarStop)		//Cas longueurChaine < tailleTab on teste le dernier caract�re de a chaine,
		{																				// si ce n'est pas le caract�re terminateur, on le rajoute � la case d'apr�s.
			// Au pire, le point est avant, on en aura 2 mais c'est valide.
			// On ne d�borde pas du tableau car longueurChaine < tailleTab
			leTableau[longueurChaine] = CarStop ;
		}
		
		// On devrait avoir un caract�re terminateur bien plac� maintenant.
		
		
	}
	
	
	public static void afficherChaine(char [] leTableau, int tailleTab, char carStop)
	{
		// Cette proc�dure affiche une chaine termin�e par un caract�re carStop.
		// Entr�e leTableau : le tableau que l'on doit afficher.
		// Entr�e tailleTab : la taille totale allou�e du tableau.
		// entr�e CarStop : le caract�re terminateur de la phrase

		 int i = 0 ;		//Compteur de parcours, fix� � 0 : d�but de tableau
		 
		 System.out.println ();
		 System.out.print ("Votre tableau : [");
		 
		 do
		 {															
			 System.out.print (leTableau[i] + ", ");
			 i = i + 1;
		 } while (i < tailleTab && leTableau[i - 1] != carStop) ; 	// On parcours jusqu'� ce que :
		 																				// i >= tailleTab || leTableau[i] = TestLireChaine.CARTERMINATEUR
		
		 System.out.println ("]");
		
		
	}
	
}
