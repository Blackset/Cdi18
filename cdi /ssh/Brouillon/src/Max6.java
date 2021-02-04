/*  Classe      : Max
 Auteur      : Halim, revu par Lécu Régis
 Mise à jour : 20 Octobre 2015
 Fonction    : ce programme permet la réalisation d'une fonction  "voulez-vous continue" sans parametre*/


public class Max6

{
	
	public static boolean veutContinuer()  // si on veut continuer ou pas
	
	{
		
		boolean resultats;
		char reponses;
		
		
		System.out.println(" voulez vous Continuer : ");
		
		reponses = Character.toLowerCase (Lire.c());
		
		while ( reponses != 'o' && reponses != 'n')
			
		{	
			System.out.println(" voulez vous Continuer : ");
		
			reponses = Character.toLowerCase (Lire.c());
		}
			if ( reponses == 'o')
			{
			   resultats = true;
			}
			else 
			{
			resultats = false;
			}
		
		
		return (resultats);
		}	
	
	}
	
	
	
	    
	
	
	
	
	
	
	
	

