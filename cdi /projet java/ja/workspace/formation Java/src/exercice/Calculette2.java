package exercice;


public class Calculette2 
{
	public static int calculer()
	{
		int entier1, entier2;
		char operateur;
		System.out.println("Saisissez votre entier1:");
		entier1 = Lire.i();
		System.out.println("Saisissez votre operateur:");
		operateur = Lire.c();
		System.out.println("Saisissez votre entier2:");
		entier2 = Lire.i();
		
		int resultat=0;
		
	switch (operateur)
	{
	case '-':resultat = entier1- entier2;
			break;
	case '+':resultat = entier1+ entier2;
			break;
	case '/': resultat = entier1/ entier2;
			break;
	case '*':resultat = entier1* entier2;
			break;
	default:System.out.println("L'operateur saisie est erroné");
	}
	
	return resultat;
	
}

	public static void saisirOperande()
	{
		// TODO Auto-generated method stub
		
	}

	public static void saisirOperateur()
	{
		// TODO Auto-generated method stub
		
	}

}