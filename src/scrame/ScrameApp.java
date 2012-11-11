package scrame;
import java.util.*;
public class ScrameApp {
	public static void main(String[] args) {
		boolean success = false;
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
					rc.rawProfessor();
					rc.rawStudent();
					rc.rawCourse();
					rc.rawClass();
					rc.rawStudentCourse();
					System.out.println("Loading rawcases.");
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