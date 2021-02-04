import javax.swing.*;

public class Split extends JFrame
{
	
	public Split()
	{
		setTitle("essai de splitpane");
		JLabel jl1 = new JLabel(new ImageIcon("Rebecca.jpg"));
		JLabel jl2 = new JLabel(new ImageIcon("Sophie.jpg"));
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jl1,jl2);
		jsp.setResizeWeight(0.5) ; // de la même façon en haut et en bas
		jsp.setOneTouchExpandable(true);// touche d'expansion
		jsp.setDividerSize(50);
		getContentPane().add(jsp);
		setBounds(100,100,400,400);
		setVisible(true);
	}
}