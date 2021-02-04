package ecouteurs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import fabrique.FabriqueSimple;
import fenetre.Fen;

/**
 * 
 */

/**
 * @author CDI
 *
 */
public class EcouteurClavier extends KeyAdapter
{
	private Fen fenetre;
	
	/**
	 * 
	 */
	public EcouteurClavier(Fen windows)
	{
		fenetre=windows;
		fenetre.addKeyListener(this);	
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		FabriqueSimple.getInstance().setFigure(e.getKeyChar());
		fenetre.setTitre();
	}	

}
