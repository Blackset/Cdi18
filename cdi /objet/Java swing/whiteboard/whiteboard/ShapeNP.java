package whiteboard;

import java.awt.Point;
import java.util.Vector;

public abstract class ShapeNP extends Shape
{

	public ShapeNP(Point start)
	{
		super( start);
	}
    private static final long serialVersionUID = 7049194078960940637L;

    private static final int TAILLE = 50;
    private static final int INCR = 50;
    protected Vector<Point> m_points;

    protected boolean setStart(Point point)
    {
        if (m_points == null)
        {
        	// le vecteur sera créé par l'appel du constructeur de la classe mère
        	m_points = new Vector<Point>(TAILLE, INCR);
        }
        if ( point == null)
        {
        	point = new Point();
        }
        m_points.addElement(point);

        return true;
    }

    public boolean setEnd(Point point)
    {
    	if (point == null)
    	{
    		point = new Point();
    	}
    	m_points.addElement(point);
        return true;
    }

 }
