package exercice;

public class CompteCaraCible
{	
	
	private static final char CIBLE = 'a';
	private static final char FIN = '.';

	public static void main(String[] argument)
	{
		String phrase;		
				
		
		
		System.out.println("Veuillez saisre un phrase  :");
		phrase = Lire.S();
		
		int nbCara = compterLettre(phrase,CIBLE);	
		
		System.out.println("Le caractere cible est present "+nbCara+" dans la phrase");
	}

	private static int compterLettre(String phrase, char cible)
	{
		int i=0;			
		int nbCara=0;	
		while (phrase.charAt(i)!=FIN)
		{
			if (phrase.charAt(i)==cible)
			{
				nbCara = nbCara+1;
			}
			i=i+1;
		}
		return nbCara;
	}
	
	
		
		
		
	}