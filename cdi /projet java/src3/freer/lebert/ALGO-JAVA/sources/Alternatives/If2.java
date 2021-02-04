/*************************************************************************
  Programme     :  If2.java
  Auteur        :  L�cu Regis 
  Mise a jour   :  f�vrier 2001, maj nov 2003 jcc
  Fonction          
   -  Illustre la Structure CONDITIONNELLE avec imbrication de if 
   -  Ce programme  reconna�t les nombres  pairs, et les multiples
   de 4 : un  nombre ne pouvant �tre multiple de 4 sans �tre pair, on ne teste
   la divisibilit� par 4 que si le nombre est pair (-> if imbriqu�s )
**************************************************************************/
public class If2
{
	public static void main (String [] argument)
	{  
		// notez que la pr�sentation met en �vidence la structure du pg
		int entier;

		System.out.println ( "*** If imbriques ***");
		System.out.println ();
	  
		System.out.print( "Entier a tester ?") ;
		entier = Lire.i();
	  
		if (entier % 2 == 0)		// d�but de la port�e du premier if
		{                                        
		    System.out.println ("C'est un entier pair");
			  
			if (entier % 4 == 0)	// if imbriqu� 
		    {
				System.out.println ("C'est aussi un multiple de quatre") ;
		    }
			  
		}							// fin de la port�e du  premier if
	  
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();
	}
}
