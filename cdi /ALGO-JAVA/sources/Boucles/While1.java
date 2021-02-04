/*********************************************************************
  Nom du programme  :  While1.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2003 jcc
  Fonction          :  Illustre la structure algorithmique while (tant que)  

    Tant que l'utilisateur r�pond 'O' � la question  "Voulez vous continuer ",
  le programme  boucle en affichant � l'�cran le nombre de passages dans la
  boucle, et calcule � chaque passage une suite arithm�tique de raison et
  de premier terme choisi par l'utilisateur.
  par exemple premier terme 3, raison 5, la suite est 3, 8, 13, 18, 23, ...
**********************************************************************/

public class While1
{
	public static void main (String arg [])
	{

		char veutContinuer;	 // egal � 'O' quand on veut continuer 
												  
		int nbrPassages;	 // nombre de passages dans la boucle 
		int suite;			 // suite arithm�tique calcul�e dans la boucle 
		int raison;			 // raison de la suite arithm�tique 
  

		System.out.println ( "** While **" );
		System.out.println ();
		nbrPassages = 0;	 // on n'a pas ENCORE ex�cut� la boucle !
  
		System.out.print ("Premier terme de la suite ? "); 
		suite = Lire.i();	 // U(0) premier terme de la suite 
  
		System.out.print ("Raison de la suite ? ");
		raison = Lire.i(); 

		System.out.print ("Voulez-vous entrer dans la boucle (O  pour oui)?");
		veutContinuer = Lire.c();	// si veutContinuer = 'O', on choisit 
									// d'ex�cuter la boucle au moins une fois!
		                      
		while  (veutContinuer == 'O')	// arr�t quand veutContinuer != 'O' 
		{										
			nbrPassages= nbrPassages + 1;// on compte le nouveau passage 
			suite = suite + raison;		 // calcul du terme suivant de la suite 
	
			System.out.print ( "Au " + nbrPassages + " passage, ");
			System.out.println ("la suite vaut: " + suite);
			
			System.out.print ("Tapez O pour continuer, une autre lettre "
							  + "pour arreter : "); 
			veutContinuer = Lire.c();
		}
  
		System.out.println ();
		System.out.println ("*** Tapez Entree pour Terminer ***");
		Lire.c();
	}	  
}
