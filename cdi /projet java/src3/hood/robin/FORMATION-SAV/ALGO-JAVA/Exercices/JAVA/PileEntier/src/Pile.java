
public class Pile
{
	int[] entier = new int[5];
	int indice;

	public static Pile init(Pile lifo)
	{
		lifo.indice = 0;
		return lifo;
	}

	public static Pile empiler(Pile lifo, int entier)
	{
		if (lifo.indice < lifo.entier.length)
		{
			lifo.entier[lifo.indice + 1] = entier;
		}
		else
		{
			
		}

		return lifo;
	}

}
