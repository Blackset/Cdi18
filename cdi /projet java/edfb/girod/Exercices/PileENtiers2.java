MANIPULER une pile d�entiers g�r�e avec un tableau et un indice. 
 
 // Une pile d�entiers est une structure de donn�es qui permet de stocker des entiers 
 // et de les restituer dans un ordre bien pr�cis. 
 // Ces donn�es seront restitu�es une � une sur demande selon la r�gle : derni�re entr�e, premi�re sortie    
 // ( LIFO: Last In First Out ). Ceci correspond � l'usage habituel d'une pile d'assiettes ou de torchons. 
 // Cette pile est r�alis�e � l�aide d�un tableau d�entier et d�un indice de parcours. 
 
 
1) Donnez le principe de fonctionnement avec les structures de donn�es de cette pile (ajout et retrait d�un �l�ment) 
	en �tudiant particuli�rement ce qui se passe quand le tableau est vide et quand il est plein. 
 
2) Donnez les interfaces des proc�dures � init_pile �, � empiler �, � d�piler �. 
 
3) Donnez les algoritmes des trois proc�dures. 


CONSTANTES
N = 50 // taille du tableau contenant les entiers � empiler   
 
Type
		pile = Enregistrement  // type des piles d�entiers         
			table : tableau [ N ] entier  // ranger les informations       
			nbrElement : entier  // nombre d��l�ment dans table    
		Finenregistrement 
		
		pileLifo : pile  	// pileLifo.table[]
							// pileLifo.nbrElement

	
	
pileLIFO vide quand nbrElement de pile = 0
pileLIFO pleine quand nbrElement = N 



Principe de fonctionnement
quand la pile est vide, le nombre d��l�ments de la pile est �gale � 0. 
Quand la pile est pleine, le nombre d��l�ments de la pile est N. 

Empiler est une fonction qui retourne un bool�en pour indiquer le bon fonctionnement de la fonction ( true on peut empiler, false la pile est pleine)
Si pile pleine --> l'entier empiler n'est donc pas empiler  --> r�sultat false
Autre cas --> r�sultat true
Depiler est une fonction qui retourne un bool�en pour indiquer le bon fonctionnement de la fonction ( true on peut d�piler, false la pile est vide)
Si pile vide --> Il n'y a donc pas d'entier � d�piler  --> resultat false
Autre cas --> r�sultat true
Init_pile est une fonction qui initialise la pile --> r�sultat pile vide (pileLIFO est initialis�e)


Interface proc�dure � empiler �
Fonction empiler ( entr�e Sortie pileLIFO : pile, entr�e valeur : entier ) : bool�en      
 // Cette fonction permet d�ins�rer un �l�ment dans la pile.      
 // Si pile pleine, la fonction ne fait rien et retourne false.   
 
	// pileLIFO est :
	// en entr�e : la pile dans laquelle on veut empiler valeur   
	// en sortie : la pile dans laquelle valeur est empil�e (si pile n'est pas encore pleine)     
	// valeur est la valeur � empiler        
	// la fonction retourne true si valeur empil�e, false si pleine 

Interface proc�dure � depiler �
Fonction depiler ( entr�e Sortie pileLIFO : pile, sortie val : entier ) : bool�en      
 // Cette fonction permet d�extraire un �l�ment dans la pile.      
 // Si pile vide, la fonction ne fait rien et retourne false. 

	// pileLIFO est :
	// en entr�e : la pile dans laquelle on veut depiler valeur   
	// en sortie : la pile dans laquelle valeur est d�pil�� (si pile n'est pas d�j� vide)     
	// valeur est la valeur � d�piler     
	// la fonction retourne true si valeur d�pil�e, false si vide


Interface proc�dure � init_pile �
procedure init_pile ( Sortie pileLIFO : pile )
  // Initialise la pile, (aucun �l�ment/vide) 
  // pileLIFO est notre pile initialis�e   



----------------------------------------------

CONSTANTES
N = 50 // taille du tableau contenant les entiers � empiler   
 
Type
		pile = Enregistrement  // type des piles d�entiers         
			table : tableau [ N ] entier  // ranger les informations  (dans la pile)     
			nbrElement : entier  // nombre d��l�ment dans table    
		Finenregistrement 

variable
valeur : entier
possible : booleen

Proc�dure depiler ( entr�e Sortie pileLIFO : pile, sortie val : entier ) : bool�en   // sortir la derni�re entr�e empil�e
		 // Cette fonction permet d�extraire un �l�ment dans la pile.      
		 // Si pile vide, la fonction ne fait rien et retourne false. 

		
		
		// A FAIRE
		Si pileLIFO.nbrElement = 0 alors  possible = false     // la pile est vide
 
			 Sinon  // on "d�pile" dans la pile  
				 valeur = pileLIFO.table [ pileLIFO.nbrElement ]   // on "depile"/ r�cup�re l'entier le plus haut dans la pile
				 pileLIFO.nbrElement := pileLIFO.nbrElement - 1   // on d�cr�mente pour pointer sue le nouveau sommet de la pile
				 possible = true                                  // la pile est pr�te pour une nouvelle entr�e
	 
		Finsi 
		// FIN A AFIRE
		 
		 
		 



                                        
Proc�dure empiler ( entr�e Sortie pileLIFO : pile, entr�e valeur : entier ) : bool�en    // entr�e une donn�e
		 // Cette fonction permet d�ins�rer un �l�ment dans la pile.      
		 // Si pile pleine, la fonction ne fait rien et retourne false. 

		Si pileLIFO.nbrElement = N alors  possible = false     // la pile est pleine
 
			 Sinon  // on "empile" l��l�ment dans la pile  
				 pileLIFO.nbrElement := pileLIFO.nbrElement + 1   // on incr�mente pour pointer en haut de la pile
				 pileLIFO.table [ pileLIFO.nbrElement ] = valeur   // on "empile" l'entier
				 possible = true                                  // la pile est pr�te pour une nouvelle entr�e
	 
		Finsi 

Proc�dure init_pile ( Sortie pileLIFO : pile )  // vider la pile
  // Initialise la pile, (aucun �l�ment, vide) 
  // pileLIFO est notre pile initialis�e          
 
 
D�but      // Aucun �l�ment dans la pile  
 
 pileLIFO.nbrElement := 0 // il suffit de mettre l'indice � 0
 
Fin 