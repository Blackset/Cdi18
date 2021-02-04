G�rer une liste de noms class�s alphab�tiquement. 
 
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
			table : tableau [ tailtable ] de �l�ment     // table permet de ranger les informations       tablenom.table[]    
			libre : entier // libre est le premier �l�ment de la liste libre             				  tablenom.libre     
			premier : entier // premier est le premier �l�ment de la liste  des noms   					  tablenom.premier                                                            
		Finenregistrement 
 
 
Questions 
1) donnez une proc�dure permettant d�initialiser la table des noms � l�origine (vide). 
 
2) donnez une proc�dure permettant d�ajouter un nom � la table des noms. 
 
3) donnez une proc�dure permettant d�enlever un nom de la table des noms. 


pile		pr�noms			indice												init
1			Cun�gonde			7	  // --> quatri�me = 7						1 2   // 
2			Berthe				6     // --> deuxi�me = 6						2 3   // 
3			Sidonie				0												3 4   // 
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
 
 tablenom.libre := 1	// 1er libre
 tabnom.premier := final // fin de liste
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on g�n�re une liste de libre en incr�mentant tabnom.libre 
 
 tabnom.libre := 1  
	 Tantque    tabnom.libre <> tailtable    Faire  // toute la table
				// cr�ation de la liste des N �l�ments libres    
	 tabnom.libre := tabnom.libre + 1 
	 tabnom.table [ tabnom.libre -1 ] := tabnom.libre   
 Fintantque 
 
 tabnom.libre := 1
 
Fin 

Interface proc�dure ajouternom    
Proc�dure ajouternom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : chaine )  //
// on ajoute un mot dans la table
// soit le mot existe d�j� alors on ne fait rien et on retourne  un code-retour	--> "rien � faire" -->  "raf"  (ou entier) 0
// soit la table est pleine et on retourne un code-retour-->						"table pleine"	-->	"tp"
// soit on ajoute le pr�nom et on retourne 	un code-retour-->						"ajout�"		--> "ajout"
// tablenom est modifi� en fonction de l'op�ration effectu�e

Fonction ajouter ( Entr�e Sortie tabnom : tablenom, Entr�e nom : cha�nenom ) : chaine 
 
 
Variables 	code-retour  : chaine // code-retour est le code de retour de la fonction    
			nom-avant : entier // nom-avant est le nom avant le nom inspect�    
			indice-nom  : entier // indice du nom v�rifi�       
			nouvel-indice  : entier // nouvel-indice est l�indice ou on va ranger le nom  
 
DEBUT   
 Si    	tabnom.libre = final    Alors // la table est pleine on ne fait rien   
 
		code-retour := "tp" 
 
 Sinon  	// recherche ou ranger le nom dans le tableau   
 
			nom-avant := final                 //  
			indice-nom := tabnom.premier     //  l'indice pointe sur le premier �l�ment de la liste des noms
 
	   // parcours de la liste des noms jusqu�� trouver le nom � l�indice indice-nom      
	   // sa place entre nom-avant et indice-nom, ou la fin de liste     
 
		Tantque    ( indice-nom <> final ) et ( tabnom.table [ indice-nom ] < nom )    Faire     
							// quand fin de liste ou quand on trouve un nom >= dans la table   
	 
			nom-avant := indice-nom    
			indice-nom := tabnom.table [ indice-nom ]
	 
		Fintantque 
 
		   // soit on a trouv� le nom, soit il faut ajouter le nom en t�te, soit il faut     
		   // ajouter le nom en milieu ou fin de liste.     
 
		Si    ( indice-nom <> final ) et ( nom = tabnom.table [ indice-nom ] )    Alors 
		 
			   // nom trouv� dans la table des noms  
			 
				code-retour := "raf"  
			
		Sinon // rangement du nom dans la table des noms  
		 
				code-retour := "ajout"    
				nouvel-indice := tabnom.libre 
				tabnom.table [ nouvel-indice ] := nom 
			 
				// remise � jour la liste des libres  
			 
				tabnom.libre := tabnom.table [ tabnom.libre ] 
			 
				// soit on ins�re le nom en t�te de liste, soit on l�ins�re dans la liste  
		 
						   Si    nom-avant = final    Alors      // soit c�est le premier �l�ment de la table de noms       
								   // soit nom est le plus petit nom de la table       
								   
								   tabnom.table [ nouvel-indice ] := tabnom.premier     
								   tabnom.premier := nouvel-indice     
							Sinon      
								   // soit on ins�re au milieu de la liste de noms       
								   // soit en fin de liste de noms        
								   
								   tabnom.table [ nom-avant ] := nouvel-indice     
								   tabnom.table [ nouvel-indice ] := indice-nom    
						   Finsi 
			 
		  Finsi 
 
 Finsi 
FIN



//A FAIRE
Interface proc�dure enlevernom     
Proc�dure enlevernom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : entier )  //
// on ajoute un mot dans la table
// soit le mot existe d�j� alors on ne fait rien et on retourne 		"rien � faire" -->  raf
// soit la table est pleine et on retourne 								"table pleine"	-->	tp
// soit on ajoute le pr�nom et on retourne 								"ajout�"		--> ajout
// tablenom est modifi� en fonction de l'op�ration effectu�e