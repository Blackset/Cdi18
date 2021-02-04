/*  Classe      : Calculatrice1
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : Calculatrice
*/
public class Calculatrice1
{

	private static final int MAX = 1000;

	public static void main(String[] argument)
	{

		int nombre1; // Entier numero 1
		

		// Affichage de la version
		System.out.println("****Calculatrice (V1.0, 11/10/16)****");
		// Saisiedu chiffre
		System.out.println("Entrez un chiffre compris entre -"+MAX+" et "+MAX+" : ");
		nombre1 = Lire.i();
		if ((nombre1 <= -MAX) || (nombre1 >= MAX))
		{
			System.out.println("ERREUR : Entrez un chiffre compris entre -"+MAX+" et "+MAX+" : ");
			nombre1 = 0;
		}

	}

}