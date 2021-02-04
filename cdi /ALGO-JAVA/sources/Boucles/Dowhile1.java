/*************************************************************************************
  Nom du programme  :  Dowhile1.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          :  
  Ce programme lit un ensemble de caractères au clavier,
  (sur la même ligne ou non ),  jusqu'au caractère  "."  
    
  Parmi les caractères entrés, il compte :
  - le nombre de lettres majuscules 
  - le nombre de lettres minuscules 
  - le nombre de caractères de ponctuation :  ! ? , . ; :
  - les caractères restant sont comptabilisés dans la catégorie "divers"

 Dans cette version, on désire compter le point final comme un caractère de ponctuation.
***************************************************************************************/

public class Dowhile1
{
	 public static void main (String arg [])
	 {
		 char carlu;
		 // Déclarations et initialisations à 0 des différents compteurs 
		 //  on n'a encore rien lu !
		 int  nbMajuscule = 0;
		 int  nbMinuscule = 0 ;
		 int  nbPonctuation = 0;
		 int  nbDivers = 0;

		 // Dans cette version, on ne filtre pas les fins de ligne : tous
		 // les caractères doivent être lus, y compris les caractères 
		 // de contrôle
		 Lire.Filtre (false);

		 System.out.println ( "*** Boucle : do ... while (Version 1) **" );
		 System.out.println ();

		 System.out.print ( "Texte termine par un point : ");
		 do               
		 { 
			carlu = Lire.c();
	
			if ( (carlu >= 'A') && (carlu <= 'Z') ) 
			{
			   nbMajuscule = nbMajuscule + 1;
			}
			else if ((carlu >= 'a') && (carlu <= 'z') ) 
			{
			   nbMinuscule = nbMinuscule + 1;
			}
			else if ((carlu == '.') || (carlu == ',') || (carlu == ';')
			        || (carlu == '!') || (carlu == '?') || (carlu == ':'))   
			{
			   nbPonctuation = nbPonctuation + 1;
			}
			else
			{
			   nbDivers = nbDivers + 1;
			}
		 }
		 while (carlu != '.');

		// affichage du nombre de caractères, dans chaque catégorie
		System.out.println ( "Il y a ");
		
		if (nbMajuscule != 0)
		{
		   System.out.println ( "\t" + nbMajuscule + " majuscules") ;
		}
		if (nbMinuscule != 0)
		{
		   System.out.println ( "\t" + nbMinuscule + " minuscules" ); 
		}
		if (nbPonctuation != 0)
		{
		   System.out.println ( "\t" + nbPonctuation + " ponctuations" );
		}
		if (nbDivers != 0)
		{
		   System.out.println ( "\tet " + nbDivers + " caracteres d'un autre type" ); 
		}
		
		Lire.Purge();
		Lire.Attente();

	}
}
