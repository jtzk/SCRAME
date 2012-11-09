package scrame;

public class CourseComponent {
	private String CourseComponentTitle;
	private int CourseComponentMark;
	private int CourseComponentPercent;
	
	public CourseComponent(String CourseComponentTitle,int CourseComponentMark , int CourseComponentPercent)
	{
		this.CourseComponentTitle=CourseComponentTitle;
		this.CourseComponentMark=CourseComponentMark;
		this.CourseComponentPercent=CourseComponentPercent;		
	}

	public String getCourseComponentTitle()
	{
		return CourseComponentTitle;
	}
	
	public int getCourseComponentMark()
	{
		return CourseComponentMark;
	}
	
	public int getCourseComponentPercent()
	{
		return CourseComponentPercent;
	}
	
	public int setCalculateScore()
	{	
		return CourseComponentPercent*CourseComponentMark;
	}
	
}
