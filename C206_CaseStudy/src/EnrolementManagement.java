
public class EnrolementManagement {
	
	private String studentId;
	private String course;
	private double gpa;
	
	public EnrolementManagement(String studentId, String course, double gpa) {
		this.studentId = studentId;
		this.course = course;
		this.gpa = gpa;
	}
	public String getStudentId() {
		return studentId;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getGpa() {
		return gpa;
	}
	public void setStudentPerformance(double gpa) {
		this.gpa = gpa;
	}
	
}
