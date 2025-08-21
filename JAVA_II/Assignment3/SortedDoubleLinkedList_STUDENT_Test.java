import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;


	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);

		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
 	sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Students");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Students");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulStringNext() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Computers");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computers", iterator.next());
		assertEquals("Students", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPreviousProblem() {
		sortedLinkedString.add("Computers");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Students");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computers", iterator.next());
		assertEquals("Students", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Students", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Computers");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computers", iterator.next());
		assertEquals("Students", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Students", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext()); }

	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(new Double(10), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(new Double(10), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}

	@Test
	public void testIteratorNoSuchElementExceptionString() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Computers");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computers", iterator.next());
		assertEquals("Students", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Zebra", iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}

	@Test
	public void testIteratorNoSuchElementExceptionDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		sortedLinkedDouble.add(new Double(2));
		sortedLinkedDouble.add(new Double(10));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(10), iterator.next());
		try{
			
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		} }

	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Computers");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		try{
			
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionDoubleSTUDENT() {
	}

	@Test
	public void testAddString() {
		sortedLinkedString.add("Banana");
		sortedLinkedString.add("Elephant");
		sortedLinkedString.add("Apple");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		sortedLinkedString.add("Cat");
		sortedLinkedString.add("Dog");
		assertEquals("Apple", sortedLinkedString.getFirst());
		assertEquals("Elephant", sortedLinkedString.getLast());
		//deletes Elephant from linked list
		assertEquals("Elephant",sortedLinkedString.retrieveLastElement());

		assertEquals("Dog", sortedLinkedString.getLast());
	}

	@Test
	public void testAddDoubleSTUDENT() {

	}

	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		assertEquals("Students", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Computers");
		assertEquals("Computers", sortedLinkedString.getFirst());
		
		sortedLinkedString.remove("Computers", comparator);
		assertEquals("Students", sortedLinkedString.getFirst());
	}

	@Test
	public void testRemoveFirstDouble() {
		sortedLinkedDouble.add(new Double(5));
		sortedLinkedDouble.add(new Double(8));
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
		assertEquals(new Double(8), sortedLinkedDouble.getLast());
		sortedLinkedDouble.add(new Double(2));
		assertEquals(new Double(2), sortedLinkedDouble.getFirst());
		// remove the first
		sortedLinkedDouble.remove(new Double(2), comparatorD);
		assertEquals(new Double(5), sortedLinkedDouble.getFirst());
	}

	@Test
	public void testRemoveEndString() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		assertEquals("Students", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Zebra");
		assertEquals("Zebra", sortedLinkedString.getLast());
		//remove from the end of the list
		sortedLinkedString.remove("Zebra", comparator);
		assertEquals("World", sortedLinkedString.getLast());
	}

	@Test
	public void testRemoveEndDoubleSTUDENT() {
	}

	@Test
	public void testRemoveMiddleString() {
		sortedLinkedString.add("Students");
		sortedLinkedString.add("World");
		assertEquals("Students", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		sortedLinkedString.add("Computers");
		assertEquals("Computers", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(3,sortedLinkedString.getSize());
		
		sortedLinkedString.remove("Students", comparator);
		assertEquals("Computers", sortedLinkedString.getFirst());
		assertEquals("World", sortedLinkedString.getLast());
		assertEquals(2,sortedLinkedString.getSize());
	}

	@Test
	public void testRemoveMiddleDoubleSTUDENT() {
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {

			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {

			return arg0.compareTo(arg1);
		}

	}
}