
public class Student extends StudentList{

	private int age;
	// Add other properties as needed

	public Student(String studentID, String name, int age) {
		super(studentID, name);
		this.age = age;
		// Initialize other properties as needed
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Add other methods as needed

	@Override
	public String toString() {
		String output = super.toString();
		output = String.format("| %-31s | %-15d |", output, age);
		
		return output;
	}

}
