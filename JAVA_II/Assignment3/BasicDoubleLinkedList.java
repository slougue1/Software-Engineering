/**
 * This program is a generic double-linked list that relies on a head and tail 
 * @author Sakina Lougue
 */

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> 
{
	/**
	 * This inner class represents the field of the program. 
	 * It declare all variables and assign some of them, and also implements ListIterator
	 * @author Sakina Lougue
	 */
	protected class Node 
	{
		protected T item;
		protected Node next, previous;

		/**
		 * This is a paramaterized constructor which assigns the the parameters to the field declare above
		 * @param item - the number of items
		 * @param next - the next item 
		 * @param previous - the previous item
		 */
		protected Node(T item, Node next, Node previous) 
		{
			this.item = item;
			this.next = next;
			this.previous = previous;
		}
	}

	protected int size;    //the size of the linked list
	protected Node header; //the first element of the list
	protected Node tail;   //the the last element of the list

	/**
	 * This constructor set the size to 0 and the header and tail to null
	 */
	public BasicDoubleLinkedList() 
	{
		size = 0;
		tail = null;
		header = null;
	}
	
	/**
	 * This method adds an element to the end of the list. The method does not use iterators to implement this method.
	 * @param data - the data for the Node within the linked list
	 * @return this - reference to the current object
	 */

	public BasicDoubleLinkedList<T> addToEnd(T data) 
	{
		Node element = new Node(data, null, tail);
		if (tail != null) 
		{
			tail.next = element;
		}
		tail = element;
		
		if (header == null) 
		{
			header = element;
		}
		size++;
		return this;
	}

	/**
	 * This method adds an element to the front of the list.The method does not use iterators to implement this method.
	 * @param data - the data for the Node within the linked list
	 * @return this - reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) 
	{

		Node element = new Node(data, header, null);
		if (header != null) 
		{
			header.previous = element;
		}
		header = element;
		
		if (tail == null) 
		{
			tail = element;
		}
		size++;
		return this;
	}

	/**
	 * This method just returns the value of the instance variable you use to keep track of size.
	 * @return - size the size of the linked list
	 */
	public int getSize() 
	{
		return size;
	}
	
	/**
	 * This method returns but does not remove the last element from the list.
	 * @return tail.item - the item of the last element of the last
	 */
	public T getLast() 
	{
		return tail.item;
	}
	
	/**
	 * This method returns but does not remove the first element from the list.
	 * @return header.item - the item of the first element of the last
	 */
	public T getFirst() 
	{
		return header.item;
	}

	/**
	 * This method removes the first instance of the targetData from the list.
	 * the method does not implement this method using iterators.
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return this - data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) 
	{
		Node previous1 = null;
		Node current1 = header;
		while (current1 != null) 
		{
			if (comparator.compare(current1.item, targetData) == 0) 
			{
				if (current1 == header) 
				{
					header = header.next;
					current1 = header;
				} 
				else if (current1 == tail) 
				{
					current1 = null;
					tail = previous1;
					previous1.next = null;
				} 
				else 
				{
					previous1.next = current1.next;
					current1 = current1.next;
				}
				size--;
			}
			else 
			{
				previous1 = current1;
				current1 = current1.next;
			}
		}
		return this;
	}
	
	/**
	 * This method removes and returns the first element from the list. If there are no elements the method returns null. 
	 * The method doesn't implement this method using iterators.
	 * @return element.item - data element or null
	 */
	public T retrieveFirstElement() 
	{
		if (size == 0) 
		{
			throw new NoSuchElementException("Linked list is empty");
		}
		
		Node temp = header;
		header = header.next;
		header.previous = null;
		size--;
		return temp.item;
	}
	
	/**
	 * This method removes and returns the last element from the list. If there are no elements the method returns null. 
	 * The method doesn't implement implement this method using iterators.
	 * @return current.item - data element or null
	 */
	public T retrieveLastElement() 
	{

		if (header == null) 
		{
			throw new NoSuchElementException("Linked list is empty");

		}
		
		Node current2 = header;
		Node previous2 = null;

		while (current2 != null) 
		{
			if (current2.equals(tail)) 
			{
				tail = previous2;
				break;
			}
			previous2 = current2;
			current2 = current2.next;
		}
		size--;
		return current2.item;
	}
	
	/**
	 * This method returns an arraylist of the items in the list from head of list to tail of list
	 * @return element - an arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList() 
	{
		ArrayList<T> element = new ArrayList<T>();
		ListIterator<T> iterator1 = new iterator1();

		while (iterator1.hasNext()) 
		{
			element.add(iterator1.next());
		}
		return element;
	}
	
	/**
	 * This is an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous()
	 * @author Sakina Lougue
	 *
	 */
	public class iterator1 implements ListIterator<T> 
	{
		private Node current3;
		private Node tail1;
		
		/**
		 * this is a constructor that set current3 and tail1
		 */
		public iterator1()
		{
			current3 = header;
			tail1 = null;
		}
		
		/**
		 * this method method throws NoSuchElementException if there are no more elements at the end of the list 
		 * and calling next() or at the beginning of the list and calling previous()).
		 */
		public T next()
		{
			if(current3 != null)
			{
				T returningData1 = current3.item;
				tail1 = current3;
				current3 = current3.next;
				
				if(current3 != null) 
				{ 
					current3.previous = tail1;
				}
				return returningData1;
			}
			else
				throw new NoSuchElementException();
		}
		
		/**
		 * This method should be called as many times as we want without changing what is considered the next element.
		 * @return either if the current data is null or not
		 */
		public boolean hasNext()
		{
			return current3!=null;
		}
		
		/**
		 * 
		 */
		public T previous()
		{
			if(tail1 != null)
			{
				current3 = tail1;
				tail1= current3.previous;
				T returningData2 = current3.item;
				return returningData2;
			}
			else
				throw new NoSuchElementException();
		}
		
		/**
		 * This method should be called as many times as we want without changing what is considered the next element.
		 * @return either if the tail1 data is null or not
		 */
		public boolean hasPrevious()
		{
			return tail1!=null;
		}
		
		/**
		 * This method set the item of current3 to the parameter
		 * @param data 
		 */
		public void set(T data) 
		{
			current3.item = data;
		}
		/**
		 * this method throws UnsupportedOperationException if called.
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/**
		 * this method throws UnsupportedOperationException if called.
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/**
		 * this method throws UnsupportedOperationException if called.
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/**
		 * this method throws UnsupportedOperationException if called.
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();

		}
	}

	/** 
	 * This method must be implemented using an inner class that implements ListIterator
	 * @return the instance of the inner class iterator1
	 * @throws java.lang.UnsupportedOperationException
	 *         java.util.NoSuchElementException
	 */
	public java.util.ListIterator<T> iterator() throws java.lang.UnsupportedOperationException,
                                                       java.util.NoSuchElementException
	{
		return new iterator1();
		
	}

}
