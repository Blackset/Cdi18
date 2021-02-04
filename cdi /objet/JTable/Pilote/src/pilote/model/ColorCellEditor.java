/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author jcc
 */
public class ColorCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private Color couleur;
    private final JButton bouton;
    private final JColorChooser colorChooser;
    private final JDialog dialog;
 
    public ColorCellEditor() {
        super();
 
        bouton = new JButton();
        bouton.setActionCommand("change");
        bouton.addActionListener(this);
 
        colorChooser = new JColorChooser();
        // attention, ici l'écouteur ( this) sera abonné au bouton OK du JColorChooser
        dialog = JColorChooser.createDialog(bouton, "Choisissez votre couleur", true, colorChooser, this, null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("change".equals(e.getActionCommand())) {
            // ici le bouton de couleur a été actionné
            bouton.setBackground(couleur);
            colorChooser.setColor(couleur);
            dialog.setVisible(true);
 
            fireEditingStopped(); // redemande au rendu de redessiner la table
        } else {
            // ici le bouton OK du JColorChooser a été actionné
            couleur = colorChooser.getColor();
        }
     }
 
    @Override
    public Object getCellEditorValue() {
        return couleur;
    }
 
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        couleur = (Color)value;
 
        return bouton;
    }
}

