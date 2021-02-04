
public class CompterLongueurPhrase
{
	final static int TAILLETABLEAU = 100 ;		//définie la taille limite de la chaîne de caractère traitée.
	final static char MARQUEURDEFIN = '.' ;		//définie le marqueur de fin de phrase.


	public static void main(String[] args)
	{
		
		char[] chaineATraiter = new char [TAILLETABLEAU];
		int longueur ;
		
		System.out.println ("*** Ce programme permet de calculer la longueur d'une phrase. ***");
		System.out.println ("\t\t Version 1.0 ");
		System.out.println ();
		
		LireChaine.lireChaine(chaineATraiter, TAILLETABLEAU, MARQUEURDEFIN) ;
		
		longueur = compterNbCarPhrase (chaineATraiter) ;
		
		System.out.println ();
		System.out.print ("La phrase ");
		LireChaine.afficherPhrase(chaineATraiter, TAILLETABLEAU, MARQUEURDEFIN);
		System.out.println (" contient " + longueur + " caractères.") ;	
	
		System.out.println ();
		System.out.print ("\t\t **** FIN ****");
		
	}


	private static int compterNbCarPhrase(char[] chaineATraiter)
	{
		// Cette fonction retourne la longueur d'une phrase donnée et terminée par MARQUEURDEFIN.
		// entrée chaineATraiter : c'est la phrase dont on va calculer la longueur.
	
		
		int compteurDeParcours ;		// ce compteur va nous permettre de parcourir le tableau. C'est également la taille cumulée découverte.
					
		// initialisation
		compteurDeParcours = 0 ;	// positionnement du compteur au premier caractère du tableau.
						
		while (chaineATraiter[compteurDeParcours] != MARQUEURDEFIN)		 //Condition d'arrêt : on atteint MARQUEURDEFIN
			{	
				compteurDeParcours = compteurDeParcours + 1 ;
			}
						
					
		return compteurDeParcours ;
	}

}
