
public class TestCompterOccurenceLettre
{
	final static int TAILLETABLEAU = 100 ;		//d�finie la taille limite de la cha�ne de caract�re trait�e.
	final static char MARQUEURDEFIN = '.' ;		//d�finie le marqueur de fin de phrase.


	public static void main(String[] args)
	{
		
		char [] chaineATraiter = new char [TAILLETABLEAU] ;		// contient la chaine � tester lue telle que fournie par l'utilisateur, d'une taille max TAILLETABLEAU.
		char caractereRecherche ;	// le caract�re fourni par l'utilisateur et dont on va rechercher les occurences.
		int nbOccurance ;	// compte le nombre d'occurences d�couvertes.	
		
		
	
		// initialisation
		nbOccurance = 0 ;


		System.out.println ("*** Ce programme permet de compter le nombre d'occurence d'une lettre dans une phrase. ***");
		System.out.print ("\t\t Version 1.0 ");
		System.out.println();
		System.out.println();
		
		
		LireChaine.lireChaine(chaineATraiter, TAILLETABLEAU, MARQUEURDEFIN);
		System.out.print ("merci, veuillez tapez le caract�re recherch� : ");
		caractereRecherche = Lire.c() ;
		
		nbOccurance = compterCaractere(chaineATraiter, caractereRecherche) ;
		
		System.out.println();
		System.out.println();
		System.out.print("Il y a " + nbOccurance + " occurence de la lettre " + caractereRecherche + " dans la phrase : ");
		LireChaine.afficherPhrase(chaineATraiter, TAILLETABLEAU, MARQUEURDEFIN);
		
		System.out.println();
		System.out.println();
		System.out.print("\t\t **** FIN ****");

	}

	
	private static int compterCaractere(char[] chaineATraiter, char caractereRecherche)
	{
		// Cette fonction retrourne le nombre d'occurence d'un caract�re donn� dans une chaine termn�e par MARQUEURDEFIN.
		// entr�e chaineATraiter : la phrase � tester.
		// entr�e caractereRecherche : carcat�re dont on veut compter les occurences dans la phrase
		
		
		
		int compteurDeParcours = 0 ;		// ce compteur va nous permettre de parcourir le tableau.
		int compteurNbOccurance = 0 ;		// compteur du nombre d'occurence du caract�re rencontr�, initialement � 0
		
		while (chaineATraiter[compteurDeParcours] != MARQUEURDEFIN)	//Condition d'arr�t : soit on atteint MARQUEURDEFIN, soit on atteint la fin de tableau (TAILLETABLEAU)
		 	{
				if (chaineATraiter[compteurDeParcours] == caractereRecherche)		//Nous avons trouv� une occurence � la position CompteurDeParcours
					{
						compteurNbOccurance = compteurNbOccurance + 1 ;
					}
				
				compteurDeParcours = compteurDeParcours + 1 ;
			}
		 
		return compteurNbOccurance ;
	}

}
