import java.util.Arrays;

public class Dichotomie
{
	private static final int TAILLE = 6; // taille du tableau

	public static String[] saisirValeurs(int pNbSaisies)
	{
		String[] tab = new String[TAILLE]; // tableau de chaines de caractères

		for (int i = 0; i < pNbSaisies; i++)
		{
			System.out.print("Saisir un prénom : ");
			tab[i] = Lire.S();
		}
		return tab;
	}

	public static int tailleTableau(String[] pTab)
	{
		int taille = 0; // taille du tableau

		for (String valeur : pTab)
		{
			if (valeur != null)
			{
				taille++;
			}
		}

		return taille - 1;
	}

	public static boolean rechercheDichotomique(String[] pTab, String pRecherche)
	{
		boolean succes = false; // recherche reussie
		int debut = 0; // indice de début
		int fin = tailleTableau(pTab); // indice de fin
		int milieu = (debut + fin) / 2; // indice du milieu

		while (!pRecherche.equals(pTab[milieu]) && debut <= fin)
		{
			if (pRecherche.compareTo(pTab[milieu].toString()) > 0)
			{
				debut = milieu + 1;
			}
			else
			{
				if (pRecherche.compareTo(pTab[milieu].toString()) != 0)
				{
					fin = milieu - 1;
				}
			}
			milieu = (debut + fin) / 2;
		}
		if (debut > fin)
		{
			succes = true;
		}
		else
		{
			succes = false;
		}
		return succes;
	}

	public static void main(String[] argument)
	{
		int nbSaisies; // nombre de saisies
		String recherche; // nom recherché
		String[] tab; // tableau

		System.out.print("Nombre de saisies : ");
		nbSaisies = Lire.i();
		System.out.print("Nom recherché : ");
		recherche = Lire.S();
		tab = saisirValeurs(nbSaisies);
		Arrays.sort(tab, 0, tailleTableau(tab));
		if (rechercheDichotomique(tab, recherche))
		{
			System.out.println("Oui");
		}
		else
		{
			System.out.println("Non");
		}
	}
}
