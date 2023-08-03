import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FeeManagementMain {

	public static void feeManagementPage() {
		
		ArrayList <FeeManagement> studentFeeList = new ArrayList<FeeManagement>();
		
		studentFeeList.add(new FeeManagement(5000, "tuition", LocalDate.of(2023, 9, 8), "22000313"));
		studentFeeList.add(new FeeManagement(3498.75, "exam", LocalDate.of(2023, 10, 15), "22028492"));
		studentFeeList.add(new FeeManagement(1234.89, "exam", LocalDate.of(2023, 11, 07), "22026533"));
		studentFeeList.add(new FeeManagement(5678.23, "tuition", LocalDate.of(2023, 12, 21), "22013820"));
		studentFeeList.add(new FeeManagement(9123.46, "others", LocalDate.of(2024, 01, 10), "22003342"));
		
		int option = 0;
		
		while(option != 5) {
			menu();
			option = Helper.readInt("Enter option: ");
			
			if(option == 1) {
				viewAllFees(studentFeeList);
			} else if(option == 2) {
				addFees(studentFeeList);
			}
		}
		
	} //end of feeManagementPage method
	
	public static void menu() {
		Helper.line(40, "=");
    	System.out.println("*** WELCOME TO FEE MANAGEMENT ***");
    	Helper.line(40, "=");
    	
    	System.out.println("1. View all Fees");
    	System.out.println("2. Add Fees");
    	System.out.println("3. Edit existing Fees");
    	System.out.println("4. Delete exisisting Fees");
    	System.out.println("5. Quit");
	}
	
	private static void viewAllFees(ArrayList <FeeManagement> studentFeeList) {
		
		DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String output = String.format("%-15s %-15s %-15s %s\n", "STUDENT ID", "FEE TYPE", "DUE DATE", "FEE AMOUNT");
		for(FeeManagement f : studentFeeList) {
			output += String.format("%-15s %-15s %-15s %-15f\n", f.getStudentId(), f.getFeeType(), f.getFeeDueDate().format(formattedDate), f.getFeeAmount());
		}
		
		System.out.println(output);
		
		String filterOption = Helper.readString("Do you want to filter? (yes/no): ");
		
		if(filterOption.equalsIgnoreCase("yes")) {
			String filterStudentId = Helper.readString("Enter Student ID: ");
		
			output = "Invalid Student Id";
		
			for(FeeManagement f : studentFeeList) {
				if(f.getStudentId().equals(filterStudentId)) {
					output = String.format("%-15s %-15s %-15s %s\n", "STUDENT ID", "FEE TYPE", "DUE DATE", "FEE AMOUNT");
					output += String.format("%-15s %-15s %-15s %-15f\n", f.getStudentId(), f.getFeeType(), f.getFeeDueDate().format(formattedDate), f.getFeeAmount());
					break;
				}
				
				System.out.println(output);
				break;
			}		
			
		}
		
	} //End of viewAllFees method
	
	private static void addFees(ArrayList <FeeManagement> studentFeeList) {
		
		String inputStudentId = Helper.readString("Enter Student ID: ");
		String inputFeeType = Helper.readString("Enter Fee Type: ");
		LocalDate inputDueDate = readDate(Helper.readString(("Enter due date: (example: 25/02/2023): ")));
		Double inputFeeAmount = Helper.readDouble("Enter Fee Amount: ");
		
		studentFeeList.add(new FeeManagement(inputFeeAmount, inputFeeType, inputDueDate, inputStudentId));
		
	} //End of addFees method
	
	public static LocalDate readDate(String userInput) {
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);
	    return date;
	} //End of readDate method
}
