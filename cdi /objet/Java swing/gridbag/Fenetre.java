import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Titre : gridbag</p>
 * <p>Description : essai de fonctionnement du gridbaglayout</p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : afpa</p>
 * @author corre
 * @version 1.0
 */

public class Fenetre extends JFrame
{
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JLabel jLabel1 = new JLabel();
	private JList jList1 = new JList();
	private JButton jButton1 = new JButton();
	private JCheckBox jCheckBox1 = new JCheckBox();
	private JList jList2 = new JList();
	private JPanel jPanel3 = new JPanel();
	private JCheckBox jCheckBox2 = new JCheckBox();
	private JButton jButton2 = new JButton();
	private JLabel jLabel2 = new JLabel();
	private JPanel jPanel4 = new JPanel();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JButton jButton5 = new JButton();
	private GridBagLayout gridBagLayout1 = new GridBagLayout();
	private GridBagLayout gridBagLayout2 = new GridBagLayout();
	private GridLayout gridLayout1 = new GridLayout();
	private GridBagLayout gridBagLayout3 = new GridBagLayout();
	
	//Construire le cadre
	public Fenetre()
	{
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
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
		//setIconImage(Toolkit.getDefaultToolkit().createImage(Fenetre.class.getResource("[Votre icône]")));
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(400, 300));
		this.setTitle("essai de gridbag");
		jPanel1.setLayout(gridBagLayout3);
		jPanel2.setLayout(gridBagLayout1);
		jLabel1.setFont(new java.awt.Font("Dialog", 0, 11));
		jLabel1.setText("Colonnes triées");
		jList1.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton1.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton1.setText("Supprimer du tri");
		jButton1.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}
				});
		jCheckBox1.setFont(new java.awt.Font("Dialog", 0, 11));
		jCheckBox1.setText("Décroissant");
		jList2.setFont(new java.awt.Font("Dialog", 0, 11));
		jPanel3.setLayout(gridBagLayout2);
		jCheckBox2.setFont(new java.awt.Font("Dialog", 0, 11));
		jCheckBox2.setText("Diff MAJ / min");
		jCheckBox2.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				jCheckBox2_actionPerformed(e);
			}
				});
		jButton2.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton2.setText(" Ajouter au tri");
		jButton2.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}
				});
		jLabel2.setFont(new java.awt.Font("Dialog", 0, 11));
		jLabel2.setText(" Colonnes disponibles");
		jPanel4.setLayout(gridLayout1);
		jButton3.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton3.setText("Annuler");
		jButton3.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}
				});
		jButton4.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton4.setText("OK");
		jButton4.addActionListener(new java.awt.event.ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				jButton4_actionPerformed(e);
			}
				});
		jButton5.setFont(new java.awt.Font("Dialog", 0, 11));
		jButton5.setText("Aide");
		gridLayout1.setHgap(5);
		gridLayout1.setVgap(2);
		contentPane.add(jPanel1, BorderLayout.CENTER);
		jPanel2.add(jLabel1,    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 4, 0), 66, 11));
		jPanel2.add(jButton1,    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 0, 10), 0, 0));
		jPanel2.add(jCheckBox1,    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(6, 0, 0, 0), 58, -8));
		jPanel2.add(jList1,             new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0
				,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 141, 95));
		jPanel3.add(jLabel2,                         new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
				,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 0), 66, 7));
		jPanel3.add(jList2,                       new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0
				,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 1, 0), 141, 95));
		jPanel3.add(jButton2,     new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 0, 10), 24, 0));
		jPanel3.add(jCheckBox2,                             new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
				,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, -5));
		jPanel1.add(jPanel2,  new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
				,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 0, 0), 0, 0));
		jPanel1.add(jPanel4,         new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0
				,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(15, 0, 15, 0), 162, 14));
		jPanel4.add(jButton4, null);
		jPanel4.add(jButton3, null);
		jPanel4.add(jButton5, null);
		jPanel1.add(jPanel3,          new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0
				,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(15, 10, 0, 0), 0, 0));
	}
	//Supplanté, ainsi nous pouvons sortir quand la fenêtre est fermée
	protected void processWindowEvent(WindowEvent e)
	{
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			System.exit(0);
		}
	}
	
	void jButton1_actionPerformed(ActionEvent e)
	{
		
	}
	void jButton2_actionPerformed(ActionEvent e)
	{
		
	}
	
	void jCheckBox2_actionPerformed(ActionEvent e)
	{
		
	}
	
	void jButton3_actionPerformed(ActionEvent e)
	{
		
	}
	
	void jButton4_actionPerformed(ActionEvent e)
	{
		
	}
}