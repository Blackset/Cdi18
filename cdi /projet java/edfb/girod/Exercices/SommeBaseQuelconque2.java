Calculer la somme de nombre en base quelconque
// Soit une chaine de caract�res repr�sentaant des nombres dans une base quelconque
// comprise entre 2 et 16.
// Soit b la base dans laquelle ces nombres sont �crits. 
// Le premier caract�re z�ro rencontr� en d�but de nombre indique la fin de la cha�ne de caract�res � traiter.

// DONNEZ l'algorithme de la proc�dure qui, � partir de ces informations, donne l'entier 
// repr�sentant la somme des nombres contenus dans cette cha�ne.
 
Exemple :    14-203--9-0-				base b = 13 
Le calcul donnera un entier de valeur 
	1*13+7 + 2*13*13+0*13+3+9=20+341+9=370

	NOTE : 	- On sait que les informations contenues dans la cha�ne de caract�res sont corrects
			- Les nombres sont non sign�s
			- les d�bordements ne seront pas trait�s
			
			
			
Jeux D'ESSAIS
									base 13
Entr�e								Sortie
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
	 
	Tantque tous les nombres -1 ne sont pas calcul�es Faire   
		chercherNombre 
		calculerBaseNombre
		calculerSomme
	Fintantque 
	
	
Programme inverserPhrase
//CONSTANTES
SEPARE = ' ' 	//s�parateur de mots
N = 80 			//taille des chaines trait�es

// Types
	chaine = tableau[N] caract�res // types de chaines de caract�res trait�es
	
//VARIABLES
chaineChiffre : cha�ne // phrase � traiter
b : entier  // base 
Somme : entier // r�sultat dans la base demand�e

DEBUT
	ECRIRE ("Saisir une base entre 2 et 16 : ")
	LIRE ( b )   // base b
	
	ECRIRE ("Cha�ne de chiffres s�par�e d'espace et z�ro comme terminateur : ")
	LIRE ( chaineChiffre) // chaine de caract�res � convertir
	
	calculBase (chaineChiffre, b, somme )   // retourne le calcul en base b

	ECRIRE ("Liste initiale :", chaineChiffre )
	ECRIRE ("Somme en base :", b ," est �gale � : " somme) 

FIN





	
	
proc�dure chercherNombre (entr�e chaineChiffre : chaine, entr�e/sortie i : entier, sortie lg : entier)
	//Cette proc�dure permet de rep�rer un Chiffre � partir de la position i dans chaineChiffre.
	//chaineChiffre : phrase o� nous cherchons le nombre
	//i -en entr�� : point de d�part pour chercher le nombre
	//	-en sortie : indice juste apr�s le nombre
	//lg est la longueur du nombre trouv�, ou 0 si 0 isol�	
	
D�but	
	tantque (chaineChiffre[i] = SEPARE) Faire
		//on s'arr�te quand on trouve autre chose qu'un SEPARE
		i:=i+1		
	fintantque
	
	//initialisation
	lg := 0
	Si phrase[i]=0
		tantque (phrase[i]<>SEPARE) Faire
			//on s'arr�te quand le caract�re est un SEPARE
			lg := lg+1
			i:=i+1
		fintantque	
	Finsi
	
Fin	







proc�dure calculerBaseNombre (entr�e chaineChiffre : chaine, entr�e b : entier, entr�e i : entier, entr�e lg : entier, entr�e/sortie somme : entier )					 
	//calcul les nombres dans une base donn�e (b)
	// chaineChiffre est la chaine de caract�res � traiter
	//i est l'indice juste apr�s le nombre et dans chaineChiffre
	//lg est la longueur du nombre � calculer en base b
	
	//somme est le r�sultat du calcul en cours
	
	// on sait convertir un caract�re en entier
	

D�but
	
	somme_tampon:=0 // init � 0 pour additionner � somme en sortie
	i:=i-lg // on possitionne l'indice sur le premier carat�re � traiter dans le sens de lecture
	
	tantque lg <> 0  faire
	
				somme_tampon := somme_tampon*b+Convertir.CharInt (chaineChiffre[i])
		
		i := i + 1	
		lg := lg - 1
	fintantque
	
	somme := somme+somme_tampon

Fin





Proc�dure Inverser
	
//CONSTANTES
SEPARE = ' ' 	//s�parateur de mots
N = 80 			//taille des chaines trait�es

//TYPES
	chaine = tableau[N] caract�res // types de chaines de caract�res trait�es

//VARIABLES
chaineChiffre : cha�ne // phrase � traiter
b : entier  // base 
Somme : entier // r�sultat dans la base demand�
i : entier  // indice dans phrase
lg : entier // longueur du nombre en cours de traitement
nbchiffres: // nombre de chiffre dans phrase

DEBUT

Programme    // calcul les nombres dans une base donn�e (b)
D�but // indice au d�but de la cha�ne chaineChiffre et initialisation des compteurs  
 
i := 1
nbchiffres := 0
 
  // parcours de la phrase pour compter les mots et les caract�res utiles  
 
chercherNombre ( chaineChiffre, i, lg )  // trouver un mot dans le phrase

TANTQUE  chaineChiffre[i-lg]<>0   Faire    // arr�t quand plus de mot et STOP   
		 nbchiffres := nbchiffres + 1   // compter des mots   
		 chercherNombre ( chaineChiffre, i, lg )  // trouver un mot dans le phrase 
Fintantque    
 
   // init indices au d�but de chaineChiffre  
 
i := 1  	// indice dans chaineChiffre 
somme := 0
 
TANTQUE  nbchiffres > 0  Faire // on traite tous les mots (si pas de mot en ecrit directement STOP
 
		  chercherNombre( chaineChiffre, i, lg )   // trouver un chiffre dans le phrase
		  calculerBaseNombre (chaineChiffre, b, i, lg, somme)   // calcul en base b du chiffre courant
		  nbchiffres := nbchiffres - 1 
			
 
 Fintantque   

 
FIN