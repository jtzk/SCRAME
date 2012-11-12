package scrame;

import java.util.ArrayList;
import java.util.List;

public class Report extends CourseComponent{
	private static String courseType;
	public Report(String _courseComponentCode,String _courseType , int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		courseType=_courseType;
		// TODO Auto-generated constructor stub
	}

	public static int addReport(String _courseCode, int balance)
	{
		int remain=0;
		courseType="report";
		List list = getReport();
		System.out.println("\nAdding new " +courseType+ " Component");
		System.out.println("-------------------------");	
		int  _percent = processPercent(courseType);						
		int index=0;
		int storeNo=0;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Report rp = (Report)list.get(i);
				if (_courseCode.compareTo(rp.getCourseComponentCode())==0){
					storeNo=rp.getIndex();
				}
			}
		}
		index=storeNo+1;
		System.out.println("\n "+_courseCode +" "+ courseType +" "+ _percent+" " +index);
		Report rp1= new Report(_courseCode,courseType, _percent, index);
			if (list == null) list = new ArrayList();
			
			int subtotal=_percent+sumUp(_courseCode);
			//System.out.println("subtotal"+subtotal);
			if(balance>0&&subtotal<=100)
			{		
				list.add(rp1);
				Report.save(list);		
				System.out.println("\n "+rp1.getCourseComponentCode() + rp1.getCourseComponentPercent() + rp1.getIndex() +" added!");
				displayReportAll();
				remain=balance-sumUp(_courseCode);
			}
			//else if(remain==0)
			//	System.out.println("Course component ("+_courseCode+ ")"+" is done");
			else{
				System.out.println("\n "+rp1.getCourseComponentCode() + rp1.getCourseComponentPercent() + rp1.getIndex() +" not added! Exceeded balance");
				remain=-1;
			}

			return remain;
	}
	
	public static List getReport() {
		return getReportList("report.dat");
	}
	
	public static List getReportList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static void displayReport(String _courseCode)
	{
		List list=getReport();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Report course ("+_courseTitle+")");
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Report rp = (Report)list.get(i);
					if(rp.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Report" + rp.getIndex() + " (" + rp.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no report for this " + _courseTitle);
			}

	}
	

	public static void displayReportAll()
	{
		List list=getReport();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Report rp = (Report)list.get(i);
					System.out.println(rp.getCourseComponentCode() + rp.getIndex() + " (" + rp.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no report");
			}

	}
	
	public static int sumUp(String _courseCode)
	{
		int sum=0;
		List list=getReport();
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Report rp = (Report)list.get(i);
				if(rp.getCourseComponentCode().compareTo(_courseCode)==0)
					sum+=rp.getCourseComponentPercent();
				
			}
		}
		//System.out.println("\nsum"+sum);
		return sum;
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("report.dat", list);
	}
}
