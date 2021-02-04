package whiteboard.client;

import java.rmi.RemoteException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            new Client();
        } 
        catch (RemoteException e) 
        {
            System.err.println("Impossible d'initialiser le client");
            e.printStackTrace();
        }
    }

}
