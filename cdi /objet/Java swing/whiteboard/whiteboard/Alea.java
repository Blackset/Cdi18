package whiteboard;

import java.awt.Graphics;
import java.awt.Point;

public class Alea extends ShapeNP
{
    private static final long serialVersionUID = 7049194078960940637L;


    /**
     * Cr�e une nouvelle courbe � partir d'un point de d�part et pour un client donn�.
     * @param start Le Point de d�part.
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
