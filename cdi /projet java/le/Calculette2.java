
public class Calculette2
{
	public static void main(String[] argument)
	{
		int nombre1, nombre2; // nombres saisis par l'utilisateur
		char operateur; // op�rateur saisi par l'utilisateur
		int resultat = 0; // resultat de l'op�ration

		System.out.print("Nombre 1 : ");
		nombre1 = Lire.i();
		System.out.print("Nombre 2 : ");
		nombre2 = Lire.i();
		System.out.print("Op�rateur : ");
		operateur = Lire.c();
		switch (operateur)
		{
		case '+':
			resultat = nombre1 + nombre2;
			break;
		case '-':
			resultat = nombre1 - nombre2;
			break;
		case '*':
			resultat = nombre1 * nombre2;
			break;
		case '/':
			if (nombre2 != 0)
			{
				resultat = nombre1 / nombre2;
			}
			else
			{
				System.out.println("Erreur : division par z�ro");
				System.exit(0);
			}
			break;
		default:
			System.out.println("Erreur : op�rateur inconnu");
			System.exit(0);
		}
		System.out.println("R�sultat : " + resultat);
	}
}
