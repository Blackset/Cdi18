// class : Calculette
// Ce programme est une calculette am�lior�e. On saisit 2 nombres et un op�rateur et on renvoie le r�sultat.

public class Calculette {

	public static void main(String[] args) {		
		int nombre1 ;		// premier nombre saisi par l'utilisateur
		int nombre2 ;		// second nombre saisi par l'utilisateur
		int result ;		// variable de stockage du r�sultat
		char operateur ;	// op�rateur choisi
		
		
		// Lecture et controle du premier nombre
		System.out.print ("Tapez votre nombre compris dans [-1000, 1000] : ");
		nombre1 = Lire.i();
		System.out.println ("");
		System.out.println ("");
		
		if(nombre1 < -1000 || nombre1 > 1000)		// Nombre donn� hors des bornes accept�es : erreur
		{
			nombre1 = 0;		//on fixe le nombre � 0 d'office
			System.out.println ("Erreur, votre nombre n'est pas contenu dans l'intervalle [-1000, 1000].");
			System.out.println ("");
		}
		
		// Lecture de l'op�rateur jusqu'� validit�
		do
		{
			System.out.print ("Tapez votre op�rateur [+, -, *, /] : ");
			operateur = Lire.c();
			System.out.println ("");
		} while (operateur != '+' && operateur != '-' && operateur != '/' && operateur != '*');		// condition d'arr�t : l'op�rateur tap� est l'un des quatre attendus
	
		System.out.println ("");
		
			
		
		// Lecture et controle du second nombre
		System.out.print ("Tapez votre nombre compris dans [-1000, 1000] : ");
		nombre2 = Lire.i();
		System.out.println ("");
		System.out.println ("");
		
		if(nombre2 < -1000 || nombre2 > 1000)		// Nombre donn� hors des bornes accept�es : erreur
		{
			nombre2 = 0;		//on fixe le nombre � 0 d'office
			System.out.println ("Erreur, votre nombre n'est pas contenu dans l'intervalle [-1000, 1000].");
			System.out.println ("");
		}
		
		
		// On effectue l'op�ration demand�e
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
					System.out.println ("Erreur, vous essayez de diviser par 0 ou par un nombre hors de l'intervalle [-1000, 1000].");
					result = 0;
				}
				else
					result = nombre1 / nombre2 ;		// la division est valide
				break;
		
			default :		// aucun des op�rateurs valides n'a �t� trouv�, normalement impossible
				System.out.println ("Erreur, le contr�le de l'op�rateur a �chou�, le programme est disfonctionnnel");
				System.out.println ("");
				result = 0 ;
		}
		
		
		// affichage du r�sultat.
		System.out.println ("");
		System.out.println ("Le r�sultat de l'op�ration " + nombre1 + " " + operateur + " " + nombre2 + " est " + result);
		
		

	}

}
