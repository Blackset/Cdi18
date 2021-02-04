/*  Classe      : FabriquePiece
    Auteur      : Yann Capelli	
    Mise à jour : 20 Ocotbre 2016
    Fonction    : Structure de données des pieces
*/
public class FabriquePiece
{
	private static final int MAX = 2;
	public static void main(String[] argument)
	{
		Piece [] listePiece = new Piece[MAX];
		for (int i = 0 ; i<MAX ; i++)
		{
			listePiece [i] = saisiePiece();
		}
		affichagePiece(listePiece);
		
	}
/* ******************************PROCEDURE **************************************/
	public static Piece saisiePiece ()
	{
		// Création nouvelle piece
		Piece piece = new Piece();
		piece.dateFab = new Date();
		piece.dimensionPiece = new Dimension();
		
		
		System.out.println("Saisir le numero de serie ");
		piece.numero = Lire.i();
		System.out.println("Saisir le jour de fabrication :");		
		piece.dateFab.j= Jour.saisieJour();
		System.out.println("Saisir le numero du jour :");
		piece.dateFab.numJour = Lire.i();
		System.out.println("Saisir le mois :");
		piece.dateFab.m = Mois.saisieMois();
		System.out.println("Saisir l'année :");
		piece.dateFab.a = Lire.i();
		System.out.println("Saisir la couleur :");
		piece.couleur = Colorie.saisieColorie();
		System.out.println("Saisir la forme de la pièce :");
		piece.dimensionPiece.forme = Genre.saisieGenre();
		switch (piece.dimensionPiece.forme)
		{
			case CUBIQUE :
				System.out.println("Saisir la dimension des cotés :");
				piece.dimensionPiece.hauteur = Lire.f();
				break;	
			case CYLINDRIQUE :
				System.out.println("Saisir la hauteur du cylindre :");
				piece.dimensionPiece.hauteur = Lire.f();
				System.out.println("Saisir le rayon du cylindre :");
				piece.dimensionPiece.rayon = Lire.f();
				break;
			case SPHERIQUE :
				System.out.println("Saisir le rayon de la sphere :");
				piece.dimensionPiece.rayon = Lire.f();
				break;		
		}
		return piece;
	}

	public static void affichagePiece (Piece [] listePiece)
	// Procédure qui permet l'affichage des pièces
	// listePiece est le tableau de piece que l'ont veut afficher
	{
		for (int i = 0 ; i<MAX ; i++)
		{
			
			System.out.println("Numero de serie : "+ listePiece[i].numero);
			System.out.println("Date de fabrication : "+ listePiece[i].dateFab.j + " " +listePiece[i].dateFab.numJour + " "+ listePiece[i].dateFab.m +" "+ listePiece[i].dateFab.a );
			System.out.println("Couleur : "+ listePiece[i].couleur);
			System.out.println("Forme : "+ listePiece[i].dimensionPiece.forme);
			switch ( listePiece[i].dimensionPiece.forme )
			{
				case CUBIQUE :
					System.out.println("Dimension des cotés : "+ listePiece[i].dimensionPiece.hauteur);
					break;	
				case CYLINDRIQUE :
					System.out.println("Hauteur du cylindre : "+ listePiece[i].dimensionPiece.hauteur);
					System.out.println("Rayon du cylindre : "+listePiece[i].dimensionPiece.rayon);
					break;
				case SPHERIQUE :
					System.out.println("Rayon de la sphere : " + listePiece[i].dimensionPiece.rayon);
					break;		
			}
		}
	}
}

/* *****************************CLASSE******************************/
enum Colorie
{
	JAUNE, VERT, BLEU, ROUGE, ORANGE, MAUVE;
	public static Colorie saisieColorie()
	{
		String s;
		Colorie col = null;
		boolean ok = true;
		do
		{
			System.out.print("Couleur : ");
			for(Colorie c : Colorie.values())
			{
				System.out.print(c+" ");

			}
			System.out.println();
			System.out.print("donnez votre couleur : ");
			
			s = Lire.S().toUpperCase();
			try
			{
				col = Colorie.valueOf(s);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		} while (!ok);
		return col;
	}
}
enum Jour
{
	LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE;
	public static Jour saisieJour()
	{
		String s;
		Jour jour = null;
		boolean ok = true;
		do
		{
			System.out.print("Jour : ");
			for(Jour c : Jour.values())
			{
				System.out.print(c+" ");

			}
			System.out.println();
			System.out.print("donnez votre jour : ");
			
			s = Lire.S().toUpperCase();
			try
			{
				jour = Jour.valueOf(s);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		} while (!ok);
		return jour;
	}
}
enum Mois
{
	JANVIER, FEVRIER, MARS, AVRL, MAI, JUIN, JUILLET, AOUT, SEPTEMBRE, OCTOBRE, NOVEMBRE, DECEMBRE;
	public static Mois saisieMois()
	{
		String s;
		Mois moi = null;
		boolean ok = true;
		do
		{
			System.out.print("Mois : ");
			for(Mois m : Mois.values())
			{
				System.out.print(m+" ");
	
			}
			System.out.println();
			System.out.print("donnez le mois : ");
			
			s = Lire.S().toUpperCase();
			try
			{
				moi = Mois.valueOf(s);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		} while (!ok);
		return moi;
	}
}
enum Genre
{
	CUBIQUE, CYLINDRIQUE, SPHERIQUE;
	public static Genre saisieGenre()
	{
		String s;
		Genre genre = null;
		boolean ok = true;
		do
		{
			System.out.print("Genre : ");
			for(Genre g : Genre.values())
			{
				System.out.print(g+" ");

			}
			System.out.println();
			System.out.print("donnez le genre : ");
			
			s = Lire.S().toUpperCase();
			try
			{
				genre = Genre.valueOf(s);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		} while (!ok);
		return genre;
	}
}
class Date
{
	Jour j;
	int numJour;
	Mois m;
	int a;	
}
class Dimension
{
	Genre forme;
	float hauteur;
	float rayon;
}
class Piece
{
	Colorie couleur;
	int numero;
	Date dateFab;
	Dimension dimensionPiece;
}
