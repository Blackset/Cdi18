import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Commande
{
	int numero;
	List<Produit> produits;

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	public void setProduits(List<Produit> produits)
	{
		this.produits = produits;
	}

	public int getNumero()
	{
		return numero;
	}

	public List<Produit> getProduits()
	{
		return produits;
	}

	public static boolean commandePresente(Client client, int numero)
	{
		boolean succes = false;

		for (Commande commande : client.getCommandes())
		{
			if (commande.getNumero() == numero)
			{
				succes = true;
			}
		}

		return succes;
	}

	public static List<Commande> ajouterCommandes(Client client, BufferedReader br)
	{
		String ligne = "";

		try
		{
			client.setCommandes(new ArrayList<Commande>());
			for (int i = 0; i < Constantes.LECTURE; i++)
			{
				ligne = br.readLine();
			}
			while (ligne != null)
			{
				String sNom = ligne.replaceAll("\t+", "\t").split("\t")[Constantes.CLIENT - 1];
				if (client.getNom().equals(sNom))
				{
					int sNumero = Integer.parseInt(ligne.replaceAll("\t+", "\t").split("\t")[Constantes.COMMANDE - 1]);
					if (!commandePresente(client, sNumero))
					{
						Commande commande = new Commande();
						commande.setNumero(sNumero);
						client.getCommandes().add(commande);
					}
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

		return client.getCommandes();
	}
}
