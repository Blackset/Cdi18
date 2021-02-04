/*********************************************************************
  Programme			:  Erreurs.java
  Auteur            :  L�cu Regis 
  Mise a jour		:  f�vrier 2001,maj nov 2003 jcc

  Fonction          : D�monstration sur les erreurs les plus r�pandues sur
  les tableaux : d�bordement, affectation d'un tableau � un autre...

  Ce programme peut �tre suivi sous debugger, pour pr�ciser les notions de
  r�f�rence en Java
************************************************************************/
public class Erreurs
{	
	
	public static void main (String arg [] )
	{		
		System.out.println ("*** Erreurs frequentes sur les Tableaux ***");
		System.out.println ();

		// Etape 1 : cr�ation du tableau, avec un nombre de cases choisies par l'utilisateur
		int [] entiers;		// d�claration du tableau d'entiers	
		final int nbCases;	// taille du tableau ( constant apr�s sa lecture )

		System.out.print ("Taille de votre tableau ?");	
		nbCases = Lire.i();
		entiers = new int [nbCases];  // attention si la taille est < 0
		
  		// Etape 2 :  rangement d'un entier dans le tableau, � un indice choisi par l'utilisateur 
		int iRang;
		do
		{
			System.out.print ("Indice de rangement ?");
			iRang = Lire.i();	// attention si l'indice est incorrect
		
			System.out.print ("Valeur ?");
			entiers [iRang] = Lire.i();
		}	
		while (Lire.Question ("Une autre saisie"));	
		
		// Remarquez l'utilisation directe de la case du tableau, 
		//    pour recevoir le retour de la fonction Lire
		
		
		//  Etape 3 : r�affichage du tableau
		System.out.println ( "** Contenu du tableau entiers **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + entiers[i] );
		}

		// Etape 4 : un tableau "pointe", "se r�f�re" � un autre
		int clone [];
		// les deux tableaux d�signent maintenant la m�me zone m�moire
		clone = entiers ;		
		
		System.out.println ( "** Contenu du tableau clone **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + clone[i] );	
		}
		
		// si je modifie l'un, je modifie l'autre
		clone[0] = 0; // je modifie la premi�re case du tableau
		
		System.out.println ( "** Contenu du tableau entiers **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + entiers[i] );
		}
		
		Lire.Attente ();   
   }   
}
