
class Elem
{
	String nom;
	Elem suivant;
}

public class Pointeur
{
	public static void initialiser(Elem pElem)
	{
		pElem = null;
	}

	public static void afficher(Elem pElem)
	{
		if (pElem.suivant == null)
		{
			System.out.println("Liste vide.");
		}
		while (pElem != null)
		{
			if (pElem.nom != null)
			{
				System.out.println(pElem.nom + "\t");
			}
			pElem = pElem.suivant;
		}
	}

	public static boolean ajouter(Elem pElem, String pNom)
	{
		boolean succes = false;
		Elem prec = new Elem();

		initialiser(prec);
		while (pElem != null && pNom.compareTo(pElem.nom == null ? "" : pElem.nom) > 0)
		{
			prec = pElem;
			pElem = pElem.suivant;
		}
		if (pElem == null || pNom.compareTo(pElem.nom == null ? "" : pElem.nom) != 0)
		{
			prec.suivant = new Elem();
			prec.suivant.nom = pNom;
			prec.suivant.suivant = pElem;
			succes = true;
		}

		return succes;
	}

	public static boolean supprimer(Elem pElem, String pNom)
	{
		boolean succes = false;
		Elem prec = new Elem();

		if (pElem != null)
		{
			initialiser(prec);
			while (pElem != null && pNom.compareTo(pElem.nom == null ? "" : pElem.nom) > 0)
			{
				prec = pElem;
				pElem = pElem.suivant;
			}
			if (pElem != null && pNom.compareTo(pElem.nom == null ? "" : pElem.nom) == 0)
			{
				prec.suivant = pElem.suivant;
				succes = true;
			}
		}

		return succes;
	}

	public static void main(String[] argument)
	{
		Elem elem = new Elem();
		String nom;

		initialiser(elem);
		do
		{
			System.out.println("1\tAfficher liste");
			System.out.println("2\tAjouter un nom");
			System.out.println("3\tSupprimer un nom");
			System.out.println("autre\tQuitter");
			char choix = Lire.c();
			switch (choix)
			{
			case '1':
				afficher(elem);
				break;
			case '2':
				System.out.print("Nom à ajouter : ");
				nom = Lire.S();
				System.out.println(ajouter(elem, nom) ? nom + " a été ajouté." : "Erreur.");
				break;
			case '3':
				System.out.print("Nom à supprimer : ");
				nom = Lire.S();
				System.out.println(supprimer(elem, nom) ? nom + " a été supprimé." : "Tableau vide ou nom inexistant.");
				break;
			default:
				System.exit(0);
			}
		} while (Dialogue.veutContinuer());
	}
}
