
class Pile
{
	public int[] entier = new int[Constantes.TAILLEPILE];
	public int indice;
}

public class PileEntier
{

	/**
	 * @param lifo
	 *            pile à initialiser
	 * @return la pile initialiser
	 */
	public static Pile init(Pile lifo)
	{
		lifo.indice = -1;

		return lifo;
	}

	/**
	 * @param lifo
	 *            pile dans laquelle on ajoute un entier
	 * @param entier
	 *            l'entier ajouté
	 * @return retourne vrai si l'élément est ajouté, faux si la pile est pleine
	 */
	public static boolean empiler(Pile lifo, int entier)
	{
		boolean ok = false;

		if (lifo.indice < lifo.entier.length - 1)
		{
			lifo.indice++;
			lifo.entier[lifo.indice] = entier;
			ok = true;
		}

		return ok;
	}

	/**
	 * @param lifo
	 *            la pile dans laquel on récupère le dernier élément rentré
	 * @param nbr
	 *            l'entier récupéré
	 * @return retourne vrai si l'élément est récupéré, faux si la pile est vide
	 */
	private static boolean depiler(Pile lifo, Entier nbr)
	{
		boolean ok = false;

		if (lifo.indice > -1)
		{
			nbr.setVal(lifo.entier[lifo.indice]);
			lifo.indice--;
			ok = true;
		}

		return ok;
	}

	/**
	 * @param lifo
	 *            la pile a afficher
	 */
	private static void afficher(Pile lifo)
	{
		System.out.print("La pile | ");

		for (int i = 0; i < lifo.entier.length; i++)
		{
			System.out.print(lifo.entier[i] + " | ");
		}
		System.out.println();
	}

	public static void menu()
	{
		Pile lifo = new Pile();
		Entier nbr = new Entier();
		char saisie;

		init(lifo);

		do
		{
			System.out.println();
			System.out.print("Tapez 'e' pour empiler, 'd' pour dépiler, 'a' pour afficher, 'q' pour quitter : ");
			System.out.println();

			saisie = Character.toLowerCase(Lire.c());

			switch (saisie)
			{
			case 'e':
				if (empiler(lifo, Tools.saisieEntier()))
				{
					System.out.println("Elément empilé");
				}
				else
				{
					System.out.println("Pile pleine");
				}
				break;
			case 'd':
				if (depiler(lifo, nbr))
				{
					System.out.println("Elément depilé : " + nbr.getVal());
				}
				else
				{
					System.out.println("Pile vide");
				}
				break;
			case 'a':
				afficher(lifo);
				break;
			case 'q':
				System.out.println("Terminé");
				break;
			default:
				System.out.println("Erreur de saisie.");
				break;
			}
		}
		while (saisie != 'q');
	}

}
