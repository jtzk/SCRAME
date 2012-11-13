package scrame;

import java.util.ArrayList;
import java.util.List;

public class Exam extends CourseComponent{
	private static String courseType;
	public Exam(String _courseComponentCode,String _courseType , int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		courseType=_courseType;
		// TODO Auto-generated constructor stub
	}

	public static int addExam(String _courseCode, int balance)
	{
		int remain=0;
		courseType="exam";
		List list = getExam();
		System.out.println("\nAdding new " +courseType+ " Component");
		System.out.println("-------------------------");	
		int  _percent = processPercent(courseType);						
		int index=0;
		int storeNo=0;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Exam em = (Exam)list.get(i);
				if (_courseCode.compareTo(em.getCourseComponentCode())==0){
					storeNo=em.getIndex();
				}
			}
		}
		index=storeNo+1;
		
		Exam em1= new Exam(_courseCode,courseType, _percent, index);
		if (list == null) list = new ArrayList();
		int subtotal=_percent+sumUpAll(_courseCode);

		if(balance>0&&subtotal<=100)
		{		
			list.add(em1);
			Exam.save(list);		
			System.out.println(courseType + index + " (" + _percent+ ")" +" added!");
			remain=balance-_percent;
		}
			
		else{
			System.out.println(courseType + index + " (" + _percent+ ")" +" not added! Exceeded balance!");
			remain=-1;
		}

		return remain;
	}
	
	public static List getExam() {
		return getExamList("exam.dat");
	}
	
	public static List getExamList(String file) {
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
		List list = getExam();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Exam ex = (Exam) list.get(i);
				if (ex.getCourseComponentCode().equals(_courseCode)) {
					return ex.getCourseComponentPercent();
				}
			}
		}
		return 0;
	}
	
	public static void displayExam(String _courseCode)
	{
		List list=getExam();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Exam course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Exam em = (Exam)list.get(i);
					if(em.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Exam" + em.getIndex() + " (" + em.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no exams for this " + _courseTitle);
			}

	}

	public static void displayExamAll()
	{
		List list=getExam();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Exam em = (Exam)list.get(i);
					System.out.println(em.getCourseComponentCode() + em.getIndex() + " (" + em.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no exams");
			}

	}
	
	public static int sumUp(String _courseCode)
	{
		int sum=0;
		List list=getExam();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Exam em = (Exam)list.get(i);
				if(em.getCourseComponentCode().compareTo(_courseCode)==0)
					sum+=em.getCourseComponentPercent();
				
			}
		}
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("exam.dat", list);
	}
}