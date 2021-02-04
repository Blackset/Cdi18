
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Fichier : PanelLegende.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class PanelLegende extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 999162544748081041L;
	private JButton [] tabButton;
	private DonneeGraphe donnees;
	private Panel pD, pG;
	public PanelLegende(DonneeGraphe d)
	{
		pG = new Panel();
		pD = new Panel();
		pD.setLayout(new GridLayout(10,1));
		pG.setLayout(new GridLayout(10,1));
		pD.setPreferredSize(new Dimension(20,200));
		pG.setPreferredSize(new Dimension(100,200));
		add(pD);
		add(pG);
		
		tabButton = new JButton [5];
		
		update(d);
		
		
	}
	
	
	public void update(DonneeGraphe d)
	{
		Label legende;
		int height = 30;
		int width = 100;
		Ecouteur ec;
		
		donnees = d;
		pD.removeAll();
		pG.removeAll();
		
		for (int i = 0; i< donnees.taille(); i++)
		{
			legende = new Label(donnees.getPortion(i).getLegende() + ": " + Integer.toString(donnees.getPortion(i).getValeur()));
			legende.setSize(width, height);
			tabButton[i] = new JButton();
			Panel p = new Panel();
			tabButton[i].setBackground(donnees.getPortion(i).getColor());
			tabButton[i].setPreferredSize(new Dimension(8,8));
			ec = new Ecouteur();
			tabButton[i].addActionListener(ec);
			p.add(tabButton[i]);
			pD.add(p);
			pG.add(legende);
		}
		validate();
	}
	
	class Ecouteur implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			System.out.println("clique sur le bouton");
			JColorChooser jcc= new JColorChooser();
			Color c = JColorChooser.showDialog(jcc,"Choisir la couleur",Color.orange);
			
			JButton b = (JButton) ae.getSource();
			for (int i = 0; i< donnees.taille(); i++)
			{
				if (b == tabButton[i])
				{
					donnees.modifieColor(i, c);
					tabButton[i].setBackground(c);
				}
			}
			
		}
	}
}