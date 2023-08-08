

/**
 * 
 */

/**
 * @author 22003342
 *
 */
public class Course 
{
	private String courseID;
	private String title;
	private String schedule;
	private String teacher;
	
	public Course(String courseID, String title, String teacher, String schedule) 
	{
		this.courseID = courseID;
		this.title = title;
		this.teacher = teacher;
		this.schedule = schedule;
	}
	
	public String getCourseID() 
	{
		return courseID;
	}

	public void setCourseID(String courseID) 
	{
		this.courseID = courseID;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTeacher() 
	{
		return teacher;
	}

	public void setTeacher(String teacher) 
	{
		this.teacher = teacher;
	}

	public String getSchedule() 
	{
		return schedule;
	}

	public void setSchedule(String schedule) 
	{
		this.schedule = schedule;
	}
	
	public String toString()
	{
		String output = "";
		// Write your codes here
		return output;
	}
}
