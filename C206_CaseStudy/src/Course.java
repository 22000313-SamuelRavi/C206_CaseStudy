import java.util.List;
import java.util.ArrayList;

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

	public static String showAvailability(boolean isAvailable) 
	{
		String avail;

		if (isAvailable == true) 
		{
			avail = "Yes";
		} 
		else 
		{
			avail = "No";
		}
		return avail;
	}
	
	public void displayCourse() 
	{
		System.out.println("Course Code:"+ courseID);
		System.out.println("Title: "+ title);
		System.out.println("Teacher: "+ teacher);
		System.out.println("Schedule: " + schedule);
	}    
}
