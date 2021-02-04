package whiteboard;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape2P
{
    private static final long serialVersionUID = 5326121402111946017L;

    
    /**
     * Crée un nouveau trait à partir d'un point de départ et pour un client donné.
     * @param start le Point de départ.
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
