import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

import java.awt.*;
/*
 * Created on 7 f�vr. 2005
 */

/**
 * @author corre
 * 
 * cet essai de liste traite d'une liste variable, avec les s�lections
 * par d�faut ( multiples s�lections possibles), et un rendu de la liste par d�faut
 */
public class Fenetre extends JFrame 
{
	// contenu variable de la liste. Le contenu sera mis � jour pas � pas
	private DefaultListModel model = new DefaultListModel();
	// cr�ation de la liste sur son mod�le
	private JList jl = new JList(model);
	// encadrement par des barres de scroll
	private JScrollPane js = new JScrollPane(jl);
	// label d'affichage des noms s�lectionn�s de la liste
	private JLabel jlab = new JLabel("                                           ");
	// bouton pour ajouter des �l�ments � la liste
	private JButton ajout = new JButton("ajouter");
	private JTextField jtf = new JTextField();
	
	public Fenetre()
	{
		// ecouteur sur toute modification de la selection
		Ecouteur ec = new Ecouteur();
		// abonnement de l'�couteur
		jl.addListSelectionListener(ec);
		setTitle("liste avec mod�le de donn�es");
		Container aff = getContentPane();
		aff.setLayout(new GridLayout(4,1));
		// mettre la liste, le bouton d'ajout, la zone de saisie et le label dans le contentpane
		aff.add(js);
		aff.add(ajout);
		aff.add(jtf);
		aff.add(jlab);
		// ecouteur sur le bouton d'ajout
		EcBout eb = new EcBout();
		ajout.addActionListener(eb);
		
		setBounds(100,10,500,500);
		setVisible(true);
	}
	class EcBout implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			// si le texte est correct, le mettre dans la liste
			String s = jtf.getText();
			if ( (s != null) && (!s.trim().equals("")))
			{
				model.addElement(s);
				jtf.setText("");
			}
			
		}
		
	}
	class Ecouteur implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			// r�cup�ration de l'ensemble de la selection
			Object [] val = jl.getSelectedValues();
			
			String affiche = new String();
			for (int i = 0;i < val.length;i++)
			{
				affiche += " "+(String)val[i];
			}
			// affichage de l'ensemble de la s�lection
			jlab.setText(affiche);
		}
	}
}
