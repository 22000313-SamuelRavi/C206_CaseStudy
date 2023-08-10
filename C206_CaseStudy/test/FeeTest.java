import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeeTest {
	

	//fee management test
	// Done by Priya
	private FeeManagement f1;
	private FeeManagement f2;
	private FeeManagement f3;
	private ArrayList<FeeManagement> studentFeeList;
	
	public FeeTest() {
		super();
	}


	@Before
	public void setUp() throws Exception {
		//=========================== fee management =============================================
	    // Done by Priya
			f1 = new FeeManagement(5000, "tuition", LocalDate.of(2023, 9, 8), "22000313");
			f2 = new FeeManagement(3498.75, "exam", LocalDate.of(2023, 10, 15), "22028492");
			f3 = new FeeManagement(1234.89, "exam", LocalDate.of(2023, 11, 07), "22026533");
			

			studentFeeList= new ArrayList<FeeManagement>();
		
	}

	  @Test
	    public void testAddFees() {
	      //----Test 1----- 
	      // Item list is not null and it is empty (boundary Condition)
	      assertNotNull("Test if there is valid student fee arraylist to add to", studentFeeList);
	      assertEquals("Test that the Student Fee arraylist is empty.", 0, studentFeeList.size());
	      
	      //-----Test 2----
	      //Given an empty list, after adding 1 item, the size of the list is 1 (normal condition)
	      //The item just added is as same as the first item of the list
	      FeeManagementMain.addFees(studentFeeList, f1);
	      System.out.println("1st Student Fee successfully added!");
	      assertEquals("Check that Student Fee arraylist size is 1", 1, studentFeeList.size());
	      
	      // Add another item
	      FeeManagementMain.addFees(studentFeeList, f2);
	      System.out.println();
	      System.out.println("2nd Student Fee successfully added!");
	  	  assertEquals("Test that the Student Fee arraylist size is now 2.", 2, studentFeeList.size());
	  	
	  	  //The item just added is as same as the last item in the list
	      assertSame("Test that Fee is added to the end of the list.", f2, studentFeeList.get(1));
	  
	     // Error condition: Add an item that already exists in the list 
	  	  FeeManagementMain.addFees(studentFeeList, f2);
	  	  System.out.println();
	  	  System.out.println("The newly added student fees was not added as it already exists in the list!");
	  	  assertEquals("Test that the Student Fee arraylist size is unchanged.", 2, studentFeeList.size());

	  	 //-- Test 3-----
	  	 // Add an item that has missing detail
	  	  FeeManagement fee_MD = new FeeManagement(5000, " ", LocalDate.of(2023, 9, 8), "22000313") ;
	  	  FeeManagementMain.addFees(studentFeeList,fee_MD );
	  	  System.out.println();
	  	  System.out.println("Student fees cannot be added as it has missing detail!");
	  	  assertEquals("Test that the Student Fee arraylist size is unchanged.",2, studentFeeList.size()); 
	    }
	    
	    @Test
	    public void testViewAllFees() {
	    	
	    	//Boundary condition:
	        assertNotNull("Test if there is a valid Student Fee arraylist to get and display the Student Fees", studentFeeList);
	        // Test viewing student fees when the list is empty
	        String emptyOutput = FeeManagementMain.viewAllFees(studentFeeList);
	        String expectedEmptyOutput = "";
	        		
	        assertEquals("Test that viewing all student fees in an empty Student Fee List returns the appropriate message",
	                expectedEmptyOutput, emptyOutput);

	        
	        //Normal condition:
	        
	        // Add the fees
	        
	        studentFeeList.add(f1);
	    	studentFeeList.add(f2);
	    	studentFeeList.add(f3);
	    
	    	
	        assertEquals("Test that the Student Fee arraylist size is now 3.", 3, studentFeeList.size());
	        
	        // Test viewing all existing fees in the studentFeeList
	        String expectedOutput = "";
	        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        expectedOutput += String.format("| %-13s | %-9s | %-15s | %-7.2f |\n",
	                f1.getStudentId(), f1.getFeeType(), f1.getFeeDueDate().format(formattedDate), f1.getFeeAmount());
	        expectedOutput += String.format("| %-13s | %-9s | %-15s | %-7.2f |\n",
	                f2.getStudentId(), f2.getFeeType(), f2.getFeeDueDate().format(formattedDate), f2.getFeeAmount());
	        expectedOutput += String.format("| %-13s | %-9s | %-15s | %-7.2f |\n",
	                f3.getStudentId(), f3.getFeeType(), f3.getFeeDueDate().format(formattedDate), f3.getFeeAmount());
	        
	        
	        String allFees = FeeManagementMain.viewAllFees(studentFeeList);
	        assertEquals("Test that viewing all fees in the Student Fee List returns the expected output", expectedOutput, allFees);
	    
	    }
	    
	    
	    
	    @Test
	    public void testDeleteFee() {
	    	
	    	// Boundary Condition: Student Fee list is not null and it is empty 
	    	assertNotNull("Test if there is valid Student Fee arraylist to view the Student Fees", studentFeeList);
	    	
	    	// Add the student fees 
	    	studentFeeList.add(f1);
	    	studentFeeList.add(f2);
	    	studentFeeList.add(f3);
	    	
	        
	        // Normal Condition: Delete an existing course
	        assertNotNull("Test if there is a valid Student Fee arraylist to delete from",studentFeeList );
	        assertEquals("Test that the Student Fee arraylist size is 3.", 3, studentFeeList.size());

	        boolean isDeleted = FeeManagementMain.deleteFee(studentFeeList, f1.getStudentId());
	        assertTrue("Test that the correct Student's fee is deleted", isDeleted);
	        assertEquals("Test that the Student Fee arraylist size is now 2 after deletion.", 2, studentFeeList.size());
	        assertFalse("Test that the deleted Student Fee is no longer in the list", studentFeeList.contains(f1));

	        // Error Condition: Attempt to delete a Student Fee that does not exist in the list
	        
	        FeeManagementMain.deleteFee(studentFeeList, "22026534"); // Student Fee that does not exist
	        boolean deleteNo = FeeManagementMain.deleteFee(studentFeeList, "22026534");
	        assertFalse("Test that non-existing Student Fee is not found and not deleted", deleteNo);
	        assertEquals("Test that the Student Fee arraylist size remains unchanged.", 2, studentFeeList.size());

	        // Boundary Condition: Delete all Student Fees
	       FeeManagementMain.deleteFee(studentFeeList, f2.getStudentId());
	       FeeManagementMain.deleteFee(studentFeeList, f3.getStudentId());
	      

	        assertEquals("Test that the Student Fee arraylist is empty after deleting all fees.", 0, studentFeeList.size());
	    }
	    @After
		public void tearDown() throws Exception {
			
			
	        
	        // fee management
	        // Done by Priya
	        f1 = null;
	        f2 = null;
	        f3 = null;
	      
	        
	    
		}
}
