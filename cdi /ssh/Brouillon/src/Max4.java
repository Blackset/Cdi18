/*  Classe      : Max
 Auteur      : Halim, revu par L�cu R�gis
 Mise � jour : 20 Octobre 2015
 Fonction    : ce programme permet de d�nombrer toutes les personnesd'age inferieur strictement � 20 ans parmi un �chantillonde 20 personnes X */

public class Max4

{
	public static final int NOMBREDEPERSONNES = 20; // nombre de personnes � interroger
	public static final int LIMITEJEUNE = 20; // jeune si age <= limite jeune

	public static void main(String[] argument)

	{
		int nbJeune;
		int age;
		int nombreDepersonnesInterrog�es;

		nbJeune = 0;
		nombreDepersonnesInterrog�es = 0;

		while (nombreDepersonnesInterrog�es <= NOMBREDEPERSONNES)

		{
			System.out.print(" nombre de personnes interrog�es:");

			System.out.print("Donnez vote age:");

			age = Lire.i();

			if (age <= LIMITEJEUNE)
			{
				nbJeune = nbJeune + 1;
			}

			nombreDepersonnesInterrog�es = nombreDepersonnesInterrog�es + 1;

		}

		System.out.println(" le nombre de jeune est:" + nbJeune);
		
	}

}
