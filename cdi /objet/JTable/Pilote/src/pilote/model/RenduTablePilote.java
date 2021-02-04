/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.model;

import pilote.dao.PiloteManageur;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author faret
 */
public class RenduTablePilote implements TableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component compo = null;
        if ( column != 2 || (column == 4 && table.getModel().getValueAt(row, 3)== Boolean.TRUE))
        {
            String texte;
            
            texte = value.toString();
            compo = new JLabel(texte);
            ((JLabel) compo).setOpaque(true);
         
        
            if ((row + column)%2 == 0) 
            {
                compo.setBackground(Color.ORANGE);
            }
            else
            {
                compo.setBackground(Color.GRAY);
            }
        }
        if (column == 2)
        {
            compo = new JComboBox();
            ArrayList<String> lp = PiloteManageur.listePrenom();
            for (String prenom : lp)
            {
                ((JComboBox) compo).addItem(prenom);
            }
            //Permet de sélectionner le prénom du pilote concerné
            ((JComboBox<String>)compo).setSelectedItem(value);
            table.getColumn("PrenomPilote").setCellEditor(new DefaultCellEditor((JComboBox) compo));  

        }
        if ( column == 4 && table.getModel().getValueAt(row, 3)== Boolean.FALSE) 
        // ici je ne mets un button que si le pilote n'est pas viré
        {
           
            compo = new JButton("Virer");
        }

        // si column == 3 le type du modèle de table donne un checkbox par defaut
        return compo;
    }
    
}
