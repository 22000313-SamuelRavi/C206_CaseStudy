//Created by Kendrick
public class ResourceLibrary extends StudentList{
	private String title;
	private String type;

	public ResourceLibrary(String studentID, String name, String title, String type) {
		super(studentID, name);
		this.title = title;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
