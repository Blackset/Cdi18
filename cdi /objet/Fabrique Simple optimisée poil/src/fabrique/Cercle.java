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
public class Cercle extends Figure2Points
{

	/**
	 * @param p
	 */
	public Cercle(Point p)
	{
		super(p);		
	}

	/* (non-Javadoc)
	 * @see Figure2Points#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{		
		super.paint(g);
		
		int r = (int) (Math.sqrt(Math.pow((getPointDebut().x - getPointFin().x), 2) + 
				Math.pow((getPointDebut().y - getPointFin().y), 2)));
	
			g.fillOval(getPointDebut().x-r,getPointDebut().y-r,2*r,2*r);	
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
		return m_pPointDeb;
	}



}
