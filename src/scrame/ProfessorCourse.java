package scrame;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfessorCourse implements Serializable {
	private String professor;
	private String course;
	
	public ProfessorCourse() {
		professor = "";
		course = "";
	}
	
	public ProfessorCourse(String _professor, String _course) {
		professor = _professor;
		course = _course;
	}
	

	public static void printProfessorCourseList(String _course) {
		List list = Professor.getProfessorList("professorcourse.dat");

		if (list != null && list.size() > 0) {
			System.out.println("\nInformation of Professors coordinating courses");
			System.out.println("------------------");
			for (int i = 0; i < list.size(); i++) {
				ProfessorCourse r = (ProfessorCourse) list.get(i);
				if (r.course.equals(_course)) {
					Professor p = Professor.getProfessorByName(r.professor,"professor.dat");
					System.out.println(i+1+")"+p.getName() + " (" + p.getEmail() + ")" + " (" + p.getContact() + ")");
				}
			}
			System.out.println("------------------");
		}
		else
			System.out.println("\nThere are no professor coordinating this course.");
	}

}
