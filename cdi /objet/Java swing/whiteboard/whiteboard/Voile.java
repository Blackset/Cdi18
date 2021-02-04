package whiteboard;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;

public class Voile extends ShapeNP
{
    private static final long serialVersionUID = 7049194078960940637L;


    /**
     * Cr�e une nouvelle courbe � partir d'un point de d�part et pour un client donn�.
     * @param start Le Point de d�part.
     */
    public Voile(  Point start)
    {
        super( start);

    }

 
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Iterator i = m_points.iterator();
        
        Point start = (Point) i.next();
        
        
        while (i.hasNext())
        {
        	Point end = (Point) i.next();
            g.drawLine(start.x, start.y, end.x, end.y);
        }

    }
}
