package fabrique;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author CDI
 *
 */
public class Etoile extends Figure2Points
{
	/**
	 * 
	 */
	private static final int NOMBRE_BRANCHE = 10;
	boolean bascule=true;
	int [] tabX=new int[NOMBRE_BRANCHE];
	int [] tabY=new int[NOMBRE_BRANCHE];
	
	double angle= Math.PI*2/NOMBRE_BRANCHE;
	
	/**
	 * @param p
	 */
	public Etoile(Point p)
	{
		super(p);		
	}

	/* (non-Javadoc)
	 * @see Figure2Points#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g)
	{		
		super.paint(g);
		
		
		double bd=(getPtFin().y-getPtDebut().y);
		
		double ad=(getPtFin().x-getPtDebut().x);
	  
		double ab=Math.sqrt(Math.pow(bd,2)+Math.pow(ad,2));
		System.out.println((int)ad);
		
		double cosAngle=ad/ab;
		
		double angleRadian;
		
		
		if (getPtFin().y>getPtDebut().y)
		{
			angleRadian=Math.acos(cosAngle)-Math.PI*2;
		}
		else
		{
			angleRadian=Math.PI*2-Math.acos(cosAngle);	
		}
		
		
		
		int r = (int) (Math.sqrt(Math.pow((getPointDebut().x - getPointFin().x), 2) + 
				Math.pow((getPointDebut().y - getPointFin().y), 2)));
		
	for (int i = 0; i < NOMBRE_BRANCHE; i++)
	{
		if (bascule)
		{
			tabX[i]=getPointDebut().x+(int)(Math.cos(angle*i+angleRadian)*r);
			tabY[i]=getPointDebut().y+(int)(Math.sin(angle*i+angleRadian)*r);
		}
		else 
		{
			tabX[i]=getPointDebut().x+(int)(Math.cos(angle*i+angleRadian)*r/2);	
			tabY[i]=getPointDebut().y+(int)(Math.sin(angle*i+angleRadian)*r/2);
		}	
		bascule=!bascule;	
	}				
			g.drawPolygon(tabX, tabY, NOMBRE_BRANCHE);
			g.fillPolygon(tabX, tabY, NOMBRE_BRANCHE);
	}

	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtFin()
	 */
	@Override
	public Point getPtFin()
	{
		// TODO Auto-generated method stub
		return m_pPointFin;
	}

	/* (non-Javadoc)
	 * @see fabrique.Figure#getPtDebut()
	 */
	@Override
	public Point getPtDebut()
	{
		// TODO Auto-generated method stub
		return m_pPointDeb;
	}



}
