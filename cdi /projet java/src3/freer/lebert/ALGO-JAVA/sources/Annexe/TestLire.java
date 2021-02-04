/****************************************************************************
  Nom du programme  :  TestLire.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2003 jcc
  Fonction          :  programme de test 
					   de la biblioth�que de fonctions de lecture Lire.java
*****************************************************************************/
public class TestLire
{
	private static void ecrire (char car)
	{
		// Si le caractere est imprimable, on l'affiche
		if (car >= ' ')
		{
			System.out.println ("Caractere : " + car );
		}
		// Sinon si c'est un caractere de controle, on affiche son code ascci
		else
		{
			System.out.println ("Controle : code " + (int) car);
		}
	}
	
	public static void main (String[] args)
	{
		System.out.println ("**** Programme de test de la classe Lire ***");
		System.out.println ();
				
		String nom ;
		
		System.out.print ("Votre nom ? ");
		nom = Lire.S ();					// lecture d'une String
				
		int age ;
		System.out.print ("Votre age ? ");
		age = Lire.i ();					//	lecture d'un entier
		
		float taille ;
		System.out.print ("Votre taille (en m) ? ");
		taille = Lire.f ();					// lecture d'un r�el

		System.out.println ();
		System.out.println ("***** Recapitulatif de votre fiche personnelle *****");
		System.out.print ("Nom : ");
		System.out.println (nom);
		System.out.print ("Age : ");
		System.out.println (age+ " ans");
		System.out.print ("Taille : ");
		System.out.println (taille + " m");	
		
		
		// Utilisation de la fonction bool�enne Question
		System.out.println ();			
		System.out.println ("***** Utilisation de la fonction Question ****");
		String trait = "";
		do
		{	
			trait = trait + ".";
			System.out.println (trait);			
		}	
		while (Lire.Question ("Voulez-vous reboucler") );	
		// arr�t quand on ne veut plus reboucler
		
		// Lecture d'un texte � la vol�e, sans aller � la ligne apr�s chaque lecture
		System.out.println ();
		System.out.println ("**** Saisie d'un texte sans filtrage ***");

		Lire.Filtre (false);
		System.out.println ("Entrez une suite de caracteres terminee par un .");
		System.out.println ("Sur une ou plusieurs lignes. Tous les caracteres sont lus");
		char car = Lire.c();
		while (car != '.')
		{	
			ecrire (car);
			car = Lire.c();
		}
		
		// remettons le filtre comme nous l'avons trouv� en arrivant
		Lire.Filtre (true);
		
		// Lecture d'un texte avec filtrage : seul le premier caract�re 
		//	de chaque ligne sera lu
		System.out.println ();
		System.out.println ("**** Saisie d'un caractere par ligne ***");

		System.out.println ("Entrez une suite de caracteres terminee par un .");
		System.out.println ("Seul le premier caractere de chaque ligne est lu");
		car = Lire.c();
		while (car != '.')
		{			
			ecrire (car);
			car = Lire.c();
		}
		
		
		// Lecture d'un texte sans filtrage : on �limine la fin de ligne 
		// � partir d'un caract�re d�termin�, par la fonction Purge
				
		System.out.println ();
		System.out.println ("**** Demo fonction Purge ***");
		System.out.println ("Entrez une suite de caracteres terminee par un .");
		System.out.println ("Sur chaque ligne, tous les caracteres apres ; seront ignores");							
		Lire.Filtre (false);
		car = Lire.c();
		while (car != '.')
		{	
			ecrire (car);
			if (car == ';')
			{
				Lire.Purge ();
			}
			car = Lire.c();
		}
		Lire.Purge ();
		// il reste les caract�res de fin de ligne '\r' et '\n' � traiter
		// remettons le filtre comme nous l'avons trouv� en arrivant
		Lire.Filtre (true);
		
		Lire.Attente();						// Attente de la frappe de return		
	}

}
