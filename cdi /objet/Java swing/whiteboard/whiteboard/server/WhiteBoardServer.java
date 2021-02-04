package whiteboard.server;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import whiteboard.Shape;
import whiteboard.client.WhiteBoardObserver;

public class WhiteBoardServer implements WhiteBoard
{
    private static final long serialVersionUID = -328029075725792603L;

    private boolean connected;
    
    private static final String  serverBoundName = "Whiteboard";
    
    private Registry registry;
    
    private JFrame frame;
    private JLabel lNbClients;
    private JButton bOK;
    private JButton bQuit;
    
    private Ecouteur clients;
    private Oeuvre shapes;
    
    private static int numClient;
    
   
    protected WhiteBoardServer() throws RemoteException
    {
        connected = false;
        numClient = 0;
        initGUI();
    }
    
    private void initGUI()
    {
        frame = new JFrame("WhiteBoardServer");
        JPanel pTop = new JPanel();
        pTop.setLayout(new BoxLayout(pTop, BoxLayout.PAGE_AXIS));
        
        JPanel pFields = new JPanel(new GridLayout(1, 2, 20, 10));
        lNbClients = new JLabel(Integer.toString(numClient));
        
        pFields.add(new JLabel("Clients connectés"));
        pFields.add(lNbClients);
        
        JPanel pButtons = new JPanel();
        pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.LINE_AXIS));
        ButtonsListener bl = new ButtonsListener();
        bOK = new JButton("OK");
        bOK.addActionListener(bl);
        bQuit = new JButton("Quitter");
        bQuit.addActionListener(bl);
        
        pButtons.add(Box.createHorizontalGlue());
        pButtons.add(bOK);
        pButtons.add(Box.createRigidArea(new Dimension(10, 0)));
        pButtons.add(bQuit);
        
        pTop.add(pFields);
        pTop.add(Box.createRigidArea(new Dimension(0, 10)));
        pTop.add(pButtons);
        
        pTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        frame.getContentPane().add(pTop);
        
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) 
            { close(); }
        });
        
        frame.setLocation(75, 75);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private boolean checkFields()
    {
        shapes = new Oeuvre();

        return true;
    }
    
    private void disableGUI()
    {
        bOK.setText("Stop");
    }
    
    private void enableGUI()
    {
        bOK.setText("OK");
    }
    
    private boolean startServer()
    {
        boolean ok = false;
 
        try
        {
            /* Nouvelle méthode Java 5 : le stub du serveur est compilé à
             * l'exécution puis envoyé au registre. Le client récupère le code
             * compilé lors de l'interrogation du registre.
            */
            WhiteBoard wb = (WhiteBoard) UnicastRemoteObject.exportObject(this, 0);
            registry = LocateRegistry.createRegistry(1099);
            registry.rebind(serverBoundName, wb);
            
            clients = new Ecouteur();
            ok = true;
        }
        catch (AccessException e)
        {
            System.err.println("Accès impossible au registre. Opération non permise");
            e.printStackTrace();
        }
        catch (RemoteException e)
        {
            System.err.println("Impossible d'inscrire le serveur dans le registre.");
            e.printStackTrace();
        }
        return ok;
    }
    
    private boolean stopServer()
    {
        boolean ok = false;
        
        try
        {
            shapes.clear();
            
            for (WhiteBoardObserver wbo : clients)
            {
            	int i = wbo.getId();
                System.out.println("Déconnexion du client n°" + Integer.toString(i));
                disconnect(i);
            }
            
            lNbClients.setText(Integer.toString(0));
            
            registry.unbind(serverBoundName);
            ok = true;
        } 
        catch (RemoteException e)
        {
            System.err.println("Impossible de désinscrire le serveur du registre.");
            e.printStackTrace();
        }
        catch (NotBoundException e)
        {
            System.err.println("Le serveur n'est pas enregistré dans le registre.");
            e.printStackTrace();
        }
        
        return ok;
    }
    
    private void close()
    {
        if (connected)
            if (!stopServer())
                System.exit(1);
        
        System.exit(0);
    }
    
    public int connect(WhiteBoardObserver client)
    {
        int i = numClient;
        try
		{
			client.setId(i);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clients.add(client);// hélas c'est ici une copie du client...
        Dessin d = new Dessin(i);
        shapes.add(d);
        numClient++;
        lNbClients.setText(Integer.toString(shapes.size()));
        return i;
    }
    
    public boolean disconnect(int clientId)
    {
    	if (clients.get(clientId) != null)
    	{

		    shapes.remove(clientId);
		    clients.remove(clientId);
		    lNbClients.setText(Integer.toString(shapes.size()));
    	}
        return true;
    }
        
    public boolean add(Shape s, int clientId)
    {
     	if (clients.gett(clientId) != null)
    	{
       
	        shapes.gett(clientId).add(s);
	        fireShapesChanged();
    	}
        return true;
    }

    
    public void empty(int clientId)
    {
    	if (clients.gett(clientId) != null)
    	{
	        shapes.get(clientId).clear();
	        fireShapesChanged();
    	}
    }
    
    public Oeuvre getShapes()
    {
        return shapes;
    }

    public boolean remove(int clientId)
    {
        boolean ok = (clients.gett(clientId) != null && shapes.gett(clientId).size()> 0);
        
        if (ok)
        {
            ok = false;
            
            if(shapes.gett(clientId).size()>0)
            {
                shapes.gett(clientId).remove();
            	ok = true;
            }
            if (ok)
                fireShapesChanged();
        }
        
        return ok;
    }

    private void fireShapesChanged()
    {
        for (WhiteBoardObserver wbo : clients)
        {
                try
                {
                    try
                    {
                    	if (wbo.nonInit())
                    	{
                    		int i = wbo.getId();

                    		clients.remove(wbo);
                    		wbo = (WhiteBoardObserver) registry.lookup("observer"+i);
                    		clients.add(wbo);
                    	}
                    }
                    catch (Exception e)
                    {
                        System.err.println("Client - Erreur RMI.");
                        e.printStackTrace();
                    }

                    wbo.update();
                }
                catch (RemoteException e)
                {
                    System.err.println("Serveur - Impossible d'envoyer les données vers un client " );
                    e.printStackTrace();
                }
            }
        
    }
    
    class ButtonsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == bOK)
            {
                if (connected)
                {
                    if (stopServer())
                    {
                        enableGUI();
                        connected = false;
                    }
                }
                else
                {
                    if (checkFields() && startServer())
                    {
                        disableGUI();
                        connected = true;
                    }
                }
            }
            else if (e.getSource() == bQuit)
            {
                close();
            }
        }
    }
}
