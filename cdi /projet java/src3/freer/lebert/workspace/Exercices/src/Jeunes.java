
public class Jeunes
{
	private static final int JEUNE = 20; // age des jeunes
	private static final int ECHANTILLON = 20; // nombre de personnes à interroger

	public static void main(String[] argument)
	{
		int nbJeunes = 0; // nombre de jeunes

		for (int i = 1; i <= ECHANTILLON; i++)
		{
			System.out.print("Age de la personne " + i + " : ");
			if (Lire.i() < JEUNE)
			{
				nbJeunes++;
			}
		}
		System.out.println("Nombre de jeunes : " + nbJeunes);
	}
}
