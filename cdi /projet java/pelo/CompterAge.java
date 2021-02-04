/*  Classe      : CompterAge
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : Denombre les personnes agées de moins de 20 ans, moins de 40 ans et plus de 40 ans
    le comptage s'arrete a la saisie d'un centenaire
*/
public class CompterAge
{

	private static final int AGEJEUNE = 20; // Age limite des jeunes
	private static final int AGEMOYEN = 40;	// Age limite des moyens
	private static final int AGESTOP = 100;	// Age qui signal l'arret

	public static void main(String[] argument)
	{

		int nbMoyens=0; 			// Nombre de moyens
		int nbJeunes=0; 			// Nombre de jeunes	
		int nbVieux=0; 				// Nombre de vieux	
		int age;					// Age de la personne interrogée
		
		// Affichage de la version
		System.out.println("****CompterAge (V1.0, 11/10/16)****");
		//Interroge une personne tant qu'un centenaire n'est pas saisie
		do
		{
			System.out.println("Donnez votre age :");
			age = Lire.i();
			if (age<AGEJEUNE)				// Comparaison des ages
			{
				nbJeunes++;
			}
			else if (age<AGEMOYEN)
			{
				nbMoyens++;
			}
			else
			{
				nbVieux++;
			}				
		}
		while(age<=AGESTOP);
				
		
		System.out.println("Le nombre de jeunes est : "+nbJeunes);
		System.out.println("Le nombre de moyens est : "+nbMoyens);
		System.out.println("Le nombre de vieux est : "+nbVieux);
		
	}

}