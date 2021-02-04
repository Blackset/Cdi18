import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Couleur extends JFrame
{
	JButton b = new JButton("coucou");
	public Couleur()
	{
		Ecouteur ec = new Ecouteur();
		b.addActionListener(ec);
		getContentPane().add(b);
		setBounds(100,100,200,200);
		setVisible(true);
	}
	class Ecouteur implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			JColorChooser jcc= new JColorChooser();
			Color c = JColorChooser.showDialog(jcc,"oh les belles couleurs",Color.orange);
			b.setBackground(c);
		}
	}
}