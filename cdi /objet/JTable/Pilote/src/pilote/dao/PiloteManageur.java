
package pilote.dao;
import pilote.entity.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pilote.tools.*;
/**
 *
 * @author install
 */
public class PiloteManageur {
   public static ArrayList<Pilote> listePilotes()
   {
       try
       {
           Connection connex = Connexion.getInstance().creer("serveur-sql2008","AirEmilie","faret","faret");
       
           Statement cs = connex.createStatement();
           ResultSet rs = cs.executeQuery("select * from pilote");
           ArrayList<Pilote> vecPilote = new ArrayList<>();
           while( rs.next())
           {
               Pilote pi = new Pilote(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4));
               vecPilote.add(pi);
           }
           
           return vecPilote;
        }
        catch(Exception e)
        {
            return null;
        }
       
   }
   
   public static ArrayList<String> columnPilote()
   {
       try
       {
           Connection connex = Connexion.getInstance().creer("serveur-sql2008","AirEmilie","faret","faret");
       
           Statement cs = connex.createStatement();
           ResultSet rs = cs.executeQuery("select * from pilote");
           ArrayList<String> listPil = new ArrayList<>();
           int i = 1;
           while( i <= rs.getMetaData().getColumnCount())
           {
               listPil.add(rs.getMetaData().getColumnName(i));
               i++;
           }
           listPil.add("Action");
           return listPil;
        }
        catch(Exception e)
        {
            return null;
        }
   }
   
   
   public static void virerPilote(int id, Boolean vire)
   {
       try
       {
           Connection connex = Connexion.getInstance().creer("serveur-sql2008","AirEmilie","faret","faret");
       
           Statement cs = connex.createStatement();
           
           cs.executeUpdate("UPDATE PILOTE SET Vire = '" + vire + "' WHERE IdPilote = '" + id + "'");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }
   
   //Récupère le prénom des pilotes à mettre dans le combobox
   public static ArrayList<String> listePrenom()
   {
       try
       {
           Connection connex = Connexion.getInstance().creer("serveur-sql2008","AirEmilie","faret","faret");
       
           Statement cs = connex.createStatement();
           ResultSet rs = cs.executeQuery("select PrenomPilote from pilote");
           ArrayList<String> listPrenom = new ArrayList<>();
           while( rs.next())
           {
               listPrenom.add(rs.getString(1));
           }
           return listPrenom;
           
        }
        catch(Exception e)
        {
            return null;
        }
   }

    public static boolean changerPrenomPilote(int id, String prenom) {
        try
       {
           Connection connex = Connexion.getInstance().creer("serveur-sql2008","AirEmilie","faret","faret");
       
           Statement cs = connex.createStatement();
           int retour = cs.executeUpdate("update pilote set PrenomPilote = '"+prenom+"' where IdPilote = '"+id+"'");
           
           if ( retour != 1)
           {
               return false;
           }
            return true;   
               
           
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
