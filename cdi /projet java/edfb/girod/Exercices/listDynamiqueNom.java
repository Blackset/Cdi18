g�rer une liste dynamiquement.(structures de donn�es) 
 
 
Constantes tailnom = 10 // les noms ont dix caract�res maximum   
 
Types cha�nenom  = tableau [ tailnom ] de caract�re      
// type des noms rang�s dans la liste de noms     
pt_elem = pointeur de �l�ment      // type des pointeur sur des cha�nons de la liste    
�l�ment = Enregistrement // cha�non de la liste          
nom : cha�nenom  // nom conserv� dans ce cha�non        
suivant : pt_elem  // pointeur vers le cha�non suivant de la liste    
Finenregistrement 
 
 
Principe de fonctionnement de la table des noms 
 
Il n�y a pas de contrainte de d�bordement quand un �l�ment est ajout�. Par contre, 
quand un �l�ment d�une liste vide doit �tre enlev�, il faut signaler une erreur. 
 
� ajouter � et � enlever � sont des fonctions qui retournent un entier qui indique si la 
fonction s�est bien d�roul�e. Si un nom � une liste vide est enlev�, la fonction retourne la valeur -1. 
Si un nom d�j� pr�sent dans la liste est ajout�, la fonction retourne la valeur 1. 
Si un nom absent de la liste est enlev�, la fonction retourne la valeur 1. 
Dans les autres cas, ces deux fonctions retourneront des comptes rendus � 0. 

Proc�dure init_liste ( Sortie t�te : pt_elem ) 
 
 // Cette proc�dure permet d�initialiser une liste, c�est � dire qu�elle n�ait aucun �l�ment   
 
 // t�te est la t�te de la liste cr��e        
 
 
D�but      // il n�y a pas d��l�ment dans la liste  
 
 t�te := null 
 
Fin 
 

 
Fonction ajouter ( Entr�e Sortie t�te : pt_elem, Entr�e nom : cha�nenom ) : entier      
// Cette fonction permet d�ajouter un nom dans la liste des noms.    
// Si le nom est d�j� pr�sent dans la liste de noms, la fonction ne fait rien,   
// mais retourne la valeur 1.        
 
 // t�te est en entr�e la t�te de liste de noms dans laquelle on veut ajouter un nom    
 //              en sortie la t�te de liste de noms dans laquelle nom a pris sa place si possible   
 // nom est le nom � ranger dans la liste.        
 
 // la fonction retourne 0  si le nom est rang� dans la liste    
 //   1  si le nom �tait d�j� dans la liste    
 
 
Variables ok : entier  // ok est le code de retour de la fonction      
pt_prec : pt_elem  // pointeur sur le cha�non pr�c�dent celui en cours    
pt_cour : pt_elem  // pointeur sur le cha�non courant de la liste   
 
D�but // initialisation des pointeurs de parcours de la liste � la recherche du nom  
 
 pt_prec := null  pt_cour := t�te 
 
  // parcours de la liste des noms jusqu�� trouver le cha�non o� est le nom,     
  // les deux cha�nons entre lesquels il devrait �tre, ou la fin de liste    
 
 Tantque    ( pt_cour <> null ) et ( ptcour->.nom < nom )    Faire   // arr�t en fin de liste, ou quand on trouve un nom plus grand ou �gal dans la liste  
 
	  pt_prec := pt_cour   
	  pt_cour := pt_cour->.suivant 
 
 Fintantque 
 
  // soit on a trouv� le nom, soit il faut ajouter le nom en t�te,     
  // soit il faut ajouter le nom en milieu ou fin de liste.    
 
	Si    ( pt_cour <> null ) et ( nom = pt_cour->.nom )    Alors   ok := 1 
	// le nom est trouv� dans la liste des noms   Sinon 
	// rangement du nom dans la liste alphab�tique des noms    ok := 0 
 
		  Si    pt_prec = null    Alors // soit c�est le premier �l�ment de la liste de noms         
		  // soit nom est le plus petit nom de la liste     
			  cr�er ( t�te )    
			  t�te->.nom := nom    
			  t�te->.suivant := pt_cour   
		  Sinon // soit on ins�re au milieu de la liste de noms, soit en fin de liste de noms     
			  cr�er ( pt_prec->.suivant )    
			  pt_prec->.suivant->.nom := nom    
			  pt_prec->.suivant->.suivant := pt_cour   
		  Finsi  
  Finsi 
 
   // retour du compte rendu de l�ajout   Retourner ( ok ) 
 FIN
 
 
Fonction enlever ( Entr�e Sortie t�te : pt_elem, Entr�e nom : cha�nenom ) : entier      
// Cette fonction permet d�enlever un nom de la liste des noms.    
// Si la liste de noms est vide la fonction ne fait rien, mais retourne -1.   
// Si le nom est absent de la liste de noms, la fonction ne fait rien,   
// mais retourne la valeur 1.       
 
 // t�te est en entr�e la t�te de liste de noms dans laquelle on veut enlever un nom   
 // en sortie la t�te de liste de nom dans laquelle nom a  �t� enlev� si possible.   
 // nom est le nom � enlever de la liste.      
 
 // la fonction retourne -1 si la liste �tait vide      
 //  0  si le nom est enlev� de la liste     
 //  1  si le nom n��tait pas dans la liste    
 
Variables ok : entier // ok est le code de retour de la fonction      
pt_prec : pt_elem // pointeur sur le cha�non pr�c�dent celui en cours    
pt_cour : pt_elem // pointeur sur le cha�non courant de la liste   
 
D�but // si la liste des noms est vide on ne peut pas enlever  
 
 Si    t�te = null    Alors   
	ok := -1  
 
 Sinon // recherche du nom dans la liste  
 
	  pt_prec := null   
	  pt_cour := t�te 
 
  // parcours de la liste des noms jusqu�� trouver le cha�non o� est le nom,     
  // les deux cha�nons entre lesquels il devrait �tre, ou la fin de liste      
  Tantque    ( pt_cour <> null ) et ( ptcour->.nom < nom )    Faire   
		  // arr�t en fin de liste, ou quand on trouve un nom plus grand ou �gal dans la liste  
		 
		   pt_prec := pt_cour    
		   pt_cour := pt_cour->.suivant    
   Fintantque // soit on a trouv� le nom, soit on ne l�a pas trouv� et on arr�te l�  
 
	Si    ( pt_cour = null ) ou ( nom <> pt_cour->.nom )    Alors    
			  ok := 1 // nom non trouv� dans la liste des noms    
	Sinon // nom enlev� de la liste des noms     
			  ok := 0 // soit on enl�ve le nom en t�te de liste, soit on l�enl�ve dans la liste   
			 
			   Si    pt_prec = null    Alors // c�est le premier �l�ment de la liste de noms       
					   t�te := t�te->.suivant    Sinon       // soit on enl�ve dans la liste de noms        
					   pt_prec->.suivant := pt_cour->.suivant    
			   Finsi       
						d�truire ( pt_cour ) // cha�non contenant le nom � d�truire      
	Finsi  
Finsi    // retour du compte rendu du retrait   
   
   Retourner ( ok ) 
 
Fin 