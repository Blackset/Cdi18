import java.awt.*;

import javax.swing.JPanel;

//Fichier : Graphe.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public abstract class Graphe extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2699011227621588718L;
	protected DonneeGraphe donnees;
	
	public Graphe(DonneeGraphe d)
	{
		donnees = d;
	}
	
	public void update(DonneeGraphe d)
	{
		donnees = d;
		// repeintre le graphe
		repaint();
	}
	public Insets getInsets() {
		 return new Insets(20,20,20,20);
		}



}
