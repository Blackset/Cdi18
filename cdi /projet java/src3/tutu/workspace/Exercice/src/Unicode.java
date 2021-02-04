//  Classe      : Cercle
//  Fonction    : ce programme renvoie le caractère associé à une valeur unicode donnée. 




public class Unicode {

	public static void main(String[] args) {
	
	int valeurUnicode  ;	// valeur unicode, récupérée à l'utilisateur.
	
	
	System.out.println("Programme Unicode, renvoie le caractère associé à une valeur unicode. V1.0 ");
	System.out.println("");
	
	
	System.out.print("Donner votre entier : ");
	valeurUnicode = Lire.i();		// On récupère la valeur unicode à tester
	System.out.println("");
	System.out.print("Le caractère associé est :\t");
	System.out.println((char) valeurUnicode);		// On affiche le caractère après avoir converti le type.
		
	}

}
