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
	private Student student1;
	private Student student2;

	private ArrayList<FeeManagement> studentFeeList;
	private ArrayList<Student> studentList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
	//=========================== fee management =============================================

		f1 = new FeeManagement(5000, "tuition", LocalDate.of(2023, 9, 8), "22000313");
		f2 = new FeeManagement(3498.75, "exam", LocalDate.of(2023, 10, 15), "22028492");
		f3 = new FeeManagement(1234.89, "exam", LocalDate.of(2023, 11, 07), "22026533");
		f4 = new FeeManagement(5678.23, "tuition", LocalDate.of(2023, 12, 21), "22013820");
		f5 = new FeeManagement(9123.46, "others", LocalDate.of(2024, 01, 10), "22003342");

		studentFeeList= new ArrayList<FeeManagement>();
		
	// ================================= student management  =================================
		student1 = new Student("22021234", "Alice", 19);
		student2 = new Student("22025678", "Bob", 21);

		studentList = new ArrayList<Student>();

		
	}
    //================================= fee management  ===================================================
	@Test
	public void testAddFees() {

		// Item list is not null and it is empty (Normal Condition)
		assertNotNull("Test if there is valid student fee arraylist to add to", studentFeeList);
		assertEquals("Test that the student fee arraylist is empty.", 0, studentFeeList.size());
		
		// Add an item (Normal Condition)
		FeeManagementMain.addFees(studentFeeList,f1);
		assertEquals("Test that the studentFeeList arraylist size is now 1.", 1, studentFeeList.size());
		
		
	}

	// ================================= student management  ================================================
	@Test
	public void testRetrieveAllStudent() {
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);

		String allStudent = StudentManagement.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);

		StudentManagement.addStudent(studentList, student1);
		StudentManagement.addStudent(studentList, student2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());

		allStudent = StudentManagement.retrieveAllStudent(studentList);
		testOutput = String.format("%-15s %-15s %-15s\n", "22021234", "Alice", "19");
		testOutput += String.format("%-15s %-15s %-15s\n", "22025678", "Bob", "21");

		assertEquals("Test that ViewAllStudentlist", testOutput, allStudent);

	}

	@Test
	public void testAddStudent() {
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		StudentManagement.addStudent(studentList, student1);

		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", student1, studentList.get(0));

		StudentManagement.addStudent(studentList, student2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that Studentis added", student2, studentList.get(1));

	}
	
	@Test
	public void testDoDeleteStudent() {
	    // Check if there is a valid Student ArrayList to retrieve items
	    assertNotNull("Test if there is a valid Student ArrayList to retrieve items", studentList);

	    // Add students to the studentList
	    StudentManagement.addStudent(studentList, student1);
	    StudentManagement.addStudent(studentList, student2);

	    // Test that the Student ArrayList size is 2
	    assertEquals("Test that the Student ArrayList size is 2", 2, studentList.size());

	    // Test if the correct student is deleted
	    boolean isDeleted = StudentManagement.doDeleteStudent(studentList, student1.getStudentID());
	    assertTrue("Check that the correct student is deleted", isDeleted);

	    // Test that the Student ArrayList size is reduced by one after deletion
	    assertEquals("Test that the Student ArrayList size is 1 after deletion", 1, studentList.size());

	    // Test that the deleted student is no longer in the list
	    assertFalse("Check that the deleted student is no longer in the list", studentList.contains(student1));

	    // Test if the deleteStudent method handles non-existing student IDs correctly
	    boolean nonExistingDelete = StudentManagement.doDeleteStudent(studentList, "12345678");
	    assertFalse("Check that non-existing student ID returns false", nonExistingDelete);
	    assertEquals("Test that the Student ArrayList size remains 1 after attempting to delete a non-existing student", 1, studentList.size());

	}
	// =========================================================================================================
	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
	}

	
}	
