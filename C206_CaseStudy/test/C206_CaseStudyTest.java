import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	
	//prepare test data for fee management
			private FeeManagement f1;
			private FeeManagement f2;
			private FeeManagement f3;
			private FeeManagement f4;
			private FeeManagement f5;
			
			private ArrayList<FeeManagement> studentFeeList;
			
			public C206_CaseStudyTest() {
				super();
			}
		
	@Before
	public void setUp() throws Exception {
		//prepare test data for fee management
		
		f1 = new FeeManagement(5000, "tuition", LocalDate.of(2023, 9, 8), "22000313");
		f2 = new FeeManagement(3498.75, "exam", LocalDate.of(2023, 10, 15), "22028492");
		f3 = new FeeManagement(1234.89, "exam", LocalDate.of(2023, 11, 07), "22026533");
		f4 = new FeeManagement(5678.23, "tuition", LocalDate.of(2023, 12, 21), "22013820");
		f5 = new FeeManagement(9123.46, "others", LocalDate.of(2024, 01, 10), "22003342");
		
		studentFeeList= new ArrayList<FeeManagement>();
	}

	@Test
	public void testAddFees() {
		
		//fail("Not yet implemented"); 
		//assertTrue("C206_CaseStudy_SampleTest ",true);
		
		// Item list is not null and it is empty (Normal Condition)
				assertNotNull("Test if there is valid student fee arraylist to add to", studentFeeList);
				assertEquals("Test that the student fee arraylist is empty.", 0, studentFeeList.size());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

	

}
