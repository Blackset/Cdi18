
public class Tableau
{
	private static final int TAILLE = 6; // taille du tableau
	private static final char FIN = '.'; // caractère terminateur

	public static int calculerTaille(String pSaisie)
	{
		int valeur; // valeur de retour

		if (pSaisie.contains(Character.valueOf(FIN).toString()))
		{
			valeur = pSaisie.indexOf(FIN);
		}
		else
		{
			if (pSaisie.length() >= TAILLE)
			{
				valeur = TAILLE;
			}
			else
			{
				valeur = pSaisie.length();
			}
		}
		return valeur;
	}

	public static void afficherTableau(String pSaisie, char[] pTab, int pTaille)
	{
		for (int i = 0; i < pTaille; i++)
		{
			pTab[i] = pSaisie.charAt(i);
		}
		if (pTaille == 0 || pTab[pTaille - 1] != FIN)
		{
			if (pTaille == TAILLE)
			{
				pTab[pTaille - 1] = FIN;
			}
			else
			{
				pTab[pTaille] = FIN;
			}
		}
		System.out.print(new String(pTab));
	}

	public static void main(String[] argument)
	{
		String saisie;
		char[] tab = new char[TAILLE];

		System.out.print("Saisir texte : ");
		saisie = Lire.S();
		Lire.Attente();
		afficherTableau(saisie, tab, calculerTaille(saisie));

	}
}
