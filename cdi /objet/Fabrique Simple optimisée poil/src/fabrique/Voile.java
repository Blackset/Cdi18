package fabrique;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author Alain Gourdin
 *
 */
public class Voile extends FigureNPoints
{

	/**
	 * @param p
	 */
	public Voile(Point p)
	{
		super(p);		
	}

	/* (non-Javadoc)
	 * @see FigureNPoints#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{		
		super.paint(g);
		
		for (int i = 0; i < getSize() - 1; i++)
		{
			// trace trait
			g.drawLine(getElementAt(0).x, getElementAt(0).y, getElementAt(i + 1).x, getElementAt(i + 1).y);
		}
	}

}
