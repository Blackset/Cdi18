import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Essai {
	public static void main(String [] arg)
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//	Connection co = DriverManager.getConnection("jdbc:odbc:toto", "Rodrigues", "Rogerio");
			
		 String url =  "jdbc:sqlserver://serveur-sql2008:1433" +
		                   ";databaseName=mfcat;";
		 Connection con = java.sql.DriverManager.getConnection(url,
				 "visiteur", "visiteur");
		 Statement st= con.createStatement();
	     ResultSet rs = st.executeQuery("select * from articles");
	     while (rs.next())
	     {
	    	 String s = rs.getString(1);
	    	 System.out.println(s);
	     }
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
