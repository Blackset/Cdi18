import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

import java.awt.*;
/*
 * Created on 7 févr. 2005
 */

/**
 * @author corre
 * 
 * cet essai de liste traite d'une liste variable, avec les sélections
 * par défaut ( multiples sélections possibles), et un rendu de la liste par défaut
 */
public class Fenetre extends JFrame 
{
	// contenu variable de la liste. Le contenu sera mis à jour pas à pas
	private DefaultListModel model = new DefaultListModel();
	// création de la liste sur son modèle
	private JList jl = new JList(model);
	// encadrement par des barres de scroll
	private JScrollPane js = new JScrollPane(jl);
	// label d'affichage des noms sélectionnés de la liste
	private JLabel jlab = new JLabel("                                           ");
	// bouton pour ajouter des éléments à la liste
	private JButton ajout = new JButton("ajouter");
	private JTextField jtf = new JTextField();
	
	public Fenetre()
	{
		// la selection de liste sera simple ( un seul élément )
		// il faut donc récupérer le modèle de sélection,et le configurer
		jl.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// association d'un rendu d'élément
		jl.setCellRenderer(new MonRendu());

		// ecouteur sur toute modification de la selection
		Ecouteur ec = new Ecouteur();
		// abonnement de l'écouteur
		jl.addListSelectionListener(ec);
		setTitle("liste avec modèle de données, selection, et rendu cellule");
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
			// récupération de l'ensemble de la selection
			Object [] val = jl.getSelectedValues();
			
			String affiche = new String();
			for (int i = 0;i < val.length;i++)
			{
				affiche += " "+((String)val[i]);
			}
			// affichage de l'ensemble de la sélection
			jlab.setText(affiche);
		}
	}
	public class MonRendu extends JLabel implements ListCellRenderer 
	{
		public MonRendu()
		{
			setOpaque(true);
		}
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) 
		{
			if ((index >= 0)&&(index <10))
			{
				setIcon(new ImageIcon("gif"+(index+1)+".gif"));

			}
			else
			{
				setIcon(new ImageIcon("gif.gif"));
			}
			setText(" "+ (String)model.getElementAt(index));
			if ( isSelected)
			{
				setBackground(new Color(240,230,220));
			}
			else
			{
				setBackground(new Color(255,200,200));
			}
			setForeground(Color.black);
			
			ImageIcon icon = (ImageIcon)getIcon();
			icon.setImageObserver(new ImageAnimator(list));
			return this;

		}

	}
	class ImageAnimator implements ImageObserver
	{
		JList m_list;
		
		public ImageAnimator(JList iconed)
		{
			if(iconed!=null)
			{
				m_list=iconed;
			}
			else
			{
				RuntimeException re = new RuntimeException();
				throw re;
			}
		}
		
		public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height)
		{
			if((infoflags & (ALLBITS | FRAMEBITS))!=0 )
			{
				m_list.repaint();
			}
			return (infoflags & (ALLBITS | ABORT)) == 0;
		}
	}

	}
