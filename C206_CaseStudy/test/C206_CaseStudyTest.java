import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student student1;
	private Student student2;

	private ArrayList<Student> studentList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		student1 = new Student("22021234", "Alice", 19);
		student2 = new Student("22025678", "Bob", 21);

		studentList = new ArrayList<Student>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);

	}

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
	public void testDeleteStudent() {
		// not done
	}

	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
	}
}
