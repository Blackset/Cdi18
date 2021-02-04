
/*  Classe      : unicode
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 19 Octobre 2015
    Fonction    : ce programme permet de verifier  si une chaine de caractère est un plindrome */

public class remontbull
{
     public static final int MAX = 100;
     
	 public static void main(String [] argument)

	 {

		int[] tabloEntier;
		
		System.out.println ("combien d'entiers voulez vous rentrer:" );
		int longueur = Lire.i();
		
		tabloEntier = compter.traiterTabEentier(longueur);
		
		
		
	    boolean inversion;
		int stock;
	    int i;
	     
	 
   do 
   {
     
	   
	 	   inversion = false;
		    i = 0;
		   
	      
	  
	      
	    while ( i < longueur-1)
	        {
		        if (tabloEntier [i] > tabloEntier [i + 1])
			
		         { 
		           stock = tabloEntier [i];
		           tabloEntier [i] = tabloEntier [i + 1];
		           tabloEntier [i + 1] = stock;
		 
		           inversion = true;
		           
		         }
		            i = i + 1;
		
	        } 
	  }
	
	  while ( inversion == true );
   
	   i = 0;
	   
	   while( i< longueur)
	   {
		   System.out.println("la valeur de la case " + i + " est maintenant de " + tabloEntier [i] );
		   i = i + 1;
	   }
   }
   }
	
	
		
	
	
	
		
		
		
		
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	