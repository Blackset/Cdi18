
public class Jeunes2
{
	private static final int JEUNE = 20; // age des jeunes
	private static final int MOYEN = 40; // age des moyens
	private static final int CENTENAIRE = 100; // age du centenaire

	public static void main(String[] argument)
	{
		int nbJeunes = 0; // nombre de jeunes
		int nbMoyens = 0; // nombre de moyens
		int nbVieux = 0; // nombre de vieux
		int age; // age saisi

		do
		{
			System.out.print("Age : ");
			age = Lire.i();
			if (age < JEUNE)
			{
				nbJeunes++;
			}
			else if (age < MOYEN)
			{
				nbMoyens++;
			}
			else
			{
				nbVieux++;
			}
		} while (age < CENTENAIRE);
		System.out.println("Nombre de jeunes : " + nbJeunes);
		System.out.println("Nombre de moyens : " + nbMoyens);
		System.out.println("Nombre de vieux : " + nbVieux);
	}
}
