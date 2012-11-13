package scrame;

import java.util.ArrayList;
import java.util.List;

public class Assignment extends CourseComponent{
	private static String courseType;
	public Assignment(String _courseComponentCode,String _courseType , int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		courseType=_courseType;
		// TODO Auto-generated constructor stub
	}

	public static int addAssignment(String _courseCode, int balance)
	{
		int remain=0;
		courseType="assignment";
		List list = getAssignment();
		System.out.println("\nAdding new " +courseType+ " Component");
		System.out.println("--------------------------------------------");	
		int  _percent = processPercent(courseType.toLowerCase());						
		int index=0;
		int storeNo=0;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Assignment ass = (Assignment)list.get(i);
				if (_courseCode.compareTo(ass.getCourseComponentCode())==0){
					storeNo=ass.getIndex();
				}
			}
		}
		index=storeNo+1;

		Assignment ass1= new Assignment(_courseCode,courseType, _percent, index);
		if (list == null) list = new ArrayList();	
		int subtotal=_percent+sumUpAll(_courseCode);

		if(balance>0&&subtotal<=100)
		{		
			list.add(ass1);
			Assignment.save(list);		
			System.out.println(courseType + index + " (" + _percent+ ")" +" added!");
			remain=balance-_percent;
		}
		
		else{
			System.out.println(courseType + index + " (" + _percent+ ")" +" not added! Exceeded balance!");
			remain=-1;
		}

		return remain;
	}
	
	public static List getAssignment() {
		return getAssignmentList("assignment.dat");
	}
	
	public static List getAssignmentList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static int getPercent(String _courseCode) {
		List list = getAssignment();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Assignment ass = (Assignment) list.get(i);
				if (ass.getCourseComponentCode().equals(_courseCode)) {
					return ass.getCourseComponentPercent();
				}
			}
		}
		return 0;
	}
	
	public static void displayAssignment(String _courseCode)
	{
		List list=getAssignment();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Assignment course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Assignment ass = (Assignment)list.get(i);
					if(ass.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Assignment" + ass.getIndex() + " (" + ass.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no assignments for this " + _courseTitle);
			}

	}
	
	public static void displayAssignmentAll()
	{
		List list=getAssignment();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Assignment ass = (Assignment)list.get(i);
					System.out.println(ass.getCourseComponentCode() + ass.getIndex() + " (" + ass.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no assignments");
			}

	}
	
	public static int sumUp(String _courseCode)
	{
		int sum=0;
		List list=getAssignment();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Assignment ass = (Assignment)list.get(i);
				if(ass.getCourseComponentCode().compareTo(_courseCode)==0)
					sum+=ass.getCourseComponentPercent();
				
			}
		}
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("assignment.dat", list);
	}
}