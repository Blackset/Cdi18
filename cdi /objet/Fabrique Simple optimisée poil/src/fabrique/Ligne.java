package fabrique;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author CDI
 *
 */
public class Ligne extends Figure2Points
{

	/**
	 * @param p
	 */
	public Ligne(Point p)
	{
		super(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Figure2Points#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		// trace trait		
		g.drawLine(getPointDebut().x, getPointDebut().y, getPointFin().x, getPointFin().y);
		

	}

	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{
		// TODO Auto-generated method stub
		return m_pPointFin;
	}

	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{
		// TODO Auto-generated method stub
		return m_pPointFin;
	}

	

	

}
