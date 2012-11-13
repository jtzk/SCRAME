package scrame;
import java.util.*;
public class ScrameApp {
	public static void main(String[] args) {
		boolean success = false;
		boolean loaded=false;
		RawCase rc= new RawCase();
		char choice = '1';
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
					
				case '4':
					if(loaded==false){
						rc.rawProfessor();
						rc.rawStudent();
						rc.rawCourse();
						//rc.rawClass();
						rc.rawStudentCourse();
						rc.rawProfessorCourse();
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