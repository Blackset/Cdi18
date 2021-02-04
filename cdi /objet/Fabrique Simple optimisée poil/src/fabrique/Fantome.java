/**
 * 
 */
package fabrique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author CDI
 *
 */
public interface Fantome
{
	/**
	 * @return the m_Couleur
	 */
	public abstract Color getCouleur();

	/**
	 * @param m_Couleur the m_Couleur to set
	 */
	public abstract void setCouleur(Color m_Couleur);

	public abstract void setPtFin(Point p);

	public abstract void setPtDebut(Point p);

	public abstract Point getPtFin();

	public abstract Point getPtDebut();

	/* (non-Javadoc)
	 * @see fabrique.Fantome#paint(java.awt.Graphics)
	 */
	public abstract void paint(Graphics g);

}