//  Classe      : Cercle
//  Fonction    : ce programme renvoie le caract�re associ� � une valeur unicode donn�e. 




public class Unicode {

	public static void main(String[] args) {
	
	int valeurUnicode  ;	// valeur unicode, r�cup�r�e � l'utilisateur.
	
	
	System.out.println("Programme Unicode, renvoie le caract�re associ� � une valeur unicode. V1.0 ");
	System.out.println("");
	
	
	System.out.print("Donner votre entier : ");
	valeurUnicode = Lire.i();		// On r�cup�re la valeur unicode � tester
	System.out.println("");
	System.out.print("Le caract�re associ� est :\t");
	System.out.println((char) valeurUnicode);		// On affiche le caract�re apr�s avoir converti le type.
		
	}

}
