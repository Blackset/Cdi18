
public class NombreLettres
{
	public static void main(String[] argument)
	{
		String phrase; // phrase saisie par l'utilisateur

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		System.out.print("La phrase compte " + phrase.replaceAll("[^a-zA-Z]", "").length() + " lettres.");
	}
}
