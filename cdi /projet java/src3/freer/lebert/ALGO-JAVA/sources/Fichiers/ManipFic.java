/***********************************************************************
  Programme		ManipFic.java
  Auteur        L�cu Regis 
  Mise a jour   avril 2001, maj nov 2003 JCC
  Fonction		manipulation de fichiers et r�pertoires par la classe File 

- Cr�e un r�pertoire, r�cup�re son chemin absolu, et le supprime
- Ouvre un fichier ou un r�pertoire de nom choisi par l'utilisateur :
- S'il s'agit d'un r�pertoire liste son contenu. 
- Termine en renommant le fichier ou r�pertoire s�lectionn�
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
	    //cr�ation d'un r�pertoire
        fic.mkdir ();  
		
		// affichage du chemin complet
		System.out.println ("Chemin complet " + fic.getAbsolutePath ());
	    Lire.Suite ();
		
		// Suppression du r�pertoire
		fic.delete ();
		
		// Ouverture d'un fichier ou r�pertoire quelconque 
		System.out.print ("Nom de fichier ou de repertoire a ouvrir :");
		rep = Lire.Chaine ();
		fic = new File (rep);
		
		// Si c'est un r�pertoire, on affiche son contenu
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
		
		// Renommage d'un fichier ou r�pertoire
		System.out.print ("Nouveau nom du fichier :");
        rep = Lire.Chaine ();
		fic.renameTo ( new File (rep) );		
		
		Lire.Attente ();		
	}
}
