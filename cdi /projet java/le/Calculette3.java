
public class Calculette3
{
	public static void main(String[] argument)
	{
		int nombre1, nombre2; // nombres saisis par l'utilisateur
		char operateur; // opérateur saisi par l'utilisateur
		int resultat = 0; // resultat de l'opération
		boolean erreur = false; // erreur tant que l'opérateur n'est pas correct

		do
		{
			System.out.print("Nombre 1 : ");
			nombre1 = Lire.i();
			System.out.print("Nombre 2 : ");
			nombre2 = Lire.i();
			do
			{
				if (erreur)
				{
					System.out.print("Opérateur inconnu, recommencer : ");
					erreur = false;
				}
				else
				{
					System.out.print("Opérateur : ");
				}
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
						System.out.println("Erreur : division par zéro");
						System.exit(0);
					}
					break;
				default:
					erreur = true;
				}
			} while (erreur);
			System.out.println("Résultat : " + resultat);
		} while (Dialogue.veutContinuer());
	}
}
