import javax.swing.tree.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

public class ExprCellEditor implements TreeCellEditor
{
	EditeurCombo ec;
	EditeurTextField etf;
	CellEditor editeurCourant;
	static final String[] operateurs = {"+","-","*","/"};
	public ExprCellEditor(Arbre a)
	{
		ec = new EditeurCombo(operateurs);
		etf = new EditeurTextField();
		ec.setFont(new Font("Monospace",Font.PLAIN,14));
		etf.setFont(new Font("Monospace",Font.PLAIN,14));
		editeurCourant = etf;
	}
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row)
	{
		if (!leaf && ((Noeud)value).getOuvert())
		{
			editeurCourant = ec;
			ec.setSelectedItem(((Noeud)value).getOperateur());
		}
		else
		{
			editeurCourant = etf;
			etf.setText(value.toString());
		}
		return (Component)editeurCourant;
	}
	public Object getCellEditorValue()
	{
		return editeurCourant.getCellEditorValue();
	}
	public boolean isCellEditable(EventObject eo)
	{
		return editeurCourant.isCellEditable(eo);
	}
	public boolean shouldSelectCell(EventObject eo)
	{
		return editeurCourant.shouldSelectCell(eo);
	}
	public boolean stopCellEditing()
	{
		return editeurCourant.stopCellEditing();
	}
	public void cancelCellEditing()
	{
		editeurCourant.cancelCellEditing();
	}
	public void addCellEditorListener(CellEditorListener l)
	{
		ec.addCellEditorListener(l);
		etf.addCellEditorListener(l);
	}
	public void removeCellEditorListener(CellEditorListener l)
	{
		ec.removeCellEditorListener(l);
		etf.removeCellEditorListener(l);
	}
}