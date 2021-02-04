/*************************************************************************
  Programme			Visibilite.java
  Auteur            Lécu Regis 
  Mise a jour       février 2001, maj nov 2003 jcc
  Fonction          
    visibilité des variables dans les classes Java. Données
	membres publiques et privées.
  
*************************************************************************/

class Autre
{
	private static int x = 800; // x est privé, donc caché
	public static int y;		// y est public, donc visible de l'extérieur
	
	public static void Methode ()
	{
		System.out.println();
  	    System.out.println("\t\t** debut Autre.Methode **");
		System.out.println("\t\tx (variable privee de la classe Autre)  =" + x );
		System.out.println("\t\ty (variable publique de la classe Autre)  =" + y );		
		System.out.println("\t\t** fin Autre.Methode **");
		System.out.println();				
	}
}

public class Visibilite
{
	static int x = 1959;    // x est visible dans toutes les méthodes de la classe
 
	public static void main (String arg []) 
	{                   
		System.out.println("* Visibilite des variables (suivre sur le listing) *");
		System.out.println();
   		
		System.out.println("x (variable de classe) = " + x );
		
		// x est visible de sa déclaration à la fin du main : il masque la variable 
		//	de classe de même nom ( évitez de faire cela !!! )
		int x = 1515;
		System.out.println("\tx (du main) = " + x );

		// appel d'une méthode de la classe "Visibilite"
		FoncLocale ();      
		System.out.println("\tx (du main, bis) = " + x );
   
		Autre.y = 1600;
		Autre.Methode ();
		System.out.println("\tx (du main, ter) = " + x );
		
		Lire.Attente ();	
	} 

	public static void FoncLocale ()
	{	
  	    System.out.println();
  	    System.out.println("\t\t** debut FoncLocale **");
		System.out.println("\t\tx (variable de classe)  =" + x );	
		// définition d'une variable locale à la fonction
		int x = 1492;
		System.out.println("\t\t\tx (locale à la fonction)  =" + x );			
		{	
			// variable local au bloc ( délimité par {  } )
			int y = 1789; // ici on ne peut pas redéfinir x
			System.out.println("\t\t\ty (dans le bloc1)  =" + y );			
		}
		// ici y n'existe pas
		{	
			// variable local au bloc ( délimité par {  } )
			int y = 832; // ici on ne peut pas redéfinir x
			System.out.println("\t\t\ty (dans le bloc2)  =" + y );			
		}
		// ici non plus y n'existe pas
		System.out.println("\t\tx (locale à la fonction bis)  =" + x );
		System.out.println("\t\t** fin FoncLocale **");
		System.out.println();
	}
}