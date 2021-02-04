/***************************************************************************
  Programme		  EssaiString.java
  Auteur		  jcc 
  Mise a jour     nov 2003 
  Fonction        
  Essai d'utilisation de diff�rentes m�thodes (fonctions) de la classe String
****************************************************************************/
   
public class EssaiString
{
	public static void main(String [] arg)
	{
		String s;
		// lecture d'une cha�ne au clavier
		System.out.print("frappez \"lapin\" :");
		s = Lire.S();
		
		//affichage de la String (entre des �toiles)
		System.out.println("votre chaine est :*"+s+"*");
		
		// testons les diff�rentes comparaisons
		if (s == "lapin")
		// ici nous regardons si les r�f�rences r�f�rencent bien les m�mes objets
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			// ce n'est pas la m�me cha�ne, c'est une autre qui a m�me contenu
			System.out.println("votre chaine n'est pas reconnue");
		}
		
		if (s .equals( "lapin")) 
		// ici nous regardons si les cha�nes ont le m�me contenu
		// equalsIgnoreCase fait la m�me chose sans tenir compte de la casse
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			System.out.println("votre chaine n'est pas reconnue");
		}
		
		if (s.compareTo("lapin") == 0)
		// ici nous regardons l'ordre alphab�tique des cha�nes 
		// 0 si m�me cha�ne
		// >0 si s est plus grande que "lapin"
		// <0 si s est plus petite que "lapin"
		{
			System.out.println("votre chaine est reconnue");
		}
		else
		{
			System.out.println("votre chaine n'est pas reconnue");
		}

		// comment r�cup�rer un caract�re d'une cha�ne:
		char c = s.charAt(0); // premier caract�re de la cha�ne si non vide
		System.out.println("le premier caractere de la  chaine est :"+c);
		
		// calculer la longueur d'une cha�ne
		System.out.println("la longueur de la chaine est :"+ s.length ());
		
		// r�cup�rer la cha�ne en majuscule
		String smaj = s.toUpperCase();
		System.out.println("la chaine en majuscule est :"+ smaj);
		
		// r�cup�rer un morceau de la cha�ne
		// apr�s le deuxi�me caract�re jusqu'au cinqui�me compris 
		String sbout = s.substring (2,5);
		System.out.println("la fin de la chaine est :"+ sbout);
		
		// vous constaterez que ces fonctions ne modifient pas la cha�ne,
		// mais construisent une autre cha�ne � partir de s.
		// en regardant l'aide vous trouverez d'autres fonctions encore.
		
		Lire.Attente();
	}	
}
