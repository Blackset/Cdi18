/*************************************************************************
  Programme			:  For1.java
  Auteur            :  Lécu Regis 
  Mise a jour		:  février 2001, maj nov 2003 jcc
  Fonction			:  Illustre la boucle "for" en Java
                   
   Ce programme effectue la somme des N  premiers nombres strictement
   positifs, puis la somme des N plus grands nombres strictement négatifs 
   ([-N,-1]), en affichant à l'écran la suite des nombres.
***************************************************************************/

public class For1
{
	public static void main (String arg [])
	{
		int nombreEntiers;    // Nombre d'entiers que l'on doit sommer  
		int somme;            // somme des entiers 

		System.out.println ( "Somme des N Premiers entiers positifs" );
		System.out.print ( "Nombre d'entiers a sommer : "); 
		nombreEntiers = Lire.i ();
		System.out.println ();
  
		// Etape 1 : affichage des N premiers entiers positifs
		//           et calcul de leur somme
		
		somme = 0;   
		for (int entier = 1; entier <= nombreEntiers; entier = entier + 1)
		{
			System.out.println ("J'ajoute " + entier);
			somme = somme + entier;
		}
  
		// Etape 2 : affichage de leur somme
		
		System.out.println ("Somme des " + nombreEntiers + 
						    " premiers entiers positifs :" + somme);

		// Etape 3 : affichage des N plus grands entiers négatifs
		//           et calcul de leur somme
		
		System.out.println ();
		System.out.println ( "Somme des N plus grands entiers negatifs");
		System.out.print ( "Nombre d'entiers a sommer: ");
		nombreEntiers = Lire.i ();
		somme = 0;   
		System.out.println ();
		 
		for (int entier = -1; entier >= -nombreEntiers; entier = entier - 1)
		{
			System.out.println (  "J'ajoute " + entier);
			somme = somme + entier;
		}
  
		// Etape 4 : affichage de leur somme
		
		System.out.println ();
		System.out.println ("Somme des " + nombreEntiers + 
						    " plus grands entiers negatifs : " + somme);
  
		System.out.println ();
		System.out.println ("*** Tapez Entree pour Terminer ***");
		Lire.c();
	}
 }
  
  

