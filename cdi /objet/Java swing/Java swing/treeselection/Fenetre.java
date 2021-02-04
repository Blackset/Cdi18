import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

public class Fenetre extends JFrame
{
	DefaultTreeModel tm;
	JTree jt;
	JButton bt;
	public Fenetre()
	{
		DefaultMutableTreeNode afpa = new DefaultMutableTreeNode("afpa",true);
		DefaultMutableTreeNode lpc = new DefaultMutableTreeNode("Le Pont de Claix",true);
		DefaultMutableTreeNode ven = new DefaultMutableTreeNode("Venissieux",true);
		DefaultMutableTreeNode cha = new DefaultMutableTreeNode("Chambery",true);
		DefaultMutableTreeNode ann = new DefaultMutableTreeNode("Annecy",true);
		DefaultMutableTreeNode di = new DefaultMutableTreeNode("Developpeur informatique",false);
		DefaultMutableTreeNode tsrit = new DefaultMutableTreeNode("Technicien supérieur en Réseaux informatiques et télécommunication",false);
		DefaultMutableTreeNode cdse = new DefaultMutableTreeNode("Concepteur Développeur en systèmes électroniques",false);
		DefaultMutableTreeNode tse = new DefaultMutableTreeNode("Technicien supérieur en électronique",false);
		DefaultMutableTreeNode tsaii = new DefaultMutableTreeNode("Technicien Supérieur en Automatisme et Informatique Industrielle",false);
		DefaultMutableTreeNode fcpc = new DefaultMutableTreeNode("Fabricant de Croquettes Pour Chiens",false);
		DefaultMutableTreeNode fcpa = new DefaultMutableTreeNode("Fabricant de Croquettes Pour Autruches",false);
		afpa.add(lpc);
		afpa.add(ven);
		afpa.add(cha);
		afpa.add(ann);
		lpc.add(di);
		lpc.add(tsrit);
		lpc.add(cdse);
		lpc.add(tse);
		lpc.add(tsaii);
		ann.add(fcpc);
		ann.add(fcpa);
		bt = new JButton("                                                             ");
		DefaultTreeModel tm = new DefaultTreeModel(afpa,true);
		// le TreeModel est bien l'endroit où se trouvent les informations du JTree
		jt = new JTree(tm);
		TreeSelectionListener tsl = new Select();
		jt.addTreeSelectionListener(tsl);
		jt.setShowsRootHandles(true); // handle visible sur la racine
		jt.setScrollsOnExpand(true); // rend le plus visible possible la partie ouverte
		getContentPane().add(new JScrollPane(jt),BorderLayout.NORTH);
		getContentPane().add(bt,BorderLayout.SOUTH);
		setBounds(100,100,700,500);
		setVisible(true);
	}
	
	DefaultMutableTreeNode getSelectedNode()
	{
		TreePath selectedPath = jt.getSelectionPath(); // chemin depuis la racine
		if (selectedPath == null) return null;
		return (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
		// nom de la dernière feuille ou dernier noeud
	}
	
	
	class Select implements TreeSelectionListener
	{
		public void valueChanged(TreeSelectionEvent tse)
		{
			DefaultMutableTreeNode node = getSelectedNode();
			if ( node != null && node.isLeaf() ) // différent de getAllowsChildren
			{                                    // qui dit si on est autorisé a avoir des enfants
				bt.setText(node.getUserObject().toString());
			}
		}
	}
}