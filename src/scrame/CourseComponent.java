package scrame;

import java.io.Serializable;

public class CourseComponent implements Serializable{
	private String courseComponentCode;
	private static int courseComponentPercent;
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
	public static int processPercent(String Component) {
		int _percent;
		do {
			try {
				System.out.print("Enter " + Component + "'s percent: ");			
				_percent = GetType.getInt();
				courseComponentPercent=_percent;
				return courseComponentPercent;
			}
			catch (NumberFormatException e) {
				System.out.println("\n  Error: Invalid percent number. Only digits are allowed.\n");
			}
		} while (true);
	}
}