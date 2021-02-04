package whiteboard.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import whiteboard.Shape;
import whiteboard.client.WhiteBoardObserver;

public interface WhiteBoard extends Remote
{
    /**
     * 
     * @param client
     * @return
     * @throws RemoteException
     */
    public int connect(WhiteBoardObserver client) throws RemoteException;

    public boolean disconnect(int clientId) throws RemoteException;

    public boolean add(Shape s, int cvlientId) throws RemoteException;
    
    public void empty(int clientId) throws RemoteException;
    
    public Oeuvre getShapes() throws RemoteException;

    public boolean remove(int clientId) throws RemoteException;
}
