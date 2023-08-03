
public class Student {
	
    private String studentID;
    private String name;
    private int age;
    // Add other properties as needed

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        // Initialize other properties as needed
    }

    // Getters and setters for studentID, name, age, and other properties (if needed)

    // Add other methods as needed

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age;
    }
}
