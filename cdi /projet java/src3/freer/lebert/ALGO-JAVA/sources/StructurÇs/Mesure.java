/***************************************************************************
  Programme		  Mesure.java
  Auteur		  Lécu Regis 
  Mise a jour     février 2001, maj nov 2003 jcc
  Fonction        

  Utilisation des classes en Java comme "enregistrement", sans fonctions
  membres.

  On gère un ensemble de mesure. Une mesure a pour caractéristique : 
    1° un libellé
    2° l'état du capteur : s'il est en panne, la mesure est sans signification
    3° la valeur de la mesure.
****************************************************************************/
   
class Capteur      	// descripteur de mesure : class sans l'attribut public
{
	public String   lib;	// libellé de la mesure
	public boolean  etat;	// vrai si fonctionnement capteur OK
	public int      val;    // valeur mesurée   
}

public class Mesure
{
	public static void main (String arg[])
    {
		System.out.println ("* Demo sur les enregistrements (suivre sur le listing) *");
		System.out.println ();
		
		// déclaration d'une variable qui référencera un "Descripteur"
		Capteur pression1 ;
		// création du Descripteur par new, référencé par pression1
		pression1 = new Capteur();
		// initialisation de ses champs (Notation avec le .)
		pression1.lib = "PRESSION";
		pression1.etat = true;
		pression1.val = 5;
		
		afficher ("Capteur Pression1", pression1);

		Capteur pression2 = pression1;
		afficher ("Capteur Pression2 (idem pression1)", pression2);
        // Les deux objets se réfèrent maintenant au même enregistrement en mémoire 

		// modification d'un champ
		pression2.etat = false;
		pression2.val = 1;
		pression2.lib = "Basse pression";
		afficher ("Capteur Pression1 (apres modif par pression2)", pression1);
		
		Lire.Attente ();		  

		// Création d'un nouvel enregistrement référencé par pression2
		pression2 = new Capteur();
		pression2.lib = "Haute Pression";
		pression2.val = 30;
		pression2.etat = true;
		
		afficher ("Capteur Pression1", pression1);
		afficher ("Capteur Pression2 (autre enregistrement)", pression2);
		Lire.Attente ();		  
	}

	public static void afficher (String msg, Capteur des) 
	// ici msg et des sont en entrée sortie, mais
	// msg est une chaîne constante, et ne peut pas être modifiée
	// des ici n’est pas modifié par la fonction, donc est utilisée comme une entrée
	{
		// Accès aux champs "public" d'un objet
		// par la notation :   nom_objet.nom_champ 

		System.out.println (msg);
		System.out.println ();
		
		System.out.println (" Nom    : "  + des.lib);
		System.out.print   (" Etat   : ");
		if (des.etat)
		{
			System.out.println ("** OK **"); // capteur en état de marche
		}
		else
		{
			System.out.println ("** HS **"); // capteur en panne
		}
		
		System.out.println (" Valeur : " + des.val);
		System.out.println ();
	}
}