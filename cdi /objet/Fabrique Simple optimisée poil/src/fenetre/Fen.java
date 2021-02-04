package fenetre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import ecouteurs.EcouteurClavier;
import ecouteurs.EcouteurSouris;
import ecouteurs.EcouteursWindows;
import fabrique.FabriqueSimple;
import fabrique.Fantome;

/**
 * 
 */

/**
 * @author CDI
 *
 */
public class Fen extends Frame
{					
	private Groupe m_Groupe;
	
	private Fantome m_Figure;	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;			
	
	/**
	 * @throws HeadlessException
	 */
	public Fen()
	{		
		m_Groupe=new Groupe();
		
		new EcouteurSouris(this);
		
		new EcouteursWindows(this);
		
		new EcouteurClavier(this);
						
		setBounds(400,400,400,400);
		setVisible(true);	
		
	}

	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{
		Graphics2D tampon = (Graphics2D) g;
		Image brouillon;
		
		Dimension d=this.getSize();
		brouillon=createImage(d.width,d.height);
		tampon=(Graphics2D)brouillon.getGraphics();
		
		tampon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		m_Groupe.paint(tampon);
		
		g.setColor(Color.pink);
		
		
		if (m_Figure!=null)
		{
			m_Figure.paint(tampon);
		}
			
		g.drawImage(brouillon, 0, 0, null);
		
		setTitre();
	}
	
	
	public void update(Graphics g)
	{
		paint(g);
	}	
	

	public void setTitre()
	{
		if (m_Groupe.getCount() < m_Groupe.getInitialCapacity())
		{
			setTitle("je vais dessiner:  "+FabriqueSimple.getInstance().getTitreADessiner()+" avec "+ FabriqueSimple.getInstance().getQteOmbre()+ " ombre(s)");			
		}
		else
		{
			setTitle("trop de lignes !!!!");
		}
	}
	
	/**
	 * @param point
	 */
	public void debutTrait(Point point)
	{
		if (m_Groupe.getCount()<m_Groupe.getInitialCapacity())
		{			
			m_Figure=FabriqueSimple.getInstance().creerFormeOmbree(point);					
		}		
	}

	/**
	 * 
	 */
	public void dessineTrait(Point p)
	{
		if (m_Figure!=null)
		{
			m_Figure.setPtFin(p);
		}	
		
		if (m_Groupe.getCount()<m_Groupe.getInitialCapacity())
		{
			m_Groupe.addLine(m_Figure);	
		}	
		
		m_Figure=null;
		
		repaint();
				
	}

	/**
	 * @param point
	 */
	public void finTrait(Point p)
	{
		if (m_Figure!=null)
		{
			m_Figure.setPtFin(p);			
			repaint();
		}
	}

	/**
	 * 
	 */
	public void effaceTousTraits()
	{
		m_Groupe.deletAllLine();		
		repaint();	
	}

	/**
	 * 
	 */
	public void effaceDernierTrait()
	{		
		m_Groupe.deletLastLine();
		repaint();
	}
	
	
}
