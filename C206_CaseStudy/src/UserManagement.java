import java.util.ArrayList;

public class UserManagement {

    private static final int OPTION_QUIT = 3;
    private static final int OPTION_ADD = 1;
    private static final int OPTION_VIEW = 2;

    public static void userManagementPage(ArrayList<Student> studentList, ArrayList<Teacher> teacherList) {
        ArrayList<User> userList = new ArrayList<User>();

        int option = 0;

        while (option != OPTION_QUIT) {
            menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_VIEW) {
                viewAllUsers(userList);
            } else if (option == OPTION_ADD) {
                addNewUser(userList);
            } else if (option == OPTION_QUIT) {
                System.out.println("Thank you for using User Management!\n");
            } else {
                System.out.println("Invalid option selected");
            }
        }
    }

//        //error proofing 
//        studentList.clear();
//        teacherList.clear();
//
//        for (User user : userList) {
//            if (user instanceof Student) {
//                studentList.add((Student) user);
//            } else if (user instanceof Teacher) {
//                teacherList.add((Teacher) user);
//            }
//        }
//    }

    public static void menu() {
        Helper.line(40, "=");
        System.out.println("******** WELCOME TO USER MANAGEMENT ********");
        Helper.line(40, "=");

        System.out.println("1. Add new user");
        System.out.println("2. View all users");
        System.out.println("3. Quit");
    }

    private static void viewAllUsers(ArrayList<User> userList) {
        Helper.line(40, "=");
        System.out.println(String.format("%-15s %-15s %-15s %-15s", "ID", "NAME", "USER TYPE", "DETAILS"));
        Helper.line(40, "=");
        String output = "";

        for (User user : userList) {
            String userType = user.getUserType();
            String details = user.getUserDetails();

            output += String.format("%-15s %-15s %-15s %-15s\n", user.getUserID(), user.getName(), userType, details);
        }

        System.out.println(output);
    }

    private static void addNewUser(ArrayList<User> userList) {
        boolean isAdded = false;
        Helper.line(40, "=");
        System.out.println("ADD NEW USER");
        Helper.line(40, "=");

        String userID = Helper.readString("Enter user ID > ");
        String userType = Helper.readString("Enter user type (student/teacher) > ");
        String name = Helper.readString("Enter name > ");
        int age = Helper.readInt("Enter age > ");

        //error proofing still 
//        if ("student".equalsIgnoreCase(userType)) {
//            String studentID = Helper.readString("Enter student ID > ");
//            userList.add(new Student(userID, name, studentID, age));
//            System.out.print("");
//            System.out.println("Student has been added ");
//        } else if ("teacher".equalsIgnoreCase(userType)) {
//            String teacherID = Helper.readString("Enter teacher ID > ");
//            userList.add(new Teacher(userID, name, teacherID, age));
//            System.out.print("");
//            System.out.println("Teacher has been added ");
//        } else {
//            userList.add(new User(userID, name));
//            System.out.print("");
//            System.out.println("User has been added ");
        }
    }

