package objetExo2;



public class Test
{
	 public static void main(String [] argument)
	 {
		 Individu leMeilleur = new Individu();
		 leMeilleur.setNom("GERRARD"); 
		 leMeilleur.setPr�nom("Jean");
		 leMeilleur.setAdresse("3 Rue Emile Bouvier 69100 Villeurbanne");
		 //leMeilleur.lire();
		 //leMeilleur.afficher();
		 
		 // modifier quelques champs par les set pour les tester
		 // setNumRue
		leMeilleur.setNumRue("-5454");
		 
		 // afficher s�par�ment les champs par des get
		System.out.print(leMeilleur.getNumRue());
		 
		 
	 }
}
