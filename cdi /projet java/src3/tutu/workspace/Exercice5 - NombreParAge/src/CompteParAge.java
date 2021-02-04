
public class CompteParAge {

	public static void main(String[] args) {
		
		final int AGEMAX = 122 ; 
		
		int nombreJeunes = 0 ;			// Le nombre de jeunes trouv�s jusque l�, 0 initialement
		int nombreMoyens = 0 ;			// Le nombre de moyens trouv�s jusque l�, 0 initialement
		int nombreVieux = 0 ;			// Le nombre de vieux trouv�s jusque l�, 0 initialement
		int ageCourant ;				// L'age de la personne test�e
		
		// Affichage de la fonctionnalit� et de la version du programme
		System.out.println("**** Calcul de l'�ge (V2.0, 12/10/2016 ****");
	    System.out.println ();
		
		
		// On fait une boucle jusqu'� la rencontre d'un centenaire
		do {
			System.out.println ();
			System.out.print ("Donnez votre age : ");
			ageCourant = Lire.i();
			
			//Calcul des quotas.
			if (ageCourant > 0 && ageCourant < AGEMAX){
				if (ageCourant < 20){							//cas jeune
					nombreJeunes = nombreJeunes + 1;
				}
				else if (ageCourant < 40){						//cas moyen (&& non jeune)
					nombreMoyens = nombreMoyens + 1 ;
				}
				else {											//cas Vieux >= 40 && < AGEMAX
					nombreVieux = nombreVieux + 1 ;
				}
			}
			// Sinon, l'age est invalide, on ne le compte pas
		}
		while (ageCourant < 100 || ageCourant > AGEMAX);		// Condition d'arr�t : x > 100 ET x < AGEMAX
																// De Morgan :
																// x < 100 OU x > AGEMAX (continuit�)
		
		
		// On affiche les r�sultats
		System.out.println ();
		System.out.println ();
		System.out.println ("le nombre de jeunes test�s : " + nombreJeunes);
		System.out.println ("le nombre de moyens test�s : " + nombreMoyens);
		System.out.println ("le nombre de vieux test�s : " + nombreVieux);

	}

}
