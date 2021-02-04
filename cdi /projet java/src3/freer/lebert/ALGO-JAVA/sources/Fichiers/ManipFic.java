/***********************************************************************
  Programme		ManipFic.java
  Auteur        Lécu Regis 
  Mise a jour   avril 2001, maj nov 2003 JCC
  Fonction		manipulation de fichiers et répertoires par la classe File 

- Crée un répertoire, récupère son chemin absolu, et le supprime
- Ouvre un fichier ou un répertoire de nom choisi par l'utilisateur :
- S'il s'agit d'un répertoire liste son contenu. 
- Termine en renommant le fichier ou répertoire sélectionné
************************************************************************/
import java.io.* ;
public class ManipFic
{
	public static void main (String[] args) throws IOException 
	{
        System.out.println ("*** Manipulation des fichiers et repertoires ***");
        System.out.println ();

		System.out.print ("Nom du sous-repertoire a creer :");
		String rep = Lire.Chaine ();
			
		File fic  = new File (rep);	
	    //création d'un répertoire
        fic.mkdir ();  
		
		// affichage du chemin complet
		System.out.println ("Chemin complet " + fic.getAbsolutePath ());
	    Lire.Suite ();
		
		// Suppression du répertoire
		fic.delete ();
		
		// Ouverture d'un fichier ou répertoire quelconque 
		System.out.print ("Nom de fichier ou de repertoire a ouvrir :");
		rep = Lire.Chaine ();
		fic = new File (rep);
		
		// Si c'est un répertoire, on affiche son contenu
        if (fic.isDirectory()) 
		{	
			System.out.println ("C'est un repertoire, de contenu : ");
			String tab []  = fic.list ();
			for (int i = 0 ; i < tab.length ; i++)
			{
				System.out.println ( tab[i] );
			}
		}			
		else if (fic.isFile())
		{
			System.out.println ("C'est un fichier de donnee");
		}
		else
		{
			System.out.println ("Fichier inexistant !");
			System.exit (1); // sortie sauvage du programme avec retour 1
		}
		
		// Renommage d'un fichier ou répertoire
		System.out.print ("Nouveau nom du fichier :");
        rep = Lire.Chaine ();
		fic.renameTo ( new File (rep) );		
		
		Lire.Attente ();		
	}
}
