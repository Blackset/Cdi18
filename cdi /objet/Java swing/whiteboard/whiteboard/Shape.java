package whiteboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.Random;

public abstract class Shape implements Serializable
{
    private Color m_color;
    
    public Shape( Point start)
    {
        setStart(start);
        setEnd(start);
        setColor();
    }

    
    /**
     * Fixe le point de départ de la figure.
     * @param start Le point de départ de la figure.
     * @return Vrai si l'opération s'est bien passée.
     */
    protected abstract boolean setStart(Point start);
    
    /**
     * Fixe le point d'arrivée de la figure.
     * @param start Le point d'arrivée de la figure.
     * @return Vrai si l'opération s'est bien passée.
     */
    public abstract boolean setEnd(Point end);

    /**
     * Affecte une couleur aléatoire à la figure. 
     * @return Vrai si l'opération s'est bien passée.
     */
    private boolean setColor()
    {
        Random r = new Random();
        m_color = new Color(r.nextInt(16777216));
        
        return true;
    }

    /**
     * Affecte une couleur à la figure.
     * @param couleur La couleur à modifier.
     * @return Vrai si le paramètre n'est pas nul;
     */
    public boolean setCouleur(Color couleur)
    {
        boolean ok = (couleur != null);
        
        if (ok)
            m_color = couleur;
        
        return ok;
    }
    
    public void paint(Graphics g)
    {
        g.setColor(m_color);
    }
}
