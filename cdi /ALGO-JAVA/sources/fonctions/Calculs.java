 /*************************************************************************
  Nom du programme  :  Calculs.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001, maj nov 2033 jcc
  Fonction          :  biblioth�ques de fonctions  
 *************************************************************************/

public class Calculs
{	
	// Fonction Puissance
	// Si le calcul est possible (exposant >= 0), cette fonction
	// retourne la puissance "exposant" de l'entier "operande", sinon
	// elle retourne 0
	//             
	// Entree 
	// operande : entier dont on veut la puissance
	// exposant : exposant positif ou nul 
	// Valeur de retour
	// op�rande � la puissance exposant
	
	public static int puissance (int operande, int exposant)
	{ 	  
		int result;
			 
		if (exposant < 0)
		{
			result = 0;
		}
		else
		{ 
			result = 1;
			for (int nbfois = 1; nbfois <= exposant; nbfois ++ ) 
			{
				result = result * operande;
			}
		}  
		return result;      
	}
 
	// Fonction Factorielle
	// Si le calcul est possible (n >= 0), cette fonction
	// retourne la factorielle de "n", sinon elle retourne 0
	            
	// Entree 
	// n : entier dont on veut calculer la factorielle  
	// Valeur de retour
	// n!
	public static int factorielle (int n)
	{ 	  
		int result;
		 
		if (n < 0)
		{
			result = 0;
		}
		else
		{ 
			result = 1;
			for (int nbfois = 1; nbfois  <= n ; nbfois ++ ) 
			{
				result = result * nbfois ;
			}
		}  
		return result;      
	}
}  
