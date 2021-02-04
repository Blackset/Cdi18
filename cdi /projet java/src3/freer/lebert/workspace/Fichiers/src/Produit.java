import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produit
{
	int produit;
	int quantite;
	float prix;

	public void setProduit(int produit)
	{
		this.produit = produit;
	}

	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}

	public void setPrix(float prix)
	{
		this.prix = prix;
	}

	public int getProduit()
	{
		return produit;
	}

	public int getQuantite()
	{
		return quantite;
	}

	public float getPrix()
	{
		return prix;
	}

	public static List<Produit> ajouterProduits(Client client, Commande commande, BufferedReader br)
	{
		String ligne = "";

		try
		{
			commande.setProduits(new ArrayList<Produit>());
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
					if (commande.getNumero() == sNumero)
					{
						int sProduit = Integer
								.parseInt(ligne.replaceAll("\t+", "\t").split("\t")[Constantes.PRODUIT - 1]);
						int sQuantite = Integer
								.parseInt(ligne.replaceAll("\t+", "\t").split("\t")[Constantes.QUANTITE - 1]);
						float sPrix = Float.parseFloat(ligne.replaceAll("\t+", "\t").split("\t")[Constantes.PRIX - 1]);
						Produit produit = new Produit();
						produit.setProduit(sProduit);
						produit.setQuantite(sQuantite);
						produit.setPrix(sPrix);
						commande.getProduits().add(produit);
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

		return commande.getProduits();
	}
}
