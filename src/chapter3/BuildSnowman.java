package programs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BuildSnowman extends JoeApplet implements KeyListener, MouseListener, MouseMotionListener
{
	//snowman Starting Point
	int snowmanX = 150;
	int snowmanY = 50;
	
	//arm movement
	int rightArmEnd = snowmanY+40;
	int movement = 2;
	
	//create solid object
	SolidObject wall = new SolidObject();
	SolidObject snowman = new SolidObject();
	
	//test for collision
	boolean wallHit = false;
	
	public void init()
	{
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void setScene(Graphics art)
	{
		//set screen size and background color
		setSize(300, 225);
		setBackground(Color.cyan);
		
		//ground
		art.setColor(Color.blue);
		art.fillRect(0, 175, 300, 50);
		
		//sun
		art.setColor(Color.yellow);
		art.fillOval(-40, -40, 80, 80);
		
		//wall (with collision)
		art.setColor(Color.red);
		art.fillRect(30, 50, 40, 150); //draws the wall
		wall.makeSolidObject(30, 50, 40, 150); //superimposes this object over drawing
	}
	
	public void snowmanBody(Graphics art)
	{
		//body with 3 ovals
		art.setColor(Color.white);
		art.fillOval(snowmanX-20, snowmanY, 40, 40);
		art.fillOval(snowmanX-35, snowmanY+35, 70, 50);
		art.fillOval(snowmanX-50, snowmanY+80, 100, 60);
		
		//creates solid object
		snowman.makeSolidObject(snowmanX-50, snowmanY, 100, 160);
	}
	
	public void snowmanHead(Graphics art)
	{
		art.setColor(Color.black);
		
		//eyes
		art.fillOval(snowmanX-10, snowmanY+10, 5, 5);
		art.fillOval(snowmanX+5, snowmanY+10, 5, 5);

		art.drawArc(snowmanX-10, snowmanY+20, 20, 10, 190, 160); //mouth
		art.drawLine(snowmanX-20, snowmanY+5, snowmanX+20, snowmanY+5); //Hat
		art.fillRect(snowmanX-15, snowmanY-20, 30, 25);
	}
	
	public void snowmanArms(Graphics art)
	{
		//draw arms
		art.setColor(Color.gray);
		art.drawLine(snowmanX+25, snowmanY+60, snowmanX+55, snowmanY+60);
		art.drawLine(snowmanX-25, snowmanY+60, snowmanX-55, rightArmEnd);
		rightArmEnd = rightArmEnd + movement;
		
		if(rightArmEnd > 150 || rightArmEnd < 70)
		{
			movement = movement * -1;
		}
	}
	
	public void paint(Graphics art)
	{
		setScene(art);
		snowmanBody(art);
		snowmanHead(art);
		snowmanArms(art);
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		snowmanY = e.getY();
		snowmanX = e.getX();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//move left and right
		int key = e.getKeyCode();
		if(key == e.VK_RIGHT)
		{
			snowmanX++;
		}
		
		if(key == e.VK_LEFT)
		{
			snowmanX--;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
