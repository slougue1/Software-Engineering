

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5;
	   ManagementCompany m ;
	@Before
	public void setUp() throws Exception {
		p1 = new Property ("Belmar", "Silver Spring", 1200.45, "John Smith");
		p2 = new Property ("Camden Lakeway", "Rockville", 2450, "Ann Taylor");
		p3 = new Property ("Hamptons", "Rockville", 1250, "Rick Steves");

		m= new ManagementCompany("Alliance", "1235",6);

		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		//student create a management company
		//student add three properties, with plots, to mgmt co
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1=p2=p3=null;
	       m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		 p4 = new Property ("Mallory Square", "Wheaton", 1000, "Abbey McDonald");
	       p5 = new Property ("Lakewood", "Rockville", 3000, "Alex Tan");
	         
	       assertEquals(m.addProperty(p4),-4,0);
	       assertEquals(m.addProperty(p5),-4,0);
	       assertEquals(m.addProperty(p1),-4,0); //exceeds the size of the array and can not be added, add property should return -1  
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		assertEquals(m.maxRentProp(),1200.45,0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		 assertEquals(m.totalRent(),1200.45,0);
		 //student should test if totalRent returns the total rent of properties
	}

 }