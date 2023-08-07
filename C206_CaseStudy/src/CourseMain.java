import java.util.ArrayList;

public class CourseMain {
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;

	public static void coursePage() {
		// TODO Auto-generated method stub
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course("C206", "Software Development Process", "Serene Yong", "Thursday"));
		courseList.add(new Course("C209", "Advanced Object-Oriented Programming", "Yeo Koon Huat", "Friday"));
		courseList.add(new Course("C236", "Web Application Development in .Net", "Hew Ka Kian", "Monday"));
		courseList.add(new Course("C328", "Intelligent Networks", "Ivan Wee", "Wednesday"));
		courseList.add(new Course("C327", "Internet Server Technologies", "Sharmila Kanna", "Tuesday"));

		int option = 0;
		while (option != OPTION_QUIT) {
			menu();
			int choice = Helper.readInt("Enter an option > ");

			if (choice == OPTION_ADD) {
				Course inputCourse = CourseMain.inputCourse();
				CourseMain.addCourse(courseList, inputCourse);
				System.out.println("Course successfully added!");
			} else if (choice == OPTION_VIEW) {
				viewCourse(courseList);
			} else if (choice == OPTION_DELETE) {
				String courseCodeToDelete = Helper.readString("Enter the course code to delete > ");
				deleteCourse(courseList, courseCodeToDelete);
			} else if (choice == OPTION_QUIT) {
				System.out.println("Thank you for using Tuition Management System.");
				option = OPTION_QUIT;
			} else {
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

	public static void menu() {
		Helper.line(40, "=");
		System.out.println("*** WELCOME TO COURSE DETAILS ***");
		Helper.line(40, "=");
		System.out.println("1. Add a new course");
		System.out.println("2. View all courses");
		System.out.println("3. Delete an existing course");
		System.out.println("4. Quit\n");
	}

	// View all course details
	public static String viewCourse(ArrayList<Course> courseList) {
		String output = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");

		for (Course course : courseList) {
			output += String.format("%-15s %-40s %-30s %-15s\n", course.getCourseID(), course.getTitle(),
					course.getTeacher(), course.getSchedule());
		}
		System.out.println();
		System.out.println(output);
		return output;
	}

	// Add a new course
	public static void addCourse(ArrayList<Course> courseList, Course cc) {
		Course c;
		for (int i = 0; i < courseList.size(); i++) {
			c = courseList.get(i);
			if (c.getCourseID().equalsIgnoreCase(cc.getCourseID()))
				return;
		}
		if ((cc.getCourseID().isEmpty()) || (cc.getTitle().isEmpty())) {
			return;
		}
		courseList.add(cc);
	}

	// New method to input course details
	public static Course inputCourse() {
		String courseCode = Helper.readString("Enter course code > ");
		String title = Helper.readString("Enter title > ");
		String instructor = Helper.readString("Enter instructor > ");
		String schedule = Helper.readString("Enter schedule > ");

		return new Course(courseCode, title, instructor, schedule);
	}

	// Delete an existing course
	public static void deleteCourse(ArrayList<Course> courseList, String courseCodeToDelete) {
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			if (course.getCourseID().equalsIgnoreCase(courseCodeToDelete)) {
				// Prompt for confirmation before deletion
				System.out.println("Are you sure you want to delete the following course?");
				System.out.println("Course Code: " + course.getCourseID());
				System.out.println("Title: " + course.getTitle());
				System.out.println("Instructor: " + course.getTeacher());
				System.out.println("Schedule: " + course.getSchedule());

				String confirm = Helper.readString("Deletion confirm (yes/no) > ");
				if (confirm.equalsIgnoreCase("yes")) {
					courseList.remove(i);
					System.out.println("Course with code " + courseCodeToDelete + " has been deleted successfully!");
				} else if (confirm.equalsIgnoreCase("no")) {
					System.out
							.println("Deletion canceled. Course with code " + courseCodeToDelete + " was not deleted.");
				} else {
					System.out.println("Invalid input. Please enter 'yes' or 'no' for confirmation.");
				}
				return;
			}
		}
		System.out.println("Course with code " + courseCodeToDelete + " not found.");
	}

}
