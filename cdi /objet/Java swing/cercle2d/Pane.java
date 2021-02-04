import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author corre
 *
 */
public class Pane extends JPanel
{
	public void paint(Graphics g)
	{
		setBackground(Color.white);
		int nb = 26; // moitié du nombre de cercles
		double angle = Math.PI/nb;
		double rayon = 300.0;
		double petitrayon = rayon * Math.sqrt(2 - 2*Math.cos(angle)) ;
		int Rayon = (int)(rayon + petitrayon);
		int delta = this.getInsets().top;
		g.drawOval(340-Rayon,340-Rayon+delta,(2*Rayon),(2*Rayon));
		for (int i = 0; i < nb*2; i++)
		{
			g.drawOval((int) (rayon*Math.cos(angle + i*angle)+340-petitrayon),
					(int) (rayon*Math.sin(angle + i*angle)+340-petitrayon+delta),
					(int)(2* petitrayon),(int)(2* petitrayon));
		}
		
		nb = 50;
		angle = Math.PI/nb;
		rayon = 185;
		petitrayon = rayon * Math.sqrt(2 - 2*Math.cos(angle)) ;
		Rayon = (int)(rayon + petitrayon);
		
		g.drawOval(340-Rayon,340-Rayon+delta,(2*Rayon),(2*Rayon));
		
		for (int i = 0; i < nb; i++)
		{
			g.drawOval((int) (rayon*Math.cos(angle + 2*i*angle)+340-petitrayon),
					(int) (rayon*Math.sin(angle + 2*i*angle)+340-petitrayon+delta),
					(int)(2* petitrayon),(int)(2* petitrayon));
		}
		g.setColor(Color.white );
		g.fillOval((int)(340-rayon),(int)(340-rayon+delta),(int)(2*rayon),(int)(2*rayon));
		g.setColor(Color.black );
		g.drawOval((int)(340-rayon),(int)(340-rayon+delta),(int)(2*rayon),(int)(2*rayon));
		g.drawOval(339,339+delta,1,1) ;
	}
}
