import java.awt.Color;
import java.util.Vector;

//Fichier : DonneeGraphe.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class DonneeGraphe
{
	private TypeGraphe type;
	private Vector<Portion> vPortion;
	private Vector<DonneesListener> vListener = new Vector<DonneesListener> (10,2);
	
	public DonneeGraphe(TypeGraphe t)
	{
		vPortion = new Vector<Portion> (10,2);
		type = t;
	}
	
	public Portion getPortion(int ind)
	{
		return vPortion.elementAt(ind);
	}
	
	public void setType(TypeGraphe t)
	{
		type = t;
		fireDonneesChanged();
	}
	
	public TypeGraphe getType()
	{
		return type;
	}
	
	public float getPortionPercentage(int ind)
	{
		int total = 0;
		float res;
		for (int i = 0; i< vPortion.size(); i++)
		{
			total = total + getPortion(i).getValeur();
		}
		if (total != 0)
		{
			res = (float) getPortion(ind).getValeur() / (float) total;
			return res*360;
		}
		else
			return 0;
	}
	
	public int taille()
	{
		return vPortion.size();
	}
	
	public void addPortion(Portion p)
	{
		vPortion.addElement(p);
		fireDonneesChanged();
	}
	
	public void removePortion(Portion p)
	{
		vPortion.removeElement(p);
		fireDonneesChanged();
	}
	
	// modifie le portion de l'index ind au nouveau portion p
	public boolean modifiePortion(Portion p, int ind)
	{
		if (ind >=0  && ind < vPortion.size())
		{
			vPortion.setElementAt(p, ind);
			fireDonneesChanged();
			return true;
		} 
		return false;
	}
	
	public void modifieValeur(int ind, int val)
	{
		if (vPortion.elementAt(ind)!= null)
		{
			vPortion.elementAt(ind).setValeur(val);
			fireDonneesChanged();
		}
	}
	
	public void modifieColor(int ind, Color c)
	{
		if (vPortion.elementAt(ind)!= null)
		{
			vPortion.elementAt(ind).setColor(c);
			fireDonneesChanged();
		}
	}
	
	public void modifieLegende(int ind, String l)
	{
		if (vPortion.elementAt(ind)!= null)
		{
			vPortion.elementAt(ind).setLegende(l);
			fireDonneesChanged();
		}

	}
	
	public  void addDonneesListener(DonneesListener dl)
	{
		if (dl!= null)
			vListener.addElement(dl);
	}
	
	public  void removeDonneesListener(DonneesListener dl)
	{
		vListener.removeElement(dl);
	}
	
	private void fireDonneesChanged()
	{
		DonneesEvent ce = new DonneesEvent(this);
		for (DonneesListener dl : vListener)
		{
			dl.donneesChanged(ce);
		}
	}
	

}
