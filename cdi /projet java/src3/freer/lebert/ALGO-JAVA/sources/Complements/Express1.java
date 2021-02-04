/******************************************************************************
 Programme 			Express1.java
 Auteur				Lécu Regis
 Mise à jour		février 2001, maj nov 2003 jcc
 Fonction			démo de récursivité croisée

Ce programme évalue des expressions parenthésées par une méthode récursive.

Exemple d'expressions :	((100+ 900) * 5) + ((( 100*5) /5) + 10)	
						10000 + 1
 
Exemples d'expressions interdites :	( 12 + A ) * 4b
										( 100 )
										- 10000
										10000
										( 12 + 4 )        

Signification des notations utilisées de la grammaire (BNF)
............................................................

		"x"				mot-clé : les mots-clés sont entourés de " "
		x				une suite de caractères
		x y				x et y se suivent et sont collés
		x  ::= y z		x se décompose en  y et z
		[x | y]			x ou y
		{ x }			x est répété autant de fois que l'on veut (éventuellement 0)
		N{ x }M			x est répété au minimum N et au maximum M fois
		[x]				x est optionnel (peut être omis)


Définition de la grammaire des expressions parenthésées :
.........................................................

expression   ::= terme operateur terme
(une expression se décompose en un premier terme , un opérateur
et un deuxième terme : les opérateurs unaires + ou - sont interdits)

operateur    ::= "+" |  "-"  |   "*"  |   "/"
(les opérateurs permis  sont + - * / )

terme        ::= separateur  [  "(" expression ")"   |  terme_simple ] separateur
(un terme est un terme simple (suite de chiffres) ou une expression parenthésée)

separateur   ::=  { " " }
separateur est une suite d'un nombre quelconque d'espaces, voire 0

terme_simple ::= 1{chiffre}
(un terme simple est une suite d'au moins un chiffre

chiffre      ::= "0" |  "1" |  ... etc ...     |  "9"


Le programme qui suit est construit en respectant la grammaire : une fonction par règle
.......................................................................................

On a besoin de la récursivité car une expression contient des termes ; un terme peut 
contenir une expression...

La fonction Expression doit donc appeler Terme, et Terme doit appeler Expression pour 
évaluer les formules parenthésées : la fonction Expression s'appelle donc elle-même 
en passant par un appel à Terme
*/

public class Express1 
{	

	public static void main (String arg[])			
	{
		// notez que l'indice est en entrée sortie des fonctions
		// l'erreur aussi, donc les classes d'habillage sont utilisées
		Booleen erreur = new Booleen();	// vrai si erreur de syntaxe détectée
		int   nbCar;				// nombre de caractères de la formule
		char [] formule;			// formule à calculer
		int valeur ;				// valeur de l'expression parenthésée
		Entier iCour = new Entier();// indice du  caractère à traiter
		
		erreur.setVal(false);		// pas d'erreur au départ
		iCour.setVal(0);			// on part du début
		
		System.out.println("** Calcul d'expression parenthesee **" );
		System.out.println();

		// Saisie de la formule 
		System.out.print("Formule :");
		String s = Lire.S();
		nbCar = s.length();
		formule =  new char [nbCar];
		s.getChars (0, nbCar, formule, 0);
				
		// évaluation de la formule
		valeur = expression (iCour,formule,erreur);
						
		// réaffichage de la formule demandée
		System.out.print (" Votre formule " + formule);
			
		// Formule correcte : analysée jusqu'à la fin sans rencontrer d'erreur de syntaxe
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

	// saute les espaces à partir de la case iCour, jusqu'au premier 
	// caractère différent de espace, ou jusqu'à la fin de la formule 
 
	private static void separateur (Entier iCourant,char [] formu)
	// iCourant est la valeur à partir de laquelle on saute les espaces
	//				en sortie le premier caractère différent d'un espace
	// formu contient l'expression à analyser
	{	
		int nbCar = formu.length ; // nombre de caracteres de la formule
		int i = iCourant.getVal(); // indice courant de la formule
		while ((i < nbCar) && (formu[i] == ' '))
		{ // arrêt quand plus d'espaces, ou fin de phrase
			i++;
		}
		iCourant.setVal(i);
	}	


	//Operateur : vérifie que le caractère courant est + * - ou /

	private static char operateur (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur à partir de laquelle on saute les espaces
	//				en sortie le premier caractère différent d'un espace
	// formu contient l'expression à analyser
	// erreur sera mis à vrai si il y a une erreur
	{
		char op = '?';
		int i = iCourant.getVal();
		if ( i == formu.length  )
		{
			erreur.setVal(true);				// fin d'expression anormale
		}
		
		// vérification de l'opérateur
		else if ((formu[i] == '+') || (formu[i] == '-') ||
				(formu[i] == '*') || (formu[i] == '/') ) 									
		{
			op = formu [i];				
			iCourant.setVal(i+1);
		}
		else
		{
			erreur.setVal(true);				// opérateur inconnu
		}
		return op;
	}	

	//  Expression : une expression se décompose en un premier terme , un opérateur 
	//				 et un deuxième terme 
	//				 (les opérateurs unaires + ou - ne sont pas autorisés)
	private static int expression (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur à partir de laquelle on saute les espaces
	//				en sortie le premier caractère différent d'un espace
	// formu contient l'expression à analyser
	// erreur sera mis à vrai si il y a une erreur
	{
		int valeur  = 0;
		
		int t1 = terme (iCourant,formu,erreur);	// évaluation du premier terme
		if (! erreur.getVal())		// test erreur de syntaxe dans le premier terme
		{
			char op = operateur (iCourant,formu,erreur);
			
			if (!erreur.getVal())
			{
				int t2 = terme (iCourant,formu,erreur);
				if (!erreur.getVal())// test erreur de syntaxe dans le 2ième terme
				{
					valeur = calculer (t1, op, t2,erreur);
									// calcul de l'expression à partir des deux termes
				}
			}
		}
		return valeur;
	}		

	// Terme : terme simple (suite de chiffres) ou expression parenthésée

	// - saute le premier séparateur par Separateur
	// - teste le mot-clé  "("  pour distinguer si le terme est un terme SIMPLE, ou COMPOSÉ	
	// - Si le terme est un terme composé (commençant par "("),
	//     - saute   "("	
	//     - appelle Expression													
	//     - saute ")"	
	// - Sinon
	//    -  appelle TermeSimple					
	//- saute le dernier separateur par Separateur	
	private static int terme (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur à partir de laquelle on saute les espaces
	//				en sortie le premier caractère différent d'un espace
	// formu contient l'expression à analyser
	// erreur sera mis à vrai si il y a une erreur
	{
		int valeur = 0;
		
		if ( iCourant.getVal() == formu.length )
		{
			erreur.setVal(true); // fin rencontrée
		}
		else
		{
			separateur (iCourant,formu);
			if ( iCourant.getVal() == formu.length )
			{
				erreur.setVal(true); // fin rencontrée
			}
			else if (formu[iCourant.getVal()] ==  '(')	
			{
				iCourant.setVal(iCourant.getVal()+1); // incrémente iCourant
				valeur = expression (iCourant,formu,erreur); 
				if (formu[iCourant.getVal()] != ')')
				{
					erreur.setVal(true); // erreur syntaxe
				}
				else
				{
					iCourant.setVal(iCourant.getVal()+1); // incrémente iCourant
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

	//	TermeSimple :  suite de caractères numériques ( '0' à '9' ) 
	// Un terme simple comporte AU MOINS un chiffre, donc la fonction détecte  
	// une erreur si le caractère courant n'est pas un chiffre 
	private static  int termeSimple (Entier iCourant,char [] formu,Booleen erreur)
	// iCourant est la valeur à partir de laquelle on saute les espaces
	//				en sortie le premier caractère différent d'un espace
	// formu contient l'expression à analyser
	// erreur sera mis à vrai si il y a une erreur
	{		
		String s = "";
		int valeur = 0;
		int iCour = iCourant.getVal();
		int nbCar = formu.length ;
		
		while ( (iCour < nbCar) && Character.isDigit(formu[iCour]) )
		// arrêt quand la chaine est finie, ou quand on a plus de chiffre
		{	
			s = s + formu[iCour]; // concaténation pour avoir le nombre
			iCour ++;
		}
		// Si aucun caractère numérique, alors erreur
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
	// effectue l'opération représentée par operateur sur les opérandes 
	// op1 et op2 et retourne le résultat. La seule erreur détectée est la 
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
				if (op2  == 0)			// test de la division par zéro
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