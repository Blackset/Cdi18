
public class Dialogue
{
	public static boolean veutContinuer() {
		System.out.print("Voulez-vous continuer ? ");
		switch(Lire.c()) {
		case 'O': case 'o':
			return true;
		case 'N' : case 'n':
			return false;
		default:
			return veutContinuer();
		}
	}
}
