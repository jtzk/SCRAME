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
					List courseList = Course.getCourseList();
					Collections.sort(courseList);
					
					if (courseList.size() > 0) {
						System.out.println("\nCourse list");
						System.out.println("---------------");
						for (int i = 0; i < courseList.size(); i++) {
							Course c = (Course) courseList.get(i); 
							System.out.println(i + 1 +") " + c.getCode() + " " + c.getTitle());
						}
						System.out.println();
						System.out.println("0) Back to main menu");
						System.out.println("Q) Exit program");
						System.out.println("---------------");
						System.out.print("Enter choice (or course code to search): ");
						
						String courseChoice = GetType.getString();
						
						switch (courseChoice) {
							case "0":
								System.out.println("\n  Exiting to main menu...");
								break;
								
							case "q":
							case "Q":
								Menu.terminateMenu();
								break;
								
							default:
								int courseChoiceInt;
								try {
									courseChoiceInt = Integer.parseInt(courseChoice);
									if (courseChoiceInt > 0 && courseChoiceInt <= courseList.size()) {
										Course c = (Course) courseList.get(courseChoiceInt-1);
										Menu.courseComponentMenu(c.getCode());
									}
									else {
										System.out.println("\n  Invalid choice.");
									}
								}
								catch (Exception e) {
									courseChoice = courseChoice.toUpperCase();
									String storeCourseTitle = Course.SearchCourse(courseChoice);
									
									if (storeCourseTitle != null) {
										Menu.courseComponentMenu(courseChoice);
									}
									
									else {
										System.out.println("\n  There is no such course.");
									}
								}
						}
					}
					else
						System.out.println("\nThere are no courses in the system.");
					
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