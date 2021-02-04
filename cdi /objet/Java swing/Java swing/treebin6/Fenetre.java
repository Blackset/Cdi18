import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class Fenetre extends JFrame
{
	private Arbre jt;
	private JScrollPane jsp=null;
	private TreeExpansionListener tel;
	private JButton jb = new JButton("ok");
	private JTextField jtf = new JTextField();
	private ModelTreeBin mtb;
	public Fenetre()
	{
		getContentPane().add(jb,BorderLayout.SOUTH);
		getContentPane().add(jtf,BorderLayout.NORTH);
		Ecouteur ec = new Ecouteur();
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
					jt.removeTreeExpansionListener(jt);
				}
				// plantons un jeune arbre sur le modèle de donnée établi
				if (mtb != null)
				{
					jt = new Arbre(mtb);
					
					jt.setShowsRootHandles(true); // on rend visible les poignées
					jt.collapseRow(0); // ferme, une seule ligne
					jsp = new JScrollPane(jt);
					getContentPane().add(jsp,BorderLayout.CENTER );
					setVisible(false);
					setVisible(true);  // magouille car le rafraichissement n'est pas parfait
				}
				
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