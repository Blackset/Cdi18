/*****************************************************************
  Programme			TabMesures.java
  Auteur            Lécu Regis 
  Mise a jour       février 2001, maj nov 2003 jcc
  Fonction         
	Utilisation d'un tableau d'enregistrements en Java : 
  Cet exemple reprend le type Descripteur appelé maintenant Capteur,
  présenté dans mesure.java et définit un tableau de ces structures.     
******************************************************************/

     
class Capteur      	// descripteur de mesure : class sans l'attribut public
{
	public String   lib;	// libellé de la mesure
	public boolean  etat;	// vrai si fonctionnement capteur OK
	public int      val;    // valeur mesurée   
}

public class TabMesures
{
	public static void main (String arg[])
    {
 	    Capteur [] tMesures ;	// déclaration du tableau de Capteurs
								// tMesures référencera un tableau de mesures
		System.out.println ("*** Demo sur les tableaux d'objets *** ");
		System.out.println ();

		int nbCapteurs;
		System.out.print ("Nombre de Capteurs ?");
		nbCapteurs = Lire.i();
		System.out.println ();
		
		// création du tableau de Capteur : attention, ne réserve que des "références" 
		// il faut ensuite créer les Capteurs, case par case
		tMesures = new Capteur [nbCapteurs];
		// tMesure référence maintenant un tableau
		// chaque élément du tableau référencera un Capteur
		
		// Etape 1 : saisie des mesures...
		int iVide = 0;			//  indice de la première case vide dans tMesures                                 
		do         
		{
			tMesures [iVide] = new Capteur ();  // création du Capteur
			// la case numéro iVide référence maintenant un Capteur
			
			lire (tMesures [iVide]); // initialisation du Capteur
			iVide ++;                   	 
 	    }  
		while (iVide < nbCapteurs); // arrêt quand iVide == nbCapteurs
					  
		// Etape 2 : réaffichage des mesures...
		System.out.println ("** Recapitulatif de vos mesures **" );
		
		for (int iDescr = 0 ; iDescr < nbCapteurs ; iDescr ++)  
		// iDescr est l'indice de la case à afficher
		{
			afficher (tMesures [iDescr]);
		}
		
		Lire.Attente();
	}	

	// Affichage complet d'un Capteur de mesure
	public static void afficher (Capteur des)
	// des est passé entrée sortie pour faire une entrée
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
	// des est passé en entrée sortie pour faire une sortie
	{
		System.out.println ("** Saisie d'un Capteur de mesure ** ") ;
		
		System.out.print (" Nom : ") ;
		des.lib = Lire.S();
  
		des.etat = Lire.Question (" Capteur en etat de marche");
		System.out.print (" Valeur : ");
		des.val = Lire.i(); 
	}
  }