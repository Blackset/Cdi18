import java.awt.*;
import java.awt.event.*;

public class SplashTest extends Frame
{
	private static final long serialVersionUID = -970691502632029122L;

	static void renderSplashFrame(Graphics2D g, int frame)
	{
		final String[] comps = { "infos", "donn�es", "programmes" };
		g.setComposite(AlphaComposite.Clear);
		g.fillRect(130, 250, 280, 40);
		g.setPaintMode();
		g.setColor(new Color(frame*((int)(Math.random()*0xffffff)) %0xffffff));
		g.drawString("Loading " + comps[(frame / 5) % 3] + "...", 130, 260);
		int r = frame% 101;
		g.fillOval(200-r, 130-r, 2*r, 2*r);
	}

	public SplashTest()
	{
		super("SplashScreen demo");
		setSize(500, 300);
		setLayout(new BorderLayout());
		Menu m1 = new Menu("File");
		MenuItem mi1 = new MenuItem("Exit");
		m1.add(mi1);
		Ecoute ec = new Ecoute();
		mi1.addActionListener(ec);

		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		mb.add(m1);
		final SplashScreen splash = SplashScreen.getSplashScreen();
		if (splash == null)
		{
			System.out.println("SplashScreen.getSplashScreen() returned null");
			return;
		}
		Graphics2D g = (Graphics2D) splash.createGraphics();
		if (g == null)
		{
			System.out.println("g is null");
			return;
		}
		for (int i = 0; i < 100; i++)
		{
			renderSplashFrame(g, i);
			splash.update();
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
			}
		}
		splash.close();
		setVisible(true);
		toFront();
	}

	class Ecoute implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			System.exit(0);
		}
	}

}