/*  Classe      : Remplissage tableau
    Auteur      : Yann Capelli	
    Mise à jour : 12 Ocotbre 2016
    Fonction    : Permet de remplir un tableau de taille fixe avec une chaine de caractère terminer par un point
*/
public class RemplissageTableau
{
	
	private static final int MAX = 80;
	private static final char CARACSTOP = '.';

	public static void main(String[] argument)
	{
		char[]Tab = new char [MAX];	
		Tab=remplirTab();
		Lire.afficheTableau(Tab);			
	}
	public static char[] remplirTab ()
	{
		String phrase;
		int i=0;
		char[] Tableau = new char [MAX];		
		System.out.println("Saisir une phrase :");
		phrase = Lire.S();	
		while ( i<phrase.length() && i<MAX-1 && phrase.charAt(i) != CARACSTOP)
		{
			Tableau[i] = phrase.charAt(i);		
			i++;
		}		
		Tableau[i] = CARACSTOP;		
		return Tableau;
		
	}
	
	

}