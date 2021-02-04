/*  Classe      : Max
 Auteur      : Halim, revu par L�cu R�gis
 Mise � jour : 20 Octobre 2015
 Fonction    : ce programme permet la r�alisation progressive d'une calculette 2 */

public class Max2

{
	public static final int MIN = -1000;
	public static final int MAX = 1000;

	public static void main(String[] argument)
	{

		int entier1; // le premier entier rentr� par l'utilisateur
		int entier2; // le deuxieme entier rentr� par l'utilisateur
		char Op�rateur; // la saisie d'un op�rateur '+', '-','*' ou '/' rentr�
						// par l'utilisateur
		int resultats = 0; // c'est le r�sultat de la calculette en utilisant les op�rateurs

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
			
		
		System.out.print(" Entrez un op�rateur "); // On affiche l'Op�rateur

		Op�rateur = Lire.c();

		while (Op�rateur != '+' && Op�rateur != '-' && Op�rateur != '*' && Op�rateur != '/')
		{
			System.out.print(" l'Op�rateur saisie n'est pas correct, donnez un autre op�rateurs");

			Op�rateur = Lire.c(); // recommencer la saisie
		}

		switch (Op�rateur)
		{
		case '+':
			resultats = entier1 + entier2;

			System.out.println(" cest un '+' donc il rentre dans nos op�rateurs");
			break;

		case '-':
			resultats = entier1 - entier2;

			System.out.println(" cest un '-' donc il rentre dans nos op�rateurs");
			break;

		case '*':
			resultats = entier1 * entier2;

			System.out.println(" cest un '*'donc il rentre dans nos op�rateurs");
			break;

		case '/':
			if (entier2 != 0)

			{
				resultats = entier1 / entier2;

				System.out.println(" c'est un '/'donc il rentre dans nos op�rateurs");

			}
			else
			{
				System.out.println(" indetermin�");
			}

			break;

		default:
			System.out.println(" c'est un autre caract�re");

		}

		System.out.println("le r�sultat est :" + resultats);

		} while ( Max6.veutContinuer()== true);
	
}
}
