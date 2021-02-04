import javax.swing.tree.*;
import java.awt.*;
import javax.swing.*;

public class RenduCelluleArbre extends JLabel implements TreeCellRenderer
{
	private ModelTreeBin modele;
	private boolean isleaf;
	private Object noeud;
	private Color couleur= Color.pink;
	public RenduCelluleArbre(ModelTreeBin mtb)
	{
		// on veut une police plus grosse
		setFont(new Font("Monospaced",Font.PLAIN,16));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		modele = mtb;
	}
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{// modifie le tracé ( couleur de fond ici )
		if ( selected )
		{
			setOpaque(true);
			setBackground(couleur);
		}
		else
		{
			setOpaque(false);
			setBackground(Color.white);
		}
		noeud = value;
		isleaf = leaf;
		setText(value.toString());
		return this;
	}
	public String getToolTipText() // tooltip
	{
		if (isleaf)
		{
			return "feuille "+ noeud.toString();
		}
		else
		{
			if (modele.getRoot()== (Noeud) noeud)
			{
				return "racine "+ noeud.toString();
				
			}
			else
			{
				return "noeud "+ noeud.toString();
			}
		}
	}
	public Dimension getPreferredSize() // donne de l'air à l'arbre
	{
		Dimension dim = super.getPreferredSize();
		if ( dim != null)
		{
			dim = new Dimension(dim.width+20, dim.height);
		}
		return dim;
	}
}