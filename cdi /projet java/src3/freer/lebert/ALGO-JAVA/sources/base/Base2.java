/****************************************************************
Programme     :  Base2.java
Auteur        :  Lécu Régis
Mise à jour   :  février 2001, maj nov 2003 jcc
Fonction      :  démo sur les opérateurs, affichages
******************************************************************/

public class Base2
{		
	public static void main (String [] argument)
	{
		System.out.println ("**** Demo operateurs, affichages ***");  
		System.out.println ();
    
		// En java, on peut déclarer les variables locales n'importe ou dans un
		// bloc, au plus près de leur utilisation
		int nombre = 10;
		int divEntier = 3;
		float divReel = 3.0F;
	
		// Utilisation de la division entière et réelle
		System.out.println ("Division entiere de " + nombre + " par " + divEntier);
		System.out.print ("Quotient = ");
		System.out.print (nombre / divEntier );
		System.out.print ("  Reste = ");
		System.out.println (nombre % divEntier );
		System.out.println ("...............................");
		System.out.println ();

		System.out.println ("Division reelle de " + nombre + " par " + divReel );
		System.out.println ("Quotient = "+ (nombre / divReel));
		System.out.println ("...............................");
		System.out.println ();

		// Affichage de quelques entiers en décimal, hexadécimal et octal
		long entier = 65535;
		short hexa = 0xFF;
		byte octal = 077;
	
		System.out.print ("Entier = ");
		System.out.println (entier);
		System.out.print ("Hexa = ");
		System.out.println (hexa);
		System.out.print ("Octal = ");
		System.out.println (octal);
		System.out.println ("...............................");
		System.out.println ();
	
		// Saisie d'un caractere et affichage de sa valeur ASCII ou UNICODE
		char car;
		System.out.print ("Entrez un caractere :" );
		car = Lire.c ();
	
		// On réaffiche d'abord la valeur du caractère puis la valeur de son  
		// code en "castant" le caractère en int
		System.out.print ("Le caractere " + car + " a pour valeur UNICODE :");
		System.out.println ((int) car);    
	
		System.out.println();
		System.out.println("Tapez sur Entree pour Terminer ");
		Lire.c();	
	}	  
}
