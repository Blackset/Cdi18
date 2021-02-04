import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Popup extends JFrame
{
	// definition d'une action commune au popup, toolbar et menu
	private ChangeAction change = new ChangeAction();
	// definition du menu
	private JMenuBar jmb = new JMenuBar();
	private JMenu changeLabel = new JMenu("Change");
	private JMenuItem changeLabelle = new JMenuItem(change);
	// definition du toolbar
	JToolBar jtb= new JToolBar("Menu", JToolBar.HORIZONTAL);
	// image du toolbar, mebu et popup
	private final static ImageIcon CHANGEACTION = new ImageIcon("toto.gif");
	private JButton jb = new JButton(change);
	// definition du popup
	JPopupMenu jpm = new JPopupMenu("change");
	
	private JLabel jl = new JLabel("faites un clic droit sur moi ...");
	public Popup()
	{
		getContentPane().add(jl,BorderLayout.NORTH);
		// mise en place du menu
		jmb.add(changeLabel);
		changeLabel.add(changeLabelle);
		setJMenuBar(jmb);
		// mise en place du toolbar
		jtb.add(jb);
		getContentPane().add(jtb,BorderLayout.SOUTH);
		// mise en place du popup
		PopListener pl = new PopListener();
		jl.addMouseListener(pl);
		jpm.add(new JMenuItem(change));
		// init de la fenetre
		setTitle ("essai Popup menu ");
		setBounds(100,100,400,400);
		setVisible(true);
	}
	class ChangeAction extends AbstractAction
	{
		public ChangeAction()
		{
			super("changer",CHANGEACTION);
			putValue(Action.SHORT_DESCRIPTION,"cliquer pour changer le texte du label");
		}
		public void actionPerformed(ActionEvent ae)
		{
			String val = (String) JOptionPane.showInputDialog(Popup.this,
					"entrez votre nouveau label :","saisie texte",
					JOptionPane.PLAIN_MESSAGE ,null,null,null);
			if (val != null)
			{
				jl.setText(val);
			}
			
		}
	}
	class PopListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent me)
		{
			checkPopup(me);
		}
		public void mouseReleased(MouseEvent me)
		{
			checkPopup(me);
		}
		public void mouseClicked(MouseEvent me)
		{
			checkPopup(me);
		}
		private void checkPopup(MouseEvent me)
		{
			// ceci permet de savoir si l'evt est celui qui declenche le popup
			// l'événement change suivant la plateforme ( look and feel )
			if ( me.isPopupTrigger())
			{
				// afficher le popup
				jpm.show(jl,me.getX(), me.getY());
			}
		}
	}
}

