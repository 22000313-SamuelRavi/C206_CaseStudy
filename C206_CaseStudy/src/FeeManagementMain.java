import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FeeManagementMain {
	
	
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;

	public static void feeManagementPage() {
		
	
		
		ArrayList <FeeManagement> studentFeeList = new ArrayList<FeeManagement>();
		
		studentFeeList.add(new FeeManagement(5000, "tuition", LocalDate.of(2023, 9, 8), "22000313"));
		studentFeeList.add(new FeeManagement(3498.75, "exam", LocalDate.of(2023, 10, 15), "22028492"));
		studentFeeList.add(new FeeManagement(1234.89, "exam", LocalDate.of(2023, 11, 07), "22026533"));
		studentFeeList.add(new FeeManagement(5678.23, "tuition", LocalDate.of(2023, 12, 21), "22013820"));
		studentFeeList.add(new FeeManagement(9123.46, "others", LocalDate.of(2024, 01, 10), "22003342"));
		
		int option = 0;
		
		while(option !=OPTION_QUIT ) {
			menu();
			
			System.out.println();
			
			option = Helper.readInt("Enter an option: ");
			
			if(option == OPTION_VIEW) {
				viewAllFees(studentFeeList);
			} else if(option == OPTION_ADD) {
				addFees(studentFeeList);
			} else if(option == OPTION_DELETE) { 
				deleteFee(studentFeeList);
			} else if (option == OPTION_QUIT) {
                System.out.println("Thank you for using Tuition Management System.");
                option = OPTION_QUIT;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
			
		}
		
	} //end of feeManagementPage method
	
	public static void menu() {
		System.out.println();
		
		Helper.line(40, "=");
    	System.out.println("****** WELCOME TO FEE MANAGEMENT *******");
    	Helper.line(40, "=");
    	
    	System.out.println();
    	System.out.println("1. View all Fees");
    	System.out.println("2. Add Fees");
    	System.out.println("3. Delete existing Fees");
    	System.out.println("4. Quit");
    	System.out.println();
	}
	
	
	private static void viewAllFees(ArrayList <FeeManagement> studentFeeList) {
		
		System.out.println();
		Helper.line(64,"=");
		System.out.println("*********************  VIEW ALL FEES  **************************");
		Helper.line(64,"=");
		
		System.out.println();
		
		DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String output = "";
	    
		output = String.format("%-15s %-6s %-15s %-6s\n", "| STUDENT ID ", "| FEE TYPE ", "| DUE DATE ", "| FEE AMOUNT |") +
	                    "-------------------------------------------------------\n";

	    for (FeeManagement f : studentFeeList) {
	        output += "| " + String.format("%-9s", f.getStudentId()) + " | " +
	                String.format("%-9s", f.getFeeType()) + " | " +
	                String.format("%-14s", f.getFeeDueDate().format(formattedDate)) + " | " +
	                "$" + String.format("%-10.2f", f.getFeeAmount()) + " |\n";
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
		
		System.out.println();
		Helper.line(64,"=");
		System.out.println("*********************  ADD A NEW FEE  **************************");
		Helper.line(64,"=");
		
		String inputStudentId = Helper.readString("Enter Student ID: ");
		String inputFeeType = Helper.readString("Enter Fee Type: ");
		LocalDate inputDueDate = readDate(Helper.readString(("Enter due date: (example: 25/02/2023): ")));
		Double inputFeeAmount = Helper.readDouble("Enter Fee Amount: ");
		
		studentFeeList.add(new FeeManagement(inputFeeAmount, inputFeeType, inputDueDate, inputStudentId));
		System.out.println();
		System.out.println("Fee added successfully!");
		
	} //End of addFees method
	
	public static LocalDate readDate(String userInput) {
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);
	    return date;
	  //End of readDate method
	} 
	
	public static void deleteFee(ArrayList<FeeManagement> studentFeeList) {
	    System.out.println();
	    Helper.line(64, "=");
	    System.out.println("********************* DELETE AN EXISTING FEE  ******************");
	    Helper.line(64, "=");

	    String sID = Helper.readString("Enter Student ID : ");

	    ArrayList<FeeManagement> updatedList = new ArrayList<>();
	    boolean feeFound = false;

	    for (FeeManagement fee : studentFeeList) {
	        if (!fee.getStudentId().equals(sID)) {
	            updatedList.add(fee);
	        } else {
	            feeFound = true;
	        }
	    }

	    if (feeFound) {
	        studentFeeList.clear();
	        studentFeeList.addAll(updatedList);
	        System.out.println();
	        System.out.println(sID + "'s fees have been deleted successfully!");
	    } else {
	        System.out.println(sID + " not found.");
	    }
	}

		
		
		
	
	
}
