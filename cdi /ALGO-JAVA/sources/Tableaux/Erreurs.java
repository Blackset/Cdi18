/*********************************************************************
  Programme			:  Erreurs.java
  Auteur            :  Lécu Regis 
  Mise a jour		:  février 2001,maj nov 2003 jcc

  Fonction          : Démonstration sur les erreurs les plus répandues sur
  les tableaux : débordement, affectation d'un tableau à un autre...

  Ce programme peut être suivi sous debugger, pour préciser les notions de
  référence en Java
************************************************************************/
public class Erreurs
{	
	
	public static void main (String arg [] )
	{		
		System.out.println ("*** Erreurs frequentes sur les Tableaux ***");
		System.out.println ();

		// Etape 1 : création du tableau, avec un nombre de cases choisies par l'utilisateur
		int [] entiers;		// déclaration du tableau d'entiers	
		final int nbCases;	// taille du tableau ( constant après sa lecture )

		System.out.print ("Taille de votre tableau ?");	
		nbCases = Lire.i();
		entiers = new int [nbCases];  // attention si la taille est < 0
		
  		// Etape 2 :  rangement d'un entier dans le tableau, à un indice choisi par l'utilisateur 
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
		
		
		//  Etape 3 : réaffichage du tableau
		System.out.println ( "** Contenu du tableau entiers **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + entiers[i] );
		}

		// Etape 4 : un tableau "pointe", "se réfère" à un autre
		int clone [];
		// les deux tableaux désignent maintenant la même zone mémoire
		clone = entiers ;		
		
		System.out.println ( "** Contenu du tableau clone **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + clone[i] );	
		}
		
		// si je modifie l'un, je modifie l'autre
		clone[0] = 0; // je modifie la première case du tableau
		
		System.out.println ( "** Contenu du tableau entiers **");
		for  (int i = 0 ; i < nbCases ; i ++)
		{
			System.out.println (i + ": " + entiers[i] );
		}
		
		Lire.Attente ();   
   }   
}
