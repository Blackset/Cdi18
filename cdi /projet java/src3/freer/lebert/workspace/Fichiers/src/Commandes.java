import java.io.*;
import java.util.*;

public class Commandes
{
	public static void main(String[] argument)
	{
		try
		{
			List<Client> clients = new ArrayList<Client>();
			clients = Client.ajouterClients(clients, new BufferedReader(new FileReader(Constantes.FICHIER)));
			for (Client client : clients)
			{
				client.setCommandes(Commande.ajouterCommandes(client, new BufferedReader(new FileReader(Constantes.FICHIER))));
				for (Commande commande : client.getCommandes())
				{
					commande.setProduits(
							Produit.ajouterProduits(client, commande, new BufferedReader(new FileReader(Constantes.FICHIER))));
				}
			}
			for (Client cl : clients)
			{
				float total = 0;
				for (Commande co : cl.getCommandes())
				{
					float sousTotal = 0;
					for (Produit p : co.getProduits())
					{
						total += p.getPrix();
						sousTotal += p.getPrix();
					}
					System.out.println(cl.getNom() + "\t" + co.getNumero() + "\t" + sousTotal);
				}
				System.out.println("Total\t\t" + total + "\r");
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
