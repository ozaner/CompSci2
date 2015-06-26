package programs;
import java.text.DecimalFormat;
import java.util.Scanner;
public class RightTriangle
{
	char letterChoice;
	int asciiIndex;
	double leg1, leg2, hyp;
	boolean choice = true;
	Scanner scan = new Scanner(System.in);
	DecimalFormat triplePlace = new DecimalFormat("0.000");
	
	//Gets user input
	public void askForLegs()
	{
		System.out.println("What is the 1st leg?");
		leg1 = scan.nextDouble();
		scan.nextLine();
		
		System.out.println("What is the 2st leg?");
		leg2 = scan.nextDouble();
		scan.nextLine();
	}
	
	//calculates the hypotnuse
	public void calculateHyp()
	{
		hyp = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
	}
	
	//asks if you want to redo
	public void redo()
	{
		System.out.println("Would you like to try again?");
		System.out.println("Enter Y/N to Continue");
		letterChoice = scan.nextLine().toUpperCase().charAt(0);
		asciiIndex = (int)letterChoice;
		
		if (asciiIndex == 89)
		{
			choice = true;
		}
		else
		{
			choice = false;
		}
	}
	
	//runs the program
	public void runProgram()
	{
		while(choice == true)
		{
			askForLegs();
			calculateHyp();
			System.out.println("The hypotenuse is " + triplePlace.format(hyp));
			redo();
		}
	}
	
	public static void main(String[] args)
	{
		RightTriangle obj = new RightTriangle();
		obj.runProgram();
	}
}