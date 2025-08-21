


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



public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();
	

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		}
		catch (UnsupportedOperationException e)
		{
			//assertTrue("null", true);
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
			//assertEquals("World", linkedString.getLast());
		}
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {

			return arg0.compareTo(arg1);
		}
	}

}