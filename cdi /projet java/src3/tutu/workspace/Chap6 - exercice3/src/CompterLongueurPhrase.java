
public class CompterLongueurPhrase
{
	final static int TAILLETABLEAU = 100 ;		//d�finie la taille limite de la cha�ne de caract�re trait�e.
	final static char MARQUEURDEFIN = '.' ;		//d�finie le marqueur de fin de phrase.


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
		System.out.println (" contient " + longueur + " caract�res.") ;	
	
		System.out.println ();
		System.out.print ("\t\t **** FIN ****");
		
	}


	private static int compterNbCarPhrase(char[] chaineATraiter)
	{
		// Cette fonction retourne la longueur d'une phrase donn�e et termin�e par MARQUEURDEFIN.
		// entr�e chaineATraiter : c'est la phrase dont on va calculer la longueur.
	
		
		int compteurDeParcours ;		// ce compteur va nous permettre de parcourir le tableau. C'est �galement la taille cumul�e d�couverte.
					
		// initialisation
		compteurDeParcours = 0 ;	// positionnement du compteur au premier caract�re du tableau.
						
		while (chaineATraiter[compteurDeParcours] != MARQUEURDEFIN)		 //Condition d'arr�t : on atteint MARQUEURDEFIN
			{	
				compteurDeParcours = compteurDeParcours + 1 ;
			}
						
					
		return compteurDeParcours ;
	}

}
