// Created by Team 5
// Admin page updates by khin
public class C206_CaseStudy {
	
	public static void main(String[] args){
		
		Helper.line(70,"=");
		System.out.println("******************** TUITION MANAGEMENT SYSTEM  **********************");
		Helper.line(70,"=");
		
		System.out.println();
		Helper.line(23, "-");
		System.out.println("✰ What user are you? ✰");
		Helper.line(23, "-");
		
	    System.out.println("1. Administrator");
	    System.out.println("2. Student");
	    System.out.println("3. Teacher");
		
	    System.out.println();
	    int user = Helper.readInt("» Enter an option: ");
		
		if(user == 1) {
			adminPage();
		} else if(user == 2) {
			
			System.out.println();
			System.out.println("The Student menu is underdeveloped at the moment!");
			
		} else if(user == 3) {
			
			System.out.println();
			System.out.println("The Teacher menu is underdeveloped at the moment!");
			
		} else {
			System.out.println();
			System.out.println("Invalid input");
		}
	} //End of main method
	
	public static void adminMenu() {
		Helper.line(70,"-");
		System.out.println("******************** MANAGEMENT SERVICES  ****************************");
		Helper.line(70,"-");
		
		System.out.println();
		
		System.out.println("1. Course Management");
		System.out.println("2. Fee Management");
		System.out.println("3. User Management");
		System.out.println("4. Student Management");
		System.out.println("5. Reports (NOT WORKING!)");
		System.out.println("6. Quit");
	} //End of adminMenu method
	
	private static void adminPage() {
		
		System.out.println();
		String username = Helper.readString("✎ Enter Username: ");
		String password = Helper.readString("✎ Enter Password: ");
		System.out.println();
			// Create for loop to check if correct
			if(username.equals("bob") && password.equals("1")) {

				int option = 0;
				while(option != 6) {
					adminMenu();
					
					System.out.println();
					
					option = Helper.readInt("» Enter option: ");
					
					if(option == 1) {
		
						CourseMain.coursePage();
						
					} else if(option == 2) {
						
						FeeManagementMain.feeManagementPage();
						
					} else if(option == 3) {
						
						UserManagement.userManagementPage();
						
					} else if(option == 4) {
						
						StudentManagement.studentManagementPage();
						
					} else if(option == 5) {
						
						System.out.println();
						System.out.println("Reports are unable to be generated at the moment! ☹");
						
					} else if (option == 6) {
						
						System.out.println();
						System.out.println("Thank you for using our services! 😃");
						
					} else {
						
						System.out.println("Invalid Input!");
					}
				}
			}
	} //End of adminPage method
}