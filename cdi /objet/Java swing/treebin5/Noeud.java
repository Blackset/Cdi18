


public class Noeud 
{
	// un arbre est un op�rateur avec deux enfants ( un arbre ou un Entier )
	// attention il ne faut pas avoir comme enfant 2 fois le m�me objet;
	// il n'est affich� alors qu'un des objets. ( par exemple new Integer(1) et
	// new Integer(1) sont ici les m�mes objets ( c'est Integer qui est g�r� comme �a!! )
	// d'o� l'int�r�t d'utiliser plut�t un Entier ( new Entier(1) et
	// new Entier(1) ne sont pas les m�mes objets! )
	public static final String MUL = "*";
	public static final String DIV = "/";
	public static final String ADD = "+";
	public static final String SUB = "-";
	String operateur; // un noeud est un op�rateur avec ses op�randes
	// donc une valeur seule sera val + 0 � la racine
	Object[] enfant = new Object[2]; // arbre binaire donc 2 enfants
	boolean ouvert = false; // � vrai quand l'arborescence est d�velopp�e
	public Noeud()
	{
		this(ADD);
	}
	public Noeud(String s)
	{
		operateur = s;
	}
	// m�thode de cr�ation d'un enfant ( qui est soit un Integer ou une sous expression )
	public void setChild(int index, Object fils) throws IllegalArgumentException
	{
		switch (index)
		{
		case 0 :
		case 1 :
			enfant[index] = buildChild(fils);
			break;
		default:
			throw new IllegalArgumentException("arbre binaire, index = " + index +" doit valoir 0 ou 1");
		}
		
	}
	// m�thode de r�cup�ration d'un enfant ( qui est soit un Integer ou une sous expression )
	public Object getChild(int index) throws IllegalArgumentException
	{
		switch (index)
		{
		case 0 :
		case 1 :
			return enfant[index] ;
		default:
			throw new IllegalArgumentException("arbre binaire, index = " + index +" doit valoir 0 ou 1");
		}
		
	}
	// m�thode de r�cup�ration du num�ro de l'enfant dans la fratrie
	public int getIndexOfChild(Object fils)
	{
		if (fils == enfant[0])
		{
			return 0;
		}
		else
		{
			if (fils == enfant[1])
			{
				return 1;
			}
			else
			{
				return -1;
			}
			
		}
	}
	// retourne le nombre d'enfants du noeud
	public int getChildCount()
	{
		int cpt = 0;
		for ( int i = 0; i < 2;i++)
		{
			if (enfant[i] != null)
			{
				cpt++;
			}
		}
		return cpt;
	}
	// ici on transforme l'objet en un objet compatible avec ce qu'on peut
	// mettre dans un arbre ( Integer ou Noeud
	private Object buildChild(Object o)
	{
		if ( o instanceof Entier || o instanceof Noeud)
		{
			return o;
		}
		if (o instanceof String)
		{
			String op = null;
			op = ((String)o).trim(); // chaine �pur�e des espaces et caract�res de contr�le
			if (op.equals(ADD)) {return new Noeud(ADD);}
			else if (op.equals(MUL)) {return new Noeud(MUL);}
			else if (op.equals(DIV)) {return new Noeud(DIV);}
			else if (op.equals(SUB)) {return new Noeud(SUB);}
			else
			{
				// chaine non valide, on construit un Integer(0) et on pr�vient
				System.out.println(" enfant non valide " + o);
				return new Entier(0);
			}
		}
		else
		{
			// objet non valide, on construit un Integer(0) et on pr�vient
			System.out.println(" enfant non valide " + o);
			return new Entier(0);
		}
		
	}
	// m�thode toString, qui permet d'afficher diff�remment quand l'arborescence est ouverte ou non
	public String toString()
	{
		if ( ouvert )
		{
			return operateur;
		}
		else
		{
			StringBuffer buf = new StringBuffer(80);
			buildExprString(buf,this);
			return buf.toString();
		}
	}
	// m�thode buildExprString construit la sous expression correspondant au sous arbre non d�velopp�
	private void buildExprString(StringBuffer buf, Object n)
	{
		if (n == null) return;
		if (n instanceof Noeud)
		{
			buf.append("(");
			buildExprString(buf,((Noeud)n).getChild(0));
			buf.append(" ");
			buf.append(((Noeud)n).operateur);
			buf.append(" ");
			buildExprString(buf,((Noeud)n).getChild(1));
			buf.append(")");
			
		}
		else
		{
			buf.append(n); // le toString sera appele
		}
	}
}
