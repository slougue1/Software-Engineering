/**
 * This is a generic queue class 
 * MyQueue implements the QueueInterface given you.
 * @author Sakina Lougue
 */
import java.util.ArrayList;
import java.util.Arrays;

public class NotationQueue<T> implements QueueInterface<T>
{
	private T q[];
	private int front;
	private int rear; 
	private int capacity;
	private int lenght;

	/**
	 * This paramatre constructor takes set the field
	 * @param index size of the array
	 */
	public NotationQueue(int i) 
	{
		capacity = i;
		lenght = 0;
		q = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
	}

	/**
	 * isEmpty method assign -1
	 */
	@Override
	public boolean isEmpty() 
	{
		return front == -1;
	}

	/**
	 * isFull method return the truthdullness or the wrong of the expression
	 * @return true or false
	 */
	@Override
	public boolean isFull() 
	{
		return (front == 0 && rear == capacity - 1);
	}

	/**
	 * dequeue method return the truthdullness or the wrong of the expression
	 * @return result an object
	 * @throws QueueUnderflowException 
	 */
	@Override
	public T dequeue() throws QueueUnderflowException 
	{
		if (isEmpty()) 
		{
			throw new QueueUnderflowException("Underflow Exception");
		} 
		else 
		{
			lenght--;
			T ele = q[front];
			if (front == rear) 
			{
				front = -1;
				rear = -1;
			}
			else 
			{
				front++;
			}
			return ele;
		}
	}

	/**
	 * size method return the lenght
	 * @return lenght the lenght 
	 */
	@Override
	public int size() 
	{
		return lenght;
	}

	/**
	 * enqueue method 
	 * @param s 
	 * @return true 
	 * @throws QueueOverflowException 
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException 
	{
		if (rear == -1) 
		{
			front = 0;
			rear = 0;
			q[rear] = e;

		} else if (rear + 1 >= capacity) 
		{
			throw new QueueOverflowException("Overflow Exception");
		} else if (rear + 1 < capacity) 
		{
			q[++rear] = e;
		}
		lenght++;
		return true;
	}

	/**
	 * toString method 
	 * @param delimiter 
	 * @return a string  
	 */
	@Override
	public String toString(String delimiter) 
	{
		StringBuilder s = new StringBuilder();
		for (int i = front; i <= rear; i++) 
		{
			s.append(q[i].toString());
			if(i<rear)
				s.append(delimiter);
		}
		return s.toString();
	}

	/**
	 * fill method 
	 * @param list  
	 */
	@Override
	public void fill(ArrayList<T> list) {
		lenght = 0;
		q = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
		try {
			for (T t : list) {

				enqueue(t);

			}
		} catch (QueueOverflowException ex) 
		{
			System.out.println(ex.toString());
		}
	}

	/**
	 * toString method 
	 * @return result a string  
	 */
	@Override
	public String toString() 
	{
		String result = "";
		for(int index=0; index <= rear; index++)
		{
			result += q[index];
		}
		return result;
	}
	
	

}
