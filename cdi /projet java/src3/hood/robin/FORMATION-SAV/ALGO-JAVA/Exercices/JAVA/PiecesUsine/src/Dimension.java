enum Genre
{
	CUBE, CYLINDRE, SPHERE;
	public static Genre saisie()
	{
		String formeS;
		Genre forme = null;
		boolean ok = true;
		do
		{
			System.out.print("\t-Forme de la pièce (");
			for (Genre f : Genre.values())
			{
				System.out.print(f + " ");
			}
			System.out.print(") : ");

			formeS = Lire.S().toUpperCase();

			try
			{
				forme = Genre.valueOf(formeS);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}

		}
		while (!ok);
		return forme;
	}

}

public class Dimension
{
	public int rayon;

	public int hauteur;

	public Genre forme;

	public static Dimension saisie()
	{
		Dimension dim = new Dimension();

		dim.forme = Genre.saisie();

		if (!dim.forme.equals(Genre.SPHERE))
		{
			System.out.print("\t-Hauteur de la pièce : ");
			dim.hauteur = Lire.i();
		}

		if (!dim.forme.equals(Genre.CUBE))
		{
			System.out.print("\t-Rayon de la pièce : ");
			dim.rayon = Lire.i();
		}

		return dim;
	}

	public static void afficher(Dimension dim)
	{
		System.out.println("\t-FORME : " + dim.forme);

		if (!dim.forme.equals(Genre.SPHERE))
		{
			System.out.println("\t-HAUTEUR : " + dim.hauteur);
		}
		if (!dim.forme.equals(Genre.CUBE))
		{
			System.out.println("\t-RAYON : " + dim.rayon);
		}
	}
}
