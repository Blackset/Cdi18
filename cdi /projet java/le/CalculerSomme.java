
public class CalculerSomme
{
	private static final int DECIMAL = 10;

	public static int calculerSomme(String pPhrase, int pBase)
	{
		int resultat = 0; // résultat du calcul

		for (String nombre : pPhrase.replaceAll("\\s+", " ").split("[^\\w]"))
		{
			resultat += Integer.parseInt(Integer.toString(Integer.parseInt(nombre, pBase), DECIMAL));
		}
		return resultat;
	}

	public static void main(String[] argument)
	{
		String phrase; // suite de nombres saisie
		int base; // base à convertir

		System.out.print("Saisir une suite de nombres : ");
		phrase = Lire.S();
		System.out.print("Saisir une base de calcul : ");
		base = Lire.i();
		System.out.println("Résultat : " + calculerSomme(phrase, base));
	}
}
