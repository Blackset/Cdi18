/*  Classe      : Multiple
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : Calcule les N premiers multiple d'un nombre X
*/
public class Multiple
{

	public static void main(String[] argument)
	{

		int nombre; 			// Entier numero 1
		int nombreMultiple; 	// Nombre de multiple a afficher		
		
		// Affichage de la version
		System.out.println("****Multiple (V1.0, 11/10/16)****");		
		
		// Saisie du chiffre 
		System.out.println("Entrez le 1e chiffre ");
		nombre = Lire.i();
		// Saisie du nombre de multiple
		System.out.println("Entrez le nombre de multiples :");
		nombreMultiple = Lire.i();
		//Calcul des multiple de nombre
		for (int i=1 ; i<=nombreMultiple;i++)
		{
			System.out.println(nombre*i);
		}		
	}

}