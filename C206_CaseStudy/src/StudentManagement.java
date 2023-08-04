//Created by Kendrick
import java.util.ArrayList;

public class StudentManagement {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	

	public static void studentManagementPage() {

		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("22000313", "Alice", 21));
		studentList.add(new Student("22028492", "Bob", 18));
		studentList.add(new Student("22026533", "Charlie", 19));
		studentList.add(new Student("22013820", "David", 21));
		studentList.add(new Student("22003342", "Ella", 20));

		int option = 0;

		while (option != OPTION_QUIT) {

			StudentManagement.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				viewAllStudent(studentList);
			} else if (option == OPTION_ADD) {
				addNewStudent(studentList);
			} else if (option == OPTION_DELETE) {
				deleteStudent(studentList);
			} else if (option == OPTION_QUIT) {
				System.out.println("Thank you for using Student Management!\n");
			} else {
				System.out.println("Invalid option selected");
			}
		}
	}// end of main

	public static void menu() {
		Helper.line(40, "=");
		System.out.println("*** WELCOME TO STUDENT MANAGEMENT ***");
		Helper.line(40, "=");

		System.out.println("1. View all student");
		System.out.println("2. Add new student");
		System.out.println("3. Delete student");
		System.out.println("4. Quit");
	}// end of menu

	private static void viewAllStudent(ArrayList<Student> studentList) {
		Helper.line(40, "=");
		System.out.println(String.format("%-15s %-15s %-15s", "ID", "NAME", "AGE"));
		Helper.line(40, "=");
		String output = "";

		for (Student s : studentList) {
			output += String.format("%-15s %-15s %-15s\n", s.getStudentID(), s.getName(), s.getAge());
		}

		System.out.println(output);

	}// end of viewAllStudent

	private static void addNewStudent(ArrayList<Student> studentList) {

		boolean isAdded = false;
		Helper.line(40, "=");
		System.out.println("ADD NEW STUDENT");
		Helper.line(40, "=");

		String id = Helper.readString("Enter student ID > ");
		String name = Helper.readString("Enter student name > ");
		int age = Helper.readInt("Enter student age > ");

		for (Student s : studentList) {
			if (studentList != null) {
				String studentID = s.getStudentID();
				if (id.equalsIgnoreCase(studentID)) {
					System.out.print("");
					System.out.println("The student ID has already added");
					isAdded = true;
					break;

				} // end of if
			} // end of if
		} // end of loop

		if (isAdded == false) {
			studentList.add(new Student(id, name, age));
			System.out.print("");
			System.out.println("Student has been added ");
		}

	}// end of addNewStudent

	private static boolean deleteStudent(ArrayList<Student> studentList) {

		boolean studentfound = false;

		Helper.line(40, "=");
		System.out.println("DELETE STUDENT");
		Helper.line(40, "=");

		String id = Helper.readString("Enter student ID to delete > ");
		boolean invalidIDFound = true;

		for (Student s : studentList) {

			String studentID = s.getStudentID();
			if (id.equalsIgnoreCase(studentID)) {
				String sDelete = Helper.readString("Confirm deletion (y/n) > ");

				if (sDelete.equals("y") || sDelete.equals("Y")) {
					studentList.remove(s);
					System.out.println("Student has been deleted.");
				}

				studentfound = true;
				invalidIDFound = false;
				break;
			}
		}

		if (invalidIDFound) {
			System.out.println("Invalid student ID.");
		}

		return studentfound;

	}

}// end of method
