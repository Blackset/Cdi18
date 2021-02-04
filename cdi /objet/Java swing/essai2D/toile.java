import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
public class toile extends JFrame
{
	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();
	
	//Construire le cadre
	public toile()
	{
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
		this.setSize(new Dimension(400, 300));
		this.setTitle("essai de dessin 2D");
		this.setBounds(0,0,400,600);
		this.setVisible(true);
	}
	public void paint( Graphics g )
	{
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage bi = new BufferedImage(15,15,BufferedImage.TYPE_INT_RGB);
		Graphics2D gbi = bi.createGraphics();
		gbi.setColor(Color.orange);
		gbi.fillRect(0,0,15,15);
		gbi.setColor(Color.blue) ;
		gbi.drawRect(2,2,11,11);
		gbi.setColor(Color.green) ;
		gbi.fillRect(3,3,5,10);
		gbi.setColor(Color.pink) ;
		gbi.fillRect(8,3,5,10);
		g2.setPaint(new TexturePaint(bi,new Rectangle(15,15)));
		g2.fillRect(0,0,400,600);
		
		int x = this.getInsets().top;
		
		g2.setPaint(new GradientPaint(0,0,Color.pink , 50,50,Color.gray,true));
		g2.fill(new Ellipse2D.Double(10,10+x,200,300+x));
		g2.setPaint(new GradientPaint(0,50,Color.orange , 50,0,Color.blue,true));
		g2.fill(new Ellipse2D.Double(250,100+x,150,200+x));
	}
	
}