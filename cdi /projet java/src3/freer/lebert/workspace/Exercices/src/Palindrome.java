
public class Palindrome
{
	public static void main(String[] argument)
	{
		String phrase; // phrase saisie

		System.out.print("Saisir une phrase : ");
		phrase = Lire.S();
		if (phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()
				.equals(new StringBuffer(phrase).reverse().toString().replaceAll("[^a-zA-Z0-9]", "").toLowerCase()))
		{
			System.out.print("C'est un palindrome.");
		}
		else
		{
			System.out.print("Ce n'est pas un palindrome.");
		}
	}
}
