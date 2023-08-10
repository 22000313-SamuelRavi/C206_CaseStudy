import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class C206_CaseStudyTest {
	
	//fee management test
	// Done by Priya
	private FeeManagement f1;
	private FeeManagement f2;
	private FeeManagement f3;
	
	
	private ArrayList<FeeManagement> studentFeeList;
	
	//StudentTest
	// Done by Kendrick
	private Student student1;
	private Student student2;
	
	private ArrayList<Student> studentList;
	
	//CourseMainTest
	// Done by Khin
	private Course cc1;
	private Course cc2;
	private Course cc3;
	
    private ArrayList<Course> courseList;
    
    //EnrolementManagementTest
    // Done by Samuel
    private EnrolementManagement em1;
    private EnrolementManagement em2;
    private EnrolementManagement em3;
    private EnrolementManagement em4;
    private EnrolementManagement em5;
    
    private ArrayList<EnrolementManagement> enrolList;
    
    //UserManagementTest
    // Done by Shwetha
    private User user1;
    private User user2;
    private User user3;
    
    private static ArrayList<User> userList;
    
	public C206_CaseStudyTest() {
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
		
		
	// ================================= student management  =================================
		
		//StudentTest
		// Done by Kendrick
		student1 = new Student("22021234", "Alice", 19);
		student2 = new Student("22025678", "Bob", 21);

		studentList = new ArrayList<Student>();

	// ================================= course management  =================================		
		// Add some initial courses to the list for testing
		//CourseMainTest
		// Done by Khin
        cc1 = new Course("C206", "Software Development Process", "Serene Yong", "Thursday");
        cc2 = new Course("C209", "Advanced Object-Oriented Programming", "Yeo Koon Huat", "Friday");
        cc3 = new Course("C236", "Web Application Development in .Net", "Hew Ka Kian", "Monday");
        
        courseList = new ArrayList<>();
		
    // =============================== enrollment management ==============================================
        //EnrolementManagementTest
        // Done by Samuel
        em1 = new EnrolementManagement("22000313", "C206", 3.7);
		em2 = new EnrolementManagement("22028492", "C209", 3.1);
		em3 = new EnrolementManagement("22026533", "C236", 3.9);
		em4 = new EnrolementManagement("22013820", "C328", 3.5);
		em5 = new EnrolementManagement("22003342", "C327", 3.8);
		
		enrolList = new ArrayList<EnrolementManagement>();
	
	//=====================================user management====================================================
	
		//UserManagementTest
	    // Done by Shwetha
	user1 = new User("sally", "sally123", "STUDENT");
	user2 = new User ("tom", "tom567", "TEACHER");
	user3 = new User ("mario", "mario345", "ADMIN");
	
	 userList = new ArrayList<User>();
	
	}		       
    //================================= fee management  ===================================================
	// Done by Priya
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
	  	  
	     //-----Test 3----- 
	     // Error condition: Add an item that already exists in the list 
	  	  FeeManagementMain.addFees(studentFeeList, f2);
	  	  System.out.println();
	  	  System.out.println("The newly added student fees was not added as it already exists in the list!");
	  	  assertEquals("Test that the Student Fee arraylist size is unchanged.", 2, studentFeeList.size());
	  	 // Add an item that has missing detail
	  	  FeeManagement fee_MD = new FeeManagement(5000, " ", LocalDate.of(2023, 9, 8), "22000313") ;
	  	  FeeManagementMain.addFees(studentFeeList,fee_MD );
	  	  System.out.println();
	  	  System.out.println("Student fees cannot be added as it has missing detail!");
	  	  assertEquals("Test that the Student Fee arraylist size is unchanged.", 2, studentFeeList.size());
	  	
	  	  
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

  
   
    
	// ================================= student management  ================================================
	  //StudentTest
		// Done by Kendrick
	@Test
	public void testRetrieveAllStudent() {
		// Normal condition:
		// Check if there is a valid Student ArrayList to retrieve items
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);

		String allStudent = StudentManagement.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist is correct", testOutput, allStudent);

		// Boundary condition:
		// Added two student in the Student ArrayList and the size is 2
		StudentManagement.addStudent(studentList, student1);
		StudentManagement.addStudent(studentList, student2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());

		allStudent = StudentManagement.retrieveAllStudent(studentList);
		testOutput = String.format("| %-15s | %-15s | %-15s |\n", "22021234", "Alice", "19");
		testOutput += String.format("| %-15s | %-15s | %-15s |\n", "22025678", "Bob", "21");

		assertEquals("Test that ViewAllStudentlist is correct", testOutput, allStudent);

		// Error condition:
		// Add an invalid student to the list and test if it handles the error
	    Student invalidStudent = new Student("", "", -1); // Invalid student
	    studentList.add(invalidStudent);

	    allStudent = StudentManagement.retrieveAllStudent(studentList);
	    testOutput += String.format("| %-15s | %-15s | %-15s |\n", "", "", -1); // Expected error output

	    assertEquals("Test error condition: Invalid student information", testOutput, allStudent);
		
	}

	@Test
	public void testAddStudent() {
		// Normal condition:
		// Check if there is a valid Student ArrayList to retrieve items
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		
		// Test that the student is added inside Student ArrayList and size is 1 
		StudentManagement.addStudent(studentList, student1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", student1, studentList.get(0));

		// Boundary condition:
		// Test that two student is added inside Student ArrayList and size is 2
		StudentManagement.addStudent(studentList, student2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that Studentis added", student2, studentList.get(1));

		//Error condition:
	    // Test if the addStudent method added the student ID already exist
		StudentManagement.addStudent(studentList, student2);
    	assertEquals("Test that the Student arraylist size is unchange.", 2, studentList.size());
	}
	
	@Test
	public void testDoDeleteStudent() {
		// Normal condition:
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
	    
	    // Boundary condition:
	    //Test that the Student ArrayList size is 0
	    StudentManagement.doDeleteStudent(studentList, student1.getStudentID());
	    StudentManagement.doDeleteStudent(studentList, student2.getStudentID());

	    //Test that the Student ArrayList size is reduced by two after deletion
        assertEquals("Test that the Student arraylist is empty after deleting all student.", 0, studentList.size());

	    // Test that the deleted student is no longer in the list
	    assertFalse("Check that the deleted student is no longer in the list", studentList.contains(student1));

        // Error Condition:
        // Attempt to delete a non-existing student
	    boolean deleteStudent = StudentManagement.doDeleteStudent(studentList, "12345678"); // Non-existing student
	    assertFalse("Test that non-existing student is not found in the list and not deleted", deleteStudent);
	    assertEquals("Test that the Student arraylist size remains unchanged.", 0, studentList.size());

	}
	
	
	
	
	// ================================= Course management  =================================	
	//CourseMainTest
	// Done by Khin
	
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

// ===================================== Enrollment Management =============================================
    //EnrolementManagementMain test
    //Done by Samuel
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
       
        String allUsers = EnrolementManagementMain.viewEnrol(enrolList);
        assertEquals("Test that viewing all enrollments in the enrolList returns the expected output", expectedOutput, allUsers);	
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
        boolean deleteNo = EnrolementManagementMain.deleteEnrol(enrolList, "22000123");  
        assertFalse("Test that non-existing enrollment is not found in the list and not deleted", deleteNo);
        assertEquals("Test that the EnrolementManagementMain arraylist size remains unchanged.", 4, enrolList.size());

        
        // Boundary Condition: 
        // Delete all enrollments
        EnrolementManagementMain.deleteEnrol(enrolList, em2.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em3.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em4.getStudentId());
        EnrolementManagementMain.deleteEnrol(enrolList, em5.getStudentId());

        assertEquals("Test that the EnrolementManagementMain arraylist is empty after deleting all enrollments.", 0, enrolList.size());
    }
    
    //===================================User Management=======================================================
	//Done by Shwetha
    @Test
    public void testAddUser() 
    {
    	//Boundary condition:
    	// Course list is not null and it is empty
    	assertNotNull("Test if there is valid User arraylist to add to", userList);
    	assertEquals("Test that the User arraylist is empty.", 0, userList.size());
    	
    	
    	//Normal condition:
    	//Given an empty list, after adding 1 item, the size of the list is 1
    	UserManagement.addUser(userList, user1);		
    	assertEquals("Test that the User arraylist size is 1.", 1, userList.size());
    	// Add another item
    	UserManagement.addUser(userList, user2);
    	assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
    	//The item just added is as same as the last item in the list
    	assertSame("Test that User is added to the end of the list.", user2, userList.get(1));
    	
    	
    	//Error condition:
    	// Add an item that already exists in the list
    	UserManagement.addUser(userList, user2);
    	assertEquals("Test that the User arraylist size is unchange.", 3, userList.size());
    }

    @Test
    public void testViewAllUsers() {
    	//Boundary condition:
        assertNotNull("Test if there is a valid User arraylist to retrieve the courses", userList);
        // Test viewing courses when the list is empty
        String emptyOutput = UserManagement.viewAllUsers(userList);
        String expectedEmptyOutput = "";
        assertEquals("Test that viewing all users in an empty userList returns the appropriate message",
                expectedEmptyOutput, emptyOutput);

        
        //Normal condition:
        // Add the courses
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        assertEquals("Test that the User arraylist size is now 3.", 3, userList.size());
        
        // Test viewing all existing courses in the courseList
        String expectedOutput = "";
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user1.getUsername(), user1.getUserType(),
                user1.getPassword());
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user2.getUsername(), user2.getUserType(),
                user2.getPassword());
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user3.getUsername(), user3.getUserType(),
                user3.getPassword());
       
        String allUsers = UserManagement.viewAllUsers(userList);
        assertEquals("Test that viewing all users in the userList returns the expected output", expectedOutput, allUsers);
    }


    @Test
    public void testDeleteUser() {
    	
    	//Add the courses 
    	userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        
        // Normal Condition:
        // Delete an existing course
        assertNotNull("Test if there is a valid User arraylist to delete from", userList);
        assertEquals("Test that the User arraylist size is 3.", 3, userList.size());

        boolean isDeleted = UserManagement.deleteUser(userList, user1.getUsername());
        assertTrue("Test that the correct user is deleted", isDeleted);
        assertEquals("Test that the User arraylist size is now 2 after deletion.", 2, userList.size());
        
        assertFalse("Test that the deleted course is no longer in the list", courseList.contains(user1));

        
        // Error Condition:
        // Attempt to delete a non-existing course
        
        UserManagement.deleteUser(userList, "billy789"); // Non-existing User
        boolean deleteNo = UserManagement.deleteUser(userList, "billy789");
        assertFalse("Test that non-existing user is not found in the list and not deleted", deleteNo);
        assertEquals("Test that the User arraylist size remains unchanged.", 2, userList.size());

        
        // Boundary Condition: 
        // Delete all courses
        UserManagement.deleteUser(userList, user2.getUsername());
        UserManagement.deleteUser(userList, user3.getUsername());

        assertEquals("Test that the User arraylist is empty after deleting all courses.", 0, userList.size());
    }
	
	// =========================================================================================================
	@After
	public void tearDown() throws Exception {
		
		//StudentTest
		// Done by Kendrick
		student1 = null;
		student2 = null;
		
		//CourseMainTest
		// Done by Khin
		cc1 = null;
        cc2 = null;
        cc3 = null;
        courseList = null;
        
        // fee management
        // Done by Priya
        f1 = null;
        f2 = null;
        f3 = null;
        
        //enrollment management
        // Done by Samuel	
        em1 = null;
        em2 = null;
        em3 = null;
        em4 = null;
        em5 = null;
        
    
	}

	
}	
