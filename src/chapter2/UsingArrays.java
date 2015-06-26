package programs;

public class UsingArrays
{

	boolean[] lockers = new boolean[1001]; //Using 0-1001 instead of 0-1000 for simplicity
	int openLockers = 0;
	String list = "";
	
	//this methods solves the locker problem
	public void openLockers()
	{
		//first student opens all the lockers to start
		for (int x = 1; x <= 1000; x++)
		{
			lockers[x] = true;
		}
		
		//every other student reverses the locker's state
		for (int student = 2; student <= 1000; student ++)
		{
			for (int currentLocker = student; currentLocker <= 1000; currentLocker += student)
			{
				if(lockers[currentLocker])
				{
					System.out.println("Student " + student + " is closing locker " + currentLocker);
				}
				else
				{
					System.out.println("Student " + student + " is opening locker " + currentLocker);
				}
				lockers[currentLocker] = !lockers[currentLocker];	
			}
		}
	}
	
	//this method prints the open (true) lockers
	public void printResults()
	{
		for(int x = 1; x <= 1000; x++)
		{
			if(lockers[x])
			{
				openLockers++;
				list += x + " ";
			}
		}
		
		System.out.println("\nThere are " + openLockers + " lockers open.");
		System.out.println("The open lockers are: " + list);
	}
	
	public static void main(String[] args)
	{
		UsingArrays obj = new UsingArrays();
		obj.openLockers();
		obj.printResults();
	}
}
