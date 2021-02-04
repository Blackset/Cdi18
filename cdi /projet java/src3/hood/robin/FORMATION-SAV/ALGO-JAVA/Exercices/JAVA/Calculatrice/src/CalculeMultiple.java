
public class CalculeMultiple
{

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("**** CalculeMultiple (V1.0, 12/10/2016) ****");
		System.out.println();
		System.out.println("Calcule des N premiers multiples d'un nombre entier");
		System.out.println();

		// VARIABLES
		int nbrMultiple; // Nombre de multiple à trouver
		int nbr; // Nombre pour lequel on donne les multiples
		int resultat; // résultat multiplication

		System.out.print("Saisissez le nombre de multiple a chercher : ");
		nbrMultiple = Lire.i();

		System.out.println();
		System.out.print("Saisissez le nombre : ");

		nbr = Lire.i();

		System.out.println();

		for (int i = 1; i <= nbrMultiple; i++)
		{
			// arrêt quand on atteint le nombre de multiple demandé
			resultat = nbr * i;
			System.out.println(nbr + " X " + i + " = " + resultat);
		}

		System.out.println("Programme terminé");

		// On quitte le programme
		System.exit(0);
	}

}
