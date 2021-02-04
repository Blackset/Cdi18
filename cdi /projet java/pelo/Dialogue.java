/*  Classe      : Dialogue
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : 
*/
public class Dialogue
{

	public static void main(String[] argument)
	{
		
	}
	public static boolean veutContinuer ()
	{
		boolean result=false;
		boolean saisieRep=false;
		char rep;
		do 
		{
			System.out.println("Voulez vous continuer ?(O,o pour oui , N,n pour non");
			rep = Lire.c();
			if ((rep=='o')||(rep=='O'))
			{
				result = true;
				saisieRep = true;
			}
			else if ((rep=='n')||(rep=='N'))
			{
				result = false;
				saisieRep = true;
			}
			else
			{
				saisieRep = false;
			}	
		}
		while (!saisieRep);	
		
		
		return result;
	}

}