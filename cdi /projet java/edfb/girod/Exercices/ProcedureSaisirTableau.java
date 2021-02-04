/*************************************************************************
 * Programme : ProcedureRemplirTableau.java - Auteur : EGI 
 * Date : 10/2016 
 * Fonction : Procedure pour remplir un tableau de caract�res
 * � partir d'une cha�ne lue au clavier et termin� par un '.'
 ************************************************************************/
public class ProcedureSaisirTableau
{
	/**Remplir un tableau
	 * @return de caract�res avec un . comme terminateur
	 */
	public static char[] SaisirTableau(int MAX)
	{
			
			
			final char POINT = '.';
			String chaine = new String (); // // chaine de caract�re lue au clavier
			char[] tabCaracs = new char[MAX]; // tableau de caract�re qui sera remplie 
											// � partir de la cha�ne de caract�res chaine

			
			System.out.println  ("Saisir une cha�ne de 8 caract�res finis par un point (.)  : ");
			chaine = Lire.S();
			
			
			int i = 0; // indice de parcours de chaineLue et de tabCar

			while ((i < chaine.length()) && (chaine.charAt(i) != POINT) && (i < tabCaracs.length - 1))
			// on arr�te de copier les lettres quand on a fini de parcourir chaineLue (i>=chaineLue.length())
			// ou quand on rencontre un '.' (chaineLue.charAt(i)==POINT)
			// ou quand on arrive � l'avant derni�re case de tabCaracs (i>=tabCaracs.length-1) (on laisse la derni�re case libre pour y ajouter un '.')
			{
				tabCaracs[i] = chaine.charAt(i);
				++i;
			}

			tabCaracs[i] = POINT;
			
			// System.out.println  (tabCaracs);
			
			return tabCaracs;

			// arr�t quand i = taille du tableau ou quand un point est lu
		    // tabCaracs.length est la taille du tableau
						
						

			// Lire.Purge();
			// Lire.Attente ();

								
	}			
								
}

