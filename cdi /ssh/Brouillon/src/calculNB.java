/*  Classe      : unicode
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 19 Octobre 2015
    Fonction    : ce programme permet de compter les occurences d'une lettre dans une phrase terminée par un pont */

public class calculNB
{
	 public static final char CARTERM = '.';
     public static final int MAX = 80;


	public static void main(String [] argument)
	
	{
		
	char[] texte;        // déclacaration  d'une référence sur un tableau de caractères
	
	int nbcar;
	
	int i;
    texte = compter.traiterTableau();
	
    
	i = 0;
	nbcar = 0;
	
	 
	while ( texte [i]  != CARTERM )
		{
		 nbcar = nbcar + 1;
		 i = i + 1;
		 
		}
	
	System.out.println ("le nombre de lettre :"+nbcar);
	
	
	
	}
	
	
}
