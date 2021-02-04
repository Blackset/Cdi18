import java.awt.*;

//Fichier : ObjGraphe.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class ControlGraphe
{
	private DonneeGraphe donnees;
	private VueGraphe vue;
	
	public ControlGraphe()
	{		
		// par defaut, je cree un graphe de type camembert
		donnees = new DonneeGraphe(TypeGraphe.camembert);
		vue = new VueGraphe(donnees);
	}
	
	public void addPortion(Portion p)
	{
		donnees.addPortion(p);
	}
	
	public void deletePortion(Portion p)
	{
		donnees.removePortion(p);
	}
	
	// modifie le portion de l'index ind au nouveau portion p
	public boolean modifiePortion(Portion p, int ind)
	{
		return donnees.modifiePortion(p, ind);

	}
	
	public void modifieValeur(int ind, int val)
	{
		donnees.modifieValeur(ind, val);
	}
	
	public void modifieColor(int ind, Color c)
	{
		donnees.modifieColor(ind, c);
	}
	
	public void modifieLegende(int ind, String l)
	{
		donnees.modifieLegende(ind, l);

	}
	
	public VueGraphe creerPanelGraphe()
	{
		if (vue != null)
		{
			vue.creerPanelGraphe();
		}
		
		return vue;
	}
	
	
	public void setTypeGraphe(TypeGraphe t)
	{
		donnees.setType(t);
		vue.setType(t);
	}
	
	public void setTitre(String l)
	{
		vue.setTitre(l);
	}
}
