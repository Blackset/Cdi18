/*********************************************************************
  Programme			:  Tableau.java
  Auteur            :  L�cu Regis 
  Mise a jour		:  f�vrier 2001, maj nov 2003 jcc

  Fonction          : Utilisation d'un tableau � une dimension.

Le programme lit au clavier MAX entiers et les range dans un tableau.
Puis, il r�affiche les entiers dans l'ordre inverse de la saisie. 
************************************************************************/

public class Tableau
{
	public static void main (String arg [] )
	{
		int [] tabEntier;	// d�claration d'une r�f�rence sur un tableau d'entiers	
		final int MAX = 5;  // taille du tableau

		System.out.println ("*** Demo Tableaux ***");
		System.out.println ();

		// Etape 1 : allocation de MAX cases ( cr�ation du tableau )
		tabEntier = new int [MAX];
		// tabEntier r�f�rence le tableau nouvellement cr��
		
 		// Etape 2 : lecture des MAX entiers et rangement dans le tableau 
		for (int i = 0 ; i < MAX ; i ++)
		{
			System.out.println ("Entrez l'entier numero " + (i+1) + " : ");
			tabEntier[i] = Lire.i() ; 		 // saisie de la case num�ro i du tableau
		}

		//  Etape 3 : r�affichage des MAX entiers dans l'ordre inverse 
		System.out.println ("Vos entiers dans l'ordre inverse : ");
		
		for  (int i= MAX - 1 ; i >= 0 ; i --)
		{
			System.out.println ("Case " + i + " : " + tabEntier[i] );
		}
		
		Lire.Attente ();   
	}   
}
