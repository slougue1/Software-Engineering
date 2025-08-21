import java.util.Scanner;
public class MovieDriver 
{

	public static void main(String[] args) 
	{   
		String input;
		char choice;
		
	    Scanner keyboard = new Scanner(System.in);
		Movie m1 = new Movie();
		
		do
		{
			
		
		System.out.println("Enter the title of a movie: ");
		String title = keyboard.nextLine();
		m1.setTitle(title);
		
		System.out.println("Enter the rating of the movie: ");
	    String rating = keyboard.nextLine();
		m1.setRating(rating);
		
		
		System.out.println("Enter the number of tickets sold for this movie: ");
		int soldTickets = keyboard.nextInt();
		m1.setSoldTickets(soldTickets);
		
		System.out.println(m1.toString());
		
		System.out.println("Do you want ot enter another (yes or no): ");
		keyboard.nextLine();
		input = keyboard.nextLine();
		choice = input.charAt(0);
		}
		while (choice == 'y');
		
		System.out.print("\nGoodbye" + "\n programmer: Sakina Lougue.");

		keyboard.close();
	   
	}

}
