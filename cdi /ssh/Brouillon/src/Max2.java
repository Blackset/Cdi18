/*  Classe      : Max
 Auteur      : Halim, revu par Lécu Régis
 Mise à jour : 20 Octobre 2015
 Fonction    : ce programme permet la réalisation progressive d'une calculette 2 */

public class Max2

{
	public static final int MIN = -1000;
	public static final int MAX = 1000;

	public static void main(String[] argument)
	{

		int entier1; // le premier entier rentré par l'utilisateur
		int entier2; // le deuxieme entier rentré par l'utilisateur
		char Opérateur; // la saisie d'un opérateur '+', '-','*' ou '/' rentré
						// par l'utilisateur
		int resultats = 0; // c'est le résultat de la calculette en utilisant les opérateurs

	do
	{
		
		System.out.print(" Entrez un premier chiffre entier1 "); // on affiche l'entier1

		entier1 = Lire.i();

		while (entier1 <= MIN || entier1 >= MAX)
		{
			System.out.print("cet entier n'est pas compris entre MIN et MAX, entrez un nouvel entier :");

			entier1 = Lire.i(); // saisie un autre entiers
		}

		System.out.print(" Entrez un second chiffre entier2 "); // on affiche l'entier2

		entier2 = Lire.i();

		while (entier2 <= MIN || entier2 >= MAX)
		{
			System.out.print("cet entier n'est pas compris entre MIN et MAX, entrez un nouvel entier  :");

			entier2 = Lire.i(); // saisie un autre entier
		}
			
		
		System.out.print(" Entrez un opérateur "); // On affiche l'Opérateur

		Opérateur = Lire.c();

		while (Opérateur != '+' && Opérateur != '-' && Opérateur != '*' && Opérateur != '/')
		{
			System.out.print(" l'Opérateur saisie n'est pas correct, donnez un autre opérateurs");

			Opérateur = Lire.c(); // recommencer la saisie
		}

		switch (Opérateur)
		{
		case '+':
			resultats = entier1 + entier2;

			System.out.println(" cest un '+' donc il rentre dans nos opérateurs");
			break;

		case '-':
			resultats = entier1 - entier2;

			System.out.println(" cest un '-' donc il rentre dans nos opérateurs");
			break;

		case '*':
			resultats = entier1 * entier2;

			System.out.println(" cest un '*'donc il rentre dans nos opérateurs");
			break;

		case '/':
			if (entier2 != 0)

			{
				resultats = entier1 / entier2;

				System.out.println(" c'est un '/'donc il rentre dans nos opérateurs");

			}
			else
			{
				System.out.println(" indeterminé");
			}

			break;

		default:
			System.out.println(" c'est un autre caractère");

		}

		System.out.println("le résultat est :" + resultats);

		} while ( Max6.veutContinuer()== true);
	
}
}
