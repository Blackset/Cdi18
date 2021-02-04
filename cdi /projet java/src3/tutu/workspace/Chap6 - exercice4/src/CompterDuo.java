
public class CompterDuo
{

	final static int TAILLETABLEAU = 100 ;		//définie la taille limite de la chaîne de caractère traitée.
		
	
	public static void main(String[] args)
	{
		char [] chaineATraiter = new char [TAILLETABLEAU] ;			// contient la chaine à tester lue telle que fournie par l'utilisateur, d'une taille max TAILLETABLEAU.
		char premiereLettre ;		// Première lettre du duo recherché, donnée par l'utilisateur
		char deuxiemeLettre ;		// Deuxième lettre du duo recherché, donnée par l'utilisateur
		char marqueurFin ;			// Marqueur de fin de phrase choisi par l'utillisateur.
		
		System.out.println ("*** Ce programme permet de calculer le nombre d'occurence d'un duo de caractères consécutifs dans une phrase. ***");
		System.out.println ("\t\t Version 1.0 ");
		System.out.println ();
		
		System.out.print ("Bonjour, donner un caractère de fin de phrase : ") ;
		marqueurFin = Lire.c();
		
		System.out.println ();
		LireChaine.lireChaine(chaineATraiter, TAILLETABLEAU, marqueurFin);
		
		System.out.print("Donner votre première lettre à chercher : ") ;
		premiereLettre = Lire.c() ;
		System.out.println ();
		System.out.print("Donner votre deuxième lettre à chercher : ") ;
		deuxiemeLettre = Lire.c() ;
		System.out.println ();
		
		
			
		System.out.print ("La phrase ") ;
		LireChaine.afficherPhrase(chaineATraiter, TAILLETABLEAU, marqueurFin) ;
		System.out.print (" contient " + decompteDuoLettre (chaineATraiter, marqueurFin, premiereLettre, deuxiemeLettre) + " duos de lettres.") ;

	}

	

	private static int decompteDuoLettre(char[] phrase, char caractèreFin, char premierCar, char deuxièmeCar)
	{
		// Cette fonction prend une phrase en entrée ainsi que deux caractères et un caractère marqueur de fin de chaîne, et elle renvoie le nombre d'occurence des deux caractère successifs dans la phrase.
		// La phrase est terminée par le marqueur de fin. Pour le cas les deux lettres recherchées sont les mêmes, on compte toutes les combinaisons possible de duo pour 1.
		// Entrée Phrase : c'est la phrase que nous testons.
		// Entrée CaractèreFin : marqueur de fin de phrase.
		// Entrée PremierCar : premier caractère du duo recherché.
		// Entrée DeuxièmeCar : deuxième caractère du duo recherché.
		
		int compteurDeParcours ;	// ce compteur va nous permettre de parcourir le tableau.
		int compteurDuo ;		// le nombre de duo trouvés.
		
		// initialisation
		compteurDeParcours = 0 ;		// positionnement du compteur au premier caractère du tableau.
		compteurDuo = 0	 ;		// initialisation à 0 du nombre de duos
				
		while (phrase[compteurDeParcours] != caractèreFin && phrase[compteurDeParcours + 1] != caractèreFin)		//Condition d'arrêt : soit on atteint CaractèreFin, soit la phrase est vide
			{	
				if (phrase[compteurDeParcours] == premierCar && phrase[compteurDeParcours + 1] == deuxièmeCar)
					 {
						compteurDuo = compteurDuo + 1 ;		// Nous avons trouver un duo
					 } 
									
				compteurDeParcours = compteurDeParcours + 1 ;		//On avance dans le tableau
			}
		
		return compteurDuo;
	}

}
