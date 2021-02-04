
 /***********************************************************************
  Programme			:  TestCalculs.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001, maj nov 2033 jcc
  Fonction          :  test de la bibliothèque de fonctions calculs
 ***************************************************************************/
 
public class TestCalculs
{	
	public static void main (String arg [])
	{  
	int  entier;
	int  exposant;   
	int  resultat;

	System.out.println ("*** TestCalculs ***");
	System.out.println ();

	System.out.print ("Nombre entier ? ");
	entier = Lire.i();
	   
	System.out.print ("Exposant ? ");
	exposant = Lire.i();
	System.out.println ();
	  
	System.out.print (entier + " puissance " + exposant);
	resultat = Calculs.puissance (entier, exposant); 
	
	if (resultat != 0) 
	{
		System.out.println (" = " + resultat);
	}
	else
	{
		System.out.println  (" : calcul impossible");
	} 
	
	System.out.println ();
	System.out.print ("Factorielle " + entier);
	resultat = Calculs.factorielle (entier);
	
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
} 
