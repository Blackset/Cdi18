/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.model;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jcc
 */
public class RenduCheck extends JCheckBox implements TableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object check, boolean isSelected, boolean hasFocus,int row, int column)
    {
        setHorizontalAlignment(JCheckBox.CENTER);

        //Permet d'afficher un bouton activé
        this.setSelected((Boolean)check);
        this.setOpaque(true);
            if ((row + column)%2 == 0) 
            {
                this.setBackground(Color.ORANGE);
            }
            else
            {
                this.setBackground(Color.GRAY);
            }   
        return this;
    }

}

