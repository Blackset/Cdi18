package whiteboard.client;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;

import java.rmi.RemoteException;
import java.util.List;

import whiteboard.*;
import whiteboard.server.Dessin;
import whiteboard.server.Oeuvre;
import whiteboard.server.WhiteBoard;

public class ClientWindow extends Frame
{
    private static final long serialVersionUID = -1173363505050995021L;
    
    private Client parent;
    
    private WhiteBoard whiteboard;
    private int clientId;
    
    private Oeuvre shapes;

    private Shape currentShape;
    private String title;
    
    private Image buffer;
    private Graphics2D gBuffer;
    
    private static final int TRAIT = 1;
    private static final int COURBE = 2;
    private static final int DISQUE = 3;
    private static final int ALEA = 4;
    private static final int VOILE = 5;
    
    private int typeFigure = TRAIT;
    
    public ClientWindow(Client parent, WhiteBoard whiteboard, int clientId)
    {
        this.parent = parent;
        this.whiteboard = whiteboard;
        this.clientId = clientId;
        title = "Client " + Integer.toString(clientId) ;
        try
        {
            shapes = whiteboard.getShapes();
        }
        catch (RemoteException re)
        {
            System.err.println("Client - Erreur RMI");
            re.printStackTrace();
        }
        initGUI();
    }
    
    private void initGUI()
    {
        EcouteurFenetre ef = new EcouteurFenetre();
        EcouteurSouris es = new EcouteurSouris();
        EcouteurClavier ec = new EcouteurClavier();
        
        addWindowListener(ef);
        addMouseListener(es);
        addMouseMotionListener(es);
        addKeyListener(ec);
        
        setBounds(200, 200, 400, 400);
       
        setVisible(true);
        
    }
    
    private Shape getFigure(Point p)
    {
        switch (typeFigure)
        {
        case TRAIT:
            return new Line( p);
        case COURBE:
            return new Curve( p);
        case ALEA:
        	return new Alea(p);
        case VOILE: 
        	return new Voile(p);
        default:
            return new Disc( p);
        }
    }
    
    public void setFigures()
    {
    	try
		{
			shapes = whiteboard.getShapes();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        repaint();
    }
    
    public void paint(Graphics g)
    {
        setTitle(title );

        if (buffer == null)
        {
            buffer = createImage(getSize().width, getSize().height);
            gBuffer = (Graphics2D) buffer.getGraphics();
            gBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else
        {
            gBuffer.clearRect(0, 0, getSize().width, getSize().height);
        }

        for(Dessin d : shapes)
        {
	        for (Shape s : d)
	        {
	            s.paint(gBuffer);
	        }
        }

        if (currentShape != null)
            currentShape.paint(gBuffer);

        g.drawImage(buffer, 0, 0, this);
    }
 
    public void update(Graphics g) 
    { 
        paint(g);
    }
    
    private void close()
    {
        parent.close();
    }
    
    class EcouteurFenetre extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            close();
        }
    }

    class EcouteurSouris implements MouseListener, MouseMotionListener
    {

        public void mouseClicked(MouseEvent e)
        {
            if (e.getClickCount() >= 2 && e.getButton() == MouseEvent.BUTTON1)
            {
                try
                {
                    whiteboard.empty(clientId);
                }
                catch (RemoteException re)
                {
                    System.err.println("Client - Erreur RMI");
                    re.printStackTrace();
                    close();
                }
                repaint();
            }
            
            if (e.getButton() == MouseEvent.BUTTON3)
                try
                {
                    if (whiteboard.remove(clientId))
                    {
                        repaint();
                    }
                }
                catch (RemoteException re)
                {
                    System.err.println("Client - Erreur RMI");
                    re.printStackTrace();
                    close();
                }
        }

        public void mousePressed(MouseEvent e)
        {
                if (e.getButton() == MouseEvent.BUTTON1)
                    currentShape = getFigure(e.getPoint());
        }

        public void mouseReleased(MouseEvent e)
        {

            if (currentShape != null && e.getButton() == MouseEvent.BUTTON1)
            {
                try
                {

                    whiteboard.add(currentShape,clientId);
                    currentShape = null;
                    repaint();
                }
                catch (RemoteException re)
                {
                    System.err.println("Client - Erreur RMI");
                    re.printStackTrace();
                    close();
                }
            }
        }

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}

        public void mouseDragged(MouseEvent e)
        {
            if (currentShape != null && !e.isMetaDown() && !e.isAltDown())
            {
                currentShape.setEnd(e.getPoint());
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {}
    }
    
    class EcouteurClavier extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyChar())
            {
            case 't':
            case 'T':
                typeFigure = TRAIT;
                break;
            case 'a':
            case 'A':
                typeFigure = ALEA;
                break;
            case 'v':
            case 'V':
                typeFigure = VOILE;
                break;
            case 'c':
            case 'C':
                typeFigure = COURBE;
                break;
            case 'd':
            case 'D':
                typeFigure = DISQUE;
                break;
            default:
                System.err.println("Touche invalide");
            }
        }
    }
}
