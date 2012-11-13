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
				CourseComponent.menuComponent();
				break;

			case '5':
				if(loaded==false){
					//Loaded All test cases
					rc.rawAll();
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