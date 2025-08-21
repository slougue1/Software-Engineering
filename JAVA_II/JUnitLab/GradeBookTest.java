import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest 
{

	private GradeBook book1;
	private GradeBook book2;
	
	@BeforeEach
	void setUp() throws Exception
	{
		//Creating two objects of the Driver class GradeBook.
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		//Adding random scores to each object.
		book1.addScore(50);
		book1.addScore(75);
		book2.addScore(80);
		book2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		//Setting both objects to null
		book1 = book2 = null;
	}

	@Test
	void testGetScoreSize()
	{
		
	}

	@Test
	void testToString() 
	{
	
	}

	@Test
	void testAddScore() 
	{
		//Check if the returned string is equal to expected string.
		assertTrue((book1.toString()).equals("50.0 75.0 "));
	    assertTrue((book2.toString()).equals("80.0 90.0 "));      
	    assertEquals(2, book1.getScoreSize(), 0.001);
	    assertEquals(2, book2.getScoreSize(), 0.001);
		
		
	}

	@Test
	void testSum() 
	{
		//Checking the actual sum and sum returned by the sum() are equivalent.
		assertEquals(125,book1.sum(),0.001);
		assertEquals(170,book2.sum(),0.001);
	}

	@Test
	void testMinimum() 
	{
		//Checking if the minimum score returned by minimum() is equals to actual minimum value.
		assertEquals(50,book1.minimum(),0.001);
		assertEquals(80,book2.minimum(),0.001);
	}

	@Test
	void testFinalScore() 
	{
		// There are two scores in boo1 and book2, so the finalScore will return the sum of all scores - the minimum score.
		assertEquals(75,book1.finalScore(),0.001);
		assertEquals(90,book2.finalScore(),0.001);
	}

}
