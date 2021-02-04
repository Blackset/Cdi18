/*  Classe      : Calcul du nombre d'occurence
    Auteur      : Yann Capelli	
    Mise � jour : 13 Ocotbre 2016
    Fonction    : Permet de compter le nombre d'occurence de 2 lettre successive
*/
public class occurence
{	
	private static final char CARACSTOP = '.';

	public static void main(String[] argument)
	{
		String phrase;		// Phrase � tester
		int nbOccurence;	// Nombre de caractere cible rencontr�s
		char caracDeb;		// Premier caract�re de l'occurence a tester
		char caracFin;		// Deuxi�me caract�re de l'occurence a tester
		
		System.out.println("Veuillez rentrer la phrase a tester :");
		phrase = Lire.S();
		System.out.println("Rentrer la premiere lettre");
		caracDeb = Lire.c();
		System.out.println("Rentrer la deuxi�me lettre");
		caracFin = Lire.c();
		nbOccurence = nbOccurence(phrase,caracDeb,caracFin,CARACSTOP);
		System.out.println("Le nombre d'occurence dans la phrase est de : "+nbOccurence);
		
	}
	public static int nbOccurence (String phrase,char caracDeb,char caracFin,char caracStop )
	{
		//Procedure qui compte le nombre d'occurence de 2 caract�res dans une chaine
		//Phrase est la chaine a tester et NbOccurence est le nombre de fois qu'apparait 2 caract�res successif
		//CaracDeb est le premier caractere a tester 
		//CaracFin est le deuxi�me caractere � tester
		int nbOccurence=0;
		int i =0;			// Indice de parcours de texte
		while (phrase.charAt(i)!=CARACSTOP) // Controle 1 a 1 des caract�res de la phrase
		{
			if (phrase.charAt(i)==caracDeb && phrase.charAt(i+1)==caracFin && phrase.charAt(i+1)!=CARACSTOP)
			{
				nbOccurence ++;
				i++;
			}
			i++;
		}
		return nbOccurence;
	}
}