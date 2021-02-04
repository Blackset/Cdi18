Calculer la somme de nombre en base quelconque
// Soit une chaine de caractères représentaant des nombres dans une base quelconque
// comprise entre 2 et 16.
// Soit b la base dans laquelle ces nombres sont écrits. 
// Le premier caractère zéro rencontré en début de nombre indique la fin de la chaîne de caractères à traiter.

// DONNEZ l'algorithme de la procédure qui, à partir de ces informations, donne l'entier 
// représentant la somme des nombres contenus dans cette chaîne.
 
Exemple :    14-203--9-0-				base b = 13 
Le calcul donnera un entier de valeur 
	1*13+7 + 2*13*13+0*13+3+9=20+341+9=370

	NOTE : 	- On sait que les informations contenues dans la chaîne de caractères sont corrects
			- Les nombres sont non signés
			- les débordements ne seront pas traités
			
			
			
Jeux D'ESSAIS
									base 13
Entrée								Sortie
14-203--9-0-						370
6004----123-0						6*13*13*13 + 4  + 1*13*13 + 2 *13 + 3
0									0
--------2-0							2
12----------0						1*13+2
------452---0						4*13*13 + 5*13 + 2		
01323---621-0						0			
20000-------0						2*13


Algorithme de principe

Programme    // Ce programme calcule la somme de nombres en base quelconque 
	
	ECRIRE (base entre 2 et  16 :)
	LIRE (base)
	ECRIRE (chaine de chiffres :)
	LIRE (chaineChiffre)
	
	chercherNombre
	Tantque premier chiffre du nombre <>0 Faire 
		compter les nombres   
		compter nombre de chiffres des mots   
		chercherNombre
	Fintantque 
	 
	Tantque tous les nombres -1 ne sont pas calculées Faire   
		chercherNombre 
		calculerBaseNombre
		calculerSomme
	Fintantque 
	
	
Programme inverserPhrase
//CONSTANTES
SEPARE = ' ' 	//séparateur de mots
N = 80 			//taille des chaines traitées

// Types
	chaine = tableau[N] caractères // types de chaines de caractères traitées
	
//VARIABLES
chaineChiffre : chaîne // phrase à traiter
b : entier  // base 
Somme : entier // résultat dans la base demandée

DEBUT
	ECRIRE ("Saisir une base entre 2 et 16 : ")
	LIRE ( b )   // base b
	
	ECRIRE ("Chaîne de chiffres séparée d'espace et zéro comme terminateur : ")
	LIRE ( chaineChiffre) // chaine de caractères à convertir
	
	calculBase (chaineChiffre, b, somme )   // retourne le calcul en base b

	ECRIRE ("Liste initiale :", chaineChiffre )
	ECRIRE ("Somme en base :", b ," est égale à : " somme) 

FIN





	
	
procédure chercherNombre (entrée chaineChiffre : chaine, entrée/sortie i : entier, sortie lg : entier)
	//Cette procédure permet de repérer un Chiffre à partir de la position i dans chaineChiffre.
	//chaineChiffre : phrase où nous cherchons le nombre
	//i -en entréé : point de départ pour chercher le nombre
	//	-en sortie : indice juste après le nombre
	//lg est la longueur du nombre trouvé, ou 0 si 0 isolé	
	
Début	
	tantque (chaineChiffre[i] = SEPARE) Faire
		//on s'arrête quand on trouve autre chose qu'un SEPARE
		i:=i+1		
	fintantque
	
	//initialisation
	lg := 0
	Si phrase[i]=0
		tantque (phrase[i]<>SEPARE) Faire
			//on s'arrête quand le caractère est un SEPARE
			lg := lg+1
			i:=i+1
		fintantque	
	Finsi
	
Fin	







procédure calculerBaseNombre (entrée chaineChiffre : chaine, entrée b : entier, entrée i : entier, entrée lg : entier, entrée/sortie somme : entier )					 
	//calcul les nombres dans une base donnée (b)
	// chaineChiffre est la chaine de caractères à traiter
	//i est l'indice juste après le nombre et dans chaineChiffre
	//lg est la longueur du nombre à calculer en base b
	
	//somme est le résultat du calcul en cours
	
	// on sait convertir un caractère en entier
	

Début
	
	somme_tampon:=0 // init à 0 pour additionner à somme en sortie
	i:=i-lg // on possitionne l'indice sur le premier caratère à traiter dans le sens de lecture
	
	tantque lg <> 0  faire
	
				somme_tampon := somme_tampon*b+Convertir.CharInt (chaineChiffre[i])
		
		i := i + 1	
		lg := lg - 1
	fintantque
	
	somme := somme+somme_tampon

Fin





Procédure Inverser
	
//CONSTANTES
SEPARE = ' ' 	//séparateur de mots
N = 80 			//taille des chaines traitées

//TYPES
	chaine = tableau[N] caractères // types de chaines de caractères traitées

//VARIABLES
chaineChiffre : chaîne // phrase à traiter
b : entier  // base 
Somme : entier // résultat dans la base demandé
i : entier  // indice dans phrase
lg : entier // longueur du nombre en cours de traitement
nbchiffres: // nombre de chiffre dans phrase

DEBUT

Programme    // calcul les nombres dans une base donnée (b)
Début // indice au début de la chaîne chaineChiffre et initialisation des compteurs  
 
i := 1
nbchiffres := 0
 
  // parcours de la phrase pour compter les mots et les caractères utiles  
 
chercherNombre ( chaineChiffre, i, lg )  // trouver un mot dans le phrase

TANTQUE  chaineChiffre[i-lg]<>0   Faire    // arrêt quand plus de mot et STOP   
		 nbchiffres := nbchiffres + 1   // compter des mots   
		 chercherNombre ( chaineChiffre, i, lg )  // trouver un mot dans le phrase 
Fintantque    
 
   // init indices au début de chaineChiffre  
 
i := 1  	// indice dans chaineChiffre 
somme := 0
 
TANTQUE  nbchiffres > 0  Faire // on traite tous les mots (si pas de mot en ecrit directement STOP
 
		  chercherNombre( chaineChiffre, i, lg )   // trouver un chiffre dans le phrase
		  calculerBaseNombre (chaineChiffre, b, i, lg, somme)   // calcul en base b du chiffre courant
		  nbchiffres := nbchiffres - 1 
			
 
 Fintantque   

 
FIN