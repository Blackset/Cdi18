import java.io.Serializable;
import java.rmi.*;
public interface Compte extends Remote,Serializable
{
	public float getSolde() throws RemoteException;
	public boolean deposer(float val) throws RemoteException;
	public boolean retirer(float val) throws RemoteException;
	public void abonne(int ec)throws RemoteException;
	public void desabonne(int ec)throws RemoteException;

}
