package fabrique;
import java.awt.Point;

/**
 * @author CDI
 *
 */
public abstract class Figure2Points extends Figure
{
	protected Point m_pPointDeb;
	/**
	 * @return the m_pPointDeb
	 */
	public Point getPointDebut()
	{
		return m_pPointDeb;
	}

	protected Point m_pPointFin;

	/**
	 * @return the m_pPointFin
	 */
	public Point getPointFin()
	{
		return m_pPointFin;
	}

	/**
	 * @param p
	 */
	public Figure2Points(Point p)
	{
		super(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Figure#setPtFin(java.awt.Point)
	 */
	@Override
	public void setPtFin(Point p)
	{
		if (p != null)
		{
			m_pPointFin = p;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Figure#setPtDebut(java.awt.Point)
	 */
	@Override
	public void setPtDebut(Point p)
	{
		if (p != null)
		{
			m_pPointDeb = p;
		}
	}
	
	

}
