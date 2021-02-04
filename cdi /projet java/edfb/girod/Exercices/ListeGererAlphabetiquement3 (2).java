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
1			Cunégonde			7	  // --> quatrième = 7						1 2   // 
2			Berthe				6     // --> deuxième = 6						2 3   // 
3			Sidonie				0												3 4   // 
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
 
 tablenom.libre := 1	// 1er libre
 tabnom.premier := final // fin de liste
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on génère une liste de libre en incrémentant tabnom.libre 
 
 tabnom.libre := 1  
	 Tantque    tabnom.libre <> tailtable    Faire  // toute la table
				// création de la liste des N éléments libres    
	 tabnom.libre := tabnom.libre + 1 
	 tabnom.table [ tabnom.libre -1 ] := tabnom.libre   
 Fintantque 
 
 tabnom.libre := 1
 
Fin 

Interface procédure ajouternom    
Procédure ajouternom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : chaine )  //
// on ajoute un mot dans la table
// soit le mot existe déjà alors on ne fait rien et on retourne  un code-retour	--> "rien à faire" -->  "raf"  (ou entier) 0
// soit la table est pleine et on retourne un code-retour-->						"table pleine"	-->	"tp"
// soit on ajoute le prénom et on retourne 	un code-retour-->						"ajouté"		--> "ajout"
// tablenom est modifié en fonction de l'opération effectuée

Fonction ajouter ( Entrée Sortie tabnom : tablenom, Entrée nom : chaînenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspecté    
			indice-nom  : entier // indice du nom vérifié       
			nouvel-indice  : entier // nouvel-indice est l’indice ou on va ranger le nom  
 
DEBUT   
 Si    	tabnom.libre = final    Alors // la table est pleine on ne fait rien   
 
		code-retour := "tp" 
 
 Sinon  	// recherche ou ranger le nom dans le tableau   
 
			nom-avant := final                 //  
			indice-nom := tabnom.premier     //  l'indice pointe sur le premier élément de la liste des noms
 
	   // parcours de la liste des noms jusqu’à trouver le nom à l’indice indice-nom      
	   // sa place entre nom-avant et indice-nom, ou la fin de liste     
 
		Tantque    ( indice-nom <> final ) et ( tabnom.table [ indice-nom ] < nom )    Faire     
							// quand fin de liste ou quand on trouve un nom >= dans la table   
	 
			nom-avant := indice-nom    
			indice-nom := tabnom.table [ indice-nom ]
	 
		Fintantque 
 
		   // soit on a trouvé le nom, soit il faut ajouter le nom en tête, soit il faut     
		   // ajouter le nom en milieu ou fin de liste.     
 
		Si    ( indice-nom <> final ) et ( nom = tabnom.table [ indice-nom ] )    Alors 
		 
			   // nom trouvé dans la table des noms  
			 
				code-retour := "raf"  
			
		Sinon // rangement du nom dans la table des noms  
		 
				code-retour := "ajout"    
				nouvel-indice := tabnom.libre 
				tabnom.table [ nouvel-indice ] := nom 
			 
				// remise à jour la liste des libres  
			 
				tabnom.libre := tabnom.table [ tabnom.libre ] 
			 
				// soit on insère le nom en tête de liste, soit on l’insère dans la liste  
		 
						   Si    nom-avant = final    Alors      // soit c’est le premier élément de la table de noms       
								   // soit nom est le plus petit nom de la table       
								   
								   tabnom.table [ nouvel-indice ] := tabnom.premier     
								   tabnom.premier := nouvel-indice     
							Sinon      
								   // soit on insère au milieu de la liste de noms       
								   // soit en fin de liste de noms        
								   
								   tabnom.table [ nom-avant ] := nouvel-indice     
								   tabnom.table [ nouvel-indice ] := indice-nom    
						   Finsi 
			 
		  Finsi 
 
 Finsi 
FIN



//A FAIRE
Interface procédure enlevernom     
Procédure enlevernom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : entier )  //
// on ajoute un mot dans la table
// soit le mot existe déjà alors on ne fait rien et on retourne 		"rien à faire" -->  raf
// soit la table est pleine et on retourne 								"table pleine"	-->	tp
// soit on ajoute le prénom et on retourne 								"ajouté"		--> ajout
// tablenom est modifié en fonction de l'opération effectuée