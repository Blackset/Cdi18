/*  Classe      : ValeurBit
    Auteur      : Yann Capelli	
    Mise � jour : 18 Ocotbre 2016
    Fonction    : calcul la valeur du x i�me bit d'un entier
*/
public class ValeurBit
{			
	public static void main(String[] argument)
	{
		int nombre ;		// Nombre que l'ont recherche
		int numeroBit;		// Numero du bit recherch�
		boolean valeurBit;	// Valeur du bit recherch�
		
		System.out.println("Donner le nombre :");
		nombre = Lire.i();
		System.out.println("Donner le rang du bit recherch� :");
		numeroBit = Lire.i();
		valeurBit = rechercherBit (numeroBit,nombre);
		if (valeurBit)
		{
			System.out.println("La valeur du bit num�ro : "+numeroBit+" dans l'entier "+nombre+" est 1");
		}
		else
		{
			System.out.println("La valeur du bit num�ro : "+numeroBit+" dans l'entier "+nombre+" est 0");
		}
	}		
	
	public static boolean rechercherBit ( int numeroBit , int nombre)
	{
		// Proc�dure qui recherche la valeur du Bit NumeroBit dans le tableau Tab
		// NumeroBit est l'indice du bit recherch�
		// Nombre est l'entier dont on veut connaitre la valeur du bit de rang NumeroBit
		// ValeurBit est la valeur du bit NumeroBit
		boolean valeurBit;
		while (numeroBit>0 && nombre!=0)
		{
			nombre = nombre / 2;
			numeroBit --;
		}
		valeurBit = ((nombre % 2)==1);
		return (valeurBit);
	}
}