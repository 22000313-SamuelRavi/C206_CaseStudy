//Completed by Samuel

import java.util.*;
import java.util.regex.Pattern;


public class EnrolementManagementMain {

	private static final String idCheck = "22\\d{6}";
	
	public static void EnrolementPage() {
		ArrayList<EnrolementManagement> enrolementList = new ArrayList<EnrolementManagement>();
		
		enrolementList.add(new EnrolementManagement("22000313", "C206", 3.7));
		enrolementList.add(new EnrolementManagement("22028492", "C209", 3.1));
		enrolementList.add(new EnrolementManagement("22026533", "C236", 3.9));
		enrolementList.add(new EnrolementManagement("22013820", "C328", 3.5));
		enrolementList.add(new EnrolementManagement("22003342", "C327", 3.8));
		
		int option = 0;
		while(option != 4) {
			menu();
			option = Helper.readInt("Enter option> ");
			
			if(option == 1) {
				viewEnrol(enrolementList);
			} else if(option == 2) {
				addEnrol(enrolementList);
			} else if(option == 3) {
				deleteEnrol(enrolementList);
			} else if(option == 4) {
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

	private static void viewEnrol(ArrayList<EnrolementManagement> enrolementList) {
		Helper.line(50, "=");
		System.out.println("VIEW ALL ENROLEMENT");
		Helper.line(50, "=");
		
		String output = String.format("| %-12s | %-8s | %s |\n", "Student ID", "Course", "GPA");
		
		for(EnrolementManagement e: enrolementList) {
			output += String.format("| %-12s | %-8s | %.1f |\n", e.getStudentId(), e.getCourse(), e.getGpa());
		}
		
		System.out.println(output);
	} //End of viewEnrol method
	
	private static void addEnrol(ArrayList<EnrolementManagement> enrolementList) {
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

					enrolementList.add(new EnrolementManagement(studentId, course, 0));
					System.out.println("Student Enrolled");
					added = true;
				}
			} else {
				System.out.println("Student ID Not Valid!");
			}
		}
		
	} //End of addEnrol method
	
	private static void deleteEnrol(ArrayList<EnrolementManagement> enrolementList) {
		Helper.line(50, "=");
		System.out.println("DELETE EXISTING ENROLEMENT");
		Helper.line(50, "=");
		
		boolean deleted = false;
		while(deleted == false) {
			String studentId = Helper.readString("Enter Student ID: ");
			if(Pattern.matches(idCheck, studentId)) {
				boolean studentFound = false;
				for(EnrolementManagement e: enrolementList) {
					if(e.getStudentId().equals(studentId)) {
						String confirm = Helper.readString("Confirm Delete Student " + studentId + "? (y/n): ");
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
			}
		}
	} //End of deleteEnrol method
	
	
}
