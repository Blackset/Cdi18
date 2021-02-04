/*************************************************************************
  Programme			:  If4.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          : 

  -  Illustre la Structure alternative  if...else if...else if...else 
  -  Ce programme lit un caractère au clavier, et teste si ce caractère est
      une lettre majuscule, une lettre minuscule, un chiffre, un signe de 
      ponctuation ou un autre type de caractère ...
***************************************************************************/

public class If4
{
	public static void main (String [] argument)
	{     
		char car;

		System.out.println ("**** If...else if...else... ****" );
		System.out.println ();

		System.out.print  ("Caractere a tester : " );
		car = Lire.c() ;

		if ( (car >= 'A')  &&  (car <= 'Z') )
		{
			System.out.println ("Ce caractere est une Majuscule" ) ;
		}
		else if  ( (car >= 'a')  &&  (car <= 'z') )
		{
			System.out.println ("Ce caractere est une minuscule" ) ;
		}
		else if  ( (car >= '0')  &&  (car <= '9') )
		{
			System.out.println ("Ce caractere est un chiffre" ) ;
		}
		else if ( (car == '.') || (car == ',') || (car == ';') || 
				  (car == '!') || (car == ':'))
		{
			System.out.println ("Ce caractere est un signe de ponctuation" ) ;
		}
		else
		{
			System.out.println ("caractere d'un autre type !" ) ;
		}
		   
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();   
	}
}
