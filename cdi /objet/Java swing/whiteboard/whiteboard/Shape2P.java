package whiteboard;

import java.awt.Point;

public abstract class Shape2P extends Shape
{
    private Point m_start;
    private Point m_end;

	public Shape2P(Point start)
	{
		super( start);
		// TODO Auto-generated constructor stub
	}
    protected Point getStart()
    {
        return m_start;
    }
  
    protected Point getEnd()
    {
        return m_end;
    }

   
    public boolean setEnd(Point end)
    {
    	if (end == null)
    	{
    		end = new Point();
    	}

        m_end = end;
        
        return true;
    }

    protected boolean setStart(Point start)
    {
        if ( start == null)
        {
        	start = new Point();
        }

        m_start = start;
        
        return true;
    }

}
