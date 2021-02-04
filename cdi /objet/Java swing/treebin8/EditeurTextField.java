import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class EditeurTextField extends JTextField implements CellEditor
{
	private Vector ecouteur = new Vector();
	private static final int minWidth= 64;
	
	public EditeurTextField()
	{
		this("",5);
	}
	public EditeurTextField(int w)
	{
		this("",w);
	}
	public EditeurTextField(String s)
	{
		this(s,5);
	}
	public EditeurTextField(String s, int w)
	{
		super(s,w);
		// ecoutons nous pour savoir quand retourner le r�sultat
		addActionListener(new ActionListener()
				{
			public void actionPerformed( ActionEvent ae)
			{
				if ( stopCellEditing()) { fireEditingStopped();}
			}
				});
	}
	public Object getCellEditorValue()
	{
		return getText();
	}
	public boolean isCellEditable(EventObject eo)
	{
		if ( eo == null || ((eo instanceof MouseEvent)&&((MouseEvent)eo).getButton()== MouseEvent.BUTTON1 )&& ((MouseEvent)eo).getClickCount()==2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean shouldSelectCell(EventObject anEvent)
	{
		return true;
	}
	public boolean stopCellEditing()
	{
		return true;
	}
	public void cancelCellEditing()
	{
		setText("");
	}
	public void addCellEditorListener(CellEditorListener l)
	{
		ecouteur.addElement(l);
	}
	public void removeCellEditorListener(CellEditorListener l)
	{
		ecouteur.removeElement(l);
	}
	private void fireEditingStopped()
	{
		if ( ecouteur.size()>0)
		{
			ChangeEvent ce = new ChangeEvent(this);
			for ( int i = 0; i < ecouteur.size();i++)
			{
				((CellEditorListener)ecouteur.elementAt(i)).editingStopped(ce);
			}
		}
	}
	// refaire les setBounds pour avoir assez de place
	public void setBounds(Rectangle r)
	{
		r.width = Math.max(minWidth, r.width );
		super.setBounds(r);
	}
	public void setBounds(int x, int y, int w, int h)
	{
		w = Math.max(minWidth, w );
		super.setBounds(x,y,w,h);
	}
}