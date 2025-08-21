
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class is a data manager that allows the user to read the courses from a file or to enter the data by hand, 
 * and uses an Alert to print out the database elements. 
 * The input is read from a file or read from the text-fields and is added to the data structure through the add method
 * @author Sakina Lougue
 *
 */

public class CourseDBManager implements CourseDBManagerInterface 
{
	private CourseDBStructure CDS = new CourseDBStructure(20);
	
	/**
	 * This method uses the add method from CourseDBStructure class.
	 * @param id - the course ID
	 * @param crn - the course CRN
	 * @param numOfCredits - the number of course's credits
	 * @param roomNum - the room number
	 * @param instructor - the instructor name
	 */
	@Override
	public void add(String id, int crn, int numOfCredits, String roomNum, String instructor) 
	{
		CourseDBElement newElement = new CourseDBElement(id, crn, numOfCredits, roomNum, instructor);
		CDS.add(newElement);
	}
	
	/**
	 * This method uses the get method from CourseDBStructure class.
	 * @param crn - the course CRN
	 * @return null 
	 */
	@Override
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return CDS.get(crn);
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		return null;
	}
	
	/**
	 * This method takes the given File object and creates CourseDBElement objects from the values from each line.
	 * @throws FileNotFoundException 
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		try {
			Scanner fileData = new Scanner(input);
			while(fileData.hasNext())               //Use has.next method to check if there is any more line to be read
			{
				String id = fileData.next();
				int crn = fileData.nextInt();
				int numOfCredits = fileData.nextInt();
				String roomNum = fileData.next();
				String instructor = fileData.nextLine();
				add(id, crn, numOfCredits, roomNum, instructor);
			}
			fileData.close();
		}
		catch(FileNotFoundException e) 
		{
			System.out.print("File not found");
			e.getMessage();
		}
	}
	
	/**
	 * This method traverses through a hashtable and its buckets
	 * and converts each CourseDBElement object into a string that 
	 * is put into a arraylist.
	 * @return list - the list containing the CRN, the course name,...
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for (int row = 0; row < CDS.hashTable.length; row++) 
		{            // loop through hashTable
			LinkedList<CourseDBElement> List2 = CDS.hashTable[row];
			if(List2 != null) 
			{
				for(int col = 0; col < List2.size(); col++) 
				{          // loop through buckets
					CourseDBElement element = List2.get(col);
					list.add(element.toString());
				}
			}
		}
		return list;
	}

}