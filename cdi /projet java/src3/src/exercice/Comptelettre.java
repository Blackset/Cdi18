package exercice;

public class Comptelettre
{
	public static void main (String[]argument)
	{
		String phrase;
		System.out.println("veuillez saisir un phrase");
		phrase=Lire.S();
		
		int nbCara= compterLettre(phrase);
		
		System.out.println("Il y a "+nbCara+"  caratere dans cette phrase" );
		
	}
		private static int compterLettre(String phrase)
		{
			int i=0;			
			int nbCara=0;	
			for(i=0;i<=(phrase.length()-1);i=i+1){
			
				nbCara = nbCara+1;
				
			}
			return nbCara;
		}
		
	
	}


