/*  Classe      : Justifier  phrase
    Auteur      : Yann Capelli	
    Mise à jour : 18 Ocotbre 2016
    Fonction    : recopie une phrase en inversant chaque mot
*/
public class Justification
{		
	
	private static final int TAILLE = 40;
	private static final char SPACE = ' ';
	private static final char STOP = '.';

	public static void main(String[] argument)
	{
		char []phrase = new char [TAILLE];
		char []phraseJust = new char [TAILLE];
		phrase = RemplissageTableau.remplirTab();
		phraseJust = justifier(phrase);
		System.out.println(phraseJust);
	}
	
	public static char[] justifier ( char[] phrase)
	{
		// Cette procédure justifie sur 80 caractère une phrase en repartissant les mots et les espaces
		// sur la totalité de la longueur. Si il reste des espaces ils seront rajouté au premiers intervalles
		// phrase est la phrase a justifier
		// Retourne phraseJust qui est la phrase justifié
		char []phraseJust = new char [TAILLE];
		Entier i=new Entier();					// Indice de parcours de chaîne phrase
		Entier iJust=new Entier();				// Indice de parcours de chaîne phraseJust
		int tailleMot;			// Longueur d'un mots dans une chaîne
		int nbMot=0;				// Nombre de mots dans une chaîne
		int nbCarac=0;			// Nombre de caractère dans une chaîne
		int nbInter=0;			// Nombre d'intervalle a mettre entre les mots
		int nbEspace=0;			// Nombre d'espace a mettre après un mot
		int nbEspaceRestant=0;	// Nombre d'espace a repartir au debut
		
		// On compte d'abord le nombre de caractere totale de la phrase et le nombre de mots
		tailleMot = prendreMot(phrase,i);
		while (tailleMot!=0)	// Boucle tant que on ne tombe pas sur le terminateur
		{
			nbMot ++;
			nbCarac += tailleMot;
			tailleMot = prendreMot (phrase,i);
		}
		// Calcul du nombre d'intervalle 
		if (nbMot >1)	// Si il y a plusieur mots
		{
			nbInter = (TAILLE-nbCarac-1)/(nbMot-1);			// calcul du nombre d'espace entre chaque mots
			nbEspaceRestant = (TAILLE-nbCarac-1) % (nbMot-1);	// Calcul du nombre d'espace a repartir	
		}
		
		i.setVal(0);
		iJust.setVal(0);
		while(nbMot!=0)
		{
			tailleMot = prendreMot(phrase, i);
			copierMot(phrase, i.getVal(), tailleMot, iJust, phraseJust);
			nbMot --;
			if (nbMot !=0)
			{
				nbEspace = nbInter;
				if (nbEspaceRestant != 0)
				{
					nbEspaceRestant --;
					nbEspace++;
				}
				ajouterEspace(nbEspace, iJust, phraseJust);		
			}			
		}
		phraseJust[iJust.getVal()] = STOP;
		
		return phraseJust;
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
	public static void copierMot (char[] phrase, int i , int longueur , Entier iJust , char[]phraseJust)
	{
		// Procédure qui recopie un mot de phrase dans phraseJust 
		// phrase est la chaîne que l'ont veut traiter
		// i est l'indice de parcour de la phrase (sur le dernier caractere)
		// longueur est la longueur du mot reperé 
		// iJust est en entré : l'indice ou l'ont doit recopier le mot
		//			en sortie : la fin du mot recopié
		// phraseJust est la phrase justifié
		
		i = i - longueur;		// on positione l'indice sur le premier caractere du mot
		while (longueur!=0)		// Boucle tant qu'on a pas fait la longueur du mot
		{
			phraseJust[iJust.getVal()] = phrase[i];
			iJust.incr();
			i++;
			longueur--;
		}
	}
	
	public static void ajouterEspace (int nbEspace, Entier iJust, char[] phraseJust)
	{
		// Procédure qui ajoute un nombre d'espace defini en parametre a l'indice iJust
		// nbEspace est le nombre d'espace a ajouterEspace
		// iJust est l'indice au quelle on doit ajouter les espace dans phraseJust
		// phraseJust est le chaine dans laquelle on doit ajouter les espaces
		
		while (nbEspace != 0)		//Boucle tant qu'il reste des espace a rajouter
		{
			phraseJust[iJust.getVal()]=SPACE;
			iJust.incr();;
			nbEspace--;
			System.out.println(iJust);
		}
		
	}
	
	
	
	
}