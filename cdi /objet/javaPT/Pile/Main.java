/*********************************************************************
  Nom du programme  :  Main.java
  Auteur            :  JCC 
  Mise a jour       :  janvier 2004 
  Fonction          :  gestion d'une pile ( version non objet!!! )

**********************************************************************/
class Pile
{
	static final int TAILLE = 10;	// taille maximum de la pile
	int indice;						// nombre d'�l�ments dans la pile
	int[] table = new int [TAILLE];	// tableau contenant les informations
}
public class Main
{
	public static void main(String[] arg)
	{
		char car; // caract�re pour savoir si on empile, d�pile, initialise ou stoppe
		Pile p = new Pile();	// cr�ation d'une pile
		
		do
		{
			System.out.println("que voulez-vous faire ?"); 
			System.out.println("e pour empiler"); 
			System.out.println("i pour initialiser"); 
			System.out.println("d pour depiler"); 
			System.out.println("autre chose pour arreter");
			car = Lire.c();
			
			// selon le caract�re traiter
			switch (car )
			{
				case 'e':{	boolean ok;
							int val; // pour empiler la valeur
							System.out.print("donnez la valeur a empiler : ");
							val = Lire.i();
							ok = empiler(p,val);
							if ( ok )
							{// la valeur a �t� empil�e
								System.out.println("valeur empilee ");
							}
							else
							{// la pile �tait pleine
								System.out.println("Sorry! pile pleine");
							}
							break;
						 }
				case 'd':{	boolean ok;
							Entier valeur = new Entier(); // pour r�cup�rer la valeur
							ok = depiler(p,valeur);
							if ( ok )
							{// une valeur a �t� d�pil�e
								System.out.println("valeur depilee : "+valeur.getVal());
							}
							else
							{// la pile �tait vide
								System.out.println("Sorry! pile vide");
							}
							break;
						 }
				case 'i':	init_pile(p);
							break;
				default: // ne rien faire
			}
			
		}while ((car == 'e')||(car == 'd')||(car == 'i'));
		// arr�t quand ni e, ni d, ni i	
	}
	public static void init_pile ( Pile lifo )
	// Cette proc�dure permet d�initialiser une pile, c�est � dire qu�elle n�ait aucun �l�ment	

		// en sortie lifo est la pile initialis�e								
	{
		// il n�y a pas d��l�ment dans la pile 
		lifo.indice = 0;
	}

	public static boolean empiler (  Pile lifo, int val ) 
	// Cette fonction permet d�ins�rer un �l�ment dans la pile.			
	// Si la pile est pleine, la fonction ne fait rien, mais retourne faux.		
		// lifo est en entr�e la pile dans laquelle on veut empiler			
		// 			en sortie la pile dans laquelle val est empil� si possible		
		// val est la valeur � empiler							
		// la fonction retourne vrai si val a �t� empil�, faux sinon			
	{
		boolean ok;	// ok est vrai si l�empilage se passe bien
	
		// si la pile est pleine on ne peut pas empiler 
		if (lifo.indice == Pile.TAILLE ) 
		{
			ok = false;
		}
		else	// on range l��l�ment dans le tableau 
		{
			lifo.table [ lifo.indice ] = val;
			lifo.indice ++;
			ok = true;
		}

		// on retourne le compte rendu de l�empilage 
		return ( ok );
	}

	public static boolean depiler ( Pile lifo, Entier val )
	// Cette fonction permet de r�cup�rer l��l�ment au sommet de la pile.	
	// Si la pile est vide, la fonction ne fait rien, mais retourne faux		
		// lifo est en entr�e la pile dans laquelle on veut prendre une valeur 	
		//		en sortie la pile sans le sommet, si possible			
		// val est l�entier qui �tait au sommet de la pile				
		// la fonction retourne vrai si val a �t� d�pil�e, faux sinon		
	{
		boolean ok;	// ok est vrai si le d�pilage se passe bien   
		
		// si la pile est vide on ne peut pas d�piler 
		if (lifo.indice == 0)
		{
			ok = false;
		}
		else
		{  // on prend le sommet du tableau 
			lifo.indice --;
			val.setVal(lifo.table [ lifo.indice ]);
			ok =true;
		}
		// on retourne le compte rendu de l�empilage 
		return ( ok );
	}
}
