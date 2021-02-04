/*************************************************************************
  Programme         :  Tlettres.java
  Auteur            :  L�cu Regis 
  Mise a jour       :  f�vrier 2001,maj nov 2003 jcc
  Fonction          :  
	Utilisation d'un tableau de caract�res en Java
    R�alise un tri alphab�tique sur un ensemble de maxLettres majuscules
	entr�es au clavier, et r�affiche l'ensemble tri�.   
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
	   
	   // �tape 1 : lecture et stockage des lettres dans "majuscules"
       nbMaj = lecture (majuscules);  
	   
  	   // �tape 2: les majuscules sont r�affich�es dans l'ordre de la saisie
       System.out.println ("Dans l'ordre de la saisie :");
       affichage (majuscules, nbMaj);
	   
 	   // �tape 3 : classement des lettres par ordre alphab�tique           
       triAlphabetique (majuscules, nbMaj);
	   
	   // �tape 4 : r�affichage du tableau tri� 
       System.out.println("Dans l'ordre alphabetique :" );
       affichage (majuscules, nbMaj);   
	   
	   Lire.Attente ();
   } 

	// lecture : lit une suite de caract�res termin�e par un point, et
	//	stocke au plus  maxLettres majuscules dans le tableau "maj". 
	//  Renvoie le nombre de majuscules stock�es
   
	private static int lecture (char [] maj)
	{     
		int iRang = 0;  // nombre de lettres majuscules d�j� rang�es, et indice de rangement de   
			            // la prochaine lettre dans le tableau "maj"
   
		char carLu;    // dernier caract�re lu 
                                                           
		do
		{
			System.out.print ("Majuscule ou . pour arreter :" );
			carLu = Lire.c();
		
			if ( (carLu >= 'A') && (carLu <= 'Z') ) 
			{                           // si le caract�re est une lettre majuscule
				maj [iRang] = carLu;    // il est rang� dans le tableau
				iRang ++;			    // avance de l'indice de rangement
			}    
			else if (carLu != '.')
			{
				System.out.println ("Ce n'est pas une majuscule " );
			}
		}while ( (iRang < maj.length ) && (carLu != '.') );
		// arr�t quand iRang = taille du tableau ou quand un point est lu
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

	// permuter  : inverse les caract�res texte[iPermut] et texte[iPermut+1]
	//             utilis�e pour le tri par remont�e des bulles, dans TriAlphabetique 
	private static void permuter  ( char [] texte, int iPermut) 
	{
		char sauvegarde = texte [iPermut];
		
		texte [iPermut] = texte [iPermut+1]; 
		texte [iPermut+1]= sauvegarde;
	}
	
	 // triAlphabetique : 
	 // met le tableau "texte" en ordre alphab�tique, en utilisant le tri par "remont�e des bulles"
	private static void triAlphabetique (char [] texte, int nbText)
	{   
      boolean inversion;		 	//  vrai si on effectue au moins une inversion de deux 
									// �l�ments dans la petite boucle, c'est-�-dire si le tableau n'est
								    // pas encore compl�tement tri�
	  do
	  {
		 inversion = false;
		 for (int i= 0; i < nbText - 1; i ++) 	// du premier � l'avant-dernier �l�ment
		 {
			if (texte [i] > texte [i+1] )	// si l'�l�ment est plus grand que son successeur
			{ 
				inversion = true;     	 // le tableau n'est pas encore ordonn�
				permuter (texte, i); 
			} 
		 }
	  }
      while (inversion); 			// trier tant qu'il reste des �l�ments non
						 			// ordonn�s, donnant lieu � des inversions
   }     
}	
	