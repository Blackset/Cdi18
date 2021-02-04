package exercice;

public class Jeunesse {
	
	public static int NBGENS= 20;
	public static int Limit= 20;
	public static void main(String[] argument){
		
		int nbgensint = 0;
		int nbdejeunes = 0;
		int age;
		for (nbgensint= 0;nbgensint<NBGENS-1; nbgensint=nbgensint+1){
			System.out.print("Entrez votre age svp:");
			age=Lire.i();
			if (age < Limit){
				nbdejeunes=nbdejeunes+ 1;
			}
		}
		System.out.print("le nombre de jeunes sur cet échantillon de "+NBGENS+" personne est de: "+nbdejeunes);
		
		
		
		
	}

}
