public class User {

    private String userID;
    private String name;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to get the user type as a string
    public String getUserType() {
        return "User";
    }

    // Method to get user details as a string
    public String getUserDetails() {
        return "";
    }
}
