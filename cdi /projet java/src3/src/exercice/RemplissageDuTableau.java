package exercice;


   
public class RemplissageDuTableau
{
	
	private static final int MAX = 80;
	

	public static void main(String[] argument)
	{
		char[]tab ;	
		
		do
		{
			tab = Lire.remplirTableau("donnez votre phrase : ", MAX);
			Lire.afficheTableau(tab);
			System.out.println();
		} while (Dialogue.veutContinuer());
	}
	
	

}