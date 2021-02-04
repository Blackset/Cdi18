/*  Classe      : ManipListeNom
    Auteur      : Yann Capelli	
    Mise à jour : 20 Ocotbre 2016
    Fonction    : Programme qui permet de manipuler une pile de nom classer alphabetiquement
*/
public class ManipListeNom
{
	
	private static final int MAX = 10;
	private static final int FINAL = -1;
	
	public static void main(String[] argument)
	{
		
		TableNom tableauNom = new TableNom();
		tableauNom.table  = new Element [MAX];
		String nom;
		
		initPile(tableauNom);		// initialisation du tableau
		do							// Boucle tant que l'utilisateur le choisi
		{
			System.out.println("Donner le nom a rentrer : ");
			nom = Lire.Chaine().toUpperCase();
			if (empiler(tableauNom, nom))
			{
				System.out.println(nom + " à été ajouté");
			}
			else
			{
				System.out.println("Tableau plein !!!!!");
			}
		} while (Dialogue.veutContinuer()); 
		System.out.println("DEPILLAGE : ");
		do							// Boucle tant que l'utilisateur le choisi
		{
			System.out.println("Donner le nom a retirer : ");
			nom = Lire.Chaine().toUpperCase();
			if (depiler(tableauNom, nom))
			{
				System.out.println(nom + " à été enlevé");
			}
			else
			{
				System.out.println("Tableau vide !!!!!");
			}
		 
		} while (Dialogue.veutContinuer()); 
		
	}
		
/* ******************************PROCEDURE **************************************/
	public static void initPile (TableNom tableauNom)
	{
		// Procédure qui initialise la table des noms à l'origine
		// tableauNom est la table a initialiser
		tableauNom.libre = 0;
		tableauNom.premier = FINAL;
		for (int i=0 ; i<MAX ; i++)
		{
		//while (tableauNom.libre  != MAX)
		//{
			tableauNom.table[tableauNom.libre]=new Element();
			tableauNom.table[tableauNom.libre].suivant = tableauNom.libre +1;
			tableauNom.libre ++;
		}
		tableauNom.table[MAX-1].suivant = FINAL;
		tableauNom.libre = 0;
	}
	
	public static boolean empiler (TableNom tableauNom , String nom)
	{
		// Fonction qui ajoute un nom dans une tableau de nom et son indice 
		// tableauNom est la table dans laquelle on souhaite ajouter le nom 
		// nom est le nom que l'on souhaite ajouter
		int i;
		int nouveau;
		int indicePrecedent;
		boolean estFait;
		if(tableauNom.libre == FINAL)		// Si le tableau est plein
		{
			estFait = false;
		}
		else
		{
			tableauNom.table[tableauNom.libre].nom = nom;	// ajout du nom dans la liste a la premiere case vide
			i = tableauNom.premier;
			indicePrecedent = FINAL;
			nouveau = tableauNom.libre;
			if (tableauNom.premier != FINAL)
			{
				
				while ( i != FINAL && nom.compareTo(tableauNom.table[i].nom)>0 )	// on compare les chaine pour trouver la place du nom 
				{
					
						indicePrecedent = i;
						i = tableauNom.table[i].suivant;
					
				}
			}
			tableauNom.libre = tableauNom.table[tableauNom.libre].suivant;	// modification de l'indice libre pour donner la nouvelle premiere case vide
			if (indicePrecedent==FINAL)			// Si l'element ajouté est le premier de la liste ou le plus petit
			{
				tableauNom.table[nouveau].suivant = tableauNom.premier;		// element ajouté 
				tableauNom.premier = nouveau;
			}
			else					// Si on insere l'element au milieu ou a la fin de la liste
			{
				tableauNom.table[indicePrecedent].suivant = nouveau;	// modifie l'indice de l'element ajouté pour renvoyer sur le prochaine libre
				tableauNom.table[nouveau].suivant = i;				// on modifie l'indice de l'element avant pour renvoyer sur celui que l'ont a ajoué
			}
			estFait = true;
		}
		return (estFait);
	}
	public static boolean depiler (TableNom tableauNom , String nom)
	{
		// Fonction qui permet d'enlever un nom de la table des noms
		// tableauNom est la table dans laquelle on souhaite ajouter le nom 
		// nom est le nom que l'on souhaite ajouter
		int i;
		int indicePrecedent=0;
		boolean estFait;
		if (tableauNom.premier == FINAL)		// Si le tableau est VIDE
		{
			estFait=false;
		}
		else
		{
			i = tableauNom.premier;
			while (i != FINAL && nom.compareTo(tableauNom.table[i].nom)!=0 )	// on compare les chaine pour trouver la place du nom 
			{
				indicePrecedent = i;
				i = tableauNom.table[i].suivant;
			}
			if (i==FINAL)	// Si le nom n'est pas dans la liste
			{
				estFait=false;
				System.out.println("Le nom n'est pas dans la liste !!!");
			}
			else		// Si on a trouvé le nom
			{
				tableauNom.table[i].nom ="";
				if (i==tableauNom.premier)	// Si on supprime le premier element de la liste de nom
				{
					tableauNom.premier = tableauNom.table[i].suivant;	// modifie l'indice qui renvoi au premier nom de la liste
				}
				else	// Si on supprime un element au milieu ou a la fin de la liste
				{
					tableauNom.table[indicePrecedent].suivant = tableauNom.table[i].suivant;
				}
				tableauNom.table[i].suivant = tableauNom.libre;
				tableauNom.libre = i;
				estFait = true;
			}
		}
		return (estFait);
	}
	public static void affichageTest (TableNom tableauNom)
	{
		for (int i =0 ; i<MAX ; i++)
		{
			System.out.println(i+"  "+tableauNom.table[i].nom + "\t" +tableauNom.table[i].suivant);
		}
	}
}

/* ****************************** CLASSE ***************************************/
class Element	// type des éléments de la table des noms 
{
	String nom;		// nom est le nom contenu dans la table 
	int suivant;	// indice du nom suivant dans la table 
}
class TableNom	// type des tables de noms 
{
	Element [] table;	// table permet de ranger les informations  
	int libre;			// libre est le premier élément de la liste libre 
	int premier;		// premier est le premier élément de la liste des noms 
}






