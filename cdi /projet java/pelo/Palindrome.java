/*  Classe      : palindrome
    Auteur      : Yann Capelli	
    Mise à jour : 17 Ocotbre 2016
    Fonction    : Permet verifier si une phrase est un palindrome ou non
*/
public class Palindrome
{	

	public static void main(String[] argument)
	{
		String phrase;		// Phrase à tester
				
		System.out.println("Veuillez rentrer la phrase a tester :");
		phrase = Lire.S();
		if (estPalindrome(phrase))
		{
			System.out.println("La chaine de caractère est bien un palindrome");
		}
		else
		{
			System.out.println("La chaine de caractère n'est pas un palindrome");
		}
	}
		
	public static boolean estPalindrome (String phrase)
	{				
		int nbCaractere = compterCaractere.compterCarac(phrase);
		int i=0;
		boolean estPalindrome = true;	
		while (i<nbCaractere && estPalindrome)
		{
			if (phrase.charAt(i) == phrase.charAt(nbCaractere-1))
			{				
				i++;
				nbCaractere--;
			}
			else
			{
				estPalindrome = false;
			}
		}
		
		return estPalindrome;
	}
	
}