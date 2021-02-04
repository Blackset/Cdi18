/*************************************************************************
  Programme         :  Tlettres.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001,maj nov 2003 jcc
  Fonction          :  
	Utilisation d'un tableau de caractères en Java
    Réalise un tri alphabétique sur un ensemble de maxLettres majuscules
	entrées au clavier, et réaffiche l'ensemble trié.   
**************************************************************************/
public class Tlettres
{
	final static int MAXLETTRES = 10;  
	
	public static void main (String arg [])
	{  
	   char [] majuscules ;
	   int nbMaj ;
	   majuscules = new char [MAXLETTRES]; 
                       
       System.out.println ("** Tri par ordre alphabetique d'un ensemble de lettres majuscules **");
       System.out.println ();										  
	   
	   // étape 1 : lecture et stockage des lettres dans "majuscules"
       nbMaj = lecture (majuscules);  
	   
  	   // étape 2: les majuscules sont réaffichées dans l'ordre de la saisie
       System.out.println ("Dans l'ordre de la saisie :");
       affichage (majuscules, nbMaj);
	   
 	   // étape 3 : classement des lettres par ordre alphabétique           
       triAlphabetique (majuscules, nbMaj);
	   
	   // étape 4 : réaffichage du tableau trié 
       System.out.println("Dans l'ordre alphabetique :" );
       affichage (majuscules, nbMaj);   
	   
	   Lire.Attente ();
   } 

	// lecture : lit une suite de caractères terminée par un point, et
	//	stocke au plus  maxLettres majuscules dans le tableau "maj". 
	//  Renvoie le nombre de majuscules stockées
   
	private static int lecture (char [] maj)
	{     
		int iRang = 0;  // nombre de lettres majuscules déjà rangées, et indice de rangement de   
			            // la prochaine lettre dans le tableau "maj"
   
		char carLu;    // dernier caractère lu 
                                                           
		do
		{
			System.out.print ("Majuscule ou . pour arreter :" );
			carLu = Lire.c();
		
			if ( (carLu >= 'A') && (carLu <= 'Z') ) 
			{                           // si le caractère est une lettre majuscule
				maj [iRang] = carLu;    // il est rangé dans le tableau
				iRang ++;			    // avance de l'indice de rangement
			}    
			else if (carLu != '.')
			{
				System.out.println ("Ce n'est pas une majuscule " );
			}
		}while ( (iRang < maj.length ) && (carLu != '.') );
		// arrêt quand iRang = taille du tableau ou quand un point est lu
        // maj.length est la taille du tableau
		
		System.out.println ();										  
		return iRang;
	}

   // affichage : affiche les "nbcar" caracteres du tableau "texte"     
	private static void affichage (char [] texte, int nbcar)
	{  
		for (int i = 0; i < nbcar ; i ++)
		{
	  	  System.out.print (texte [i] );
		}
		System.out.println ();
	}

	// permuter  : inverse les caractères texte[iPermut] et texte[iPermut+1]
	//             utilisée pour le tri par remontée des bulles, dans TriAlphabetique 
	private static void permuter  ( char [] texte, int iPermut) 
	{
		char sauvegarde = texte [iPermut];
		
		texte [iPermut] = texte [iPermut+1]; 
		texte [iPermut+1]= sauvegarde;
	}
	
	 // triAlphabetique : 
	 // met le tableau "texte" en ordre alphabétique, en utilisant le tri par "remontée des bulles"
	private static void triAlphabetique (char [] texte, int nbText)
	{   
      boolean inversion;		 	//  vrai si on effectue au moins une inversion de deux 
									// éléments dans la petite boucle, c'est-à-dire si le tableau n'est
								    // pas encore complètement trié
	  do
	  {
		 inversion = false;
		 for (int i= 0; i < nbText - 1; i ++) 	// du premier à l'avant-dernier élément
		 {
			if (texte [i] > texte [i+1] )	// si l'élément est plus grand que son successeur
			{ 
				inversion = true;     	 // le tableau n'est pas encore ordonné
				permuter (texte, i); 
			} 
		 }
	  }
      while (inversion); 			// trier tant qu'il reste des éléments non
						 			// ordonnés, donnant lieu à des inversions
   }     
}	
	