public class Piece
{
	public int numero;

	public Dimension mesure;

	public Couleur colo;

	public Date dataFab;

	/**
	 * @param info
	 *            les informations vide pour une pièce
	 * @return les informations remplies par l'utilisateur
	 */
	public static Piece creer()
	{
		Piece info = new Piece();
		System.out.println();
		System.out.print("\t-Code de la pièce : ");
		info.numero = Lire.i();

		info.mesure = Dimension.saisie();

		info.colo = Couleur.saisie();

		info.dataFab = Date.saisie();

		return info;
	}
	/**
	 * @param nbrPiece
	 *            le nombre de pièce a ajouter
	 * @return la liste des pièces ajoutés
	 */
	public static Piece[] ajouter(int nbrPiece)
	{
		// Création du tableau de pièce
		Piece[] listePiece = new Piece[nbrPiece];

		for (int i = 0; i < listePiece.length; i++)
		{
			System.out.println();
			System.out.println("Donnez les informations sur la pièce n°" + (i + 1));

			listePiece[i] = Piece.creer();
		}		
		return listePiece;
	}
	
	public static void afficherListe(Piece[] listePiece)
	{
		for (int i = 0; i < listePiece.length; i++)
		{
			System.out.println("PIECE N° : " + listePiece[i].numero);
			
			Dimension.afficher(listePiece[i].mesure);
			
			Couleur.afficher(listePiece[i].colo);
			
			Date.afficher(listePiece[i].dataFab);			
		}
	}
}
