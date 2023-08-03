public class Teacher {
    private String teacherID;
    private String name;
    private String specialization;
    // Add other properties as needed

    public Teacher(String teacherID, String name, String specialization) {
        this.teacherID = teacherID;
        this.name = name;
        this.specialization = specialization;
        // Initialize other properties as needed
    }

    // Getters and setters for teacherID, name, specialization, and other properties (if needed)

    // Add other methods as needed

    @Override
    public String toString() {
        return "Teacher ID: " + teacherID + ", Name: " + name + ", Specialization: " + specialization;
    }
}
