/*************************************************************************
  Programme			:  ChoixMul.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          :  Structure algorithmique  "choix multiple" 

     Ce programme de démonstration lit un caractère au clavier, 
     et effectue plusieurs tests exclusifs par l'instruction "switch"
************************************************************************/
public class ChoixMul
{
	public static void main (String [] argument)
	{     
		char car;   //  caractère à tester

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

