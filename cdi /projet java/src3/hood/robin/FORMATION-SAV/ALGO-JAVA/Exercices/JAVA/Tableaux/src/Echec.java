/**************************************************************************************
  Nom du programme  :  Echec.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2003 jcc
  Fonction          :  utilisation des tableaux à deux dimensions, du type String
                       et de la surcharge de fonctions en Java

   Ce programme affiche un échiquier, et bouge les pièces à la demande de l'utilisateur,
sans aucun contrôle sur la cohérence des mouvements.
****************************************************************************************/

class Position		// décrit une position sur l'échiquier
{
	short ligne;	// numéro ligne sur l'échiquier
	short colonne;	// numéro colonne sur l'échiquier
}
public class Echec
{
	static 	final String TRAIT ="_|____|____|____|____|____|____|____|____|";

	public static void main (String arg [] )
	{
		// tableau 8 X 8 représentant l'échiquier
		String unJeu[][];		
		unJeu = new String[8][8];
		
		// mémoriser les positions de départ et d'arrivée
		Position depart;
		depart = new Position();
		
		Position arrivee;
		arrivee = new Position();	
				
   	    init (unJeu);      							// met chaque pièce à sa place	
		afficher (unJeu);							// réaffichage de l'échiquier
		do 
		{	
			get ("Position de depart  : ", depart);	// saisie position de départ
			get ("Position d'arrivee : ", arrivee);	// saisie position d'arrivée
      
		    bouger  ( unJeu, depart, arrivee);		// effectue le mouvement                          
			afficher (unJeu);						// réaffichage de l'échiquier

		}
		while (Lire.Question ("Autre coup ") );			
	}

	// ................. Fonctions d'initialisation de l'échiquier......................
	
	// Cette fonction la string "piece" sur toutes les cases du tableau "ligne"
	//   utilisée pour l'initialisation des lignes vides, et des lignes de Pion
	public static void  init (String [] ligne, String piece)
	{ 
		for (int iCol = 0; iCol <= 7; iCol++)
		{
			ligne [iCol] = piece;
		}
	} 
	
	// Cette fonction initialise tout l'échiquier, en début de partie
	// NOTER la surcharge avec la fonction précédente
	public static void init (String [][] jeu)
	{
		// Initialisation des lignes vides, au milieu de l'échiquier	
		for (int iLig = 2; iLig <= 5 ; iLig ++)
		{
			 init (jeu [iLig],"  ");
		}

		// Initialisation des blancs : Tour, Cavalier, Fou...
		jeu [0][0] = "TO";
		jeu [0][1] = "CA";	 
		jeu [0][2] = "FO";
		jeu [0][3] = "RO";
		jeu [0][4] = "RE";
		
		// Recopie de l'autre moitié de la ligne, par symétrie
		for (int iCol = 0; iCol <= 2; iCol ++)
		{
			 jeu [0] [7-iCol] = jeu [0] [iCol];
		}
		
		// La ligne de pions blancs 
		init  (jeu [1], "PI");
	
		// Idem avec les noirs 
		jeu [7][0] = "to";
		jeu [7][1] = "ca";	 
		jeu [7][2] = "fo";
		jeu [7][3] = "ro";
		jeu [7][4] = "re";
	 
 		for (int iCol= 0; iCol <= 2; iCol++)
		{
			 jeu [7] [7-iCol] = jeu [7] [iCol];
		}
	 
		// La ligne de pions noirs 
		init  (jeu [6], "pi");
	}

	//................... Fonctions d'affichage de l'échiquier ........................

	// Affichage de la grille supérieure : A   B   C   D ...
	private static void  afficherGrille  ()
	{
		System.out.println () ;
  		for  (char iCol = 'A'; iCol <= 'H' ; iCol ++)
		{
			System.out.print (" |  " + iCol) ;
		}
		System.out.println (" |") ;
	}

	// Affichage complet d'une ligne de l'échiquier : cases et grille
	private static void  afficher (short iLig, String [] ligne)
	{
		// Afficher le numéro de ligne et la grille
		System.out.println (TRAIT);
		System.out.print ((iLig + 1) + "|" );
		
		// Afficher chaque case de la ligne, avec sa pièce 
		for  (short iCol = 0; iCol <= 7; iCol++)
		{
			System.out.print ( " " + ligne [iCol] + " |");
		}
		
		System.out.println ();
	}

	// Affichage complet de l'échiquier
	private static void  afficher  (String jeu [][] )
	{
		afficherGrille  ();
	
		for  (short iLig = 0; iLig <= 7; iLig++)
		{
			afficher (iLig, jeu [iLig] );
		}
	    
		System.out.println (TRAIT);
		System.out.println ();
	}

	//............................  Saisie d'une position.............
	//  Entree : question
	//	         "Position de départ" ou "Position d'arrivée" 
	//  Sortie : position de la pièce
	private static void get ( String question, Position position)	
	{ 
		String pos ;   
		char l='0', c='Z';
		
		do 
		{
			System.out.print (question);  
    		pos = Lire.S();
			if (pos.length() == 2) // sinon on recommence
			{
				l = pos.charAt(0);
				c = pos.charAt(1);
			}
		}  
		while ( (l < '1') || (l > '8') || (c < 'A') || (c > 'H'));
		// arrêt quand '8'>= l >= '1' et 'H' >= c >= 'A'
		
		position.ligne  = (short) ( l - '1');			
		position.colonne  = (short) ( c - 'A');	  
	}

	//................. Effectuer le mouvement d'une piece dans l'échiquier ...
	// Entree-Sortie : tableau jeu 
	//					représente l'échiquier
	// Entree        : depart 
	//					ligne, colonne de départ
	//				 : arrivee
	//					ligne, colonne d'arrivee
	private static void bouger (String jeu [][], Position depart, Position arrivee)	
    { 
		// recopie de la pièce sur la case d'arrivée	
		jeu[arrivee.ligne] [arrivee.colonne] = jeu [depart.ligne] [depart.colonne];
		// la case de départ est maintenant vide (symbolisé par "  " )
		jeu [depart.ligne] [depart.colonne] = "  ";	  
	}

}

	 

