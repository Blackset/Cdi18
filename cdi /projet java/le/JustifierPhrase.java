
public class JustifierPhrase
{
	private static final int TAILLE = 80;
	private static final char ESPACE = ' ';

	public static String justifierPhrase(String pPhrase)
	{
		String phraseJustifiee = ""; // phrase justifiée
		String[] mots = pPhrase.split("[^\\w]"); // tableau de mots
		int nbEspaces = (pPhrase.length() - pPhrase.replace(" ", "").length()) + (TAILLE - pPhrase.length()); // nombre
																												// d'espaces
		int reste = nbEspaces % (mots.length - 1); // reste d'espaces à placer

		for (String mot : mots)
		{
			phraseJustifiee += mot;
			for (int i = 0; i < nbEspaces / (mots.length - 1); i++)
			{
				if (mot != mots[mots.length - 1])
				{
					phraseJustifiee += ESPACE;
					if (reste > 0)
					{
						phraseJustifiee += ESPACE;
						reste--;
					}
				}
			}
		}
		return phraseJustifiee;
	}

	public static void main(String[] argument)
	{
		String phrase; // phrase saisie

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		phrase = (phrase.length() > TAILLE) ? phrase.substring(0, TAILLE) : phrase;
		System.out.println(justifierPhrase(phrase));
	}
}
