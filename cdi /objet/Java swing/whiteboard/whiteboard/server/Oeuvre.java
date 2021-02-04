package whiteboard.server;

import java.io.Serializable;
import java.util.ArrayList;

public class Oeuvre extends ArrayList<Dessin> implements Serializable
{
	public Dessin remove(int i)
	{
		int j = 0;
		for ( Dessin d : this)
		{
			if (d.getId() == i)
			{
				return super.remove(j);
			}
			else
			{
				j++;
			}
		}
		return null;
	}
	public Dessin gett(int i)
	{
		int j = 0;
		for ( Dessin d : this)
		{
			if (d.getId() == i)
			{
				return get(j);
			}
			else
			{
				j++;
			}
		}
		return null;
	}
	
}
