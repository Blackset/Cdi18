enum JourSemaine
{
	LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE;
	public static JourSemaine saisie()
	{
		String nomS;
		JourSemaine nom = null;
		boolean ok = true;
		do
		{

			System.out.print("\t-Jour de fabrication de la pièce ( ");
			for (JourSemaine j : JourSemaine.values())
			{
				System.out.print(j + " ");
			}
			System.out.print(") : ");

			nomS = Lire.S().toUpperCase();

			try
			{
				nom = JourSemaine.valueOf(nomS);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}

		}
		while (!ok);
		return nom;
	}
}

enum MoisAnnee
{
	JANVIER, FEVRIER, MARS, AVRIL, MAI, JUIN, JUILLET, AOUT, SEPTEMBRE, OCTOBRE, NOVEMBRE, DECEMBRE;

	public static MoisAnnee saisie()
	{
		String moisS;
		MoisAnnee mois = null;
		boolean ok = true;
		do
		{

			System.out.print("\t-Mois de fabrication de la pièce (");
			for (MoisAnnee m : MoisAnnee.values())
			{
				System.out.print(m + " ");
			}
			System.out.print(") : ");

			moisS = Lire.S().toUpperCase();

			try
			{
				mois = MoisAnnee.valueOf(moisS);
				ok = true;
			}
			catch (Exception e)
			{
				ok = false;
			}

		}
		while (!ok);
		return mois;
	}
}

public class Date
{
	public JourSemaine jour;

	public int nJour;
	
	public MoisAnnee mois;

	public int annee;

	public static Date saisie()
	{
		Date date = new Date();

		date.jour = JourSemaine.saisie();

		System.out.print("\t-Date du jour de fabrication de la pièce : ");
		date.nJour = Lire.i();
				
		date.mois = MoisAnnee.saisie();

		System.out.print("\t-Année de fabrication de la pièce : ");
		date.annee = Lire.i();
		
		return date;
	}
	
	public static void afficher(Date date)
	{
		System.out.println("\t-DATE FABRICATION : " + date.jour + " " + date.nJour + " " + date.mois + " " + date.annee);
	}
}
