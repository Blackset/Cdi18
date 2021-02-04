package whiteboard;

import java.awt.Graphics;
import java.awt.Point;

public class Disc extends Shape2P
{
    private static final long serialVersionUID = -3454656640309090971L;

    /**
     * Cr�e un nouveau dsique � partir d'un point de d�part et pour un client donn�.
     * @param start le Point de d�part.
     */
   public Disc ( Point start)
    {
       super(start);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        int r = (int) Math.sqrt(Math.pow(getStart().x - getEnd().x, 2) + Math.pow(getStart().y - getEnd().y, 2));

        g.fillOval(getStart().x - r, getStart().y - r, 2 * r, 2 * r);
    }
}
