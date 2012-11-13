package scrame;

import java.util.*;
public class ScrameApp {
	public static void main(String[] args) {
		boolean success = false;
		boolean loaded=false;
		char choice = '1';
		RawCase rc= new RawCase();
		
		do {
			Menu.showMenu();			
			choice = GetType.getChar();
			switch (choice) {
				case '1':	
					Professor.menuProfessors();
					break;
					
				case '2':					
					Student.menuStudents();
					break;
					
				case '3':		
					Course.menuCourse();
					break;
					
				case'4':
					System.out.print("Enter course code: ");
					String _courseCode=GetType.getString().toUpperCase();
					String storeCourseTitle=Course.SearchCourse(_courseCode);
					if(storeCourseTitle!=null){
						System.out.println(storeCourseTitle + " (" + _courseCode + ") is found");
						Menu.courseComponentMenu(_courseCode);
					}
					else
						System.out.println("There is no such course.");
					
					break;
					
				case '5':
					if(loaded==false){
						rc.rawProfessor();
						rc.rawStudent();
						rc.rawCourse();
				//		rc.rawClass();
						rc.rawStudentCourse();
						loaded=true;
						System.out.println("Loading rawcases.");
					}
					else
						System.out.println("Rawcases has been loaded.");

					break;
					
				case 'q':
				case 'Q':
					Menu.terminateMenu();
					break;
				default:
					System.out.println("Invalid choice.");
			}
		} while (choice != 'q' && choice != 'Q');
	}

}