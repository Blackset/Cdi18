package whiteboard.client;

import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import whiteboard.Shape;
import whiteboard.server.WhiteBoard;


public class Client implements WhiteBoardObserver,Serializable
{
    private static final long serialVersionUID = 2156005759112244166L;

    private static final String registryHost = "localhost";
    private static final String serverBoundName = "Whiteboard";
    
    private Registry registry;
    
    private WhiteBoard whiteboard;
    private int clientId = -1;
    
    private ClientWindow window;
    private boolean init=false;
    
    public Client() throws RemoteException
    {
        if (connect())
        {
            try
            {
                clientId = whiteboard.connect(this);
                //enregistrons maintenant l'écouteur dans le registry
                if (clientId >= 0)
                {
                    window = new ClientWindow(this, whiteboard, clientId);
                }
                else
                {
                    System.err.println("Client - Impossible de se connecter, serveur plein.");
                    System.exit(1);
                }

                try
                {
                    /* Nouvelle méthode Java 5 : le stub du serveur est compilé à
                     * l'exécution puis envoyé au registre. Le client récupère le code
                     * compilé lors de l'interrogation du registre.
                    */
                    WhiteBoardObserver wbo = (WhiteBoardObserver) UnicastRemoteObject.exportObject(this, 0);
                    registry = LocateRegistry.getRegistry(registryHost);
                    registry.rebind("observer"+clientId, wbo);
                    
                }
                catch (Exception e)
                {
                    System.err.println("Accès impossible au registre. Opération non permise");
                    e.printStackTrace();
                }
            }
            catch (RemoteException re)
            {
                System.err.println("Client - Impossible de se connecter (connexion refusée).");
                re.printStackTrace();
                System.exit(1);
            }
            
        }
    }

    public boolean connect()
    {
        boolean ok = false;
        
        try
        {
            registry = LocateRegistry.getRegistry(registryHost);
            whiteboard = (WhiteBoard) registry.lookup(serverBoundName);
            ok = true;
        }
        catch (RemoteException e)
        {
            System.err.println("Client - Erreur RMI.");
            e.printStackTrace();
        }
        catch (NotBoundException e)
        {
            System.err.println("Client - Impossible de se connecter au serveur. (serveur non lancé ?)");
            e.printStackTrace();
        }
        
        return ok;
    }
    
    public void close()
    {
        try
        {
            whiteboard.disconnect(clientId);
        }
        catch (RemoteException re)
        {
            System.err.println("Client - Déconnexion impossible. Fin du programme forcée.");
            re.printStackTrace();
        }
        System.exit(0);
    }
    
    public void update() throws RemoteException
    {
        window.setFigures();
    }

    public void disconnect() throws RemoteException
    {
        System.err.println("Client - Le serveur a été arrêté");
        window.setTitle("Déconnecté");
        try
		{
			registry.unbind("observer"+clientId);
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	public int getId() throws RemoteException
	{
		// TODO Auto-generated method stub
		return clientId;
	}

	public boolean nonInit() throws RemoteException
	{
		if (init == false)
		{
			init = true;
			return true;
		}
		return false;
	}

	public void setId(int i) throws RemoteException
	{
		if (i>0)
			clientId = i;
		
	}
}
