import java.awt.*;
import javax.swing.*;

public class Cercle extends JFrame
{
	private Pane cp;
	
	//Construire le cadre
	public Cercle()
	{
		cp = new Pane();
		setContentPane(cp);
		this.setSize(new Dimension(700, 740));
		this.setTitle("tracé de  cercles");
	}

}