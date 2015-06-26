package programs;

public class UsingWhileLoops extends CommonMethods
{
	int num;
	
	public void countBackwards()
	{
		System.out.println("Enter an Integer");
		num = scan.nextInt();
		scan.nextLine();
		while (num > 0)
		{
			num--;
			System.out.println(num);
		}
	}
	
	public void countForward50()
	{
		System.out.println("Enter an Integer");
		num = scan.nextInt();
		scan.nextLine();
		while (num != num + 50)
		{
			num++;
			System.out.println(num);
		}
	}
	
	public static void main(String[] args)
	{
		UsingWhileLoops obj = new UsingWhileLoops();
		obj.countForward50();
	}
}
