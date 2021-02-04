package fenetre;
import java.awt.Graphics;
import java.util.Vector;

import fabrique.Fantome;

public class Groupe
{
	private final static int INITIAL_CAPACITY = 10;
	private final static int CAPACITY_INCREMENT = 1;
		
	private Vector<Fantome> m_lVector;

	/**
	 * @return the initialCapacity
	 */
	public int getInitialCapacity()
	{
		return INITIAL_CAPACITY;
	}
		
	public boolean deletLastLine()
	{
		boolean ok=false;
		if ( m_lVector.size()!=0)
		{
			ok=true;
			m_lVector.remove(m_lVector.size()-1);
		}
		return ok;
	}
	
	public void addLine(Fantome l)
	{
		if (getCount()<INITIAL_CAPACITY)
		{
			m_lVector.addElement(l);	
		}		
	}

	public void deletAllLine()
	{
		m_lVector.clear();
	}
	
	public Groupe()
	{
		m_lVector = new Vector<Fantome>(INITIAL_CAPACITY,CAPACITY_INCREMENT);
	}

	
	/**
	 * @return the m_nCount
	 */
	public int getCount()
	{
		return m_lVector.size();
	}

	
	public void paint(Graphics g)
	{		
		for (Fantome l : m_lVector)
		{
			l.paint(g);
		}			
	}

	
}
