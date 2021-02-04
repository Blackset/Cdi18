
public class Calculatrice
{
	public static void main(String[] args)
	{

		System.out.println();
		System.out.println("**** Calculatrice (V1.0, 11/10/2016) ****");
		System.out.println();


		// VARIABLES
		int numberOne; // Nombre 1 saisie par l'utilisateur
		int numberTwo; // Nombre 2 saisie par l'utilsateur
		char operator; // type de l'opération
		Calcul resultat = new Calcul(); // On instancie la classe Calcul pour le passage de paramètre
		boolean erreurCalcul; // Erreur de calcul
		do
		{
			numberOne = Dialogue.saisirOperande("premier");

			operator = Dialogue.saisirOperateur();
			
			numberTwo = Dialogue.saisirOperande("deuxieme");
			
			erreurCalcul = Dialogue.effectuerCalcul(numberOne, numberTwo, operator, resultat);
			
			Dialogue.afficher(resultat.getVal(), erreurCalcul);
						
		}
		while (Dialogue.veutContinuer());

		System.out.println("Programme terminé");

		// On quitte le programme
		System.exit(0);
	}

}
