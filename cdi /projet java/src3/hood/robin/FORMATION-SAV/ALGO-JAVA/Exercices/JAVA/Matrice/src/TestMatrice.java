
public class TestMatrice
{

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("**** TestMatrice (V1.0, 24/10/2016) ****");
		System.out.println();
		System.out.println("Ce programme doit transposer une matrice, "
				+ "représentée par un tableau à deux dimensions.");

		
		// remplissage de la matrice
		int [][]tabEntier = Tools.remplirMatrice();

		// Affichage de la matrice
		Tools.afficherMatrice(tabEntier);

		// Affichage de la nouvelle matrice
		Tools.afficherMatrice(Tools.transposeMatrice(tabEntier));

	}

}
