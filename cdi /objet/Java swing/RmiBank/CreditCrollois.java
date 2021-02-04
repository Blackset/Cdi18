import java.io.Serializable;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class CreditCrollois implements Banque,Remote,Serializable
{
	private Hashtable<String, Compte> table = new Hashtable<String, Compte>();
	public boolean open(String nom, float val) throws RemoteException
	{
		Compte c = table.get(nom);
		if (c == null)
		{
			c = new Client(nom,val);
			try
			{
				Compte b = (Compte) UnicastRemoteObject.exportObject(c,0);
				Registry r = LocateRegistry.getRegistry(1099);
				r.rebind(nom, b);
				System.out.println("publication du client "+nom+" réussi");
				
			}
			catch (RemoteException e)
			{
				System.out.println("erreur de publication du client");
				e.printStackTrace();
				return false;
			}		

			table.put(nom, c);
			return true;
		}
		return false;
	}

}
