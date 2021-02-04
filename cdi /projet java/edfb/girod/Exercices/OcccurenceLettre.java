/*************************************************************************
 * Programme : OccurenceLettre.java - Auteur : EGI 
 * Date : 10/2016 
 * Fonction : Programme compter l'occurence d'une lettre dans 
 * une phrase terminée par un '.'
 ************************************************************************/
public class OcccurenceLettre {

	public static void main (String arg [] )
	{

		final char CARCIBLE = 'a';  // caractère dont les occurrences sont comptées
		final char CARTEM = '.';  // caractère indiquant la terminaison de la chaîne
		final int TAILLE = 80;		// nombre maximum de caractères dans la chaîne
		
		char[] phrase = new char[TAILLE]; // tableau de caractère qui sera remplie							

		System.out.println ("*** Tableaux Exercice 2 ***");
		System.out.println ();
		
		int i=1;
		int compteur=0;
			
		phrase = ProcedureSaisirTableau.SaisirTableau(TAILLE);
		
		while ( phrase[i] != CARTEM )
		{
				if ( phrase[i] == CARCIBLE )
				{
					compteur = compteur + 1;
				}
				i++;
		}
		
		System.out.println  ("Le nombre de caractères " + CARCIBLE + " dans phrase est " + compteur);
		

	}

}
