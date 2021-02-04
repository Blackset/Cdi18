import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;

public class ModelTreeBin implements TreeModel
{
	Vector ecouteurs;// enregistrement des écouteurs de modification de données
	private Noeud root; // racine de l'arborescence
	public ModelTreeBin(String s) throws IllegalArgumentException
	{
		Entier i = new Entier(0); // entier init à 0
		
		root = (Noeud)former(s,i,true); // ici on forme l'arbre, à partir de s,
		// à la racine. si pb exception
	}
	// construction de l'arborescence à partir de i dans la chaine
	// s est la chaine
	// i est l'indice à partir duquel on cherche un sous arbre
	// racine est vrai quand on cherche l'arbre, et faux pour un sous arbre
	// retourne une feuille ou un sous arbre, ou une exception si pb
	public Object former(String s,Entier i, boolean racine) throws IllegalArgumentException
	{
		Object gauche, op, droite=null;
		if (s.charAt(i.getVal() ) == '(')
		{
			i.setVal(i.getVal()+1); // on saute la parenthèse
			gauche = getVal(s,i);
			op = getOp(s,i);
			if (op != null) droite = getVal(s,i);
			if (s.charAt(i.getVal() ) != ')') // expression mal formée
			{
				throw new IllegalArgumentException( "manque parenthèse fermante "+s);
			}
			else
			{
				i.setVal(i.getVal()+1); // on saute la parenthèse
			}
		}
		else
		{
			gauche = getVal(s,i);
			op = getOp(s,i);
			if (op != null) droite = getVal(s,i);
		}
		// on a fait notre travail, donc la chaine doit avoir été parcourue
		// jusqu'au bout si on est le premier appel ( racine == vrai )
		if ( racine == true && i.getVal() != s.length() )
		{
			throw new IllegalArgumentException( "il reste des merdouilles en fin d'expression "+s);
		}
		// si on est au premier appel et que il y a seulement un entier il faut
		// en faire un Noeud ( avec + 0 )
		
		if ( racine == true && op == null) // il y a juste un nombre
		{
			op = new Noeud(Noeud.ADD);
			droite = new Entier(0);
		}
		// maintenant il faut construire le noeud
		if ( op == null)
		{
			return gauche; // juste l'Entier
		}
		else
		{
			((Noeud)op).setChild(0,gauche);
			((Noeud)op).setChild(1,droite);
			return op;
		}
	}
	// récupère un Entier ou un sous arbre
	public Object getVal(String s, Entier i)throws IllegalArgumentException
	{
		if ( i.getVal() < s.length())
		{
			// récupère soit une sous expression, soit une valeur simple
			if (s.charAt(i.getVal())== '(')
			{
				return former(s,i,false); // une sous expression
			}
			else
			{
				StringBuffer sb = new StringBuffer(20);
				// ici il y a une valeur entière
				while (i.getVal() < s.length() && Character.isDigit(s .charAt(i.getVal())))
				{
					sb.append(s .charAt(i.getVal())); // on copie le chiffre
					i.setVal(i.getVal()+1); // on incrémente i
				}
				// on fabrique donc un entier avec tout ça. si pb alors exception
				Entier valeur= new Entier(0);
				try
				{
					valeur.setVal(new Integer(sb.toString()).intValue());
				}
				catch (Exception ex)
				{
					throw new IllegalArgumentException("valeur numérique incorrecte");
				}
				return valeur;
			}
		}
		else
		{
			return null; // il n'y a rien
		}
	}
	// retourne un noeud avec le bon opérateur
	public Object getOp(String s, Entier i)
	{
		if ( i.getVal() < s.length())
		{
			switch (s.charAt(i.getVal()))
			{
			case '+': i.setVal(i.getVal()+1); // on incrémente i
			return new Noeud(Noeud.ADD);
			case '-': i.setVal(i.getVal()+1); // on incrémente i
			return new Noeud(Noeud.SUB);
			case '*': i.setVal(i.getVal()+1); // on incrémente i
			return new Noeud(Noeud.MUL);
			case '/': i.setVal(i.getVal()+1); // on incrémente i
			return new Noeud(Noeud.DIV);
			default : return null;
			}
			
		}
		else
		{
			return null; // il n'y a rien
		}
		
	}
	// rend le noeud racine de l'arbre
	public Object getRoot()
	{
		return root;
	}
	// rend l'enfant demandé
	public Object getChild(Object parent, int index)
	{
		if (parent instanceof Noeud)
		{
			return ((Noeud)parent).getChild(index);
		}
		return null;
	}
	// rend le nombre d'enfants
	public int getChildCount(Object parent)
	{
		if (parent instanceof Noeud)
		{
			return ((Noeud)parent).getChildCount();
		}
		else
		{
			return 0;
		}
		
	}
	// indique si c'est une feuille
	public boolean isLeaf(Object node)
	{
		return !(node instanceof Noeud); // une Integer pour les feuilles
	}
	// ici il faut traiter la modification faite dans l'arbre
	// Cette méthode est fort complexe, car elle doit tenir compte de 4 aspects
	// 1) Quand on modifie directement un arbre il y a un certain nombre de cas
	//      - on modifie la racine ouverte
	//      - on modifie la racine fermée
	//      - on modifie un noeud ouvert ( donc uniquement l'opérateur )
	//      - on modifie un noeud fermé par un autre noeud
	//      - on modifie un noeud fermé par une feuille
	//      - on modifie une feuille
	// 2) Quand la structure de l'arbre est modifiée, il faut appeler
	// treeStructureChanged, autremnet il faut appeler treeNodeChanged
	// 3) BasicTreeUI agit quand un noeud est modifié. La racine est ouverte, et
	// ses enfants fermés. Quand un autre noeud est modifié, il reste fermé.
	// Quand une feuille est modifiée ou un noeud transformé en feuille, c'est
	// de fait le noeud parent qui est modifié. Le parent reste ouvert, mais les
	// enfants sont fermés. Il faut donc fermé le frère...
	// 4) Si les informations rentrées ne sont pas pertinentes, il faut effacer
	// ces modifications.
	public void valueForPathChanged(TreePath path, Object newValue)
	{
		Object [] p = path.getPath();
		if ( p.length == 1)
		{// on édite la racine
			Noeud n = (Noeud)p[p.length-1];
			if ( !n.getOuvert())
			{ // arborescence fermée il faut refaire une expression
				Noeud nouveau;
				try
				{
					nouveau = (Noeud)former((String) newValue,new Entier(0),true);
				}
				catch (Exception ex)
				{
					nouveau = null;
				}
				
				if ( nouveau != null)
				{// mise à jour du noeud racine
					root.setOperateur( nouveau.getOperateur());
					root.setChild(0,nouveau.getChild(0));
					root.setChild(1,nouveau.getChild(1));
				}
				// prévenir tous les écouteurs que la structure a changé
				root.setOuvert(true) ;
				fireTreeStructureChanged(this,path);
			}
			else
			{// arborescence ouverte il faut changer l'opérateur
				n.setOperateur(newValue);
				// prévenir tous les écouteurs que ça à changé
				fireTreeNodeChanged(this,p,null,new Object[]{root});
			}
		}
		else
		{
			// il y a un noeud développé
			// est-ce un noeud?
			if (p[p.length-1] instanceof Noeud)
			{
				Noeud n = (Noeud)p[p.length-1];
				if ( !n.getOuvert())
				{ // arborescence fermée il faut refaire une expression
					Object nouveau;
					try
					{
						nouveau = former((String) newValue,new Entier(0),false);
					}
					catch (Exception ex)
					{
						nouveau = null;
					}
					if (nouveau instanceof Noeud) // pas remplacé par une feuille
					{
						if ( nouveau != null)
						{// mise à jour du noeud concerné
							n.setOperateur( ((Noeud)nouveau).getOperateur());
							n.setChild(0,((Noeud)nouveau).getChild(0));
							n.setChild(1,((Noeud)nouveau).getChild(1));
						}
						// prévenir tous les écouteurs que la structure a changé
						fireTreeStructureChanged(this,path);
					}
					else
					{
						// on remplace un Noeud par une feuille
						n = (Noeud)p[p.length-2]; // c'est le fils du père qu'il faut changer
						Entier x = (Entier) nouveau;
						
						if ( nouveau != null)
						{// mise à jour du noeud racine
							n.setChild(n.getIndexOfChild(p[p.length-1]),nouveau);
							n.setOuvert(true) ;
						}
						// prévenir tous les écouteurs que ça a changé
						// construire le nouveau path en enlevant le dernier
						Object[] np = new Object[p.length-1];
						for (int i = 0; i < np.length ; i++)
						{
							np[i] = p[i];
						}
						// ici le frère sera fermé car on touche au père
						Object frère;
						if ( nouveau != null)
						{
							frère = n.getChild(1 - n.getIndexOfChild(nouveau));
						}
						else
						{
							frère = n.getChild(1 - n.getIndexOfChild(p[p.length-1]));
						}
						
						if (frère instanceof Noeud)
						{
							((Noeud)frère).setOuvert(false);
						}
						TreePath perepath = new TreePath(np);
						// prévenons que la structure a changé
						fireTreeStructureChanged(this,perepath);
					}
					
				}
				else
				{// arborescence ouverte il faut changer l'opérateur
					n.setOperateur(newValue);
					// prévenir tous les écouteurs que ça a changé
					fireTreeNodeChanged(this,p,null,new Object[]{root});
				}
			}
			else
			{
				// c'est une feuille
				Noeud n = (Noeud)p[p.length-2]; // c'est le fils du père qu'il
				// faut changer
				Entier x = (Entier) p[p.length-1];
				Object nouveau;
				try
				{
					nouveau = former((String) newValue,new Entier(0),false);
				}
				catch (Exception ex)
				{
					nouveau = null;
				}
				if ( nouveau != null)
				{// mise à jour du noeud racine
					n.setChild(n.getIndexOfChild(x),nouveau);
				}
				// prévenir tous les écouteurs que ça a changé
				// construire le nouveau path en enlevant le dernier
				Object[] np = new Object[p.length-1];
				for (int i = 0; i < np.length ; i++)
				{
					np[i] = p[i];
				}
				TreePath perepath = new TreePath(np);
				// on touche au père, le frère sera donc présenté fermé
				Object frère;
				if ( nouveau != null)
				{
					frère = n.getChild(1 - n.getIndexOfChild(nouveau));
				}
				else
				{// on récupère l'ancienne valeur
					frère = n.getChild(1 - n.getIndexOfChild(x));
				}
				
				if (frère instanceof Noeud)
				{
					((Noeud)frère).setOuvert(false); // frère fermé
				}
				//prévenons tout le monde des modifications
				fireTreeStructureChanged(this,perepath);
			}
		}
		
	}
	// on donne un fils et on veut connaître son index
	public int getIndexOfChild(Object parent, Object child)
	{
		if (parent instanceof Noeud)
		{
			return ((Noeud)parent).getChildCount();
		}
		else
		{
			return -1;
		}
		
	}
	// methode de rafraichissemnet des étiquettes de l'arbre en fonction du deploiemeent
	public void refresh(TreeExpansionEvent tee)
	{
		fireTreeNodeChanged(tee.getSource(),tee.getPath().getPath(),null,new Object[]{tee.getPath().getLastPathComponent()});
		// le premier getPath donne un TreePath, le deuxième un tableau de noeuds
		// param 3 est le tableau des noeuds à enlever ( ici aucun )
		// param 4 est la liste des noeuds à modifier, ajouter ou enlever
	}
	
	// méthode pour prévenir tous les écouteurs de l'arbre que ses données ont changé
	synchronized private void fireTreeNodeChanged(Object source, Object[] path, int[] ci,Object [] cc)
	{
		if (ecouteurs != null)
		{
			for (int i = 0; i<ecouteurs.size();i++)
				// il y a par defaut 2 écouteurs JTree et BasicUI
			{
				TreeModelEvent tme = new TreeModelEvent(source,path,ci,cc);
				((TreeModelListener)ecouteurs.elementAt(i)).treeNodesChanged(tme);
			}
			
		}
	}
	// méthode pour prévenir tous les écouteurs de l'arbre que ses données ont changé
	synchronized private void fireTreeStructureChanged(Object source, TreePath path)
	{
		if (ecouteurs != null)
		{
			for (int i = 0; i<ecouteurs.size();i++)
				// il y a par defaut 2 écouteurs JTree et BasicUI
			{
				TreeModelEvent tme = new TreeModelEvent(source,path);
				((TreeModelListener)ecouteurs.elementAt(i)).treeStructureChanged(tme);
			}
			
		}
	}
	
	synchronized public void addTreeModelListener(TreeModelListener l)
	{
		// à implémenter quand on veut être prévenu des modifications dans l'arbre
		if ( ecouteurs == null)
		{
			ecouteurs = new Vector();
		}
		ecouteurs.addElement(l) ;
	}
	synchronized public void removeTreeModelListener(TreeModelListener l)
	{
		// à implémenter quand on veut être prévenu des modifications dans l'arbre
		if (ecouteurs != null)
		{
			ecouteurs.removeElement(l);
		}
		
	}
	// recupère l'équivalent en chaine de l'expression
	public String getChaine()
	{
		StringBuffer buf = new StringBuffer(80);
		root.buildExprString(buf,root) ;
		return buf.toString();
	}
	// calcule la valeur de l'expression
	public double getVal()
	{
		return root.getVal();
	}
}