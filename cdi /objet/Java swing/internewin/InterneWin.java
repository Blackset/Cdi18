import javax.swing.*;

public class InterneWin extends JFrame
{
	
	public InterneWin()
	{
		this.setTitle("essai de internal frame");
		JDesktopPane jdp = new JDesktopPane(); // c'est lui qui va gérer les internal frame
		setContentPane(jdp); // le contentpane est maintenant un desktopPane
		JInternalFrame jif1 = new JInternalFrame("un",true,true,true,true);
		JInternalFrame jif2 = new JInternalFrame("deux",true,true,true);
		JInternalFrame jif3 = new JInternalFrame("trois",true,true);
		JInternalFrame jif4 = new JInternalFrame("quatre",true);
		JInternalFrame jif5 = new JInternalFrame("cinq"); // pas de retaillage possible
		jif1.setVisible(true) ;
		jif2.setVisible(true) ;
		jif3.setVisible(true) ;
		jif4.setVisible(true) ;
		jif5.setVisible(true) ;
		jif1.setBounds(30,30,150,100);
		jif2.setBounds(40,40,150,100);
		jif3.setBounds(50,50,150,100);
		jif4.setBounds(60,60,150,100);
		jif5.setBounds(70,70,150,100);
		jdp.add(jif1);
		jdp.add(jif2);
		jdp.add(jif3);
		jdp.add(jif4);
		jdp.add(jif5);
		setBounds(50,50,300,300);
		setVisible(true);
	}
}