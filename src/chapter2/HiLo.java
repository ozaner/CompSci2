package programs;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class HiLo extends CommonMethods
{
	int generatedNum, guessNum, guesses, highScore, inputParsed, input2;
	String name, highName, input;
	
	//The method that runs the HiLo Game
	public void playGame() throws Exception
	{
		//these four lines initialize the game
		loadScore();
		loop = true;
		guesses = 0;
		generatedNum = random.nextInt(100) + 1;
		
		//Keeps repeating until guess is correct
		do
		{
			System.out.println("Enter a number between 1 and 100, or type q to quit.\n");
			input = scan.nextLine();
			if(input.equals("q"))
			{
					System.out.println("You quit the game.\n");
					loop = false;
			}
			else
			{
				inputParsed = Integer.parseInt(input);
				guesses++;
				if(inputParsed == generatedNum)
				{
					System.out.println("You guessed correctly");
					if(guesses < highScore) //records highscore if it beat the old one.
					{
						highscoreAchieved();
					}
					loop = false;
				}
				else if(inputParsed > generatedNum)
				{
					System.out.println("You're High");
				}
				else if(inputParsed < generatedNum)
				{
						System.out.println("You're Low");
				}
			}
			        
		}
		while(loop);
	}
	
	//runs if a highscore has been made
	public void highscoreAchieved() throws Exception
	{
		write = new PrintWriter("H:\\Computer Science 2\\saveFiles\\HiLo.txt","UTF-8");
		write.println(guesses);
		write.println(name);
		write.close();
	}
	
	//runs if the score needs to be referenced
	public void loadScore() throws Exception
	{
		fileScan = new Scanner(new File("H:\\Computer Science 2\\saveFiles\\HiLo.txt"));
		highScore = fileScan.nextInt();
		fileScan.nextLine();
		highName = fileScan.nextLine();
	}
	
	//the Main menu method where you can play, check the highscore and quit
	public void mainMenu() throws Exception
	{
		System.out.println("What's your name?");
		name = scan.nextLine();
		
		do
		{
			System.out.println("Enter 1 to play, 2 for highscore, and 3 to quit.");
			input2 = scan.nextInt();
			scan.nextLine();
		
			switch(input2)
			{
				case 1:
					playGame();
					break;
				case 2:
					loadScore();
					System.out.println("The best guesser is: " + highName + " with a highscore of " + highScore);
					break;
				case 3:
					System.out.println("Goodbye");
					System.exit(0);
					break;
				default:
					System.out.println("That wasn't an option. Can you read? Here let's try again.");
					break;
			}
		}
		while(loop2);
	}
	
	public static void main(String[] args)
	{
		HiLo obj = new HiLo();
		try
		{
			obj.mainMenu();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
