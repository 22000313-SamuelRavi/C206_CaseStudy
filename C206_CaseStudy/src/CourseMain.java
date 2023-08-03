import java.util.ArrayList;

public class CourseMain {
    public static void coursePage() {
        // TODO Auto-generated method stub
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(new Course("C206", "Software Development Process", "Serene Yong", "Thursday"));
        courseList.add(new Course("C209", "Advanced Object-Oriented Programming", "Yeo Koon Huat", "Friday"));
        courseList.add(new Course("C236", "Web Application Development in .Net", "Hew Ka Kian", "Monday"));
        courseList.add(new Course("C328", "Intelligent Networks", "Ivan Wee", "Wednesday"));
        courseList.add(new Course("C327", "Internet Server Technologies", "Sharmila Kanna", "Tuesday"));

        int option = 0;
        while (option != -1) {
            menu();
            int choice = Helper.readInt("Enter an option > ");
            if (choice == 1) {
                addCourse(courseList);
            } else if (choice == 2) {
                viewCourse(courseList);
            } else if (choice == 3) {
                deleteCourse(courseList);
            } else if (choice == 4) {
                System.out.println("Thank you for using Tuition Management System.");
                option = -1;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void menu() 
    {
    	Helper.line(40, "=");
    	System.out.println("*** WELCOME TO COURSE DETAILS ***");
    	Helper.line(40, "=");
        System.out.println("1. Add a new course");
        System.out.println("2. View all courses");
        System.out.println("3. Delete an existing course");
        System.out.println("4. Quit\n");
    }

    public static void viewCourse(ArrayList<Course> courseList) {
        String output = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");
       
        for (Course course : courseList) {
        	
            output += String.format("%-15s %-40s %-30s %-15s\n", course.getCourseID(), course.getTitle(),
                    course.getTeacher(), course.getSchedule());
        }
        System.out.println();
        System.out.println(output);
    }

    public static void addCourse(ArrayList<Course> courseList) {
        String code;
        while (true) {
            code = Helper.readString("Course Code > ");
            boolean courseFound = false;
            for (Course course : courseList) {
                if (code.equalsIgnoreCase(course.getCourseID())) {
                    System.out.println("Course with code " + code + " already exists.");
                    courseFound = true;
                    break;
                }
            }

            if (!courseFound) {
                break;
            }
        }

        String title = Helper.readString("Course Title > ");
        String teacher = Helper.readString("Teacher > ");
        String schedule = Helper.readString("Schedule > ");

        courseList.add(new Course(code, title, teacher, schedule));
        System.out.println("Course added successfully!");
    }

    public static void deleteCourse(ArrayList<Course> courseList) {
        String courseCode = Helper.readString("Enter course code > ");

        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            if (course.getCourseID().equalsIgnoreCase(courseCode)) {
                courseList.remove(i);
                System.out.println("Course with code " + courseCode + " has been deleted successfully!");
                return;
            }
        }

        System.out.println("Course with code " + courseCode + " not found.");
    }
    
    public static void studentMenuOptions() 
    {
    	Helper.line(40, "=");
    	System.out.println("*** STUDENT MENU ***");
    	Helper.line(40, "=");
    	System.out.println("1. View Enrolled Courses");
        System.out.println("2. View Grades");
        System.out.println("3. Return to Main Menu\n");
    }
    
    public static void viewEnrolledCourses(ArrayList<Course> enrolledCourses) 
    {
        String output = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");
        for (Course course : enrolledCourses) 
        {
            output += String.format("%-15s %-40s %-30s %-15s\n", course.getCourseID(), course.getTitle(),
                    course.getTeacher(), course.getSchedule());
        }
        System.out.println();
        System.out.println(output);
    }
    
    public static void studentMenu(ArrayList<Course> courseList) 
    {
    	int option = 0;
    	while (option != -1) 
    	{
    		studentMenuOptions();
            int choice = Helper.readInt("Enter an option > ");
            switch (choice) 
            {
            case 1:
                ArrayList<Course> enrolledCourses = null;
				viewEnrolledCourses(enrolledCourses);
				// Assuming you have a list of enrolled courses for the student
                break;
                
            case 2:
                System.out.println("Returning to main menu...");
                option = -1;
        
            default:
                System.out.println("Invalid option. Please try again.");
            }
    	}
    }
    	
    
    public static void viewAssignedCourses(ArrayList<Course> assignedCourses) {
        String output = String.format("%-15s %-40s %-30s %-15s\n", "COURSE CODE", "TITLE", "INSTRUCTOR", "SCHEDULE");
        for (Course course : assignedCourses) {
            output += String.format("%-15s %-40s %-30s %-15s\n", course.getCourseID(), course.getTitle(),
                    course.getTeacher(), course.getSchedule().toString());
        }
        System.out.println("\n" + output);
    }
    	
    
}
