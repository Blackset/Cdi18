public class Noeud
{
	public static final String MUL = "*";
	public static final String DIV = "/";
	public static final String ADD = "+";
	public static final String SUB = "-";
	private String operateur; // un noeud est un opérateur avec ses opérandes
	// donc une valeur seule sera val + 0 à la racine
	private Object[] enfant = new Object[2]; // arbre binaire donc 2 enfants
	private boolean ouvert = false; // à vrai quand l'arborescence est développée
	public Noeud()
	{
		this(ADD);
	}
	public Noeud(String s)
	{
		operateur = s;
	}
	// positionne ouvert à vrai si on deploie l'arborescence, à faux sinon
	public void setOuvert(boolean ouvrir)
	{
		ouvert = ouvrir;
	}
	// met à jour l'opérateur du noeud
	public void setOperateur(Object o)
	{
		String newValue = (String) o;
		String op = ((String)newValue).trim();// enlève les vilains caractères
		if (op .equals(Noeud.DIV)) operateur = Noeud.DIV;
		else if (op .equals(Noeud.MUL)) operateur = Noeud.MUL;
		else if (op .equals(Noeud.SUB)) operateur = Noeud.SUB;
		else
		{
			if (!op .equals(Noeud.ADD)) System.out.println("operateur ko, Addition assurée");
			operateur = Noeud.ADD;
		}
		
	}
	public String getOperateur(){
		return operateur;
	}
	public boolean getOuvert()
	{
		return ouvert;
	}
	// méthode de création d'un enfant ( qui est soit un Integer ou une sous expression )
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
	// méthode de récupération d'un enfant ( qui est soit un Integer ou une sous expression )
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
	// méthode de récupération du numéro de l'enfant dans la fratrie
	public int getIndexOfChild(Object fils)
	{
		if (fils.equals(enfant[0]))
		{
			return 0;
		}
		else
		{
			if (fils.equals( enfant[1]))
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
			op = ((String)o).trim(); // chaine épurée des espaces et caractères de contrôle
			if (op.equals(ADD)) {return new Noeud(ADD);}
			else if (op.equals(MUL)) {return new Noeud(MUL);}
			else if (op.equals(DIV)) {return new Noeud(DIV);}
			else if (op.equals(SUB)) {return new Noeud(SUB);}
			else
			{
				// chaine non valide, on construit un Integer(0) et on prévient
				System.out.println(" enfant non valide " + o);
				return new Entier(0);
			}
		}
		else
		{
			// objet non valide, on construit un Integer(0) et on prévient
			System.out.println(" enfant non valide " + o);
			return new Entier(0);
		}
		
	}
	// méthode toString, qui permet d'afficher différemment quand l'arborescence est ouverte ou non
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
	// méthode buildExprString construit la sous expression correspondant au sous arbre non développé
	public void buildExprString(StringBuffer buf, Object n)
	{
		if (n == null) return;
		if (n instanceof Noeud)
		{
			buf.append("(");
			buildExprString(buf,((Noeud)n).getChild(0));
			buf.append(((Noeud)n).operateur);
			buildExprString(buf,((Noeud)n).getChild(1));
			buf.append(")");
			
		}
		else
		{
			buf.append(new String(new Integer(((Entier)n).getVal()).toString())); // le toString sera appele
		}
	}
	public double getVal()
	{
		// évaluation récurssive de l'expression
		Object droit;
		Object gauche;
		double valDroit;
		double valGauche;
		droit = getChild(1);
		gauche = getChild(0);
		if ( gauche instanceof Entier)
		{
			valGauche = ((Entier)gauche).getVal();
		}
		else
		{
			valGauche = ((Noeud)gauche).getVal() ;
		}
		if ( droit instanceof Entier)
		{
			valDroit = ((Entier)droit).getVal();
		}
		else
		{
			valDroit = ((Noeud)droit).getVal() ;
		}
		switch (this.operateur.charAt(0) )
		{
		case '+': return valGauche + valDroit;
		case '-': return valGauche - valDroit;
		case '*': return valGauche * valDroit;
		case '/': if (valDroit != 0.0)
			return valGauche / valDroit;
		else
			return Double.NaN;
		}
		return Double.NaN ;
	}
}
