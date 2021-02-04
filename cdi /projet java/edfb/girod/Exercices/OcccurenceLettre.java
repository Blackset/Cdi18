/*************************************************************************
 * Programme : OccurenceLettre.java - Auteur : EGI 
 * Date : 10/2016 
 * Fonction : Programme compter l'occurence d'une lettre dans 
 * une phrase termin�e par un '.'
 ************************************************************************/
public class OcccurenceLettre {

	public static void main (String arg [] )
	{

		final char CARCIBLE = 'a';  // caract�re dont les occurrences sont compt�es
		final char CARTEM = '.';  // caract�re indiquant la terminaison de la cha�ne
		final int TAILLE = 80;		// nombre maximum de caract�res dans la cha�ne
		
		char[] phrase = new char[TAILLE]; // tableau de caract�re qui sera remplie							

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
		
		System.out.println  ("Le nombre de caract�res " + CARCIBLE + " dans phrase est " + compteur);
		

	}

}
