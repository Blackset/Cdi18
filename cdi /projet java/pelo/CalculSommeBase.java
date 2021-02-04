/*  Classe      : CalculSommeBase
    Auteur      : Yann Capelli	
    Mise à jour : 20 Ocotbre 2016
    Fonction    : Programme qui calcul a partir d'une liste d'entier la somme des nombres contenu dans cette liste en base quelconque
*/
public class CalculSommeBase
{
	private static final int TAILLE = 80;
	private static final char STOP = '0';
	private static final char ESPACE = ' ';

	public static void main(String[] argument)
	{
		char []listeNombre = new char [TAILLE];
		int base;
		int somme;
		
		System.out.println("Donner la liste des nombres à additionner en terminant par 0 :");
		listeNombre = RemplissageTableau.remplirTab();
		System.out.println("Donner la base dans laquelle sont les nombre de la liste :");
		base = Lire.i();
		somme = calculSomme(listeNombre, base);
		System.out.println("La somme des nombre est : "+somme);
	}
	public static int calculSomme (char[] listeNombre , int base)
	{
		Entier i = new Entier() ;
		int somme = 0;
		int nombre = 0;
		i.setVal(0);
		do
		{
			while (listeNombre[i.getVal()] == ESPACE)
			{
				i.incr();
			}
			if (listeNombre[i.getVal()] != STOP)
			{
				nombre = calculNombre(listeNombre,base,i);
				somme += nombre;
			}
			
		}
		while (listeNombre[i.getVal()]!=STOP);
		
		return somme;		
	}
	private static int calculNombre(char[] listeNombre, int base, Entier i)
	{
		int nombre=0;
		do
		{
			nombre = nombre*base + Character.getNumericValue(listeNombre[i.getVal()]);
			i.incr();
		}
		while (listeNombre[i.getVal()]!=ESPACE);
		return nombre;
	}
}