import java.util.EventObject;

//Fichier : HistoriqueEvent.java
//Auteur : abonnenc
//Date : 23 juin 2011
//Role du fichier
public class DonneesEvent extends EventObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258827944390434164L;
	public DonneesEvent(DonneeGraphe d)
	{
		super (d);
	}

}
