import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.*;
import java.util.*;

class Entier
{// cette classe permet de passer un entier en param�tre de sortie
	private int val = 0;
	public Entier(int vale)
	{
		val = vale;
	}
	public void setVal(int j)
	{
		val = j;
	}
	public int getVal()
	{
		return val;
	}
	public String toString()
	{
		return new Integer(val).toString();
	}
}
public class ModelTreeBin implements TreeModel
{
	Vector ecouteurs;
	private Noeud root; // racine de l'arborescence
	public ModelTreeBin(String s) throws IllegalArgumentException
	{
		Entier i = new Entier(0); // entier init � 0
		
		root = (Noeud)former(s,i,true); // ici on forme l'arbre, � partir de s, � la racine
	}
	public Object former(String s,Entier i, boolean racine) throws IllegalArgumentException
	{
		Object gauche, op, droite=null;
		if (s.charAt(i.getVal() ) == '(')
		{
			i.setVal(i.getVal()+1); // on saute la parenth�se
			gauche = getVal(s,i);
			op = getOp(s,i);
			if (op != null) droite = getVal(s,i);
			if (s.charAt(i.getVal() ) != ')') // expression mal form�e
			{
				throw new IllegalArgumentException( "manque parenth�se fermante "+s);
			}
			else
			{
				i.setVal(i.getVal()+1); // on saute la parenth�se
			}
		}
		else
		{
			gauche = getVal(s,i);
			op = getOp(s,i);
			if (op != null) droite = getVal(s,i);
		}
		// on a fait notre travail, donc la chaine doit avoir �t� parcourue jusqu'au bout si on est le premier appel ( racine == vrai )
		// si on est au premier appel et que il y a seulement un entier il faut en faire un Noeud
		if ( racine == true && i.getVal() != s.length() )
		{
			throw new IllegalArgumentException( "il reste des merdouilles en fin d'expression "+s);
		}
		if ( racine == true && op == null) // il y a juste un nombre
		{
			op = new Noeud(Noeud.ADD);
			droite = new Entier(0);
		}
		// maintenant il faut construire le noeud
		if ( op == null)
		{
			return gauche; // juste l'Integer
		}
		else
		{
			((Noeud)op).setChild(0,gauche);
			((Noeud)op).setChild(1,droite);
			return op;
		}
	}
	public Object getVal(String s, Entier i)throws IllegalArgumentException
	{
		if ( i.getVal() < s.length())
		{
			// r�cup�re soit une sous expression, soit une valeur simple
			if (s.charAt(i.getVal())== '(')
			{
				return former(s,i,false); // une sous expression
			}
			else
			{
				StringBuffer sb = new StringBuffer(20);
				// ici il y a une valeur enti�re
				while (i.getVal() < s.length() && Character.isDigit(s .charAt(i.getVal())))
				{
					sb.append(s .charAt(i.getVal())); // on copie le chiffre
					i.setVal(i.getVal()+1); // on incr�mente i
				}
				// on fabrique donc un entier avec tout �a. si pb alors exception
				Entier valeur= new Entier(0);
				try
				{
					valeur.setVal(new Integer(sb.toString()).intValue());
				}
				catch (Exception ex)
				{
					throw new IllegalArgumentException("valeur num�rique incorrecte");
				}
				return valeur;
			}
		}
		else
		{
			return null; // il n'y a rien
		}
	}
	public Object getOp(String s, Entier i)
	{
		if ( i.getVal() < s.length())
		{
			switch (s.charAt(i.getVal()))
			{
			case '+': i.setVal(i.getVal()+1); // on incr�mente i
			return new Noeud(Noeud.ADD);
			case '-': i.setVal(i.getVal()+1); // on incr�mente i
			return new Noeud(Noeud.SUB);
			case '*': i.setVal(i.getVal()+1); // on incr�mente i
			return new Noeud(Noeud.MUL);
			case '/': i.setVal(i.getVal()+1); // on incr�mente i
			return new Noeud(Noeud.DIV);
			default : return null;
			}
			
		}
		else
		{
			return null; // il n'y a rien
		}
		
	}
	public Object getRoot()
	{
		return root;
	}
	public Object getChild(Object parent, int index)
	{
		if (parent instanceof Noeud)
		{
			return ((Noeud)parent).getChild(index);
		}
		return null;
	}
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
	public boolean isLeaf(Object node)
	{
		return !(node instanceof Noeud); // une Integer pour les feuilles
	}
	public void valueForPathChanged(TreePath path, Object newValue)
	{
		// si l'arbre est �ditable
	}
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
	// methode de rafraichissemnet des �tiquettes de l'arbre en fonction du deploiemeent
	public void refresh(TreeExpansionEvent tee)
	{
		fireTreeNodeChanged(tee.getSource(),tee.getPath().getPath(),null,null);
		// le premier getPath donne un TreePath, le deuxi�me un tableau de noeuds
		// param 3 est le tableau des noeuds � enlever ( ici aucun )
		// param 4 est la liste des noeuds � modifier, ajouter ou enlever
	}
	// m�thode pour pr�venir tous les �couteurs de l'arbre que ses donn�es ont chang�
	synchronized private void fireTreeNodeChanged(Object source, Object[] path, int[] ci,Object [] cc)
	{
		if (ecouteurs != null)
		{
			for (int i = 0; i<ecouteurs.size();i++) // pourquoi devoir mettre -1????
				// il y a un �couteur de BasicUI qui vient s'y mettre et met le bazar
			{
				TreeModelEvent tme = new TreeModelEvent(source,path,ci,cc);
				((TreeModelListener)ecouteurs.elementAt(i)).treeNodesChanged(tme);
			}
			
		}
	}
	
	synchronized public void addTreeModelListener(TreeModelListener l)
	{
		// � impl�menter quand on veut �tre pr�venu des modifications dans l'arbre
		if ( ecouteurs == null)
		{
			ecouteurs = new Vector();
		}
		ecouteurs.addElement(l) ;
	}
	synchronized public void removeTreeModelListener(TreeModelListener l)
	{
		// � impl�menter quand on veut �tre pr�venu des modifications dans l'arbre
		if (ecouteurs != null)
		{
			ecouteurs.removeElement(l);
		}
		
	}
}