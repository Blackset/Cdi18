/*************************************************************************
  Programme      :  If1.java
  Auteur         :  Lécu Regis 
  Mise a jour    :  février 2001, maj nov 2003 jcc
  Fonction       

   -  Programme de démonstration illustrant la  structure algorithmique 
   CONDITIONNELLE : "si la condition est réalisée alors on fait l'action"

   -  Le programme lit un entier au clavier, et teste si celui-ci est un 
      multiple de 2, de 3, et s'il s'agit d'un nombre négatif. Lorsqu'une 
      condition est réalisée, le programme affiche un message d'information.
***************************************************************************/

public class If1 // notez la majuscule au nom de la classe
{
	public static void main (String [] argument)
	{  
		int entier;

		System.out.println ("*** If consecutifs ***" );
		System.out.println ();
	 
		System.out.print( "Entier a tester ?") ;
		entier = Lire.i();
	 
		if  (entier % 2 == 0)
		{
			System.out.println ("C'est un entier pair") ;
		}
		
		if (entier % 3 == 0) 
		{
			System.out.println ("C'est un multiple de trois" );
		}
		
		if (entier <  0) 
		{
			System.out.println ("C'est un nombre negatif " ); 
		}
		
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();
	}
}
