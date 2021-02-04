package pilote.tools;

import java.sql.Connection;
import java.sql.SQLException;

public class Connexion
{
	private static Connexion instance;
	private static Connection conn;
	
	private Connexion() {}
	
	public static synchronized Connexion getInstance()
	{
		try
		{
			if (instance == null || conn.isClosed())
				instance = new Connexion();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			instance = null;
		}
		return instance;
	}
	
	public Connection creer(String serveur, String db, String login, String pswd)
	{
		String url = "jdbc:sqlserver://"+ serveur + ":1433; databaseName = " + db + ";";
		try
		{
			conn = java.sql.DriverManager.getConnection(url, login, pswd);
		}
		catch (Exception e)
		{
			System.out.println("Connexion �chou�e !\r> " + e.getMessage());
		}
		return conn;
	}
	
	public void close()
	{
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
