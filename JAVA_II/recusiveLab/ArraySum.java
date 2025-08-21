/**
 * This is a recursive method to sum the values in an array of integers. 
 * @author Sakina Logue
 */

public class ArraySum
{
	//private final static int ARRAYSIZE = 6;

	int sumOfArray(Integer a[], int index)
	{
		if (index<0)
		{
			return 0;                	                                    
		}
		else
		return a[index] + sumOfArray(a, --index);
	}

}