public class DecimalToUnicode {

	public static void main(String[] args) {
		System.out.println();
		System.out.println ("**** Convertion code Unicode d�cimal en caract�re (V1.0, 12/01/01) ****");
		
		System.out.println("*\t*"); // Tabulation
		System.out.println("*\7*"); // Beep
		System.out.println("*\r*"); // Carriage return
		
		int entier; // valeur decimal pour le caract�re unicode
		
		System.out.println();
		System.out.print("Saisissez un code Unicode en d�cimal : ");
		
		entier = Lire.i();
		
		// convertion en caract�re unicode
		System.out.print("Caract�re correspondant : ");
		System.out.println((char) entier);	
	}

}

