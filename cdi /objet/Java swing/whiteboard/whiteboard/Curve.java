package whiteboard;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;

public class Curve extends ShapeNP
{
    private static final long serialVersionUID = 7049194078960940637L;


    /**
     * Crée une nouvelle courbe à partir d'un point de départ et pour un client donné.
     * @param start Le Point de départ.
     */
    public Curve( Point start)
    {
        super( start);

    }

 
    public void paint(Graphics g)
    {
        super.paint(g);
        
        Iterator i = m_points.iterator();
        
        Point start = (Point) i.next();
        Point end = (Point) i.next();
        
        if (i.hasNext())
            while (i.hasNext())
            {
                g.drawLine(start.x, start.y, end.x, end.y);
                start = end;
                end = (Point) i.next();
            }
        else
            g.drawLine(start.x, start.y, end.x, end.y);

    }
}
