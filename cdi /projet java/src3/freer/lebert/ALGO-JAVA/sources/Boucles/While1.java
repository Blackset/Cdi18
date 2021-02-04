/*********************************************************************
  Nom du programme  :  While1.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          :  Illustre la structure algorithmique while (tant que)  

    Tant que l'utilisateur répond 'O' à la question  "Voulez vous continuer ",
  le programme  boucle en affichant à l'écran le nombre de passages dans la
  boucle, et calcule à chaque passage une suite arithmétique de raison et
  de premier terme choisi par l'utilisateur.
  par exemple premier terme 3, raison 5, la suite est 3, 8, 13, 18, 23, ...
**********************************************************************/

public class While1
{
	public static void main (String arg [])
	{

		char veutContinuer;	 // egal à 'O' quand on veut continuer 
												  
		int nbrPassages;	 // nombre de passages dans la boucle 
		int suite;			 // suite arithmétique calculée dans la boucle 
		int raison;			 // raison de la suite arithmétique 
  

		System.out.println ( "** While **" );
		System.out.println ();
		nbrPassages = 0;	 // on n'a pas ENCORE exécuté la boucle !
  
		System.out.print ("Premier terme de la suite ? "); 
		suite = Lire.i();	 // U(0) premier terme de la suite 
  
		System.out.print ("Raison de la suite ? ");
		raison = Lire.i(); 

		System.out.print ("Voulez-vous entrer dans la boucle (O  pour oui)?");
		veutContinuer = Lire.c();	// si veutContinuer = 'O', on choisit 
									// d'exécuter la boucle au moins une fois!
		                      
		while  (veutContinuer == 'O')	// arrêt quand veutContinuer != 'O' 
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
