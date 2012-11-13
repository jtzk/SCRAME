package scrame;

import java.util.ArrayList;
import java.util.List;

public class TutorialEx extends CourseComponent{
	private static String courseType;
	public TutorialEx(String _courseComponentCode,String _courseType , int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		courseType=_courseType;
		// TODO Auto-generated constructor stub
	}

	public static int addTutorial(String _courseCode, int balance)
	{
		int remain=0;
		courseType="Tutorial";
		List list = getTutorialEx();
		System.out.println("\nAdding new " +courseType+ " Component");
		System.out.println("--------------------------------------------");	
		int  _percent = processPercent(courseType.toLowerCase());						
		int index=0;
		int storeNo=0;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				TutorialEx tx1 = (TutorialEx)list.get(i);
				if (_courseCode.compareTo(tx1.getCourseComponentCode())==0){
					storeNo=tx1.getIndex();
				}
			}
		}
		index=storeNo+1;

		TutorialEx tx= new TutorialEx(_courseCode,courseType, _percent, index);
		if (list == null) list = new ArrayList();
		int subtotal=_percent+sumUpAll(_courseCode);

		if(balance>0&&subtotal<=100)
		{		
			list.add(tx);
			TutorialEx.save(list);		
			System.out.println(courseType + index + " (" + _percent+ ")" +" added!");
			remain=balance-_percent;
		}
			
		else{
			System.out.println(courseType + index + " (" + _percent+ ")" +" not added! Exceeded balance!");
			remain=-1;
		}

		return remain;
	}
	
	public static List getTutorialEx() {
		return getTutorialExList("tutorialex.dat");
	}
	
	public static List getTutorialExList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static void displayTutorialEx(String _courseCode)
	{
		List list=getTutorialEx();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Tutorial course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					TutorialEx tx = (TutorialEx)list.get(i);
					if(tx.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Tutorial excerise" + tx.getIndex() + " (" + tx.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no tutorial exercises for this " + _courseTitle);
			}

	}
	

	public static void displayTutorialExAll()
	{
		List list=getTutorialEx();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					TutorialEx tx = (TutorialEx)list.get(i);
					System.out.println(tx.getCourseComponentCode() + tx.getIndex() + " (" + tx.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no tutorial exercises");
			}

	}
	
	public static int sumUp(String _courseCode)
	{
		int sum=0;
		List list=getTutorialEx();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				TutorialEx tx = (TutorialEx)list.get(i);
				if(tx.getCourseComponentCode().compareTo(_courseCode)==0)
					sum+=tx.getCourseComponentPercent();
				
			}
		}
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("tutorialex.dat", list);
	}
}