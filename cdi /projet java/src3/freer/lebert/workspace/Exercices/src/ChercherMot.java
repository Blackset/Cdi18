
public class ChercherMot
{
	public static void main(String[] argument)
	{
		String phrase; // phrase saisie
		String mot; // mot recherch�

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		System.out.print("Mot recherch� : ");
		mot = Lire.S();
		String reponse = (phrase.matches(".*\\b" + mot + "\\b.*")) ? "Oui" : "Non";
		System.out.println(reponse);
	}
}