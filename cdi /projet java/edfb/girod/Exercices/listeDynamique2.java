CREER une liste DYNAMIQUE g�r�e en FIFO
// Une liste dynamique est une liste � laquelle on peut rajouter un nombre quelconque d'�l�ments 
// sans restriction de taille ( sauf celle de la m�moire ). 
// Les �l�ments de la liste sont cha�n�s entre eux. 
 
 Structure d'une liste dynamique: 
 
t�te  -->	[info | lien] --> [ info |lien ] --> [info | lien ]  -->	 null 
 
 Structure d'un �l�ment de la liste: 
 
 type  
	r�f�rence =  POINTEUR DE   �l�ment  
	�l�ment = ENREGISTREMENT  
				valeur : info  // contient l'information que l'on d�sire conserver    
				suivant : r�f�rence  // pointeur vers l'�l�ment suivant de la liste   
	FINENREGISTREMENT
 
 La liste sera rep�r�e par un pointeur sur son premier �l�ment ( la t�te de la liste ). 
 Elle se termine par le premier �l�ment trouv� dont le lien est � null ou avec le pointeur de t�te � null (en cas de liste vide). 
 
 Soit une liste dynamique d'entiers fonctionnant en FIFO (First In First Out). 
 Le dernier �l�ment de la liste est le dernier �l�ment rentr� dans la liste. 
 Le premier �l�ment de la liste est le premier �l�ment rentr� dans la liste et le premier �l�ment qui sortira de la liste.
 
 Ecrire une proc�dure qui rajoute un entier � la liste.
 Ecrire une proc�dure qui r�cup�re un �l�ment de la liste. 
 
 
 
 
 
 
 
 
 --------------------------------------------------------------------------------------------
 Ecrire une proc�dure qui rajoute un entier � la liste.
 // Le dernier �l�ment de la liste est le dernier �l�ment rentr� dans la liste. 
 
  type  
	r�f�rence =  POINTEUR DE   �l�ment   // pointeur sur element
	info = ...							// information que l'on desire stocker
	�l�ment = ENREGISTREMENT  
				valeur : info  // contient l'information que l'on d�sire conserver    
				suivant : r�f�rence  // pointeur vers l'�l�ment suivant de la liste   
	FINENREGISTREMENT
 
 //////////////////////////////////////////////////
 Variable 
	pointeurRef : pointeur de element // pointeur sur un objet dynamique

	
	
	
		Proc�dure initlisteDyna (  ) 
		// Initialiser une liste sans aucun �l�ment    
 
 
		Proc�dure ajouter ( Entr�e Sortie tete --> pointeurRef, Sortieinfo ) : bool�en       
 		// Cette proc�dure permet d'ajouter un �l�ment � la liste    
		// t�te est en entr�e la t�te de la liste   null est la fin       
		// valeur est la valeur � ajouter � la liste  
		// Proc�dure/fonction retourne un boole�n   ( vrai si ajouter) 
 
		Proc�dure enlever ( Entr�e Sortie tete --> pointeurRef  ) : bool�en 
		// Cette fonction permet de r�cup�rer l��l�ment en t�te de la liste.    
		// Si la liste est vide, on ne fait rien et on retourne faux  
		// t�te est l'�l�ment � enlever    
		// valeur est un entier
		// la fonction retourne vrai si element enlev� autrement faux
	

 
 Soit une liste dynamique d'entiers fonctionnant en FIFO (First In First Out). 
 Le dernier �l�ment de la liste est le dernier �l�ment rentr� dans la liste. 
 Le premier �l�ment de la liste est le premier �l�ment rentr� dans la liste et le premier �l�ment qui sortira de la liste.
 
 t�te  -->	[info | lien] --> [ info |lien ] --> [info | lien ]  -->	 null 
 t�te  -->	 null 
 
 
 
 
 
Proc�dure ajouter ( Entr�e Sortie tete --> pointeurRef, Sortieinfo ) : bool�en         
 		// Cette proc�dure permet d'ajouter un �l�ment � la liste    
		// t�te est en entr�e la t�te de la liste   null est la fin       
		// valeur est la valeur � ajouter � la liste  
		// Proc�dure/fonction retourne un boole�n   ( vrai si ajouter) 
		
		
D�but    Si    t�te = null    Alors  // la liste est vide on ajoute en t�te
			On ajoute en t�te
			
		Sinon // la liste n�est pas vide on ajoute ajout en fin/queue  
 
			parcours du pointeur  := t�te   
			Tantque   pointeurRef.suivant <> null    Faire     // arr�t sur le dernier wagon de la liste  
 
				pointeurRef := pointeurRef.suivant      
			
			Fintantque  // on rajoute un wagon en queue de train  

			cr�er (pointeurRef.suivant )
			pointeurRef.suivant.valeur-> := info  // valeur associ�e au pointeur
			pointeurRef.suivant.suivant-> := null // on vient d'ajouter en fin de train donc le suivant 
													// est null
	
		Retourner true
		
		Finsi
 
Fin 

Proc�dure enlever ( Entr�e Sortie tete --> pointeurRef  ) : bool�en 
		// Cette fonction permet d'enlever un �l�ment de la liste.   
		// Le premier �l�ment de la liste est le premier �l�ment rentr� dans la liste et le premier �l�ment qui sortira de la liste.
		// Si la liste est vide, on ne fait rien et on retourne faux 
		// tete.suivant est l'�l�ment � enlever    
		// valeur est un entier
		// la fonction retourne vrai si element enlev� autrement faux
		
		
D�but    Si    t�te = null    Alors  // la liste est vide on ajoute en t�te
			On ajoute en t�te
			
		Sinon // la liste n�est pas vide on ajoute ajout en fin/queue  
 
			parcours du pointeur  := t�te   
			Tantque   pointeurRef.suivant <> null    Faire     // arr�t sur le dernier wagon de la liste  
 
				pointeurRef := pointeurRef.suivant      
			
			Fintantque  // on rajoute un wagon en queue de train  

			cr�er (pointeurRef.suivant )
			pointeurRef.suivant.valeur-> := info  // valeur associ�e au pointeur
			pointeurRef.suivant.suivant-> := null // on vient d'ajouter en fin de train donc le suivant 
													// est null
 
		Finsi    // Retourner true
 
Fin 
	