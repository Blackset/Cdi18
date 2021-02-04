import java.awt.*;

import javax.swing.JPanel;

//Fichier : PanelTitre.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class PanelTitre extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8149028931796550401L;
	private Label lab;
	
	public PanelTitre()
	{
		lab = new Label("");
		add(lab);
	}
	
	public void setTitre(String l)
	{
		lab.setText(l);
	}
}
