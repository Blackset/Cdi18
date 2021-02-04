/*********************************************************************
  Programme			Copie.java
  Auteur            L�cu Regis 
  Mise a jour       avril 2001, maj nov 2003 JCC
  Fonction	
  - Copie d'un fichier source vers un fichier cible
  - Le fichier source et le fichier cible sont pass�s en param�tres
 du programme (args[0] et args[1])
  - Ne fonctionne que pour les fichiers Texte (du fait de l'encodage 
effectu� par les classes FileReader et FileWriter)
**********************************************************************/
import java.io.* ;

public class Copie
{	
	public static void main (String[] args) throws IOException 
	{	
		// V�rification du nombre de param�tres
		if (args.length != 2)
		{	
			System.out.println ("** Syntaxe : Copie source cible" );
			System.exit (1); //arr�t programme avec code erreur		  
		}
		
        // test d'existence du fichier source
		File source = new File (args[0] );				
		if (! source.exists()) 
		{	
			System.out.println ("Fichier source inexistant ! ");
		    System.exit (2); //arr�t programme avec code erreur	
		}
		
		// ouverture en lecture du fichier source, en �criture du 
		// fichier cible
		FileReader ficSource = new FileReader (source);		
		FileWriter ficCible = new FileWriter (new File (args[1]));

		// relecture du fichier source octet par octet et recopie
		// dans le fichier cible
		// (� la fin du fichier, la m�thode read renvoie -1)
		int octet = ficSource.read();		
		while (octet != -1)
		{
			ficCible.write (octet); 	
			octet = ficSource.read ();
		}
			
		// fermeture des deux fichiers		
		ficSource.close ();
		ficCible.close (); 		
	    
		// r�ouverture des deux fichiers en lecture, et
		// comparaison octet par octet pour v�rification
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
		// arr�t quand fin de lecture ou caract�res diff�rents
		
		if (carSource != carCopie) 
		{	
			System.out.println ("** Copie incorrecte ! ");
			System.out.println ("Octet numero " + nbcar + ": source= " 
								 + carSource + ", copie =  " + carCopie);
		}	
		else // carSource et carCopie �gaux � -1
		{
			System.out.println ("Copie achevee avec succes !");
		}

		ficSource.close ();
		ficCopie.close (); 			    
	}	
}
