/****************************** *********************************
Programme     :  Base1.java
Auteur        :  L�cu R�gis
Mise � jour   :  f�vrier 2001, maj nov 2003 jcc
Fonction      :  d�mo sur les variables, constantes, op�rateurs
                 affectations et castings
******************************************************************/
public class Base1 
{	
	
	public static void main (String [] argument)
	{
		//  Partie d�clarative
		long   chiffreAffaire;          // variable de type entier sign� sur 8 octets
		int    factureHT ;              // variable de type entier sign� sur 4 octets
		int    factureTTC;
		final  float  tauxTVA = 1.33F;  // constante de type r�el, double pr�cision 
								// (=> mot cl� final et emploi du F derri�re la constante)
   
		// Partie ex�cutive
		System.out.println ("**** Demo variables, constantes, affectation ***");  
		System.out.println ();
   
		chiffreAffaire = 100000000 ;
		// affectation de la valeur 100000000 dans chiffreAffaire
		//   et affichage 
		System.out.println ("Chiffre d'affaire initial : " + chiffreAffaire);
   
		factureHT = 10000;
		System.out.println ("Facture Hors Taxe         : " + factureHT);          
   
		// Noter l'emploi du casting pour convertir le r�sultat en int
		factureTTC = (int) (factureHT * tauxTVA) ;
   
		chiffreAffaire = chiffreAffaire + factureTTC ;
		// Ajout de la facture au chiffre d'affaire
		System.out.println ("Chiffre d'affaire final   : " + chiffreAffaire);                    

		System.out.println();
		System.out.println("Tapez sur Entree pour Terminer ");
		Lire.c();
	}

}