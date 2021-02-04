package exercice;

public class PGCalcul
{

	public static void main(String[] args)
	{
		int op1;
		int op2;
		char op;
		boolean reussite;
		Entier resultat = new Entier();
		
		
		do
		{
			op1 = TestCalculette.saisirOperande("premier");
			op = TestCalculette.saisirOperateur();
			op2 = TestCalculette.saisirOperande("deuxième");
			reussite = TestCalculette.calculer(op1, op, op2, resultat);
			TestCalculette.afficher(reussite, resultat.getVal());
			
		} while (Dialogue.veutContinuer());
	}

}
