import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Fichier : MaFrame.java
//Auteur : abonnenc
//Date : 27 juin 2011
//Role du fichier
public class MaFrame extends Frame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5449301750930787694L;

	public MaFrame()
	{
		EcouteurFenetre ef = new EcouteurFenetre();
		addWindowListener(ef);

		ControlGraphe cG = new ControlGraphe();
		

		Portion p1 = new Portion(new Color(255,0,0), "Alarme neuve", 1);
		Portion p2 = new Portion(new Color(0,255,0), "Alarme PEC", 3);
		Portion p3 = new Portion(new Color(255,0,255), "Alarme Soldé", 4);
		cG.addPortion(p1);
		cG.addPortion(p2);
		cG.addPortion(p3);
		cG.setTitre("Statistiques des alarmes");
		
		VueGraphe g = cG.creerPanelGraphe();
		add(g);

		setBounds(200,200,400,300);
		setVisible(true);

		Boolean continuer = true;
		char c;
		String l;
		int val;
		
		while (continuer)
		{
			System.out.println("ajouter portion :  A ou terminer . ou changer Type T");
			c = Lire.c();
			if (c == '.')
				continuer = false;
			else if (c == 'A')
			{
				System.out.println("libellé :  ");
				l = Lire.Chaine();
				System.out.println("valeur :  ");
				val = Lire.Entier();
				Portion p = new Portion(new Color((int)(Math.random() * 0xFFFFFF)), l, val);
				cG.addPortion(p);
			} else if (c == 'T')
			{
				System.out.println("type de graphe Historgramme : H ou Camembert : C  ");
				c = Lire.c();
				if (c == 'H')
				{

					cG.setTypeGraphe(TypeGraphe.histogramme);
				}
				else if (c == 'C')
				{

					cG.setTypeGraphe(TypeGraphe.camembert);

				}
			}
		}

	}
	
	public class EcouteurFenetre implements  WindowListener
	{
		public void windowClosing(WindowEvent evt)
		{
			System.exit(0);
		}
		
		public void windowOpened(WindowEvent evt){}
		public void windowActivated(WindowEvent evt){}
		public void windowDeactivated(WindowEvent evt){}
		public void windowIconified(WindowEvent evt){}
		public void windowDeiconified(WindowEvent evt){}
		public void windowClosed(WindowEvent e){}

	}
	

}
