package scrame;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends CourseComponent{
	private static String courseType;
	public Quiz(String _courseComponentCode,String _courseType , int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		courseType=_courseType;
		// TODO Auto-generated constructor stub
	}

	public static int addQuiz(String _courseCode, int balance)
	{
		int remain=0;
		courseType="quiz";
		List list = getQuiz();
		System.out.println("\nAdding new " +courseType+ " Component");
		System.out.println("-------------------------");	
		int  _percent = processPercent(courseType);						
		int index=0;
		int storeNo=0;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Quiz qz = (Quiz)list.get(i);
				if (_courseCode.compareTo(qz.getCourseComponentCode())==0){
					storeNo=qz.getIndex();
				}
			}
		}
		index=storeNo+1;
		
		Quiz qz1= new Quiz(_courseCode,courseType, _percent, index);
		if (list == null) list = new ArrayList();
		int subtotal=_percent+sumUp(_courseCode);
		
		if(balance>0&&subtotal<=100)
		{		
			list.add(qz1);
			Quiz.save(list);		
			System.out.println(courseType + index + " (" + _percent+ ")" +" added!");
			remain=balance-_percent;
		}
		
		else{
			System.out.println(courseType + index + " (" + _percent+ ")" +" not added! Exceeded balance!");
			remain=-1;
		}

		return remain;
	}
	
	public static List getQuiz() {
		return getQuizList("quiz.dat");
	}
	
	public static List getQuizList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static void displayQuiz(String _courseCode)
	{
		List list=getQuiz();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Quiz course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Quiz qz = (Quiz)list.get(i);
					if(qz.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Quiz" + qz.getIndex() + " (" + qz.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no quiz for this " + _courseTitle);
			}

	}

	public static void displayQuizAll()
	{
		List list=getQuiz();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Quiz qz = (Quiz)list.get(i);
					System.out.println(qz.getCourseComponentCode() + qz.getIndex() + " (" + qz.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no quiz");
			}

	}
	
	public static int sumUp(String _courseCode)
	{
		int sum=0;
		List list=getQuiz();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Quiz qz = (Quiz)list.get(i);
				if(qz.getCourseComponentCode().compareTo(_courseCode)==0)
					sum+=qz.getCourseComponentPercent();	
			}
		}
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("quiz.dat", list);
	}
}