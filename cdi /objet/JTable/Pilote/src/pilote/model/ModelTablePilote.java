/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilote.model;

import java.awt.Color;
import pilote.dao.PiloteManageur;
import pilote.entity.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author faret
 */
public class ModelTablePilote extends AbstractTableModel
{
    private final ArrayList<Pilote> listePilote;
    private final ArrayList<String> listeColonne;

    public ModelTablePilote()
    {
        listePilote = PiloteManageur.listePilotes() ;
        listeColonne = PiloteManageur.columnPilote();
        listeColonne.add("Couleur");
    }
    
    @Override
    public int getRowCount()
    {
        return listePilote.size();
    }

    @Override
    public int getColumnCount()
    {
        return listeColonne.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pilote pil = listePilote.get(rowIndex);
        switch (columnIndex)
        {
            case 0 : return pil.getNumero();        
            case 1 : return pil.getNom();  
            case 2 : return pil.getPrenom();
            case 3 : return pil.getVire();
            case 5 : return pil.getCouleurCheveux();
                //Ne doit pas être nul car on ne peut pas ajouter un objet null
            default : return "";
        }
    }

    @Override
    public String getColumnName(int column)
    {

        return listeColonne.get(column);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if (aValue instanceof Boolean && columnIndex == 3)
        {
            //Récupère un pilote dans la JTable
            Pilote pil = listePilote.get(rowIndex);
            pil.setVire((Boolean) aValue);
            //Préviens tout le monde du changement
            fireTableCellUpdated(rowIndex, columnIndex);
            fireTableCellUpdated(rowIndex, 4); // mettre à jour également la colonne des boutons
        }
        else if ( columnIndex == 2)
        {
            Pilote pil = listePilote.get(rowIndex);
            pil.setPrenom((String)aValue);
            
            //Préviens tout le monde du changement
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        else if (columnIndex == 5)
        {
            Pilote pil = listePilote.get(rowIndex);
            pil.setCouleurCheveux((Color)aValue);
            
            //Préviens tout le monde du changement
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex == 2 || columnIndex== 3 || columnIndex==5 ||
                (columnIndex==4 && getValueAt(rowIndex, 3)== Boolean.FALSE); 
            // ici les 4 dernières colonnes sont éditables, et seulemnt les boutons de la 4
    }

   @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class clas = String.class;
        if (columnIndex == 3) // colonne de notre JCheckBox
        {
            clas = Boolean.class; // ainsi le JCheckBox est pris en compte pour l’apparence de la colonne
        }
        if ( columnIndex == 5)
        {
            clas = Color.class;
        }
        return clas;
    }


    
    
    
    
    
}
