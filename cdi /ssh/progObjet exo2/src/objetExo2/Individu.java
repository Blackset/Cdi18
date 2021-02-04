package objetExo2;


public class Individu
{
	private String  m_strNom;
	private String  m_strPrénom;
	private String  m_strNomrue; 
	private String  m_strVille;
	private int     m_nNumRue;
	private int     m_nCodePostal;		 
	/**
	 * cette fonction fournie le nom de la Rue 
	 * @param nomRue est le nouveau nom de la Rue
	 */	  	 
	public String getNomRue()
	{
		return m_strNomrue ;
	}	 	 	  	 
	/**
	 * cette fonction fournie le nom de la Rue de l'Individu
	 * @param nomRue est le nouveau nom de la Rue
	 * @return la fonction retourne vrai si la Rue existe
	 */
	public boolean setNomRue(String nomRue)
	{
		if ( nomRue != null)
		{
			this.m_strNomrue = nomRue;
			return true;
		}
		else 
		{
			return false;
		}
	}	 	 
	/**
	 * cette fonction fournie la ville 
	 * @param ville est la nouvelle ville
	 */
	public String getVille()
	{
		return m_strVille;
		/**
		 * cette fonction fournie la ville de l'Individu
		 * @param ville est la nouvelle ville
		 * @return la fonction retourne vrai si la ville existe
		 */
	} 	 
	public boolean setVille(String ville)
	{
		if (  ville != null)
		{
			this.m_strVille = ville;
			return true;
		}
		else 
		{
			return false;
		}
	}	 
	/**
	 * cette fonction fournie le numero de Rue de l'Individu 
	 * @param numero de Rue est le nouveau numero de Rue
	 */

	public int getNumRue()
	{
		return m_nNumRue ;
	}

	public boolean setNumRue (String numrue)
	{
		numrue = numrue.trim();
		if (BoiteàOutil.estEntier(numrue)) 
		{	
			return setNumRue(BoiteàOutil.convertir(numrue));
		}
		else 
		{
			return false;
		}	  
	} 		 
	/**
	 * cette fonction fournie le numero de Rue de l'Individu 
	 * @param numero de Rue est le nouveau numero de Rue
	 * @return la fonction retourne vrai si le numero de Rue existe
	 */	 	 
	private boolean setNumRue(int numrue)
	{
		if (numrue>0)
		{
			this.m_nNumRue = numrue;
			return true;
		}
		else 
		{
			return false;
		}
	}	 
	/**
	 * cette fonction fournie le code postal de l'Individu 
	 * @param code postal est le nouveau code postal
	 */	 	 	 	
	public int getCodePostal()
	{
		return m_nCodePostal ;
	}
	/**
	 * cette fonction fournie le code postal de l'Individu 
	 * @param code postal est le nouveau code postal
	 * @return la fonction retourne vrai si le code postal existe
	 */

	private boolean setCodePostal (String codepostal)
	{
		codepostal = codepostal.trim();
		if ( BoiteàOutil.estEntier (codepostal) && codepostal.length() == 5)
		{	
			return setCodePostal(BoiteàOutil.convertir(codepostal));
		}
		else 
		{
			return false;
		}		  
	} 	 

	public boolean setCodePostal(int codepostal)
	{
		if ( codepostal >0)
		{
			this.m_nCodePostal = codepostal;
			return true;
		}
		else 
		{
			return false;
		}
	}	 
	/**
	 * cette fonction fournie l'adresse de l'Individu 
	 * @param adresse est la nouvelle adresse
	 */	 
	public String getAdresse()
	{
		return getNumRue()+" "+  getNomRue() +" "+  getVille()+" "+ getCodePostal()+" ";
	}
	/**
	 * cette fonction fournie l'adresse de l'Individu 
	 * @param adresse est la nouvelle adresse
	 * @return la fonction retourne vrai si l'adresse existe
	 */	 
	public boolean setAdresse(String adresse)
	{
		String tab[] = adresse.split(",");
		if ( adresse!= null && tab.length == 4 )
		{
			if (setNumRue(tab[0])&& setNomRue(tab[1])&& setVille(tab[2])&& setCodePostal(tab[3]))
			{
				return true;
			}								
			else 				 
			{
				return false;
			}							
		}
		else 
		{
			return false;
		}				 
	}	 	  		 

	public String getNom()
	{
		return m_strNom ;
	}
	/**
	 * cette fonction fournie le nom de l'Individu 
	 * @param prénom est le nouveau nom
	 * @return la fonction retourne vrai si le nom existe
	 */
	public boolean setNom (String nom)
	{
		if ( BoiteàOutil.estAlpha(nom))
		{
			this.m_strNom = nom;
			return true;
		}

		else
		{
			return false;
		}
	}	   
	public String getPrénom()
	{
		return  m_strPrénom;
	}
	/**
	 * cette fonction fournie le prénom de l'Individu 
	 * @param prénom est le nouveau prénom
	 * @return la fonction retourne vrai si le prénom existe
	 */

	public boolean setPrénom (String prénom)
	{
		if ( BoiteàOutil.estAlpha(prénom))
		{
			this.m_strPrénom = prénom;
			return true;
		}
		else
		{
			return false;
		}

	}

	public void lire ()
	{
		boolean phraseJuste;
		do
		{ 	
			System.out.println("Entrez le nom de l'employer");
			phraseJuste = setNom(Lire.S());
			if(!phraseJuste)
			{
				System.out.println("vous n'avez pas saisi le bon nom de l'employer");
			}		
		}

		while (!phraseJuste);

		do 
		{
			System.out.println("Entrez le prénom de l'employer");
			phraseJuste = setPrénom(Lire.S());
			if(!phraseJuste)
			{
				System.out.println("vous n'avez pas saisi le bon prénom de l'employer");
			}			
		}
		while (!phraseJuste);

		do
		{
			System.out.println("Entrez votre numero de rue");
			phraseJuste = setNumRue(Lire.S());
			if(!phraseJuste)
			{
				System.out.println("vous n'avez pas saisi le bon numéro de rue");
			}			
		}
		while (!phraseJuste);

		do
		{
			System.out.println("Entrez votre nom de la Rue");
			phraseJuste = setNomRue(Lire.S());
			if(!phraseJuste)
			{
				System.out.println("vous n'avez pas saisi le bon nom de la Rue");
			}			
		}
		while (!phraseJuste);

		do
		{
			System.out.println("Entrez votre Ville");
			phraseJuste = setVille(Lire.S());
			if(!phraseJuste)
			{
				System.out.println("vous n'avez pas saisi le bon nom de la Ville");
			}			
		}
		while (!phraseJuste);


		System.out.println("Entrez votre code postal");
		String phrase = Lire.S();
		while (! setCodePostal (phrase) )
		{
			System.out.println("Erreur de saisie !");

			System.out.println("Entrez votre code postal");
			phrase = Lire.S();
		}

	}
	public void afficher() 
	{
		System.out.println (getNom()+" "+ getPrénom()+" "+   getAdresse());
	}


}
















