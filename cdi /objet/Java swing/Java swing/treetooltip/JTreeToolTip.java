import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeToolTip extends JTree
{
	
	public JTreeToolTip(TreeModel tm)
	{
		super(tm);
		ToolTipManager.sharedInstance().registerComponent(this);
		// l'arbre est enregistré dans le ToolTipManager
	}
	public String getToolTipText(MouseEvent me)
	{
		TreePath path = getPathForLocation(me.getX(),me.getY());
		if (path == null)
		{
			return null;
		}
		else
		{
			TreeNode tn = (TreeNode)path.getLastPathComponent();
			
			if ( !tn.getAllowsChildren())
			{
				return "feuille "+tn;
			}
			else
			{
				if (tn.isLeaf() )
				{
					return "noeud vide "+tn;
				}
				else
				{
					return "noeud "+tn;
				}
			}
		}
	}
}