package programs;
import java.text.DecimalFormat;
public class UsingMathAndFormat
{
	DecimalFormat USD = new DecimalFormat("$0.00");
	DecimalFormat percent = new DecimalFormat("0.0%");
	DecimalFormat place3 = new DecimalFormat("0.000");
	double num;
	
	//Math class example
	public void runMath()
	{
		num = Math.random();
		System.out.println("the random number is " + num);
		
		num = 40*num + 10;
		System.out.println("number between 10-50: " + num);
		
		num = Math.pow(num, 2);
		System.out.println("the square of it is: " + num);
		
		num = Math.sqrt(num);
		System.out.println("the square of it is: " + num);
	}
	
	//format class example
	public void runFormat()
	{
		num = Math.random();
		System.out.println("Original number is " + num);
		
		System.out.println("usd value: " + USD.format(num));
		System.out.println("percent value: " + percent.format(num));
		System.out.println("place3 value: " + place3.format(num));
	}
	
	public static void main(String[] args)
	{
		UsingMathAndFormat obj = new UsingMathAndFormat();
		obj.runMath();
		obj.runFormat();
	}
}