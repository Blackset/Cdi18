/*  Classe      : compterCaractere
    Auteur      : Yann Capelli	
    Mise � jour : 13 Ocotbre 2016
    Fonction    : Permet de compter le nombre de caractere dans une phrase
*/
public class compterCaractere
{	
	private static final char CARACSTOP = '.';
	

	public static void main(String[] argument)
	{
		String phrase;		// Phrase � tester
		int nbCaractere=0;	// Nombre de caractere cible rencontr�s			
		
		
		System.out.println("Veuillez rentrer la phrase a tester :");
		phrase = Lire.S();
		nbCaractere = compterCarac(phrase);
		System.out.println("Le nombre de caract�re dans la phrase est de : "+nbCaractere);
	}
		
	public static int compterCarac (String phrase)
	{				
		int nbCaractere = 0;
		int i = 0;
		while (phrase.charAt(i )!=CARACSTOP)
		{			
			nbCaractere  ++;
			i++;
		}
		return nbCaractere;
	}
	
}