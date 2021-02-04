import java.awt.*;

/**
 * <p>Titre : Edith</p>
 * <p>Description : mini �direur de texte avec JBuilder</p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Soci�t� : afpa</p>
 * @author corre
 * @version 1.0
 */

public class EdithTexte
{
	private boolean packFrame = false;
	
	//Construire l'application
	public EdithTexte()
	{
		EdithFrame frame = new EdithFrame();
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