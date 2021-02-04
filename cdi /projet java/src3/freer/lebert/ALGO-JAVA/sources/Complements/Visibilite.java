/*************************************************************************
  Programme			Visibilite.java
  Auteur            L�cu Regis 
  Mise a jour       f�vrier 2001, maj nov 2003 jcc
  Fonction          
    visibilit� des variables dans les classes Java. Donn�es
	membres publiques et priv�es.
  
*************************************************************************/

class Autre
{
	private static int x = 800; // x est priv�, donc cach�
	public static int y;		// y est public, donc visible de l'ext�rieur
	
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
	static int x = 1959;    // x est visible dans toutes les m�thodes de la classe
 
	public static void main (String arg []) 
	{                   
		System.out.println("* Visibilite des variables (suivre sur le listing) *");
		System.out.println();
   		
		System.out.println("x (variable de classe) = " + x );
		
		// x est visible de sa d�claration � la fin du main : il masque la variable 
		//	de classe de m�me nom ( �vitez de faire cela !!! )
		int x = 1515;
		System.out.println("\tx (du main) = " + x );

		// appel d'une m�thode de la classe "Visibilite"
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
		// d�finition d'une variable locale � la fonction
		int x = 1492;
		System.out.println("\t\t\tx (locale � la fonction)  =" + x );			
		{	
			// variable local au bloc ( d�limit� par {  } )
			int y = 1789; // ici on ne peut pas red�finir x
			System.out.println("\t\t\ty (dans le bloc1)  =" + y );			
		}
		// ici y n'existe pas
		{	
			// variable local au bloc ( d�limit� par {  } )
			int y = 832; // ici on ne peut pas red�finir x
			System.out.println("\t\t\ty (dans le bloc2)  =" + y );			
		}
		// ici non plus y n'existe pas
		System.out.println("\t\tx (locale � la fonction bis)  =" + x );
		System.out.println("\t\t** fin FoncLocale **");
		System.out.println();
	}
}