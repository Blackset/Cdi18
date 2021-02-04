                                                                                     /*************************************************************************
 * Les tableaux
 * Exercice 1 page 72 / ProgJava.pdf
 ***************************************************************************/
public class Exercice1
{
	public static void main (String arg [] )
	{

		final int MAX = 8;  // taille du tableau
		char[] tabCaracs = new char[MAX]; // tableau de caractère qui sera remplie
										// déclaration d'une référence sur un tableau de caractères

		System.out.println ("*** Tableaux Exercice 1 ***");
		System.out.println ();
		
		tabCaracs = ProcedureSaisirTableau.SaisirTableau(MAX);
			
		
		System.out.println  (tabCaracs);
		
		// Lire.Attente ();
		// Lire.Purge();
	}

}
