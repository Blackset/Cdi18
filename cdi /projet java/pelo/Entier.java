public class Entier
{
	// cette classe permet d'encapsuler une valeur 
	// en un objet pour le passage de paramètres
	private int val=0;
	public int getVal()
	{
		return val;	
	}
	public void setVal(int valeur)
	{
		val = valeur;	
	}
	public void incr()
	{
		val++;
	}
	public void decr()
	{
		val--;
	}
}
