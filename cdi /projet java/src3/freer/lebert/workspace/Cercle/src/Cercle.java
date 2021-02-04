/*  Classe      : Cercle
    Auteur      : Eyrolles, revu par L�cu R�gis
    Mise � jour : 12 f�vrier 2001
    Fonction    : ce programme calcule le p�rim�tre et la surface d'un cercle 
                  � partir de son rayon
*/
public class Cercle	
{

 public static void main(String [] argument)
 {
	double rayon ;     // rayon en m
    double perimetre;  // p�rim�tre en m 
    double surface;    // surface en m
    
    System.out.println("**** P�rim�tre et surface du Cercle (V1.0, 12/01/01) ****");

    // Etape 1 : lecture du rayon
	System.out.print("Valeur du rayon : ");
	rayon = Lire.d();

    // Etape 2 : calcul et affichage du p�rim�tre
 	perimetre = 2 * Math.PI * rayon;
 	surface = Math.PI * Math.pow(rayon, 2);
    System.out.println ();
	System.out.println("  Le cercle de rayon "+ rayon);
	System.out.println("    a pour perimetre : "+ perimetre);
	System.out.println("    et pour surface : "+ surface);

 }

}