
/*  Classe      : Max
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 20 Octobre 2015
    Fonction    : ce programme permet la réalisation progressive d'une calculette */ 

    
    public class Max 

	
   { 
    	public static final int MIN = -1000;
    	public static final int MAX = 1000;
	
	public static void main(String [] argument)
	{
    

		
	int entier;   // entier rentré par l'utilisateur
	
	System.out.print (" l'entier à tester : ");  // on affiche l'entier
	
	entier = Lire.i();
	
	
	if ( entier >= MIN && entier <= MAX )
	{
	System.out.println("c'est un entier compris entre MIN et MAX :" + entier );
	}	
    else 
	 {
    entier = 0 ;
		  
	System.out.println ( "cet entier ne rentre pas dans l'interval  :" + entier  );
		
	 }
}
	}