import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 * <p>Titre : Edith</p>
 * <p>Description : mini édireur de texte avec JBuilder</p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : afpa</p>
 * @author corre
 * @version 1.0
 */
import javax.swing.text.*;
import javax.swing.event.*;
class Utils
{
	/*
	 * Get the extension of a file.
	 */
	public static String getExtension(File f)
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		
		if (i > 0 &&  i < s.length() - 1) {
			ext = s.substring(i+1).toLowerCase();
		}
		return ext;
	}
	public static String setExtension(String name)
	{
		String ext = null;
		String s = name;
		int i = s.lastIndexOf('.');
		
		if (i > 0 &&  i < s.length() - 1)
		{
			ext = s.substring(i+1).toLowerCase();
		}
		if (ext == null)
		{
			return name + ".edi";
		}
		else
		{
			return s.substring(0,i)+ ".edi";
		}
		
	}
}

class MyFileFilter extends javax.swing.filechooser.FileFilter
{
	
	// Accept all directories and all edi files.
	public boolean accept(File f) 
	{
		if (f.isDirectory()) 
		{
			return true;
		}
		
		String extension = Utils.getExtension(f);
		if (extension != null)
		{
			return (extension.equals("edi"));
		}
		
		return false;
	}
	
	// The description of this filter
	public String getDescription()
	{
		return "Fichier de l'éditeur EDI uniquement";
	}
}

public class EdithFrame extends JFrame
{
	private JPanel contentPane;
	private JMenuBar jMenuBar1 = new JMenuBar();
	private JMenu jMenuFile = new JMenu();
	private JMenuItem jMenuFileExit = new JMenuItem();
	private JMenu jMenuHelp = new JMenu();
	private JMenuItem jMenuHelpAbout = new JMenuItem();
	private JToolBar jToolBar = new JToolBar();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private JLabel statusBar = new JLabel();
	private BorderLayout borderLayout1 = new BorderLayout();
	private JScrollPane jScrollPane1 = new JScrollPane();
	private JTextArea jTextArea1 = new JTextArea();
	private JMenuItem jMenuItem1 = new JMenuItem();
	private JMenuItem jMenuItem2 = new JMenuItem();
	private JMenuItem jMenuItem3 = new JMenuItem();
	private JMenuItem jMenuItem4 = new JMenuItem();
	private JMenu jMenu1 = new JMenu();
	private JMenuItem jMenuItem5 = new JMenuItem();
	private JMenuItem jMenuItem6 = new JMenuItem();
	private JFileChooser jFileChooser1 = new JFileChooser();
	private String curfile = null;
	private boolean modif = false;
	private Document document1;
	//Construire le cadre
	public EdithFrame()
	{
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try
		{
			jbInit();
			majtitre();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Initialiser le composant
	private void jbInit() throws Exception
	{
		image1 = new ImageIcon(EdithFrame.class.getResource("openFile.gif"));
		image2 = new ImageIcon(EdithFrame.class.getResource("closeFile.gif"));
		image3 = new ImageIcon(EdithFrame.class.getResource("help.gif"));
		//setIconImage(Toolkit.getDefaultToolkit().createImage(EdithFrame.class.getResource("[Votre icône]")));
		contentPane = (JPanel) this.getContentPane();
		document1 = jTextArea1.getDocument();
		contentPane.setLayout(borderLayout1);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(new Dimension(400, 300));
		this.setTitle("Editeur de texte");
		statusBar.setText(" ");
		jMenuFile.setText("Fichier");
		jMenuFileExit.setText("Quitter");
		jMenuFileExit.addActionListener(new EdithFrame_jMenuFileExit_ActionAdapter(this));
		jMenuHelp.setText("Aide");
		jMenuHelpAbout.setText("A propos");
		jMenuHelpAbout.addActionListener(new EdithFrame_jMenuHelpAbout_ActionAdapter(this));
		jButton1.setIcon(image1);
		jButton1.addActionListener(new EdithFrame_jButton1_actionAdapter(this));
		jButton1.setToolTipText("Ouvrir un fichier");
		jButton2.setIcon(image2);
		jButton2.addActionListener(new EdithFrame_jButton2_actionAdapter(this));
		jButton2.setToolTipText("enregistrer le fichier");
		jButton3.setIcon(image3);
		jButton3.addActionListener(new EdithFrame_jButton3_actionAdapter(this));
		jButton3.setToolTipText("A propos");
		jTextArea1.setLineWrap(true);
		jTextArea1.setWrapStyleWord(true);
		jMenuItem4.setText("Nouveau");
		jMenuItem4.addActionListener(new EdithFrame_jMenuItem4_actionAdapter(this));
		jMenuItem3.setText("Ouvrir");
		jMenuItem3.addActionListener(new EdithFrame_jMenuItem3_actionAdapter(this));
		jMenuItem2.setText("Enregistrer");
		jMenuItem2.addActionListener(new EdithFrame_jMenuItem2_actionAdapter(this));
		jMenuItem1.setText("Enregistrer sous");
		jMenuItem1.addActionListener(new EdithFrame_jMenuItem1_actionAdapter(this));
		jMenu1.setText("Edition");
		jMenuItem6.setText("Couleur du Texte");
		jMenuItem6.addActionListener(new EdithFrame_jMenuItem6_actionAdapter(this));
		jMenuItem5.setText("Couleur du Fond");
		jMenuItem5.addActionListener(new EdithFrame_jMenuItem5_actionAdapter(this));
		document1.addDocumentListener(new EdithFrame_document1_documentAdapter(this));
		jToolBar.add(jButton1);
		jToolBar.add(jButton2);
		jToolBar.add(jButton3);
		jMenuFile.add(jMenuItem4);
		jMenuFile.add(jMenuItem3);
		jMenuFile.add(jMenuItem2);
		jMenuFile.add(jMenuItem1);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuFileExit);
		jMenuHelp.add(jMenuHelpAbout);
		jMenuBar1.add(jMenuFile);
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenuHelp);
		this.setJMenuBar(jMenuBar1);
		contentPane.add(jToolBar, BorderLayout.NORTH);
		contentPane.add(statusBar, BorderLayout.SOUTH);
		contentPane.add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.getViewport().add(jTextArea1, null);
		jMenu1.add(jMenuItem6);
		jMenu1.add(jMenuItem5);
		MyFileFilter filter = new MyFileFilter();
		jFileChooser1.setFileFilter(filter);
		
	}
	// traitement de l'arret sans sauvegarde
	private boolean arretsanssauver()
	{
		if (!modif)
		{
			return true;
		}
		
		int val = JOptionPane.showConfirmDialog(this,"enregistrer les modifications ? ","Editeur de texte",JOptionPane.YES_NO_CANCEL_OPTION);
		switch (val)
		{
		case JOptionPane.YES_OPTION:
			return saveFile();
		case JOptionPane.NO_OPTION:
			return true;
		default:
			return false;
		}
		
	}
	// sauvegarde d'un fichier de données
	private boolean saveFile()
	{
		if (curfile == null)
		{
			// boite de dialogue pour avoir un nom de fichier
			if (JFileChooser.APPROVE_OPTION == jFileChooser1.showSaveDialog(this))
			{
				curfile = jFileChooser1.getSelectedFile().getPath() ;
				curfile = Utils.setExtension(curfile);
			}
			else
			{
				return false;
			}
			
		}
		try
		{
			File file = new File(curfile);
			FileWriter out = new FileWriter(file);
			String text = jTextArea1.getText();
			out.write(text);
			out.close();
			this.modif = false;
			majtitre();
			statusBar.setText("enregistré dans : "+ curfile);
			return true;
		}
		catch (Exception ex)
		{
			statusBar.setText("erreur en enregistrant : "+ curfile);
			return false;
		}
		
		
	}
	// ouverture d'un fichier de donnée
	private void openFile( String fileName)
	{
		try
		{
			File file = new File(fileName);
			int size = (int)file.length();
			int nbcar = 0;
			FileReader in = new FileReader(file);
			char [] data = new char [size];
			while (in.ready())
			{
				nbcar += in.read(data,nbcar,size-nbcar);
			}
			in.close();
			jTextArea1.setText(new String(data,0,nbcar));
			curfile = fileName;
			modif = false;
			majtitre();
			statusBar.setText("ouverture de : "+ fileName);
		}
		catch (Exception ex)
		{
			statusBar.setText("erreur en ouvrant : "+ fileName);
		}
		
		
	}
	public void fileOpen()
	{
		if (arretsanssauver())
		{
			if (JFileChooser.APPROVE_OPTION == jFileChooser1.showOpenDialog(this))
			{
				openFile(Utils.setExtension (jFileChooser1.getSelectedFile().getPath() ));
			}
			
		}
	}
	
	//Opération Fichier | Quitter effectuée
	public void jMenuFileExit_actionPerformed(ActionEvent e)
	{
		if (arretsanssauver())
		{
			System.exit(0);
		}
	}
	public void helpAbout()
	{
		EdithFrame_AboutBox dlg = new EdithFrame_AboutBox(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.pack();
		dlg.show();
		
	}
	//Opération Aide | A propos effectuée
	public void jMenuHelpAbout_actionPerformed(ActionEvent e)
	{
		helpAbout();
	}
	// modification de la barre de titre de la fenêtre
	private void majtitre()
	{
		String caption;
		if (curfile == null)
		{
			caption = "sans titre";
		}
		else
		{
			caption = curfile;
		}
		if (modif)
		{
			caption += " *";
		}
		caption = "Edith Editeur de texte " + caption;
		setTitle(caption);
		
	}
	//Supplanté, ainsi nous pouvons sortir quand la fenêtre est fermée
	protected void processWindowEvent(WindowEvent e)
	{
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING)
		{
			jMenuFileExit_actionPerformed(null);
		}
	}
	
	void jMenuItem6_actionPerformed(ActionEvent e)
	{
		Color color = JColorChooser.showDialog(this,"couleur du texte",jTextArea1.getForeground());
		if (color != null)
		{
			jTextArea1.setForeground(color);
		}
		
		repaint();
	}
	
	void jMenuItem5_actionPerformed(ActionEvent e)
	{
		Color color = JColorChooser.showDialog(this,"couleur du fond",jTextArea1.getBackground());
		if (color != null)
		{
			jTextArea1.setBackground(color);
		}
		
		repaint();
	}
	
	void jMenuItem4_actionPerformed(ActionEvent e)
	{
		if (arretsanssauver())
		{
			jTextArea1.setText("");
			curfile = null;
			modif = false;
			majtitre();
		}
		
	}
	
	void jMenuItem3_actionPerformed(ActionEvent e)
	{
		fileOpen();
	}
	
	void jMenuItem2_actionPerformed(ActionEvent e)
	{
		saveFile();
	}
	
	void jMenuItem1_actionPerformed(ActionEvent e)
	{
		curfile = null;
		saveFile();
	}
	
	void jButton2_actionPerformed(ActionEvent e)
	{
		saveFile();
	}
	
	void jButton1_actionPerformed(ActionEvent e)
	{
		fileOpen();
	}
	
	void jButton3_actionPerformed(ActionEvent e)
	{
		helpAbout();
	}
	
	void document1_changedUpdate(DocumentEvent e)
	{
		if (!modif)
		{
			modif = true;
			majtitre();
		}
	}
	
	void document1_insertUpdate(DocumentEvent e)
	{
		if (!modif)
		{
			modif = true;
			majtitre();
		}
	}
	
	void document1_removeUpdate(DocumentEvent e)
	{
		if (!modif)
		{
			modif = true;
			majtitre();
		}
	}
}

class EdithFrame_jMenuFileExit_ActionAdapter implements ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuFileExit_ActionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuFileExit_actionPerformed(e);
	}
}

class EdithFrame_jMenuHelpAbout_ActionAdapter implements ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuHelpAbout_ActionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuHelpAbout_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem6_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem6_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem6_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem5_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem5_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem5_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem4_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem4_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem4_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem3_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem3_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem3_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem2_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem2_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem2_actionPerformed(e);
	}
}

class EdithFrame_jMenuItem1_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jMenuItem1_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jMenuItem1_actionPerformed(e);
	}
}

class EdithFrame_jButton2_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jButton2_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jButton2_actionPerformed(e);
	}
}

class EdithFrame_jButton1_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jButton1_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jButton1_actionPerformed(e);
	}
}

class EdithFrame_jButton3_actionAdapter implements java.awt.event.ActionListener
{
	private EdithFrame adaptee;
	
	EdithFrame_jButton3_actionAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e)
	{
		adaptee.jButton3_actionPerformed(e);
	}
}

class EdithFrame_document1_documentAdapter implements javax.swing.event.DocumentListener
{
	private EdithFrame adaptee;
	
	EdithFrame_document1_documentAdapter(EdithFrame adaptee)
	{
		this.adaptee = adaptee;
	}
	public void insertUpdate(DocumentEvent e)
	{
		adaptee.document1_insertUpdate(e);
	}
	public void removeUpdate(DocumentEvent e)
	{
		adaptee.document1_removeUpdate(e);
	}
	public void changedUpdate(DocumentEvent e)
	{
		adaptee.document1_changedUpdate(e);
	}
}