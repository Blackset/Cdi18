/*************************************************************************
  Programme		    :  Tempera.java
  Auteur            :  Lécu Regis 
  Mise a jour       :  février 2001
  Fonction          :  
  Programme résumant les différents schémas conditionnels et alternatifs 
************************************************************************/
public class Tempera
{
	 public static void main (String [] argument)
	 {     
		 char pluie, brouillard;
		 
		 System.out.println ("*** Meteo ***");
		 System.out.println ();
		 
		 System.out.print ("Va-t-il pleuvoir ? (O pour oui) : ") ;
		 pluie = Lire.c();
		 
		 System.out.print ("Y aura-t-il du brouillard ? (O pour oui): " );
		 brouillard = Lire.c();
		 System.out.println();
		 
		 if (pluie == 'O')
		 {
			if (brouillard == 'O')
			{
				System.out.println ("Bon .. pluie et brouillard je reste chez moi !");
			}
			else
			{ 
				System.out.println ("OK je prends mon parapluie ");
				System.out.println();
	
				short temperature;
				System.out.print ("Quelle temperature fera-t-il ? : ");
				temperature  = Lire.s ();
				System.out.println();
					   
				if (temperature < -20)
				{
					System.out.println ("Je ne sors pas par " + temperature + " °C" ); 
				}
				else if (temperature < 5)
				{
					System.out.println ("OK! Je veux bien venir avec un manteau " );
				}
				else if (temperature > 20)
				{
					System.out.println ("Mais c'est le printemps !");
				}
				else  
				{
					System.out.println ("C'est moyen: je mets tout de meme une veste");
				}
			}
		}
		else	// il ne pleut pas
		{  
			if (brouillard == 'O')
			{
				System.out.println ("Je viens avec une echarpe " );
			}
			else 
			{  
				// Noter l'utilisation de la variable locale soleil 
				// (visible uniquement dans le bloc)
				char soleil ;
				System.out.print ("Fera-t-il du soleil ? (O pour oui ) : " );
				soleil = Lire.c();
				System.out.println();
				       
				if (soleil == 'O')
				{
					System.out.println ("OK je prends mes lunettes noires!" );
				}
				else 
				{
					System.out.println ("Beau temps pour les champignons!") ;
				}
			}
		}
		 
		System.out.println ();
		System.out.println ("Tapez sur Entree pour Terminer");
		Lire.c();      
	}
}
