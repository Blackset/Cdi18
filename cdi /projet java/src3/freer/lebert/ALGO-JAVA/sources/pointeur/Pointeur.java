/********************************************************************
Programme     :  Pointeur.java
Auteur        :  Corre Jean Christophe
Mise � jour   :  nov 2003 jcc
Fonction      :  D�mo sur l'utilisation des pointeurs en java � l'aide
				 des r�f�rences sur les enregistrements
**********************************************************************/
class Element
{
	int donn�e;			// information port�e par une liste
	Element suivant;	// �l�ment suivant de la liste
}
public class Pointeur
{
	public static void main (String[] args)
	{
		Element tete= null;	// la liste est vide
		
		// remplissage de la liste
		
		for ( int i = 1; i < 6; i++)
		{
			Element e = new Element();	// creation d'un �l�ment de la liste
			e.donn�e = i*i;				// mise � jour de la donn�e
			e.suivant = tete;			// cha�nage des elements (ajout en t�te)
			tete = e;					// mise � jour de la nouvelle t�te
		}
		
		// parcours et affichage de la liste
		
		Element courant= tete; // courant va parcourir la liste
		
		while (courant != null) // arr�t en fin de liste
		{
			System.out.println(courant.donn�e);
			courant = courant.suivant; // courant r�f�rence maintenant l'�l�ment
									  // suivant dans la liste
		}
		Lire.Attente ();
	}
}
