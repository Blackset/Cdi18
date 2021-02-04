import javax.swing.UIManager;

/**
 * <p>Titre : gridbag</p>
 * <p>Description : essai de fonctionnement du gridbaglayout</p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : afpa</p>
 * @author corre
 * @version 1.0
 */

public class app
{

	//Méthode main
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		new Fenetre().setVisible(true);
	}
}