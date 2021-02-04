// Class Dialogue
// Nous donnons ici une fonction qui permet de proposer à l'utilisateur s'il veut continuer ou non,
// et renvoie vrai ou faux en fonction de sa réponse. 

public class Dialogue {

	// Fonction veutContinuer : si l'utilisateur répond par Oui, renvoie vrai, si il répond par non renvoie faux,
	// et autrement redemande.
	//Entrée : pas d'entrée.
	// Valeur de retour : le booléen veut continuer (v) ou non (f).
	
	public static boolean veutContinuer(){
		
		char reponse ;						// Caractère de réponse donné par l'utilisateur
		boolean continuer = false ;			// Booléen qui nous indique si l'utilisateur veut continuer (vrai),
											// retourné par la fonction.
		
		
		do {
			// Nous demandons et lisons la réponse
			System.out.println ();
			System.out.println ();
			System.out.println ("voulez-vous continuer ? (O ou o pour oui, N ou n pour non)");
			System.out.println ("\t -> ");
			reponse = Lire.c() ;
			
			//Selon la réponse
			if (reponse == 'O' || reponse == 'o') {
				continuer = true ;			// Il veut continuer.
			}
			else if (reponse == 'N' || reponse == 'n'){
				continuer = false ;
			}

			// Sinon on reboucle car la réponse n'est pas valable. On fixe le caractère à ' ' comme marqueur de bouclage
			else reponse = ' ';
			
		}
		while (reponse == ' ') ;	// On arrête si on tombe sur autre chose qu'un espace
								// (en l'occurrence forcément une réponse valide).
	
		return continuer ;
		
	}
	
}
