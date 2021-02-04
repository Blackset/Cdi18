
public class Multiples
{
	public static void main(String[] argument)
	{
		int nombre; // nombre saisi par l'utilisateur
		int multiple; // nombre de multiples voulus par l'utilisateur

		System.out.print("Saisir nombre : ");
		nombre = Lire.i();
		System.out.print("Nombre de multiples : ");
		multiple = Lire.i();
		System.out.print("Résultat :");
		for (int i = 1; i <= multiple; i++)
		{
			System.out.print(" " + nombre * i);
		}
	}
}
