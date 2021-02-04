import java.awt.*;

//Fichier : CamembertGraphe.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class CamembertGraphe extends Graphe
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2231031057389044985L;
	
	public CamembertGraphe(DonneeGraphe d)
	{
		super(d);
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Color c;
		int p;
		int angle = 0;
		int rayon;
		Dimension d = getSize();
		if (d.width > d.height)
			rayon = d.height - 20;
		else
			rayon = d.width - 20;
			
		// l'effet antialiasing
		Graphics2D gd = (Graphics2D)g;
		gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < donnees.taille(); i++)
		{

			p = (int)donnees.getPortionPercentage(i);
			c = donnees.getPortion(i).getColor();
			gd.setColor(c);
			
			if (i == donnees.taille()-1)
			{
				gd.drawArc(10, 10,rayon, rayon, angle, 360-angle);
				gd.fillArc(10, 10,rayon, rayon, angle, 360-angle);
			}
			else
			{
				gd.drawArc(10, 10,rayon, rayon, angle, p);
				gd.fillArc(10, 10,rayon, rayon, angle, p);
			}
			angle = angle + p;
			
		}

	}

}
