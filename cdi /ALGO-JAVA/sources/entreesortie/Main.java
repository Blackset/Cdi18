/****************************************************************
Programme     :  Main.java
Auteur        :  Corre Jean Christophe
Mise à jour   :  nov 2003 jcc
Fonction      :  Démo sur les passages de paramètres en entrée 
sortie et en sortie. Appel de la fonction calcul de la classe
Calcul.
******************************************************************/
public class Main
{
	public static void main (String[] args)
	{
		// test de la fonction calcul
		
		Entier valeur= new Entier();
		EntierLong square = new EntierLong();
		Reel root = new Reel();
		
		valeur.setVal(45); // valeur en entrée du nombre
		
		System.out.println("valeur du nombre en entree " +
						   valeur.getVal());
		
		boolean res = Calcul.calcul(valeur, square, root);
		
		System.out.println("valeur du nombre en sortie " +
						   valeur.getVal()); 
		System.out.println("valeur du carre " + square.getVal());
		
		if ( res == true)	//  if ( res ) tout simplement
		{
			System.out.println("valeur de la racine carree " 
							   + root.getVal());
		}
		else
		{
			System.out.println("pas de racine carree");
		}	

		Lire.Attente();
	}
}
