// admin page done by team 5
public class C206_CaseStudy {

	public static void main(String[] args) {

		Helper.line(70, "=");
		System.out.println("******************** TUITION MANAGEMENT SYSTEM  **********************");
		Helper.line(70, "=");

		System.out.println();
		Helper.line(23, "-");
		System.out.println("✰ What user are you? ✰");
		Helper.line(23, "-");

		System.out.println("1. Administrator");
		System.out.println("2. Student");
		System.out.println("3. Teacher");

		System.out.println();
		int user = Helper.readInt("» Enter an option: ");

		if (user == 1) {
			adminPage();

		} else if (user == 2) {
			studentPage();

		} else if (user == 3) {

			System.out.println();
			System.out.println("The Teacher menu is underdeveloped at the moment!");

		} else {
			System.out.println();
			System.out.println("Invalid input");
		}
	} // End of main method

	public static void adminMenu() {
		Helper.line(70, "-");
		System.out.println("******************** MANAGEMENT SERVICES  ****************************");
		Helper.line(70, "-");

		System.out.println();

		System.out.println("1. Course Management");
		System.out.println("2. Fee Management");
		System.out.println("3. User Management");
		System.out.println("4. Student Management");
		System.out.println("5. Enrolment Management");
		System.out.println("6. Quit");
	} // End of adminMenu method

	private static void adminPage() {
		int maxAttempts = 3;
		int attempts = 0;

		while (attempts < maxAttempts) {
			String username = Helper.readString("Enter Username: ");
			String password = Helper.readString("Enter Password: ");
			System.out.println();
			if (username.equalsIgnoreCase("bob") && password.equals("1")) {
				int option = 0;
				while (option != 6) {
					adminMenu();
					System.out.println();
					option = Helper.readInt("Enter option: ");

					if (option == 1) {
						CourseMain.coursePage();
					} else if (option == 2) {
						FeeManagementMain.feeManagementPage();
					} else if (option == 3) {
						// User Management
						UserManagement.userManagementPage();
					} else if (option == 4) {
						StudentManagement.studentManagementPage();
					} else if (option == 5) {
						EnrolementManagementMain.EnrolementPage();
					} else if (option == 6) {
						System.out.println("Thank you for using Tuition Management System.");
					} else {
						System.out.println("Invalid Input!");
					}
				}
				break; // Exit the loop if logged in successfully
			} else {
				attempts++;
				int remainingAttempts = maxAttempts - attempts;
				if (remainingAttempts > 0) {
					System.out.println("Incorrect username or password. Please try again.");
					System.out.println("Remaining attempts: " + remainingAttempts);
				} else {
					System.out.println("Max login attempts reached. Exiting.");
				}
			}
		}
	}

	public static void studentMenu() {
		Helper.line(70, "-");
		System.out.println("******************** STUDENT RESOURCE LIBRARY  ****************************");
		Helper.line(70, "-");

		System.out.println();

		System.out.println("1. Ebook");
		System.out.println("2. Research paper");
		System.out.println("3. Acadamic journals");
		System.out.println("4. Quit");

	} // End of studentMenu method

	private static void studentPage() {
		int maxAttempts = 3;
		int attempts = 0;

		while (attempts < maxAttempts) {
			String username = Helper.readString("Enter Username: ");
			String password = Helper.readString("Enter Password: ");
			System.out.println();
			if (username.equalsIgnoreCase("Alice") && password.equals("1")) {
				int option = 0;
				while (option != 4) {
					studentMenu();
					System.out.println();
					option = Helper.readInt("Enter option: ");

					if (option == 1) {
						// E-book
					} else if (option == 2) {
						// Research paper
					} else if (option == 3) {
						// Academic journals
						UserManagement.userManagementPage();
					} else if (option == 4) {
						System.out.println("Thank you for using Student Resource Library.");
					} else {
						System.out.println("Invalid Input!");
					}
				}
				break; // Exit the loop if logged in successfully
			} else {
				attempts++;
				int remainingAttempts = maxAttempts - attempts;
				if (remainingAttempts > 0) {
					System.out.println("Incorrect username or password. Please try again.");
					System.out.println("Remaining attempts: " + remainingAttempts);
				} else {
					System.out.println("Max login attempts reached. Exiting.");
				}
			}
		}
	}
}