/*************************************************************************
  Programme     :  If2.java
  Auteur        :  Lécu Regis 
  Mise a jour   :  février 2001, maj nov 2003 jcc
  Fonction          
   -  Illustre la Structure CONDITIONNELLE avec imbrication de if 
   -  Ce programme  reconnaît les nombres  pairs, et les multiples
   de 4 : un  nombre ne pouvant être multiple de 4 sans être pair, on ne teste
   la divisibilité par 4 que si le nombre est pair (-> if imbriqués )
**************************************************************************/
public class If2
{
	public static void main (String [] argument)
	{  
		// notez que la présentation met en évidence la structure du pg
		int entier;

		System.out.println ( "*** If imbriques ***");
		System.out.println ();
	  
		System.out.print( "Entier a tester ?") ;
		entier = Lire.i();
	  
		if (entier % 2 == 0)		// début de la portée du premier if
		{                                        
		    System.out.println ("C'est un entier pair");
			  
			if (entier % 4 == 0)	// if imbriqué 
		    {
				System.out.println ("C'est aussi un multiple de quatre") ;
		    }
			  
		}							// fin de la portée du  premier if
	  
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();
	}
}
