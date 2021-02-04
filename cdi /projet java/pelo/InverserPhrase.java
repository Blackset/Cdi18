/*  Classe      : Inverser phrase
    Auteur      : Yann Capelli	
    Mise à jour : 18 Ocotbre 2016
    Fonction    : recopie une phrase en inversant chaque mot
*/
public class InverserPhrase
{	
	private static final char SPACE = ' ';
	private static final char STOP = '.';
	private static final int MAX = 80;
	
	public static void main(String[] argument)
	{
		//String phrase;
		//String phraseInverse="";
		char []phrase = new char [MAX];
		char []phraseInverse = new char [MAX];
		/*System.out.println("Veuillez rentrer une phrase :");
		phrase = Lire.S();	*/
		phrase = RemplissageTableau.remplirTab();
		inverser(phrase,phraseInverse);
		System.out.println(phraseInverse);
	}	
	public static void inverser ( char [] phrase , char [] phraseInv)
	{
		// Procédure qui recopie le texte en inversant l'ordre des lettres de chaque mots
		// phrase est la phrase que l'ont souhaite inverser
		// Renvoie une chaîne qui est la phrase obtenue apres avoir inverser les mots
		
		Entier i = new Entier();		// Indice de parcours de phrase
		Entier iInv = new Entier();		// Indice de parcours de phraseInv
		int longueur;					// Longueur d'un mot		
		i.setVal(0);
		iInv.setVal(0);
		longueur = prendreMot (phrase,i);
		
		while (longueur != 0)		// Boucle tant qu'il y a des mots
		{			
			inverserMot(phrase,i.getVal(),longueur,iInv,phraseInv);
			longueur = prendreMot (phrase,i);
			if (longueur != 0) 		// Si il y a encore des mots alors on rajoute un espace
			{
				phraseInv[iInv.getVal()] = SPACE;
				iInv.incr();
			}
			
		}
		phraseInv[iInv.getVal()]= STOP;
	}
	
	public static int prendreMot(char [] phrase, Entier i)
	{
		// Procédure qui fait avancer l'indice juste apres la fin d'un mot et donne sa longueur
		// Si le caractère suivant est le terminateur alors renvoi 0
		// phrase est la chaîne que l'ont veut traiter
		// i est l'indice de parcour de la phrase en entrée : position de depart pour chercher un mot 
		// 					en sortie : position juste apres un mot ou sur le terminateur
		// longueur est la longueur du mot reperé ou 0 si on est sur le point.
		int longueur=0;

		while (phrase[i.getVal()]==SPACE)	// Boucle tant qu'on a des espaces
		{			
			i.incr();
		}
		while ((phrase[i.getVal()]!=SPACE)&&(phrase[i.getVal()]!=STOP)) 	// Boucle tant qu'on est dans un mot et qu'on ne trouve pas le terminateur
		{
			i.incr();
			longueur++;
		}		
		return longueur;
	}
	private static void inverserMot(char [] phrase, int j, int longueur, Entier iInv, char[] phraseInv)
	{
		// Procédure qui recopie un mot de phrase dans phraseJust 
		// phrase est la chaîne que l'ont veut traiter
		// i est l'indice de parcour de la phrase (sur le dernier caractere)
		// longueur est la longueur du mot reperé 
		// iInv est en entré : l'indice ou l'ont doit recopier le mot
		//			en sortie : la fin du mot recopié
		// phraseInv est la phrase inversée
		j--;		
		while (longueur>0)
		{			
			phraseInv[iInv.getVal()] = phrase[j];
			iInv.incr();
			j--;
			longueur --;
		}
		
	}
	
	
	
	
	
	
	// FONCIONNE MAIS PAS CE QUI EST DEMANDE
	
	/*public static String inverser (String phrase)
	{
		String phraseInv="";		
		for (String mot : phrase.split(" "))
		{			
			 phraseInv += new StringBuffer(mot).reverse();			
			 phraseInv += " ";	
		}
		phraseInv = phraseInv.trim() +".";		// Enleve les espace a a fin et rajoute le poin final
		return phraseInv;
	}*/
}