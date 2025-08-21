/**
 * This program is a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList class.
 * @author Sakina Lougue
 */
import java.util.ListIterator;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> 
{
	java.util.Comparator<T> comparator1 = null;
	
	/**
	 * this is a parameritized constructore with an empty list that is associated with the specified comparator.
	 * @param comparator2 Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) 
	{
		comparator1 = comparator2;
	}
	
	/**
	 * This method inserts the specified element at the correct position in the sorted list.
	 * The method doen't implement this method using iterators
	 * @param data - the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) 
	{
		if (data == null) 
		{
			return this;
		}

		Node node = new Node(data, null, null);
		
		if (header == null) 
		{
			header = tail = new Node(data, null, null);
		} 
		
		else 
		{
			if (comparator1.compare(data, header.item) <= 0) 
			{
				node.next = header;
				header = node;
			} 
			else if (comparator1.compare(data, tail.item) >= 0) 
			{
				tail.next = node;
				tail = node;
			} 
			else 
			{
				Node next = header.next;
				Node previous = header;
				
				while (comparator1.compare(data, next.item) > 0) 
				{
					previous = next;
					next = next.next;
				}
				
				previous.next = node;
				node.next = next;
			}
		}
		size++;
		return this;
	}

	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data to be added to the list
	 * @throws UnsupportedOperationException - if the method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data to be added to the list
	 * @throws UnsupportedOperationException - if the method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This method implements the remove operation by calling the super class remove method.
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return the data element or null
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) 
	{
		Node next = header;
		Node previous = null;
		while (next != null) 
		{
			if (comparator.compare(next.item, data) == 0) 
			{
				size--;
				if (previous != null) 
				{
					previous.next = next.next;
				}
				else 
				{
					header = next.next;
				}
				if (next == tail) 
				{
					tail = previous;
				}
			}
			previous = next;
			next = next.next;
		}

		return this;

	}

	/**
	 * This method implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public java.util.ListIterator<T> iterator() 
	{
		return new iterator1();
	}
}