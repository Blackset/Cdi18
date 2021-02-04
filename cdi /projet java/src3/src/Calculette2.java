
public class Calculette2 
{
	public static void main ( String [] argument)
	{
		int entier1, entier2;
		char operateur;
		System.out.println("Saisissez votre entier1:");
		entier1 = Lire.i();
		System.out.println("Saisissez votre operateur:");
		operateur = Lire.c();
		System.out.println("Saisissez votre entier2:");
		entier2 = Lire.i();
		
	switch (operateur)
	{
	case '-':System.out.println("le resultat est " +(entier1- entier2));
			break;
	case '+':System.out.println("Le resultat est "+(entier1+ entier2));
			break;
	case '/':System.out.println("Le resultat est "+(entier1/ entier2));
			break;
	case '*':System.out.println("Le resultat est "+(entier1* entier2));
			break;
	default:System.out.println("L'operateur saisie est erroné");
	}
	}

}