/*********************************************************************************
   Programme		   Recursive.java
   Auteur			   Lécu Regis
   Mise à jour		   février 2001, maj nov 2003 jcc
   Fonction

   La fonction AppelRecursif
	- affiche le message "Vous entrez dans la fonction AppelRecursif au niveau d'appel I" 
	- demande à l'utilisateur s'il veut continuer
    et se rappelle elle-même si l'utilisateur répond oui , en passant comme paramètre I + 1
	- dans le cas contraire ,la procédure  affiche le message
    "Vous sortez de la procedure AppelRecursif au niveau d'appel I " et se termine

	Il est bien entendu que pour programmer ce problème, nous n'utiliserions pas
	d'appels récursifs, ( une boucle do...while suffit ), mais nous ne faisons que
	visualiser le mécanisme de la récursivité.
*********************************************************************************/

public class Recursive
{
	public static void main (String arg[])
	{
		AppelRecursif ( 1 ) ;
		Lire.Attente ();
	}

	public static void AppelRecursif (int niveau)
	{		
		System.out.println ("Vous entrez dans AppelRecursif au niveau " + niveau);
	
		if (Lire.Question ("Voulez-vous continuer"))
		{
			AppelRecursif (niveau + 1);	// avec le niveau d'appel + 1
		}
	
		System.out.println ("Vous sortez de AppelRecursif au niveau " + niveau);
	}
}
