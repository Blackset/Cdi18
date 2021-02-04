/*  Classe      : ManipMatice
    Auteur      : Yann Capelli	
    Mise à jour : 20 Ocotbre 2016
    Fonction    : Transpose une matrice représenté par un tableau en 2 dimensons
*/
public class ManipMatrice
{
	public static void main(String[] argument)
	{
		int [][] m = new int [4][3];
		int [][] mT = new int [3][4];
		int incr =1 ;
		
		// Creation de la matrice en 4x3
		for (int i=0 ; i < m.length;i++)
		{
			for (int j =0 ; j<m[i].length;j++)
			{
				m[i][j] = incr++;
			}
		}
		// Creation de la matrice transposé en 3x4 par rapport a la premiere matrice
		for (int i=0 ; i < m.length;i++)
		{
			for (int j =0 ; j<m[i].length;j++)
			{
				mT[j][i] = m[i][j];
			}
		}
		
		// AFFICHAGE DES TABLEAU
		for (int i=0 ; i < m.length;i++)
		{
			for (int j =0 ; j<m[i].length;j++)
			{
				System.out.print(m[i][j]+ "\t");
			}
			System.out.println();
		}		
		
		for (int i=0 ; i < mT.length;i++)
		{
			for (int j =0 ; j<mT[i].length;j++)
			{
				System.out.print(mT[i][j]+ "\t");
			}
			System.out.println();
		}	
		
		
			
	}
	public static int [][] creerMat ()
	{
		// Foncion qui creer une matrice de taille definie par l'uilisateur et la rempli
		// Retourne la matrice 
		
		
		return null;
		
	}
	
}