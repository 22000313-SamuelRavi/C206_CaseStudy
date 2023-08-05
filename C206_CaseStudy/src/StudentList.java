
public class StudentList {
	private String studentID;
	private String name;

	public StudentList(String studentID, String name) {
		this.studentID = studentID;
		this.name = name;

	}

	public String toString() {

		// Write your codes here
		String studentInfo = String.format("%-15s %-15s", studentID, name);
		return studentInfo;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

}
