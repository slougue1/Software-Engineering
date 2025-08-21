import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	StringComparator comparator;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Sakina");
		linkedString.addToEnd("Lougue");
		comparator = new StringComparator();

		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();

	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
	}

	@Test
	public void testAddToEnd() {
		assertEquals("Lougue", linkedString.getLast());
		linkedString.addToEnd("Sia");
		assertEquals("Sia", linkedString.getLast());
	}

	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
	}

	@Test
	public void testAddToFront() {
		assertEquals("Sakina", linkedString.getFirst());
		linkedString.addToFront("Computer");
		assertEquals("Computer", linkedString.getFirst());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
	}

	@Test
	public void testGetFirst() {
		assertEquals("Sakina", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
	}

	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
	}

	@Test
	public void testGetLast() {
		assertEquals("Lougue", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
	}

	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		list = linkedString.toArrayList();
		assertEquals("Computer", list.get(0));
		assertEquals("Sakina", list.get(1));
		assertEquals("Lougue", list.get(2));
		assertEquals("Sia", list.get(3));
	}

	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
	}

	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computer", iterator.next());
		assertEquals("Sakina", iterator.next());
		assertEquals("Lougue", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Sia", iterator.next());
	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computer", iterator.next());
		assertEquals("Sakina", iterator.next());
		assertEquals("Lougue", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Lougue", iterator.previous());
		assertEquals("Sakina", iterator.previous());
	}

	@Test
	public void testIteratorSuccessfulSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the preceeding test method as an example
	}

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computer", iterator.next());
		assertEquals("Sakina", iterator.next());
		assertEquals("Lougue", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Sia", iterator.next());
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computer", iterator.next());
		assertEquals("Sakina", iterator.next());
		assertEquals("Lougue", iterator.next());
		assertEquals("Sia", iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Sia", iterator.previous());
		assertEquals("Lougue", iterator.previous());
		assertEquals("Sakina", iterator.previous());
		assertEquals("Computer", iterator.previous());
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}

	@Test
	public void testIteratorNoSuchElementExceptionSTUDENT(){

	}

	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("Computer");
		linkedString.addToEnd("Sia");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Computer", iterator.next());
		assertEquals("Sakina", iterator.next());
		assertEquals("Lougue", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Sia", iterator.next());

		try{
			//remove is not supported for the iterator
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
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
	}

	@Test
	public void testRemove() {

		assertEquals("Sakina", linkedString.getFirst());
		assertEquals("Lougue", linkedString.getLast());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		linkedString.remove("New", comparator);
		assertEquals("Sakina", linkedString.getFirst());

		linkedString.addToEnd("Sia");
		assertEquals("Sia", linkedString.getLast());
		linkedString.remove("Sia", comparator);
		assertEquals("Lougue", linkedString.getLast());

		linkedString.addToFront("Computer");
		assertEquals("Computer", linkedString.getFirst());
		assertEquals("Lougue", linkedString.getLast());
		linkedString.remove("Hello", comparator);
		assertEquals("Computer", linkedString.getFirst());
		assertEquals("Lougue", linkedString.getLast());

	}

	@Test
	public void testRemoveSTUDENT()
	{

	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Sakina", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Sakina",linkedString.getFirst());
		assertEquals("Sakina", linkedString.retrieveFirstElement());
		assertEquals("Lougue",linkedString.getFirst());

	}

	@Test
	public void testRetrieveFirstElementSTUDENT(){

	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("Lougue", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("Lougue",linkedString.getLast());
	}

	@Test
	public void testRetrieveLastElementSTUDENT(){

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