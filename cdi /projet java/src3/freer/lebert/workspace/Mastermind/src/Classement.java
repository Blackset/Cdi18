import java.io.*;
import java.util.*;

public class Classement
{
	int tours;
	double temps;
	String nom;

	public Classement(String nom)
	{
		this.nom = nom;
	}

	public static List<Classement> lireFichier(BufferedReader br)
	{
		List<Classement> classements = new ArrayList<Classement>();

		try
		{
			String ligne = br.readLine();

			// lecture d'une ligne
			while (ligne != null)
			{
				String sNom = ligne.replaceAll("\t+", "\t").split("\t")[Constante.NOM - 1];
				int sTours = Integer.parseInt(ligne.replaceAll("\t+", "\t").split("\t")[Constante.TOURS - 1]);
				double sTemps = Double.parseDouble(ligne.replaceAll("\t+", "\t").split("\t")[Constante.TEMPS - 1]);
				Classement classement = new Classement(sNom);
				classement.tours = sTours;
				classement.temps = sTemps;
				classements.add(classement);
				ligne = br.readLine();
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return classements;
	}

	public static void afficherClassement(List<Classement> classements)
	{
		int position = 1;
		for (Classement c : classements)
		{
			if (c != null)
			{
				System.out.println(position++ + "\t" + c.nom + "\t" + c.tours + "\t" + c.temps);
			}
		}
	}

	public static void enregistrerClassement(Partie partie, Classement classement)
	{
		try
		{
			List<Classement> classements = new ArrayList<Classement>();
			classements = lireFichier(new BufferedReader(new FileReader(partie.fichier)));
			classements.add(classement);
			Collections.sort(classements, new ClassementComparator());

			BufferedWriter fw = new BufferedWriter(new FileWriter(partie.fichier));
			for (int i = 0; i < Constante.TOP; i++)
			{
				if (classements.get(i) != null)
				{
					fw.write(classements.get(i).nom + "\t\t" + classements.get(i).tours + "\t\t"
							+ classements.get(i).temps);
					fw.newLine();
				}
			}
			fw.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Votre partie a été enregistrée");
	}
}
