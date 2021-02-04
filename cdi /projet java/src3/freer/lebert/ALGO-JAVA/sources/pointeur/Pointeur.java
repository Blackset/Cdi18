/********************************************************************
Programme     :  Pointeur.java
Auteur        :  Corre Jean Christophe
Mise à jour   :  nov 2003 jcc
Fonction      :  Démo sur l'utilisation des pointeurs en java à l'aide
				 des références sur les enregistrements
**********************************************************************/
class Element
{
	int donnée;			// information portée par une liste
	Element suivant;	// élément suivant de la liste
}
public class Pointeur
{
	public static void main (String[] args)
	{
		Element tete= null;	// la liste est vide
		
		// remplissage de la liste
		
		for ( int i = 1; i < 6; i++)
		{
			Element e = new Element();	// creation d'un élément de la liste
			e.donnée = i*i;				// mise à jour de la donnée
			e.suivant = tete;			// chaînage des elements (ajout en tête)
			tete = e;					// mise à jour de la nouvelle tête
		}
		
		// parcours et affichage de la liste
		
		Element courant= tete; // courant va parcourir la liste
		
		while (courant != null) // arrêt en fin de liste
		{
			System.out.println(courant.donnée);
			courant = courant.suivant; // courant référence maintenant l'élément
									  // suivant dans la liste
		}
		Lire.Attente ();
	}
}
