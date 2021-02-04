// Class TestLireChaine
// Ce programme teste la fonction public static void LireChaine(char [] leTableau, int tailleTab)

public class TestLireChaine
{

	private static final int TAILLETAB = 10;		// Taille maximum de la cha�ne de caract�res.
	public static final char CARTERMINATEUR = '.';			// Caract�re terminateur.

	public static void main(String[] args)
	{
		
		char [] monTableau ;
		// int tailleTab = TAILLETAB ;
		
		monTableau = new char [TAILLETAB] ;		// On alloue la m�moire.
		LireChaine.lireChaine(monTableau, TAILLETAB, CARTERMINATEUR);
		
		LireChaine.afficherChaine(monTableau, TAILLETAB, CARTERMINATEUR) ;

	}

}
