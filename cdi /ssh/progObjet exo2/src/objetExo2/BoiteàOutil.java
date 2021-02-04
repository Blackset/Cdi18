package objetExo2;

public class Boite‡Outil
{
	   public static boolean estAlpha (String mot)
		{
			if ( mot != null && mot.matches("^[\\p{L}]+$"))
			{
				return true;
			}
			else
			{
				return false;
			}	
	 }
	   
	   public static boolean estEntier (String s)
	   {
	       boolean Valide = true;
	       
	       try
	       {
	    	   Integer.parseInt(s); 
	       }
	       catch(Exception nfe)
	       {
	    	   Valide = false;
	       }
	       
	       return Valide;
	   }

	   public static int convertir (String num)
	   {
		   
			try
			{
				return Integer.parseInt( num);
			}
			catch (Exception e)
			{
				return 0;
			}	   
	   }
	    
	}
	
	
	
	
	
	
	
	


