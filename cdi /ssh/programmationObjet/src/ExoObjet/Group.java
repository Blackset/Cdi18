package ExoObjet;


public class Group
{	 
	public static final int MAX  = 20;  	
	private int m_nCpt;                    // compte le nombre d'individu d'un groupe
	private Individu[] m_tTab;


	public Group (int nombreIndividu)	       //constructeur
	{
		if ( nombreIndividu > 0 && nombreIndividu < MAX )
		{
			m_nCpt = 0;
			m_tTab = new Individu [nombreIndividu];
		}
		else		
		{
			m_nCpt = 0;
			m_tTab = new Individu [MAX];
		}   	   	
	}    	   
	public Group()   // par defaut  
	{ 	
		m_nCpt = 0;
		m_tTab = new Individu [MAX];
	}

	/**
	 * cette fonction demande à l'utilisateur le nombre maximun d'Iindividus composant
	 * le groupe puis chaque individu
	 * @param 
	 * @return 
	 */		
	public void lire() 
	{  
		int i = getNb();

		if (isNotFull())
		{
			do 		 			   
			{  				
				m_tTab[i] = new Individu();                             // initialisation de chaque case du tableau  
				m_tTab[i].lire();
				setCpt(); i++;

			} while (isNotFull() && Saisie.veutContinuer());	
		}
	}

	/**
	 * cette fonction affiche les caractéristiques de l'Individu
	 * @param aucun
	 * @return aucun
	 */

	public void afficher ()
	{

		for (int i = 0;  i < getNb(); i++) 
		{
			m_tTab[i].afficher();  
		}
	}

	private boolean setCpt()
	{
		if ( isNotFull())
		{
			m_nCpt ++; 
			return true;
		}
		else
		{
			return false;
		}    	 
	}
	/**
	 * cette fonction compte le nombre d'individu effectivement dans le groupe
	 * @param  
	 * @return 
	 */

	private int  getNb()
	{
		return  m_nCpt;    	 
	}

	private int getMax()    
	{
		return m_tTab.length;    	 
	}


	private boolean isNotFull()
	{
		return getNb() < getMax();
	}

	/**
	 * cette fonction retourne une référence dans une case de tableau Individus
	 * @param i
	 * @return référence Individu
	 */

	public Individu individuAt(int i)
	{
		if ( i > 0 &&  i < getNb())
		{
			return m_tTab [i];
		}
		else
		{
			return null;
		}		  
	}

}
