// Class TestLireChaine
// Ce programme teste la fonction public static void LireChaine(char [] leTableau, int tailleTab)

public class TestLireChaine
{

	private static final int TAILLETAB = 10;		// Taille maximum de la chaîne de caractères.
	public static final char CARTERMINATEUR = '.';			// Caractère terminateur.

	public static void main(String[] args)
	{
		
		char [] monTableau ;
		// int tailleTab = TAILLETAB ;
		
		monTableau = new char [TAILLETAB] ;		// On alloue la mémoire.
		LireChaine.lireChaine(monTableau, TAILLETAB, CARTERMINATEUR);
		
		LireChaine.afficherChaine(monTableau, TAILLETAB, CARTERMINATEUR) ;

	}

}
