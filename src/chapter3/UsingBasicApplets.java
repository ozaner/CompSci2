package programs;
import java.awt.*;
import java.applet.Applet;

public class UsingBasicApplets extends Applet
{
	final int WIDTH = 600;
	final int HEIGHT = 300;
	Font radical = new Font(("Comic Sans MS"), Font.ITALIC, 15);
	
	//This method is required to create an applet
	public void paint(Graphics ravi)
	{
		setSize(WIDTH,HEIGHT);
		setBackground(Color.cyan);
		
		//test stuff
		ravi.setColor(Color.magenta);
		ravi.drawRect(60, 60, 100, 50);
		ravi.drawString("0, 0", 10, 10);
		ravi.setFont(radical);
		ravi.drawString("Ozaner is super cool", 60, 150);
		
		//draw a house
		ravi.setColor(Color.red);
		ravi.fillRect(300, 150, 200, 50);
		
		int[] xPoints = {270, 530, 400};
		int[] yPoints = {150, 150, 100};
		ravi.fillPolygon(xPoints, yPoints, 3);
	}
}
