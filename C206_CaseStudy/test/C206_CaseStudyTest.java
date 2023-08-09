import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_CaseStudyTest {
	
	//fee management test
	private FeeManagement f1;
	private FeeManagement f2;
	private FeeManagement f3;
	private FeeManagement f4;
	private FeeManagement f5;
	
	private ArrayList<FeeManagement> studentFeeList;
	
	//StudentTest
	private Student student1;
	private Student student2;
	
	private ArrayList<Student> studentList;
	
	//CourseMainTest
	private Course cc1;
	private Course cc2;
	private Course cc3;
	
    private ArrayList<Course> courseList;

    
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

	// ================================= course management  =================================		
		// Add some initial courses to the list for testing
        cc1 = new Course("C206", "Software Development Process", "Serene Yong", "Thursday");
        cc2 = new Course("C209", "Advanced Object-Oriented Programming", "Yeo Koon Huat", "Friday");
        cc3 = new Course("C236", "Web Application Development in .Net", "Hew Ka Kian", "Monday");
        
        courseList = new ArrayList<>();
		
		
		
	}
    //================================= fee management  ===================================================
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
      assertEquals("Check that Student Fee arraylist size is 1", 1, studentFeeList.size());
      
      // Add another item
      FeeManagementMain.addFees(studentFeeList, f2);
  	  assertEquals("Test that the Student Fee arraylist size is now 2.", 2, studentFeeList.size());
  	
  	  //The item just added is as same as the last item in the list
      assertSame("Test that Fee is added to the end of the list.", f2, studentFeeList.get(1));
  	  
     //-----Test 3----- 
     // Error condition: Add an item that already exists in the list 
  	  FeeManagementMain.addFees(studentFeeList, f2);
  	  assertEquals("Test that the Student Fee arraylist size is unchanged.", 2, studentFeeList.size());
  	 // Add an item that has missing detail
  	  FeeManagement fee_MD = new FeeManagement(5000, " ", LocalDate.of(2023, 9, 8), "22000313") ;
  	  FeeManagementMain.addFees(studentFeeList,fee_MD );
  	  assertEquals("Test that the Student Fee arraylist size is unchanged.", 2, studentFeeList.size());
  	  
    }
    
    @Test
    public void testViewAllFees() {
    	
    	// Boundary Condition: Student Fee list is not null and it is empty 
    	assertNotNull("Test if there is valid Student Fee arraylist to view the student fees", studentFeeList);
    	
    	// Add the student fees 
    	studentFeeList.add(f1);
    	studentFeeList.add(f2);
    	studentFeeList.add(f3);
    	studentFeeList.add(f4);
    	studentFeeList.add(f5);
        
        assertEquals("Test that the Student Fee arraylist size is now 5.", 5, studentFeeList.size());
        

        // Normal Condition: Test viewing all existing fees in the studentFeeList
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
        String actualOutput = String.format("%-15s %-15s %-15s %-15s \n", "STUDENT ID ", "FEE TYPE  ", "DUE DATE ", "FEE AMOUNT   ");
     
        for (FeeManagement f : studentFeeList) {
        	actualOutput   +="| " + String.format("%-15s", f.getStudentId()) + " | " +
                    String.format("%-15s", f.getFeeType()) + " | " +
                    String.format("%-15s", f.getFeeDueDate().format(formattedDate)) + " | " +
                    "$" + String.format("%-15.2f", f.getFeeAmount()) + " |\n";
        }
        
        String allFees = FeeManagementMain.viewAllFees(studentFeeList);
        assertEquals("Test that viewing all Students Fees in the studentFeeList returns the wanted output", actualOutput, allFees);

        // Boundary Condition: Test viewing all student fees when the list is empty
        ArrayList<FeeManagement> emptyStudentFeeList = new ArrayList<>();
        String Output = String.format("%-15s %-15s %-15s %-15s \n", "STUDENT ID ", "FEE TYPE  ", "DUE DATE ", "FEE AMOUNT   ");
        String emptyOutput = FeeManagementMain.viewAllFees(emptyStudentFeeList);
        assertEquals("Test that viewing all fees in an empty studentFeeList returns the appropriate message",Output , emptyOutput);
    }
    
    
    @Test
    public void testDeleteFee() {
    	
    	// Boundary Condition: Student Fee list is not null and it is empty 
    	assertNotNull("Test if there is valid Student Fee arraylist to view the Student Fees", studentFeeList);
    	
    	// Add the student fees 
    	studentFeeList.add(f1);
    	studentFeeList.add(f2);
    	studentFeeList.add(f3);
    	studentFeeList.add(f4);
    	studentFeeList.add(f5);
        
        // Normal Condition: Delete an existing course
        assertNotNull("Test if there is a valid Student Fee arraylist to delete from",studentFeeList );
        assertEquals("Test that the Student Fee arraylist size is 5.", 5, studentFeeList.size());

        boolean isDeleted = FeeManagementMain.deleteFee(studentFeeList, f1.getStudentId());
        assertTrue("Test that the correct Student's fee is deleted", isDeleted);
        assertEquals("Test that the Student Fee arraylist size is now 4 after deletion.", 4, studentFeeList.size());
        assertFalse("Test that the deleted Student Fee is no longer in the list", studentFeeList.contains(f1));

        // Error Condition: Attempt to delete a Student Fee that does not exist in the list
        
        FeeManagementMain.deleteFee(studentFeeList, "22026534"); // Student Fee that does not exist
        boolean deleteNo = FeeManagementMain.deleteFee(studentFeeList, "22026534");
        assertFalse("Test that non-existing Student Fee is not found and not deleted", deleteNo);
        assertEquals("Test that the Student Fee arraylist size remains unchanged.", 4, studentFeeList.size());

        // Boundary Condition: Delete all Student Fees
       FeeManagementMain.deleteFee(studentFeeList, f2.getStudentId());
       FeeManagementMain.deleteFee(studentFeeList, f3.getStudentId());
       FeeManagementMain.deleteFee(studentFeeList, f4.getStudentId());
       FeeManagementMain.deleteFee(studentFeeList, f5.getStudentId());

        assertEquals("Test that the Student Fee arraylist is empty after deleting all fees.", 0, studentFeeList.size());
    }

    
	// ================================= student management  ================================================
	@Test
	public void testRetrieveAllStudent() {
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);

		String allStudent = StudentManagement.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist is correct", testOutput, allStudent);

		StudentManagement.addStudent(studentList, student1);
		StudentManagement.addStudent(studentList, student2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());

		allStudent = StudentManagement.retrieveAllStudent(studentList);
		testOutput = String.format("%-15s %-15s %-15s\n", "22021234", "Alice", "19");
		testOutput += String.format("%-15s %-15s %-15s\n", "22025678", "Bob", "21");

		assertEquals("Test that ViewAllStudentlist is correct", testOutput, allStudent);

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
	
	
	
	
	// ================================= Course management  =================================		
	
	@Test
    public void testAddCourse() 
    {
    	//Boundary condition:
    	// Course list is not null and it is empty
    	assertNotNull("Test if there is valid Course arraylist to add to", courseList);
    	assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
    	
    	
    	//Normal condition:
    	//Given an empty list, after adding 1 item, the size of the list is 1
    	CourseMain.addCourse(courseList, cc1);		
    	assertEquals("Test that the Course arraylist size is 1.", 1, courseList.size());
    	// Add another item
    	CourseMain.addCourse(courseList, cc2);
    	assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());
    	//The item just added is as same as the last item in the list
    	assertSame("Test that Course is added to the end of the list.", cc2, courseList.get(1));
    	
    	
    	//Error condition:
    	// Add an item that already exists in the list
    	CourseMain.addCourse(courseList, cc2);
    	assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());
    }

    @Test
    public void testViewCourse() {
    	//Boundary condition:
        assertNotNull("Test if there is a valid Course arraylist to retrieve the courses", courseList);
        // Test viewing courses when the list is empty
        String emptyOutput = CourseMain.viewCourse(courseList);
        String expectedEmptyOutput = "";
        assertEquals("Test that viewing all courses in an empty courseList returns the appropriate message",
                expectedEmptyOutput, emptyOutput);

        
        //Normal condition:
        // Add the courses
        courseList.add(cc1);
        courseList.add(cc2);
        courseList.add(cc3);
        assertEquals("Test that the Course arraylist size is now 3.", 3, courseList.size());
        
        // Test viewing all existing courses in the courseList
        String expectedOutput = "";
        expectedOutput += String.format("| %-15s | %-40s | %-25s | %-10s |\n", cc1.getCourseID(), cc1.getTitle(),
                cc1.getTeacher(), cc1.getSchedule());
        expectedOutput += String.format("| %-15s | %-40s | %-25s | %-10s |\n", cc2.getCourseID(), cc2.getTitle(),
                cc2.getTeacher(), cc2.getSchedule());
        expectedOutput += String.format("| %-15s | %-40s | %-25s | %-10s |\n", cc3.getCourseID(), cc3.getTitle(),
                cc3.getTeacher(), cc3.getSchedule());
       
        String allCourses = CourseMain.viewCourse(courseList);
        assertEquals("Test that viewing all courses in the courseList returns the expected output", expectedOutput, allCourses);
    }


    @Test
    public void testDeleteCourse() {
    	
    	//Add the courses 
    	courseList.add(cc1);
        courseList.add(cc2);
        courseList.add(cc3);
        
        // Normal Condition:
        // Delete an existing course
        assertNotNull("Test if there is a valid Course arraylist to delete from", courseList);
        assertEquals("Test that the Course arraylist size is 3.", 3, courseList.size());

        boolean isDeleted = CourseMain.deleteCourse(courseList, cc1.getCourseID());
        assertTrue("Test that the correct course is deleted", isDeleted);
        assertEquals("Test that the Course arraylist size is now 2 after deletion.", 2, courseList.size());
        
        assertFalse("Test that the deleted course is no longer in the list", courseList.contains(cc1));

        
        // Error Condition:
        // Attempt to delete a non-existing course
        
        CourseMain.deleteCourse(courseList, "C999"); // Non-existing course
        boolean deleteNo = CourseMain.deleteCourse(courseList, "C999");
        assertFalse("Test that non-existing course is not found in the list and not deleted", deleteNo);
        assertEquals("Test that the Course arraylist size remains unchanged.", 2, courseList.size());

        
        // Boundary Condition: 
        // Delete all courses
        CourseMain.deleteCourse(courseList, cc2.getCourseID());
        CourseMain.deleteCourse(courseList, cc3.getCourseID());

        assertEquals("Test that the Course arraylist is empty after deleting all courses.", 0, courseList.size());
    }

	
	
	// =========================================================================================================
	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
		
		cc1 = null;
        cc2 = null;
        cc3 = null;
        courseList = null;
        
        f1 = null;
        f2 = null;
        f3 = null;
        f4 = null;
        f5 = null;
	}

	
}	
