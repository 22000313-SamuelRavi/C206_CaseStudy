//Created by Kendrick
public class Student extends StudentList {

	private int age;

	public Student(String studentID, String name, int age) {
		super(studentID, name);
		this.age = age;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void display() {
		super.displayStudentInfo();
		System.out.println(String.format("%-10s: %d ","Age", age));
	}
	// Add other methods as needed

	@Override
	public String toString() {
		String output = super.toString();
		output = String.format("| %-31s | %-15d |", output, age);

		return output;
	}

}
////
