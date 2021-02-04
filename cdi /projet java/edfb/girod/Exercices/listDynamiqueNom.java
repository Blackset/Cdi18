gérer une liste dynamiquement.(structures de données) 
 
 
Constantes tailnom = 10 // les noms ont dix caractères maximum   
 
Types chaînenom  = tableau [ tailnom ] de caractère      
// type des noms rangés dans la liste de noms     
pt_elem = pointeur de élément      // type des pointeur sur des chaînons de la liste    
élément = Enregistrement // chaînon de la liste          
nom : chaînenom  // nom conservé dans ce chaînon        
suivant : pt_elem  // pointeur vers le chaînon suivant de la liste    
Finenregistrement 
 
 
Principe de fonctionnement de la table des noms 
 
Il n’y a pas de contrainte de débordement quand un élément est ajouté. Par contre, 
quand un élément d’une liste vide doit être enlevé, il faut signaler une erreur. 
 
« ajouter » et « enlever » sont des fonctions qui retournent un entier qui indique si la 
fonction s’est bien déroulée. Si un nom à une liste vide est enlevé, la fonction retourne la valeur -1. 
Si un nom déjà présent dans la liste est ajouté, la fonction retourne la valeur 1. 
Si un nom absent de la liste est enlevé, la fonction retourne la valeur 1. 
Dans les autres cas, ces deux fonctions retourneront des comptes rendus à 0. 

Procédure init_liste ( Sortie tête : pt_elem ) 
 
 // Cette procédure permet d’initialiser une liste, c’est à dire qu’elle n’ait aucun élément   
 
 // tête est la tête de la liste créée        
 
 
Début      // il n’y a pas d’élément dans la liste  
 
 tête := null 
 
Fin 
 

 
Fonction ajouter ( Entrée Sortie tête : pt_elem, Entrée nom : chaînenom ) : entier      
// Cette fonction permet d’ajouter un nom dans la liste des noms.    
// Si le nom est déjà présent dans la liste de noms, la fonction ne fait rien,   
// mais retourne la valeur 1.        
 
 // tête est en entrée la tête de liste de noms dans laquelle on veut ajouter un nom    
 //              en sortie la tête de liste de noms dans laquelle nom a pris sa place si possible   
 // nom est le nom à ranger dans la liste.        
 
 // la fonction retourne 0  si le nom est rangé dans la liste    
 //   1  si le nom était déjà dans la liste    
 
 
Variables ok : entier  // ok est le code de retour de la fonction      
pt_prec : pt_elem  // pointeur sur le chaînon précédent celui en cours    
pt_cour : pt_elem  // pointeur sur le chaînon courant de la liste   
 
Début // initialisation des pointeurs de parcours de la liste à la recherche du nom  
 
 pt_prec := null  pt_cour := tête 
 
  // parcours de la liste des noms jusqu’à trouver le chaînon où est le nom,     
  // les deux chaînons entre lesquels il devrait être, ou la fin de liste    
 
 Tantque    ( pt_cour <> null ) et ( ptcour->.nom < nom )    Faire   // arrêt en fin de liste, ou quand on trouve un nom plus grand ou égal dans la liste  
 
	  pt_prec := pt_cour   
	  pt_cour := pt_cour->.suivant 
 
 Fintantque 
 
  // soit on a trouvé le nom, soit il faut ajouter le nom en tête,     
  // soit il faut ajouter le nom en milieu ou fin de liste.    
 
	Si    ( pt_cour <> null ) et ( nom = pt_cour->.nom )    Alors   ok := 1 
	// le nom est trouvé dans la liste des noms   Sinon 
	// rangement du nom dans la liste alphabétique des noms    ok := 0 
 
		  Si    pt_prec = null    Alors // soit c’est le premier élément de la liste de noms         
		  // soit nom est le plus petit nom de la liste     
			  créer ( tête )    
			  tête->.nom := nom    
			  tête->.suivant := pt_cour   
		  Sinon // soit on insère au milieu de la liste de noms, soit en fin de liste de noms     
			  créer ( pt_prec->.suivant )    
			  pt_prec->.suivant->.nom := nom    
			  pt_prec->.suivant->.suivant := pt_cour   
		  Finsi  
  Finsi 
 
   // retour du compte rendu de l’ajout   Retourner ( ok ) 
 FIN
 
 
Fonction enlever ( Entrée Sortie tête : pt_elem, Entrée nom : chaînenom ) : entier      
// Cette fonction permet d’enlever un nom de la liste des noms.    
// Si la liste de noms est vide la fonction ne fait rien, mais retourne -1.   
// Si le nom est absent de la liste de noms, la fonction ne fait rien,   
// mais retourne la valeur 1.       
 
 // tête est en entrée la tête de liste de noms dans laquelle on veut enlever un nom   
 // en sortie la tête de liste de nom dans laquelle nom a  été enlevé si possible.   
 // nom est le nom à enlever de la liste.      
 
 // la fonction retourne -1 si la liste était vide      
 //  0  si le nom est enlevé de la liste     
 //  1  si le nom n’était pas dans la liste    
 
Variables ok : entier // ok est le code de retour de la fonction      
pt_prec : pt_elem // pointeur sur le chaînon précédent celui en cours    
pt_cour : pt_elem // pointeur sur le chaînon courant de la liste   
 
Début // si la liste des noms est vide on ne peut pas enlever  
 
 Si    tête = null    Alors   
	ok := -1  
 
 Sinon // recherche du nom dans la liste  
 
	  pt_prec := null   
	  pt_cour := tête 
 
  // parcours de la liste des noms jusqu’à trouver le chaînon où est le nom,     
  // les deux chaînons entre lesquels il devrait être, ou la fin de liste      
  Tantque    ( pt_cour <> null ) et ( ptcour->.nom < nom )    Faire   
		  // arrêt en fin de liste, ou quand on trouve un nom plus grand ou égal dans la liste  
		 
		   pt_prec := pt_cour    
		   pt_cour := pt_cour->.suivant    
   Fintantque // soit on a trouvé le nom, soit on ne l’a pas trouvé et on arrête là  
 
	Si    ( pt_cour = null ) ou ( nom <> pt_cour->.nom )    Alors    
			  ok := 1 // nom non trouvé dans la liste des noms    
	Sinon // nom enlevé de la liste des noms     
			  ok := 0 // soit on enlève le nom en tête de liste, soit on l’enlève dans la liste   
			 
			   Si    pt_prec = null    Alors // c’est le premier élément de la liste de noms       
					   tête := tête->.suivant    Sinon       // soit on enlève dans la liste de noms        
					   pt_prec->.suivant := pt_cour->.suivant    
			   Finsi       
						détruire ( pt_cour ) // chaînon contenant le nom à détruire      
	Finsi  
Finsi    // retour du compte rendu du retrait   
   
   Retourner ( ok ) 
 
Fin 