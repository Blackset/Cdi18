import java.io.*;

public class Mastermind
{
	public static void jouer(Partie partie)
	{
		partie.combinaison = Partie.genererCombinaison(partie);
		String solution = "";
		for (Element element : partie.combinaison)
		{
			solution += element.valeur;
		}

		// début du jeu
		long chronoDebut = System.currentTimeMillis();

		for (int i = 0; i < partie.proposition && !partie.victoire; i++)
		{
			Tour tour = new Tour(i + 1);
			tour.proposition = Partie.saisirProposition(partie, tour);
			tour.resultat = Tour.comparer(partie, tour);
			tour.possibilites = Tour.solutionsPossibles(partie, tour);
			partie.progression.add(tour);
			partie.victoire = tour.resultat.matches("\\" + String.valueOf(Constante.BIEN) + "{" + partie.taille + "}");
			Partie.afficherProgression(partie);
		}

		// fin du jeu
		long chronoFin = System.currentTimeMillis();
		partie.temps = (chronoFin - chronoDebut) / 1000.0;
		System.out.println(
				partie.victoire ? "Gagné en " + partie.progression.size() + " tour(s)" : "Perdu : " + solution);
		System.out.println("Temps de jeu : " + partie.temps + " seconde(s)");

		// enregistrement du score en cas de victoire
		if (partie.victoire)
		{
			System.out.print("Saisir nom : ");
			Classement classement = new Classement(Lire.S());
			classement.tours = partie.progression.size();
			classement.temps = partie.temps;
			Classement.enregistrerClassement(partie, classement);
		}
	}

	public static void main(String[] argument)
	{
		char choix;

		do
		{
			System.out.println("1\tJouer");
			System.out.println("2\tAide");
			System.out.println("3\tClassement");
			System.out.println("autre\tQuitter");
			choix = Lire.c();
			switch (choix)
			{
			case '1':
				// jouer
				System.out.println("1\tMastermind");
				System.out.println("2\tSuper Mastermind");
				System.out.println("autre\tRetour");
				choix = Lire.c();
				switch (choix)
				{
				case '1':
					jouer(new Partie(Constante.TAILLE, Constante.MAX, Constante.PROPOSITION, Constante.FICHIER));
					break;
				case '2':
					jouer(new Partie(Constante.TAILLE2, Constante.MAX2, Constante.PROPOSITION2, Constante.FICHIER2));
					break;
				default:
					break;
				}
				break;
			case '2':
				// aide
				System.out.println(
						"Mastermind : combinaison composée de " + Constante.TAILLE + " chiffres de " + Constante.MIN
								+ " à " + Constante.MAX + ". Nombre de propositions : " + Constante.PROPOSITION);
				System.out.println("Super Mastermind : combinaison composée de " + Constante.TAILLE2 + " chiffres de "
						+ Constante.MIN + " à " + Constante.MAX2 + ". Nombre de propositions : "
						+ Constante.PROPOSITION2);
				break;
			case '3':
				// classement
				try
				{
					System.out.println("1\tMastermind");
					System.out.println("2\tSuper Mastermind");
					System.out.println("autre\tRetour");
					choix = Lire.c();
					switch (choix)
					{
					case '1':
						Classement.afficherClassement(
								Classement.lireFichier(new BufferedReader(new FileReader(Constante.FICHIER))));
						break;
					case '2':
						Classement.afficherClassement(
								Classement.lireFichier(new BufferedReader(new FileReader(Constante.FICHIER2))));
						break;
					default:
						break;
					}
					break;
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.exit(0);
			}
		} while (true);
	}
}
