
enum Type
{
	SPHERIQUE, CUBIQUE, CYLINDRIQUE
}

class Dimensions
{
	Type type;
	float hauteur;
	float rayon;
}

enum Couleur
{
	JAUNE, VERT, BLEU, ROUGE, ORANGE, MAUVE
}

enum Jour
{
	LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE
}

enum Mois
{
	JANVIER, FEVRIER, MARS, AVRIL, MAI, JUIN, JUILLET, AOUT, SEPTEMBRE, OCTOBRE, NOVEMBRE, DECEMBRE
}

class Date
{
	Jour jour;
	int numero;
	Mois mois;
	int annee;
}

class Piece
{
	Dimensions dimensions;
	Couleur couleur;
	int numSerie;
	Date date;
}

public class StructurerDonnees
{
	private static final int TAILLE = 1000;

	public static Type saisirType()
	{
		Type type = null;
		String val;
		boolean succes = false;

		do
		{
			System.out.print("Saisir type de pièce : ");
			val = Lire.S().toUpperCase();
			try
			{
				type = Type.valueOf(val);
				succes = true;
			}
			catch (Exception e)
			{
				succes = false;
			}
		} while (!succes);
		return type;
	}

	public static Dimensions saisirDimensions()
	{
		Dimensions dim = new Dimensions();
		float hauteur = 0;
		float rayon = 0;

		dim.type = saisirType();
		switch (dim.type)
		{
		case SPHERIQUE:
			System.out.print("Saisir rayon : ");
			rayon = Lire.f();
			break;
		case CUBIQUE:
			System.out.print("Saisir hauteur : ");
			hauteur = Lire.f();
			break;
		case CYLINDRIQUE:
			System.out.print("Saisir hauteur : ");
			hauteur = Lire.f();
			System.out.print("Saisir rayon : ");
			rayon = Lire.f();
			break;
		default:
			System.out.println("Erreur dimensions");
		}
		dim.hauteur = hauteur;
		dim.rayon = rayon;
		return dim;
	}

	public static Couleur saisirCouleur()
	{
		Couleur couleur = null;
		String val;
		boolean succes = false;

		do
		{
			System.out.print("Saisir couleur : ");
			val = Lire.S().toUpperCase();
			try
			{
				couleur = Couleur.valueOf(val);
				succes = true;
			}
			catch (Exception e)
			{
				succes = false;
			}
		} while (!succes);
		return couleur;
	}

	public static Jour saisirJour()
	{
		Jour jour = null;
		String val;
		boolean succes = false;

		do
		{
			System.out.print("Saisir jour de fabrication : ");
			val = Lire.S().toUpperCase();
			try
			{
				jour = Jour.valueOf(val);
				succes = true;
			}
			catch (Exception e)
			{
				succes = false;
			}
		} while (!succes);
		return jour;
	}

	public static Mois saisirMois()
	{
		Mois mois = null;
		String val;
		boolean succes = false;

		do
		{
			System.out.print("Saisir mois de fabrication : ");
			val = Lire.S().toUpperCase();
			try
			{
				mois = Mois.valueOf(val);
				succes = true;
			}
			catch (Exception e)
			{
				succes = false;
			}
		} while (!succes);
		return mois;
	}

	public static Date saisirDate()
	{
		Date date = new Date();

		date.jour = saisirJour();
		System.out.print("Saisir le numéro du jour : ");
		date.numero = Lire.i();
		date.mois = saisirMois();
		System.out.print("Saisir année de fabrication : ");
		date.annee = Lire.i();
		return date;
	}

	public static void saisirValeurs(Piece[] pPieces, int pNbSaisies)
	{
		for (int i = 0; i < pNbSaisies; i++)
		{
			System.out.println("------------------------");
			System.out.println("Pièce numéro " + (i + 1));
			pPieces[i] = new Piece();
			pPieces[i].dimensions = saisirDimensions();
			pPieces[i].couleur = saisirCouleur();
			System.out.print("Saisir numéro de série : ");
			pPieces[i].numSerie = Lire.i();
			pPieces[i].date = saisirDate();
		}
	}

	public static void afficherValeurs(Piece[] pPieces, int pNbSaisies)
	{
		for (int i = 0; i < pNbSaisies; i++)
		{
			System.out.println("------------------------");
			System.out.println("Pièce numéro " + (i + 1));
			System.out.println("Type : " + pPieces[i].dimensions.type.toString());
			switch (pPieces[i].dimensions.type)
			{
			case SPHERIQUE:
				System.out.println("Rayon : " + pPieces[i].dimensions.rayon);
				break;
			case CUBIQUE:
				System.out.println("Hauteur : " + pPieces[i].dimensions.hauteur);
				break;
			case CYLINDRIQUE:
				System.out.println("Hauteur : " + pPieces[i].dimensions.hauteur);
				System.out.println("Rayon : " + pPieces[i].dimensions.rayon);
				break;
			default:
				System.out.println("Erreur dimensions");
			}
			System.out.println("Couleur : " + pPieces[i].couleur.toString());
			System.out.println("Numéro de série : " + pPieces[i].numSerie);
			System.out.println("Date de fabrication : " + pPieces[i].date.jour.toString() + " " + pPieces[i].date.numero
					+ " " + pPieces[i].date.mois.toString() + " " + pPieces[i].date.annee);
		}
	}

	public static void main(String[] argument)
	{
		Piece[] pieces = new Piece[TAILLE];
		int nbSaisies;

		System.out.print("Nombre de saisies : ");
		nbSaisies = Lire.i();
		saisirValeurs(pieces, nbSaisies);
		afficherValeurs(pieces, nbSaisies);
	}
}
