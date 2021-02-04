import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Fenetre extends JFrame
{
	private JTree jt;
	JScrollPane jsp; // on met des scrollbarres au JTree
	private JButton jb = new JButton("ok");
	private JTextField jtf = new JTextField();
	private ModelTreeBin mtb; // on le construira en fonction des saisies
	public Fenetre()
	{
		getContentPane().add(jb,BorderLayout.SOUTH);
		getContentPane().add(jtf,BorderLayout.NORTH);
		Ecouteur ec = new Ecouteur(); // écouteur du bouton ok
		jb.addActionListener(ec) ;
		setBounds(100,100,400,400);
		setVisible(true);
	}
	class Ecouteur implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// il faut construire un modèle de données pour l'arbre à partir
			// de l'expression donnée dans la zone texte
			try
			{
				mtb = new ModelTreeBin(jtf.getText() );
				
				if (jsp != null)
				{
					// il y a un vieil arbre, abattons le ( et tant pis pour Idéfix)
					getContentPane().remove(jsp);
				}
				// plantons un jeune arbre sur le modèle de donnée établi
				jt = new JTree(mtb);
				jt.setShowsRootHandles(true); // on rend visible les poignées
				jt.collapseRow(0); // arborescence fermée, une seule ligne
				jsp = new JScrollPane(jt);
				getContentPane().add(jsp,BorderLayout.CENTER );
				setVisible(false);
				setVisible(true);  // magouille car le rafraichissement n'est pas parfait
				
			}
			catch (Exception ex)
			{
				JOptionPane.showInternalMessageDialog(getContentPane() ,"L'expression est incorrecte "+ ex,
						"Calcul d'une expression",
						JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
	}
}