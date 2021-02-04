 /* Classe      : Max
 Auteur      : Halim, revu par Lécu Régis
 Mise à jour : 20 Octobre 2015
 Fonction    : ce programme permet de dénombrer toutes les personnesd'age inferieur strictement à 20 ans, les personnes d'age strictement sup à 40 et 
               les personnes qui ont age compris entre 20 et 40 parmi un échantillonde 20 personnes, on arrete dés la saisie d'un centenaire X */



    

  public class Max5
  
{
	public static final int LIMITESJEUNE = 20; // nombre de personnes à interroger
	public static final int LIMITESVIEUX = 40;
	public static final int LIMITESCENT = 100;
	
	public static void main(String[] argument)
	
	{
		int age;
		int nbJeune;
		int nbMoyen;
		int nbVieux;
		
		
		nbJeune = 0;
		nbMoyen = 0;
		nbVieux = 0;
	do 
	{
		  System.out.print("Donnez vote age:" );
		  age = Lire.i();
		
		
		if ( age <= LIMITESJEUNE)
		{
			 nbJeune = nbJeune + 1;
		}
		
		else if ( age >= LIMITESVIEUX)
		{
			nbVieux = nbVieux + 1;
		}
		else
		{
		nbMoyen = nbMoyen + 1; 
		}
		
	
		
		} while (age < LIMITESCENT );
		
		
	System.out.println(" le nombre de jeune est:" + nbJeune);
	System.out.println(" le nombre de Moyen est:" + nbMoyen);
	System.out.println(" le nombre de Vieux est:" + nbVieux);
	
	
	
	
	
	}
}