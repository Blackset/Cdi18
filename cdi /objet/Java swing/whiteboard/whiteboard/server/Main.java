package whiteboard.server;

import java.rmi.RemoteException;

public class Main
{
    public static void main(String[] args)
    {
        try {
            new WhiteBoardServer();
        }
        catch (RemoteException e)
        {
            System.err.println("Erreur RMI. Le serveur n'a pas pu s'initialiser.");
            e.printStackTrace();
        }
    }
 
}
