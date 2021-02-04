import java.util.*;

public class ClassementComparator implements Comparator<Classement>
{
	public int compare(Classement cl1, Classement cl2)
	{
		int valeur = Integer.toString(cl1.tours).compareTo(Integer.toString(cl2.tours));
		if (valeur == 0)
		{
			valeur = Double.toString(cl1.temps).compareTo(Double.toString(cl2.temps));
		}
		return valeur;
	}
}
