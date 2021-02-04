
/*  Classe      : unicode
    Auteur      : Halim, revu par Lécu Régis
    Mise à jour : 19 Octobre 2015
    Fonction    : ce programme permet de compter les occurences d'une lettre dans une phrase terminée par un pont */






public class compter
{
	  public static final char CARTERM = '.';
      public static final int MAX = 80;


	public static void main(String [] argument)
	
	{
		
	char[] texte;        // déclacaration  d'une référence sur un tableau de caractères
	
	
    char lettre1;
    char lettre2;
	int nbcouples;	
	
	
	int i;
	texte = traiterTableau();
	
	 i = 0;
     nbcouples = 0;
     
     System.out.println(" donne la lettre1  :" );
	 lettre1 = Lire.c();

	 System.out.println(" donner la lettre2 :");
	 lettre2 = Lire.c();
				
	while (texte[i] != CARTERM )
		
		
	{
	     		if (texte[i] == lettre1 )	
				{ 
					if (texte [i+1] == lettre2 &&  texte[i+1] != CARTERM);
					{
					nbcouples = nbcouples + 1;
			
					}		
							
				}
		         i = i + 1;   
				
				
	}
	
	System.out.println ("le nombre de couple est  :" + nbcouples );
	}


	public static char[] traiterTableau()
	{
		char[] texte;
		int i;
		texte = new char [MAX];    // tabcaractère est un tableau à une dimension MAX char
			
		String phrase; 
		
		System.out.println(" rentrer votre texte : ");
		
		phrase = Lire.Chaine();
for ( i = 0; i < phrase.length()&& phrase.charAt(i) != CARTERM &&i < texte.length - 1; i++)
{
		texte [i] = phrase.charAt(i);
}
 texte [i] = CARTERM;
		return texte;
	}
	

	
	
	public static int[] traiterTabEentier(int max)
	{
		int[] tabloEntier;
		int i;
		tabloEntier = new int [max];    // tabloEntier est un tableau à une dimension MAX int
		
		
	for ( i =  0;  i < max; i++)	
	{
		System.out.println(" entrer votre entier : ");
		tabloEntier [i] = Lire.i();
	}
		
		return tabloEntier;
	}
}


			
				

			

				
			
	
	
	
	
	
	
	


