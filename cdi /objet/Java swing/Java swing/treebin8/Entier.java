public class Entier
{
	// cette classe permet de passer un entier en paramètre de sortie
	private int val = 0;
	public Entier(int vale)
	{
		val = vale;
	}
	public void setVal(int j)
	{
		val = j;
	}
	public int getVal()
	{
		return val;
	}
	public String toString()
	{
		return new Integer(val).toString();
	}
}

