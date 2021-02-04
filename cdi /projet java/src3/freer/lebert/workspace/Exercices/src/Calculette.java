
public class Calculette
{
	private static final int MIN = -1000; // valeur minimum
	private static final int MAX = 1000; // valeur maximum

	public static void main(String[] argument)
	{
		int nombre; // nombre saisi par l'utilisateur

		System.out.print("Saisir un nombre compris entre " + MIN + " et " + MAX + " : ");
		nombre = Lire.i();
		if (nombre < MIN || nombre > MAX)
		{
			nombre = 0;
			System.out.println("Erreur : valeur hors norme");
		}
		else
		{
			System.out.println("OK");
		}
	}
}
