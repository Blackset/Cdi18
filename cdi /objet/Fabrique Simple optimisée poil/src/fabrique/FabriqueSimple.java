/**
 * 
 */
package fabrique;

import java.awt.Point;




/**
 * @author CDI
 *
 */
public class FabriqueSimple
{			
	private static FabriqueSimple _fabrique;	//instance unique de class

	private Forme _figure=Forme.LIGNE;	
	
	private int _qteOmbre=0;		// compris entre 0 et 9
	
	private boolean _aPoil=false;	// decoration poil
	
	/**
	 * @return the _qteOmbre
	 */
	public int getQteOmbre()
	{
		return _qteOmbre;
	}

	/**
	 * 
	 */
	private FabriqueSimple()
	{
		_figure=Forme.LIGNE;
	}

	public static FabriqueSimple getInstance()
	{
		if (_fabrique == null)
		{
			_fabrique = new FabriqueSimple();
		}
		return _fabrique;
	}
	
	/**
	 * @param _figure the _figure to set
	 */
	public void setFigure(char touche)
	{
		switch (touche)
		{
		case '0':
			
		case '1':
			
		case '2':
			
		case '3':
			
		case '4':
			
		case '5':
			
		case '6':
			
		case '7':
			
		case '8':
			
		case '9':
			_qteOmbre=Integer.parseInt(Character.toString(touche));	
			break;	
				
		case 'c':
			_figure=Forme.CERCLE;	
			break;
		case 'e':
			_figure=Forme.ETOILE;	
			break;
		case 'm':
			_figure=Forme.MAINLEVEE;	
			break;
		case 'p':
			_aPoil=!_aPoil;	
			break;
		case 'P':
			_figure=Forme.POLYGONE;	
			break;
		case 'v':
			_figure=Forme.VOILE;	
			break;

		default:
			_figure=Forme.LIGNE;	
			break;
		}				
	}
	
	public Fantome creerFormeOmbree(Point point)
	{
		Fantome figureOmbreeADessiner=creerForme(point);
		
		for (int i = 1; i <= _qteOmbre; i++)
		{			
				figureOmbreeADessiner=new FigureOmbre(figureOmbreeADessiner);
		}		
		
		return figureOmbreeADessiner;
	}
	
	
	public Fantome creerForme(Point point)
	{
		Fantome figureADessiner=null;
		
		try
		{
			Class<?> [] tab = {Point.class};
			//liste des types de parametres
			
			Object[] param = {point};
			//liste des paramètres
			
			//si les formes sont dans un package, il faut rajouter le nom du package au nom de classe Figures.Cercle
			 String pack;
			if (Cercle.class.getPackage()==null)
			{//pas de package
				pack= new String();					
			}
			else
			{
				pack= Cercle.class.getPackage().getName()+'.';
			}
			
			figureADessiner =(Fantome)Class.forName(pack+_figure.toString().substring(0,1).toUpperCase()+_figure.toString().substring(1,_figure.toString().length()).toLowerCase()).getConstructor(tab).newInstance(param);
			if (_aPoil)
			{
				figureADessiner=new FigureAPoil(figureADessiner);
							
			}				
		}
		catch (Exception e1)
		{
			System.out.println("ça merde !!!");
			e1.printStackTrace();
		}				
		
		return figureADessiner;		
	}
	
	public String getTitreADessiner()
	{
		String s="";
		
			s=_figure.toString();
		
		return s;
	}

}
