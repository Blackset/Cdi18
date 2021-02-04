/*************************************************************************
  Programme			 :  Parametre.java         
  Auteur             :  Lécu Régis
  Mise a jour        :  février 2001, maj nov 2033 jcc
  Fonction           :  idem fonction.java
  Utilisation        :
     appels de fonctions avec passage de paramètres en entrée, et
     valeurs de retour
 *************************************************************************/

public class Parametre 
{
	
	public static void main(String arg [])
	{
		System.out.println ("*** Calcul de l'inverse d'un nombre (V2) *****");
		System.out.println (); 	   
			   
		char reponse;
		String nom;  
			 
		System.out.print ("Entrez votre nom :");
		nom = Lire.S();
		   
		// passage de nom à la fonction afficheBonjour, 
		// en paramètre par valeur
		afficheBonjour ( nom );   
		  
		do 
		{
			afficheInverse ();	  
			System.out.print ("Tapez O si vous voulez continuer :");
			reponse = Lire.c();
			System.out.println ();
		}
		while (reponse == 'O');
		   
		afficheAuRevoir(nom); 	
		Lire.Attente ();
	}

	public static void afficheBonjour (String unNom)
	{
		System.out.print ("Bonjour ");
		afficheNom (unNom);    
		// transmet le paramètre reçu: le parametre formel de afficheBonjour 
		// devient paramètre effectif de afficheNom   
	}

	private static void afficheAuRevoir(String unNom)
	{
		System.out.print ("Au revoir ");
		afficheNom (unNom);   
	}

	private static void afficheNom (String unNom)
	{
		// affiche le parametre formel	
		System.out.println ("\t Monsieur " + unNom); 
		System.out.println ();   
	}

	private static double saisieNombre ()
	{
		// variable tampon recevant le reel qui est retourné à l'appelant
		double reel;
		
		System.out.print ("Entrez un nombre reel : " );
		// La fonction d() de la classe Lire fonctionne comme saisieNombre 
		reel = Lire.d();
		
		return reel ;
	}

	private static void afficheInverse()
	{
		// variables locales à la fonction AfficheInverse
		double inverse;     
		double nombreLu;

		nombreLu = saisieNombre();	
		if (nombreLu != 0)
		{
			inverse = 1 / nombreLu ;  
			System.out.println ("L'inverse de " + nombreLu + " est " + inverse ) ;
		}
		else
		{
			System.out.println ("0 n'a pas d'inverse !");	
		}
		
		System.out.println ();	
	}
}  
