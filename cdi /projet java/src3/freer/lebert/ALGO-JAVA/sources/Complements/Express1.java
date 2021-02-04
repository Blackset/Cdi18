/******************************************************************************
 Programme 			Express1.java
 Auteur				L�cu Regis
 Mise � jour		f�vrier 2001, maj nov 2003 jcc
 Fonction			d�mo de r�cursivit� crois�e

Ce programme �value des expressions parenth�s�es par une m�thode r�cursive.

Exemple d'expressions :	((100+ 900) * 5) + ((( 100*5) /5) + 10)	
						10000 + 1
 
Exemples d'expressions interdites :	( 12 + A ) * 4b
										( 100 )
										- 10000
										10000
										( 12 + 4 )        

Signification des notations utilis�es de la grammaire (BNF)
............................................................

		"x"				mot-cl� : les mots-cl�s sont entour�s de " "
		x				une suite de caract�res
		x y				x et y se suivent et sont coll�s
		x  ::= y z		x se d�compose en  y et z
		[x | y]			x ou y
		{ x }			x est r�p�t� autant de fois que l'on veut (�ventuellement 0)
		N{ x }M			x est r�p�t� au minimum N et au maximum M fois
		[x]				x est optionnel (peut �tre omis)


D�finition de la grammaire des expressions parenth�s�es :
.........................................................

expression   ::= terme operateur terme
(une expression se d�compose en un premier terme , un op�rateur
et un deuxi�me terme : les op�rateurs unaires + ou - sont interdits)

operateur    ::= "+" |  "-"  |   "*"  |   "/"
(les op�rateurs permis  sont + - * / )

terme        ::= separateur  [  "(" expression ")"   |  terme_simple ] separateur
(un terme est un terme simple (suite de chiffres) ou une expression parenth�s�e)

separateur   ::=  { " " }
separateur est une suite d'un nombre quelconque d'espaces, voire 0

terme_simple ::= 1{chiffre}
(un terme simple est une suite d'au moins un chiffre

chiffre      ::= "0" |  "1" |  ... etc ...     |  "9"


Le programme qui suit est construit en respectant la grammaire : une fonction par r�gle
.......................................................................................

On a besoin de la r�cursivit� car une expression contient des termes ; un terme peut 
contenir une expression...

La fonction Expression doit donc appeler Terme, et Terme doit appeler Expression pour 
�valuer les formules parenth�s�es : la fonction Expression s'appelle donc elle-m�me 
en passant par un appel � Terme
*/

public class Express1 
{	

	public static void main (String arg[])			
	{
		// notez que l'indice est en entr�e sortie des fonctions
		// l'erreur aussi, donc les classes d'habillage sont utilis�es
		Booleen erreur = new Booleen();	// vrai si erreur de syntaxe d�tect�e
		int   nbCar;				// nombre de caract�res de la formule
		char [] formule;			// formule � calculer
		int valeur ;				// valeur de l'expression parenth�s�e
		Entier iCour = new Entier();// indice du  caract�re � traiter
		
		erreur.setVal(false);		// pas d'erreur au d�part
		iCour.setVal(0);			// on part du d�but
		
		System.out.println("** Calcul d'expression parenthesee **" );
		System.out.println();

		// Saisie de la formule 
		System.out.print("Formule :");
		String s = Lire.S();
		nbCar = s.length();
		formule =  new char [nbCar];
		s.getChars (0, nbCar, formule, 0);
				
		// �valuation de la formule
		valeur = expression (iCour,formule,erreur);
						
		// r�affichage de la formule demand�e
		System.out.print (" Votre formule " + formule);
			
		// Formule correcte : analys�e jusqu'� la fin sans rencontrer d'erreur de syntaxe
		if ( iCour.getVal() == nbCar && !erreur.getVal())
		{
			System.out.println(" vaut  " + valeur );
		}
		else
		{
			System.out.println("  est erronee ! ");
		}
		Lire.Attente ();
	}
	
	// Separateur : suite d'un nombre quelconque d'espaces (y compris 0)

	// saute les espaces � partir de la case iCour, jusqu'au premier 
	// caract�re diff�rent de espace, ou jusqu'� la fin de la formule 
 
	private static void separateur (Entier iCourant,char [] formu)
	// iCourant est la valeur � partir de laquelle on saute les espaces
	//				en sortie le premier caract�re diff�rent d'un espace
	// formu contient l'expression � analyser
	{	
		int nbCar = formu.length ; // nombre de caracteres de la formule
		int i = iCourant.getVal(); // indice courant de la formule
		while ((i < nbCar) && (formu[i] == ' '))
		{ // arr�t quand plus d'espaces, ou fin de phrase
			i++;
		}
		iCourant.setVal(i);
	}	


	//Operateur : v�rifie que le caract�re courant est + * - ou /

	private static char operateur (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur � partir de laquelle on saute les espaces
	//				en sortie le premier caract�re diff�rent d'un espace
	// formu contient l'expression � analyser
	// erreur sera mis � vrai si il y a une erreur
	{
		char op = '?';
		int i = iCourant.getVal();
		if ( i == formu.length  )
		{
			erreur.setVal(true);				// fin d'expression anormale
		}
		
		// v�rification de l'op�rateur
		else if ((formu[i] == '+') || (formu[i] == '-') ||
				(formu[i] == '*') || (formu[i] == '/') ) 									
		{
			op = formu [i];				
			iCourant.setVal(i+1);
		}
		else
		{
			erreur.setVal(true);				// op�rateur inconnu
		}
		return op;
	}	

	//  Expression : une expression se d�compose en un premier terme , un op�rateur 
	//				 et un deuxi�me terme 
	//				 (les op�rateurs unaires + ou - ne sont pas autoris�s)
	private static int expression (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur � partir de laquelle on saute les espaces
	//				en sortie le premier caract�re diff�rent d'un espace
	// formu contient l'expression � analyser
	// erreur sera mis � vrai si il y a une erreur
	{
		int valeur  = 0;
		
		int t1 = terme (iCourant,formu,erreur);	// �valuation du premier terme
		if (! erreur.getVal())		// test erreur de syntaxe dans le premier terme
		{
			char op = operateur (iCourant,formu,erreur);
			
			if (!erreur.getVal())
			{
				int t2 = terme (iCourant,formu,erreur);
				if (!erreur.getVal())// test erreur de syntaxe dans le 2i�me terme
				{
					valeur = calculer (t1, op, t2,erreur);
									// calcul de l'expression � partir des deux termes
				}
			}
		}
		return valeur;
	}		

	// Terme : terme simple (suite de chiffres) ou expression parenth�s�e

	// - saute le premier s�parateur par Separateur
	// - teste le mot-cl�  "("  pour distinguer si le terme est un terme SIMPLE, ou COMPOS�	
	// - Si le terme est un terme compos� (commen�ant par "("),
	//     - saute   "("	
	//     - appelle Expression													
	//     - saute ")"	
	// - Sinon
	//    -  appelle TermeSimple					
	//- saute le dernier separateur par Separateur	
	private static int terme (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur � partir de laquelle on saute les espaces
	//				en sortie le premier caract�re diff�rent d'un espace
	// formu contient l'expression � analyser
	// erreur sera mis � vrai si il y a une erreur
	{
		int valeur = 0;
		
		if ( iCourant.getVal() == formu.length )
		{
			erreur.setVal(true); // fin rencontr�e
		}
		else
		{
			separateur (iCourant,formu);
			if ( iCourant.getVal() == formu.length )
			{
				erreur.setVal(true); // fin rencontr�e
			}
			else if (formu[iCourant.getVal()] ==  '(')	
			{
				iCourant.setVal(iCourant.getVal()+1); // incr�mente iCourant
				valeur = expression (iCourant,formu,erreur); 
				if (formu[iCourant.getVal()] != ')')
				{
					erreur.setVal(true); // erreur syntaxe
				}
				else
				{
					iCourant.setVal(iCourant.getVal()+1); // incr�mente iCourant
				}
			}
			else
			{
				valeur = termeSimple (iCourant,formu,erreur);
			}
			separateur (iCourant,formu);
		}
	
		return valeur;
	}		

	//	TermeSimple :  suite de caract�res num�riques ( '0' � '9' ) 
	// Un terme simple comporte AU MOINS un chiffre, donc la fonction d�tecte  
	// une erreur si le caract�re courant n'est pas un chiffre 
	private static  int termeSimple (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur � partir de laquelle on saute les espaces
	//				en sortie le premier caract�re diff�rent d'un espace
	// formu contient l'expression � analyser
	// erreur sera mis � vrai si il y a une erreur
	{		
		String s = "";
		int valeur = 0;
		int iCour = iCourant.getVal();
		int nbCar = formu.length ;
		
		while ( (iCour < nbCar) && Character.isDigit(formu[iCour]) )
		// arr�t quand la chaine est finie, ou quand on a plus de chiffre
		{	
			s = s + formu[iCour]; // concat�nation pour avoir le nombre
			iCour ++;
		}
		// Si aucun caract�re num�rique, alors erreur
		if (s.length() == 0)
		{
			erreur.setVal( true ); // erreur syntaxe
		}
		else
		{
			valeur = Integer.parseInt (s); // convertion chaine en entier
		}
		iCourant.setVal(iCour);
		return valeur;
	}

	// EffectuerCalcul : 
	// effectue l'op�ration repr�sent�e par operateur sur les op�randes 
	// op1 et op2 et retourne le r�sultat. La seule erreur d�tect�e est la 
	// division par 0 
	private static int calculer(int op1,char operateur,int op2,Booleen erreur) 
	{
		int valeur = 0;
		
		switch (operateur)
		{
			case '+' :
				valeur = op1 + op2;
				break;
			
			case '*' :
				valeur = op1 * op2;
				break;
			
			case '-' :
				valeur = op1 - op2;
				break;
			
			case '/' :
				if (op2  == 0)			// test de la division par z�ro
				{ 
					erreur.setVal(true);		// calcul impossible !!
				}
				else
				{
					valeur = op1 / op2;
				}
				break;
		}
		return valeur;
	}		
 }