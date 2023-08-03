// Created by Samuel
public class C206_CaseStudy {
	
	public static void main(String[] args){
		
		String username = Helper.readString("Enter Username: ");
		String password = Helper.readString("Enter Password: ");
		
		// Create for loop
		if(username == "bob" && password == "1") {
			
			
			
			int option = Helper.readInt("Enter optoion: ");
			
			if(option == 1) {
				
				adminMenu();
				
			}
			
		}
		
	}
	
	public static void adminMenu() {
		System.out.println("1. Courses: ");
	}
	
}