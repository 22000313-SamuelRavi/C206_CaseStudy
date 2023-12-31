
//Created by Kendrick
import java.util.ArrayList;

public class StudentManagement {

	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_UPDATE = 4;
	private static final int OPTION_SEARCH = 5;
	private static final int OPTION_QUIT = 6;

	public static void studentManagementPage() {

		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("22000313", "Alice", 21));
		studentList.add(new Student("22028492", "Bob", 18));
		studentList.add(new Student("22026533", "Charlie", 19));
		studentList.add(new Student("22013820", "David", 21));
		studentList.add(new Student("22003342", "Elsa", 20));

		int option = 0;

		while (option != OPTION_QUIT) {

			StudentManagement.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				StudentManagement.viewAllStudent(studentList);

			} else if (option == OPTION_ADD) {
				StudentManagement.setHeader("ADD STUDENT");
				Student s = inputStudent();
				StudentManagement.addStudent(studentList, s);

			} else if (option == OPTION_DELETE) {
				StudentManagement.setHeader("DELETE STUDENT");
				StudentManagement.deleteStudent(studentList);

			} else if (option == OPTION_UPDATE) {
				StudentManagement.setHeader("UPDATE STUDENT");
				StudentManagement.updateStudent(studentList);

			} else if (option == OPTION_SEARCH) {
				StudentManagement.setHeader("SEARCH STUDENT");
				StudentManagement.searchStudent(studentList);

			} else if (option == OPTION_QUIT) {
				System.out.println("Thank you for using Student Management!\n");

			} else {
				System.out.println("Invalid option selected");
			}
		}
	}// end of main

	public static void menu() {
		StudentManagement.setHeader("STUDENT MANAGEMENT SYSTEM");
		System.out.println("1. View all student");
		System.out.println("2. Add new student");
		System.out.println("3. Delete student");
		System.out.println("4. Update student");
		System.out.println("5. Search student");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}// end of menu

	public static void setHeader(String header) {
		Helper.line(55, "=");
		System.out.println(header);
		Helper.line(55, "=");
	}

	// ================================= Option 1 View
	// =================================
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {

			String str = studentList.get(i).toString();
			output += String.format("%-47s\n", str);
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<Student> studentList) {
		StudentManagement.setHeader("                    STUDENT LIST");
		String output = "";
		System.out.println(String.format("| %-15s | %-15s | %-15s |", "ID", "NAME", "AGE"));
		Helper.line(55, "-");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}

	// ================================= Option 2 Add
	// =================================
	public static Student inputStudent() {
		String id = Helper.readString("Enter student ID > ");
		String name = Helper.readString("Enter student name > ");
		int age = Helper.readInt("Enter student age > ");

		Student s = new Student(id, name, age);
		return s;

	}

	public static void addStudent(ArrayList<Student> studentList, Student s) {
		for (Student existingStudent : studentList) {
			String studentID = s.getStudentID();
			if (existingStudent.getStudentID().equalsIgnoreCase(studentID)) {
				System.out.println("Student ID already exists");
				return;
			}
		}

		if (s.getStudentID().isEmpty() || s.getName().isEmpty() || s.getAge() <= 0) {
			System.out.println("Invalid student information");
			return;
		}

		studentList.add(s);
		System.out.println("Student added");

	}// end of addNewStudent

	// ================================= Option 3 Delete
	// =================================
	public static boolean doDeleteStudent(ArrayList<Student> studentList, String s) {
		boolean isDeleted = false;

		if (s.isEmpty()) {
			return false;
		}

		for (int i = 0; i < studentList.size(); i++) {
			String studentID = studentList.get(i).getStudentID();

			if (s.equalsIgnoreCase(studentID)) {
				studentList.remove(i);
				isDeleted = true;
				break;
			}
		}

		return isDeleted;
	}

	public static void deleteStudent(ArrayList<Student> studentList) {
		StudentManagement.viewAllStudent(studentList);
		String id = Helper.readString("Enter student ID to delete > ");
		boolean confirmDelete = Helper.readBoolean("Are you sure you want to delete student " + id + "? (yes/no) ");

		if (confirmDelete) {
			boolean isDelete = doDeleteStudent(studentList, id);
			if (!isDelete) {
				System.out.println("Invalid student ID");
			} else {
				System.out.println("Student " + id + " deleted.");
			}
		} else {
			System.out.println("Deletion canceled.");
		}

	}

	// ================================= Option 4 Update
	// =================================
	public static void updateStudent(ArrayList<Student> studentList) {
		StudentManagement.viewAllStudent(studentList);
		String id = Helper.readString("Enter student ID to update > ");

		for (Student student : studentList) {
			if (student.getStudentID().equalsIgnoreCase(id)) {
				String newName = Helper.readString("Enter new student name > ");
				int newAge = Helper.readInt("Enter new student age > ");

				student.setName(newName);
				student.setAge(newAge);

				System.out.println("Student details updated.");
				return;
			}
		}

		System.out.println("Student ID not found.");
	}

	// ================================= Option 6 Search
	// =================================
	public static void searchStudent(ArrayList<Student> studentList) {
		String searchTerm = Helper.readString("Enter student ID or name to search > ");

		boolean found = false;

		for (Student student : studentList) {
			if (student.getStudentID().equalsIgnoreCase(searchTerm) || student.getName().equalsIgnoreCase(searchTerm)) {
				System.out.println("Student found:");
				Helper.line(25, "=");
				student.display();
				Helper.line(25, "=");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Student not found.");
		}
	}

}// end of method
