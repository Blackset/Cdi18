import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Client
{
	String nom;
	List<Commande> commandes;

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public void setCommandes(List<Commande> commandes)
	{
		this.commandes = commandes;
	}

	public String getNom()
	{
		return nom;
	}

	public List<Commande> getCommandes()
	{
		return commandes;
	}

	public static boolean clientPresent(List<Client> clients, String nom)
	{
		boolean succes = false;

		for (Client client : clients)
		{
			if (client.getNom().equals(nom))
			{
				succes = true;
			}
		}

		return succes;
	}

	public static List<Client> ajouterClients(List<Client> clients, BufferedReader br)
	{
		String ligne = "";

		try
		{
			for (int i = 0; i < Constantes.LECTURE; i++)
			{
				ligne = br.readLine();
			}
			while (ligne != null)
			{
				String sNom = ligne.replaceAll("\t+", "\t").split("\t")[Constantes.CLIENT - 1];
				if (!clientPresent(clients, sNom))
				{
					Client client = new Client();
					client.setNom(sNom);
					clients.add(client);
				}
				ligne = br.readLine();
			}
		}
		catch (

		IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clients;
	}
}
