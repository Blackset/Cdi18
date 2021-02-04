package ecouteurs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fenetre.Fen;

/**
 * @author Alain
 *
 */
public class EcouteurSouris extends MouseAdapter
{

	private Fen fenetre;

	/**
	 * 
	 */
	public EcouteurSouris(Fen windows)
	{
		fenetre = windows;
		
		fenetre.addMouseListener(this);		
		
		fenetre.addMouseMotionListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (!e.isMetaDown() && e.getClickCount() >= 2)
		{
			fenetre.effaceTousTraits();	
		}
		if (e.isMetaDown())
		{
			fenetre.effaceDernierTrait();		
		}	
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		if (!e.isMetaDown())
		{
			fenetre.debutTrait(e.getPoint());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isMetaDown())
		{
			fenetre.dessineTrait(e.getPoint());
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (!e.isMetaDown())
		{
			fenetre.finTrait(e.getPoint());
		}		
	}

}
