package scrame;

public class Exam extends CourseComponent {
	public Exam(String CourseComponentTitle, int CourseComponentMark,
			int CourseComponentPercent) {
		super(CourseComponentTitle, CourseComponentMark, CourseComponentPercent);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public int setCalculateScore()
	{	
		return super.getCourseComponentPercent()*super.getCourseComponentMark();
	}
}
