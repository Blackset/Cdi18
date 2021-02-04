/*  Classe      : Dichotomie
    Auteur      : Yann Capelli	
    Mise � jour : 17 Ocotbre 2016
    Fonction    : Permet de rechercher par dichotomie d'un entier dans un tableau
*/
public class Dichotomie
{		
	private static final int MAX = 4;

	public static void main(String[] argument)
	{
		int [] tabNombre = new int [MAX];  	// Liste d'entier 
		int nombreCible;					// Entier que l'on cherche dans la liste
		int estIndice;						// Indice dans la liste du prenom recherch�
		
		System.out.println("Saisir le chiffre a rechercher dans la liste :");
		nombreCible = Lire.i();
		TriBulle.saisieTab(tabNombre);
		TriBulle.triBulle(tabNombre, tabNombre.length);
		estIndice =recherche (tabNombre,nombreCible);
		if (estIndice==0)
		{
			System.out.println("Le chiffre n'est pas dans la liste");
		}
		else
		{
			System.out.println("Le chiffre est dans la liste � l'indice : "+estIndice);
		}
	}	
	
	public static int recherche (int [] tabNombre , int nombreCible )
	{	
		// Procedure qui recherche un pr�nom dans une liste class� par ordre alphab�thique 
		// tabNombre est la liste des entier
		// nombreCible est l'entier recherch� 
		// Med est l'indice dans la tableau de l'entier recherch�
		
		int Med;		// Valeur mediane d'un indice d'une liste
		int iDebut=1;		// Indice du debut de la recherche
		int iFin= tabNombre.length;		// Indice de fin de la recherche
		
		Med = (iDebut+iFin) / 2;		// Recherche du milieu de la liste
		System.out.println("Med : "+Med);
		while ( iDebut < iFin && tabNombre[Med]!=nombreCible)	// Boucle tant qu'il ne reste pas que une ligne ou que le prenom est trouv�
		{
			if (nombreCible>tabNombre[Med])
			{
				iDebut = Med +1;		// Zone de recherche dirig� vers le bas de la liste par rapport au median
			}
			else
			{
				iFin = Med -1;			// Zone de recherche dirig�e vers le haut de la liste par rapport au median
			}
			Med = (iDebut+iFin) / 2;
		}
		System.out.println("Med : "+Med);
		if (iDebut > iFin)		// Si le prenom est absent
		{
			Med = 0 ;
		}		
		return (Med);
	}
	


}