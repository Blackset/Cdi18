// Class Calcul
// Proc�dures et fonctions n�cessaires � la r�alisation d'une calculette. 

// public static int saisirOp�rande(int positionOp)
		// public static int saisirOp�rande(int positionOp) : saisit une op�rande tap�e au clavier, ce jusqu'� validit�, et retrourne ce nombre.
		// L'interface utilisateur d�pend de l'entr�e, 1 pour premi�re op�rande, 2 pour seconde op�rande.
		// Entr�e positionOp : premi�re ou seconde op�rande. Seule les valeurs 1 ou 2 sont valides !
		// Renvoie la valeur de l'op�rande valide.

//public static char saisirOperateur()
		// public static char saisirOperateur() : saisit un op�rateur tap� au clavier, ce jusqu'� validit�, et retrourne ce caract�re.
		// Renvoie un des op�rateurs autoris�s.

//public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// cette fonction prend deux op�randes et un op�rateur, effectue l'op�ration et renvoie si l'op�ration
		// est possible ou non (vrai ou faux), et met � jour l'entier r�sultat.
		// op1 : premi�re op�rande
		// op2 : seconde op�rande
		// operateur : un des quatre op�rateurs autoris�s.
		// resultat : l'entier r�sultat du calcul, mis � jour.

//public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// Cette fonction affiche une op�ration, son r�sultat et la faisabilit� de l'op�ration
		// op1 : op�rande 1
		// op2 : op�rande 2
		// operateur : un des quatre op�rateurs autoris�s
		// resultat : le r�sultat de l'op�ration, un entier
		// possible : vrai si l'op�ration est possible, faux sinon (cas division par 0)





public class Calcul
{

	private static final int MAX = 1000;


	public static int saisirOp�rande(int positionOp){
		// public static int saisirOp�rande(int positionOp) : saisit une op�rande tap�e au clavier, ce jusqu'� validit�, et retrourne ce nombre.
		// L'interface utilisateur d�pend de l'entr�e, 1 pour premi�re op�rande, 2 pour seconde op�rande.
		// Entr�e positionOp : premi�re ou seconde op�rande. Seule les valeurs 1 ou 2 sont valides !
		// Renvoie la valeur de l'op�rande valide.
		
		
		int operande ;		// Variable de stockage de l'op�rande.
		
		do
		{
			
			// Lecture et controle du nombre
			switch (positionOp)
			{
				case 1 :
				{
					System.out.print ("Tapez votre premi�re op�rande compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
					break ;
				}
				
				case 2 :
				{
					System.out.print ("Tapez votre seconde op�rande compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
					break ;
				}
				
				default :
				{
					System.out.print ("Erreur de 'Calcul.saisirOp�rande(int X)' : l'argument n'est pas valable !");
				}
			}
			
			operande = Lire.i();
			System.out.println ("");
			
			if(operande < -MAX || operande > MAX)		// Nombre donn� hors des bornes accept�es : erreur
				{
					operande = 0;		//on fixe le nombre � 0 d'office
					System.out.print ("Erreur, votre nombre n'est pas compris dans l'intervalle [" + -MAX + " , " + MAX + " ]");
					System.out.println ("");
				}
		
			return operande ;
			
		} while (operande < -MAX || operande > MAX) ;
		
	}
	
	
	
	public static char saisirOperateur()
	{
		// public static char saisirOperateur() : saisit un op�rateur tap� au clavier, ce jusqu'� validit�, et retrourne ce caract�re.
		// Renvoie un des op�rateurs autoris�s.
		
		char operateur;
		
		// Lecture de l'op�rateur jusqu'� validit�
		do
		{
				System.out.print ("Tapez votre op�rateur [+, -, *, /] : ");
				operateur = Lire.c();
				System.out.println ("");
		} while (operateur != '+' && operateur != '-' && operateur != '/' && operateur != '*');		// condition d'arr�t : l'op�rateur tap� est l'un des quatre attendus
			
		return operateur ;
	}
	
	
	
	public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
	{
		// public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// cette fonction prend deux op�randes et un op�rateur, effectue l'op�ration et renvoie si l'op�ration
		// est possible ou non (vrai ou faux), et met � jour l'entier r�sultat.
		// op1 : premi�re op�rande
		// op2 : seconde op�rande
		// operateur : un des quatre op�rateurs autoris�s.
		// resultat : l'entier r�sultat du calcul, mis � jour.
		
		
		boolean possible = true ;
		
		// On effectue l'op�ration demand�e
		switch (operateur)
			{
				case '+' : 
					resultat.setVal(op1 + op2) ;
					break;
			
				case '-' :
					resultat.setVal(op1 - op2) ;
					break;
						
				case '*' :
					resultat.setVal(op1 * op2) ;
					break;
						
				case '/' :
					if (op2 == 0)		// Test de la division par 0
							{
								possible = false ;
								resultat.setVal(0);
							}
							else
								resultat.setVal(op1 / op2) ;		// la division est valide
							break;
				
						default :		// aucun des op�rateurs valides n'a �t� trouv�, normalement impossible
							System.out.println ("Erreur, le contr�le de l'op�rateur a �chou�, le programme est disfonctionnnel");
							System.out.println ("");
							resultat.setVal(0);
							possible = false ;
							
			}
		
		
		return possible ;
	}
	
	
	public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
	{
		// public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// Cette fonction affiche une op�ration, son r�sultat et la faisabilit� de l'op�ration
		// op1 : op�rande 1
		// op2 : op�rande 2
		// operateur : un des quatre op�rateurs autoris�s
		// resultat : le r�sultat de l'op�ration, un entier
		// possible : vrai si l'op�ration est possible, faux sinon (cas division par 0)
		
		System.out.println ();
		System.out.print ("L'op�ration " + op1 + " " + operateur + " " + op2 + " est ");
		if (possible)
		{
			System.out.println ("r�alisable.");
		}
		else
		{
			System.out.println ("impossible (division par 0).");
		}
		
		System.out.println ("\t\t -->  " +op1 + " " + operateur + " " + op2 + " = " + resultat.getVal());
		
	}
	
}
