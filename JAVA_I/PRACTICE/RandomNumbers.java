/**
 *This program builds an application that will receive a guess and report if user's guess is the random number that was generated.  
 *The application will narrow down the choices according to your previous guesses, 
 *and continue to prompt you to enter a guess until you guess correctly.
 *Name: Sakina Lougue
 *Due Date = September, 28th, 2020
 */

import java.util.Scanner;       //to read user's inputs from the keyboard

/**
 * This is the data element class that will be using the driver class RNG to run and compile
 * It contains only one method, the main method 
 */

public class RandomNumbers      //Compilable and runnable class with the main method
{
	/**This main method executes all the tasks in the program.
	 * It contains an outer do while loop, two inner while loop, and an inner if statement.
	 * Then it display a thank you message and the programmer name all the way at the bottom
	 * @param args accepts an argument of class type String array
	 */
	public static void main(String[] args) 
	{
		final String PROGRAMMER_NAME = "Sakina Lougue";
		final String DUE_DATE = "Semptember, 28th, 2020";
		String choice;
		
		int randNumd,      //to hold random numbers
		nextGuess,         //to hold the next number guessed by the user
		highGuess,         //to hold to maximum number; ex: next guess < high guess
		lowGuess;          //to hold the minimum number; ex low guess < next guess

		Scanner keyboard = new Scanner(System.in);      //Creating an object keyboard from the class Scanner 
		                                                //to read inputs from the keyboard (!=from the Scanner variable keyboard)
System.out.println("Hi! This is a random number guesser game.\nThe program will generate a random number and you will try to guess it\n"
		           +"You don't have to guess it right at your first try. You will have several attempts\n");
       /*
        * Used a do while loop because I wanted the inside of the loop to perform at least once, even if the user enters no at the bottom
        *This do while loop contains the whole code so that I can have a control on the number of repeating: 
        *        (1) the input validation until the user enters it with in the specified range
        *        (2) keep guessing the number until it is equal to the random number
        *        (3) repeat the whole process above if the user entered yes when prompted 
        */
		do  
		{              /*OUTER DO LOOP START*/
			randNumd = RNG.rand();                     //Assigning the value of the random number from the RNG class to randNumber
			                                           //Generate a new random number for each try
			System.out.println("Please enter your first guess between 0 and 100: ");  //prompt the user to enter a number between 0 100
			nextGuess = keyboard.nextInt();                                           //read the number entered and assign it to the variable nextGuess
			lowGuess=0;                                                               //Set the lowest guess to 0 for the first try
			highGuess=100;                                                            //Set the highest guess to 100 for the first try

			     /*FIRST INNER WHILE LOOP START*/
			while(!RNG.inputValidation(nextGuess, lowGuess, highGuess))      //Verifying the validity of the guess number entered                           
			{   
				nextGuess=keyboard.nextInt();
			}     
			     /*FIRST INNER WHILE LOOP END*/ 

			     /*SECCOND INNER WHILE LOOP START*/
			while(nextGuess != randNumd)         //Verifying 2 general conditions, guessed number greater or less than random number !!                                 
			{	
				 //First condition, is the number entered greater than the random number? 
				if ((nextGuess > randNumd))
				{  
					//If yes, the following statement should be displayed
					System.out.println("Number of guess is " + RNG.getCount());

					System.out.println("Your guess is too high");
					highGuess = nextGuess;
					System.out.println("Enter a guess between " + lowGuess + " and " + highGuess);
					nextGuess=keyboard.nextInt();

					//Checking if the number entered is in between the range
					while (!RNG.inputValidation(nextGuess, lowGuess, highGuess))  	  
					{ 
						nextGuess=keyboard.nextInt();
					}                
				}

				 //Second condition, is the number entered less than the random number?
				else if (nextGuess < randNumd)
				{ 
					//If yes, the following statement should be displayed
					System.out.println("Number of guess is " + RNG.getCount());

					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
					System.out.println("Enter a guess between " + lowGuess + " and " + highGuess);
					nextGuess = keyboard.nextInt();

					//Checking if the number entered is in between the range	   
					while (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) 
					{	
						nextGuess=keyboard.nextInt();
					}
				}

			}         /*SECOND INNER WHILE LOOP END*/ 
			
			  //If the guessed number is neither greater nor less than the random number, then it should be equal to the random number
			  //And the following statement should be executed
			if (nextGuess == randNumd)   
			{  
				System.out.println("Number of guess is " + RNG.getCount());
				System.out.println("Congratulations, you guessed correctly"); 	
			}

			System.out.println("Would you like to try again? (yes or no) ");
			RNG.resetCount();
			keyboard.nextLine();
			choice =keyboard.nextLine();
			System.out.println();
		}                          /*OUTER LOOP END*/
		
		while (choice.equalsIgnoreCase("yes")); 
		
		System.out.println();
	    System.out.println("Thank you for testing my program!!\n");
	    System.out.println("Programmer name: " + PROGRAMMER_NAME);
	    System.out.println("       Due date: " + DUE_DATE);

		keyboard.close();          //To close the location I opened with the java.util statement
	}
}

