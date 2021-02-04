package ecouteurs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import fenetre.Fen;

/**
 * 
 */

/**
 * @author CDI
 *
 */
public class EcouteursWindows extends WindowAdapter
{

	/**
	 * 
	 */
	public EcouteursWindows(Fen fenetre)
	{
		fenetre.addWindowListener(this);
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
	}

}
