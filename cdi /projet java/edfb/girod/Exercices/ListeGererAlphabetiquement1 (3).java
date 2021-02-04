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

Interface proc�dure init_tablenom
Proc�dure init_tablenom ( Sortie tablenom : table )  // vider la table
  // Initialise la table, (aucun �l�ment, vide) 
  // tablenom est notre table initialis�e           
D�but      // Aucun �l�ment dans la table 
 
 tablenom.libre := 1
 tablenom.premier := final // 0
 
  // construction de libre1, libre2, libre3, libre4 etc...
  // on g�n�re une liste de libre en incr�mentant tabnom.libre 
 
 tablenom.libre := 1  
	 Tantque    tablenom.libre <> tailtable    Faire  // jusqu'� 100
				// cr�ation de la liste des N �l�ments libres    
	 tablenom.table [ tablenom.libre ].suivant := tablenom.libre + 1  
	 tablenom.libre := tablenom.libre + 1 
 Fintantque 
 // fin liste libre
  tablenom.table [ tablenom.libre ].suivant := final 
 // d�but liste libre
 tablenom.libre := 1
Fin 




Interface proc�dure ajouternom    
Proc�dure ajouternom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : entier )  //
// on ajoute un pr�nom dans la table
// soit le pr�nom existe d�j� alors on ne fait rien et on retourne "rien � faire" --> -1
// soit la table est pleine et on retourne "table pleine"	--> 0
// soit on ajoute le pr�nom et on retourne "ajout�"		--> 1
// tablenom est modifi� ou pas en fonction de l'ajout du pr�nom

D�but      // Aucun �l�ment dans la table 

SI  tablenom.premier = 0  // si la table est vide  ( les 3 modfifs) 
SI  tablenom.libre <> 0 alors // si la table est pleine on ne fait rien
SI	

SI  

sinon

Finsi

 
 
Fin 












//A FAIRE
Interface proc�dure enlevernom     
Proc�dure enlevernom ( entr�e Sortie tablenom : table,  entr�e nom : chainenom , sortie : entier )  //


