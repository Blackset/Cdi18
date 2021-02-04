import javax.swing.JTree;
import javax.swing.event.*;
// la classe Arbre est un JTree qui surveille ses d�ploiements pour demander au
// modele de mettre � jour les �tiquettes de l'arbre quand on d�ploie, ou quand
// on replie.
public class Arbre extends JTree implements TreeExpansionListener
{
	private ModelTreeBin model;
	public Arbre(ModelTreeBin mtb)
	{
		super(mtb);
		model = mtb;
		addTreeExpansionListener(this);
	}
	public void treeExpanded(TreeExpansionEvent tee)
	{
		Noeud n = (Noeud)tee.getPath().getLastPathComponent();
		n.setOuvert(true);
		model.refresh(tee); // demande au modele de mettre � jour ses infos
	}
	public void treeCollapsed(TreeExpansionEvent tee)
	{
		Noeud n = (Noeud)tee.getPath().getLastPathComponent();
		n.setOuvert(false);
		model.refresh(tee); // demande au modele de mettre � jour ses infos
	}
	
}