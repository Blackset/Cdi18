Recopier une phrase en inversant chaque mot.
//Soit une phrase terminée par un point. 
 //Donnez l'algorithme de la procédure qui inverse chacun des mots de cette phrase 
 // et qui rend le résultat dans une deuxième phrase.
 // Cette deuxième phrase comportera un espace entre deux mots et le point final
 // sera cadré le plus à gauche possible. 
 
Exemple :    le#chat##est###gris#####. 
Donnera      el#tahc#tse#sirg.      (un seul espace entre les mots)


Jeux d'ESSAI
Entrée							Sortie
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
	 
	Tantque tous les mots ne sont pas inversés Faire   
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
SEPARE = ' ' 	//séparateur de mots
N = 80 			//taille des chaines traitées

// Types
	chaine = tableau[N] caractères // types de chaines de caractères traitées
	
//VARIABLES
phrase : chaîne // phrase à triter
phraseinversée : chaîne // phrase inversée

DEBUT
	ECRIRE ("Saisir une phrase avec un terminateur : ", STOP)
	LIRE ( Phrase)
	
	Inverser (phrase, phraseinversée )   // retourne la phrase inversée

	ECRIRE ("Phrase initiale :", phrase )
	ECRIRE ("Phrase inversée :", phraseInversée )

FIN





	
	
procédure chercherMot(entrée phrase : chaine, entrée/sortie i : entier, sortie lg : entier)
	//Cette procédure permet de repérer un mot à partir de la position i dans la phrase.
	//phrase : phrase où nous cherchons le mot
	//i -en entréé : point de départ pour chercher le mot
	//	-en sortie : indice juste après le mot, ou sur le point
	//lg est la longueur du mot trouvé, ou 0 si plus de mot	
	
Début	
	tantque (phrase[i] = SEPARE) Faire
		//on s'arrête quand on trouve autre chose qu'un SEPARE
		i:=i+1		
	fintantque
	
	//initialisation
	lg := 0
	
	tantque (phrase[i]<>STOP) et (phrase[i]<>SEPARE) Faire
		//on s'arrête quand le caractère est un STOP ou un SEPARE
		lg := lg+1
		i:=i+1
	fintantque	
Fin	







procédure inverserMot(entrée phrase : chaine, entrée i : entier, entrée lg : entier,
					 entrée/sortie phraseInversée : chaineinversée, entrée/sortie j : entier)					 
	//posionne un mot de la phrase dans la phraseInversée
	//i est l'indice juste après le mot et dans la phrase
	//lg est la longueur du mot à inverser
	
	//phraseinversée -en entrée : portion de phrase déjà inversée
	//				-en sortie : portion de phrase déjà inversée plus le mot inversée
	//j : -en entrée : indice où nous écrirons le mot inversée
	//	  -en sortie : indice après le mot inversée	

	

Début
	
	tantque lg <> 0  faire
	// arrêt quand le mot est copié
	
		phraseInversée[j] := phrase [i]   // copie d'un caractère		
		i := i - 1	
		j := j + 1
		lg := lg - 1
		
	fintantque
Fin

Procédure Inverser
	
//CONSTANTES
STOP = '.' 		//terminateur de phrase
SEPARE = ' ' 	//séparateur de mots
N = 80 			//taille des chaines traitées

//TYPES
chaine = tableau de [N] caractères 			//types des phrases

//VARIABLES
i : entier  // indice dans phrase
j : entier  // indice dans phrasejustifiée
lg : entier // longueur du mot en cours de traitement
nbmots : // nombre de mot dans phrase
nblettres  : entier // nombre de lettres dans toute la phrase
intervalle : entier // nombre d'espace à ecrire

DEBUT

Programme    // Ce programme inverse une phrase   
Début // indice au début de la chaîne phrase et initialisation des compteurs  
 
i := 1
nbmots := 0
nblettres := 0 
 
  // parcours de la phrase pour compter les mots et les caractères utiles  
 
chercherMot ( phrase, i, lg )  // trouver un mot dans le phrase

TANTQUE  lg <> 0    Faire    // arrêt quand plus de mot et STOP   
		 nbmots := nbmots + 1   // compter des mots   
		 nblettres := nblettres + lg  // compter des caractères utiles   
		 chercherMot ( phrase, i, lg )  // trouver un mot dans le phrase 
Fintantque    
 
   // init indices au début de phrase et phrasejustifiée  
 
 i := 1  	// indice dans phrase 
 j := 1    // indice dans phrase inversée  
 intervalle:= nbmots - 2  // on a un blanc de - que le nombre de mots ( - tour de recherche vide )
 
TANTQUE  nbmots > 0  Faire // on traite tous les mots (si pas de mot en ecrit directement STOP
 
		  chercherMot ( phrase, i, lg )   // trouver un mot dans le phrase
		  inverserMot (phrase, i , lg , phraseInversée, j)   // posionne un mot de la phrase dans la phraseInversée
		  nbmots := nbmots - 1 
		 
		   // traitement des espaces entre les mots  
		 
			Si    intervalle > 0    Alors  // on met un SEPARE aprés le mot  
					phraseInversée [ j ] := SEPARE
					intervalle:=intervalle - 1
			Finsi 
 
 Fintantque   
 
   // terminateur dans la phrase inversée  
 phraseInversée [ j ] := STOP
 
FIN
