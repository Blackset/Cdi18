import javax.swing.tree.*;
import javax.swing.event.*;
import java.util.*;

public class ModelTreeBin implements TreeModel
{
	Vector ecouteurs;// enregistrement des �couteurs de modification de donn�es
	private Noeud root; // racine de l'arborescence
	public ModelTreeBin(String s) throws IllegalArgumentException
	{
		Entier i = new Entier(0); // entier init � 0
		
		root = (Noeud)former(s,i,true); // ici on forme l'arbre, � partir de s,
		// � la racine. si pb exception
	}
	// construction de l'arborescence � partir de i dans la chaine
	// s est la chaine
	// i est l'indice � partir duquel on cherche un sous arbre
	// racine est vrai quand on cherche l'arbre, et faux pour un sous arbre
	// retourne une feuille ou un sous arbre, ou une exception si pb
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
		// on a fait notre travail, donc la chaine doit avoir �t� parcourue
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
	// r�cup�re un Entier ou un sous arbre
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
	// retourne un noeud avec le bon op�rateur
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
	// rend le noeud racine de l'arbre
	public Object getRoot()
	{
		return root;
	}
	// rend l'enfant demand�
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
	// Cette m�thode est fort complexe, car elle doit tenir compte de 4 aspects
	// 1) Quand on modifie directement un arbre il y a un certain nombre de cas
	//      - on modifie la racine ouverte
	//      - on modifie la racine ferm�e
	//      - on modifie un noeud ouvert ( donc uniquement l'op�rateur )
	//      - on modifie un noeud ferm� par un autre noeud
	//      - on modifie un noeud ferm� par une feuille
	//      - on modifie une feuille
	// 2) Quand la structure de l'arbre est modifi�e, il faut appeler
	// treeStructureChanged, autremnet il faut appeler treeNodeChanged
	// 3) BasicTreeUI agit quand un noeud est modifi�. La racine est ouverte, et
	// ses enfants ferm�s. Quand un autre noeud est modifi�, il reste ferm�.
	// Quand une feuille est modifi�e ou un noeud transform� en feuille, c'est
	// de fait le noeud parent qui est modifi�. Le parent reste ouvert, mais les
	// enfants sont ferm�s. Il faut donc ferm� le fr�re...
	// 4) Si les informations rentr�es ne sont pas pertinentes, il faut effacer
	// ces modifications.
	public void valueForPathChanged(TreePath path, Object newValue)
	{
		Object [] p = path.getPath();
		if ( p.length == 1)
		{// on �dite la racine
			Noeud n = (Noeud)p[p.length-1];
			if ( !n.getOuvert())
			{ // arborescence ferm�e il faut refaire une expression
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
				{// mise � jour du noeud racine
					root.setOperateur( nouveau.getOperateur());
					root.setChild(0,nouveau.getChild(0));
					root.setChild(1,nouveau.getChild(1));
				}
				// pr�venir tous les �couteurs que la structure a chang�
				root.setOuvert(true) ;
				fireTreeStructureChanged(this,path);
			}
			else
			{// arborescence ouverte il faut changer l'op�rateur
				n.setOperateur(newValue);
				// pr�venir tous les �couteurs que �a � chang�
				fireTreeNodeChanged(this,p,null,new Object[]{root});
			}
		}
		else
		{
			// il y a un noeud d�velopp�
			// est-ce un noeud?
			if (p[p.length-1] instanceof Noeud)
			{
				Noeud n = (Noeud)p[p.length-1];
				if ( !n.getOuvert())
				{ // arborescence ferm�e il faut refaire une expression
					Object nouveau;
					try
					{
						nouveau = former((String) newValue,new Entier(0),false);
					}
					catch (Exception ex)
					{
						nouveau = null;
					}
					if (nouveau instanceof Noeud) // pas remplac� par une feuille
					{
						if ( nouveau != null)
						{// mise � jour du noeud concern�
							n.setOperateur( ((Noeud)nouveau).getOperateur());
							n.setChild(0,((Noeud)nouveau).getChild(0));
							n.setChild(1,((Noeud)nouveau).getChild(1));
						}
						// pr�venir tous les �couteurs que la structure a chang�
						fireTreeStructureChanged(this,path);
					}
					else
					{
						// on remplace un Noeud par une feuille
						n = (Noeud)p[p.length-2]; // c'est le fils du p�re qu'il faut changer
						Entier x = (Entier) nouveau;
						
						if ( nouveau != null)
						{// mise � jour du noeud racine
							n.setChild(n.getIndexOfChild(p[p.length-1]),nouveau);
							n.setOuvert(true) ;
						}
						// pr�venir tous les �couteurs que �a a chang�
						// construire le nouveau path en enlevant le dernier
						Object[] np = new Object[p.length-1];
						for (int i = 0; i < np.length ; i++)
						{
							np[i] = p[i];
						}
						// ici le fr�re sera ferm� car on touche au p�re
						Object fr�re;
						if ( nouveau != null)
						{
							fr�re = n.getChild(1 - n.getIndexOfChild(nouveau));
						}
						else
						{
							fr�re = n.getChild(1 - n.getIndexOfChild(p[p.length-1]));
						}
						
						if (fr�re instanceof Noeud)
						{
							((Noeud)fr�re).setOuvert(false);
						}
						TreePath perepath = new TreePath(np);
						// pr�venons que la structure a chang�
						fireTreeStructureChanged(this,perepath);
					}
					
				}
				else
				{// arborescence ouverte il faut changer l'op�rateur
					n.setOperateur(newValue);
					// pr�venir tous les �couteurs que �a a chang�
					fireTreeNodeChanged(this,p,null,new Object[]{root});
				}
			}
			else
			{
				// c'est une feuille
				Noeud n = (Noeud)p[p.length-2]; // c'est le fils du p�re qu'il
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
				{// mise � jour du noeud racine
					n.setChild(n.getIndexOfChild(x),nouveau);
				}
				// pr�venir tous les �couteurs que �a a chang�
				// construire le nouveau path en enlevant le dernier
				Object[] np = new Object[p.length-1];
				for (int i = 0; i < np.length ; i++)
				{
					np[i] = p[i];
				}
				TreePath perepath = new TreePath(np);
				// on touche au p�re, le fr�re sera donc pr�sent� ferm�
				Object fr�re;
				if ( nouveau != null)
				{
					fr�re = n.getChild(1 - n.getIndexOfChild(nouveau));
				}
				else
				{// on r�cup�re l'ancienne valeur
					fr�re = n.getChild(1 - n.getIndexOfChild(x));
				}
				
				if (fr�re instanceof Noeud)
				{
					((Noeud)fr�re).setOuvert(false); // fr�re ferm�
				}
				//pr�venons tout le monde des modifications
				fireTreeStructureChanged(this,perepath);
			}
		}
		
	}
	// on donne un fils et on veut conna�tre son index
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
		fireTreeNodeChanged(tee.getSource(),tee.getPath().getPath(),null,new Object[]{tee.getPath().getLastPathComponent()});
		// le premier getPath donne un TreePath, le deuxi�me un tableau de noeuds
		// param 3 est le tableau des noeuds � enlever ( ici aucun )
		// param 4 est la liste des noeuds � modifier, ajouter ou enlever
	}
	
	// m�thode pour pr�venir tous les �couteurs de l'arbre que ses donn�es ont chang�
	synchronized private void fireTreeNodeChanged(Object source, Object[] path, int[] ci,Object [] cc)
	{
		if (ecouteurs != null)
		{
			for (int i = 0; i<ecouteurs.size();i++)
				// il y a par defaut 2 �couteurs JTree et BasicUI
			{
				TreeModelEvent tme = new TreeModelEvent(source,path,ci,cc);
				((TreeModelListener)ecouteurs.elementAt(i)).treeNodesChanged(tme);
			}
			
		}
	}
	// m�thode pour pr�venir tous les �couteurs de l'arbre que ses donn�es ont chang�
	synchronized private void fireTreeStructureChanged(Object source, TreePath path)
	{
		if (ecouteurs != null)
		{
			for (int i = 0; i<ecouteurs.size();i++)
				// il y a par defaut 2 �couteurs JTree et BasicUI
			{
				TreeModelEvent tme = new TreeModelEvent(source,path);
				((TreeModelListener)ecouteurs.elementAt(i)).treeStructureChanged(tme);
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
	// recup�re l'�quivalent en chaine de l'expression
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