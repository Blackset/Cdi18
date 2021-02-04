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
		this.setEditable(true);
	}
	// 2 m�thodes pour etre un TreeExpansionListener
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
	// la fenetre doit pouvoir etre prevenue des modif sur l'arbre
	public void abonne(TreeModelListener tml)
	{
		model.addTreeModelListener(tml);
	}
	// la fenetre doit pouvoir r�cup�rer la chaine de l'expression
	public String getChaine()
	{
		return model.getChaine();
	}
	// la fenetre doit pouvoir r�cup�rer la valeur de l'expression
	public double getVal()
	{
		return model.getVal() ;
	}
}