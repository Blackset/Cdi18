package whiteboard;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape2P
{
    private static final long serialVersionUID = 5326121402111946017L;

    
    /**
     * Cr�e un nouveau trait � partir d'un point de d�part et pour un client donn�.
     * @param start le Point de d�part.
     */
    public Line (  Point start)
    {
        super( start);
    }

    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawLine(getStart().x, getStart().y, getEnd().x, getEnd().y);
    }
}
