import java.util.Scanner;
/**
   This program demonstrates how numeric types and operators behave in Java
*/
public class NumericTypes 
{
	public static void main (String [] args) 
	{
		Scanner keyboard = new Scanner(System.in);//TASK #2 Create a Scanner object here 
		String output; // line of output to print out
		
		//identifier declarations
		final int NUMBER = 2; // number of scores
		int score1 ; // first test score
		int score2 ; // second test score
		final int BOILING_IN_F = 212; // boiling temperature
		
		double fToC; // temperature in Celsius
		double average; // arithmetic average
		double temperature;//Task #2 declare a variable to hold the user’s temperature
		
		System.out.print("Please enter your first test score: ");//Task #2 prompt user to input score1
		score1=keyboard.nextInt();//Task #2 read score1 
		System.out.print("Please enter your second test score: ");//Task #2 prompt user to input score2
		score2=keyboard.nextInt();//Task #2 read score2 
		// Find an arithmetic average
		average = (score1 + score2) / (double)NUMBER;
		output = score1 + " and " + score2 + " have an average of " + average;	
		System.out.println(output);
		System.out.println();
		System.out.println("Now, let's convert temperature from dregrees fahrenheit to celsius!! ");
		// Convert Fahrenheit temperatures to Celsius
		fToC = ((double)5/9) * (BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.\n";
		
		System.out.println(output);
		System.out.print("Please enter another temperature (in fahrenheit): ");//Task #2 prompt user to input another temperature
		temperature=keyboard.nextDouble();//Task #2 read the user’s temperature in Fahrenheit
		temperature = ((double)5/9) * (temperature - 32); //Task #2 convert the user’s temperature to Celsius
		System.out.println("The temperature in fahrenheit you enterd is equals to "
				         + temperature + "celsius");//Task #2 print the user’s temperature in Celsius
		System.out.println("\nGoodbye"); // to show that the program is ended
		
		keyboard.close();
	}
}
