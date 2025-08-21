/**
 * This is a generic queue class 
 * MyQueue implements the QueueInterface given you.
 * @author Sakina Lougue
 */
import java.util.*;


public class MyQueue<T> implements QueueInterface<T> 
{

	protected T q[];
	protected int front;
	protected int rear; 
	protected int capacity;
	protected int lenght;

	/**
	 * This paramatre constructor takes set the field
	 * @param size size of the array
	 */
	public MyQueue(int size) 
	{
		capacity = size;
		lenght = 0;
		q = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
	}

	/**
	 * MyQueue method
	 */
	public MyQueue() {
		this(20);
	}

	/**
	 * isEmpty method assign -1
	 */
	@Override
	public boolean isEmpty() {
		return front == -1;
	}

	/**
	 * isFull method return the truthdullness or the wrong of the expression
	 * @return true or false
	 */
	@Override
	public boolean isFull() {
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
			T result = q[front];
			if (front == rear) 
			{
				front = -1;
				rear = -1;
			}
			else 
			{
				front++;
			}
			return result;
		}
	}

	/**
	 * size method return the lenght
	 * @return lenght the lenght 
	 */
	@Override
	public int size() {
		return lenght;
	}

	/**
	 * enqueue method 
	 * @param s 
	 * @return true 
	 * @throws QueueOverflowException 
	 */
	@Override
	public boolean enqueue(T s) throws QueueOverflowException 
	{

		if (rear == -1) 
		{
			front = 0;
			rear = 0;
			q[rear] = s;

		}
		else if (rear + 1 >= capacity) 
		{
			throw new QueueOverflowException("Overflow Exception");
		} else if (rear + 1 < capacity) 
		{
			q[++rear] = s;
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
	 * toString method  
	 * @return a string  
	 */
	@Override
	public String toString( ) {
		StringBuilder s = new StringBuilder();
		for (int i = front; i <= rear; i++) 
		{
			s.append(q[i].toString());

		}
		return s.toString();
	}

	/**
	 * fill method 
	 * @param list  
	 */
	@Override
	public void fill(ArrayList<T> list) 
	{
		lenght = 0;
		q = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
		try {
			for (T t : list) {

				enqueue(t);

			}
		} catch (QueueOverflowException ex) {
			System.out.println(ex.toString());
		}
	}

}
