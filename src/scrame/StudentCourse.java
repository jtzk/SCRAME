package scrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentCourse implements Serializable {
	private String student;
	private String course;
	
	public StudentCourse() {
		student = "";
		course = "";
	}
	
	public StudentCourse(String _student, String _course) {
		student = _student;
		course = _course;
	}
	
	// Register student for a course
	public static boolean register(String _student, String _course) {
	    if (_student.length() > 0) {
	    	List list = getRegisterList();
    		StudentCourse r;
	    	int i = 0;
	    	while (i < list.size()) {
	    		r = (StudentCourse) list.get(i);
	    		if (r.student.equals(_student) && r.course.equals(_course)) {
	    			System.out.println("\nStudent is already registered for this course.");
	    			break;
	    		}
	    		i++;
	    	}
	    	if (i == list.size()) {
	    		r = new StudentCourse(_student, _course);
	    		list.add(r);
	    		save(list);
	    		System.out.println("\nStudent successfully enrolled in course.");
	    		return true;
	    	}
	    }
	    else {
	    	System.out.println("\nStudent does not exist.");
	    }
		return false;
	}

	// Update matric numbers
	public static void updateMatric(String _oldMatric, String _newMatric) {
		List list = getRegisterList();
		for (int i = 0; i < list.size(); i++) {
			StudentCourse r = (StudentCourse) list.get(i);
			if (r.student.equals(_oldMatric)) {
				int rIndex = list.indexOf(r);
				if (rIndex != -1) {
					r.student = _newMatric;
					list.set(rIndex, r);
					save(list);
				}
			}
		}
	}
	
	// Update course codes
	public static void updateCode(String _oldCode, String _newCode) {
		List list = getRegisterList();
		for (int i = 0; i < list.size(); i++) {
			StudentCourse r = (StudentCourse) list.get(i);
			if (r.course.equals(_oldCode)) {
				int rIndex = list.indexOf(r);
				if (rIndex != -1) {
					r.course = _newCode;
					list.set(rIndex, r);
					save(list);
				}
			}
		}
	}
	
	// Delete student
	public static void deleteStudent(String _matric) {
		List list = getRegisterList();
		for (int i = 0; i < list.size(); i++) {
			StudentCourse r = (StudentCourse) list.get(i);
			if (r.student.equals(_matric)) {
				list.remove(r);
				save(list);
			}
		}
	}
	
	// Delete course
	public static void deleteCourse(String _code) {
		List list = getRegisterList();
		for (int i = 0; i < list.size(); i++) {
			StudentCourse r = (StudentCourse) list.get(i);
			if (r.course.equals(_code)) {
				list.remove(r);
				save(list);
			}
		}
	}
	
	public static void printRegisterList(String _course) {
		List list = getRegisterList();
		if (list != null && list.size() > 0) {
			System.out.println("\nStudents enrolled");
			System.out.println("------------------");
			for (int i = 0; i < list.size(); i++) {
				StudentCourse r = (StudentCourse) list.get(i);
				if (r.course.equals(_course)) {
					Student s = Student.getStudentByMatric(r.student);
					System.out.println(i+1+")"+s.getName() + " (" + s.getMatric() + ")");
				}
			}
			System.out.println("------------------");
		}
		else
			System.out.println("\nThere are no students registered for this course.");
	}
	
	public static List getRegisterList() {
		return getRegisterList("studentcourse.dat");
	}
	
	public static List getRegisterList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	private static void save(List list) {
		SerializeDB.writeSerializedObject("studentcourse.dat", list);
	}
}
