// Class Dialogue
// Nous donnons ici une fonction qui permet de proposer � l'utilisateur s'il veut continuer ou non,
// et renvoie vrai ou faux en fonction de sa r�ponse. 

public class Dialogue {

	// Fonction veutContinuer : si l'utilisateur r�pond par Oui, renvoie vrai, si il r�pond par non renvoie faux,
	// et autrement redemande.
	//Entr�e : pas d'entr�e.
	// Valeur de retour : le bool�en veut continuer (v) ou non (f).
	
	public static boolean veutContinuer(){
		
		char reponse ;						// Caract�re de r�ponse donn� par l'utilisateur
		boolean continuer = false ;			// Bool�en qui nous indique si l'utilisateur veut continuer (vrai),
											// retourn� par la fonction.
		
		
		do {
			// Nous demandons et lisons la r�ponse
			System.out.println ();
			System.out.println ();
			System.out.println ("voulez-vous continuer ? (O ou o pour oui, N ou n pour non)");
			System.out.println ("\t -> ");
			reponse = Lire.c() ;
			
			//Selon la r�ponse
			if (reponse == 'O' || reponse == 'o') {
				continuer = true ;			// Il veut continuer.
			}
			else if (reponse == 'N' || reponse == 'n'){
				continuer = false ;
			}

			// Sinon on reboucle car la r�ponse n'est pas valable. On fixe le caract�re � ' ' comme marqueur de bouclage
			else reponse = ' ';
			
		}
		while (reponse == ' ') ;	// On arr�te si on tombe sur autre chose qu'un espace
								// (en l'occurrence forc�ment une r�ponse valide).
	
		return continuer ;
		
	}
	
}
