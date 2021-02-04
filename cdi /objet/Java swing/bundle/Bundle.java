import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// il y a plusieurs manières de faire des bundles
// les fichiers properties, les ResourceBundles, et les ListResourceBundle
// ici nous traitons uniquement les fichiers properties ( le plus simple, il traite
// uniquement les chaines de caractères.il ne permet pas d'avois des objets
// différents suivant les pays.
public class Bundle extends JFrame
{
	JButton jb ;
	JLabel jl;
	ResourceBundle rb;
	boolean ok;
	Locale loc;
	JLabel somme;
	JLabel valeur;
	JLabel pourcent;
	JLabel date1;
	JLabel date2;
	NumberFormat nf ;
	DateFormat df;
	public Bundle()
	{
		ok = true;
		loc = new Locale("fr","FR");
		Locale.setDefault(loc) ;
		getContentPane().setLayout(new GridLayout(7,1));
		// ceci va chercher les textes dans des fichiers de properties
		// blabla_fr_FR.properties et blabla_en_US.properties situés dans
		// le répertoire monprojet/classes
		rb = ResourceBundle.getBundle("blabla",loc);
		jb = new JButton(rb.getString("Bouton"));
		jl = new JLabel(rb.getString("Label"));
		somme = new JLabel();
		valeur = new JLabel();
		pourcent = new JLabel();
		date1 = new JLabel();
		date2 = new JLabel();
		getContentPane().add(jl);
		getContentPane().add(jb);
		getContentPane().add(somme);
		getContentPane().add(valeur);
		getContentPane().add(pourcent);
		getContentPane().add(date1);
		getContentPane().add(date2);
		// ici par defaut le look est metal
		misajour();
		Ecoute ec = new Ecoute();
		jb.addActionListener(ec);
		setBounds(100,100,300,300);
		setVisible(true);
	}
	class Ecoute implements ActionListener
	{
		public void actionPerformed (ActionEvent ae)
		{
			if (ok)
			{
				loc = new Locale("en","US");
				// look motif
				try
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingUtilities.updateComponentTreeUI(Bundle.this);
				}
				catch ( Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				loc = new Locale("fr","FR");
				// look windows
				try
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(Bundle.this);
					// mise à jour des composants par rapport au look and feel
				}
				catch ( Exception e)
				{
					e.printStackTrace();
				}
				
			}
			Locale.setDefault(loc);
			
			ok = !ok;
			rb = ResourceBundle.getBundle("blabla",loc);
			misajour();
		}
	}
	public void misajour()
	{
		jb.setText(rb.getString("Bouton"));
		jl.setText(rb.getString("Label"));
		nf = NumberFormat.getCurrencyInstance();
		somme.setText(rb.getString("Somme")+ " " + nf.format(5000)) ;
		nf = NumberFormat.getNumberInstance();
		valeur.setText(rb.getString("Valeur")+ " " + nf.format(5000.25)) ;
		nf = NumberFormat.getPercentInstance();
		pourcent.setText(rb.getString("Pourcent")+ " " + nf.format(5.25)) ;
		df = DateFormat.getDateInstance(DateFormat.FULL);
		Date now = new Date();
		date1.setText(rb.getString("Date")+ " " +df.format(now ));
		df = DateFormat.getTimeInstance(DateFormat.SHORT);
		date2.setText(rb.getString("Heure")+ " " +df.format(now)) ;
		
	}
	
}