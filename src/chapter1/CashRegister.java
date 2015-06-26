package programs;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class CashRegister
{
	Random rand = new Random();
	String item;
	Scanner scan = new Scanner(System.in);
	DecimalFormat percentage = new DecimalFormat("00.##%");
	DecimalFormat currency = new DecimalFormat("$0.00");
	DecimalFormat integers = new DecimalFormat("0.##");
	double priceReduction = 5*rand.nextInt(15) + 5, oPrice, percent, amountOff, salesPrice, tax, totalPrice, 
			paid, change, remainder, dollers, quarters, dimes, nickels, pennies;
	boolean choice = true;
	char letterChoice;
	int asciiIndex;

	//gathers user input
	public void userInput()
	{
		System.out.println("What is the name of the item?");
		item = scan.nextLine();
		System.out.println("What is the price of the item?");
		oPrice = scan.nextDouble();
		scan.nextLine();
	}

	//calculates the data about your purchase
	public void calculate()
	{
		percent = priceReduction*.01;
		amountOff = oPrice*percent;
		salesPrice = oPrice - amountOff;
		tax = salesPrice*0.07;
		totalPrice = salesPrice + tax;
	}

	//outputs all the data about your purchase
	public void output()
	{
		System.out.println("The Original Price is " + currency.format(oPrice));
		System.out.println("The Discount is " + currency.format(amountOff));
		System.out.println("The Discount % is " + percentage.format(percent));
		System.out.println("The Sales Price is " + currency.format(salesPrice));
		System.out.println("The Tax is " + currency.format(tax));
		System.out.println("The Total Price is " + currency.format(totalPrice));
	}

	//calculates the change based off what you payed
	public void change()
	{
		System.out.println("How much are you paying the cashier?");
		paid = scan.nextDouble();
		scan.nextLine();
		change = paid - totalPrice;
		change = change*100;
		
		dollers = (int)change/100;
		remainder = (int)change%100;
		
		quarters = (int)remainder/25;
		remainder = (int)remainder%25;
		
		dimes = (int)remainder/10;
		remainder = (int)remainder%10;
		
		nickels = (int)remainder/5;
		remainder = (int)remainder%5;
		
		pennies = remainder;
		
		System.out.println("Your change is " + integers.format(dollers) + " doller(s), " 
			+ integers.format(quarters) + " quarter(s), " + integers.format(dimes) + " dime(s), " 
				+ integers.format(nickels) + " nickel(s), " + integers.format(pennies) + " penn(y)(ies).");
	}

	//asks if you want to redo
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
			userInput();
			calculate();
			output();
			change();
			redo();
		}
	}
	
	public static void main(String[] args)
	{
		CashRegister obj = new CashRegister();
		obj.runProgram();
	}
}