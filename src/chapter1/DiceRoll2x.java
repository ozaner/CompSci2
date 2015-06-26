package programs;
import java.util.Random;
import java.util.Scanner;
public class DiceRoll2x
{
	Random rGen = new Random();
	Scanner scan = new Scanner(System.in);
	int userRoll1, userRoll2, pcRoll1, pcRoll2, asciiIndex;
	char letterChoice;
	boolean choice = true;
	
	//generates the random numbers between 1-6
	public void diceRoll()
	{
		userRoll1 = rGen.nextInt(6) + 1;
		userRoll2 = rGen.nextInt(6) + 1;
		pcRoll1 = rGen.nextInt(6) + 1;
		pcRoll2 = rGen.nextInt(6) + 1;
	}
	
	//outputs what was rolled
	public void outputRolls()
	{
		System.out.println("You rolled a " + userRoll1 + " and a " + userRoll2);
		System.out.println("Your total is " + (userRoll1 + userRoll2));
		
		System.out.println("\nThe computer rolled a " + pcRoll1 + " and a " + pcRoll2);
		System.out.println("Its total is " + (pcRoll1 + pcRoll2));
	}
	
	// determines and outputs whether you won or not
	public void getStatistics()
	{
		if (pcRoll1 + pcRoll2 > userRoll1 + userRoll2)
		{
			System.out.println("\nToo bad you lost");
		}
		if (pcRoll1 + pcRoll2 < userRoll1 + userRoll2)
		{
			System.out.println("\nCongradulations you've won");
		}
		if (pcRoll1 + pcRoll2 == userRoll1 + userRoll2)
		{
			System.out.println("\nIts a tie!");
		}
	}
	
	//aks if you want to redo
	public void redo()
	{
		System.out.println("Would you like to try again?");
		System.out.println("Enter Y/N");
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
		while (choice == true)
		{
			diceRoll();
			outputRolls();
			getStatistics();
			redo();
		}
	}
	
	public static void main(String[] args)
	{
		DiceRoll2x obj = new DiceRoll2x();
		obj.runProgram();
	}
}
