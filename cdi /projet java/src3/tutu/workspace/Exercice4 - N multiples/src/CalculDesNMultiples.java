// Class CalculDesNMultiples
// Ce programme calcul les N premiers multiples d'un nombre entier X donn�

public class CalculDesNMultiples {

	public static void main(String[] args) {
		
		int nombreEntier ;		// C'est mon nombre entier dont je vais calculer les multiples
		int n ;					// C'est le nombre de multiples que je dois calculer
		int multiple ;			// Variable de stockage des multiples
		
		
				
		// Annonce du programme et de la version
		System.out.println("**** Calcul des N multiples (V1.0, 12/01/01) ****");
		System.out.println ();
		
		// On r�cup�re l'entier � multiplier N fois 
		System.out.print ("Donner un nombre entier : ");
		nombreEntier = Lire.i();
		System.out.println ();
		
		// On r�cup�re le nombre de multiples souhait�s et on s'assure qu'il soit valide (>=1)
		do {
			System.out.print ("Donner le degr� de votre puissance (>= 1) : ");
			n = Lire.i();
			System.out.println ();
			}
		while (n < 1);
		
		multiple = nombreEntier ;	// Amor�age, on a pour l'instant NombreEntier exposant 1
		
		for (int i = 1 ; i <= n ; i = i + 1)		// On commence par exposant 1 puis jusqu'� N+1
		{
			System.out.println (nombreEntier + " EXP " + i + " = " + multiple);
			multiple = multiple * nombreEntier ;			
		}
		
		System.out.println ();
		System.out.println ("FIN");
		

	}

}
