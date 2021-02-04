import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;


public class MainServeur 
{
	public static void main(String arg[])
	{
		CreditCrollois cc = new CreditCrollois();
		try
		{
			Banque b = (Banque) UnicastRemoteObject.exportObject(cc,0);// création d'un stub
			Registry r = LocateRegistry.createRegistry(1099);// création d'un registry pour enregistrer les stubs
			r.rebind("banque", b);// enregistrement du stub dans le registry
			System.out.println("lancement du serveur réussi");
			
		}
		catch (RemoteException e)
		{
			System.out.println("erreur de lancement du serveur"+e);
			e.printStackTrace();
		}		
	}
}
