/* 
 This program Build an application that will step through some possible problems to restore internet connectivity. 
  Assume that the computer uses wifi to connect to a router, 
  which connects to an Internet Service Provider (ISP) which connects to the Internet.
 */



import java.util.Scanner;//To read inputs
public class WifiDiagnosis 
{

	public static void main(String[] args) 
	{
		String choice; //To hold the answer yes or no of the user
		Scanner keyboard = new Scanner(System.in);//Declare a class type variable keyboard as a scanner 
		
		System.out.println("Hi!\nIf you have a problem with your internet connectivity," //Introductory message
							+ "this wifi Diagnosis might work.");
		System.out.print("\nFirst step: please, reboot your computer");
		System.out.print("\nAre you able to connect back with the internet? (yes or no)\n");
		//Prompt the user to enter a yes or no
		
		choice = keyboard.nextLine(); //Read a line(yes or no entered) from keyboard to choice
		

		if (choice.equals("yes"))
			System.out.print("\nRebooting your computer seemed to work!!\n");
		
		else 
		{
			System.out.print("\nSecond step: reboot your router\n");
			System.out.print("Now, are you able to connect back with the internet? (yes or no)\n");//Prompt
			choice = keyboard.nextLine();
			
			if (choice.equals("yes"))
				System.out.print("\nRebooting your router seemed to work!!\n");
			
			else
			{
				System.out.print("\nThird step: make sure the cables to your router are plugged in firmly\n"
			                      +"            and your router is getting power.");
				System.out.print("\nNow, are you able to connect back with the internet? (yes or no)\n");//prompt
				choice = keyboard.nextLine();
				
				if (choice.equals("yes"))
					System.out.print("\nChecking the router's cables seemed to work!!\n");
				
				else 
				{
					System.out.print("\nFourth step: move the computer closer to the router" 
				                     + "and try to connect\n");
					System.out.print("Now, are you able to connect back with the internet? (yes or no)\n");//prompt
					choice = keyboard.nextLine();
					
					if (choice.equals("yes"))
						System.out.print("\nMoving the computer closer to the router your router seemed to work!!\n");
					
					else 
					{
						System.out.print("\nFifth step: contac your ISP\n"
								+ "Make sure your ISP is hooked up to your router.\n");
						               
					}
				}
				
			
			}
		}
		System.out.print("\nThank you for testing my program!!\n\n");
		System.out.print("\nProgrammer: Sakina Lougue"
				         +"\nAssigment1"
				         +"\nDue date: September, 4th, 2020");
		keyboard.close();//To close the Scanner class as I opened it at the begin

	}

}
