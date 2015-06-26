package programs;

import java.util.Scanner;

public class UsingSwitch
{
	Scanner scan = new Scanner(System.in);
	char grade;
	
	public void runProgram()
	{
		System.out.println("Enter a letter grade");
		grade = scan.nextLine().charAt(0);
		
		switch(grade)
		{
		case 'a':
		case 'A':
			System.out.println("Good job");
			break;
		case 'b':
		case 'B':
			System.out.println("ok");
			break;
		case 'c':
		case 'C':
			System.out.println("ehh");
			break;
		case 'd':
		case 'D':
			System.out.println("What are you even doing");
		}
	}
	
	public static void main(String[] args)
	{
		UsingSwitch obj = new UsingSwitch();
		obj.runProgram();
	}
}
