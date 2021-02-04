public class TestEnregistrerPiece
{
	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("**** TestEnregistrerPiece (V1.0, 25/10/2016) ****");
		System.out.println();
		System.out.println("Ce programme permet d'ajouter de nouvelle pièce dans une structure de donnée, "
				+ "il affiche également les pièces enregistrées.");
		
		// Saisie du nombre de pièce à ajouter et affichage
		Piece.afficherListe(Piece.ajouter(Tools.saisieEntier()));	
	}
}
