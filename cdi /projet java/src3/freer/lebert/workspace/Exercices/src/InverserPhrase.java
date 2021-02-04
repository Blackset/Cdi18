
public class InverserPhrase
{
	private static final int TAILLE = 20;
	private static final char ESPACE = ' ';
	private static final char FIN = '.';

	public static String inverserPhrase(String pPhrase)
	{
		String phraseInverse = ""; // phrase inversée
		String[] mots = new String[TAILLE]; // liste des mots

		mots = pPhrase.trim().replaceAll("\\.", "").replaceAll("\\s+", " ").split(" ");
		for (int i = 0; i < mots.length; i++)
		{
			phraseInverse += new StringBuffer(mots[i]).reverse();
			if (i < mots.length - 1)
			{
				phraseInverse += ESPACE;
			}
		}
		phraseInverse += FIN;
		return phraseInverse;
	}

	public static void main(String[] argument)
	{
		String phrase; // phrase saisie

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		System.out.print(inverserPhrase(phrase));
	}
}
