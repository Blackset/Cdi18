
class Element
{
	String nom;
	int suivant;
}

class TableNom
{
	Element[] table = new Element[GererListeNoms.TAILLE];
	int libre;
	int premier;
}

public class GererListeNoms
{
	public static final int FIN = -1;
	public static final int TAILLE = 10;

	public static void initialiserPile(TableNom pTab)
	{
		pTab.libre = 0;
		pTab.premier = FIN;
		for (int i = 0; i < TAILLE; i = pTab.table[i].suivant)
		{
			pTab.table[i] = new Element();
			pTab.table[i].suivant = i + 1;
		}
		pTab.table[TAILLE - 1].suivant = FIN;
	}

	public static boolean ajouterNom(TableNom pTab, String pNom)
	{
		boolean succes = false;
		int prec = 0;
		int suiv = pTab.premier;

		if (pTab.libre != FIN)
		{
			pTab.table[pTab.libre].nom = pNom;
			int temp = pTab.libre;
			pTab.libre = pTab.table[pTab.libre].suivant;
			if (pTab.premier != FIN)
			{
				while (suiv != FIN && pNom.compareTo(pTab.table[suiv].nom) > 0)
				{
					prec = suiv;
					suiv = pTab.table[suiv].suivant;
				}
				pTab.table[prec].suivant = temp;
			}
			else
			{
				pTab.premier = temp;
			}
			succes = true;
		}

		return succes;
	}

	public static boolean supprimerNom(TableNom pTab, String pNom)
	{
		boolean succes = false;
		int prec = FIN;
		int suiv = pTab.premier;

		if (pTab.premier != FIN)
		{
			while (suiv != FIN && pNom.compareTo(pTab.table[suiv].nom) > 0)
			{
				prec = suiv;
				suiv = pTab.table[suiv].suivant;
			}
			if (pNom.equals(pTab.table[suiv].nom))
			{
				pTab.table[suiv].nom = "";
				pTab.table[suiv].suivant = suiv;
			}
			if (prec != FIN)
			{
				pTab.table[prec].suivant = pTab.table[suiv].suivant;
			}
			else
			{
				pTab.premier = pTab.table[suiv].suivant;
			}
			pTab.table[suiv].suivant = pTab.libre;
			pTab.libre = suiv;
			succes = true;
		}

		return succes;
	}

	public static void afficher(TableNom pTab)
	{
		int i = 0;
		for (Element elem : pTab.table)
		{
			System.out.print(i++ + "\t" + elem.nom + "\t" + elem.suivant + "\r");
		}
		System.out.println("libre " + pTab.libre + " premier " + pTab.premier);
	}

	public static void main(String[] argument)
	{
		TableNom tab = new TableNom();
		String nom1;
		String nom2;

		initialiserPile(tab);
		do
		{
			System.out.print("Saisir nom à ajouter : ");
			nom1 = Lire.S();
			System.out.println((ajouterNom(tab, nom1)) ? nom1 + " a été ajouté." : "Tableau plein.");
			afficher(tab);
		} while (Dialogue.veutContinuer());
		do
		{
			System.out.print("Saisir nom à supprimer : ");
			nom2 = Lire.S();
			System.out
					.println((supprimerNom(tab, nom2)) ? nom2 + " a été supprimé." : "Tableau vide ou nom inexistant.");
			afficher(tab);
		} while (Dialogue.veutContinuer());
	}
}
