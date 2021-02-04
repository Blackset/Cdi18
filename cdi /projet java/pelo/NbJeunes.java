/*  Classe      : NbJeunes
    Auteur      : Yann Capelli	
    Mise à jour : 11 Ocotbre 2016
    Fonction    : Denombre les personnes agées de moins de 20 ans parmis 20 personnes
*/
public class NbJeunes
{

	private static final int MAX = 20;
	private static final int AGEJEUNES = 20;

	public static void main(String[] argument)
	{

		int nbInterroge=0; 			// Nombre de personne intérrogées
		int nbJeunes=0; 			// Nombre de jeunes	
		int age;					// Age de la personne interrogée
		
		// Affichage de la version
		System.out.println("****NbJeunes (V1.0, 11/10/16)****");		
		while (nbInterroge< MAX )
		{
			System.out.println("Donnez votre age :");
			age = Lire.i();
			if (age <AGEJEUNES)
			{
				nbJeunes++;
			}
			nbInterroge++;
		}
		System.out.println("Le nombre de jeunes est :"+nbJeunes);
		
	}

}