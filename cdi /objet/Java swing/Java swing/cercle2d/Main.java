import javax.swing.UIManager;


public class Main
{
	//M�thode main
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
		new Appli();
	}

}
