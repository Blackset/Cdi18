/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author jcc
 */
public class EditeurBoutonTable extends DefaultCellEditor
{      
    private JButton button;
    private final ButtonListener bListener = new ButtonListener();
        
  // Constructeur avec une checkBox ( c'est par defaut! ), ici la checkbox ne nous sert à rien !!!
    public EditeurBoutonTable(JCheckBox checkBox) 
    {
        //Par défaut, ce type d'objet travaille avec un JCheckBox
        super(checkBox);
        //On crée à nouveau notre bouton
        button = new JButton("Virer");
        button.setOpaque(true);
        //On lui attribue un listener
        button.addActionListener(bListener);
    }
   //  ici c’est le comportement qui est défini.
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                           boolean isSelected, int row, int column) 
    { 
        //On définit le numéro de ligne à notre listener
        bListener.setRow(row);
        //Ici on se moque du numéro de colonne
        //On passe aussi le tableau pour des actions potentielles
        bListener.setTable(table);
        
        //On renvoie le bouton
        return button;
    }
        
    // écouteur qui nous donne ce qu’il faut faire quand le bouton est appuyé
    class ButtonListener implements ActionListener
    {
        private int row;
        private JTable table;
                 
        public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}
                 
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            // 1. recuperer le modele de donnees de table
            TableModel tm = table.getModel();
            // modifier le booléen virer à faux sur cette ligne
            tm.setValueAt(Boolean.TRUE,  row, 3); // je mets la valeur de la colonne 3 à faux
                      
            stopCellEditing(); // force la remise à jour de la table
            
        }
    }
          
}

