import javax.swing.*;
import java.awt.*;
public class Option extends JFrame
{
	
	public Option()
	{
		setTitle("test JOptionPane");
		getContentPane().setBackground(Color.orange);
		setBounds(100,100,400,400);
		setVisible(true);
		
		// boites de messages d'informations
	      JInternalFrame modal = optionPane.
          createInternalFrame(desktop, "Modal");

        // create opaque glass pane
        JPanel glass = new JPanel();
        glass.setOpaque(false);

        // Attach modal behavior to frame
        modal.addInternalFrameListener(
          new ModalAdapter(glass));


		JOptionPane.showInternalMessageDialog(this.getGlassPane() ,"boite interne",
				"voici le titre",
				JOptionPane.PLAIN_MESSAGE);
		
		// messages
		
		JOptionPane.showInternalConfirmDialog(this.getGlassPane(),"juste un message");

	}
}