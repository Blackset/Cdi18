
public class CompterDuo
{

	final static int TAILLETABLEAU = 100 ;		//d�finie la taille limite de la cha�ne de caract�re trait�e.
		
	
	public static void main(String[] args)
	{
		char [] chaineATraiter = new char [TAILLETABLEAU] ;			// contient la chaine � tester lue telle que fournie par l'utilisateur, d'une taille max TAILLETABLEAU.
		char premiereLettre ;		// Premi�re lettre du duo recherch�, donn�e par l'utilisateur
		char deuxiemeLettre ;		// Deuxi�me lettre du duo recherch�, donn�e par l'utilisateur
		char marqueurFin ;			// Marqueur de fin de phrase choisi par l'utillisateur.
		
		System.out.println ("*** Ce programme permet de calculer le nombre d'occurence d'un duo de caract�res cons�cutifs dans une phrase. ***");
		System.out.println ("\t\t Version 1.0 ");
		System.out.println ();
		
		System.out.print ("Bonjour, donner un caract�re de fin de phrase : ") ;
		marqueurFin = Lire.c();
		
		System.out.println ();
		LireChaine.lireChaine(chaineATraiter, TAILLETABLEAU, marqueurFin);
		
		System.out.print("Donner votre premi�re lettre � chercher : ") ;
		premiereLettre = Lire.c() ;
		System.out.println ();
		System.out.print("Donner votre deuxi�me lettre � chercher : ") ;
		deuxiemeLettre = Lire.c() ;
		System.out.println ();
		
		
			
		System.out.print ("La phrase ") ;
		LireChaine.afficherPhrase(chaineATraiter, TAILLETABLEAU, marqueurFin) ;
		System.out.print (" contient " + decompteDuoLettre (chaineATraiter, marqueurFin, premiereLettre, deuxiemeLettre) + " duos de lettres.") ;

	}

	

	private static int decompteDuoLettre(char[] phrase, char caract�reFin, char premierCar, char deuxi�meCar)
	{
		// Cette fonction prend une phrase en entr�e ainsi que deux caract�res et un caract�re marqueur de fin de cha�ne, et elle renvoie le nombre d'occurence des deux caract�re successifs dans la phrase.
		// La phrase est termin�e par le marqueur de fin. Pour le cas les deux lettres recherch�es sont les m�mes, on compte toutes les combinaisons possible de duo pour 1.
		// Entr�e Phrase : c'est la phrase que nous testons.
		// Entr�e Caract�reFin : marqueur de fin de phrase.
		// Entr�e PremierCar : premier caract�re du duo recherch�.
		// Entr�e Deuxi�meCar : deuxi�me caract�re du duo recherch�.
		
		int compteurDeParcours ;	// ce compteur va nous permettre de parcourir le tableau.
		int compteurDuo ;		// le nombre de duo trouv�s.
		
		// initialisation
		compteurDeParcours = 0 ;		// positionnement du compteur au premier caract�re du tableau.
		compteurDuo = 0	 ;		// initialisation � 0 du nombre de duos
				
		while (phrase[compteurDeParcours] != caract�reFin && phrase[compteurDeParcours + 1] != caract�reFin)		//Condition d'arr�t : soit on atteint Caract�reFin, soit la phrase est vide
			{	
				if (phrase[compteurDeParcours] == premierCar && phrase[compteurDeParcours + 1] == deuxi�meCar)
					 {
						compteurDuo = compteurDuo + 1 ;		// Nous avons trouver un duo
					 } 
									
				compteurDeParcours = compteurDeParcours + 1 ;		//On avance dans le tableau
			}
		
		return compteurDuo;
	}

}
