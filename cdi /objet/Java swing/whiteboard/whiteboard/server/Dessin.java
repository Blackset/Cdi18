package whiteboard.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import whiteboard.Shape;

public class Dessin implements Iterable<Shape>, Serializable
{
	private int clientId; // reference du client
	private List<Shape> trait = new ArrayList<Shape>();
	
	public Dessin(int id)
	{
		if (id>0)
		{
			clientId = id;
		}
	}
	public int getId()
	{
		return clientId;
	}
	public void add(Shape s)
	{
		trait.add(s);
	}
	public void clear()
	{
		 trait.clear();
	}
	public void remove()
	{
		if (trait.size() >0)
		{
			trait.remove(trait.size()-1);
		}
	}
	public int size()
	{
		return trait.size();
	}
	public Iterator<Shape> iterator()
	{
		
		return trait.iterator();
	}
}
