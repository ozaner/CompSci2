package programs;

import java.util.Scanner;

public class Compare2Averages
{
	Scanner scan = new Scanner(System.in);
	int firstGrade, secondGrade, thirdGrade, fourthGrade;
	double averageOne, averageTwo;
	
	public void getUserInput()
	{
		System.out.println("Enter the first grade to be averaged");
		firstGrade = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter the second grade to be averaged");
		secondGrade = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter another first grade to be averaged");
		thirdGrade = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter another second grade to be averaged");
		fourthGrade = scan.nextInt();
		scan.nextLine();
	}
	
	public void averageGrades()
	{
		averageOne = (firstGrade + secondGrade) / 10;
		averageTwo = (thirdGrade + fourthGrade) * .1;
	}
	
	public void compareOutput()
	{
		if (averageOne > averageTwo)
		{
			System.out.println("The first average, " + averageOne + " is higher.");
		}
		else
		{
			if (averageOne < averageTwo)
			{
				System.out.println("The second average, " + averageTwo + " is higher.");
			}
			if (averageOne == averageTwo)
			{
				System.out.println("Both averages are equal. They equal: " + averageOne);
			}
		}
	}
	
	public void runProgram()
	{
		getUserInput();
		averageGrades();
		compareOutput();
	}
	
	public static void main(String[] args)
	{
		Compare2Averages obj = new Compare2Averages();
		obj.runProgram();
	}
}
