/*  Classe      : ManipPileEntier
    Auteur      : Yann Capelli	
    Mise à jour : 20 Ocotbre 2016
    Fonction    : Programme qui permet de manipuler une pile d'entier
*/
public class ManipPileEntier
{
	
	private static final int MAX = 50;
	
	public static void main(String[] argument)
	{
		
		Pile pileEntier = new Pile();
		pileEntier.table = new int [MAX];
		int valeurE;		
		Entier valeur = new Entier();
		initPile(pileEntier);		
		do
		{
			System.out.println("Donner a valeur a rentrer : ");
			valeurE = Lire.i();
			if (empiler(pileEntier, valeurE))
			{
				System.out.println(valeurE + " à été ajouté");
			}
			else
			{
				System.out.println("Tableau plein !!!!!");
			}
		} while (Dialogue.veutContinuer()); 
		System.out.println("DEPILLAGE : ");
		do
		{
			if (depiler(pileEntier, valeur))
			{
				System.out.println(valeur.getVal() + " à été enlevé");
			}
			else
			{
				System.out.println("Tableau vide !!!!!");
			}
		 
		} while (Dialogue.veutContinuer()); 
		
	}
		
/* ******************************PROCEDURE **************************************/
	public static void initPile (Pile pileEntier)
	{
		// Procédure qui initialise la pile
		// pileEntier est la pile initialisée
		pileEntier.indice = 0;		
	}
	public static boolean empiler (Pile pileEntier , int valeur)
	{
		// Fonction qui permet d'inserer un element dans la pile
		// Si la pile est pleine alors la fonction ne fait rien et renvoi FAUX
		// pileEntier es la pile dans laquelle on veut empiler un element
		// valeur est l'element a empiler
		// Retourne VRAI si on a ajouté l'element a la pile et FAUX sinon
		boolean estFait;
		
		if (pileEntier.indice != MAX)	// Si on est pas a la fin de la pile alors rajoute l'element
		{
			pileEntier.indice ++;
			pileEntier.table[pileEntier.indice] = valeur;						
			estFait = true;
		}
		else		// Si la fin de la liste est atteinte alors pas d'operation donc retourne FAUX
		{
			estFait = false;
		}
		return estFait;
	}
	public static boolean depiler (Pile pileEntier , Entier valeur)
	{
		// Fonction qui permet de recperer e dernier element de la pile
		// Si la pile est vide alors la fonction ne fait rien et renvoi FAUX
		// pileEntier est la pile dans laquelle on veut recuperer la valeur
		// valeur est l'element que l'ont veu recuperer
		// Retourne VRAI si l'element a été récuperer et FAUX sinon 
		boolean estFait;
		if (pileEntier.indice == 0)		// Si la liste est vide on ne fait rien
		{
			estFait = false;
		}
		else		// Si la liste n'est pas vide alors on sors l'element a l'indice courant et on decremente l'indice
		{
			valeur.setVal(pileEntier.table[pileEntier.indice]);
			pileEntier.indice --;
			estFait = true;
		}		
		return estFait;
	}
}

/* ****************************** CLASSE ***************************************/
class Pile
{
	int [] table;	// Table dans laquelle sont rangé les entiers
	int indice;		// Nombre d'element contenu dans table
}