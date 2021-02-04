/*************************************************************************
 * Programme : ProcedureRemplirTableau.java - Auteur : EGI 
 * Date : 10/2016 
 * Fonction : Procedure pour remplir un tableau de caractères
 * à partir d'une chaîne lue au clavier et terminé par un '.'
 ************************************************************************/
public class ProcedureSaisirTableau
{
	/**Remplir un tableau
	 * @return de caractères avec un . comme terminateur
	 */
	public static char[] SaisirTableau(int MAX)
	{
			
			
			final char POINT = '.';
			String chaine = new String (); // // chaine de caractère lue au clavier
			char[] tabCaracs = new char[MAX]; // tableau de caractère qui sera remplie 
											// à partir de la chaîne de caractères chaine

			
			System.out.println  ("Saisir une chaîne de 8 caractères finis par un point (.)  : ");
			chaine = Lire.S();
			
			
			int i = 0; // indice de parcours de chaineLue et de tabCar

			while ((i < chaine.length()) && (chaine.charAt(i) != POINT) && (i < tabCaracs.length - 1))
			// on arrête de copier les lettres quand on a fini de parcourir chaineLue (i>=chaineLue.length())
			// ou quand on rencontre un '.' (chaineLue.charAt(i)==POINT)
			// ou quand on arrive à l'avant dernière case de tabCaracs (i>=tabCaracs.length-1) (on laisse la dernière case libre pour y ajouter un '.')
			{
				tabCaracs[i] = chaine.charAt(i);
				++i;
			}

			tabCaracs[i] = POINT;
			
			// System.out.println  (tabCaracs);
			
			return tabCaracs;

			// arrêt quand i = taille du tableau ou quand un point est lu
		    // tabCaracs.length est la taille du tableau
						
						

			// Lire.Purge();
			// Lire.Attente ();

								
	}			
								
}

