enum Couleur
{
	JAUNE, VERT, BLEU, ROUGE, ORANGE, MAUVE;
	public static Couleur saisie()
	{
		String colorS;
		Couleur color = null;
		boolean ok = true;
		do
		{
			System.out.print("\t-Couleur de la pièce (");
			for (Couleur c : Couleur.values())
			{
				System.out.print(c + " ");
			}
			System.out.print(") : ");

			colorS = Lire.S().toUpperCase();

			try
			{
				color = Couleur.valueOf(colorS);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}
		}
		while (!ok);
		return color;
	}
	
	public static void afficher(Couleur couleur)
	{
		System.out.println("\t-COULEUR : " + couleur);
	}
}