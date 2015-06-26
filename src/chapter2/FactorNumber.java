package programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class FactorNumber extends CommonMethods
{
	ArrayList<Integer> factors = new ArrayList<>();
	int num, userInput;
	boolean isPrime, isAboveOne;
	String lastFactor;
	
	public void getNum()
	{
		System.out.println("Please enter a positive integer to be factored.");
		num = scan.nextInt();
		scan.nextLine();
	}
	
	//Checks if the number is prime and acts accordingly
	public void primeCheck() throws Exception
	{	
		//reset variables and objects
		factors.clear();
		isPrime = true;
		isAboveOne = true;
		
		if (num <= 1) //Checks for 0, 1
		{
			isAboveOne = false;
		}
		
		if(isAboveOne)
		{
			for(int x = 2; x <= num/2; x++)
			{
	            if(num % x == 0)
	            {
	            	isPrime = false;
	            }
			}
		}
		else
		{
			isPrime = false;
		}
		
		if(isPrime) //Chooses to factor or end
		{
			System.out.println("This is a prime number and has no factors other than 1 and itself.");
			write = new PrintWriter("H:\\Computer Science 2\\saveFiles\\FactorNumber.txt","UTF-8");
			write.println("The last number factored was the Prime number " + num);
			write.close();
		}
		else
		{
			factor();
		}
	}
	
	//factors the number when number is not prime
	public void factor() throws Exception
	{
		for(int x2 = 1; x2 <= num; x2++)
		{
			if(num % x2 == 0)
			{
				factors.add(x2);
			}
		}
		System.out.println("The factors of " + num + " are:\n" + factors);
		
		write = new PrintWriter("H:\\Computer Science 2\\saveFiles\\FactorNumber.txt","UTF-8");
		write.println(factors);
		write.close();
	}
	
	//Reads the last
	public void viewLastFactor() throws Exception
	{
		fileScan = new Scanner(new File("H:\\Computer Science 2\\saveFiles\\FactorNumber.txt"));
		lastFactor = fileScan.nextLine();
		System.out.println(lastFactor);
	}
	
	//Runs main menu
	public void runProgram() throws Exception
	{
		do
		{
			System.out.println("\nWould you like to:\n1. Factor a number?\n2. View last factor?\n3. Quit?");
			userInput = scan.nextInt();
			scan.nextLine();
			switch(userInput)
			{
			case 1: getNum();
					primeCheck(); //if !isPrime then it'll goto factor()
					break;
					
			case 2: viewLastFactor();
					break;
					
			case 3: System.exit(0);
					break;
			}
		}
		while(loop);
	}
	
	public static void main(String[] args)
	{
		FactorNumber obj = new FactorNumber();
		try
		{
			obj.runProgram();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}