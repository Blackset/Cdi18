import javax.swing.UIManager;

/*
 * Created on 3 f�vr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author corre
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Main 
{
	//M�thode main
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		new EdithTexte();
	}
}
