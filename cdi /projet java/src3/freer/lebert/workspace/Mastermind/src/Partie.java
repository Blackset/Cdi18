import java.util.*;

public class Partie
{
	int taille; // taille de la combinaison
	int max; // valeur max de chaque élément
	int proposition; // nombre de propositions
	List<Tour> progression; // historique de progression
	List<Element> combinaison; // combinaison à trouver
	boolean victoire; // indique si la partie a été gagnée
	double temps; // durée de la partie
	String fichier; // fichier des records

	public Partie(int taille, int max, int proposition, String fichier)
	{
		this.taille = taille;
		this.max = max;
		this.proposition = proposition;
		progression = new ArrayList<Tour>();
		combinaison = new ArrayList<Element>();
		victoire = false;
		this.fichier = fichier;
	}

	public static List<Element> genererCombinaison(Partie partie)
	{
		for (int i = 0; i < partie.taille; i++)
		{
			partie.combinaison.add(new Element(i/* (int) (Math.random() * partie.max) */));
		}

		return partie.combinaison;
	}

	public static List<Element> saisirProposition(Partie partie, Tour tour)
	{
		String saisie = null; // saisie de l'utilisateur

		// lecture de saisie
		do
		{
			System.out.print("Proposition " + tour.numero + "/" + partie.proposition + " : ");
			saisie = Lire.S();
			if (tour.numero > 1 && saisie.equals(String.valueOf(Constante.AIDE)))
			{
				int random = (int) (Math.random() * tour.solutions);
				List<Element> nombre = tour.possibilites.get(random - 1);
				saisie = "";
				for (Element element : nombre)
				{
					saisie += element.valeur;
				}
			}
		} while (saisie.length() != partie.taille || !saisie.matches("[" + Constante.MIN + "-" + partie.max + "]+"));

		for (int i = 0; i < saisie.length(); i++)
		{
			tour.proposition.add(new Element(Integer.parseInt(String.valueOf(saisie.charAt(i)))));
		}

		return tour.proposition;
	}

	public static void afficherProgression(Partie partie)
	{
		// historique de progression
		for (Tour tour : partie.progression)
		{
			String saisie = "";
			for (int i = 0; i < tour.proposition.size(); i++)
			{
				saisie += tour.proposition.get(i).valeur;
			}
			System.out.println("Tour " + tour.numero + "\t" + saisie + "\t" + tour.resultat + "\t" + tour.solutions);
		}
	}
}
