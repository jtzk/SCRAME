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
		System.out.println("-------------------------");	
		int  _percent = processPercent(courseType);						
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
		System.out.println("\n "+_courseCode +" "+ courseType +" "+ _percent+" " +index);
		Assignment ass1= new Assignment(_courseCode,courseType, _percent, index);
			if (list == null) list = new ArrayList();
			
			int subtotal=_percent+sumUp(_courseCode);
			//System.out.println("subtotal"+subtotal);
			if(balance>0&&subtotal<=100)
			{		
				list.add(ass1);
				Assignment.save(list);		
				System.out.println("\n "+ass1.getCourseComponentCode() + ass1.getCourseComponentPercent() + ass1.getIndex() +" added!");
				displayAssignmentAll();
				remain=balance-sumUp(_courseCode);
			}
			//else if(remain==0)
			//	System.out.println("Course component ("+_courseCode+ ")"+" is done");
			else{
				System.out.println("\n "+ass1.getCourseComponentCode() + ass1.getCourseComponentPercent() + ass1.getIndex() +" not added! Exceeded balance");
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
	
	public static void displayAssigment(String _courseCode)
	{
		List list=getAssignment();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Tutorial course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Assignment ass = (Assignment)list.get(i);
					if(ass.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Tutorial excerise" + ass.getIndex() + " (" + ass.getCourseComponentPercent()+ ")");
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
		//System.out.println("\nsum"+sum);
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("assignment.dat", list);
	}
}
