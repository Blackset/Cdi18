
public class Multiple {
	
	public static void main(String [] argument){
		
		int X;
		int N;
		System.out.println ();
		System.out.print( "Entier a tester :");
		X = Lire.i();
		System.out.print("Nombre de multiple :");
		N = Lire.i();
		
		for (int i= 0; i <=N-1; i=i+1 )
		{System.out.println ("premiers multiples de "+X +" est: "+i*X);}
	}

}

