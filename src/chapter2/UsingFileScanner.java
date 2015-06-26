package programs;

import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class UsingFileScanner
{
	int input;
	boolean loop = true;
	Scanner scan = new Scanner(System.in);
	Scanner fileScan;
	PrintWriter writer;
	
	public void setInfo()
	{
		try
		{
			writer = new PrintWriter("H:\\Computer Science 2\\saveFiles\\UsingFileScanner.txt","UTF-8");
			System.out.println("Input a Name");
			writer.println(scan.nextLine());
			System.out.println("Input a Street");
			writer.println(scan.nextLine());
			System.out.println("Input a Town");
			writer.println(scan.nextLine());
			System.out.println("Input a Zip Code");
			writer.println(scan.nextLine());
			
			writer.close();
		}
		catch (IOException ioe)
		{
			System.out.println("Error: " + ioe.getMessage());
		}
	}
	
	public void getInfo()
	{
		try
		{
			fileScan = new Scanner(new File("H:\\Computer Science 2\\saveFiles\\UsingFileScanner.txt"));
			System.out.println("The current adress is:");
			System.out.println("Name: " + fileScan.nextLine());
			System.out.println("Street: " + fileScan.nextLine());
			System.out.println("Town: " + fileScan.nextLine());
			System.out.println("Zip Code: " + fileScan.nextLine());
		}
		catch (IOException ioe)
		{
			System.out.println("Error: " + ioe.getMessage());
		}
	}
	
	public void runProgram()//menu
	{
		do
		{
			System.out.println("Press 1 to read the current adress, \nPress 2 to overwrite it and 3 to quit.");
			input = scan.nextInt();
			scan.nextLine();
			
			switch(input)
			{
			case 1:
				getInfo();
				break;
			case 2:
				setInfo();
				break;
			case 3:
				loop = false;
				break;
			default:
				System.out.println("Invalid, try again.");
			}
		}
		while(loop);
	}
	
	public static void main(String[] args)
	{
		UsingFileScanner obj = new UsingFileScanner();
		obj.runProgram();
	}
}
