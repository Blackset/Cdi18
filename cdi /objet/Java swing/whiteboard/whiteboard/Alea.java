package whiteboard;

import java.awt.Graphics;
import java.awt.Point;

public class Alea extends ShapeNP
{
    private static final long serialVersionUID = 7049194078960940637L;


    /**
     * Crée une nouvelle courbe à partir d'un point de départ et pour un client donné.
     * @param start Le Point de départ.
     */
    public Alea(Point start)
    {
        super( start);

    }

 
    public void paint(Graphics g)
    {
        super.paint(g);
        int max = m_points.size();
        int i = max;
        while (i>0)
        {
            Point start = m_points.elementAt(i-1);

        	Point end = m_points.elementAt(Math.max(i-8, 0));
            g.drawLine(start.x, start.y, end.x, end.y);
            i--;
        }

    }
}
