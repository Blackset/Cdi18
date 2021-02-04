
/*************************************************************************
  Programme			:  If3.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          : 

   -  Illustre la Structure alternative  if ... else 
   -  Ce programme lit un caractère au clavier, et teste si ce caractère est
      une lettre majuscule, ou un autre type de caractère ...
***************************************************************************/

public class If3
{
	public static void main (String [] argument)
	{     
		char car;

		System.out.println ("**** If .. else ****" );
		System.out.println ();

		System.out.print  ("Caractere a tester : " );
		car = Lire.c() ;
	 
		if ( (car >= 'A')  &&  (car <= 'Z') )
		{
			System.out.println ("Ce caractere est une lettre Majuscule !");
		}
		else
		{
			System.out.println ("Ce caractere n'est pas une lettre Majuscule !");
		}
	 
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();   
	}
}
