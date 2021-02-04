/*  Classe      : TriBullle
    Auteur      : Yann Capelli	
    Mise à jour : 17 Ocotbre 2016
    Fonction    : Permet verifier si une phrase est un palindrome ou non
*/
public class TriBulle
{	
	private static final int MAX = 100;
	public static void main(String[] argument)
	{
		int [] tab = new int [MAX];
		int longTab ;
		longTab =saisieTab(tab);
		triBulle(tab, longTab);
		affichageTab(tab, longTab);
	}
	
	public static int saisieTab (int [] tab)
	{
		// Procédure de saisie d'un tableau d'entier
		// Tab est le tableau que l'on souhaite remplir
		// LongTab est la longueur de Tab
		// Initialisation
		int i = 0;
		int longueur;
		System.out.println("Veuillez saisir le nombre de chiffre a rentrer dans le tableau :");
		longueur = Lire.i();
		while (i<longueur)
		{
			System.out.println("Saisir le chiffre numero : "+ i);
			tab[i] = Lire.i();
			i++;
		}
		return (longueur);
	}
	
	public static void affichageTab (int []tab , int longTab)
	{
		// Procédure qui affiche les données du tableau
		// Tab est le tableau a afficher 
		// LongTab est la longueur de Tab
		int i=0;
		while (i<longTab)
		{
		 System.out.println(tab[i] + " ");
		 i++;
		}		
	}
	public static void triBulle (int []tab , int longTab)
	{
		// Procédure qui trie les nombre d'un tableau par ordre croissant
		// Tab est le tableau que l'ont souhaite trier
		// LongTab est la longueur du tableau
		int i = 0;			// Indice de parcours du tableau
		int tampon=0 ;		// Variable servant de tampon pour l'inversion
		boolean modif;		// Booléen permettant de savoir si il y a eu une modification du tableau ou non
		
		do					// Boucle permettant de repeter le traitement tant que des modification sont faites
		{					
			modif = false;
			for(i=0;i<longTab-1;i++)
			{
				if(tab[i]>tab[i+1])	// Boucle qui parcours le tableau jusqu'a la fin
				{					
					tampon = tab[i];	// Inverse la valeur courante de l'indice i du tableau avec la valeur a i+1
					tab[i] = tab[i+1];
					tab[i+1] = tampon;
					modif = true;
				}				
			}
			longTab -- ;
		}
		while (modif);		
	}
	
	
}