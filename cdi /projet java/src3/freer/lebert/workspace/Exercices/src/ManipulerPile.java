
class Pile
{
	public static final int TAILLE = 100;

	int[] tab = new int[TAILLE];
	int indice = 0;

	public static boolean empiler(Pile pPile, int pVal)
	{
		boolean succes = false;

		if (pPile.indice < Pile.TAILLE)
		{
			pPile.tab[pPile.indice + 1] = pVal;
			pPile.indice++;
			succes = true;
		}
		return succes;
	}

	public static boolean depiler(Pile pPile, Entier pVal)
	{
		boolean succes = false;

		if (pPile.indice > 0)
		{
			pVal.setVal(pPile.tab[pPile.indice]);
			pPile.indice--;
			succes = true;
		}
		return succes;
	}
}

public class ManipulerPile
{
	public static void main(String[] argument)
	{
		Pile pile = new Pile();
		int val1;
		Entier val2 = new Entier();

		do
		{
			System.out.print("Saisir valeur à empiler : ");
			val1 = Lire.i();
			System.out.println((Pile.empiler(pile, val1)) ? val1 + " a été empilé." : "Tableau plein.");
		} while (Dialogue.veutContinuer());
		do
		{
			System.out.println((Pile.depiler(pile, val2)) ? val2.getVal() + " a été dépilé." : "Tableau vide.");
		} while (Dialogue.veutContinuer());
	}
}
