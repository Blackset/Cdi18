// class : Calculette
// Ce programme est une calculette améliorée. On saisit 2 nombres et un opérateur et on renvoie le résultat.

public class Calculette {

	private static final int MAX = 1000;

	public static void main(String[] args) {		
		
		int nombre1 ;		// premier nombre saisi par l'utilisateur
		int nombre2 ;		// second nombre saisi par l'utilisateur
		int result ;		// variable de stockage du résultat
		char operateur ;	// opérateur choisi
		
		
		
		System.out.println ("*** Calculette améliorée, permettant d'effectuer plusieurs calculs à la suite. ***");
		System.out.print ("\t\t Version 3.0 ");
		System.out.println ("");
		System.out.println ("");
		System.out.println ("");
		
		do {
		
			// Lecture et controle du premier nombre
			System.out.print ("Tapez votre nombre compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
			nombre1 = Lire.i();
			System.out.println ("");
			System.out.println ("");
		
			if(nombre1 < -MAX || nombre1 > MAX)		// Nombre donné hors des bornes acceptées : erreur
			{
				nombre1 = 0;		//on fixe le nombre à 0 d'office
				System.out.print ("Erreur, votre nombre n'est pas compris dans l'intervalle [" + -MAX + " , " + MAX + " ]");
				System.out.println ("");
			}
		
			// Lecture de l'opérateur jusqu'à validité
			do
			{
				System.out.print ("Tapez votre opérateur [+, -, *, /] : ");
				operateur = Lire.c();
				System.out.println ("");
			} while (operateur != '+' && operateur != '-' && operateur != '/' && operateur != '*');		// condition d'arrêt : l'opérateur tapé est l'un des quatre attendus
	
			System.out.println ("");
		
			
		
			// Lecture et controle du second nombre
			System.out.print ("Tapez votre nombre compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
			nombre2 = Lire.i();
			System.out.println ("");
			System.out.println ("");
		
			if(nombre2 < -1000 || nombre2 > 1000)		// Nombre donné hors des bornes acceptées : erreur
			{
				nombre2 = 0;		//on fixe le nombre à 0 d'office
				System.out.print ("Erreur, votre nombre n'est pas compris dans l'intervalle [" + -MAX + " , " + MAX + " ]");
				System.out.println ("");
			}
		
		
			// On effectue l'opération demandée
			switch (operateur)
			{
				case '+' : 
					result = nombre1 + nombre2 ;
					break;
		
				case '-' :
					result = nombre1 - nombre2 ;
					break;
				
				case '*' :
					result = nombre1 * nombre2;
					break;
				
				case '/' :
					if (nombre2 == 0)		// Test de la division par 0
					{
						System.out.print ("Erreur, vous essayez de diviser par 0 ou par un nombre hors de l'intervalle [" + -MAX + " , " + MAX + " ] : ");
						result = 0;
					}
					else
						result = nombre1 / nombre2 ;		// la division est valide
					break;
		
				default :		// aucun des opérateurs valides n'a été trouvé, normalement impossible
					System.out.println ("Erreur, le contrôle de l'opérateur a échoué, le programme est disfonctionnnel");
					System.out.println ("");
					result = 0 ;
			}
		
		
			// affichage du résultat.
			System.out.println ("");
			System.out.println ("Le résultat de l'opération " + nombre1 + " " + operateur + " " + nombre2 + " est " + result);
		
		} while (Dialogue.veutContinuer()) ;
		

	}

}
