
public class TriBulle
{
	private static final int TAILLE = 6; // taille du tableau

	public static int[] saisirValeurs(int pNbSaisies)
	{
		int[] tab = new int[TAILLE];

		for (int i = 0; i < pNbSaisies; i++)
		{
			System.out.print("Saisir un entier : ");
			tab[i] = Lire.i();
		}
		return tab;
	}

	public static int[] triBulle(int[] pTab, int pNbSaisies)
	{
		boolean modif; // teste si les valeurs ont été inversées

		do
		{
			modif = false;
			for (int i = 0; i < pNbSaisies - 1; i++)
			{
				if (pTab[i] > pTab[i + 1])
				{
					int sauv = pTab[i];
					pTab[i] = pTab[i + 1];
					pTab[i + 1] = sauv;
					modif = true;
				}
			}
			pNbSaisies--;
		} while (modif);
		return pTab;
	}

	public static void afficherTableau(int pNbSaisies, int[] pTab)
	{
		for (int i = 0; i < pNbSaisies; i++)
		{
			System.out.print(pTab[i] + " ");
		}
	}

	public static void main(String[] argument)
	{
		int nbSaisies; // nombre de saisies

		System.out.print("Nombre de saisies voulues : ");
		nbSaisies = Lire.i();
		afficherTableau(nbSaisies, triBulle(saisirValeurs(nbSaisies), nbSaisies));
	}
}
