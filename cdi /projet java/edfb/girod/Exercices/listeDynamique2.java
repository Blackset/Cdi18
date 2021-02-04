CREER une liste DYNAMIQUE gérée en FIFO
// Une liste dynamique est une liste à laquelle on peut rajouter un nombre quelconque d'éléments 
// sans restriction de taille ( sauf celle de la mémoire ). 
// Les éléments de la liste sont chaînés entre eux. 
 
 Structure d'une liste dynamique: 
 
tête  -->	[info | lien] --> [ info |lien ] --> [info | lien ]  -->	 null 
 
 Structure d'un élément de la liste: 
 
 type  
	référence =  POINTEUR DE   élément  
	élément = ENREGISTREMENT  
				valeur : info  // contient l'information que l'on désire conserver    
				suivant : référence  // pointeur vers l'élément suivant de la liste   
	FINENREGISTREMENT
 
 La liste sera repérée par un pointeur sur son premier élément ( la tête de la liste ). 
 Elle se termine par le premier élément trouvé dont le lien est à null ou avec le pointeur de tête à null (en cas de liste vide). 
 
 Soit une liste dynamique d'entiers fonctionnant en FIFO (First In First Out). 
 Le dernier élément de la liste est le dernier élément rentré dans la liste. 
 Le premier élément de la liste est le premier élément rentré dans la liste et le premier élément qui sortira de la liste.
 
 Ecrire une procédure qui rajoute un entier à la liste.
 Ecrire une procédure qui récupère un élément de la liste. 
 
 
 
 
 
 
 
 
 --------------------------------------------------------------------------------------------
 Ecrire une procédure qui rajoute un entier à la liste.
 // Le dernier élément de la liste est le dernier élément rentré dans la liste. 
 
  type  
	référence =  POINTEUR DE   élément   // pointeur sur element
	info = ...							// information que l'on desire stocker
	élément = ENREGISTREMENT  
				valeur : info  // contient l'information que l'on désire conserver    
				suivant : référence  // pointeur vers l'élément suivant de la liste   
	FINENREGISTREMENT
 
 //////////////////////////////////////////////////
 Variable 
	pointeurRef : pointeur de element // pointeur sur un objet dynamique

	
	
	
		Procédure initlisteDyna (  ) 
		// Initialiser une liste sans aucun élément    
 
 
		Procédure ajouter ( Entrée Sortie tete --> pointeurRef, Sortieinfo ) : booléen       
 		// Cette procédure permet d'ajouter un élément à la liste    
		// tête est en entrée la tête de la liste   null est la fin       
		// valeur est la valeur à ajouter à la liste  
		// Procédure/fonction retourne un booleén   ( vrai si ajouter) 
 
		Procédure enlever ( Entrée Sortie tete --> pointeurRef  ) : booléen 
		// Cette fonction permet de récupérer l’élément en tête de la liste.    
		// Si la liste est vide, on ne fait rien et on retourne faux  
		// tête est l'élément à enlever    
		// valeur est un entier
		// la fonction retourne vrai si element enlevé autrement faux
	

 
 Soit une liste dynamique d'entiers fonctionnant en FIFO (First In First Out). 
 Le dernier élément de la liste est le dernier élément rentré dans la liste. 
 Le premier élément de la liste est le premier élément rentré dans la liste et le premier élément qui sortira de la liste.
 
 tête  -->	[info | lien] --> [ info |lien ] --> [info | lien ]  -->	 null 
 tête  -->	 null 
 
 
 
 
 
Procédure ajouter ( Entrée Sortie tete --> pointeurRef, Sortieinfo ) : booléen         
 		// Cette procédure permet d'ajouter un élément à la liste    
		// tête est en entrée la tête de la liste   null est la fin       
		// valeur est la valeur à ajouter à la liste  
		// Procédure/fonction retourne un booleén   ( vrai si ajouter) 
		
		
Début    Si    tête = null    Alors  // la liste est vide on ajoute en tête
			On ajoute en tête
			
		Sinon // la liste n’est pas vide on ajoute ajout en fin/queue  
 
			parcours du pointeur  := tête   
			Tantque   pointeurRef.suivant <> null    Faire     // arrêt sur le dernier wagon de la liste  
 
				pointeurRef := pointeurRef.suivant      
			
			Fintantque  // on rajoute un wagon en queue de train  

			créer (pointeurRef.suivant )
			pointeurRef.suivant.valeur-> := info  // valeur associée au pointeur
			pointeurRef.suivant.suivant-> := null // on vient d'ajouter en fin de train donc le suivant 
													// est null
	
		Retourner true
		
		Finsi
 
Fin 

Procédure enlever ( Entrée Sortie tete --> pointeurRef  ) : booléen 
		// Cette fonction permet d'enlever un élément de la liste.   
		// Le premier élément de la liste est le premier élément rentré dans la liste et le premier élément qui sortira de la liste.
		// Si la liste est vide, on ne fait rien et on retourne faux 
		// tete.suivant est l'élément à enlever    
		// valeur est un entier
		// la fonction retourne vrai si element enlevé autrement faux
		
		
Début    Si    tête = null    Alors  // la liste est vide on ajoute en tête
			On ajoute en tête
			
		Sinon // la liste n’est pas vide on ajoute ajout en fin/queue  
 
			parcours du pointeur  := tête   
			Tantque   pointeurRef.suivant <> null    Faire     // arrêt sur le dernier wagon de la liste  
 
				pointeurRef := pointeurRef.suivant      
			
			Fintantque  // on rajoute un wagon en queue de train  

			créer (pointeurRef.suivant )
			pointeurRef.suivant.valeur-> := info  // valeur associée au pointeur
			pointeurRef.suivant.suivant-> := null // on vient d'ajouter en fin de train donc le suivant 
													// est null
 
		Finsi    // Retourner true
 
Fin 
	