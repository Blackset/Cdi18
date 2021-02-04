/*  Classe      : Max
 Auteur      : Halim, revu par Lécu Régis
 Mise à jour : 20 Octobre 2015
 Fonction    : ce programme permet la réalisation progressive d'une calculette 2 */

public class Operateur

{

	public static final int MIN = -1000;
	public static final int MAX = 1000;

	public static void main(String[] argument)

	{

		Entier resultats = new Entier();
		int operande1;
		int operande2;
		char operateur;
		boolean reussite;

		operande1 = saisirOperande("premier"); // saisir premier Operande
		operateur = saisirOperateur();

		operande2 = saisirOperande("deuxieme"); // saisir deuxieme Operande

		reussite = effectuerCalcul(operande1, operande2, operateur, resultats);

		afficher(resultats.getVal(), reussite);

		System.out.println(" resultats, reussite : ");

	}

	public static int saisirOperande(String invite)
	{

		int operande;

		System.out.println(" saisirle " + invite + " Operande : ");
		operande = Lire.i();

		while (operande < MIN || operande > MAX)
		{
			System.out.println(" cet operande n'est pas compris entre MIN et MAX, entrez un nouvel operande : ");
			operande = Lire.i();

			System.out.println(" saisir ' Operateur' : ");

		}
		return operande;

	}

	public static char saisirOperateur()

	{
		char operateur;

		{
			System.out.println(" saisir Operateur : ");
			operateur = Lire.c();

		}

		while (operateur != '+' && operateur != '-' && operateur != '*' && operateur != '/')
		{
			System.out.print(" l'Opérateur saisie n'est pas correct, donnez un autre opérateurs");

			operateur = Lire.c(); // recommencer la saisie
		}
		return (operateur);

	}

	// fonction afficher

	public static void afficher(int resultats, boolean reussite)

	{

		if (reussite == true)
		{
			System.out.println(" le resultats est  : " + resultats);
		}

		else
		{
			System.out.println(" calcul impossible  : ");
		}

		
	}

	// fonction calcul

	public static boolean effectuerCalcul(int operande1, int operande2, char operateur, Entier resultats)

	{

		boolean succes = true;

		switch (operateur)
		{
		case '+':
			resultats.setVal(operande1 + operande2);

			System.out.println(" cest un '+' donc il rentre dans nos opérateurs");
			break;

		case '-':
			resultats.setVal(operande1 - operande2);

			System.out.println(" cest un '-' donc il rentre dans nos opérateurs");
			break;

		case '*':
			resultats.setVal(operande1 * operande2);

			System.out.println(" cest un '*'donc il rentre dans nos opérateurs");
			break;

		case '/':
			if (operande2 != 0)

			{
				resultats.setVal(operande1 / operande2);
				System.out.println(" c'est un '/'donc il rentre dans nos opérateurs");
				succes = true;

			}
			else
			{
				System.out.println(" indeterminé");
				succes = false;
			}

			break;

		default:
		{
			succes = false;
		}

			

		}
		return succes;
	}
}
