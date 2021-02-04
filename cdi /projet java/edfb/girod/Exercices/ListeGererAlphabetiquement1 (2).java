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
 
 tablenom.libre := 1
 tabnom.premier := final // 0
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on génère une liste de libre en incrémentant tabnom.libre 
 
 tabnom.libre := 1  
	 Tantque    tabnom.libre <> tailtable    Faire  // jusqu'à 100
				// création de la liste des N éléments libres    
	 tabnom.libre := tabnom.libre + 1 
	 tabnom.table [ tabnom.libre -1 ] := tabnom.libre   
 Fintantque 
 
 tabnom.libre := 1
 
Fin 

Interface procédure ajouternom    
Procédure ajouternom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : entier )  //
// on ajoute un mot dans la table
// soit le mot existe déjà alors on ne fait rien et on retourne "rien à faire" --> 2
// soit la table est pleine et on retourne "table pleine"	-->0
// soit on ajoute le prénom et on retourne "ajouté"		--> 1
// tablenom est modifié en fonction de l'opération effectuée

//A FAIRE
Interface procédure enlevernom     
Procédure enlevernom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : entier )  //
// on ajoute un mot dans la table
// soit le mot existe déjà alors on ne fait rien et on retourne "rien à faire" --> 2
// soit la table est pleine et on retourne "table pleine"	-->0
// soit on ajoute le prénom et on retourne "ajouté"		--> 1
// tablenom est modifié en fonction de l'opération effectuée