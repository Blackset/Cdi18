
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
		System.out.println( entier+ "n'est pas compris entre" + -MAX+" et " +MAX);
	}
	}
}
