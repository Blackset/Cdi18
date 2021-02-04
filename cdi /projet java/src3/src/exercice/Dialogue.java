package exercice;

public class Dialogue
{
	public static boolean veutContinuer()
	{
		boolean resultat = false;
		boolean saisieOk;
		char reponse;
		do
		{
			System.out.print("Voulez-vous continuer ?");
			reponse = Character.toLowerCase(Lire.c());
			if (reponse == 'o')
			{
				resultat = true;
				saisieOk = true;
			}

			else if (reponse == 'n') 
			{
				resultat = false;
				saisieOk = true;
			}
			else
			{

				saisieOk = false;
			}
		} while (saisieOk == false);
		return resultat;

	}

}
