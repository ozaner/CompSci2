package programs;
import java.util.Random;
public class UsingRandom
{
	//creates objects and variables
	Random rGen = new Random();
	int rInt;
	char rChar;
	
	//Runs program
	public void runProgram()
	{
		rGen.setSeed(1043);
		rInt = 5*rGen.nextInt(9) + 10;
		System.out.println("The random integer is " + rInt);
		rInt = 5*rGen.nextInt(9) + 10;
		System.out.println("The random integer is " + rInt);
		rInt = 5*rGen.nextInt(9) + 10;
		System.out.println("The random integer is " + rInt);
		
		//Generates random lowercase letter
		rChar = (char)(rGen.nextInt(26)+97);
		System.out.println("The random integer is " + rChar);
	}
	
	public static void main(String[] args)
	{
		UsingRandom obj = new UsingRandom();
		obj.runProgram();
	}
}
