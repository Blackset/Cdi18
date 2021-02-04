// Class calculette
// Ce programme est une calculette par ligne de commande, selon les prescriptions suivantes :
// Saisit une op�rande valide
// Saisit un op�rateur valide
// Saisit une seconde op�rande valide
// Effectue le calcul
// Affiche le r�slutat

public class Calculette {

	public static void main(String[] args) 
	{
	
		int op1 ;										// Op�rande 1, dans un intervalle donn�
		int op2 ;										// Op�rande 2, dans un intervalle donn�
		char operateur ;								// op�rateur +, -, / ou *
		boolean possible ;								// L'op�ration est-elle possible : division par 0 !
		Entier resultat = new Entier() ;				// R�sultat de l'op�ration, 0 si elle est impossible.
	
	
		System.out.println ("*** Calculette permettant d'effectuer les quatres op�rations de base. ***");
		System.out.print ("\t\t Projet de synth�se. Version 4.0 ");
		System.out.println ("");
		System.out.println ("");
		System.out.println ("");
	
	
		op1 = Calcul.saisirOp�rande(1) ;
		operateur = Calcul.saisirOperateur() ;
		op2 = Calcul.saisirOp�rande(2) ;
	
		possible = Calcul.effectuerCalcul (op1, op2, operateur, resultat) ;		// calcul le r�sultat et renvoie si possible ou non
		Calcul.afficher(op1, op2, operateur, resultat, possible) ;
	

	}

}
