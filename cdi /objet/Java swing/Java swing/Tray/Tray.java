import java.awt.*;
import java.awt.event.*;

public class Tray extends Frame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5444621209837152237L;

	public Tray()
	{
		// changement de l'icone de la fenetre
		Image icone = Toolkit.getDefaultToolkit().getImage("./tray.gif");
		setIconImage(icone);


		setBounds(100, 100, 300, 300);
		setVisible(true);
		final TrayIcon trayIcon;

		if (SystemTray.isSupported())
		{// sinon ce n'est pas la peine

			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage("./tray.gif");

			MouseListener mouseListener = new MouseListener()
			{// ici ce n'est que pour voir que l'on peut les traiter dans l'appli

				public void mouseClicked(MouseEvent e)
				{
					System.out.println("Tray Icon - Mouse clicked!");
				}

				public void mouseEntered(MouseEvent e)
				{
					System.out.println("Tray Icon - Mouse entered!");
				}

				public void mouseExited(MouseEvent e)
				{
					System.out.println("Tray Icon - Mouse exited!");
				}

				public void mousePressed(MouseEvent e)
				{
					System.out.println("Tray Icon - Mouse pressed!");
				}

				public void mouseReleased(MouseEvent e)
				{
					System.out.println("Tray Icon - Mouse released!");
				}
			};

			ActionListener exitListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{// choix de l'exit du popup ( clic droit sur l'icone de la barre )
					System.exit(0);
				}
			};

			PopupMenu popup = new PopupMenu();
			MenuItem item = new MenuItem("Quitter");
			item.addActionListener(exitListener);
			popup.add(item);

			trayIcon = new TrayIcon(image, "Tray Demonstration", popup);

			ActionListener actionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{// double clic sur l'icone de la barre
					trayIcon.displayMessage("Pour Arrêter", "appuyez sur démarrer!", TrayIcon.MessageType.WARNING);
				}
			};

			trayIcon.setImageAutoSize(true);
			trayIcon.addActionListener(actionListener);
			trayIcon.addMouseListener(mouseListener);

			try
			{
				tray.add(trayIcon);
			}
			catch (AWTException e)
			{
				System.err.println("ça ne marche pas !!! l'icone ne veut pas y aller");
			}

		}
		else
		{

			System.err.println("ça ne marche pas !!! Tray n'est pas supporté.");


		}

	}
}
