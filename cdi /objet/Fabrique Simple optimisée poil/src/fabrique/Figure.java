package fabrique;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author Alain
 *
 */
public abstract class Figure implements Fantome
{	
	private Color m_Couleur;

	/* (non-Javadoc)
	 * @see fabrique.Fantome#getCouleur()
	 */
	@Override
	public Color getCouleur()
	{
		return m_Couleur;
	}

	/* (non-Javadoc)
	 * @see fabrique.Fantome#setCouleur(java.awt.Color)
	 */
	@Override
	public void setCouleur(Color m_Couleur)
	{
		this.m_Couleur = m_Couleur;
	}

	/**
	 * 
	 */
	public Figure(Point p)
	{		
		m_Couleur = new Color((int) (Math.random() * 0xFFFFFF));

		if (p == null)
		{
			p=new Point(0,0);
		}
		
		setPtDebut(p);
		setPtFin(p);
	}

	
	
	/* (non-Javadoc)
	 * @see fabrique.Fantome#setPtFin(java.awt.Point)
	 */
	@Override
	public abstract void setPtFin(Point p);	

	
	/* (non-Javadoc)
	 * @see fabrique.Fantome#setPtDebut(java.awt.Point)
	 */
	@Override
	public abstract void setPtDebut(Point p);
	
	/* (non-Javadoc)
	 * @see fabrique.Fantome#getPtFin(java.awt.Point)
	 */
	@Override
	public abstract Point getPtFin();
	
	/* (non-Javadoc)
	 * @see fabrique.Fantome#getPtDebut(java.awt.Point)
	 */
	@Override
	public abstract Point getPtDebut();
		
	
	/* (non-Javadoc)
	 * @see fabrique.Fantome#paint(java.awt.Graphics)
	 */	
	@Override
	public void paint(Graphics g)
	{		
		g.setColor(m_Couleur);
	}		

}
