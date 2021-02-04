/*********************************************************************
  Programme			Copie.java
  Auteur            Lécu Regis 
  Mise a jour       avril 2001, maj nov 2003 JCC
  Fonction	
  - Copie d'un fichier source vers un fichier cible
  - Le fichier source et le fichier cible sont passés en paramètres
 du programme (args[0] et args[1])
  - Ne fonctionne que pour les fichiers Texte (du fait de l'encodage 
effectué par les classes FileReader et FileWriter)
**********************************************************************/
import java.io.* ;

public class Copie
{	
	public static void main (String[] args) throws IOException 
	{	
		// Vérification du nombre de paramètres
		if (args.length != 2)
		{	
			System.out.println ("** Syntaxe : Copie source cible" );
			System.exit (1); //arrêt programme avec code erreur		  
		}
		
        // test d'existence du fichier source
		File source = new File (args[0] );				
		if (! source.exists()) 
		{	
			System.out.println ("Fichier source inexistant ! ");
		    System.exit (2); //arrêt programme avec code erreur	
		}
		
		// ouverture en lecture du fichier source, en écriture du 
		// fichier cible
		FileReader ficSource = new FileReader (source);		
		FileWriter ficCible = new FileWriter (new File (args[1]));

		// relecture du fichier source octet par octet et recopie
		// dans le fichier cible
		// (à la fin du fichier, la méthode read renvoie -1)
		int octet = ficSource.read();		
		while (octet != -1)
		{
			ficCible.write (octet); 	
			octet = ficSource.read ();
		}
			
		// fermeture des deux fichiers		
		ficSource.close ();
		ficCible.close (); 		
	    
		// réouverture des deux fichiers en lecture, et
		// comparaison octet par octet pour vérification
		ficSource = new FileReader (source);
		FileReader ficCopie = new FileReader (args[1]);
		
		int carSource;
		int carCopie;
		int nbcar = 0;
		do
		{
		   carSource = ficSource.read ();
		   carCopie  = ficCopie.read ();		   
		   nbcar = nbcar + 1;
		}
		while ( (carSource != -1) && (carCopie == carSource) ); 	
		// arrêt quand fin de lecture ou caractères différents
		
		if (carSource != carCopie) 
		{	
			System.out.println ("** Copie incorrecte ! ");
			System.out.println ("Octet numero " + nbcar + ": source= " 
								 + carSource + ", copie =  " + carCopie);
		}	
		else // carSource et carCopie égaux à -1
		{
			System.out.println ("Copie achevee avec succes !");
		}

		ficSource.close ();
		ficCopie.close (); 			    
	}	
}
