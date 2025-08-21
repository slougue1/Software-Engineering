import static org.junit.Assert.*;

import org.junit.Test;

public class Town_STUDENT_Test 
{
	@Test
	public void testGetName() {
		Town t1 = new Town("Africa");
		Town t2 = new Town("Burkina Faso");
		assertEquals("Africa", t1.getName());
		assertEquals("Burkina Faso", t2.getName());
	}

	@Test
	public void getAdjacentTown() {
		Town t1 = new Town("Africa");
		Town t2 = new Town("Burkina Faso");
		equals(t1.getAdjacentTown());
		equals(t2.getAdjacentTown());
	}
	
	@Test
	public void addAdjacentTown() {
		Town t1 = new Town("Nigeria");
		Town t2 = new Town("Benin");
		assertEquals( t1.addAdjacentTown(t2), true);
		assertEquals( t2.addAdjacentTown(t1), true);
	}
	
	
	@Test
	public void removeNeighbors() {
		Town t1 = new Town("Ghana");
		Town t2 = new Town("Togo");
		assertEquals( t1.removeAdjacentTown(t2), false);
		assertEquals( t2.removeAdjacentTown(t1), false);
	}
	
	
	@Test
	public void testHashcode() {
		Town t1 = new Town("T1");
		Town t2 = new Town("T2");
		assertEquals(2653, t1.hashCode());
		assertEquals(2654, t2.hashCode());
	}

	@Test
	public void testCompareTo() 
	{
		Town t1 = new Town("Senegal");
		Town t2 = new Town("Ivory Coast");
		assertEquals(t1.compareTo(t2), 10);
		assertEquals(t2.compareTo(t1), -10);
	}
	
	@Test
	public void testToString() {
		Town t1 = new Town("Sierra Leonne");
		Town t2 = new Town("Guinea");
		assertEquals("Sierra Leonne", t1.toString());
		assertEquals("Guinea", t2.toString());
	}

	@Test
	public void testEqualsTown() {
		Town t1 = new Town("Congo");
		Town t2 = new Town("Ethiopia");
		assertFalse(t1.equals(t2));
		assertTrue(t2.equals(t2));
	}
}
