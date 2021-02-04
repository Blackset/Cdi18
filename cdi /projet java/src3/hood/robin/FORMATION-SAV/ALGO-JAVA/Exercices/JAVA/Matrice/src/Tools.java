
public class Tools
{
	/**
	 * @param tabSaisie
	 *            Chaine de caractère a copier dans un tableau
	 * @return la copie de la chaine dans un tableau avec vérif du terminateur
	 */
	public static char[] copieTexte(String tabSaisie)
	{
		// déclaration d'une référence sur un tableau de char copie du tableau
		// saisie
		char[] tabCopie;
		// Création du tableau pour la copie
		tabCopie = new char[Constantes.TAILLETEXTE];

		int i = 0; // Indice de parcours de la chaine

		// arrêt quand l'indice est supérieur à tabSaisie ou à TAILLETEXTE
		// ou egale a CARACFIN
		while ((i < tabSaisie.length()) && (i < Constantes.TAILLETEXTE - 1)
				&& (tabSaisie.charAt(i) != Constantes.CARACFIN))
		{
			tabCopie[i] = tabSaisie.charAt(i);
			i++;
		}
		// On copie le point en fin de chaine
		tabCopie[i] = Constantes.CARACFIN;
		return tabCopie;
	}

	/**
	 * @param carac
	 *            le caractère à compter dans la chaine
	 * @param chaine
	 *            la chaine a vérifier
	 * @return le nombre d'occurence du caractère dans la chaine
	 */
	public static int compteOccurence(char carac, char[] chaine)
	{
		int i = 0; // Indice de parcours de la chaine
		int nbrOccurence = 0; // Nombre d'occurence contenu dans la chaine

		// arrêt quand plus de lettre à verifier
		while (i < chaine.length)
		{
			if (carac == chaine[i])
			{
				nbrOccurence++;
			}
			i++;
		}
		return nbrOccurence;
	}

	/**
	 * @param chaine
	 *            où l'on compte le nombre de lettre
	 * @return le nombre de lettre dans la chaine
	 */
	public static int compteLettre(char[] chaine)
	{
		int i = 0; // Indice de parcours de la chaine
		int nbrLettre = 0; // Nombre de lettre contenu dans la chaine

		// arret quand plus de lettre à compter
		while (i < chaine.length)
		{
			if ((((int) chaine[i] >= Constantes.ASCIIMINMAJ) && ((int) chaine[i] <= Constantes.ASCIIMAXMAJ))
					|| (((int) chaine[i] >= Constantes.ASCIIMINMIN) && ((int) chaine[i] <= Constantes.ASCIIMAXMIN)))
			{
				nbrLettre++;
			}
			i++;
		}

		return nbrLettre;
	}

	/**
	 * @param chaine
	 *            chaine terminé par un point
	 * @param caracOne
	 *            premier caractère de l'occurence à trouver
	 * @param caracTwo
	 *            deuxième caratère de l'occurence à trouver
	 * @return le nombre d'occurence des 2 caractères
	 */
	public static int compteOccurenceDouble(char[] chaine, char caracOne, char caracTwo)
	{
		int i = 0; // Indice de parcours de la chaine
		int nbrOccurence = 0; // Nombre d'occurence double dans la chaine

		// arrêt sur le caractère terminateur
		while (chaine[i] != Constantes.CARACFIN)
		{
			if (chaine[i] == caracOne)
			{
				if ((chaine[i + 1] == caracTwo) || (chaine[i + 1] != Constantes.CARACFIN))
				{
					nbrOccurence++;
					i++;
				}
			}
			i++;
		}

		return nbrOccurence;
	}

	/**
	 * @param chaine
	 *            chaine à controler
	 * @return si la chiane est un palindrome ou non
	 */
	public static boolean palindrome(char[] chaine)
	{
		int i = 0; // Indice de parcours de la chaine du début vers la fin
		int j = 0; // Indice de parcours de la chaine de la fin vers le début

		// arrêt sur le caractère terminateur
		while (chaine[j] != Constantes.CARACFIN)
		{
			j++;
		}

		j--; // parcours de la depuis la fin sans compter le caractère
				// terminateur

		// arrêt quand les indices se croisent ou quand les lettres sont
		// différentes
		while ((i < j) && (chaine[i] == chaine[j]))
		{
			i++;
			j--;
		}

		boolean palindrome = false; // Si la chaine est un palindrome

		// si les indices se croisent c'est un palindrome
		if (i >= j)
		{
			palindrome = true;
		}

		return palindrome;
	}

	/**
	 * @param tabEntier
	 *            tableau d'entier à trier
	 * @return tableau d'entier trier avec la methode de tri à bulles
	 */
	public static int[] triBulles(int[] tabEntier)
	{
		int i = 0; // indice de parcours du tableau d'entier
		int inverserOne = 1; // indique l’endroit de la première inversion
		int inverserTwo; // indique l’endroit de la dernière inversion ou -1
		int temp; // variable intermédiaire de copie
		int tailleTab = tabEntier.length - 1; // taille du tableau d'entier

		// arrêt quand il n’y a plus de nombre à trier
		while (tailleTab > 0)
		{
			inverserTwo = 0; // il n’y a pas encore d’inversion pour ce parcours
			i = inverserOne - 1; // début du nouveau parcours

			// si la première inversion se fait en début de table on remet i au
			// début
			if (i == -1)
			{
				i = 0;
			}
			do
			{
				// comparaison des éléments du tableau
				if (tabEntier[i] > tabEntier[i + 1])
				{
					temp = tabEntier[i];
					tabEntier[i] = tabEntier[i + 1];
					tabEntier[i + 1] = temp;
					// on récupère l'emplacement de la première inversion
					if (inverserTwo == 0)
					{
						inverserOne = i;
					}
					// on récupère l'emplacement de la dernière inversion
					inverserTwo = i;
				}
				i++;
			}
			while (i != tailleTab);
			// arrêt sur le dernier élément du tableau
			tailleTab = inverserTwo;
		}

		return tabEntier;
	}

	/**
	 * @param tabEntier
	 *            tableau d'entier positif trié
	 * @param entier
	 *            a rechercher dans le tableau d'entier
	 * @return l'indice de l'entier trouvé dans le tableau ou 0 si non trouvé
	 */
	public static int chercherDichotomie(int[] tabEntier, int entier)
	{
		// indice de parcours depuis le début de tableau
		int iStart = 0;
		// indice de parcours depuis la fin de tableau
		int iEnd = tabEntier.length - 1;
		// retourne l'indice si trouvé, 0 si non trouvé. Positionné sur l'indice
		// du milieu de tableau
		int result = (iStart + iEnd) / 2;

		// arrêt quand les indice se croise ou quand l'entier est trouvé
		while ((iStart <= iEnd) && (tabEntier[result] != entier))
		{
			if (tabEntier[result] > entier)
			{
				iEnd = result - 1; // zone du haut
			}
			else
			{
				iStart = result + 1; // zone du bas
			}
			result = (iStart + iEnd) / 2;
		}
		if (iStart > iEnd)
		{
			result = -1;
		}
		return result;
	}

	/**
	 * @param nbr
	 *            nombre dont on veut connaitre la valeur d'un bit
	 * @param rang
	 *            est le poid du bit que l'on veut connaitre
	 * @return le poid du bit demandé
	 */
	public static boolean valeurBit(int nbr, int rang)
	{
		boolean valbit; // valeur du bit

		if (rang < 0)
		{
			valbit = false;
		}
		else
		{
			while ((rang > 0) && (nbr != 0))
			{
				nbr = nbr / 2;
				rang--;
			}
			valbit = ((nbr % 2) == 1); // récupération du LSB de valnb
		}

		return valbit;
	}

	/**
	 * @param entier
	 *            nombre à comparer
	 * @param masque
	 *            masque de comparaison
	 * @return resultat du ET Logique
	 */
	public static int etLogique(int entier, int masque)
	{
		int resultat = 0;
		int poids = 1;

		// arrêt quand l'entier ou le masque est nul
		while ((masque != 0) && (entier != 0))
		{
			// quand les deux LSB sont à 1 on ajout le poid
			resultat = (masque % 2) * (entier % 2) * (poids + resultat);

			masque = masque / 2; // passage au bit suivant sur les deux entiers
			entier = entier / 2;
			poids = poids * 2; // passage au poids du bit suivant
		}

		return resultat;
	}

	/**
	 * @param chaine
	 *            chaine dans laquelle on cherche un mot
	 * @param mot
	 *            le mot à rechercher dans la chaine
	 * @return si le mot existe dans la chaine ou non
	 */
	public static boolean chercherMot(char[] chaine, String mot)
	{
		boolean exist = false; // le mot est trouvé
		int lMot; // longueur du mot sélectionné
		Entier indice = new Entier();
		do
		{
			// repérage d'un mot dans le texte
			lMot = prendreMot(chaine, indice);
			// se la longueur est correcte, on compare les mots
			if (lMot == mot.length())
			{
				exist = comparerMot(chaine, indice.getVal(), lMot, mot);
			}

		}
		while ((!exist) && (lMot != 0));
		// arrêt quand le mot est trouvé ou quand plus de mot

		return exist;

	}

	/**
	 * @param chaine
	 *            chaine de texte dans laquel on cherche un mot
	 * @param indice
	 *            du caractère situé juste après le mot
	 * @return la longueur du mot
	 */
	private static int prendreMot(char[] chaine, Entier indice)
	{

		// on se positionne au début de mot en sautant d'éventuels espace
		// arrêt quand le caractère n'est pas un ESPACE
		while (chaine[indice.getVal()] == Constantes.ESPACE)
		{
			indice.incr();
		}

		int lMot = 0; // Initialisation de la longueur du mot

		// arrêt quand le caractère est un ESPACE ou le CARACFIN
		while ((chaine[indice.getVal()] != Constantes.ESPACE) && (chaine[indice.getVal()] != Constantes.CARACFIN))
		{
			indice.incr();
			lMot++;
		}

		return lMot;
	}

	/**
	 * @param chaine
	 *            la chaine dans laquel on compare le mot
	 * @param indice
	 *            du caractère situé juste après le mot
	 * @param lMot
	 *            la longueur du mot
	 * @param mot
	 *            à comparer avec le mot de la chaine
	 * @return si les mots sont identiques ou non
	 */
	private static boolean comparerMot(char[] chaine, int indice, int lMot, String mot)
	{
		// indice sur le dernier caractère du mot
		indice--;

		// arrêt quand le mot est parcouru ou quand la longueur des mots est
		// différente
		while ((lMot != 0) && (chaine[indice] == mot.charAt(lMot - 1)))
		{
			indice--;
			lMot--;
		}

		return (lMot == 0);
	}

	/**
	 * @param chaine
	 *            la chaine à copier inversé
	 * @return la copie de la chiane avec les mots inversés
	 */
	public static char[] recopierInverser(char[] chaine)
	{
		// indice de parcours de la chaine d'entrée
		Entier indice = new Entier();
		// indice de la chaine inversé
		Entier indiceInv = new Entier();
		// chaine des mots inversés
		char[] chaineInverse = new char[Constantes.TAILLETEXTE];

		indice.setVal(0);
		indiceInv.setVal(0);

		int lg = prendreMot(chaine, indice);

		// arrêt quand la taille du mot pris vaut 0
		while (lg != 0)
		{
			inverserMot(chaine, indice.getVal(), lg, indiceInv, chaineInverse);

			lg = prendreMot(chaine, indice);

			if (lg != 0)
			{
				chaineInverse[indiceInv.getVal()] = Constantes.ESPACE;
				indiceInv.incr();
			}
		}

		chaineInverse[indiceInv.getVal()] = Constantes.CARACFIN;

		return chaineInverse;
	}

	/**
	 * @param chaine
	 *            la chaine dont on veut inverser les mots
	 * @param indice
	 *            l'indice juste après le mot
	 * @param lg
	 *            la longueur du mot
	 * @param indiceInv
	 *            l'indice de parcours de la chaine dans laquelle on copie les
	 *            mots inversés
	 * @param chaineInverse
	 *            la chaine où l'on copie les mots inversés
	 * @return la chaine avec les mots inversés
	 */
	private static char[] inverserMot(char[] chaine, int indice, int lg, Entier indiceInv, char[] chaineInverse)
	{
		indice--;
		// arrêt quand le mot est parcouru
		while (lg != 0)
		{
			chaineInverse[indiceInv.getVal()] = chaine[indice];
			indiceInv.incr();
			indice--;
			lg--;
		}

		return chaineInverse;
	}

	/**
	 * @param chaine
	 *            la chaine a justifier
	 * @return une copie de la chaine justifiée
	 */
	public static char[] justifier(char[] chaine)
	{
		Entier indice = new Entier(); // indice de parcours de la chaine
										// d'entrée
		int lg = prendreMot(chaine, indice);
		int nbrMot = 0;
		int nbrLettre = 0;

		// arrêt quand la taille du mot pris vaut 0
		while (lg != 0)
		{
			// parcours de la phrase pour calculer le nombre de caractères
			// utiles
			nbrMot++;
			nbrLettre = nbrLettre + lg;
			lg = prendreMot(chaine, indice);
		}
		int interval = 0;
		int reste = 0;
		// indice de parcours de la chaine justifiée
		Entier indiceJus = new Entier();

		// compte des intervalles entre les mot et des espaces restant à
		// repartir
		if (nbrMot > 1)
		{
			interval = (Constantes.TAILLETEXTE - nbrLettre - 1) / (nbrMot - 1);
			reste = (Constantes.TAILLETEXTE - nbrLettre - 1) % (nbrMot - 1);
		}
		// chaine des mots inversé
		char[] chaineJustifie = new char[Constantes.TAILLETEXTE];
		int nbrEspace = 0;

		indice.setVal(0);
		indiceJus.setVal(0);
		// arrêt quand plus de mot a traiter
		while (nbrMot != 0)
		{
			// parcours du texte en recopiant le texte justifié
			lg = prendreMot(chaine, indice);

			chaineJustifie = copierMot(chaine, indice.getVal(), lg, indiceJus, chaineJustifie);

			nbrMot--;

			// si il reste des mots on met des espaces
			if (nbrMot != 0)
			{
				nbrEspace = interval;
				// si il resete des espaces en trop
				if (reste != 0)
				{
					reste--;
					nbrEspace++;
				}
				// arrêt quand plus d'espace à copier
				while (nbrEspace != 0)
				{
					// on insert les espaces
					chaineJustifie[indiceJus.getVal()] = Constantes.ESPACE;
					indiceJus.incr();
					nbrEspace--;
				}

			}
		}

		chaineJustifie[indiceJus.getVal()] = Constantes.CARACFIN;

		return chaineJustifie;
	}

	/**
	 * @param chaine
	 *            la chaine a justifier
	 * @param indice
	 *            l'indice juste après le mot trouvé dans la chaine
	 * @param lg
	 *            la longueur du mot trouvé dans la chaine
	 * @param indiceJus
	 *            l'indice de parcours de la chaine justifiée
	 * @param chaineJustifie
	 *            la chaine dans laquelle nous justifions le texte
	 * @return la chaine justifiée
	 */
	private static char[] copierMot(char[] chaine, int indice, int lg, Entier indiceJus, char[] chaineJustifie)
	{
		// on positionne l'indice sur le premier caractère a copier
		indice = indice - lg;

		// arrêt quand le mot est parcouru
		while (lg != 0)
		{
			chaineJustifie[indiceJus.getVal()] = chaine[indice];
			indiceJus.incr();
			indice++;
			lg--;
		}

		return chaineJustifie;
	}

	/**
	 * @param chaine
	 *            la chaine de chiffre à calculer
	 * @param base
	 *            la base dans laquelle sont les chiffres
	 * @return le resultat du calcul de somme
	 */
	public static int calculerSomme(String chaine, int base)
	{
		Entier indice = new Entier();

		indice.setVal(0);
		int resultat = 0;

		do
		{
			// arrêt au début d'un nombre
			while (chaine.charAt(indice.getVal()) == Constantes.ESPACE)
			{
				// Recherche de début de nombre
				indice.incr();
			}

			int nombre = 0;

			// on calcul le nombre si ce n'est pas une fin de chaine
			if (chaine.charAt(indice.getVal()) != Constantes.FINBASE)
			{
				nombre = parcourirDecoder(chaine, indice, base);
				resultat += nombre;
			}
		}
		while (chaine.charAt(indice.getVal()) != Constantes.FINBASE);
		// arrêt quand on a le caractère de fin

		return resultat;
	}

	/**
	 * @param chaine
	 *            la chaine de chiffre à décoder
	 * @param indice
	 *            la position juste après le nombre décodé
	 * @param base
	 *            dans laquelle en encodé le chiffre
	 * @return le résultat de la somme
	 */
	private static int parcourirDecoder(String chaine, Entier indice, int base)
	{
		int valeur = 0;

		do
		{
			valeur = (valeur * base) + convertir(chaine.charAt(indice.getVal()));
			indice.incr();
		}
		while (chaine.charAt(indice.getVal()) != Constantes.ESPACE);
		// arrêt quand on a un espace
		return valeur;
	}

	/**
	 * @param carac
	 *            le caractère à convertir en entier
	 * @return le caractère converti en entier
	 */
	private static int convertir(char carac)
	{
		int val = 0;

		switch (Character.toUpperCase(carac))
		{
		case '0':
			val = 0;
			break;
		case '1':
			val = 1;
			break;
		case '2':
			val = 2;
			break;
		case '3':
			val = 3;
			break;
		case '4':
			val = 4;
			break;
		case '5':
			val = 5;
			break;
		case '6':
			val = 6;
			break;
		case '7':
			val = 7;
			break;
		case '8':
			val = 8;
			break;
		case '9':
			val = 9;
			break;
		case 'A':
			val = 10;
			break;
		case 'B':
			val = 11;
			break;
		case 'C':
			val = 12;
			break;
		case 'D':
			val = 13;
			break;
		case 'E':
			val = 14;
			break;
		default:
			val = 15;
			break;
		}

		return val;
	}

	/**
	 * @param tabEntier
	 *            la matrice à transposer
	 * @return un nouvelle matrice transposée
	 */
	public static int[][] transposeMatrice(int[][] tabEntier)
	{
		int[][] tabTranspose = new int[tabEntier[0].length][tabEntier.length];

		int i;
		int j = 0;

		// arrêt quand plus de colonne à remplir
		while (j < tabTranspose[0].length)
		{
			i = 0;
			// arrêt quand plus de ligne à remplir
			while ((i < tabTranspose.length))
			{
				tabTranspose[i][j] = tabEntier[j][i];
				i++;
			}
			j++;
		}
		return tabTranspose;
	}

	/**
	 * @param tabEntier
	 *            la matrice à afficher
	 */
	public static void afficherMatrice(int[][] tabEntier)
	{
		System.out.println();
		// arrêt quand le tableau d'entier est affiché
		for (int i = 0; i < tabEntier.length; i++)
		{
			// arrêt quand les colonne de la ligne sont pleine
			for (int j = 0; j < tabEntier[0].length; j++)
			{
				System.out.print(" | " + tabEntier[i][j]);
			}
			System.out.print(" | ");
			System.out.println();
		}
	}

	/**
	 * @return un entier positif
	 */
	public static int saisieEntier()
	{

		int taille;
		System.out.println();
		do
		{
			System.out.println();
			System.out.print("Saisissez un entier positif supérieur à 0 : ");
			taille = Lire.i();
		}
		while (taille < 0);
		// arrêt quand l'utilisateur à saisie une valeur supérieur à 0
		return taille;
	}

	/**
	 * @param tabEntier
	 *            la matrice à remplir
	 * @return la matrice pleine
	 */
	public static int[][] remplirMatrice()
	{
		// nombre de ligne de la matrice
				int tailleL = Tools.saisieEntier();
				// nombre de colonne de la matrice
				int tailleC = Tools.saisieEntier();

				// création de la matrice d'entier avec la taille défini par
				// l'utilisateur
				int[][] tabEntier = new int[tailleL][tailleC];

		// arrêt quand le tableau d'entier est plein
		for (int i = 0; i < tabEntier.length; i++)
		{
			// arrêt quand les colonne de la ligne sont pleine
			for (int j = 0; j < tabEntier[0].length; j++)
			{

				tabEntier[i][j] = i * 2 + j;
			}
		}
		return tabEntier;
	}
}
