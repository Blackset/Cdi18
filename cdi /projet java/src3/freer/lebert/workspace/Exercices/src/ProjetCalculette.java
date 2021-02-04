
public class ProjetCalculette
{
	private static final int MIN = -1000; // valeur minimum
	private static final int MAX = 1000; // valeur maximum

	public static int saisirOperande(String pChainecar)
	{
		int operande; // opérande saisi par l'utilisateur
		boolean succes; // test sur opérande

		do
		{
			System.out.print(pChainecar);
			operande = Lire.i();
			if (operande < MIN || operande > MAX)
			{
				System.out.println("Erreur : opérande hors limite !");
				succes = false;
			}
			else
			{
				succes = true;
			}
		} while (!succes);
		return operande;
	}

	public static char saisirOperateur()
	{
		char operateur; // opérateur saisi par l'utilisateur
		boolean succes; // test sur opérateur

		do
		{
			System.out.print("Saisir un opérateur valide : ");
			operateur = Lire.c();
			if (operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/')
			{
				succes = true;
			}
			else
			{
				System.out.println("Ceci n'est pas un opérateur valide !");
				succes = false;
			}
		} while (!succes);
		return operateur;
	}

	public static boolean effectuerCalcul(int pOperande1, int pOperande2, char pOperateur, Entier pResultat)
	{
		switch (pOperateur)
		{
		case '+':
			pResultat.setVal(pOperande1 + pOperande2);
			return true;
		case '-':
			pResultat.setVal(pOperande1 - pOperande2);
			return true;
		case '*':
			pResultat.setVal(pOperande1 * pOperande2);
			return true;
		case '/':
			if (pOperande2 != 0)
			{
				pResultat.setVal(pOperande1 / pOperande2);
				return true;
			}
			else
			{
				return false;
			}
		default:
			return false;
		}
	}

	public static void afficher(int pResultat, boolean pReussite)
	{
		if (pReussite)
		{
			System.out.println("Le résultat est : " + pResultat);
		}
		else
		{
			System.out.println("Calcul impossible : division par zéro");
		}
	}

	public static void main(String[] argument)
	{
		int operande1 = saisirOperande("Saisir un premier opérande valide : ");
		int operande2 = saisirOperande("Saisir un deuxième opérande valide : ");
		char operateur = saisirOperateur();
		Entier resultat = new Entier();
		boolean succes = effectuerCalcul(operande1, operande2, operateur, resultat);

		afficher(resultat.getVal(), succes);
	}
}
