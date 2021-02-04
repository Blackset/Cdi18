/*  Classe      : compterLettre
    Auteur      : Yann Capelli	
    Mise à jour : 13 Ocotbre 2016
    Fonction    : Permet de compter le nombre des fois qu'apparait une lettre dans une phrase
*/
public class compterLettre
{	
	private static final char CARACSTOP = '.';
	private static final char CARACTERECIBLE = 'a';

	public static void main(String[] argument)
	{
		String phrase;		// Phrase à tester
		int i=0;			// Indice de parcours de texte
		int nbCaractere=0;	// Nombre de caractere cible rencontrés			
		
		
		System.out.println("Veuillez rentrer la phrase a tester :");
		phrase = Lire.S();
		while (phrase.charAt(i)!=CARACSTOP)
		{
			if (phrase.charAt(i)==CARACTERECIBLE)
			{
				nbCaractere ++;
			}
			i++;
		}
		System.out.println("Il y a "+nbCaractere + " fois la lettre "+ CARACTERECIBLE+ " dans la phrase.");
	}
	
}