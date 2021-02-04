Justifier une phrase
// Soit une phrase de 80 caract�res termin�e par un point. 
// Donnez l'algorihme du programme qui justifie cette phrase.
// La justification d'une phrase consiste � r�partir les mots sur la totalit� de la phrase
// en r�partissant �quitablement les espaces entre les mots. Si il reste des espaces, ils seront rajout�s aux premiers intervalles.

JEUX D�ESSAI : justifier une phrase 
 
-Les----chaussures-et-les-chaussettes---d'albert---sont--vertes--trop-grandes------.   80

Les---chaussures---et---les---chaussettes---d'albert---sont---vertes--trop--grandes.   80        


Programme    // Ce programme justifie une phrase   

Constantes

	N=80			// Nbre maximum de carat�res dans la cha�ne
	FINCHAINE='.' 	// Caract�re de fin de cha�ne
	BLANC=' '		// Espace dans la phrase
	
Types
	Phrase=tableau [N] caract�res // type de cha�ne de caract�res

Variables
	Mot : cha�ne	// chaine de carat�res du mot � trouver
	Longueur	: entier	// Longueur du mot � trouver
	iCour : entier // indice du prochain mot � comparer
	Fini : Bool�en // vrai si on atteint le terminateur
	Existe : Bool�en // vrai si le mot est dans la phrase
	

	
PROCEDURE ComparerMot (Entr�e Mot: chaine , Entr�e Longueur: entier , Entr�e iCour : entier, Sortie Existe: Bool�en )
// Mot est le mot � rechercher
// Longueur est la longueur du mot recherch�
// iCour est l'indice du prochain mot � comparer
// Existe est le r�sultat � VRAI si le mot existe

PROCEDURE SauterEspaces (Entr�e Entr�e iCour : entier, Sortie Fini : Bool�en )
// iCour est l'indice courant
// Fini  vrai si on atteint le terminateur

PROGRAMME
Constantes
	N=80			// Nbre maximum de carat�res dans la cha�ne
	FINCHAINE='.' 	// Caract�re de fin de cha�ne
	BLANC=' '		// Espace dans la phrase
	
Types
	Phrase=tableau [N] caract�res // type de cha�ne de caract�res

Variables
	Mot : cha�ne	// chaine de carat�res du mot � trouver
	Longueur	: entier	// Longueur du mot � trouver
	iCour : entier // indice du prochain mot � comparer
	Fini : Bool�en // vrai si on atteint le terminateur
	Existe : Bool�en // vrai si le mot est dans la phrase

DEBUT
	// Chercher un mot dans une phrase
	
	iCour:=1  // init de l'indice
	EXISTE:=FALSE // init de EXISTE
	FINI:=FALSE // init de FINI
	
	ECRIRE ("Entrez votre phrase avec terminateur. :")
	LIRE (Phrase)
	ECRIRE ("Entrez le mot recherch� :)
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
		ECRIRE ("Le mot recherch� n'existe pas dans cette phrase.)
	FINSI

FIN

PROCEDURE ComparerMot (Entr�e Mot: chaine , Entr�e Longueur: entier , Entr�e iCour : entier, Sortie Existe: Bool�en )
// Mot est le mot � rechercher
// Longueur est la longueur du mot recherch�
// iCour est l'indice du prochain mot � comparer
// Existe est le r�sultat � VRAI si le mot existe

DEBUT
i:=1
	
	TANTQUE  Phrase[Icour]<>BLANC ET Phrase[Icour]<>FINCHAINE  // on sort � la fin d'un mot
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


PROCEDURE SauterEspaces (Entr�e Entr�e iCour : entier, Sortie Fini : Bool�en )
// iCour est l'indice courant
// Fini  vrai si on atteint le terminateur

DEBUT
	TANTQUE NON FINI ET NON BLANC       // On passe les blancs tant que NON FINI ou nouveau caract�re
		SI Phrase[Icour]==BLANC
			iCour:=iCour+1
		ELSE
			IF Phrase[Icour]==FINCHAINE
				FINI                      // le mot n'existe pas
			FINSI
		FINSI								// on continue la recherche
	FINTANTQUE    
FIN
	
	
	