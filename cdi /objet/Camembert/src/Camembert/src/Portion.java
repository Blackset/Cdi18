import java.awt.Color;

//Fichier : Portion.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class Portion
{
	private Color couleur;
	private String legende;
	private int valeur;
	
	
	public Portion(Color c, String l, int val)
	{
		couleur = c;
		legende = l;
		valeur = val;
	}
	

	public void setColor (Color c)
	{
		couleur = c;
	}
	
	public void setLegende(String l)
	{
		legende = l;
	}
	
	public void setValeur(int val)
	{
		valeur = val;
	}
	
	public Color getColor ()
	{
		return couleur;
	}
	
	public String getLegende()
	{
		return legende;
	}
	
	public int getValeur()
	{
		return valeur;
	}
}
