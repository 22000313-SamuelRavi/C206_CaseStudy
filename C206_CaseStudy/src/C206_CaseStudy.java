// Created by Samuel
public class C206_CaseStudy {
	
	public static void main(String[] args){
		
		String user = Helper.readString("What user are you? (Student, Teacher, Admin): ");
		
		if(user.equalsIgnoreCase("admin")) {
			adminPage();
		} 
	} //End of main method
	
	public static void adminMenu() {
		System.out.println("1. Course Management");
		System.out.println("2. Fee Management");
		System.out.println("3. User Management");
		System.out.println("4. Student Management");
		System.out.println("5. Reports (NOT WORKING!)");
		System.out.println("6. Quit");
	} //End of adminMenu method
	
	private static void adminPage() {
		String username = Helper.readString("Enter Username: ");
		String password = Helper.readString("Enter Password: ");
		
			// Create for loop to check if correct
			if(username.equals("bob") && password.equals("1")) {

				int option = 0;
				while(option != 6) {
					adminMenu();
					option = Helper.readInt("Enter optoion: ");
					
					if(option == 1) {
		
						CourseMain.coursePage();
						
					} else if(option == 2) {
						
						FeeManagementMain.feeManagementPage();
						
					} else if(option == 3) {
						
					} else if(option == 4) {
						
					} else if(option == 5) {
						
					} else if (option == 6) {
						System.out.println("BYE BYE!");
					} else {
						System.out.println("Invalid Input!");
					}
				}
			}
	} //End of adminPage method
}