import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// created by Kendrick
public class StudentTestCase {

	// StudentTest
	// Done by Kendrick
	private Student student1;
	private Student student2;

	private ArrayList<Student> studentList;

	@Before
	public void setUp() throws Exception {

		// StudentTest
		// Done by Kendrick
		student1 = new Student("22021234", "Alice", 19);
		student2 = new Student("22025678", "Bob", 21);

		studentList = new ArrayList<Student>();

	}

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

		// Error condition:
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
		// Test that the Student ArrayList size is 0
		StudentManagement.doDeleteStudent(studentList, student1.getStudentID());
		StudentManagement.doDeleteStudent(studentList, student2.getStudentID());

		// Test that the Student ArrayList size is reduced by two after deletion
		assertEquals("Test that the Student arraylist is empty after deleting all student.", 0, studentList.size());

		// Test that the deleted student is no longer in the list
		assertFalse("Check that the deleted student is no longer in the list", studentList.contains(student1));

		// Error Condition:
		// Attempt to delete a non-existing student
		boolean deleteStudent = StudentManagement.doDeleteStudent(studentList, "12345678"); // Non-existing student
		assertFalse("Test that non-existing student is not found in the list and not deleted", deleteStudent);
		assertEquals("Test that the Student arraylist size remains unchanged.", 0, studentList.size());

	}

	@After
	public void tearDown() throws Exception {

		// StudentTest
		// Done by Kendrick
		student1 = null;
		student2 = null;

	}

}
