import java.util.Scanner;// to use scanner class
public class SphereVolume 
{

	public static void main(String[] args) 
	{   
		//declare my variables
		Scanner keyboard = new Scanner(System.in);//
		double diam,
		       radius,
		       volume;
		
		
		System.out.println("This program calculates the result of a mathematical formula");
		System.out.print("\nPlease enter a number as a diameter for a sphere: ");
		diam = keyboard.nextDouble();
		
		if (diam >=0)
		{//calculate the radius
		radius = (double) diam/2;
		volume = ((double)4/3) *Math.PI * Math.pow(radius, 3);
		System.out.println("The volume of a sphere with a radius of "
		                    +radius + " is " + volume + (" cube unit"));
		}
		
		while (diam < 0)
		{
			System.out.print("!!The diameter has to be greater than 0!!"
					           + "\n!!Please re-enter a number as a diameter greater than 0!! ");
			diam = keyboard.nextDouble();
			System.out.println();
			
		   if (diam >= 0)
			{radius = (double) diam/2;
			volume = ((double)4/3) *Math.PI * Math.pow(radius, 3);
			System.out.println("The volume of a sphere with a radius of "
			                    +radius + " is " + volume + (" cube unit"));
			}
		}
		keyboard.close();
	}

}
