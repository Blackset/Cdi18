public class DecimalToUnicode {

	public static void main(String[] args) {
		System.out.println();
		System.out.println ("**** Convertion code Unicode décimal en caractère (V1.0, 12/01/01) ****");
		
		System.out.println("*\t*"); // Tabulation
		System.out.println("*\7*"); // Beep
		System.out.println("*\r*"); // Carriage return
		
		int entier; // valeur decimal pour le caractère unicode
		
		System.out.println();
		System.out.print("Saisissez un code Unicode en décimal : ");
		
		entier = Lire.i();
		
		// convertion en caractère unicode
		System.out.print("Caractère correspondant : ");
		System.out.println((char) entier);	
	}

}

