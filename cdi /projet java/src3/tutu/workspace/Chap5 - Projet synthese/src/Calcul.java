// Class Calcul
// Procédures et fonctions nécessaires à la réalisation d'une calculette. 

// public static int saisirOpérande(int positionOp)
		// public static int saisirOpérande(int positionOp) : saisit une opérande tapée au clavier, ce jusqu'à validité, et retrourne ce nombre.
		// L'interface utilisateur dépend de l'entrée, 1 pour première opérande, 2 pour seconde opérande.
		// Entrée positionOp : première ou seconde opérande. Seule les valeurs 1 ou 2 sont valides !
		// Renvoie la valeur de l'opérande valide.

//public static char saisirOperateur()
		// public static char saisirOperateur() : saisit un opérateur tapé au clavier, ce jusqu'à validité, et retrourne ce caractère.
		// Renvoie un des opérateurs autorisés.

//public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// cette fonction prend deux opérandes et un opérateur, effectue l'opération et renvoie si l'opération
		// est possible ou non (vrai ou faux), et met à jour l'entier résultat.
		// op1 : première opérande
		// op2 : seconde opérande
		// operateur : un des quatre opérateurs autorisés.
		// resultat : l'entier résultat du calcul, mis à jour.

//public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// Cette fonction affiche une opération, son résultat et la faisabilité de l'opération
		// op1 : opérande 1
		// op2 : opérande 2
		// operateur : un des quatre opérateurs autorisés
		// resultat : le résultat de l'opération, un entier
		// possible : vrai si l'opération est possible, faux sinon (cas division par 0)





public class Calcul
{

	private static final int MAX = 1000;


	public static int saisirOpérande(int positionOp){
		// public static int saisirOpérande(int positionOp) : saisit une opérande tapée au clavier, ce jusqu'à validité, et retrourne ce nombre.
		// L'interface utilisateur dépend de l'entrée, 1 pour première opérande, 2 pour seconde opérande.
		// Entrée positionOp : première ou seconde opérande. Seule les valeurs 1 ou 2 sont valides !
		// Renvoie la valeur de l'opérande valide.
		
		
		int operande ;		// Variable de stockage de l'opérande.
		
		do
		{
			
			// Lecture et controle du nombre
			switch (positionOp)
			{
				case 1 :
				{
					System.out.print ("Tapez votre première opérande compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
					break ;
				}
				
				case 2 :
				{
					System.out.print ("Tapez votre seconde opérande compris dans l'intervalle [" + -MAX + " , " + MAX + " ] : ");
					break ;
				}
				
				default :
				{
					System.out.print ("Erreur de 'Calcul.saisirOpérande(int X)' : l'argument n'est pas valable !");
				}
			}
			
			operande = Lire.i();
			System.out.println ("");
			
			if(operande < -MAX || operande > MAX)		// Nombre donné hors des bornes acceptées : erreur
				{
					operande = 0;		//on fixe le nombre à 0 d'office
					System.out.print ("Erreur, votre nombre n'est pas compris dans l'intervalle [" + -MAX + " , " + MAX + " ]");
					System.out.println ("");
				}
		
			return operande ;
			
		} while (operande < -MAX || operande > MAX) ;
		
	}
	
	
	
	public static char saisirOperateur()
	{
		// public static char saisirOperateur() : saisit un opérateur tapé au clavier, ce jusqu'à validité, et retrourne ce caractère.
		// Renvoie un des opérateurs autorisés.
		
		char operateur;
		
		// Lecture de l'opérateur jusqu'à validité
		do
		{
				System.out.print ("Tapez votre opérateur [+, -, *, /] : ");
				operateur = Lire.c();
				System.out.println ("");
		} while (operateur != '+' && operateur != '-' && operateur != '/' && operateur != '*');		// condition d'arrêt : l'opérateur tapé est l'un des quatre attendus
			
		return operateur ;
	}
	
	
	
	public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
	{
		// public static boolean effectuerCalcul (int op1, int op2, char operateur, Entier resultat)
		// cette fonction prend deux opérandes et un opérateur, effectue l'opération et renvoie si l'opération
		// est possible ou non (vrai ou faux), et met à jour l'entier résultat.
		// op1 : première opérande
		// op2 : seconde opérande
		// operateur : un des quatre opérateurs autorisés.
		// resultat : l'entier résultat du calcul, mis à jour.
		
		
		boolean possible = true ;
		
		// On effectue l'opération demandée
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
				
						default :		// aucun des opérateurs valides n'a été trouvé, normalement impossible
							System.out.println ("Erreur, le contrôle de l'opérateur a échoué, le programme est disfonctionnnel");
							System.out.println ("");
							resultat.setVal(0);
							possible = false ;
							
			}
		
		
		return possible ;
	}
	
	
	public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
	{
		// public static void afficher (int op1, int op2, char operateur, Entier resultat, boolean possible)
		// Cette fonction affiche une opération, son résultat et la faisabilité de l'opération
		// op1 : opérande 1
		// op2 : opérande 2
		// operateur : un des quatre opérateurs autorisés
		// resultat : le résultat de l'opération, un entier
		// possible : vrai si l'opération est possible, faux sinon (cas division par 0)
		
		System.out.println ();
		System.out.print ("L'opération " + op1 + " " + operateur + " " + op2 + " est ");
		if (possible)
		{
			System.out.println ("réalisable.");
		}
		else
		{
			System.out.println ("impossible (division par 0).");
		}
		
		System.out.println ("\t\t -->  " +op1 + " " + operateur + " " + op2 + " = " + resultat.getVal());
		
	}
	
}
