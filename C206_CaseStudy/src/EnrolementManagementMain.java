//Completed by Samuel

import java.util.*;
import java.util.regex.Pattern;


public class EnrolementManagementMain {

	private static final String idCheck = "22\\d{6}";
	
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	
	public static void EnrolementPage() {
		ArrayList<EnrolementManagement> enrolementList = new ArrayList<EnrolementManagement>();
		
		enrolementList.add(new EnrolementManagement("22000313", "C206", 3.7));
		enrolementList.add(new EnrolementManagement("22028492", "C209", 3.1));
		enrolementList.add(new EnrolementManagement("22026533", "C236", 3.9));
		enrolementList.add(new EnrolementManagement("22013820", "C328", 3.5));
		enrolementList.add(new EnrolementManagement("22003342", "C327", 3.8));
		
		int option = 0;
		while(option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter option> ");
			
			if(option == OPTION_VIEW) {
				System.out.println(viewEnrol(enrolementList));
			} else if(option == OPTION_ADD) {
				EnrolementManagement newEnrol = inputEnrol(enrolementList);
				addEnrol(enrolementList, newEnrol);
			} else if(option == OPTION_DELETE) {
				Helper.line(50, "=");
				System.out.println("DELETE EXISTING ENROLEMENT");
				Helper.line(50, "=");
				String studentId = Helper.readString("Enter Student ID To Delete: ");
				deleteEnrol(enrolementList, studentId);
			} else if(option == OPTION_QUIT) {
				System.out.println("Bye Bye!");
			} else {
				System.out.println("Invalid Input!");
			}
		}

	} //End of EnrolementPage method
	
	private static void menu() {
		Helper.line(50, "=");
		System.out.println("ENROLEMENT MANAGEMENT");
		Helper.line(50, "=");
		
		System.out.println("1. View All Enrolements");
		System.out.println("2. Add New Enrolement");
		System.out.println("3. Delete Existing Enrolement");
		System.out.println("4. Quit");
	} //End of menu method

	public static String viewEnrol(ArrayList<EnrolementManagement> enrolementList) {
		Helper.line(50, "=");
		System.out.println("VIEW ALL ENROLEMENT");
		Helper.line(50, "=");
		
		String output = String.format("| %-12s | %-8s | %s |\n", "Student ID", "Course", "GPA");
		
		for(EnrolementManagement e: enrolementList) {
			output += String.format("| %-12s | %-8s | %.1f |\n", e.getStudentId(), e.getCourse(), e.getGpa());
		}
		
		return output;
	} //End of viewEnrol method
	
	// =========== ADDING NEW ENROLLMENT ==========
	
	public static void addEnrol(ArrayList<EnrolementManagement> enrolementList, EnrolementManagement newEnrol) {
		
		boolean enrolExists = false;
	    
	    // Check if the course with the same courseID already exists
	    for (EnrolementManagement existingEnrol : enrolementList) 
	    {
	        if (existingEnrol.getStudentId().equalsIgnoreCase(newEnrol.getStudentId())) 
	        {
	        	enrolExists = true;
	            break;
	        }
	    }
	    
	    if (enrolExists) 
	    {
	        System.out.println("An enrollment with the same student ID already exists in the list.");
	        System.out.println("Please enter a new enrollment.");
	        
	    } 
	    else 
	    {
	        enrolementList.add(newEnrol);
	        System.out.println("Enrollment successfully added!");
	    }
		
	} //End of addEnrol method
	
	private static EnrolementManagement inputEnrol(ArrayList<EnrolementManagement> enrolementList) {
		Helper.line(50, "=");
		System.out.println("ADD NEW ENROLEMENT");
		Helper.line(50, "=");

		boolean added = false;
		while(added == false) {
			String studentId = Helper.readString("Enter Student ID: ");
			if(Pattern.matches(idCheck, studentId)) {
				boolean alreadyEnrolled = false;
				for(EnrolementManagement e: enrolementList) {
					if(e.getStudentId().equals(studentId)) {	
						System.out.println("Student already Enrolled!");
						alreadyEnrolled = true;
					}
				}
				if(alreadyEnrolled == false) {
					String course = Helper.readString("Enter Student's Course: ");
					added = true;
					return (new EnrolementManagement(studentId, course, 0));
				}
			} else {
				System.out.println("Student ID Not Valid!");
			}
		}
		
		return null;
		
	} //End of inputEnrol method
	
	// ==================== DELETE ENROLLMENT ====================
	
	public static boolean deleteEnrol(ArrayList<EnrolementManagement> enrolementList, String studentId) {
		
		boolean deleted = false;
		while(deleted == false) {
			if(Pattern.matches(idCheck, studentId)) {
				boolean studentFound = false;
				for(EnrolementManagement e: enrolementList) {
					if(e.getStudentId().equals(studentId)) {
						String confirm = Helper.readString("Confirm Delete Enrollment " + studentId + "? (y/n): ");
						if(confirm.equalsIgnoreCase("y")) {
							enrolementList.remove(e);
							System.out.println("Student Enrolement Deleted");
							deleted = true;
						} else if(confirm.equalsIgnoreCase("n")){
							System.out.println("Student Enrolement Not Deleted");
							deleted = true;
						} else {
							System.out.println("Invalid Input!");
						}
						studentFound = true;
						break;
					}
				}
				if(studentFound == false){
					System.out.println("Student Does Not Exist!");
					break;
				}
			} else {
				System.out.println("Student ID Not Valid!");
				break;
			}
		}
		return deleted;
	} //End of deleteEnrol method
	
	
}
