/**
 * 
 */
package fabrique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * @author CDI
 *
 */
public class FigureOmbre extends Decorateur
{
	/*
	private   Random rand=new Random();
	private  int nombreAleatoireX=-25+rand.nextInt(50-3+1)+3;
	private  int nombreAleatoireY=-25+rand.nextInt(50-3+1)+3;
	*/
	
	private   double STD_DECALE_OMBRE_X =5;
	private   double STD_DECALE_OMBRE_Y = 5;
	private static final int STD_OMBRE = 9;

	private Fantome ombre;

	/**
	 * @param f
	 */
	public FigureOmbre(Fantome f)
	{
		super(f);

		ombre = FabriqueSimple.getInstance().creerForme(decale(f.getPtDebut()));
		ombre.setCouleur(ombrer(f.getCouleur()));		
	}
	
	public Color ombrer(Color couleur)
	{
		int r=couleur.getRed()-STD_OMBRE;
		if (r<0)
		{
			r=0;			
		}
		
		int v=couleur.getGreen()-STD_OMBRE;
		if (v<0)
		{
			v=0;			
		}
		int b=couleur.getBlue()-STD_OMBRE;
		if (b<0)
		{
			b=0;			
		}
		
		return couleur=new Color(r,v,b);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Decorateur#setCouleur(java.awt.Color)
	 */
	@Override
	public void setCouleur(Color m_Couleur)
	{			
			ombre.setCouleur(m_Couleur);		
	}	

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getCouleur()
	 */
	@Override
	public Color getCouleur()
	{		
		return ombre.getCouleur();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Decorateur#setPtFin(java.awt.Point)
	 */
	@Override
	public void setPtFin(Point p)
	{
		_figure.setPtFin(p);
		ombre.setPtFin(decale(_figure.getPtFin()));
		
		//super.setPtFin(p);
	}
	
	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{		
		return ombre.getPtFin();
	}

	/**
	 * @param ptDebut
	 * @return
	 */
	private Point decale(Point point)
	{
		Point p = new Point(point.x + (int)STD_DECALE_OMBRE_X, point.y +(int)STD_DECALE_OMBRE_Y);		

		return p;
	}

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{		
		return ombre.getPtDebut();
	}

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{						
		ombre.paint(g);
		
		_figure.paint(g);		
	}
}
