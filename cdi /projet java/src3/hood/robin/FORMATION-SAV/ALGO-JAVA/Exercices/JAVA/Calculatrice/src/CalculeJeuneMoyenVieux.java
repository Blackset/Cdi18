
public class CalculeJeuneMoyenVieux
{
	// CONSTANTES
	public static final int AGEJEUNE = 20; // Les jeunes ont moins de AGEJEUNE
	public static final int AGEMOYEN = 40; // Les moyens ont entre AGEJEUNE et
											// AGEVIEUX
	public static final int AGEVIEUX = 40; // Les vieux ont plus de AGEVIEUX
	public static final int CENTENAIRE = 100; // Les centenaires ont CENTENAIRE

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("**** CalculeJeuneMoyenVieux (V1.0, 12/10/2016) ****");
		System.out.println();
		System.out.println("Calcule les personnes d'âge inférieur strictement à 20 ans"
				+ "\nles personnes d'âge supérieur strictement à 40 ans"
				+ "\net celles dont l'âge est compris entre 20 ans et 40 ans (20 ans et 40 ans y compris)."
				+ "\nLe comptage est arrêté dès la saisie d'un centenaire.\nLe centenaire est compté.");
		System.out.println();

		// VARIABLES
		int agePersonne = 0; // Age de la personne interrogée
		int nbrJeune = 0; // nombre de jeune
		int nbrMoyen = 0; // nombre de moyen
		int nbrVieux = 0; // nombre de vieux

		do
		{
			System.out.println("Qu'elle est votre age ? ");
			System.out.println();

			agePersonne = Lire.i();

			if (agePersonne <= AGEMOYEN)
			{
				if (agePersonne < AGEJEUNE)
				{
					nbrJeune++;
				}
				else
				{
					nbrMoyen++;
				}
			}
			else if (agePersonne > AGEVIEUX)
			{
				nbrVieux++;
			}

		}
		while (agePersonne < CENTENAIRE);
		// arrêt quand l'age de la personne interrogée est supérieur à
		// CENTENAIRE
		System.out.println("Il y a " + nbrJeune + " jeune(s), " + nbrMoyen + " moyen(s), " + nbrVieux
				+ " vieux dont un centenaire.");
		System.out.println();

		System.out.println("Programme terminé");

		// On quitte le programme
		System.exit(0);
	}

}
