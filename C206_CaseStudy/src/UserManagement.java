//written by Shwetha
import java.util.ArrayList;

public class UserManagement {
    private static final int OPTION_VIEW = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_DELETE = 3;
    private static final int OPTION_QUIT = 4;

    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<User> studentList = new ArrayList<>();
    private static ArrayList<User> teacherList = new ArrayList<>();

    public static void userManagementPage() {
        // Sample initial data
        userList.add(new User("admin", "admin123", "ADMIN"));
        studentList.add(new User("student1", "student123", "STUDENT"));
        teacherList.add(new User("teacher1", "teacher123", "TEACHER"));

        int option = 0;

        while (option != OPTION_QUIT) {
            UserManagement.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_VIEW) {
                UserManagement.viewAllUsers();
            } else if (option == OPTION_ADD) {
                UserManagement.addUser();
            } else if (option == OPTION_DELETE) {
                UserManagement.deleteUser();
            } else if (option == OPTION_QUIT) {
                System.out.println("Thank you for using User Management!\n");
            } else {
                System.out.println("Invalid option selected");
            }
        }
    }

    public static void menu() {
        Helper.line(80, "=");
        System.out.println("USER MANAGEMENT SYSTEM");
        Helper.line(80, "=");
        System.out.println("1. View all users");
        System.out.println("2. Add new user");
        System.out.println("3. Delete user");
        System.out.println("4. Quit");
        Helper.line(80, "-");
    }

    public static void viewAllUsers() {
        Helper.line(80, "=");
        System.out.println("USER LIST");
        Helper.line(80, "=");

        String output = String.format("%-20s %-10s %-10s\n", "USERNAME", "TYPE", "PASSWORD");
        for (User user : userList) {
            output += String.format("%-20s %-10s %-10s\n", user.getUsername(), user.getUserType(), user.getPassword());
        }

        System.out.println(output);
    }

    public static void addUser() {
        Helper.line(80, "=");
        System.out.println("ADD NEW USER");
        Helper.line(80, "=");

        String username = Helper.readString("Enter username > ");
        String password = Helper.readString("Enter password > ");
        String userType = readUserRole();

        User newUser = new User(username, password, userType);
        userList.add(newUser);

        if (userType.equalsIgnoreCase("STUDENT")) {
            studentList.add(newUser);
        } else if (userType.equalsIgnoreCase("TEACHER")) {
            teacherList.add(newUser);
        }

        System.out.println("User added successfully!");
    }

    public static void deleteUser() {
        viewAllUsers();
        String usernameToDelete = Helper.readString("Enter the username to delete > ");

        User userToRemove = null;
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(usernameToDelete)) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            userList.remove(userToRemove);
            if (userToRemove.getUserType().equalsIgnoreCase("STUDENT")) {
                studentList.remove(userToRemove);
            } else if (userToRemove.getUserType().equalsIgnoreCase("TEACHER")) {
                teacherList.remove(userToRemove);
            }
            System.out.println("User with username " + usernameToDelete + " has been deleted successfully!");
        } else {
            System.out.println("User with username " + usernameToDelete + " not found.");
        }
    }

    public static String readUserRole() {
        Helper.line(80, "=");
        System.out.println("USER ROLES");
        Helper.line(80, "=");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        int choice = Helper.readInt("Enter the user type number > ");
        if (choice == 1) {
            return "STUDENT";
        } else if (choice == 2) {
            return "TEACHER";
        } else {
            System.out.println("Invalid user type selected, setting as STUDENT by default.");
            return "STUDENT";
        }
    }

 
}
