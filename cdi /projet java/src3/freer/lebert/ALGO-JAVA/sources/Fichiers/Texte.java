/******************************************************************
  Programme			Texte.java
  Auteur            Lécu Regis 
  Mise a jour       avril 2001, maj nov 2003 JCC
  Fonction	
  - Saisie et réaffichage d'un fichier texte
******************************************************************/
import java.io.* ;
public class Texte
{
	
	public static void main (String[] args) throws IOException 
	{		
		System.out.println ("** Creation et reaffichage d'un fichier texte **");
		System.out.println ();
		
		// saisie du nom de fichier
		System.out.print ("Nom du fichier (sans extansion) : ");
		String nom = Lire.Chaine ()+".txt";
		// Les entrées sorties bufferisées sont plus performantes que les
		// entrées sorties standards ( moins d'accès disque )
		// et possède en plus la gestion des lignes.
		BufferedWriter fw = new BufferedWriter (new FileWriter (nom)) ;
		
		// saisie du contenu du fichier
		System.out.println ("Entrez un texte termine par une ligne vide :");
		String ligne = Lire.Chaine ();
		while (! ligne.equals ("") )
		{		  
			fw.write (ligne);
			fw.newLine ();
			ligne = Lire.Chaine ();
		}
		// fermeture du fichier
		fw.close ();
		
		// réaffichage du fichier
		System.out.println ();
		System.out.println ("Contenu du fichier " + nom);
		System.out.println ("......................");
		BufferedReader fr = new BufferedReader (new FileReader (nom) );
		
		// la fonction readLine renvoie null en fin de fichier
		ligne = fr.readLine ();		
		while (  ligne != null)
		{
			System.out.println (ligne);  	
			ligne = fr.readLine ();		
		}		

		Lire.Attente ();		
	}
}
