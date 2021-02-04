package whiteboard.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import whiteboard.Shape;

public interface WhiteBoardObserver extends Remote
{
    public void update() throws RemoteException;
    
    public void disconnect() throws RemoteException;
    public int getId() throws RemoteException;
    public void setId(int i) throws RemoteException;

	public boolean nonInit()throws RemoteException;
}
