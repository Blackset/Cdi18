import javax.swing.UIManager;
import java.awt.*;

public class Appli
{
	private boolean packFrame = false;
	
	//Construire l'application
	public Appli()
	{
		Cercle frame = new Cercle();
		//Valider les cadres ayant des tailles pr�d�finies
		//Compacter les cadres ayant des infos de taille pr�f�r�es - ex. depuis leur disposition
		if (packFrame)
		{
			frame.pack();
		}
		else
		{
			frame.validate();
		}
		//Centrer la fen�tre
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height)
		{
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width)
		{
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
}