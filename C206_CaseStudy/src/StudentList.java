// created by kendrick
public class StudentList {
	private String studentID;
	private String name;

	public StudentList(String studentID, String name) {
		this.studentID = studentID;
		this.name = name;

	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void displayStudentInfo() {
		System.out.println(String.format("%-10s: %s ", "Student ID", studentID));
		System.out.println(String.format("%-10s: %s ", "Name", name));
	}

	public String toString() {

		// Write your codes here
		String studentInfo = String.format("%-15s | %-15s", studentID, name);
		return studentInfo;
	}

}
