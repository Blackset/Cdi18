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
     * Fixe le point de d�part de la figure.
     * @param start Le point de d�part de la figure.
     * @return Vrai si l'op�ration s'est bien pass�e.
     */
    protected abstract boolean setStart(Point start);
    
    /**
     * Fixe le point d'arriv�e de la figure.
     * @param start Le point d'arriv�e de la figure.
     * @return Vrai si l'op�ration s'est bien pass�e.
     */
    public abstract boolean setEnd(Point end);

    /**
     * Affecte une couleur al�atoire � la figure. 
     * @return Vrai si l'op�ration s'est bien pass�e.
     */
    private boolean setColor()
    {
        Random r = new Random();
        m_color = new Color(r.nextInt(16777216));
        
        return true;
    }

    /**
     * Affecte une couleur � la figure.
     * @param couleur La couleur � modifier.
     * @return Vrai si le param�tre n'est pas nul;
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
