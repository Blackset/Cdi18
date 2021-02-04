
public class Dialogue
{
	/**
	 * @param numeroOperande
	 * @return un opérande compris entre -1000 et 1000
	 */
	public static int saisirOperande(String numeroOperande)
	{
		// VARIABLE
		int number; // Nombre saisie par l'utilisateur
		boolean saisieValide; // Validation de la saisie
		do
		{
			saisieValide = true;
			System.out.println();
			System.out.print("Saisissez le " + numeroOperande + " nombre : ");

			number = Lire.i();

			if ((number < Constantes.MIN) || (number > Constantes.MAX))
			{
				System.out.println();
				System.out.println("Erreur : opérande hors limite ! ");
				saisieValide = false;
			}
		}
		while (saisieValide == false);
		// arrêt quand saisie valide

		return number;
	}

	/**
	 * @return un opérateur valide
	 */
	public static char saisirOperateur()
	{
		// VARIABLES
		char operator; // choix de l'opérateur de calcul
		boolean saisieValide; // Validation de la saisie
		do
		{
			saisieValide = true;
			System.out.println();
			System.out.print("Saisissez l'opérateur\n(choix possible + - * /) : ");
			operator = Lire.c();

			if ((operator != Constantes.PLUS) && (operator != Constantes.MOIN) && (operator != Constantes.FOIS)
					&& (operator != Constantes.DIVI))
			{
				System.out.println();
				System.out.print("Ceci n'est pas un opérateur valide !");
				saisieValide = false;
			}

		}
		while (saisieValide == false);
		// arrêt quand saisie valide
		return operator;
	}

	/**
	 * @param numberOne
	 * @param numberTwo
	 * @param operator
	 * @param result
	 * @return true si le calcul a réussi et false si tentative de division par 0
	 */
	public static boolean effectuerCalcul(int numberOne, int numberTwo, char operator, Calcul result)
	{
		// VARIABLES
		boolean erreurCalcul = false;

		// Vérification de l'opérateur
		switch (operator)
		{
		case Constantes.PLUS:
			result.setVal(numberOne + numberTwo);
			break;
		case Constantes.MOIN:
			result.setVal(numberOne - numberTwo);
			break;
		case Constantes.FOIS:
			result.setVal(numberOne * numberTwo);
			break;
		case Constantes.DIVI:
			if ((numberOne != 0) && (numberTwo != 0))
			{
				// Gestion de la division par 0
				result.setVal(numberOne / numberTwo);
			}
			else
			{
				System.out.println("Calcul impossible :division par zéro");
				erreurCalcul = true;
			}
			break;
		}
		return erreurCalcul;
	}
	
	/**
	 * @param resultat
	 * @param erreurCalcul
	 */
	public static void afficher(int resultat, boolean erreurCalcul)
	{
		if(erreurCalcul == false)
		{
			System.out.println(resultat);
		}
		else
		{
			System.out.println("Le programme a rencontré un problème");
		}
	}

	/**
	 * @return un booléen pour continuer ou non le programme
	 */
	public static boolean veutContinuer()
	{
		// VARIABLES
		char reponse; // réponse de l'utilisateur

		do
		{
			System.out.println("Voulez-vous continuer ?");
			reponse = Character.toUpperCase(Lire.c());
		}
		while ((reponse != 'O') && (reponse != 'N'));
		// arrêt quand le caractère saisie est soit O, N

		return ((reponse == 'O'));
	}

}
