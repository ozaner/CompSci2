package programs;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * This program is an auction simulator that saves its progress in a text file.
 * <br><br>
 * Intro to CS 2 <br>
 * Class: 4
 * @author Ozaner Hansha
 * @author Nicholas Saluzzi
 */
public class Auction
{
	/**
	 * This is for randomly generating the {@link #computerBid}.
	 * @see #bidding()
	 */
	Random randGen = new Random();
	
	/**
	 * This int holds the computer's randomly generated bid.
	 */
	int computerBid = 0;
	
	/**
	 * This holds the user's bid in double precision.
	 */
	double userBid = 0;
	
	/**
	 * This int holds the user's choice of 1,2,3 for the menus.
	 */
	int userInput = 0;
	
	/**
	 * This char holds the user's choice of Y/N.
	 */
	char userInput2;
	
	/**
	 * This int of 1,2 or 3 identifies the type of item currently being bidded on.
	 */
	int currentItem = 0;
	
	/**
	 * This array stores the total sales of each item in double precision.
	 */
	double[] totals = new double[4];
	
	/**
	 * This array stores the total amount of items bought by the user.
	 */
	int[] itemNumbers = new int[4];
	
	/**
	 * This decimal format is for formatting currency printed to the console.
	 */
	DecimalFormat currency = new DecimalFormat("$0.00");
	
	/**
	 * This scanner is used in scanning for the user's input to the console.
	 */
	Scanner scan = new Scanner(System.in);
	
	/**
	 * This scanner is used to load the {@link #totals} and {@link #itemNumbers} from the auction.txt file.
	 */
	Scanner fileScan;
	
	/**
	 * This PrintWriter is used to save the {@link #totals} and {@link #itemNumbers} to the auction.txt file.
	 */
	PrintWriter writer;
	
	/**
	 * This method runs the main menu.
	 * @throws Exception
	 */
	public void mainMenu() throws Exception
	{
		System.out.println("Please select from the following menu options.");
		System.out.println("     1. View items for auction / place bid");
		System.out.println("     2. See total sales");
		System.out.println("     3. Exit program");
		userInput = scan.nextInt(); //checks user input
		scan.nextLine();
		switch(userInput)
		{
		case 1:
			itemsForAuction();
			bidding();
			break;
		case 2:
			seeTotalSales();
			break;
		case 3:
			System.out.println("Thanks for shopping!");
			save();
			System.exit(0);
		}
	}

	/**
	 * This method runs the auction menu.
	 * @see #userInput
	 */
	public void itemsForAuction()
	{
		System.out.println("Items for Action");
		System.out.println("     1. Memorabilia");
		System.out.println("     2. Art");
		System.out.println("     3. Vintage Clothing");
		
		userInput = scan.nextInt(); //checks user input
		scan.nextLine();
		
		switch(userInput)
		{
		case 1:
			currentItem = 1;
			break;
		case 2:
			currentItem = 2;
			break;
		case 3:
			currentItem = 3;
			break;
		default:
			System.out.println("you done messed up");
		}
	}
	
	/**
	 * This method handles user bidding.
	 * @see #computerBid
	 * @see #userBid
	 * @see #userInput2
	 */
	public void bidding()
	{
		System.out.println("Whaz yo bid foo?");
		userBid = scan.nextDouble();
		scan.nextLine();
		
		System.out.println("Are you sure you want to bid " + currency.format(userBid) + ". Y/N");
		userInput2 = scan.nextLine().toUpperCase().charAt(0);
		
		switch(userInput2)
		{
		case 'Y':
			if(currentItem == 1)
				computerBid = randGen.nextInt(101);
			if(currentItem == 2)
				computerBid = randGen.nextInt(51);
			if(currentItem == 3)
				computerBid = randGen.nextInt(181) + 20;
			break;
		default:
			break;
		}
		
		if(userInput2 == 'Y')
		{
			if(userBid > computerBid)
			{
				System.out.println("You won the bid by " + currency.format((userBid - computerBid)) + ". This will be added to your total.");
				totals[currentItem] = totals[currentItem] + userBid; //adds bid amount to total
				itemNumbers[currentItem]++;
			}
			if(computerBid >= userBid)
			{
				System.out.println("The computer bid " + currency.format(computerBid) + ". You lost by " + currency.format(computerBid - userBid) + ".");
			}
		}
	}
	
	/**
	 * This method prints the {@link #totals} and {@link #itemNumbers}.
	 */
	public void seeTotalSales()
	{
		System.out.println("Total Memrobilia: " + currency.format(totals[1]) + " in total & " + itemNumbers[1] + " items were sold");
		System.out.println("Total Art: " + currency.format(totals[2]) + " in total & " + itemNumbers[2] + " items were sold");
		System.out.println("Total Vintage Clothing: " + currency.format(totals[3]) + " in total & " + itemNumbers[3] + " items were sold\n");
	}
	
	/**
	 * Loads the {@link #totals} and {@link #itemNumbers} from the save file before program starts.
	 * @throws Exception
	 */
	public void loadSave() throws Exception
	{
		fileScan = new Scanner(new File(("H:\\Computer Science 2\\saveFiles\\acount.txt")));
		
		totals[1] = fileScan.nextDouble();
		itemNumbers[1] = fileScan.nextInt();
		totals[2] = fileScan.nextDouble();
		itemNumbers[2] = fileScan.nextInt();
		totals[3] = fileScan.nextDouble();
		itemNumbers[3] = fileScan.nextInt();
	}

	/**
	 * Saves {@link #totals} and {@link #itemNumbers} when program exits.
	 * @throws Exception
	 */
	public void save() throws Exception
	{
		writer = new PrintWriter("H:\\Computer Science 2\\saveFiles\\acount.txt", "UTF-8");
		
		for(int x = 1; x != 4; x++)
		{
			writer.println(totals[x]);
			writer.println(itemNumbers[x]);
		}
		writer.close();
	}
	
	/**
	 * Loads save file then loops the main menu method which calls the other methods.
	 * @throws Exception
	 */
	public void runProgram() throws Exception
	{
		loadSave();
		while(true)
		{
			mainMenu();
		}
	}
	
	/**
	 * The main method. Just runs the {@link #mainMenu()} Method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		Auction obj =  new Auction();
		obj.runProgram();
	}
}
