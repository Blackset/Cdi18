/***************************************************************************
  Programme		  EssaiString.java
  Auteur		  jcc 
  Mise a jour     nov 2003 
  Fonction        
  Essai d'utilisation de différentes méthodes (fonctions) de la classe String
****************************************************************************/
   
public class EssaiString
{
	public static void main(String [] arg)
	{
		String s;
		// lecture d'une chaîne au clavier
		System.out.print("frappez \"lapin\" :");
		s = Lire.S();
		
		//affichage de la String (entre des étoiles)
		System.out.println("votre chaine est :*"+s+"*");
		
		// testons les différentes comparaisons
		if (s == "lapin")
		// ici nous regardons si les références référencent bien les mêmes objets
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			// ce n'est pas la même chaîne, c'est une autre qui a même contenu
			System.out.println("votre chaine n'est pas reconnue");
		}
		
		if (s .equals( "lapin")) 
		// ici nous regardons si les chaînes ont le même contenu
		// equalsIgnoreCase fait la même chose sans tenir compte de la casse
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			System.out.println("votre chaine n'est pas reconnue");
		}
		
		if (s.compareTo("lapin") == 0)
		// ici nous regardons l'ordre alphabétique des chaînes 
		// 0 si même chaîne
		// >0 si s est plus grande que "lapin"
		// <0 si s est plus petite que "lapin"
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			System.out.println("votre chaine n'est pas reconnue");
		}

		// comment récupérer un caractère d'une chaîne:
		char c = s.charAt(0); // premier caractère de la chaîne si non vide
		System.out.println("le premier caractere de la  chaine est :"+c);
		
		// calculer la longueur d'une chaîne
		System.out.println("la longueur de la chaine est :"+ s.length ());
		
		// récupérer la chaîne en majuscule
		String smaj = s.toUpperCase();
		System.out.println("la chaine en majuscule est :"+ smaj);
		
		// récupérer un morceau de la chaîne
		// après le deuxième caractère jusqu'au cinquième compris 
		String sbout = s.substring (2,5);
		System.out.println("la fin de la chaine est :"+ sbout);
		
		// vous constaterez que ces fonctions ne modifient pas la chaîne,
		// mais construisent une autre chaîne à partir de s.
		// en regardant l'aide vous trouverez d'autres fonctions encore.
		
		Lire.Attente();
	}	
}
