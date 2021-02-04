Recopier une phrase en inversant chaque mot.
//Soit une phrase termin�e par un point. 
 //Donnez l'algorithme de la proc�dure qui inverse chacun des mots de cette phrase 
 // et qui rend le r�sultat dans une deuxi�me phrase.
 // Cette deuxi�me phrase comportera un espace entre deux mots et le point final
 // sera cadr� le plus � gauche possible. 
 
Exemple :    le#chat##est###gris#####. 
Donnera      el#tahc#tse#sirg.      (un seul espace entre les mots)


Jeux d'ESSAI
Entr�e							Sortie
le#chat##est###gris#####.		el#tahc#tse#sirg.
.								.
######.							.
##############le.				el.
le.								el.
le#####.						el.
le########chat#######gris.		el#thac#sirg.


Algorithme de principe

Programme    // Ce programme recopie une phrase en inversant chaque mot  
	
	chercherMot
	Tantque longueur du mot non nulle Faire   
		compter les mots   
		compter nombre de lettres des mots   
		chercherMot 
	Fintantque 
	 
	le nombre d'intervalle est le nombre de mots - 1
	 
	Tantque tous les mots ne sont pas invers�s Faire   
		chercherMot   
		inverserMot
			si ce n'est pas le dernier mot
				ecrire espace
			fin si
	Fintantque 
	mettre le point
	
	
Programme inverserPhrase
//CONSTANTES
STOP = '.' 		//terminateur de phrase
SEPARE = ' ' 	//s�parateur de mots
N = 80 			//taille des chaines trait�es

// Types
	chaine = tableau[N] caract�res // types de chaines de caract�res trait�es
	
//VARIABLES
phrase : cha�ne // phrase � triter
phraseinvers�e : cha�ne // phrase invers�e

DEBUT
	ECRIRE ("Saisir une phrase avec un terminateur : ", STOP)
	LIRE ( Phrase)
	
	Inverser (phrase, phraseinvers�e )   // retourne la phrase invers�e

	ECRIRE ("Phrase initiale :", phrase )
	ECRIRE ("Phrase invers�e :", phraseInvers�e )

FIN





	
	
proc�dure chercherMot(entr�e phrase : chaine, entr�e/sortie i : entier, sortie lg : entier)
	//Cette proc�dure permet de rep�rer un mot � partir de la position i dans la phrase.
	//phrase : phrase o� nous cherchons le mot
	//i -en entr�� : point de d�part pour chercher le mot
	//	-en sortie : indice juste apr�s le mot, ou sur le point
	//lg est la longueur du mot trouv�, ou 0 si plus de mot	
	
D�but	
	tantque (phrase[i] = SEPARE) Faire
		//on s'arr�te quand on trouve autre chose qu'un SEPARE
		i:=i+1		
	fintantque
	
	//initialisation
	lg := 0
	
	tantque (phrase[i]<>STOP) et (phrase[i]<>SEPARE) Faire
		//on s'arr�te quand le caract�re est un STOP ou un SEPARE
		lg := lg+1
		i:=i+1
	fintantque	
Fin	







proc�dure inverserMot(entr�e phrase : chaine, entr�e i : entier, entr�e lg : entier,
					 entr�e/sortie phraseInvers�e : chaineinvers�e, entr�e/sortie j : entier)					 
	//posionne un mot de la phrase dans la phraseInvers�e
	//i est l'indice juste apr�s le mot et dans la phrase
	//lg est la longueur du mot � inverser
	
	//phraseinvers�e -en entr�e : portion de phrase d�j� invers�e
	//				-en sortie : portion de phrase d�j� invers�e plus le mot invers�e
	//j : -en entr�e : indice o� nous �crirons le mot invers�e
	//	  -en sortie : indice apr�s le mot invers�e	

	

D�but
	
	tantque lg <> 0  faire
	// arr�t quand le mot est copi�
	
		phraseInvers�e[j] := phrase [i]   // copie d'un caract�re		
		i := i - 1	
		j := j + 1
		lg := lg - 1
		
	fintantque
Fin

Proc�dure Inverser
	
//CONSTANTES
STOP = '.' 		//terminateur de phrase
SEPARE = ' ' 	//s�parateur de mots
N = 80 			//taille des chaines trait�es

//TYPES
chaine = tableau de [N] caract�res 			//types des phrases

//VARIABLES
i : entier  // indice dans phrase
j : entier  // indice dans phrasejustifi�e
lg : entier // longueur du mot en cours de traitement
nbmots : // nombre de mot dans phrase
nblettres  : entier // nombre de lettres dans toute la phrase
intervalle : entier // nombre d'espace � ecrire

DEBUT

Programme    // Ce programme inverse une phrase   
D�but // indice au d�but de la cha�ne phrase et initialisation des compteurs  
 
i := 1
nbmots := 0
nblettres := 0 
 
  // parcours de la phrase pour compter les mots et les caract�res utiles  
 
chercherMot ( phrase, i, lg )  // trouver un mot dans le phrase

TANTQUE  lg <> 0    Faire    // arr�t quand plus de mot et STOP   
		 nbmots := nbmots + 1   // compter des mots   
		 nblettres := nblettres + lg  // compter des caract�res utiles   
		 chercherMot ( phrase, i, lg )  // trouver un mot dans le phrase 
Fintantque    
 
   // init indices au d�but de phrase et phrasejustifi�e  
 
 i := 1  	// indice dans phrase 
 j := 1    // indice dans phrase invers�e  
 intervalle:= nbmots - 2  // on a un blanc de - que le nombre de mots ( - tour de recherche vide )
 
TANTQUE  nbmots > 0  Faire // on traite tous les mots (si pas de mot en ecrit directement STOP
 
		  chercherMot ( phrase, i, lg )   // trouver un mot dans le phrase
		  inverserMot (phrase, i , lg , phraseInvers�e, j)   // posionne un mot de la phrase dans la phraseInvers�e
		  nbmots := nbmots - 1 
		 
		   // traitement des espaces entre les mots  
		 
			Si    intervalle > 0    Alors  // on met un SEPARE apr�s le mot  
					phraseInvers�e [ j ] := SEPARE
					intervalle:=intervalle - 1
			Finsi 
 
 Fintantque   
 
   // terminateur dans la phrase invers�e  
 phraseInvers�e [ j ] := STOP
 
FIN
