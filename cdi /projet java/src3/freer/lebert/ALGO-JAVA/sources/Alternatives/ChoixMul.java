/*************************************************************************
  Programme			:  ChoixMul.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2003 jcc
  Fonction          :  Structure algorithmique  "choix multiple" 

     Ce programme de d�monstration lit un caract�re au clavier, 
     et effectue plusieurs tests exclusifs par l'instruction "switch"
************************************************************************/
public class ChoixMul
{
	public static void main (String [] argument)
	{     
		char car;   //  caract�re � tester

		System.out.println ("*** Choix Multiples ***" ) ;
		System.out.println ();
			  
		System.out.print ( "Caractere a tester :");
		car = Lire.c();
  
		switch (car)
		{
			case 'A':
			case 'F':	System.out.println ("C'est un A ou un F" ) ; 
			            break;
					
			case 'Z':	System.out.println ("C'est un Z" ) ;
			            break;
					
			default :	System.out.println ("C'est un autre caractere" ) ;						   
		}
			  
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();   	  
	}	   
}

