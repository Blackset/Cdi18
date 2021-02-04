import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Fenetre extends JFrame
{
	private static ImageIcon SAVE_ICON = new ImageIcon("save.gif");
	private static ImageIcon NEW_ICON = new ImageIcon("new.gif");
	private static ImageIcon MOD_ICON = new ImageIcon("add.gif");
	SaveAction sa = new SaveAction(); // comportement commun aux composants save
	NewAction na = new NewAction(); // comportement commun aux composants new
	ModAction ma = new ModAction(); // comportement commun aux composants modify
	JMenu fichier = new JMenu("Fichier");
	JMenuItem nouveau = new JMenuItem(na);
	JMenuItem sauver = new JMenuItem(sa);
	JToolBar outil = new JToolBar("Menu",JToolBar.HORIZONTAL);
	// ToolBar horizontale et ses boutons
	JButton bsa = new JButton(sa); // le bouton de la toolbar et le sousmenu
	// sont en fait le même composant sous des
	// apparences différentes
	JButton bna = new JButton (na);// idem
	JButton bma = new JButton (ma);
	// Bouton dans la frame
	JButton modif = new JButton (ma);// idem entre le bouton de la toolbar et
	// celui de la frame
	JMenuBar barmenu = new JMenuBar();
	public Fenetre()
	{
		// constitution du menu
		fichier.add(nouveau);
		nouveau.setMnemonic(KeyEvent.VK_N) ; // mnémonique quand menu est ouvert
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		fichier.add(new JSeparator()); // pour le fun
		fichier.add(sauver);
		sauver.setMnemonic(KeyEvent.VK_S) ;
		sauver.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		barmenu.add(fichier);
		this.setJMenuBar(barmenu);// ici pas de add sur la JFrame, car on ajoute
		// la barre de menu sur le contenaire du Frame
		// qui gère la barre de menu ( mille feuille )
		
		// constitution de la boite à outils ( déplaçable !!! )
		// les JToolBar sont gérées par des BoxLayouts
		outil.addSeparator(new Dimension(5,5) ); // espacement de 5 pixels
		outil.add(bna);
		
		outil.addSeparator(new Dimension(20,20)) ; // espacement de 20 pixels
		outil.add(bsa);
		outil.add(Box.createGlue() ); // espacement variable qui
		// implique un collage à droite
		outil.add(bma);
		outil.addSeparator(new Dimension(5,5));
		
		// les contenair qui constituent le mille feuille de la JFrame sont
		// gérées par des BorderLayouts
		getContentPane().add(outil,BorderLayout.NORTH); // on ajoute sur le
		//le plus bas contenair ( mille feuille )
		
		// init
		sa.setEnabled(false);
		modif.setIcon(null); // pas d'icone sur le bouton
		bna.setText(null); // pas de texte sur le bouton de la toolbar
		bsa.setText(null);
		bma.setText(null) ;
		modif.setSize(150,80);
		modif.setBorder(new CompoundBorder(new LineBorder(Color.red,6,true ),
				new CompoundBorder(new LineBorder(Color.yellow, 15, false),
						new LineBorder(Color.red,6,true))));
		getContentPane().add(modif,BorderLayout.SOUTH);
		this.setTitle("essai sauvegarde");
		this.setBounds(100,100,300,300);
		this.setVisible(true);
	}
	public void doSave()
	{
		// sauvegarde
	}
	class SaveAction extends AbstractAction
	{
		public SaveAction()
		{
			super("Save",SAVE_ICON);
			putValue(Action.SHORT_DESCRIPTION,
			" appuyer pour sauvegarder vos données ");
		}
		public void actionPerformed ( ActionEvent ae)
		{
			doSave();
			sa.setEnabled(false) ;
		}
	}
	public void doNew()
	{
		// sauvegarde
	}
	class NewAction extends AbstractAction
	{
		public NewAction()
		{
			super("New",NEW_ICON);
			putValue(Action.SHORT_DESCRIPTION,
			" appuyer pour un nouveau document ");
		}
		public void actionPerformed ( ActionEvent ae)
		{
			doNew();
			sa.setEnabled(false) ;
		}
	}
	public void doMod()
	{
		// sauvegarde
	}
	class ModAction extends AbstractAction
	{
		public ModAction()
		{
			super("Modifier",MOD_ICON);
			putValue(Action.SHORT_DESCRIPTION,
			" appuyer pour modifier vos données ");
		}
		public void actionPerformed ( ActionEvent ae)
		{
			doMod();
			sa.setEnabled(true) ;
		}
	}
	
}