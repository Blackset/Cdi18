/*  Classe      : Calcul du nombre d'occurence
    Auteur      : Yann Capelli	
    Mise à jour : 13 Ocotbre 2016
    Fonction    : Permet de compter le nombre d'occurence de 2 lettre successive
*/
public class occurence
{	
	private static final char CARACSTOP = '.';

	public static void main(String[] argument)
	{
		String phrase;		// Phrase à tester
		int nbOccurence;	// Nombre de caractere cible rencontrés
		char caracDeb;		// Premier caractère de l'occurence a tester
		char caracFin;		// Deuxième caractère de l'occurence a tester
		
		System.out.println("Veuillez rentrer la phrase a tester :");
		phrase = Lire.S();
		System.out.println("Rentrer la premiere lettre");
		caracDeb = Lire.c();
		System.out.println("Rentrer la deuxième lettre");
		caracFin = Lire.c();
		nbOccurence = nbOccurence(phrase,caracDeb,caracFin,CARACSTOP);
		System.out.println("Le nombre d'occurence dans la phrase est de : "+nbOccurence);
		
	}
	public static int nbOccurence (String phrase,char caracDeb,char caracFin,char caracStop )
	{
		//Procedure qui compte le nombre d'occurence de 2 caractères dans une chaine
		//Phrase est la chaine a tester et NbOccurence est le nombre de fois qu'apparait 2 caractères successif
		//CaracDeb est le premier caractere a tester 
		//CaracFin est le deuxième caractere à tester
		int nbOccurence=0;
		int i =0;			// Indice de parcours de texte
		while (phrase.charAt(i)!=CARACSTOP) // Controle 1 a 1 des caractères de la phrase
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