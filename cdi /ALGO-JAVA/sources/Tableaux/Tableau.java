/*********************************************************************
  Programme			:  Tableau.java
  Auteur            :  Lécu Regis 
  Mise a jour		:  février 2001, maj nov 2003 jcc

  Fonction          : Utilisation d'un tableau à une dimension.

Le programme lit au clavier MAX entiers et les range dans un tableau.
Puis, il réaffiche les entiers dans l'ordre inverse de la saisie. 
************************************************************************/

public class Tableau
{
	public static void main (String arg [] )
	{
		int [] tabEntier;	// déclaration d'une référence sur un tableau d'entiers	
		final int MAX = 5;  // taille du tableau

		System.out.println ("*** Demo Tableaux ***");
		System.out.println ();

		// Etape 1 : allocation de MAX cases ( création du tableau )
		tabEntier = new int [MAX];
		// tabEntier référence le tableau nouvellement créé
		
 		// Etape 2 : lecture des MAX entiers et rangement dans le tableau 
		for (int i = 0 ; i < MAX ; i ++)
		{
			System.out.println ("Entrez l'entier numero " + (i+1) + " : ");
			tabEntier[i] = Lire.i() ; 		 // saisie de la case numéro i du tableau
		}

		//  Etape 3 : réaffichage des MAX entiers dans l'ordre inverse 
		System.out.println ("Vos entiers dans l'ordre inverse : ");
		
		for  (int i= MAX - 1 ; i >= 0 ; i --)
		{
			System.out.println ("Case " + i + " : " + tabEntier[i] );
		}
		
		Lire.Attente ();   
	}   
}
