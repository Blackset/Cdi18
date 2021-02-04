import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;


public class Client implements Compte,Remote,Serializable
{
	private Vector<EcouteurClient> v = new Vector<EcouteurClient>();
	private String nom;
	private float valeur = 0;
	public Client(String s,float val)
	{// le client est créé avec un solde positif ou nul. En cas d'erreur le solde reste nul.
		if (val >0)
		{
			valeur = val;
		}
		nom = s;
	}
	public boolean deposer(float val) throws RemoteException
	{
		if (val >0)
		{
			valeur += val;
		}
		fireClient(nom);
		return (val >0);
	}

	public float getSolde() throws RemoteException
	{
		return valeur;
	}

	public boolean retirer(float val) throws RemoteException
	{
		boolean ok = false;
		if (val >0 && val <= valeur)
		{
			ok = true;
			valeur -= val;
		}
		fireClient(nom);

		return ok;
	}
	public void abonne( int i)
	{
		EcouteurClient ec=null;
		try
		{
			Registry r = LocateRegistry.getRegistry("localhost");// reperage du registry du serveur
			ec = (EcouteurClient) r.lookup("ec" + i);// je recupere le stub du client
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}		
		v.add(ec);
	}
	public void desabonne(int i)
	{
		EcouteurClient ec=null;
		try
		{
			Registry r = LocateRegistry.getRegistry("localhost");// reperage du registry du serveur
			ec = (EcouteurClient) r.lookup("ec" + i);// je recupere le stub du client
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}		

		v.remove(ec);
	}
	public void fireClient(String nom)
	{
		for(EcouteurClient ec : v)
		{
			try
			{
				ec.metAjour(nom);
			}
			catch (RemoteException e)
			{
				
			}
		}
	}
}
