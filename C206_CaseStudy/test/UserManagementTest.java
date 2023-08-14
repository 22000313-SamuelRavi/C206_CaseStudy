import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserManagementTest {
	
	//UserManagementTest
    // Done by Shwetha
    private User user1;
    private User user2;
    private User user3;
    
    private static ArrayList<User> userList;

    @Before
    public void setUp() throws Exception 
    {
		//UserManagementTest
	    // Done by Shwetha
	user1 = new User("sally", "sally123", "STUDENT");
	user2 = new User ("tom", "tom567", "TEACHER");
	user3 = new User ("mario", "mario345", "ADMIN");
	
	 userList = new ArrayList<User>();
	
	}
	//Done by Shwetha
    @Test
    public void testAddUser() 
    {
    	//Boundary condition:
    	// Course list is not null and it is empty
    	assertNotNull("Test if there is valid User arraylist to add to", userList);
    	assertEquals("Test that the User arraylist is empty.", 0, userList.size());
    	
    	
    	//Normal condition:
    	//Given an empty list, after adding 1 item, the size of the list is 1
    	UserManagement.addUser(userList, user1);		
    	assertEquals("Test that the User arraylist size is 1.", 1, userList.size());
    	// Add another item
    	UserManagement.addUser(userList, user2);
    	assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
    	//The item just added is as same as the last item in the list
    	assertSame("Test that User is added to the end of the list.", user2, userList.get(1));
    	
    	
    	//Error condition:
    	// Add an item that already exists in the list
    	UserManagement.addUser(userList, user2);
    	assertEquals("Test that the User arraylist size is unchange.", 3, userList.size());
    }

    @Test
    public void testViewAllUsers() {
    	//Boundary condition:
        assertNotNull("Test if there is a valid User arraylist to retrieve the courses", userList);
        // Test viewing courses when the list is empty
        String emptyOutput = UserManagement.viewAllUsers(userList);
        String expectedEmptyOutput = "";
        assertEquals("Test that viewing all users in an empty userList returns the appropriate message",
                expectedEmptyOutput, emptyOutput);

        
        //Normal condition:
        // Add the courses
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        assertEquals("Test that the User arraylist size is now 3.", 3, userList.size());
        
        // Test viewing all existing courses in the courseList
        String expectedOutput = "";
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user1.getUsername(), user1.getUserType(),
                user1.getPassword());
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user2.getUsername(), user2.getUserType(),
                user2.getPassword());
        expectedOutput += String.format("| %-15s | %-20s | %-25s\n", user3.getUsername(), user3.getUserType(),
                user3.getPassword());
       
        String allUsers = UserManagement.viewAllUsers(userList);
        assertEquals("Test that viewing all users in the userList returns the expected output", expectedOutput, allUsers);
    }


    @Test
    public void testDeleteUser() {
    	
    	//Add the courses 
    	userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        
        // Normal Condition:
        // Delete an existing course
        assertNotNull("Test if there is a valid User arraylist to delete from", userList);
        assertEquals("Test that the User arraylist size is 3.", 3, userList.size());

        boolean isDeleted = UserManagement.deleteUser(userList, user1.getUsername());
        assertTrue("Test that the correct user is deleted", isDeleted);
        assertEquals("Test that the User arraylist size is now 2 after deletion.", 2, userList.size());
        
        assertFalse("Test that the deleted course is no longer in the list", userList.contains(user1));

        
        // Error Condition:
        // Attempt to delete a non-existing course
        
        UserManagement.deleteUser(userList, "billy789"); // Non-existing User
        boolean deleteNo = UserManagement.deleteUser(userList, "billy789");
        assertFalse("Test that non-existing user is not found in the list and not deleted", deleteNo);
        assertEquals("Test that the User arraylist size remains unchanged.", 2, userList.size());

        
        // Boundary Condition: 
        // Delete all courses
        UserManagement.deleteUser(userList, user2.getUsername());
        UserManagement.deleteUser(userList, user3.getUsername());

        assertEquals("Test that the User arraylist is empty after deleting all courses.", 0, userList.size());
    }

    @After
    public void tearDown() throws Exception {
		user1 = null;
	    user2 = null;
	    user3 = null;
	}

    
}
