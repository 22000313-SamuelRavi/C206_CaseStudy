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
	
	//CourseMainTest
	private Course cc1;
	private Course cc2;
	private Course cc3;
    private ArrayList<Course> courseList;


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
    	// Course list is not null and it is empty
    	assertNotNull("Test if there is valid Course arraylist to add to", courseList);
    	assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
    	//Given an empty list, after adding 1 item, the size of the list is 1
    	CourseMain.addCourse(courseList, cc1);		
    	assertEquals("Test that the Course arraylist size is 1.", 1, courseList.size());
    	
    	// Add an item
    	CourseMain.addCourse(courseList, cc2);
    	assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());
    	//The item just added is as same as the last item in the list
    	assertSame("Test that Course is added to the end of the list.", cc2, courseList.get(1));
    	
    	//Error condition
    	// Add an item that already exists in the list
    	CourseMain.addCourse(courseList, cc2);
    	assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());

    	// Add an item that has missing detail
    	Course cc_missing = new Course("C110", "", "Andy", "Monday");
    	CourseMain.addCourse(courseList, cc_missing);
    	assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());
    }

    @Test
    public void testViewCourse() {
    	
    	assertNotNull("Test if there is valid Course arraylist to retrieve the courses", courseList);
    	//Add the courses 
    	courseList.add(cc1);
        courseList.add(cc2);
        courseList.add(cc3);
        assertEquals("Test that the Course arraylist size is now 3.", 3, courseList.size());
        
//        String allCourses = CourseMain.viewCourse(courseList);
//        String testOutput = "";
//		assertEquals("Test that viewing all the courses in the courseList is correct", testOutput, allCourses);

        // Normal Condition: Test viewing all existing courses in the courseList
        String expectedOutput = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");
        for (Course course : courseList) {
            expectedOutput += String.format("%-15s %-40s %-30s %-15s\n", course.getCourseID(), course.getTitle(),
                    course.getTeacher(), course.getSchedule());
        }
        String allCourses = CourseMain.viewCourse(courseList);
        assertEquals("Test that viewing all courses in the courseList returns the expected output", expectedOutput, allCourses);

        // Boundary Condition: Test viewing courses when the list is empty
        ArrayList<Course> emptyCourseList = new ArrayList<>();
        String expectOutput = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");
        String emptyOutput = CourseMain.viewCourse(emptyCourseList);
        assertEquals("Test that viewing all courses in an empty courseList returns the appropriate message",expectOutput , emptyOutput);
    }

    @Test
    public void testDeleteCourse() {
    	
    	//Add the courses 
    	courseList.add(cc1);
        courseList.add(cc2);
        courseList.add(cc3);
        
        // Normal Condition: Delete an existing course
        assertNotNull("Test if there is a valid Course arraylist to delete from", courseList);
        assertEquals("Test that the Course arraylist size is 3.", 3, courseList.size());

        CourseMain.deleteCourse(courseList, "C206");
        assertEquals("Test that the Course arraylist size is now 2 after deletion.", 2, courseList.size());
        assertNull("Test that the deleted course C206 is no longer in the list.", findCourse(courseList, "C206"));

        // Error Condition: Attempt to delete a non-existing course
        CourseMain.deleteCourse(courseList, "C999"); // Non-existing course
        assertEquals("Test that the Course arraylist size remains unchanged.", 2, courseList.size());

        // Boundary Condition: Delete all courses
        CourseMain.deleteCourse(courseList, "C209");
        CourseMain.deleteCourse(courseList, "C236");

        assertEquals("Test that the Course arraylist is empty after deleting all courses.", 0, courseList.size());
    }


    // Helper method to find a course in the list based on course code
    private Course findCourse(ArrayList<Course> courseList, String courseCode) 
    {
        for (Course course : courseList) 
        {
            if (course.getCourseID().equalsIgnoreCase(courseCode)) 
            {
                return course;
            }
        }
        return null; // Course not found
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
	}

	
}	
