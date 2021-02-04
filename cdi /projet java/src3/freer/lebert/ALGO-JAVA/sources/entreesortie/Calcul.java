/****************************************************************
Programme     :  Calcul.java
Auteur        :  Corre Jean Christophe
Mise � jour   :  nov 2003 jcc
Fonction      :  D�mo sur les passages de param�tres en entr�e 
sortie et en sortie. D�finition de la fonction calcul de la classe
Calcul.	Pour un entier, cette fonction calcule son carr�, sa racine
carr�e, et nous dit si le nombre est positif pour que la racine 
carr�e ait un sens. l'entier est incr�ment� en sortie de fonction
******************************************************************/
public class Calcul
{
	
	// Fonction calcul: elle incr�mente l'entier donn�, apr�s avoir
	// calcul� son carr�, sa racine, et v�rifi� qu'il est positif
	// Entr�e Sortie: un entier en entr�e un nombre ( int )
	//							en sortie le nombre incr�ment�
	// Sortie: le carr� du nombre ( long )
	//		   sa racine carr� ( double )
	// En valeur de retour: un bool�en vrai si le nombre est positif
	
	public static boolean calcul( Entier nombre, EntierLong carre, Reel racine)
	{
		int val = nombre.getVal ();			// valeur du nombre en entr�e
		boolean positif;
		nombre.setVal (val+1);				// incr�menter le nombre
		carre.setVal (val*val);				// calcul du carr�
		
		positif = (val>=0);
		if ( positif)
		{
			racine.setVal(Math.sqrt(val));	// calcul de la racine carr�e
		}
		
		return positif;
	}
}
