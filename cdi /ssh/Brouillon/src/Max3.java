/*  Classe      : Max
 Auteur      : Halim, revu par L�cu R�gis
 Mise � jour : 20 Octobre 2015
 Fonction    : ce programme permet de calculer les N premiers multiples d'un nombre entier X */

public class Max3

{

	
	public static void main(String[] argument)
	
{
		int entierx;          // le nombre entier choisi par l'utilisateur
		int multiplesN;       // multiple de x rentr� par l'utilisateur
		int resultats;        
		
		System.out.println(" Entrez un nombre entierx ");        // On demande � l'utilisateur d'ecrire un entier X
		
		entierx  = Lire.i();
		
		
		System.out.println (" entrez les N premiers multiples");  // on demande � l'utilisateur d'�crire les N premier entier
		
	    multiplesN = Lire.i();
	    
	    
		
		 for ( int i = 1;  i <= multiplesN;  i = i + 1 )
		 {
	  
	
		resultats = i * entierx;
		
		System.out.println( "le multiple "+i+" de " + entierx + " est: " + resultats); 
		

			
		 }
           	
		}
		
 }