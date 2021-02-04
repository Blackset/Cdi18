import java.util.EventListener;

//Fichier : CouleurListener.java
//Auteur : abonnenc
//Date : 23 juin 2011
//Role du fichier
public interface DonneesListener extends EventListener
{
	public void donneesChanged(DonneesEvent ce);
}

