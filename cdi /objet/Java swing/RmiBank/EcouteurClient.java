import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface EcouteurClient extends Remote,Serializable
{
	public void metAjour(String nom)throws RemoteException;
}
