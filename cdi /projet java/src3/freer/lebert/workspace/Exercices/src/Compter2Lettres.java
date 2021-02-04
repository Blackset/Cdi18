
public class Compter2Lettres
{
	public static int compter2Lettres(String pPhrase, char pLettre1, char pLettre2)
	{
		int valeur = 0; // valeur de retour

		for (int i = 0; i < pPhrase.length() - 1; i++)
		{
			if (pPhrase.charAt(i) == pLettre1 && pPhrase.charAt(i + 1) == pLettre2)
			{
				valeur++;
			}
		}
		return valeur;
	}

	public static void main(String[] argument)
	{
		String phrase; // phrase saisie par l'utilisateur
		char lettre1; // premi�re lettre saisie par l'utilisateur
		char lettre2; // deuxi�me lettre saisie par l'utilisateur

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		System.out.print("Saisir la premi�re lettre recherch�e : ");
		lettre1 = Lire.c();
		System.out.print("Saisir la deuxi�me lettre recherch�e : ");
		lettre2 = Lire.c();
		System.out.println("Le couple de lettres " + lettre1 + "" + lettre2 + " apparait "
				+ compter2Lettres(phrase, lettre1, lettre2) + " fois.");
	}
}
