/******************************************************************
  Programme			Main.java  Chap. 7 Exo. 5 projet Listenom
  Auteur            JCC
  Mise a jour       janv 2004
  Fonction	
  - codage algorithme de la mise � jour d'une liste alphab�tique de 
pr�noms
******************************************************************/
class Element // un �l�ment du tableau
{
	String nom;			// nom de la personne 
	int suivant;		// indice de nom suivant dans la table
}
class TableAlpha // tableau des pr�noms
{
	public static final int TAILLE = 4;	//taille maximale de 1a table
	public static final int FINAL = -1;		// indicateur de fin de liste
	Element[] table;	// liste des pr�noms
	int libre;			// premier �l�ment libre
	int premier;		// premier pr�nom de la liste
}
public class Main
{
	public static void main (String[] args)
	{
		char car;					// choix de l'utilisateur pour ajouter, enlever, initialiser
		TableAlpha table = new TableAlpha();	//liste alphab�tique des noms
		
		//initialisation de la table
		init(table);
		
		do
		{
			System.out.println("que voulez-vous faire ?"); 
			System.out.println("a pour ajouter"); 
			System.out.println("i pour initialiser"); 
			System.out.println("e pour enlever"); 
			System.out.println("autre chose pour arreter");
			car = Lire.c();
			
			// selon le caract�re traiter
			switch (car )
			{
				case 'a':{	int ok;
							String val; // pour ajouter un nom
							System.out.print("donnez le nom a ajouter a la liste : ");
							val = Lire.S();
							ok = ajouter(table,val);
							if (ok == 0)
							{// le nom a �t� ajout� � la liste
								System.out.println("nom ajoute a la liste");
							}
							else if (ok == 1)
							{// le nom est d�j� dans la liste
								System.out.println("Sorry! le nom est deja dans la liste");
							}
							else
							{
								System.out.println("Sorry! la liste est pleine");
							}
							lister(table);
							break;
						 }
				case 'e':{	int ok;
							String nom; // nom a enlever de la liste
							System.out.print("donnez le nom a enlever de la liste : ");
							nom = Lire.S();
							ok = enlever(table,nom);
							if ( ok== 0 )
							{// le nom a �t� d�pil� de la liste
								System.out.println("le nom a ete enleve de la liste");
							}
							else if ( ok == -1)
							{// la liste �tait vide
								System.out.println("Sorry! la liste est vide");
							}
							else
							{
								System.out.println("Sorry! le nom n'est pas dans la liste");
							}
							lister(table);
							break;
						 }
				case 'i':	init(table);
							break;
				default: // ne rien faire
			}
			
		}while ((car == 'e')||(car == 'a')||(car == 'i'));
		// arr�t quand ni e, ni a, ni i	
	}
	public static int ajouter(TableAlpha tabnom, String nom )
	// Cette fonction permet d�ajouter un nom dans la table des noms.				
	// Si la table de noms est pleine la fonction ne fait rien, mais retourne -1			
	// Si le nom est d�j� pr�sent dans la table de noms, la fonction ne fait rien et retourne la valeur 1 
		// tabnom est	en entr�e la table de noms dans laquelle on veut ajouter			
		// 				en sortie la table de nom dans laquelle nom a pris sa place si possible.	
		// nom est le nom � ranger dans le tableau.						
		// la fonction retourne		-1 si la table est pleine				
		//							 0 si le nom est rang� dans la table			
		//							 1 si le nom �tait d�j� dans la table			
		// la constante FINAL a �t� d�finie en amont et repr�sente la fin de liste	
	{
		int ok;		// ok est le code de retour de la fonction		
		int pr�c�de;// pr�c�de est le nom avant le nom inspect�	
		int ptnom;	// ptnom est l�indice du nom inspect�			
 		int nouvel;	// nouvel est l�indice ou on va ranger le nom	

		if (tabnom.libre == TableAlpha.FINAL)    // si la table de noms est pleine, rajout impossible 	
		{
			ok = -1;
		}
		else	// recherche du lieu de rangement du nom dans le tableau 	
		{
			pr�c�de = TableAlpha.FINAL;
			ptnom = tabnom.premier;

			// parcours de la liste des noms jusqu�� trouver le nom � l�indice ptnom	 
			// sa place entre pr�c�de et ptnom, ou la fin de liste 			
			while (( ptnom != TableAlpha.FINAL ) && ( tabnom.table [ ptnom ].nom .compareTo( nom )<0))
					// arr�t en fin de liste, ou quand on trouve		
					// un nom plus grand ou �gal dans la table		
			{
				pr�c�de = ptnom;
				ptnom = tabnom.table [ ptnom ].suivant;
			}

			// soit on a trouv� le nom, soit il faut ajouter le nom en t�te, soit il faut	
			// ajouter le nom en milieu ou fin de liste.				
			if (( ptnom != TableAlpha.FINAL ) && ( nom.equals( tabnom.table [ ptnom ].nom )))   
			{	// nom trouv� dans la table des noms 
				ok = 1;
			}
			else
			{// rangement du nom dans la table des noms 
				ok = 0;
				nouvel = tabnom.libre;
				tabnom.table [ nouvel ].nom = nom;

				// remise � jour la liste des libres 
				tabnom.libre = tabnom.table [ tabnom.libre ].suivant;

				// soit on ins�re le nom en t�te de liste, soit on l�ins�re dans la liste 
				if (pr�c�de == TableAlpha.FINAL)    
				{
					// soit c�est le premier �l�ment de la table de noms	
					// soit nom est le plus petit nom de la table		
					tabnom.premier = nouvel;
				}
				else
				{
					// soit on ins�re au milieu de la liste de noms	
					// soit en fin de liste de noms			
					tabnom.table [ pr�c�de ].suivant = nouvel;
				}
				tabnom.table [ nouvel ].suivant = ptnom;
			}
		}

		// retour du compte rendu de l�ajout 
		return ok;
	}
	public static void init(TableAlpha tabnom)
	// Cette proc�dure permet d�initialiser une table de noms, c�est � dire 	
	// qu�elle n�ait aucun �l�ment					
		// tabnom est la table de noms initialis�e					
		// la constante FINAL a �t� d�finie en amont et repr�sente la fin de liste	
	{
		// cr�ation de la table
		tabnom.table = new Element[TableAlpha.TAILLE];
		// il n�y a pas d��l�ment dans la table des noms 
		tabnom.premier = TableAlpha.FINAL ;

		// construction des �l�ments de la table
		for (int i = 0; i<TableAlpha.TAILLE; i++)
		{
			tabnom.table [ i ] = new Element();
		}
		
		// construction de la liste des libres 
		for (int i = 0; i<TableAlpha.TAILLE-1; i++)
		{
			tabnom.table [ i ].suivant = i + 1;
		}
		
		// insertion de la fin de la liste des libres 
		tabnom.table [ TableAlpha.TAILLE-1 ].suivant = TableAlpha.FINAL ;

		// initialisation au d�but de la liste des libres 
		tabnom.libre = 0;
	}
	public static void lister(TableAlpha tabnom)
	// Cette proc�dure permet d�de lister une table de noms, dans l'ordre 	
		// tabnom est la table de noms initialis�e					
		// la constante FINAL a �t� d�finie en amont et repr�sente la fin de liste	
	{
		int i = tabnom.premier;

		if ( i == TableAlpha.FINAL )
		{// table vide
			System.out.println("la liste est vide");
		}
		else
		{// liste non vide
			System.out.print("voici la liste : ");
			while ( i != TableAlpha.FINAL ) // arr�t en fin de liste
			{
				System.out.print(tabnom.table[i].nom+" ");
				i = tabnom.table[i].suivant;
			}
			System.out.println();
		}

	}
	public static int enlever(TableAlpha tabnom, String nom)
	// Cette fonction permet d�enlever un nom de la table des noms.				
	// Si la table de noms est vide la fonction ne fait rien, mais retourne -1.			
	// Si le nom est absent de la table de noms, la fonction ne fait rien, mais retourne la valeur 1. 
		// tabnom est	en entr�e la table de noms dans laquelle on veut enlever			
		// 				en sortie la table de nom dans laquelle nom a �t� enlev� si possible.	
		// nom est le nom � enlever du tableau.							
		// la fonction retourne	-1 si la table est vide				
		//		0  si le nom est enlev� de la table		
		//		1  si le nom n��tait pas dans la table		
		// la constante FINAL a �t� d�finie en amont et repr�sente la fin de liste	
	{

		int ok;		// ok est le code de retour de la fonction		
		int pr�c�de;// pr�c�de est le nom avant le nom inspect�	
		int ptnom;	// ptnom est l�indice du nom inspect�		

		// si la table de noms est vide on ne peut pas enlever 

		if (tabnom.premier == TableAlpha.FINAL)
		{
			ok = -1;
		}
		else
		{	// recherche du nom dans le tableau 
			pr�c�de = TableAlpha.FINAL;
			ptnom = tabnom.premier;

			// parcours de la liste des noms jusqu�� trouver le nom � l�indice ptnom, 
			// sa place entre pr�c�de et ptnom, ou la fin de liste 

			while (( ptnom != TableAlpha.FINAL ) && ( tabnom.table[ ptnom ].nom.compareTo(nom)<0))    
			{	// arr�t en fin de liste, ou quand on trouve	
				// un nom plus grand ou �gal dans la table	
				pr�c�de = ptnom;
				ptnom = tabnom.table [ ptnom ].suivant;
			}

			// soit on a trouv� le nom, et on a le pr�c�dent, soit on ne l�a pas trouv�	
			if (( ptnom == TableAlpha.FINAL ) || ( !nom.equals(tabnom.table [ ptnom ].nom )))    
			{	// nom pas trouv� dans la table des noms 
				ok = 1;
			}
			else
			{	// enlever le nom de la table des noms 
				ok =0;

				// soit on enl�ve le nom en t�te de liste, soit on l�enl�ve dans la liste 
				if ( pr�c�de == TableAlpha.FINAL )   // c�est le premier �l�ment de la table de noms 	
				{
					tabnom.premier = tabnom.table [ ptnom ].suivant;
				}
				else	// soit on enl�ve dans la liste de noms		
				{
					tabnom. table [ pr�c�de ].suivant = tabnom.table [ ptnom ].suivant;
				}

				// il faut raccrocher ptnom � la liste des libres 
				tabnom.table [ ptnom ].suivant = tabnom.libre;
				tabnom.libre = ptnom;
			}
		}
		// retour du compte rendu du retrait 
		return ( ok );

	}
}
