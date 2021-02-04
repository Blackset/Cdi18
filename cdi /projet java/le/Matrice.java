
public class Matrice
{
	private static final int LIGNE = 4;
	private static final int COLONNE = 3;

	public static void saisirValeurs(int[][] pM)
	{
		int nb = 0;
		for (int i = 0; i < pM.length; i++)
		{
			for (int j = 0; j < pM[i].length; j++)
			{
				pM[i][j] = ++nb;
			}
		}
	}

	public static void afficherValeurs(int[][] pM)
	{
		for (int i = 0; i < pM.length; i++)
		{
			String ligne = "";
			for (int j = 0; j < pM[i].length; j++)
			{
				ligne += pM[i][j] + "\t";
			}
			System.out.println(ligne);
		}
	}

	public static int[][] transposer(int[][] pM)
	{
		int[][] Mt = new int[COLONNE][LIGNE]; // matrice transposée

		for (int i = 0; i < COLONNE; i++)
		{
			for (int j = 0; j < LIGNE; j++)
			{
				Mt[i][j] = pM[j][i];
			}
		}
		return Mt;
	}

	public static void main(String[] argument)
	{
		int[][] M = new int[LIGNE][COLONNE]; // matrice

		saisirValeurs(M);
		System.out.println("Matrice M");
		afficherValeurs(M);
		System.out.println("Matrice Mt");
		afficherValeurs(transposer(M));
	}
}
