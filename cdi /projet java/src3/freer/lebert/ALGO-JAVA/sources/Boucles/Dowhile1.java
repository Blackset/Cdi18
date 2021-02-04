/*************************************************************************************
  Nom du programme  :  Dowhile1.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2003 jcc
  Fonction          :  
  Ce programme lit un ensemble de caract�res au clavier,
  (sur la m�me ligne ou non ),  jusqu'au caract�re  "."  
    
  Parmi les caract�res entr�s, il compte :
  - le nombre de lettres majuscules 
  - le nombre de lettres minuscules 
  - le nombre de caract�res de ponctuation :  ! ? , . ; :
  - les caract�res restant sont comptabilis�s dans la cat�gorie "divers"

 Dans cette version, on d�sire compter le point final comme un caract�re de ponctuation.
***************************************************************************************/

public class Dowhile1
{
	 public static void main (String arg [])
	 {
		 char carlu;
		 // D�clarations et initialisations � 0 des diff�rents compteurs 
		 //  on n'a encore rien lu !
		 int  nbMajuscule = 0;
		 int  nbMinuscule = 0 ;
		 int  nbPonctuation = 0;
		 int  nbDivers = 0;

		 // Dans cette version, on ne filtre pas les fins de ligne : tous
		 // les caract�res doivent �tre lus, y compris les caract�res 
		 // de contr�le
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

		// affichage du nombre de caract�res, dans chaque cat�gorie
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
