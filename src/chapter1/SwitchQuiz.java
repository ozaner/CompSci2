package programs;

import java.util.Scanner;

public class SwitchQuiz extends CommonMethods
{
	Scanner scan = new Scanner(System.in);
	//creates variables
	int points, score;
	char input, letterChoice;
	boolean loop = true;
	boolean choice = true;
	
	//Asks and processes first question
	public void question1()
	{
		System.out.println("1. What is the radius of a circle with an Area of 25pi?");
		System.out.println("A. 2.5\nB. infinity\nC. 5\nD. False");
		input = scan.nextLine().charAt(0);
		while(loop)
		{
			switch(input)
			{
				case 'C':
				case 'c':
					System.out.println("Coooooooorect!");
					points++;
					loop = false;
					break;
				case 'A':
				case 'a':
				case 'B':
				case 'b':
				case 'D':
				case 'd':
					System.out.println("FAILURE!");
					loop = false;
					break;
				default:
					System.out.println("Please enter an A/B/C/D");
					input = scan.nextLine().charAt(0);
			}
		}
	}
	
	//Asks and processes second question
	public void question2()
	{
		System.out.println("2. Where are you right now?");
		System.out.println("A. The Moon\nB. A104\nC. Eastern Europe\nD. The 1990's");
		input = scan.nextLine().charAt(0);
		loop = true;
		while(loop)
		{
			switch(input)
			{
				case 'B':
				case 'b':
					System.out.println("Coooooooorect!");
					points++;
					loop = false;
					break;
				case 'A':
				case 'a':
				case 'C':
				case 'c':
				case 'D':
				case 'd':
					System.out.println("FAILURE!");
					loop = false;
					break;
				default:
					System.out.println("Please enter an A/B/C/D");
			}
		}
	}
	
	//Asks and processes second question
	public void question3()
	{
		System.out.println("3. 15 minutes could save you...");
		System.out.println("A. your baby\nB. life\nC. a bag of cheetos\nD. 15% or more on car insurance");
		input = scan.nextLine().charAt(0);
		loop = true;
		while(loop)
		{
			switch(input)
			{
				case 'D':
				case 'd':
					System.out.println("Coooooooorect!");
					points++;
					loop = false;
					break;
				case 'A':
				case 'a':
				case 'B':
				case 'b':
				case 'C':
				case 'c':
					System.out.println("FAILURE!");
					loop = false;
					break;
				default:
					System.out.println("Please enter an A/B/C/D");
			}
		}
	}
	
	//Asks and processes second question
	public void question4()
	{
		System.out.println("4. What is life");
		System.out.println("A. Computer Mice\nB. enlightnment\nC. Shrek the ogre\nD. the condition that distinguishes animals and plants from inorganic matter");
		input = scan.nextLine().charAt(0);
		loop = true;
		while(loop)
		{
			switch(input)
			{
				case 'D':
				case 'd':
					System.out.println("Coooooooorect!");
					points++;
					loop = false;
					break;
				case 'A':
				case 'a':
				case 'B':
				case 'b':
				case 'C':
				case 'c':
					System.out.println("FAILURE!");
					loop = false;
					break;
				default:
					System.out.println("Please enter an A/B/C/D");
			}
		}
	}
	
	//Calculates Score and prints it out
	public void calculateScore()
	{
		score = points * 25;
		System.out.println("You got " + points + "/4 right. Thats a " + score + "%!");
	}
	
	//asks if you want to redo
		public void redo()
		{
			System.out.println("Would you like to try again?");
			System.out.println("Enter Y/N to Continue");
			letterChoice = scan.nextLine().toUpperCase().charAt(0);
			
			switch (letterChoice)
			{
				case 'Y':
				case 'y':
					choice = true;
					break;
				case 'N':
				case 'n':
					choice = false;
					break;
				default:
					System.out.println("Please Enter Y/N Only");
					redo();
			}
		}
	
	//Runs the program
	public void runProgram()
	{
		while (choice)
		{
			question1();
			question2();
			question3();
			question4();
			calculateScore();
			points = 0;
			redo();
		}
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		SwitchQuiz obj = new SwitchQuiz();
		obj.runProgram();
	}
}
