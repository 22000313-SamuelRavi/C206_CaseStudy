//written by Shwetha
//fixed error
import java.util.ArrayList;

public class UserManagement {
    private static final int OPTION_VIEW = 1;
    private static final int OPTION_ADD = 2;
    private static final int OPTION_DELETE = 3;
    private static final int OPTION_QUIT = 4;

    private static ArrayList<User> userList = new ArrayList<>();

    public static void userManagementPage() {
        // Sample initial data
        userList.add(new User("admin", "admin123", "ADMIN"));
        userList.add(new User("student1", "student123", "STUDENT"));
        userList.add(new User("teacher1", "teacher123", "TEACHER"));

        int option = 0;

        while (option != OPTION_QUIT) {
            UserManagement.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_VIEW) {
                UserManagement.viewAllUsers(userList);
            } else if (option == OPTION_ADD) {
              Helper.line(80, "=");
                 System.out.println("ADD NEW USER");
                 Helper.line(80, "=");

                 User inputUser = UserManagement.readUser();
                UserManagement.addUser(userList, inputUser);
            } else if (option == OPTION_DELETE) {
             String userToRemove = Helper.readString("Enter the username of user to delete >");
                UserManagement.deleteUser(userList, userToRemove);
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

    public static String viewAllUsers(ArrayList<User>userList) {
        Helper.line(80, "=");
        System.out.println("USER LIST");
        Helper.line(80, "=");
        String output = "";

         System.out.println(String.format("| %-15s | %-20s | %-25s\n", "USERNAME", "TYPE", "PASSWORD"));
        for (User user : userList) {
            output += String.format("| %-15s | %-20s | %-25s\n", user.getUsername(), user.getUserType(), user.getPassword());
        }

        System.out.println(output);
  return output;
    }

    public static void addUser(ArrayList<User> userList, User user1) {
   
        userList.add(user1);
        System.out.println("User added.");
        

        

//        if (userType.equalsIgnoreCase("STUDENT")) {
//            studentList.add(newUser);
//        } else if (userType.equalsIgnoreCase("TEACHER")) {
//            teacherList.add(newUser);
//        }

        System.out.println("User added successfully!");
    }

    public static boolean deleteUser(ArrayList<User> userList, String string) {
        viewAllUsers(userList);
        boolean removed = false;
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
            removed = true;
            /*if (userToRemove.getUserType().equalsIgnoreCase("STUDENT")) {
               userList.remove(userToRemove);
            } else if (userToRemove.getUserType().equalsIgnoreCase("TEACHER")) {
                userList.remove(userToRemove);
            }*/
            System.out.println("User with username " + usernameToDelete + " has been deleted successfully!");
        } else {
            System.out.println("User with username " + usernameToDelete + " is not found!");
            removed = false;
        }
        return removed;
    }
    public static User readUser() {
    	while (true) {
    	String username = Helper.readString("Enter username > ");
    	String password = Helper.readString("Enter password > ");
    	String userType = Helper.readString("Enter user type >");   	

    	        // Perform validation checks on input fields
    	        if (username.trim().isEmpty()) {
    	            System.out.println("Error: Username field is missing. Please try again.");
    	            continue;
    	        }
    	        if (password.trim().isEmpty()) {
    	            System.out.println("Error: Password field is missing. Please try again.");
    	            continue;
    	        }
    	        if (userType.trim().isEmpty()) {
    	            System.out.println("Error: User type field is missing. Please try again.");
    	            continue;
    	        }

    	        // Perform additional validation if needed, e.g., valid user types
    	        
    	        User newUser = new User(username, password, userType);
    	        return newUser;
    	    }
    	}


   }
