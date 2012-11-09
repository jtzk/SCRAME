package scrame;

public class Quiz extends CourseComponent{

	public Quiz(String CourseComponentTitle, int CourseComponentMark,
			int CoursePercent) {
		super(CourseComponentTitle, CourseComponentMark, CoursePercent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int setCalculateScore()
	{	
		return super.getCourseComponentPercent()*super.getCourseComponentMark();
	}
}
