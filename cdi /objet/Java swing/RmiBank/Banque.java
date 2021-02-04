import java.io.Serializable;
import java.rmi.*;
// cet exemple ne sert que de faisabilité technique.
// d'un point de vue méthodologique c'est une horreur!!!!
public interface Banque extends Remote,Serializable
{
	public boolean open(String nom, float val) throws RemoteException;// permet de creer un compte, ou de le retrouver

}
