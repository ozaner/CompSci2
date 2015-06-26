package programs;

import java.util.TimerTask;

public class MGameTimer extends TimerTask
{
	public void timerEvent()
	{
		System.out.println("You've ran out of time!\nYOU LOSE!");
		System.exit(0);
	}
	
	public void run()
	{
		timerEvent();
	}
}