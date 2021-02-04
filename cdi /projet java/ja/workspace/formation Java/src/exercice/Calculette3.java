package exercice;


public class Calculette3 {
	public static char MOINS = '-';
	public static char PLUS = '+';
	public static char DIVISE = '/';
	public static char MULTIPLIE = '*';

	public static void main(String[] argument) {
		do{
		int entier1, entier2;
		char operateur;
		System.out.println("Saisissez votre entier1:");
		entier1 = Lire.i();

		System.out.println("Saisissez votre entier2:");
		entier2 = Lire.i();
		do {
			System.out.println("Saisissez votre operateur:");
			operateur = Lire.c();
			switch (operateur)

			{
			case '-':
				System.out.println("le resultat est " + (entier1 - entier2));
				break;
			case '+':
				System.out.println("Le resultat est " + (entier1 + entier2));
				break;
			case '/':
				if (entier2 == 0) {
					System.out.println("Aucun nombre n'est ivisible par O");
				} else {
					System.out.println("Le resultat est " + (entier1 / entier2));
				}
				;
				break;
			case '*':
				System.out.println("Le resultat est " + (entier1 * entier2));
				break;
			default:
				System.out.println("Saisissez a nouveau l'op�rateur");
			}
		} while (operateur != MOINS && operateur != PLUS && operateur != DIVISE && operateur != MULTIPLIE); 
		}while (Dialogue.veutContinuer());																								// de
																											
																											
																											
																										

	}

}
