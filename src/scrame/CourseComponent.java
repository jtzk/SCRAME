package scrame;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class CourseComponent implements Serializable{
	private String courseComponentCode;
	private int courseComponentPercent;
	private int index;
	
	public CourseComponent(String _courseComponentCode, int _courseComponentPercent, int _index)
	{
		courseComponentCode=_courseComponentCode;
		courseComponentPercent=_courseComponentPercent;	
		index=_index;
	}

	public String getCourseComponentCode()
	{
		return courseComponentCode;
	}
	
	public int getCourseComponentPercent()
	{
		return courseComponentPercent;
	}
	
	public int getIndex()
	{
		return index;
	}
	
//	
//	public int setCalculateScore()
//	{	
//		return courseComponentPercent*courseComponentMark;
//	}
//	
//	public static int processMark(String Component) {
//		int _mark;
//		do {
//			try {
//				System.out.print("Enter " + Component + "'s mark: ");			
//				_mark = GetType.getInt();
//				courseComponentMark=_mark;
//				return courseComponentMark;
//			}
//			catch (NumberFormatException e) {
//				System.out.println("\n  Error: Invalid mark number. Only digits are allowed.\n");
//			}
//		} while (true);
//	}
//	
	
	// Prompts for and gets input for course
	public static String processCourseCode(String component) {
		String _courseCode;
		List list = Course.getCourseList();
		Collections.sort(list);
		do {
			System.out.print("\nEnter " + component + "courseCode");			
			_courseCode = GetType.getString();
			String storeCourseTitle=Course.SearchCourse(_courseCode);
			if(storeCourseTitle!=null){
				System.out.println(storeCourseTitle + " (" + _courseCode + ") is found");
				return _courseCode;
			}
			else
				System.out.println("There is no such course.");
		} while (true);
	}
	
	public static int processPercent(String component) {
		int _percent;
		do {
			try {
				System.out.print("Enter " + component + "'s percent: ");			
				_percent = GetType.getInt();
				
				return _percent;
			}
			catch (NumberFormatException e) {
				System.out.println("\n  Error: Invalid percent number. Only digits are allowed.\n");
			}
		} while (true);
	}
	
	public static int sumUpAll(String _courseCode)
	{
		int sumUpAll=0;
		sumUpAll=Exam.sumUp(_courseCode)+Report.sumUp(_courseCode)+Quiz.sumUp(_courseCode)+Assignment.sumUp(_courseCode)+TutorialEx.sumUp(_courseCode);
		return sumUpAll;
	} 
}
