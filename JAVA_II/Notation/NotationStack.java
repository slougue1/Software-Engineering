/**
 * this class is a stack
 * @author Sakina Lougue
 *
 * @param <T>
 */
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>
{
	private T arr[];
    private int size;
    private int index ;
    
    /**
	 * this is a parametric MyStack 
	 * @param size size of the array
	 */
	public NotationStack(int i) 
	{
		this.size = i;
        arr =   (T[]) new Object[i];
        index = 0;
	}

	/**
	 * this is a parametric isEmpty 
	 * @return index return the boolean value, eitheri true or flase
	 */
	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	/**
	 * this is a parametric isFull 
	 * @return index return the boolean value, eitheri true or flase
	 */
	@Override
	public boolean isFull() {
		 return index == size;
	}

	/**
	 * this is a parametric pop 
	 * @return index return the object T object value
	 * @throws StackUnderflowException
	 */
	@Override
	public T pop() throws StackUnderflowException 
	{
		if (isEmpty()) 
		{
            throw new StackUnderflowException("Emply Stack!");
        }
        return arr[--index];
	}

	/**
	 * this is a parametric pop 
	 * @return arr[index-1] return the object T value
	 * @throws StackUnderflowException
	 */
	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
            throw new StackUnderflowException("Emply Stack!");
        }
        return arr[index-1];
	}

	/**
	 * this is a method Size 
	 * @return index
	 */
	@Override
	public int size() 
	{
		 return index;
	}

	
	@Override
	public boolean push(T tObject) throws StackOverflowException 
	{
		 if (isFull()) 
		 {
	            throw new StackOverflowException("Stack is full");
	        }

	        arr[index] = tObject;
	        index++;
	        return true;
	}

	@Override
	public String toString(String delimiter) 
	{
		StringBuilder aString = new StringBuilder();
        for (int index1 = 0; index1 <index; index1++) 
        {
        	aString.append(arr[index1].toString());
            if (index1!=index-1)
            {
            	aString.append(delimiter);
            }
        }
        return aString.toString();
	}

	@Override
	public void fill(ArrayList<T> list) 
	{
		arr =   (T[]) new Object[size];
		index = 0;
		try
		{
			for(T t:list) 
			{
				push(t);
			}
		}
		catch(StackOverflowException anExecption) 
		{
			System.out.println(anExecption);
		}
	}
	
	@Override
	public String toString() 
	{
		String result = "";
		for(int index1=0; index1 < index; index1++)
		{
			result += arr[index1];
		}
		return result;
	}

}
