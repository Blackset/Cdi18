import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeModelListener;
class Entier
// cette classe habille un entier en objet
// pour les passages de paramètres c'est OK
{
	private int val = 0;
	public Entier(int va)
	{
		val = va;
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
		return new String(new Integer(val).toString());
	}
}
public class ModelTreeBin implements TreeModel
{
	private Noeud root;
	public ModelTreeBin(String s) throws IllegalArgumentException
	{
		Entier i = new Entier(0); // entier init à 0
		
		root = (Noeud)former(s,i,true); // ici on forme l'arbre, à partir de s, à la racine
	}
	public Object former(String s,Entier i, boolean racine) throws IllegalArgumentException
	{
		Object gauche, op, droite= null;
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
			if (op != null)droite = getVal(s,i);
		}
		// on a fait notre travail, donc la chaine doit avoir été parcourue jusqu'au bout si on est le premier appel ( racine == vrai )
		// si on est au premier appel et que il y a seukement un entier il faut en faire un Noeud
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
				Entier valeur ;
				try
				{
					valeur =  new Entier(new Integer(sb.toString()).intValue() );
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
		//à implémenter quand on veut être prévenu des changements dans l'arbre
		throw new java.lang.UnsupportedOperationException("La méthode valueForPathChanged() n'est pas encore implémentée.");
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
	public void addTreeModelListener(TreeModelListener l)
	{
		// à implémenter quand on veut être prévenu des modifications dans l'arbre
		// throw new java.lang.UnsupportedOperationException("La méthode addTreeModelListener() n'est pas encore implémentée.");
	}
	public void removeTreeModelListener(TreeModelListener l)
	{
		// à implémenter quand on veut être prévenu des modifications dans l'arbre
		//throw new java.lang.UnsupportedOperationException("La méthode removeTreeModelListener() n'est pas encore implémentée.");
	}
}