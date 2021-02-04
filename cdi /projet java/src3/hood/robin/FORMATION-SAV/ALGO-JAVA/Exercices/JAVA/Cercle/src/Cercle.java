/*  Classe      : Cercle
    Auteur      : Eyrolles, revu par Lécu Régis
    Mise à jour : 12 février 2001
    Fonction    : ce programme calcule le périmètre et la surface d'un cercle 
                  à partir de son rayon
*/
public class Cercle	
{

 public static void main(String [] argument)
 {
	double rayon ;     // rayon en m
    double perimetre;  // périmètre en m 
    double surface;	   // surface en m
    
    // Affichage fonctionnalité et version
    System.out.println ();
    System.out.println ("**** Périmètre et surface du Cercle (V1.0, 12/01/01) ****");
    System.out.println ();
    
    // Etape 1 : lecture du rayon
	System.out.print("Valeur du rayon : ");
	rayon = Lire.d();

    // Etape 2 : calcul et affichage du périmètre
 	perimetre = 2 * Math.PI * rayon;
    System.out.println ();
	System.out.println("  Le cercle de rayon "+ rayon);
	System.out.println("    a pour perimetre : "+ perimetre);
	
	// Etape 3 : calcul de la surface
	surface = Math.PI * Math.pow(rayon, 2);
	System.out.println ();
	System.out.println ("  La surface du cercle : " + surface);

 }

}