/**
 * 
 */
package fabrique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

/**
 * @author Alain Gourdin
 *
 */
public class FigureAPoil extends Decorateur
{	
	private static final int STD_NOMBRE_POIL = 50;	//a augmenter si on aime vraiment les poils
	//private static final int LONGUEUR_POIL = 30;	
	private static final int RATIO_POIL = 4;		//ajuste la longueur des polis!

	

	private Vector<Ligne> poil= new Vector<Ligne>();
	
	private Fantome figurePoil;

	/**
	 * @param f
	 */
	public FigureAPoil(Fantome f)
	{			
		super(f);
		
		figurePoil=f;
		
		fairePoils(f.getPtDebut(),f.getPtFin());		
		
		for (Ligne fantome : poil)
		{
			fantome.setCouleur(f.getCouleur());	
		}			
	}

	/**
	 * 
	 */
	private void fairePoils(Point dep, Point arr)
	{
			
		poil.removeAllElements();		
		
			
			//Soit un triangle ABD rectangle en D
			//Segment AD Horizontal et segment BD vertical
			
		
			double bd=(arr.y-dep.y);
			
			double ad=(arr.x-dep.x);
		  
			double ab=Math.sqrt(Math.pow(bd,2)+Math.pow(ad,2));
			System.out.println((int)ad);
			
			double cosAngle=ad/ab;
			
			//permet de faire tourner les poils
			double angleRadian;
			
			
			if (arr.y>dep.y)
			{
				angleRadian=Math.acos(cosAngle)-Math.PI*2;
			}
			else
			{
				angleRadian=Math.PI*2-Math.acos(cosAngle);	
			}
					
			int r = (int) (Math.sqrt(Math.pow((dep.x - arr.x), 2) +	Math.pow((dep.y - arr.y), 2)));
			
			int rMax = r+(r/RATIO_POIL);
			
			for (int i = 0; i <= STD_NOMBRE_POIL; i++)
			{
				System.out.println(ad);
				Point deb = new Point(dep.x+(int)(Math.cos(Math.PI*2*i/STD_NOMBRE_POIL+angleRadian)*r),dep.y+(int)(Math.sin(Math.PI*2*i/STD_NOMBRE_POIL+angleRadian)*r));
				Ligne l =  new Ligne(deb);
				Point fin = new Point(dep.x+(int)(Math.cos(Math.PI*2*i/STD_NOMBRE_POIL+angleRadian)*rMax),dep.y+(int)(Math.sin(Math.PI*2*i/STD_NOMBRE_POIL+angleRadian)*rMax));
				
				l.setPtFin(fin);
				poil.add(l);
			}
	
		
	}
		

	/*
	 * (non-Javadoc)
	 * 
	 * @see fabrique.Decorateur#setCouleur(java.awt.Color)
	 */
	@Override
	public void setCouleur(Color m_Couleur)
	{		
		for (Fantome fantome : poil)
		{
			fantome.setCouleur(m_Couleur);	
		}
		_figure.setCouleur(m_Couleur);
			
	}	

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getCouleur()
	 */
	@Override
	public Color getCouleur()
	{		
		return _figure.getCouleur();
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
		fairePoils(_figure.getPtDebut(), _figure.getPtFin());
		
		
	}
	
	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{		
		return _figure.getPtFin();
	}

	

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{	
		
		return _figure.getPtDebut();
	}

	/* (non-Javadoc)
	 * @see fabrique.Decorateur#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{		
		for (Fantome fantome : poil)
		{
			fantome.paint(g);
		}
		
		_figure.paint(g);		
	}
}
