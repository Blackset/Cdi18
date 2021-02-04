package whiteboard.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import whiteboard.client.WhiteBoardObserver;

public class Ecouteur extends ArrayList<WhiteBoardObserver>
{
	public WhiteBoardObserver remove(int i)
	{
		int j = 0;
		for ( WhiteBoardObserver d : this)
		{
			try
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
			catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public WhiteBoardObserver gett(int i)
	{
		int j = 0;

		for ( WhiteBoardObserver d : this)
		{
			try
			{
				if (d.getId() == -1)
            	{
            		remove(d);
            		Registry r = LocateRegistry.getRegistry();
            		try
					{
						d = (WhiteBoardObserver) r.lookup("observer"+i);
					}
					catch (NotBoundException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		add(d);
            	}

				if (d.getId() == i)
				{

					return super.get(j);
				}
				else
				{
					j++;
				}
			}
			catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
