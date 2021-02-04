// Class calculette
// Ce programme est une calculette par ligne de commande, selon les prescriptions suivantes :
// Saisit une opérande valide
// Saisit un opérateur valide
// Saisit une seconde opérande valide
// Effectue le calcul
// Affiche le réslutat

public class Calculette {

	public static void main(String[] args) 
	{
	
		int op1 ;										// Opérande 1, dans un intervalle donné
		int op2 ;										// Opérande 2, dans un intervalle donné
		char operateur ;								// opérateur +, -, / ou *
		boolean possible ;								// L'opération est-elle possible : division par 0 !
		Entier resultat = new Entier() ;				// Résultat de l'opération, 0 si elle est impossible.
	
	
		System.out.println ("*** Calculette permettant d'effectuer les quatres opérations de base. ***");
		System.out.print ("\t\t Projet de synthèse. Version 4.0 ");
		System.out.println ("");
		System.out.println ("");
		System.out.println ("");
	
	
		op1 = Calcul.saisirOpérande(1) ;
		operateur = Calcul.saisirOperateur() ;
		op2 = Calcul.saisirOpérande(2) ;
	
		possible = Calcul.effectuerCalcul (op1, op2, operateur, resultat) ;		// calcul le résultat et renvoie si possible ou non
		Calcul.afficher(op1, op2, operateur, resultat, possible) ;
	

	}

}
