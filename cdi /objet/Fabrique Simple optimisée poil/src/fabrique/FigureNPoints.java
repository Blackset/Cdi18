package fabrique;
import java.awt.Point;
import java.util.Vector;

/**
 * @author CDI
 *
 */
public class FigureNPoints extends Figure
{
	private Vector<Point>m_vLines;
	
	/**
	 * @param p
	 */
	public FigureNPoints(Point p)
	{		
		super(p);
	}

	
	/* (non-Javadoc)
	 * @see Figure#setPtFin(java.awt.Point)
	 */
	@Override
	public void setPtFin(Point p)
	{
		if (p != null)
		{
			m_vLines.addElement(p);
		}
	}

	public int getSize()
	{
		return m_vLines.size();
	}
	
	public Point getElementAt(int index)
	{
		return m_vLines.elementAt(index);
	}

	/* (non-Javadoc)
	 * @see Figure#setPtDebut(java.awt.Point)
	 */
	@Override
	public void setPtDebut(Point p)
	{
		//initialisation du vecteur
		m_vLines = new Vector<Point>();
		
		if (p != null)
		{
			m_vLines.addElement(p);
		}		
	}


	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{	
		return m_vLines.lastElement();
	}


	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{		
		return m_vLines.firstElement();
	}
	
}
