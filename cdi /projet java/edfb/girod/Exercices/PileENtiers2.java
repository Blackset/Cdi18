MANIPULER une pile d’entiers gérée avec un tableau et un indice. 
 
 // Une pile d’entiers est une structure de données qui permet de stocker des entiers 
 // et de les restituer dans un ordre bien précis. 
 // Ces données seront restituées une à une sur demande selon la règle : dernière entrée, première sortie    
 // ( LIFO: Last In First Out ). Ceci correspond à l'usage habituel d'une pile d'assiettes ou de torchons. 
 // Cette pile est réalisée à l’aide d’un tableau d’entier et d’un indice de parcours. 
 
 
1) Donnez le principe de fonctionnement avec les structures de données de cette pile (ajout et retrait d’un élément) 
	en étudiant particulièrement ce qui se passe quand le tableau est vide et quand il est plein. 
 
2) Donnez les interfaces des procédures « init_pile », « empiler », « dépiler ». 
 
3) Donnez les algoritmes des trois procédures. 


CONSTANTES
N = 50 // taille du tableau contenant les entiers à empiler   
 
Type
		pile = Enregistrement  // type des piles d’entiers         
			table : tableau [ N ] entier  // ranger les informations       
			nbrElement : entier  // nombre d’élément dans table    
		Finenregistrement 
		
		pileLifo : pile  	// pileLifo.table[]
							// pileLifo.nbrElement

	
	
pileLIFO vide quand nbrElement de pile = 0
pileLIFO pleine quand nbrElement = N 



Principe de fonctionnement
quand la pile est vide, le nombre d’éléments de la pile est égale à 0. 
Quand la pile est pleine, le nombre d’éléments de la pile est N. 

Empiler est une fonction qui retourne un booléen pour indiquer le bon fonctionnement de la fonction ( true on peut empiler, false la pile est pleine)
Si pile pleine --> l'entier empiler n'est donc pas empiler  --> résultat false
Autre cas --> résultat true
Depiler est une fonction qui retourne un booléen pour indiquer le bon fonctionnement de la fonction ( true on peut dépiler, false la pile est vide)
Si pile vide --> Il n'y a donc pas d'entier à dépiler  --> resultat false
Autre cas --> résultat true
Init_pile est une fonction qui initialise la pile --> résultat pile vide (pileLIFO est initialisée)


Interface procédure « empiler »
Fonction empiler ( entrée Sortie pileLIFO : pile, entrée valeur : entier ) : booléen      
 // Cette fonction permet d’insérer un élément dans la pile.      
 // Si pile pleine, la fonction ne fait rien et retourne false.   
 
	// pileLIFO est :
	// en entrée : la pile dans laquelle on veut empiler valeur   
	// en sortie : la pile dans laquelle valeur est empilée (si pile n'est pas encore pleine)     
	// valeur est la valeur à empiler        
	// la fonction retourne true si valeur empilée, false si pleine 

Interface procédure « depiler »
Fonction depiler ( entrée Sortie pileLIFO : pile, sortie val : entier ) : booléen      
 // Cette fonction permet d’extraire un élément dans la pile.      
 // Si pile vide, la fonction ne fait rien et retourne false. 

	// pileLIFO est :
	// en entrée : la pile dans laquelle on veut depiler valeur   
	// en sortie : la pile dans laquelle valeur est dépiléé (si pile n'est pas déjà vide)     
	// valeur est la valeur à dépiler     
	// la fonction retourne true si valeur dépilée, false si vide


Interface procédure « init_pile »
procedure init_pile ( Sortie pileLIFO : pile )
  // Initialise la pile, (aucun élément/vide) 
  // pileLIFO est notre pile initialisée   



----------------------------------------------

CONSTANTES
N = 50 // taille du tableau contenant les entiers à empiler   
 
Type
		pile = Enregistrement  // type des piles d’entiers         
			table : tableau [ N ] entier  // ranger les informations  (dans la pile)     
			nbrElement : entier  // nombre d’élément dans table    
		Finenregistrement 

variable
valeur : entier
possible : booleen

Procédure depiler ( entrée Sortie pileLIFO : pile, sortie val : entier ) : booléen   // sortir la dernière entrée empilée
		 // Cette fonction permet d’extraire un élément dans la pile.      
		 // Si pile vide, la fonction ne fait rien et retourne false. 

		
		
		// A FAIRE
		Si pileLIFO.nbrElement = 0 alors  possible = false     // la pile est vide
 
			 Sinon  // on "dépile" dans la pile  
				 valeur = pileLIFO.table [ pileLIFO.nbrElement ]   // on "depile"/ récupère l'entier le plus haut dans la pile
				 pileLIFO.nbrElement := pileLIFO.nbrElement - 1   // on décrémente pour pointer sue le nouveau sommet de la pile
				 possible = true                                  // la pile est prète pour une nouvelle entrée
	 
		Finsi 
		// FIN A AFIRE
		 
		 
		 



                                        
Procédure empiler ( entrée Sortie pileLIFO : pile, entrée valeur : entier ) : booléen    // entrée une donnée
		 // Cette fonction permet d’insérer un élément dans la pile.      
		 // Si pile pleine, la fonction ne fait rien et retourne false. 

		Si pileLIFO.nbrElement = N alors  possible = false     // la pile est pleine
 
			 Sinon  // on "empile" l’élément dans la pile  
				 pileLIFO.nbrElement := pileLIFO.nbrElement + 1   // on incrémente pour pointer en haut de la pile
				 pileLIFO.table [ pileLIFO.nbrElement ] = valeur   // on "empile" l'entier
				 possible = true                                  // la pile est prète pour une nouvelle entrée
	 
		Finsi 

Procédure init_pile ( Sortie pileLIFO : pile )  // vider la pile
  // Initialise la pile, (aucun élément, vide) 
  // pileLIFO est notre pile initialisée          
 
 
Début      // Aucun élément dans la pile  
 
 pileLIFO.nbrElement := 0 // il suffit de mettre l'indice à 0
 
Fin 