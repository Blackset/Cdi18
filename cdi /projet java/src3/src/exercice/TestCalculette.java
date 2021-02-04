package exercice;

public class TestCalculette
{
	public static int MAX=1000;																				//Definition constante necessaire a saiseOperateur
	public static int saisirOperande( String ordre)
	{	
		int operande;
			
		do
		{
			System.out.println("Saisir votre "+ordre+" operande:");											//saisie d'un operande valide
			operande = Lire.i();
		} while ((operande<= -MAX)&&(operande >=MAX) );														//condition de sortie 
		return operande;
	}
	public static char MOINS = '-',PLUS = '+',DIVISE = '/',MULTIPLIE = '*';								    // Defintion des contstantes necessaire a saiseOperateur
	public static char saisirOperateur()
	{
		char operateur;
		do
		{
			System.out.println("Saisir votre operateur");												   //saisie d'un operateur valide
			operateur = Lire.c();
		} while (operateur != MOINS && operateur != PLUS && operateur != DIVISE && operateur != MULTIPLIE);//condition de sortie
		return operateur;
	} 
	

	public static boolean calculer(int op1, char operateur, int op2, Entier resultat)
	{
		boolean reussite = true;
		switch (operateur)
		{
		case '-':resultat.setVal(op1 - op2);														// calcul des differentes operations
				break;
		case '+':resultat.setVal(op1 + op2);
				break;
		case '/':if (op2==0){
			    reussite=false;
			}else{
				resultat.setVal(op1 / op2);
		}
				break;
		case '*':resultat.setVal(op1 * op2);
				break;
		default:reussite = false;
				break;
		}
		
		return reussite;
	}

	public static void afficher(boolean reussite, int resultat)
	{
		if(reussite==true){
																											// affichage du resultat
			System.out.println("le resultat est "+resultat);
		}else{
			
			System.out.println("Erreur"); 
		}
		
	}
	
}
