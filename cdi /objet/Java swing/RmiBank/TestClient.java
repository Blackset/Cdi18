import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TestClient extends JFrame
{
	private static int i = 0;
	private int monI;
	private JLabel jlNom = new JLabel("nom");
	private JLabel jlSolde = new JLabel("solde");
	private JTextField jtNom = new JTextField();
	private JTextField jtSolde = new JTextField();
	private JButton jbCreer = new JButton("créer");
	private JButton jbRetirer = new JButton("retirer");
	private JButton jbDeposer = new JButton("déposer");
	private JButton jbFermer = new JButton("Fermer");
	private Banque b;
	private Registry r =null;
	private Compte c = null;// compte créé à la banque
	private EcouteClient ec = new EcouteClient();
	public TestClient()
	{
		i++;
		monI = i;
		GridLayout gl = new GridLayout(4,2);
		setLayout(gl);
		add(jlNom);
		add(jtNom);
		add(jlSolde);
		add(jtSolde);
		add(jbCreer);
		jbRetirer.setEnabled(false);
		jbDeposer.setEnabled(false);
		jbFermer.setEnabled(false);
		add(jbFermer);
		add(jbRetirer);
		add(jbDeposer);
		setTitle("TestClient");
		setBounds(100,100,300,300);
		setVisible(true);
		try
		{
			// se connecter à la banque
			r = LocateRegistry.getRegistry("localhost");// reperage du registry du serveur
			b = (Banque) r.lookup("banque");// on recupere le stub de la banque
			System.out.println("la banque est ouverte");

		}
		catch (Exception e)
		{
			System.out.println("la banque est fermée");
			e.printStackTrace();
			System.exit(0);
		}
		try
		{
			// publions la fenetre 
			EcouteurClient b = (EcouteurClient) UnicastRemoteObject.exportObject(ec, 0);
			Registry r = LocateRegistry.getRegistry(1099);
			r.rebind("ec" + monI, b);
		}
		catch (Exception e)
		{
		}		
		System.out.println("publication de l'écouteur "+"ec"+monI+" réussi");

		EcCreer ecc = new EcCreer();
		jbCreer.addActionListener(ecc);
		EcFermer ecf = new EcFermer();
		jbFermer.addActionListener(ecf);
		EcRetirer ecr = new EcRetirer();
		jbRetirer.addActionListener(ecr);
		EcDeposer ecd = new EcDeposer();
		jbDeposer.addActionListener(ecd);
		
		
	}
	class EcCreer implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			int val = 0;
			jbCreer.setEnabled(false);
			jbRetirer.setEnabled(true);
			jbDeposer.setEnabled(true);
			jbFermer.setEnabled(true);
			try
			{

				if (b.open(jtNom.getText(), val))// le compte n'est pas deja créé
				{

				}
				c = (Compte) r.lookup(jtNom.getText());// je recupere le stub du client
				jtSolde.setText(""+c.getSolde());
				c.abonne(monI);
			}
			catch (Exception ex)
			{
				System.out.println("la banque ne marche plus");
				ex.printStackTrace();
				System.exit(0);

			}			
			
		}
		
	}
	class EcFermer implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			jbCreer.setEnabled(true);
			jbRetirer.setEnabled(false);
			jbDeposer.setEnabled(false);
			jbFermer.setEnabled(false);
			try
			{
				c.desabonne(monI);
			}
			catch (RemoteException e1)
			{
			}
			
		}
		
	}
	class EcRetirer implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			int val = 100;

			try
			{
				Compte c = (Compte) r.lookup(jtNom.getText());
				if (c != null)
				{
					c.retirer(val);
				}
			}
			catch(NotBoundException nbe)
			{
				System.out.println("ce compte n'existe pas");

			}

			catch (Exception ex)
			{
				System.out.println("la banque ne marche plus");
				ex.printStackTrace();
				System.exit(0);

			}			
			
		}
		
	}
	class EcDeposer implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			int val = 100;
			try
			{
				Compte c = (Compte) r.lookup(jtNom.getText());
				if (c != null)
				{
					c.deposer(val);
				}
			}
			catch(NotBoundException nbe)
			{
				System.out.println("ce compte n'existe pas");

			}
			catch (Exception ex)
			{
				System.out.println("la banque ne marche plus");
				ex.printStackTrace();
				System.exit(0);

			}			
			
			
		}
		
	}
	class EcouteClient implements EcouteurClient
	{
		public void metAjour(String nom)throws RemoteException
		{
			if (nom.equals(jtNom.getText()))
			{
				try
				{
					Compte c = (Compte) r.lookup(jtNom.getText());
					if (c != null)
					{
						jtSolde.setText(""+c.getSolde());
					}
				}
				catch (Exception ex)
				{
					System.out.println("la banque ne marche plus");
					ex.printStackTrace();
					System.exit(0);

				}			

			}
			
		}
		
	}
	public class EcClose implements WindowListener
	{

		public void windowActivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowClosing(WindowEvent e)
		{
			
			try
			{
				// depublions la fenetre 
				Registry r = LocateRegistry.getRegistry(1099);
				r.unbind("ec" + monI);
			}
			catch (Exception eu)
			{
			}		

		}

		public void windowDeactivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowOpened(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}
