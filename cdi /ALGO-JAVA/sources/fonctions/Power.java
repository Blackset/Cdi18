 /*************************************************************************
  Nom du programme  :  Power.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2033 jcc
  Fonction          :  Fonctions avec valeur de retour
 *************************************************************************/

public class Power
{	
	public static void main (String arg [])
	{  
		int  entier;
		int  exposant;   
		int  resultat;

		System.out.println ("*** Elevation a la puissance ***");
		System.out.println ();

		System.out.print ("Nombre entier ? ");
		entier = Lire.i();
		   
		System.out.print ("Exposant ? ");
		exposant = Lire.i();
		System.out.println ();
		   
		System.out.print (entier + " puissance " + exposant);
		   
		resultat = Puissance (entier, exposant);     
		   
		if (resultat != 0) 
		{
			System.out.println (" = " + resultat);	
		}
		else
		{
			System.out.println  (" : calcul impossible");
		}
		   
		System.out.println ();
		Lire.Attente ();
	}  

	// Fonction Puissance
	// Si le calcul est possible (exposant >= 0), cette fonction
	// retourne la puissance "exposant" de l'entier "operande", sinon
	// elle retourne 0 
	
	public static int Puissance (int operande, int exposant)
	{ 	  
		int result;
			 
		if (exposant < 0)
		{
			result = 0;
		}
		else
		{ 
			result = 1;
			for (int nbfois = 1; nbfois <= exposant; nbfois ++ ) 
			{
				result = result * operande;
			}
		}  
		return result;      
	} 
}  
