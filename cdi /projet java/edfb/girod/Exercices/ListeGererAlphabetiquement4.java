G�rer une liste de noms class�s alphab�tiquement.  (page 94)
 
// Il s�agit de constituer une liste de noms class�s par ordre alphab�tique.
// Cette liste peut �voluer dans le temps, un  nom pouvant �tre ajout� ou retranch� � cette liste, tout en conservant l�ordre alphab�tique. 
// Pour cela, et pour optimiser les temps de traitement, utilisez la structure de donn�es suivante : 
 
 
Constantes tailtable = 100 // taille du tableau contenant les noms      
tailnom = 10  // les noms ont dix caract�res maximum  
final = 0  // indicateur de fin de liste    
 
Types cha�nenom = tableau [ tailnom ] de caract�re     
						// type des noms rang�s dans le tableau   
	�l�ment = Enregistrement                                                                     
							// type des �l�ments de la table des noms      
			nom : cha�nenom // nom est le nom contenu dans la table        	�l�ment.nom      
			suivant : entier // indice du nom suivant dans la table    		�l�ment.suivant   
	Finenregistrement 
 
	tablenom = Enregistrement                                                    
				// type des tables de noms       
			table : tableau [ tailtable ] de �l�ment     // table permet de ranger les informations       tablenom.table[].nom  tablenom.table[].suivant   
			libre : entier // libre est le premier �l�ment de la liste libre             				  tablenom.libre     
			premier : entier // premier est le premier �l�ment de la liste  des noms   					  tablenom.premier                                                            
		Finenregistrement 
 
 
Questions 
1) donnez une proc�dure permettant d�initialiser la table des noms � l�origine (vide). 
 
2) donnez une proc�dure permettant d�ajouter un nom � la table des noms. 
 
3) donnez une proc�dure permettant d�enlever un nom de la table des noms. 


pile		pr�noms			indice												init
1			Cun�gonde			7	  // --> quatri�me = 7						1 2   libre 1 
2			Berthe				6     // --> deuxi�me = 6						2 3   premier 0
3			Sidonie				0												3 4    
4								8	  libre = 4									4 5
5			Agathe				2     premier = 5   							5 6
6			Cellulite			1	  // --> troisi�me = 1						6 7
7			Raymonde			3												7 8
8								9     // libre2 = 8								8 9
9								10	  // libre3 = 9								9 0
																				
Interface proc�dure init_tablenom
Proc�dure init_tablenom ( Sortie tablenom : table )  // vider la table
  // Initialise la table, (aucun �l�ment, vide) 
  // tablenom est notre table initialis�e           
D�but      // Aucun �l�ment dans la table 
 
 tablenom.libre := 1
 tablenom.premier := final // 0
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on g�n�re une liste de libre en incr�mentant tablenom.libre 
 
 tablenom.libre := 1  
	 Tantque    tablenom.libre <> tailtable    Faire  // jusqu'� 100
				// cr�ation de la liste des N �l�ments libres    
	 tablenom.table [ tablenom.libre ] := tablenom.libre + 1    //// .suivant page 23 ALGOSC
	 tablenom.libre := tablenom.libre + 1 
 Fintantque 
 // fin liste libre
  tablenom.table [ tablenom.libre ] := final 
 // d�but liste libre
 tablenom.libre := 1
Fin 


Algorithme DE PRINCIPE AJOUTERNOM
		Si table PLEINE alors
			-->TABLE PLEINE
		SINON
			Chercher PRENOM � ajouter
				SI PRENOM
					-->RIEN A FAIRE
				SINON
					
					NON SUIVANT // jusqu'a nom suivant
				
					ON range dans 1er libre
					ON modifie libre
						SI premier
							ON modifie premier
								indice-nom = tablenom.premier
								tablenom.premier = nouvel-indice
						SINON
																							// si dernier 
																							// indice = final
								(milieu ou dernier)
								tablenom (nouvel-indice) = tablenom (nom-avant)
								tablenom (nom-avant) = nouvelle-indice
						FINSI
				-->AJOUT
				FINSI
		FINSI
		 

Interface proc�dure ajouternom    
Proc�dure ajouternom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : chaine )  //
// on ajoute un mot dans la table
// soit le mot existe d�j� alors on ne fait rien et on retourne  un code-retour	--> "rien � faire"
// soit la table est pleine et on retourne un code-retour-->						"table pleine"
// soit on ajoute le pr�nom et on retourne 	un code-retour-->						"ajout"
// tablenom est modifi� en fonction de l'op�ration effectu�e

Fonction ajouter ( Entr�e Sortie tablenom : table, Entr�e nom : cha�nenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspect�    
			indice-nom  : entier // indice du nom v�rifi�       
			nouvel-indice  : entier // nouvel-indice est l�indice ou on va ranger le nom  
 
DEBUT   
 Si    	tablenom.libre = final    Alors // la table est pleine on ne fait rien   
 
		code-retour := "table pleine"
 
 Sinon  	// recherche ou ranger le nom dans le tableau   
 
			nom-avant := final                 //  
			indice-nom := tablenom.premier     //  l'indice pointe sur le premier �l�ment de la liste des noms
 
	   // parcours de la liste des noms jusqu�� trouver le nom � l�indice indice-nom      
	   // sa place entre nom-avant et indice-nom ou en fin de liste     
 
		Tantque    ( indice-nom <> final ) et ( tablenom.table [ indice-nom ].nom < nom )    Faire    
							// quand fin de liste ou quand on trouve un pr�nom >= dans la table  soit le suivant 
							// on connait le nom suivant  // nom suivant dans la table
			nom-avant := indice-nom    
			indice-nom := tablenom.table [ indice-nom ]
	 
		Fintantque 
 
		   // soit on a trouv� le nom, soit il faut ajouter le nom en t�te, soit il faut     
		   // ajouter le nom en milieu ou fin de liste.     
 
		Si    ( indice-nom <> final ) et ( nom = tablenom.table [ indice-nom ].nom )    Alors 
		 
			   // pr�nom trouv� dans la table des noms  
			 
				code-retour := "rien � faire"  
			
		Sinon // rangement du pr�nom dans la table des noms  
		 
				code-retour := "ajout"    
				nouvel-indice := tablenom.libre 
				tablenom.table [ nouvel-indice ] := nom 
			 
				// remise � jour la liste des libres  
			 
				tablenom.libre := tablenom.table [ tablenom.libre ] 
			 
				// soit on ins�re le pr�nom en premier soit dans la liste  
		 
						   Si    nom-avant = final    Alors      // soit c�est le premier �l�ment de la table de pr�noms       
								   // soit nom est le plus petit pr�nom de la table donc premier       
								   
								   tablenom.table [ nouvel-indice ] := tablenom.premier     
								   tablenom.premier := nouvel-indice     
							Sinon      
								   // si milieu ou fin de liste      
								   
								   tablenom.table [ nom-avant ] := nouvel-indice    
								   tablenom.table [ nouvel-indice ] := indice-nom    // (0 � 100)
						   Finsi 
			 
		  Finsi 
 
 Finsi 
FIN

Algorithme DE PRINCIPE ENLEVERNOM
		Si table VIDE alors
			-->TABLE VIDE
		SINON
			Chercher PRENOM � enlever 
				SI NON PRENOM
					-->ABSENT
				SINON
				NON SUIVANT
				VALEUR TABLE
					SI PREMIER
						ON modifie premier  
						PREMIER = indice NON SUIVANT
					SINON
																					// SI DERNIER
																					// indice de NON PRECEDENT --> final
						( milieu ou dernier) 
						table (NON SUIVANT) --> indice NON SUIVANT
					FINSI
					ON modifie libre
				-->ENLEVE
				FINSI
		FINSI

		
		
Interface proc�dure enlevernom     
Proc�dure enlevernom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : chaine )  //   
// Cette fonction permet d�enlever un pr�nom de la table des pr�noms.      
// Si table des pr�noms vide la fonction ne fait rien et retourne "vide"      
// Si pr�nnom est absent de la table la fonction ne fait rien et retourne "absent"   
 
 // tablenom est 
 //      en entr�e : la table des pr�noms dans laquelle on veut enlever nom
 //      en sortie : la table des pr�noms dans laquelle nom a �t� enlev�.    
 // 		nom est le pr�nom � enlever de la table.        
 // On retourne "vide" si la table est vide      
 // On retourne  "enlev�"  si le nom est enlev� de la table     
 // On retourne  "absent" si le nom n��tait pas dans la table
 


Fonction enlever ( Entr�e Sortie tablenom : table, Entr�e nom : cha�nenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspect�    
			indice-nom  : entier // indice du nom � enlever     
			nouvel-indice  : entier // nouvel-indice est l�indice du suivant dans la liste
			  
			indice-nom : entier // indice-nom est l�indice du nom inspect�

DEBUT     // si la table de noms est vide on ne peut pas enlever   
 Si    tablenom.premier = final    Alors 
		code-retour := "vide" 
 Sinon 
	   // recherche du nom  	 
	  nom-avant := final   
	  indice-nom := tablenom.premier 	 
	   // parcours de la liste des noms jusqu�� trouver le nom � l�indice indice-nom,  


	   
	 
					Tantque    ( indice-nom <> final ) et ( tablenom.table [ indice-nom].nom < nom )    Faire   // nom contenu dans la table  
								  // arr�t en fin de liste ou nom dans la table  
						nom-avant := indice-nom    
						indice-nom := tablenom.table[ indice-nom ].suivant    // nom suivant dans la table
					Fintantque 
	 
									// si trouv� on a non avant 
	 
					Si    ( indice-nom = final ) ou ( nom <>tablenom.table [indice-nom ].nom )    Alors 
					   // nom pas trouv� dans la table des noms  
						code-retour := "absent" 
						
					Sinon 	// enlever le nom de la table des noms  
					
							// si premier
										Si    nom-avant = final    Alors // c�est le premier element de la table  
											
											
											tablenom.premier := tablenom.table[indice-nom].suivant      // nom suivant dans la table
										/// PREMIER = indice NON SUIVANT
										
										
										Sinon   // si milieu liste ou fin de liste
											
											
											
											tablenom.table[nom-avant].suivant := tablenom.table[indice-nom].suivant  
												// dans cungonde on met 1 (valeur de berthe )
										///	table (NON SUIVANT) --> indice NON SUIVANT
											
										
										
										
										Finsi 
				 
				   // modifier la liste des libres  
				   tablenom.table [ indice-nom ].suivant := tablenom.libre  
				   tablenom.libre := indice-nom 
				   
				   code-retour := "enl�v�" 
				   
				  Finsi  
 Finsi 
 
FIN 
