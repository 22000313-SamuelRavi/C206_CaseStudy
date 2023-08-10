import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnrolementManagementMainTest {

	private EnrolementManagement em1;
    private EnrolementManagement em2;
    private EnrolementManagement em3;
    private EnrolementManagement em4;
    private EnrolementManagement em5;
    
    private ArrayList<EnrolementManagement> enrolList;
	
    @Before
    public void setup() throws Exception{
    	
    	em1 = new EnrolementManagement("22000313", "C206", 3.7);
		em2 = new EnrolementManagement("22028492", "C209", 3.1);
		em3 = new EnrolementManagement("22026533", "C236", 3.9);
		em4 = new EnrolementManagement("22013820", "C328", 3.5);
		em5 = new EnrolementManagement("22003342", "C327", 3.8);
		
		enrolList = new ArrayList<EnrolementManagement>();
    }
    
    @Test
    public void testViewEnrol() {
    	//Boundary condition:
        assertNotNull("Test if there is a valid enrollementsManagementMain arraylist to retrieve the enrollments", enrolList);
        // Test viewing Enrollments when the list is empty
        String emptyOutput = EnrolementManagementMain.viewEnrol(enrolList);
        String expectedEmptyOutput = String.format("| %-12s | %-8s | %s |\n", "Student ID", "Course", "GPA");
        assertEquals("Test that viewing all enrollments in an empty enrolList returns the appropriate message",
                expectedEmptyOutput, emptyOutput);

        //Normal condition:
        // Add the enrollments
        enrolList.add(em1);
        enrolList.add(em2);
        enrolList.add(em3);
        enrolList.add(em4);
        enrolList.add(em5);
        assertEquals("Test that the enrollementsManagementMain arraylist size is now 5.", 5, enrolList.size());
        
        // Test viewing all existing enrollments in the enrolList
        String expectedOutput = String.format("| %-12s | %-8s | %s |\n", "Student ID", "Course", "GPA");;
        	for(EnrolementManagement em: enrolList) {
        		expectedOutput += String.format("| %-12s | %-8s | %.1f |\n", em.getStudentId(), em.getCourse(), em.getGpa());
        	}
       
        String allEnrolments = EnrolementManagementMain.viewEnrol(enrolList);
        assertEquals("Test that viewing all enrollments in the enrolList returns the expected output", expectedOutput, allEnrolments);	
    }
    
    @Test
    public void testAddEnrol() {
    	//Boundary condition:
    	// enrollementsManagementMain list is not null and it is empty
    	assertNotNull("Test if there is valid enrollementsManagementMain arraylist to add to", enrolList);
    	assertEquals("Test that the enrollementsManagementMain arraylist is empty.", 0, enrolList.size());
    	
    	
    	//Normal condition:
    	//Given an empty list, after adding 1 item, the size of the list is 1
    	EnrolementManagementMain.addEnrol(enrolList, em1);		
    	assertEquals("Test that the EnrolementManagementMain arraylist size is 1.", 1, enrolList.size());
    	// Add another item
    	EnrolementManagementMain.addEnrol(enrolList, em2);
    	assertEquals("Test that the EnrolementManagementMain arraylist size is now 2.", 2, enrolList.size());
    	//The item just added is as same as the last item in the list
    	assertSame("Test that enrollement is added to the end of the list.", em2, enrolList.get(1));
    	
    	
    	//Error condition:
    	// Add an item that already exists in the list
    	EnrolementManagementMain.addEnrol(enrolList, em2);
    	assertEquals("Test that the EnrolementManagementMain arraylist size is unchange.", 2, enrolList.size());	
    }
    
    @Test
    public void testDeleteEnrol() {
    	//Add the enrollments 
    	enrolList.add(em1);
        enrolList.add(em2);
        enrolList.add(em3);
        enrolList.add(em4);
        enrolList.add(em5);
        
        // Normal Condition:
        // Delete an existing enrollment
        assertNotNull("Test if there is a valid EnrolementManagementMain arraylist to delete from", enrolList);
        assertEquals("Test that the EnrolementManagementMain arraylist size is 5.", 5, enrolList.size());

        boolean isDeleted = EnrolementManagementMain.deleteEnrol(enrolList, em1.getStudentId());
        assertTrue("Test that the correct enrollment is deleted", isDeleted);
        assertEquals("Test that the EnrolementManagementMain arraylist size is now 4 after deletion.", 4, enrolList.size());
        
        assertFalse("Test that the deleted enrollment is no longer in the list", enrolList.contains(em1));
        
        // Error Condition:
        // Attempt to delete a non-existing enrollment
        
        // Non-existing enrollment
        boolean isNotDeleted = EnrolementManagementMain.deleteEnrol(enrolList, "22000123");  
        assertFalse("Test that non-existing enrollment is not found in the list and not deleted", isNotDeleted);
        assertEquals("Test that the EnrolementManagementMain arraylist size remains unchanged.", 4, enrolList.size());

        
        // Boundary Condition: 
        // Delete all enrollments
        EnrolementManagementMain.deleteEnrol(enrolList, em2.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em3.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em4.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em5.getStudentId());

        assertEquals("Test that the EnrolementManagementMain arraylist is empty after deleting all enrollments.", 0, enrolList.size());
    }
    
    @After
    public void tearDown() throws Exception{
    	em1 = null;
        em2 = null;
        em3 = null;
        em4 = null;
        em5 = null;
    }
}
