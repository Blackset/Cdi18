
/*************************************************************************
  Programme			:  If3.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2003 jcc
  Fonction          : 

   -  Illustre la Structure alternative  if ... else 
   -  Ce programme lit un caract�re au clavier, et teste si ce caract�re est
      une lettre majuscule, ou un autre type de caract�re ...
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
