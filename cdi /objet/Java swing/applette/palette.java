
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * <p>Titre : test applette</p>
 * <p>Description : test de génération d'une applette avec jbuilder</p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : afpa</p>
 * @author corre
 * @version 1.0
 */

public class palette extends Applet
{
	private boolean isStandalone = false;
	private BorderLayout borderLayout1 = new BorderLayout();
	private Panel bas = new Panel();
	private Panel haut = new Panel();
	private CardLayout cardLayout1 = new CardLayout();
	private Panel panel1 = new Panel();
	private Panel panel2 = new Panel();
	private Panel panel3 = new Panel();
	private Panel panel4 = new Panel();
	private Panel panel5 = new Panel();
	private BorderLayout borderLayout2 = new BorderLayout();
	private BorderLayout borderLayout3 = new BorderLayout();
	private BorderLayout borderLayout4 = new BorderLayout();
	private BorderLayout borderLayout5 = new BorderLayout();
	private BorderLayout borderLayout6 = new BorderLayout();
	private Choice choice1 = new Choice();
	private Label label1 = new Label();
	private Label label2 = new Label();
	private Label label3 = new Label();
	private Label label4 = new Label();
	private Label label5 = new Label();
	private Label label6 = new Label();
	private Button button1 = new Button();
	//Obtenir une valeur de paramètre
	public String getParameter(String key, String def)
	{
		return isStandalone ? System.getProperty(key, def) :
			(getParameter(key) != null ? getParameter(key) : def);
	}
	
	//Construire l'applet
	public palette()
	{
	}
	//Initialiser l'applet
	public void init()
	{
		choice1.addItem("Italien");
		choice1.addItem("Anglais");
		choice1.addItem("Allemand");
		choice1.addItem("Breton");
		choice1.addItem("Français");
		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Initialiser le composant
	private void jbInit() throws Exception
	{
		this.setLayout(borderLayout1);
		haut.setBackground(Color.green);
		bas.setBackground(Color.yellow);
		bas.setLayout(cardLayout1);
		panel1.setLayout(borderLayout2);
		panel2.setLayout(borderLayout3);
		panel3.setLayout(borderLayout4);
		panel4.setLayout(borderLayout5);
		panel5.setLayout(borderLayout6);
		panel5.setBackground(Color.yellow);
		panel4.setBackground(SystemColor.desktop);
		panel3.setBackground(Color.blue);
		panel2.setBackground(Color.cyan);
		panel1.setBackground(new Color(202, 72, 126));
		label1.setFont(new java.awt.Font("Dialog", 0, 20));
		label1.setForeground(Color.blue);
		label1.setText("choisissez un mot     ");
		label2.setFont(new java.awt.Font("Dialog", 0, 48));
		label2.setText("     Bonjourno");
		label3.setFont(new java.awt.Font("Dialog", 0, 48));
		label3.setText("     Hello");
		label4.setFont(new java.awt.Font("Dialog", 0, 48));
		label4.setText("     Guten Tag");
		label5.setFont(new java.awt.Font("Dialog", 0, 48));
		label5.setText("     Blao eo");
		label6.setFont(new java.awt.Font("Dialog", 0, 48));
		label6.setText("     Bonjour");
		button1.setBackground(new Color(99, 163, 99));
		button1.setLabel("button1");
		button1.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				button1_actionPerformed(e);
			}
				});
		choice1.addItemListener(new java.awt.event.ItemListener()
				{
			public void itemStateChanged(ItemEvent e)
			{
				choice1_itemStateChanged(e);
			}
				});
		this.add(haut, BorderLayout.NORTH);
		haut.add(label1, null);
		haut.add(choice1, null);
		this.add(bas, BorderLayout.CENTER);
		bas.add(panel1, "panel1");
		panel1.add(label2, BorderLayout.CENTER);
		panel1.add(button1, BorderLayout.EAST);
		bas.add(panel2,  "panel2");
		panel2.add(label3,  BorderLayout.CENTER);
		bas.add(panel3,  "panel3");
		panel3.add(label4,  BorderLayout.CENTER);
		bas.add(panel4,  "panel4");
		panel4.add(label5,  BorderLayout.CENTER);
		bas.add(panel5,  "panel5");
		panel5.add(label6,  BorderLayout.CENTER);
	}
	//Démarrer l'applet
	public void start()
	{
	}
	//Arrêter l'applet
	public void stop()
	{
	}
	//Détruire l'applet
	public void destroy()
	{
	}
	//Obtenir les informations d'applet
	public String getAppletInfo()
	{
		return "Information applet";
	}
	//Obtenir les informations de paramètre
	public String[][] getParameterInfo()
	{
		return null;
	}
	
	void choice1_itemStateChanged(ItemEvent e)
	{
		if (choice1.getSelectedItem().equalsIgnoreCase("Italien"))
		{
			cardLayout1.show(bas,"panel1");
		}
		else if (choice1.getSelectedItem().equalsIgnoreCase("Anglais"))
		{
			cardLayout1.show(bas,"panel2");
		}
		else if (choice1.getSelectedItem().equalsIgnoreCase("Allemand"))
		{
			cardLayout1.show(bas,"panel3");
		}
		else if (choice1.getSelectedItem().equalsIgnoreCase("Breton"))
		{
			cardLayout1.show(bas,"panel4");
		}
		else if (choice1.getSelectedItem().equalsIgnoreCase("Français"))
		{
			cardLayout1.show(bas,"panel5");
		}
		
		
	}
	
	void button1_actionPerformed(ActionEvent e)
	{
		label2.setForeground(Color.red);
	}
}