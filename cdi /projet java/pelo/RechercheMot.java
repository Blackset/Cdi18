/*  Classe      : RechercherMot
    Auteur      : Yann Capelli	
    Mise à jour : 18 Ocotbre 2016
    Fonction    : recherche un mot dans une phrase
*/
public class RechercheMot
{			
	public static void main(String[] argument)
	{
		String phrase;
		String mot;
		System.out.println("Donner la phrase :");
		phrase = Lire.S();
		System.out.println("Donner le mot à rechercher :");
		mot = Lire.S();
		if (phrase.matches(".*\\b"+ mot+ "\\b.*"))  // on cherche dans la phrase si mot est présent
		{
			System.out.println(mot+" est bien dans la phrase.");
		}
		else
		{
			System.out.println(mot+" n'est pas dans la phrase");
		}	
	}			
}