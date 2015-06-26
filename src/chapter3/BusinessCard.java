package programs;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BusinessCard extends Applet
{
	final int WIDTH = 500;
	final int HEIGHT = 200;
	Font radical = new Font(("Comic Sans MS"), Font.BOLD, 20);
	Font radical2 = new Font(("Timer New Roman"), Font.ITALIC, 13);
	
	//This method is required to create an applet
	public void paint(Graphics painter)
	{
		setSize(WIDTH,HEIGHT);
		setBackground(Color.cyan);
		
		//Draws the car
		painter.setColor(Color.magenta);
		painter.fillRect(70, 60, 60, 10); //draws top rectangle
		painter.fillRect(50, 70, 100, 20); //draws body
		painter.setColor(Color.black);
		painter.fillOval(60, 90, 20, 20); //draws left wheel
		painter.fillOval(120, 90, 20, 20); //draws right wheel
		painter.drawLine(60,110, 140, 110); //draws road
		
		//draws text
		painter.setFont(radical);
		painter.drawString("Ozaner's Car Repo", 190, 30);
		painter.setFont(radical2);
		painter.drawString("For all your Car Repo needs!!!", 190, 60);
	}
}