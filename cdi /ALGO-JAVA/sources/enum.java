
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

};
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Colorie c = Colorie.saisieColorie();
		System.out.println(c);

	}

	
}

