
/*  Classe      : unicode
    Auteur      : Halim, revu par L�cu R�gis
    Mise � jour : 19 Octobre 2015
    Fonction    : ce programme permet de compter les occurences d'une lettre dans une phrase termin�e par un pont */

public class compter1
{

     public static final char CARTERM = '.';
     public static final int MAX = 80;
     public static final char LETTRERECHERCHER= 'a';

	public static void main(String [] argument)
	
	{
		
	char[] texte;        // d�clacaration  d'une r�f�rence sur un tableau de caract�res
	
	
 
	 int nbLettrea;
	 int i;
	 texte = compter.traiterTableau();
	
	
	
	 i = 0;
	 nbLettrea = 0;
	  
	 while ( texte [i] != CARTERM)
	 {
		 
		 if (texte[i] == LETTRERECHERCHER )
		 {
				 nbLettrea = nbLettrea + 1;
		 }
		 
		 i = i + 1;
	 }
	 
	 System.out.println ("le nombre de lettrea :" + nbLettrea );
	 }
	
	}

