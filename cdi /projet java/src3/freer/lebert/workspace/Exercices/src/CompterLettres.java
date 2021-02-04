
public class CompterLettres
{
	public static int compterLettres(String pPhrase, char pLettre)
	{
		int valeur = 0; // valeur de retour

		for (int i = 0; i < pPhrase.length(); i++)
		{
			if (pPhrase.charAt(i) == pLettre)
			{
				valeur++;
			}
		}
		return valeur;
	}

	public static void main(String[] argument)
	{
		String phrase; // phrase saisie par l'utilisateur
		char lettre; // lettre saisie par l'utilisateur

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		System.out.print("Saisir la lettre recherchée : ");
		lettre = Lire.c();
		System.out.println("La lettre " + lettre + " apparait " + compterLettres(phrase, lettre) + " fois.");
	}
}
