/*  Classe      : Dichotomie
    Auteur      : Yann Capelli	
    Mise à jour : 17 Ocotbre 2016
    Fonction    : Permet de rechercher par dichotomie d'un entier dans un tableau
*/
public class Dichotomie
{		
	private static final int MAX = 4;

	public static void main(String[] argument)
	{
		int [] tabNombre = new int [MAX];  	// Liste d'entier 
		int nombreCible;					// Entier que l'on cherche dans la liste
		int estIndice;						// Indice dans la liste du prenom recherché
		
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
			System.out.println("Le chiffre est dans la liste à l'indice : "+estIndice);
		}
	}	
	
	public static int recherche (int [] tabNombre , int nombreCible )
	{	
		// Procedure qui recherche un prénom dans une liste classé par ordre alphabéthique 
		// tabNombre est la liste des entier
		// nombreCible est l'entier recherché 
		// Med est l'indice dans la tableau de l'entier recherché
		
		int Med;		// Valeur mediane d'un indice d'une liste
		int iDebut=1;		// Indice du debut de la recherche
		int iFin= tabNombre.length;		// Indice de fin de la recherche
		
		Med = (iDebut+iFin) / 2;		// Recherche du milieu de la liste
		System.out.println("Med : "+Med);
		while ( iDebut < iFin && tabNombre[Med]!=nombreCible)	// Boucle tant qu'il ne reste pas que une ligne ou que le prenom est trouvé
		{
			if (nombreCible>tabNombre[Med])
			{
				iDebut = Med +1;		// Zone de recherche dirigé vers le bas de la liste par rapport au median
			}
			else
			{
				iFin = Med -1;			// Zone de recherche dirigée vers le haut de la liste par rapport au median
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