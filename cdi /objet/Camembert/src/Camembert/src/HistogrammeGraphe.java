import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


//Fichier : HistogrammeGraphe.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class HistogrammeGraphe extends Graphe
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3609623917186420484L;

	public HistogrammeGraphe(DonneeGraphe d)
	{
		super(d);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Color c;
		int p;
		int width, height;
		int CoordX = 20;
		
		// l'effet antialiasing
		Graphics2D gd = (Graphics2D)g;		
		gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Dimension d = getSize();
		height = d.height;
		width = (d.width-20)/donnees.taille();

		for (int i = 0; i < donnees.taille(); i++)
		{
			p = (int)donnees.getPortionPercentage(i);
			c = donnees.getPortion(i).getColor();
			gd.setColor(c);
			height = (int)(p*d.height/(float)200);
			gd.drawRect(CoordX, d.height - height, width, height);
			gd.fillRect(CoordX,  d.height - height, width, height);
			
			CoordX = CoordX + width;
			
		}
	}

}
