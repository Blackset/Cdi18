/****************************************************************
Programme     :  Calcul.java
Auteur        :  Corre Jean Christophe
Mise à jour   :  nov 2003 jcc
Fonction      :  Démo sur les passages de paramètres en entrée 
sortie et en sortie. Définition de la fonction calcul de la classe
Calcul.	Pour un entier, cette fonction calcule son carré, sa racine
carrée, et nous dit si le nombre est positif pour que la racine 
carrée ait un sens. l'entier est incrémenté en sortie de fonction
******************************************************************/
public class Calcul
{
	
	// Fonction calcul: elle incrémente l'entier donné, après avoir
	// calculé son carré, sa racine, et vérifié qu'il est positif
	// Entrée Sortie: un entier en entrée un nombre ( int )
	//							en sortie le nombre incrémenté
	// Sortie: le carré du nombre ( long )
	//		   sa racine carré ( double )
	// En valeur de retour: un booléen vrai si le nombre est positif
	
	public static boolean calcul( Entier nombre, EntierLong carre, Reel racine)
	{
		int val = nombre.getVal ();			// valeur du nombre en entrée
		boolean positif;
		nombre.setVal (val+1);				// incrémenter le nombre
		carre.setVal (val*val);				// calcul du carré
		
		positif = (val>=0);
		if ( positif)
		{
			racine.setVal(Math.sqrt(val));	// calcul de la racine carrée
		}
		
		return positif;
	}
}
