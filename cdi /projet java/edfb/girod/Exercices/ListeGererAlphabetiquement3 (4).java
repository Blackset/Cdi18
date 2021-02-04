Gérer une liste de noms classés alphabétiquement. 
 
// Il s’agit de constituer une liste de noms classés par ordre alphabétique.
// Cette liste peut évoluer dans le temps, un  nom pouvant être ajouté ou retranché à cette liste, tout en conservant l’ordre alphabétique. 
// Pour cela, et pour optimiser les temps de traitement, utilisez la structure de données suivante : 
 
 
Constantes tailtable = 100 // taille du tableau contenant les noms      
tailnom = 10  // les noms ont dix caractères maximum  
final = 0  // indicateur de fin de liste    
 
Types chaînenom = tableau [ tailnom ] de caractère     
						// type des noms rangés dans le tableau   
	élément = Enregistrement                                                                     
							// type des éléments de la table des noms      
			nom : chaînenom // nom est le nom contenu dans la table        	élément.nom      
			suivant : entier // indice du nom suivant dans la table    		élément.suivant   
	Finenregistrement 
 
	tablenom = Enregistrement                                                    
				// type des tables de noms       
			table : tableau [ tailtable ] de élément     // table permet de ranger les informations       tablenom.table[]    
			libre : entier // libre est le premier élément de la liste libre             				  tablenom.libre     
			premier : entier // premier est le premier élément de la liste  des noms   					  tablenom.premier                                                            
		Finenregistrement 
 
 
Questions 
1) donnez une procédure permettant d’initialiser la table des noms à l’origine (vide). 
 
2) donnez une procédure permettant d’ajouter un nom à la table des noms. 
 
3) donnez une procédure permettant d’enlever un nom de la table des noms. 


pile		prénoms			indice												init
1			Cunégonde			7	  // --> quatrième = 7						1 2   libre 1 
2			Berthe				6     // --> deuxième = 6						2 3   premier 0
3			Sidonie				0												3 4    
4								8	  libre = 4									4 5
5			Agathe				2     premier = 5   							5 6
6			Cellulite			1	  // --> troisième = 1						6 7
7			Raymonde			3												7 8
8								9     // libre2 = 8								8 9
9								10	  // libre3 = 9								9 0
																				
Interface procédure init_tablenom
Procédure init_tablenom ( Sortie tablenom : table )  // vider la table
  // Initialise la table, (aucun élément, vide) 
  // tablenom est notre table initialisée           
Début      // Aucun élément dans la table 
 
 tablenom.libre := 1
 tablenom.premier := final // 0
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on génère une liste de libre en incrémentant tablenom.libre 
 
 tablenom.libre := 1  
	 Tantque    tablenom.libre <> tailtable    Faire  // jusqu'à 100
				// création de la liste des N éléments libres    
	 tablenom.table [ tablenom.libre ].suivant := tablenom.libre + 1  
	 tablenom.libre := tablenom.libre + 1 
 Fintantque 
 // fin liste libre
  tablenom.table [ tablenom.libre ].suivant := final 
 // début liste libre
 tablenom.libre := 1
Fin 


Interface procédure ajouternom    
Procédure ajouternom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : chaine )  //
// on ajoute un mot dans la table
// soit le mot existe déjà alors on ne fait rien et on retourne  un code-retour	--> "rien à faire" -->  "raf"  (ou entier) 0
// soit la table est pleine et on retourne un code-retour-->						"table pleine"	-->	"tp"
// soit on ajoute le prénom et on retourne 	un code-retour-->						"ajouté"		--> "ajout"
// tablenom est modifié en fonction de l'opération effectuée

Fonction ajouter ( Entrée Sortie tablenom : table, Entrée nom : chaînenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspecté    
			indice-nom  : entier // indice du nom vérifié       
			nouvel-indice  : entier // nouvel-indice est l’indice ou on va ranger le nom  
 
DEBUT   
 Si    	tablenom.libre = final    Alors // la table est pleine on ne fait rien   
 
		code-retour := "tp" 
 
 Sinon  	// recherche ou ranger le nom dans le tableau   
 
			nom-avant := final                 //  
			indice-nom := tablenom.premier     //  l'indice pointe sur le premier élément de la liste des noms
 
	   // parcours de la liste des noms jusqu’à trouver le nom à l’indice indice-nom      
	   // sa place entre nom-avant et indice-nom, ou la fin de liste     
 
		Tantque    ( indice-nom <> final ) et ( tablenom.table [ indice-nom ] < nom )    Faire     
							// quand fin de liste ou quand on trouve un prénom >= dans la table   
	 
			nom-avant := indice-nom    
			indice-nom := tablenom.table [ indice-nom ]
	 
		Fintantque 
 
		   // soit on a trouvé le nom, soit il faut ajouter le nom en tête, soit il faut     
		   // ajouter le nom en milieu ou fin de liste.     
 
		Si    ( indice-nom <> final ) et ( nom = tablenom.table [ indice-nom ] )    Alors 
		 
			   // prénom trouvé dans la table des noms  
			 
				code-retour := "raf"  
			
		Sinon // rangement du prénom dans la table des noms  
		 
				code-retour := "ajout"    
				nouvel-indice := tablenom.libre 
				tablenom.table [ nouvel-indice ] := nom 
			 
				// remise à jour la liste des libres  
			 
				tablenom.libre := tablenom.table [ tablenom.libre ] 
			 
				// soit on insère le prénom en tête de liste, soit on l’insère dans la liste  
		 
						   Si    nom-avant = final    Alors      // soit c’est le premier élément de la table de prénoms       
								   // soit nom est le plus petit prénom de la table       
								   
								   tablenom.table [ nouvel-indice ] := tablenom.premier     
								   tablenom.premier := nouvel-indice     
							Sinon      
								   // soit on insère au milieu de la liste de prénoms       
								   // soit en fin de liste de prénoms        
								   
								   tablenom.table [ nom-avant ] := nouvel-indice     
								   tablenom.table [ nouvel-indice ] := indice-nom    
						   Finsi 
			 
		  Finsi 
 
 Finsi 
FIN


Interface procédure enlevernom     
Procédure enlevernom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : chaine )  //   
// Cette fonction permet d’enlever un prénom de la table des prénoms.      
// Si table des prénoms vide la fonction ne fait rien et retourne "vide"      
// Si prénnom est absent de la table la fonction ne fait rien et retourne "absent"   
 
 // tablenom est 
 //      en entrée : la table des prénoms dans laquelle on veut enlever nom
 //      en sortie : la table des prénoms dans laquelle nom a été enlevé.    
 // 		nom est le prénom à enlever de la table.        
 // On retourne "vide" si la table est vide      
 // On retourne  "enlevé"  si le nom est enlevé de la table     
 // On retourne  "absent" si le nom n’était pas dans la table
 


Fonction enlever ( Entrée Sortie tablenom : table, Entrée nom : chaînenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspecté    
			indice-nom  : entier // indice du nom à enlever     
			nouvel-indice  : entier // nouvel-indice est l’indice du suivant dans la liste
 
DEBUT   
 Si    	tablenom.libre = 1    Alors // la table est vide on ne fait rien   
 
		code-retour := "vide" 
 
 Sinon  	// recherche ou enlever le prénom dans le tableau   
 
			nom-avant := final                 //  
			indice-nom := tablenom.premier     //  l'indice pointe sur le premier élément de la liste des noms
 
	   // parcours de la liste des noms jusqu’à trouver le nom à l’indice indice-nom      
	   // sa place entre nom-avant et indice-nom, ou la fin de liste     
 
		Tantque    ( indice-nom <> final ) et ( tablenom.table [ indice-nom ] < nom )    Faire     
							// quand fin de liste ou quand on trouve un nom >= dans la table   
	 
			nom-avant := indice-nom    
			indice-nom := tablenom.table [ indice-nom ]
	 
		Fintantque 
 
		   // soit on a trouvé le nom, soit il faut ajouter le nom en tête, soit il faut     
		   // ajouter le nom en milieu ou fin de liste.     
 
		Si    ( indice-nom <> final ) et ( nom = tablenom.table [ indice-nom ] )    Alors // on a trouvé un prénom
		// on enlève prénom dans la table des prénoms 
		
										 
							
						
						// si premier
						Si tablenom.table [ indice-nom ] = tablenom.premier

							tablenom.table [ nouvel-indice ] := tablenom.premier
							tablenom.libre := tablenom.table [ indice-nom ]	
										
						// sinon
						SINON
						
							tablenom.libre := tablenom.table [ indice-nom ]
							tablenom.table [ indice-nom ] := nouvel-indice

						FINSI

									
									 
		code-retour := "enlevé"  
			
		Sinon  
		
				 // prénom absent dans la table des prénoms 
				 
				code-retour := "absent" 
				
		Finsi 
 
 Finsi 
FIN
