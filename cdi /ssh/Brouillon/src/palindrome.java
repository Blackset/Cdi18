
/*  Classe      : unicode
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 19 Octobre 2015
    Fonction    : ce programme permet de verifier  si une chaine de caractère est un plindrome */


public class palindrome
{
	 public static final char CARTERM = '.';
     public static final int MAX = 100;
   

	public static void main(String [] argument)
	
	{	
	
		char[] texte;        // déclacaration  d'une référence sur un tableau de caractères
		
		
		 int i;
		 int j;
		 
		 texte = compter.traiterTableau();
		 
		 
	     j = 0 ;
	     
	  while ( texte [j] != CARTERM)
	    		 {
	    			 j = j + 1; 
	    		 }
	    		 System.out.println ("nombre de caractère :" + j);
	    		 
	    		 
	    	 j  = j -1;	 
	    
	         i = 0;
	         
	        
	        
	 while ( i < j && (texte[j] == texte[i]))
		 
	     {
		 
			 i = i + 1;
	         j = j - 1;
		
	     }
	        System.out.println ("afficher les resultats de la recherche :" );
	
	if (i> j)
	{
		
		 System.out.println ("cest un palindrome:" );
	}
	else 
	{	
		System.out.println ("ce n'est pas un palindrome :" );
	}
	
	
	
	}	
	
	
}
