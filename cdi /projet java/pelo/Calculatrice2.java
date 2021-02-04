/*  Classe      : Calculatrice2
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : Calculatrice
*/
public class Calculatrice2
{

	public static void main(String[] argument)
	{

		int nombre1; 	// Entier numero 1
		int nombre2; 	// Entier numero 2
		int resultat=0;	// Resultat de l'operation
		char operateur;	// Operateur 
		
		// Affichage de la version
		System.out.println("****Calculatrice (V1.1, 11/10/16)****");
		
		
		// Saisie du 1e chiffre 
		System.out.println("Entrez le 1e chiffre ");
		nombre1 = Lire.i();
		// Saisie du 2e chiffre
		System.out.println("Entrez le 2e chiffre ");
		nombre2 = Lire.i();
		// Saisie de l'operateur
		System.out.println("Entrez l'operateur souhaité (+,-,*,/) : ");
		operateur = Lire.c();		
		// Traitement de differente operation et de la division par 0
		switch (operateur)
		{
				case '+' : resultat = nombre1 + nombre2;
							break;
				case '-' : resultat = nombre1 - nombre2;
							break;
				case '*' : resultat = nombre1 * nombre2;
							break;
				case '/' : if ((operateur=='/')&&(nombre2==0))
							{
								System.out.println("ERREUR : Division par 0 impossible ");			
							}
							else
							{
								resultat = nombre1 / nombre2;
							}
							break;
				default : System.out.println("ERREUR : Entrez operateur valide (+,-,*,/) ");
							resultat =0;
		}
		// Affichage du résultat
		System.out.println(nombre1+""+operateur+""+nombre2+"="+resultat);
		
		

	}

}