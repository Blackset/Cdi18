
public class CalculeJeune
{
	// CONSTANTES
	public static final int AGEJEUNE = 20; // Les jeunes ont moins de AGEJEUNE
	public static final int PANEL = 20; // Le nombre de personne interrogée sur
										// leur age

	public static void main(String[] args)
	{

		System.out.println();
		System.out.println("**** CalculeJeune (V1.0, 12/10/2016) ****");
		System.out.println();
		System.out.println(
				"Calcule toutes les personnes d'âge inférieur strictement à vingt ans\nparmi un échantillon donné de vingt personnes.");
		System.out.println();

		// VARIABLES
		int nbrJeune = 0; // Nombre de jeune
		int agePersonne = 0; // Age de la personne intérrogé

		for (int i = 1; i < PANEL; i++)
		{
			// arrêt quand toute les personnes du panel ont été interrogées
			System.out.println("PERSONNE " + i + ": Qu'elle est votre age ? ");

			agePersonne = Lire.i();

			if (agePersonne < AGEJEUNE)
			{
				nbrJeune++;
			}
		}

		System.out.println("Il y a " + nbrJeune + " jeune(s) dans ce panel.");

		System.out.println("Programme terminé");

		// On quitte le programme
		System.exit(0);

	}

}
