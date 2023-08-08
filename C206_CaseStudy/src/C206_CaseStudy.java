// Created by Priya
// adminPage method updated by Khin

public class C206_CaseStudy 
{
	
	public static void main(String[] args)
	{
		
		Helper.line(70,"=");
		System.out.println("******************** TUITION MANAGEMENT SYSTEM  **********************");
		Helper.line(70,"=");
		
		System.out.println();
		
		String user = Helper.readString("What user are you? (Student, Teacher, Admin): ");
		
		if(user.equalsIgnoreCase("admin")) 
		{
			adminPage();
		} 
		else if(user.equalsIgnoreCase("student")) 
		{
			System.out.println("The Student menu is underdeveloped at the moment!");
			
		} 
		else if(user.equalsIgnoreCase("teacher")) 
		{
			System.out.println("The Teacher menu is underdeveloped at the moment!");
		} 
		else 
		{
			System.out.println("Invalid input");
		}
	} //End of main method
	
	public static void adminMenu() 
	{
		Helper.line(70,"-");
		System.out.println("******************** MANAGEMENT SERVICES  ****************************");
		Helper.line(70,"-");
		
		System.out.println();
		
		System.out.println("1. Course Management");
		System.out.println("2. Fee Management");
		System.out.println("3. User Management");
		System.out.println("4. Student Management");
		System.out.println("5. Enrolment Management");
		System.out.println("6. Quit");
	} //End of adminMenu method
	
	private static void adminPage() 
	{
	    int maxAttempts = 3;
	    int attempts = 0;
	    
	    while (attempts < maxAttempts) 
	    {
	        String username = Helper.readString("Enter Username: ");
	        String password = Helper.readString("Enter Password: ");
	        System.out.println();

	        if (username.equalsIgnoreCase("bob") && password.equals("1")) 
	        {
	            int option = 0;
	            while (option != 6) 
	            {
	                adminMenu();
	                System.out.println();
	                option = Helper.readInt("Enter option: ");

	                if (option == 1) 
	                {
	                    CourseMain.coursePage();
	                } 
	                else if (option == 2) 
	                {
	                    FeeManagementMain.feeManagementPage();
	                } 
	                else if (option == 3) 
	                {
	                    // User Management
	                    // Add functionality here
	                } 
	                else if (option == 4) 
	                {
	                    StudentManagement.studentManagementPage();
	                } 
	                else if (option == 5) 
	                {
	                    // Enrolment Management
	                    // Add functionality here
	                } 
	                else if (option == 6) 
	                {
	                    System.out.println("Thank you for using Tuition Management System.");
	                } 
	                else 
	                {
	                    System.out.println("Invalid Input!");
	                }
	            }
	            break; // Exit the loop if logged in successfully
	        } 
	        else 
	        {
	            attempts++;
	            int remainingAttempts = maxAttempts - attempts;
	            if (remainingAttempts > 0) 
	            {
	                System.out.println("Incorrect username or password. Please try again.");
	                System.out.println("Remaining attempts: " + remainingAttempts);
	            } 
	            else 
	            {
	                System.out.println("Max login attempts reached. Exiting.");
	            }
	        }
	    }
	}
}