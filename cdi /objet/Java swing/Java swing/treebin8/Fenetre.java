import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class Fenetre extends JFrame
{
	private Arbre jt; // voici le JTree
	private JScrollPane jsp=null;// il est enrobé dans un JScrollPane
	private TreeExpansionListener tel;// il va écouter les déploiments
	private TreeModelListener tml;// il va écouter l'évolution des données
	private JButton jb = new JButton("ok");// bouton de validation d'expression
	private JTextField jtf = new JTextField();// zone saisie expression
	private JTextField jtfval = new JTextField();// zone affichage résultat expr
	private ModelTreeBin mtb;// modèle des données
	public Fenetre()
	{
		getContentPane().add(jb,BorderLayout.EAST);
		getContentPane().add(jtf,BorderLayout.NORTH);
		getContentPane().add(jtfval,BorderLayout.SOUTH);
		Ecouteur ec = new Ecouteur();
		jb.addActionListener(ec) ;
		
		setBounds(100,100,400,400);
		setVisible(true);
		// init des icones des arbres
		UIManager.put("Tree.expandedIcon",new ImageIcon("banane.gif"));
		UIManager.put("Tree.collapsedIcon",new ImageIcon("bn.gif"));
		//UIManager.put("Tree.closedIcon",new ImageIcon("e:\\corre\\valtech\\jgui\\images\\banana.gif"));
		//UIManager.put("Tree.openIcon",new ImageIcon("e:\\corre\\valtech\\jgui\\images\\hotdog.gif"));
		//UIManager.put("Tree.leafIcon",new ImageIcon("e:\\corre\\valtech\\jgui\\images\\hamburger.gif"));
		
	}
	// il faut un écouteur sur les changements du modèle, afin de mettre à
	// jour la valeur de l'expression, et de mettre à jour le texte complet de
	// l'expression
	class EcouteurArbre implements TreeModelListener
	{
		public void treeNodesChanged(TreeModelEvent e)
		{
			jtf.setText(jt.getChaine());
			jtfval.setText(new Double(jt.getVal()).toString());
		}
		public void treeNodesInserted(TreeModelEvent e)
		{
			jtf.setText(jt.getChaine());
			jtfval.setText(new Double(jt.getVal()).toString());
		}
		public void treeNodesRemoved(TreeModelEvent e)
		{
			jtf.setText(jt.getChaine());
			jtfval.setText(new Double(jt.getVal()).toString());
		}
		public void treeStructureChanged(TreeModelEvent e)
		{
			jtf.setText(jt.getChaine());
			jtfval.setText(new Double(jt.getVal()).toString());
		}
	}
	// sur le bouton il faut virer l'ancien arbre et en construire un nouveau
	class Ecouteur implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// il faut construire un modèle de données pour l'arbre à partir
			// de l'expression donnée dans la zone texte
			try
			{
				mtb = new ModelTreeBin(jtf.getText() );
				tml = new EcouteurArbre();
				
				if (jsp != null)
				{
					// il y a un vieil arbre, abattons le ( et tant pis pour Idéfix)
					getContentPane().remove(jsp);
					jt.removeTreeExpansionListener(jt);
				}
				// plantons un jeune arbre sur le modèle de donnée établi
				if (mtb != null)
				{
					jt = new Arbre(mtb);
					jt.abonne(tml);
					jt.setShowsRootHandles(true); // on rend visible les poignées
					jt.collapseRow(0); // ferme, une seule ligne
					jsp = new JScrollPane(jt);
					getContentPane().add(jsp,BorderLayout.CENTER );
					setVisible(false);
					setVisible(true);  // magouille car le rafraichissement n'est pas parfait
				}
				
			}
			catch (Exception ex)
			{
				JOptionPane.showInternalMessageDialog(getContentPane() ,"L'expression est incorrecte "+ ex,
						"Calcul d'une expression",
						JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
	}
	
}