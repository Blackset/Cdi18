/****************************** *********************************
Programme     :  Base1.java
Auteur        :  Lécu Régis
Mise à jour   :  février 2001, maj nov 2003 jcc
Fonction      :  démo sur les variables, constantes, opérateurs
                 affectations et castings
******************************************************************/
public class Base1 
{	
	
	public static void main (String [] argument)
	{
		//  Partie déclarative
		long   chiffreAffaire;          // variable de type entier signé sur 8 octets
		int    factureHT ;              // variable de type entier signé sur 4 octets
		int    factureTTC;
		final  float  tauxTVA = 1.33F;  // constante de type réel, double précision 
								// (=> mot clé final et emploi du F derrière la constante)
   
		// Partie exécutive
		System.out.println ("**** Demo variables, constantes, affectation ***");  
		System.out.println ();
   
		chiffreAffaire = 100000000 ;
		// affectation de la valeur 100000000 dans chiffreAffaire
		//   et affichage 
		System.out.println ("Chiffre d'affaire initial : " + chiffreAffaire);
   
		factureHT = 10000;
		System.out.println ("Facture Hors Taxe         : " + factureHT);          
   
		// Noter l'emploi du casting pour convertir le résultat en int
		factureTTC = (int) (factureHT * tauxTVA) ;
   
		chiffreAffaire = chiffreAffaire + factureTTC ;
		// Ajout de la facture au chiffre d'affaire
		System.out.println ("Chiffre d'affaire final   : " + chiffreAffaire);                    

		System.out.println();
		System.out.println("Tapez sur Entree pour Terminer ");
		Lire.c();
	}

}