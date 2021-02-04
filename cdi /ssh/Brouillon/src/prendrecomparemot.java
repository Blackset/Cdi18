
/*  Classe      : unicode
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 19 Octobre 2015
    Fonction    : ce programme permet de trouver : prendre mot et compare mot*/



public class prendrecomparemot
{
	 public static final char CARTERM = '.';
     public static final int MAX = 80;
     public static final int ESPACE = '.';
     
	public static void main(String [] argument)
	
	{
		
		char[] texte;
		texte = compter.traiterTableau();
			
   Entier i = new Entier ();
	
    i.setVal(0);
      
     int longueur;
    
    
	while  ( texte[i.getVal()] == ESPACE )	
	{
		  i.setVal(i.getVal()+1);
	}
		longueur = 0;
		
	while ( texte[i.getVal()] != ESPACE)
	{
		longueur =longueur + 1;
		i.setVal(i.getVal()+1);
	}
	
	}
	}

	
	
	
	
