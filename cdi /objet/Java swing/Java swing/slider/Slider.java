import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*
 * Created on 3 févr. 2005
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
public class Slider extends JFrame
{
	private JTextField tf = new JTextField(" 10 ");

	public Slider(String titre) 
	{
		super(titre);
		// le defaultboundedrangemodel sert de modele de donnée pour les outils
		// comme les sliders, les scrollbars et les progressbars
		// param 1 c'est la valeur d'initialisation
		// param2 c'est l'extend c'est à dire la largeur d'un curseur 
		// ( si le curseur est pointu la largeur est nulle ) donc ici 0
		// si ici non 0 , alors le cursuer ne pourra pas aller jusqu'au bout.
		// param3 c'est la valeur minimale
		// param4 c'est la valeur maximale
		DefaultBoundedRangeModel brm = new DefaultBoundedRangeModel(10,0,0,45);
		// le slider est construit associé au modèle
		JSlider js = new JSlider(brm);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(js,BorderLayout.NORTH);
		getContentPane().add(tf,BorderLayout.SOUTH);
		// je programe le curseur pour être précisement sur un tick ( le + proche )
		js.setSnapToTicks(true);
		// je mets des petits ticks tous les 1
		js.setMinorTickSpacing(1);
		// je mets des gros ticks tous les 5
		js.setMajorTickSpacing(5);
		// je peins les ticks
		js.setPaintTicks(true);
		// je veux des labels sur les ticks
		js.setPaintLabels(true);
		// je crée des labels tous les 5 ticks
		js.setLabelTable(js.createStandardLabels(5));
		setBounds(100,100,500,500);
		// je mets un écouteur sur les changements sur le slider
		Ecouteur ec = new Ecouteur();
		js.addChangeListener(ec);
		setVisible(true);
	}
	class Ecouteur implements ChangeListener
	{
		public void stateChanged(ChangeEvent ce) 
		{
			tf.setText(""+((JSlider)ce.getSource()).getValue());
		}
		
	}

}
