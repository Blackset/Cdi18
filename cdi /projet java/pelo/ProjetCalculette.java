/*  Classe      : Calculette
    Auteur      : Yann Capelli	
    Mise à jour : 12 Ocotbre 2016
    Fonction    : Calculatrice
*/
public class ProjetCalculette
{
	private static final int MAX = 1000;

	public static void main(String[] argument)
	{
		do
		{
			Entier resultat = new Entier();
			int op1;
			int op2;
			char operateur;
			boolean reussite;
			op1 = saisieOperande("premier");
			operateur = saisieOperateur();
			op2 = saisieOperande("deuxieme");
			reussite = effectuerCalcul(op1, op2, operateur, resultat);
			afficher(resultat.getVal(),reussite);			
		} while (Dialogue.veutContinuer());
	}
	
	public static int saisieOperande (String texte)
	{
		// Fonction qui permet la saisie d'operande valide (-1000 à 1000)
		// texte permet de savoir si c'est le premier ou le 2e a saisir
		// Retourne un entier saisie au claver
		int operande;
		boolean saisieOperande;
		do
		{
			System.out.println("Saisir un "+texte+" opérande valide (-1000 à 1000) :");
			operande = Lire.i();
			if ((operande>=-MAX) && (operande<=MAX))
			{
				saisieOperande=true;				
			}
			else
			{
				System.out.println("ERREUR : Entrer une valeur comprise entre -1000 et 1000 ");
				saisieOperande=false;
			}
		}
		while (saisieOperande==false);
		return operande;		
	}
	
	public static char saisieOperateur ()
	{
		// Fonction qui permet la saisie d'un opérateur valide (+,-,*,/)
		// Retourne un caractere saisie au clavier
		char operateur;	// Operateur 
		boolean saisieOperateur=false; // Booléen pour la verification de la saisie
		do
		{
			System.out.println("Entrez l'operateur souhaité (+,-,*,/) : ");
			operateur = Lire.c();
			// Verifie si l'operateur est bien un de ceux attendu
			if ((operateur=='+')||(operateur=='-')||(operateur=='*')||(operateur=='/'))
			{
				saisieOperateur=true;				
			}
			else
			{
				System.out.println("ERREUR : Entrez operateur valide (+,-,*,/) ");
				saisieOperateur=false;
			}
		}
		while (saisieOperateur==false);
		return operateur;
		
	}
	public static boolean effectuerCalcul (int operande1, int operande2, char operateur, Entier resultat)
	{
		// Fonction qui verifie si le calcul est possible (division par 0) et effectue le calcul
		// operande1 et operande2 sont les 2 valeur que l'ont veut utiliser pour le calcul
		// operateur represente l'operation a éffectuer
		// resultat est le resultat du calcul si il est possible
		// Retourne vrai si le calcul est possible et faux si division par 0
		boolean opValid;
		switch (operateur)
		{
				case '+' : resultat.setVal(operande1 + operande2);
							opValid = true;
							break;
				case '-' : resultat.setVal(operande1-operande2);
							opValid = true;
							break;
				case '*' : resultat.setVal(operande1 * operande2);
							opValid = true;
							break;
				case '/' : if (operande2==0)       // Verifie si on ne divise pas par 0
							{								
								opValid = false;
							}
							else
							{
								resultat.setVal(operande1 / operande2);
								opValid = true;
							}
							break;
				default : opValid = false; 
		}
		return opValid;
		
	}
	
	public static void afficher (int resultat, boolean reussite)
	{
		// Fonction qui affiche le resultat si le calcul a pu être éffectué 
		// ou non dans ce cas affiche un message d'erreur
		// resultat est le resultat du calcul
		// reussite nous permet de savoir si le calcul est valide ou non
		if (reussite)
		{
			System.out.println("Le résultat est :"+resultat);
		}
		else
		{
			System.out.println("ERREUR : Division par 0 impossible ");
		}
	}

		

}