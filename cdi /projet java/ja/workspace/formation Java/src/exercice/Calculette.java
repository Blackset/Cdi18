package exercice;


public class Calculette
{
	
	public static void main (String [] argument)
	{
	int MAX = 1000;
	int entier = 0;
	System.out.println("Saisissez votre entier:");
	entier = Lire.i();
	if ((entier >= -MAX) && (entier <=MAX))
		{
			System.out.println(entier+" est bien entre compris "+ -MAX+" et " +MAX);
		}
	else
	{
		System.out.print(0);
	}
	}
}
