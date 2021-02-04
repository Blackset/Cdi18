/*****************************************************************
  Programme			TabMesures.java
  Auteur            L�cu Regis 
  Mise a jour       f�vrier 2001, maj nov 2003 jcc
  Fonction         
	Utilisation d'un tableau d'enregistrements en Java : 
  Cet exemple reprend le type Descripteur appel� maintenant Capteur,
  pr�sent� dans mesure.java et d�finit un tableau de ces structures.     
******************************************************************/

     
class Capteur      	// descripteur de mesure : class sans l'attribut public
{
	public String   lib;	// libell� de la mesure
	public boolean  etat;	// vrai si fonctionnement capteur OK
	public int      val;    // valeur mesur�e   
}

public class TabMesures
{
	public static void main (String arg[])
    {
 	    Capteur [] tMesures ;	// d�claration du tableau de Capteurs
								// tMesures r�f�rencera un tableau de mesures
		System.out.println ("*** Demo sur les tableaux d'objets *** ");
		System.out.println ();

		int nbCapteurs;
		System.out.print ("Nombre de Capteurs ?");
		nbCapteurs = Lire.i();
		System.out.println ();
		
		// cr�ation du tableau de Capteur : attention, ne r�serve que des "r�f�rences" 
		// il faut ensuite cr�er les Capteurs, case par case
		tMesures = new Capteur [nbCapteurs];
		// tMesure r�f�rence maintenant un tableau
		// chaque �l�ment du tableau r�f�rencera un Capteur
		
		// Etape 1 : saisie des mesures...
		int iVide = 0;			//  indice de la premi�re case vide dans tMesures                                 
		do         
		{
			tMesures [iVide] = new Capteur ();  // cr�ation du Capteur
			// la case num�ro iVide r�f�rence maintenant un Capteur
			
			lire (tMesures [iVide]); // initialisation du Capteur
			iVide ++;                   	 
 	    }  
		while (iVide < nbCapteurs); // arr�t quand iVide == nbCapteurs
					  
		// Etape 2 : r�affichage des mesures...
		System.out.println ("** Recapitulatif de vos mesures **" );
		
		for (int iDescr = 0 ; iDescr < nbCapteurs ; iDescr ++)  
		// iDescr est l'indice de la case � afficher
		{
			afficher (tMesures [iDescr]);
		}
		
		Lire.Attente();
	}	

	// Affichage complet d'un Capteur de mesure
	public static void afficher (Capteur des)
	// des est pass� entr�e sortie pour faire une entr�e
	{
		System.out.println ();
		System.out.println (" Nom : " + des.lib);
	    System.out.print   (" Etat  : ");
        if (des.etat)
		{
			System.out.println  ("** OK **"); 
		}
		else
		{
			System.out.println  ("** HS **");
		}
		
		System.out.println (" Valeur : "  +  des.val);
		System.out.println ();
	}
     
	// Lecture clavier d'un Capteur de mesure
	public static void lire (Capteur des)
	// des est pass� en entr�e sortie pour faire une sortie
	{
		System.out.println ("** Saisie d'un Capteur de mesure ** ") ;
		
		System.out.print (" Nom : ") ;
		des.lib = Lire.S();
  
		des.etat = Lire.Question (" Capteur en etat de marche");
		System.out.print (" Valeur : ");
		des.val = Lire.i(); 
	}
  }