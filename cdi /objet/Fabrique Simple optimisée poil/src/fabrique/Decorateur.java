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
public class Decorateur implements Fantome
{
	protected Fantome _figure;

	/**
	 * 
	 */
	public Decorateur(Fantome f)
	{
		_figure = f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Fantome#getCouleur()
	 */
	@Override
	public Color getCouleur()
	{
		// TODO Auto-generated method stub
		return _figure.getCouleur();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Fantome#setCouleur(java.awt.Color)
	 */
	@Override
	public void setCouleur(Color m_Couleur)
	{
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Fantome#setPtFin(java.awt.Point)
	 */
	@Override
	public void setPtFin(Point p)
	{
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Fantome#setPtDebut(java.awt.Point)
	 */
	@Override
	public void setPtDebut(Point p)
	{
		// TODO Auto-generated method stub
	}	

	/* (non-Javadoc)
	 * @see fabrique.Fantome#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{
		// TODO Auto-generated method stub
		return _figure.getPtFin();
	}

	/* (non-Javadoc)
	 * @see fabrique.Fantome#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{
		// TODO Auto-generated method stub
		return _figure.getPtDebut();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Fantome#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
	}

}
