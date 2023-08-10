//CourseMainTest
//Completed by Khin

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;

public class CourseMainTest 
{
	private Course cc1;
	private Course cc2;
	private Course cc3;
    private ArrayList<Course> courseList;

    @Before
    public void setUp() throws Exception 
    {
        // Add some initial courses to the list for testing
        cc1 = new Course("C206", "Software Development Process", "Serene Yong", "Thursday");
        cc2 = new Course("C209", "Advanced Object-Oriented Programming", "Yeo Koon Huat", "Friday");
        cc3 = new Course("C236", "Web Application Development in .Net", "Hew Ka Kian", "Monday");
        courseList = new ArrayList<>();
    }

    
  	
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

    @After
    public void tearDown() throws Exception 
    {
        cc1 = null;
        cc2 = null;
        cc3 = null;
        courseList = null;
    }
}