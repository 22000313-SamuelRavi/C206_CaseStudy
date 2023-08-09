// created by priya
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
     
      
      option = Helper.readInt("Enter an option: ");
      
      
      
      if(option == OPTION_VIEW) {
        
        viewAllFees(studentFeeList);
        
      } 
      
     else if(option == OPTION_ADD) {
    	
    //header 	  
       System.out.println();
       Helper.line(64,"=");
       System.out.println("*********************  ADD A NEW FEE  **************************");
       Helper.line(64,"=");
        
     //adding fees
       FeeManagement f = inputFees();
       FeeManagementMain.addFees(studentFeeList,f);
           System.out.println();
           System.out.println("Fee added successfully!");
      
 
      } 
      
     else if(option == OPTION_DELETE) { 
        
     //header
        System.out.println();
        Helper.line(64, "=");
        System.out.println("********************* DELETE AN EXISTING FEE  ******************");
        Helper.line(64, "=");
          
        System.out.println();
        
        String deleteThisFee  = Helper.readString("Enter the Student ID to delete fees> ");
        
        if (deleteFee(studentFeeList, deleteThisFee)) {
        	
            System.out.println("Fee deleted successfully!");
            
        } else {
        	
            System.out.println("Fee not deleted. Student ID not found.");
        }
        
      } 
      
      else if (option == OPTION_QUIT) {
        
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
      System.out.println("↠↠↠↠↠↠ WELCOME TO FEE MANAGEMENT ↞↞↞↞↞↞");
      Helper.line(40, "=");
      
      System.out.println();
      System.out.println("1. View all Fees");
      System.out.println("2. Add Fees");
      System.out.println("3. Delete existing Fees");
      System.out.println("4. Quit");
      System.out.println();
  }
  
  //--------------------------------------------- method to view fees ----------------------------------------------------------------
  
  public static String viewAllFees(ArrayList<FeeManagement> studentFeeList) {
	    System.out.println();
	    Helper.line(64, "=");
	    System.out.println("*********************  VIEW ALL FEES  **************************");
	    Helper.line(64, "=");
	    System.out.println();

	    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    System.out.println(String.format("| %-13s | %-9s | %-15s | %-7s | ", "STUDENT ID", "FEE TYPE", "DUE DATE", "AMOUNT"));
	    Helper.line(57, "-");

	    for (FeeManagement f : studentFeeList) {
	        System.out.printf("| %-13s | %-9s | %-15s | %-7.2f |\n",
	                f.getStudentId(), f.getFeeType(), f.getFeeDueDate().format(formattedDate), f.getFeeAmount());
	    }
		return null;
	} 
  //--------------------------------------------- Method to add fees ----------------------------------------------------------------------
  
  
  public static void addFees(ArrayList <FeeManagement> studentFeeList, FeeManagement f ){
	    
	  FeeManagement fm;

      for (int i = 0; i < studentFeeList.size(); i++) {
          fm = studentFeeList.get(i);

          if (fm.getStudentId().equalsIgnoreCase(f.getStudentId())) {
              return;
          }
          
          
          
      
      studentFeeList.add(f);
   
  }
  }
    public static FeeManagement inputFees() {
    
      String inputStudentId = Helper.readString("Enter Student ID: ");
      String inputFeeType = Helper.readString("Enter Fee Type: ");
      LocalDate inputDueDate = readDate(Helper.readString(("Enter due date: (example: 25/02/2023): ")));
      Double inputFeeAmount = Helper.readDouble("Enter Fee Amount: ");
      
      
      
      return new FeeManagement(inputFeeAmount, inputFeeType, inputDueDate, inputStudentId);
      
    }
    
  //------------------------------------------- checking date format --------------------------------------------------------------------------
  public static LocalDate readDate(String userInput) {
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate date = LocalDate.parse(userInput, dateFormat);
      return date;
   
  } 
  
  // --------------------------------------- Method to delete fees ----------------------------------------------------------------------------
  
  public static boolean deleteFee(ArrayList<FeeManagement> studentFeeList, String deleteThisFee) {
	  
      for (int i = 0; i < studentFeeList.size(); i++) {
    	  
          if (studentFeeList.get(i).getStudentId().equalsIgnoreCase(deleteThisFee)) {
        	  
              String confirm = Helper.readString("Delete this Student's Fee? (Y/N) > ");
              
              if (confirm.equalsIgnoreCase("Y")) {
            	  
                  studentFeeList.remove(i);
                  System.out.println("Student, " + deleteThisFee + "'s fee has been deleted successfully!");
                  return true;
                  
              } else if (confirm.equalsIgnoreCase("N")) {
            	  
                  System.out.println("Student, " + deleteThisFee + "'s fee deletion failed.");
                  return true;
                  
              } else {
                  System.out.println("Invalid input. Please try again with 'Y' or 'N' !");
              }
          }
      }
      return false;
  }
 
}
