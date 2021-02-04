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
public class Mainlevee extends FigureNPoints
{

	/**
	 * @param p
	 */
	public Mainlevee(Point p)
	{
		super(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FigureNPoints#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		for (int i = 0; i < getSize() - 1; i++)
		{
			// trace trait
			g.drawLine(getElementAt(i).x, getElementAt(i).y, getElementAt(i + 1).x, getElementAt(i + 1).y);
		}
	}

}
