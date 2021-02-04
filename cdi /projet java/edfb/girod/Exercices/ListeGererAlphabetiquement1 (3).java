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

Interface procédure init_tablenom
Procédure init_tablenom ( Sortie tablenom : table )  // vider la table
  // Initialise la table, (aucun élément, vide) 
  // tablenom est notre table initialisée           
Début      // Aucun élément dans la table 
 
 tablenom.libre := 1
 tablenom.premier := final // 0
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on génère une liste de libre en incrémentant tabnom.libre 
 
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
Procédure ajouternom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : entier )  //
// on ajoute un prénom dans la table
// soit le prénom existe déjà alors on ne fait rien et on retourne "rien à faire" --> -1
// soit la table est pleine et on retourne "table pleine"	--> 0
// soit on ajoute le prénom et on retourne "ajouté"		--> 1
// tablenom est modifié ou pas en fonction de l'ajout du prénom

Début      // Aucun élément dans la table 

SI  tablenom.premier = 0  // si la table est vide  ( les 3 modfifs) 
SI  tablenom.libre <> 0 alors // si la table est pleine on ne fait rien
SI	

SI  

sinon

Finsi

 
 
Fin 












//A FAIRE
Interface procédure enlevernom     
Procédure enlevernom ( entrée Sortie tablenom : table,  entrée nom : chainenom , sortie : entier )  //


