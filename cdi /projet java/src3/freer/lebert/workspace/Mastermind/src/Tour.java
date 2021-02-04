import java.util.*;

public class Tour
{
	int numero; // numéro du tour
	List<Element> proposition; // proposition donnée
	int bien; // nombre d'éléments à la bonne place
	int mal; // nombre d'éléments mal placés
	String resultat; // résultat affiché
	int solutions; // nombre de solutions possibles
	List<List<Element>> possibilites; // liste des propositions possibles

	public Tour(int numero)
	{
		this.numero = numero;
		proposition = new ArrayList<Element>();
		bien = 0;
		mal = 0;
		resultat = "";
		solutions = 0;
		possibilites = new ArrayList<List<Element>>();
	}

	public static String comparer(Partie partie, Tour tour)
	{
		// initiliasation à faux
		for (int i = 0; i < partie.taille; i++)
		{
			partie.combinaison.set(i, new Element(partie.combinaison.get(i).valeur));
			tour.proposition.set(i, new Element(tour.proposition.get(i).valeur));
		}

		// nombre de bien placés
		for (int i = 0; i < partie.taille; i++)
		{
			if (partie.combinaison.get(i).valeur == tour.proposition.get(i).valeur)
			{
				Element element = new Element(partie.combinaison.get(i).valeur);
				element.utilise = true;
				partie.combinaison.set(i, element);
				element = new Element(tour.proposition.get(i).valeur);
				element.utilise = true;
				tour.proposition.set(i, element);
				tour.bien++;
			}
		}

		// nombre de mal placés
		for (int i = 0; i < partie.taille; i++)
		{
			if (!partie.combinaison.get(i).utilise)
			{
				int j = 0;
				while (j < partie.taille && (tour.proposition.get(i).utilise
						|| partie.combinaison.get(i).valeur != tour.proposition.get(j).valeur))
				{
					j++;
				}
				if (j < partie.taille)
				{
					Element element = new Element(tour.proposition.get(j).valeur);
					element.utilise = true;
					tour.proposition.set(j, element);
					tour.mal++;
				}
			}
		}

		// affichage du résultat
		for (int i = 0; i < tour.bien; i++)
		{
			tour.resultat += Constante.BIEN;
		}
		for (int i = 0; i < tour.mal; i++)
		{
			tour.resultat += Constante.MAL;
		}

		return tour.resultat;
	}

	public static String comparer(Partie partie, Tour tour, List<Element> nombre)
	{
		// initiliasation à faux
		for (int i = 0; i < partie.taille; i++)
		{
			nombre.set(i, new Element(nombre.get(i).valeur));
			tour.proposition.set(i, new Element(tour.proposition.get(i).valeur));
		}

		// nombre de bien placés
		int bien = 0;
		for (int i = 0; i < partie.taille; i++)
		{
			if (nombre.get(i).valeur == tour.proposition.get(i).valeur)
			{
				Element element = new Element(nombre.get(i).valeur);
				element.utilise = true;
				nombre.set(i, element);
				element = new Element(tour.proposition.get(i).valeur);
				element.utilise = true;
				tour.proposition.set(i, element);
				bien++;
			}
		}

		// nombre de mal placés
		int mal = 0;
		for (int i = 0; i < partie.taille; i++)
		{
			if (!nombre.get(i).utilise)
			{
				int j = 0;
				while (j < partie.taille
						&& (tour.proposition.get(i).utilise || nombre.get(i).valeur != tour.proposition.get(j).valeur))
				{
					j++;
				}
				if (j < partie.taille)
				{
					Element element = new Element(tour.proposition.get(j).valeur);
					element.utilise = true;
					tour.proposition.set(j, element);
					mal++;
				}
			}
		}

		// affichage du résultat
		String resultat = "";
		for (int i = 0; i < bien; i++)
		{
			resultat += Constante.BIEN;
		}
		for (int i = 0; i < mal; i++)
		{
			resultat += Constante.MAL;
		}

		return resultat;
	}

	public static List<List<Element>> solutionsPossibles(Partie partie, Tour tour)
	{
		for (int i = 0; i < Math.pow(partie.max + 1, partie.taille); i++)
		{
			String v = Integer.toString(i, partie.max + 1);
			while (v.length() < partie.taille)
			{
				v = "0" + v;
			}
			List<Element> nombre = new ArrayList<Element>();
			for (int j = 0; j < v.length(); j++)
			{
				nombre.add(new Element(Integer.parseInt(String.valueOf(v.charAt(j)))));
			}
			if (tour.resultat.equals(comparer(partie, tour, nombre)))
			{
				tour.possibilites.add(nombre);
				tour.solutions++;
			}
		}

		return tour.possibilites;
	}
}
