package exercice;

public class Jeunesse2
{
	public static int Limbasse = 20;
	public static int Limhaute = 40;
	public static int Terminal = 100;

	public static void main(String[] arg)
	{
		int nbJeunes = 0;
		int Nbvieux = 0;
		int Nbmoyen = 0;
		int Age;
		do
		{
			System.out.print("Entrez votre age svp");
			Age = Lire.i();
			if (Age < Limbasse)
			{
				nbJeunes = nbJeunes + 1;
			}
			else if (Age > Limhaute)
			{
				Nbvieux = Nbvieux + 1;
			}
			else
			{
				Nbmoyen = Nbmoyen + 1;
			}
		} while (Age <= Terminal);

		System.out.print("Le nombre de jeunes est: " + nbJeunes);
		System.out.print("Le nombre de vieux est: " + Nbvieux);
		System.out.print("le nombre de moyen est: " + Nbmoyen);

	}
}
