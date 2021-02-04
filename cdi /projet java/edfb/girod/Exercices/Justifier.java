Justifier une phrase
// Soit une phrase de 80 caractères terminée par un point. 
// Donnez l'algorihme du programme qui justifie cette phrase.
// La justification d'une phrase consiste à répartir les mots sur la totalité de la phrase
// en répartissant équitablement les espaces entre les mots. Si il reste des espaces, ils seront rajoutés aux premiers intervalles.

JEUX D’ESSAI : justifier une phrase 
 
-Les----chaussures-et-les-chaussettes---d'albert---sont--vertes--trop-grandes------.   80

Les---chaussures---et---les---chaussettes---d'albert---sont---vertes--trop--grandes.   80        


Programme    // Ce programme justifie une phrase   

Constantes

	N=80			// Nbre maximum de caratères dans la chaîne
	FINCHAINE='.' 	// Caractère de fin de chaîne
	BLANC=' '		// Espace dans la phrase
	
Types
	Phrase=tableau [N] caractères // type de chaîne de caractères

Variables
	Mot : chaîne	// chaine de caratères du mot à trouver
	Longueur	: entier	// Longueur du mot à trouver
	iCour : entier // indice du prochain mot à comparer
	Fini : Booléen // vrai si on atteint le terminateur
	Existe : Booléen // vrai si le mot est dans la phrase
	

	
PROCEDURE ComparerMot (Entrée Mot: chaine , Entrée Longueur: entier , Entrée iCour : entier, Sortie Existe: Booléen )
// Mot est le mot à rechercher
// Longueur est la longueur du mot recherché
// iCour est l'indice du prochain mot à comparer
// Existe est le résultat à VRAI si le mot existe

PROCEDURE SauterEspaces (Entrée Entrée iCour : entier, Sortie Fini : Booléen )
// iCour est l'indice courant
// Fini  vrai si on atteint le terminateur

PROGRAMME
Constantes
	N=80			// Nbre maximum de caratères dans la chaîne
	FINCHAINE='.' 	// Caractère de fin de chaîne
	BLANC=' '		// Espace dans la phrase
	
Types
	Phrase=tableau [N] caractères // type de chaîne de caractères

Variables
	Mot : chaîne	// chaine de caratères du mot à trouver
	Longueur	: entier	// Longueur du mot à trouver
	iCour : entier // indice du prochain mot à comparer
	Fini : Booléen // vrai si on atteint le terminateur
	Existe : Booléen // vrai si le mot est dans la phrase

DEBUT
	// Chercher un mot dans une phrase
	
	iCour:=1  // init de l'indice
	EXISTE:=FALSE // init de EXISTE
	FINI:=FALSE // init de FINI
	
	ECRIRE ("Entrez votre phrase avec terminateur. :")
	LIRE (Phrase)
	ECRIRE ("Entrez le mot recherché :)
	LIRE (Mot)
	
	TANTQUE NON FINI OU NON EXISTE  FAIRE
	
			ComparerMot ( Mot, Longueur, iCour, Existe)
			SI NON EXISTE ET NON FINI
				SauterEspaces ( iCour, Fini)
			FINSI
	
	Fintantque
	
	SI EXISTE ALORS
		ECRIRE ("Le mot est dans la phrase.")
	ELSE
		ECRIRE ("Le mot recherché n'existe pas dans cette phrase.)
	FINSI

FIN

PROCEDURE ComparerMot (Entrée Mot: chaine , Entrée Longueur: entier , Entrée iCour : entier, Sortie Existe: Booléen )
// Mot est le mot à rechercher
// Longueur est la longueur du mot recherché
// iCour est l'indice du prochain mot à comparer
// Existe est le résultat à VRAI si le mot existe

DEBUT
i:=1
	
	TANTQUE  Phrase[Icour]<>BLANC ET Phrase[Icour]<>FINCHAINE  // on sort à la fin d'un mot
		SI Phrase[Icour]==Mot[i]
				i:=i+1 
				iCour:=iCour+1
				EXISTE
		ELSE
			NON EXISTE
		FINSI 
		
				IF Phrase[Icour]==FINCHAINE
						FINI                      // le mot n'existe pas
				FINSI
	FINTANTQUE                                   // soit EXISTE soit FINI soit sur BLANC

FIN


PROCEDURE SauterEspaces (Entrée Entrée iCour : entier, Sortie Fini : Booléen )
// iCour est l'indice courant
// Fini  vrai si on atteint le terminateur

DEBUT
	TANTQUE NON FINI ET NON BLANC       // On passe les blancs tant que NON FINI ou nouveau caractère
		SI Phrase[Icour]==BLANC
			iCour:=iCour+1
		ELSE
			IF Phrase[Icour]==FINCHAINE
				FINI                      // le mot n'existe pas
			FINSI
		FINSI								// on continue la recherche
	FINTANTQUE    
FIN
	
	
	