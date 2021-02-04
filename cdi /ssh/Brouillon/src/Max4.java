/*  Classe      : Max
 Auteur      : Halim, revu par Lécu Régis
 Mise à jour : 20 Octobre 2015
 Fonction    : ce programme permet de dénombrer toutes les personnesd'age inferieur strictement à 20 ans parmi un échantillonde 20 personnes X */

public class Max4

{
	public static final int NOMBREDEPERSONNES = 20; // nombre de personnes à interroger
	public static final int LIMITEJEUNE = 20; // jeune si age <= limite jeune

	public static void main(String[] argument)

	{
		int nbJeune;
		int age;
		int nombreDepersonnesInterrogées;

		nbJeune = 0;
		nombreDepersonnesInterrogées = 0;

		while (nombreDepersonnesInterrogées <= NOMBREDEPERSONNES)

		{
			System.out.print(" nombre de personnes interrogées:");

			System.out.print("Donnez vote age:");

			age = Lire.i();

			if (age <= LIMITEJEUNE)
			{
				nbJeune = nbJeune + 1;
			}

			nombreDepersonnesInterrogées = nombreDepersonnesInterrogées + 1;

		}

		System.out.println(" le nombre de jeune est:" + nbJeune);
		
	}

}
