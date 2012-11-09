package scrame;
import java.util.*;
public class ScrameApp {
	public static GetType GetTypeFc = new GetType();
	public static Menu newMenu=new Menu();
	public static void main(String[] args) {
		boolean success = false;
		char choice = '1';
		do {
			newMenu.showMenu();			
			choice = GetTypeFc.getChar();
			switch (choice) {
				case '1':
					menuProfessors();
					break;
					
				case '2':
					menuStudents();
					break;
					
				case '3':
					menuCourse();
					break;
					
				case 'q':
				case 'Q':
					newMenu.terminateMenu();
					break;
				default:
					System.out.println("Invalid choice.");
			}
		} while (choice != 'q' && choice != 'Q');
	}
	
	private static void menuCourse()
	{
		String MenuTitle = "Course";
		char choice = '\u0000';
		
		do {
		  newMenu.showMenu(MenuTitle);
		  System.out.print("Enter choice: ");
			choice = GetTypeFc.getChar();
			
			switch (choice) {
				case '1':
					Course.printCourseList();
					break;
				case '2':
					System.out.println("\nAdding new course");
					System.out.println("-------------------------");		
					
					System.out.print("Enter course title: ");		
					String _title = GetTypeFc.getString();
					
					String _code = "";
					boolean codeError = true;
					
					do {
						System.out.print("Enter course code: ");
						_code = GetTypeFc.getString();
						if (_code.equals("q") || _code.equals("Q")) break;
						if (Course.getCourseByCode(_code) != null) {
							System.out.println("  Error: Another course with that code already exists. Please try again.");
						}
						else codeError = false;
					} while (codeError);
					
					if (!codeError) {
						System.out.print("Enter course AU: ");
						int _au = GetTypeFc.getInt(); 				
						List list = Course.getCourseList();
						Course c = new Course(_title, _code, _au);
						if (list == null) list = new ArrayList();
						list.add(c);
						c.save(list);			
						System.out.println("\n  Course " + c.getTitle() + " added!");
					}
					
					break;
				case '0':
					System.out.println("  Exiting to previous menu...");
					break;
				case 'q':
				case 'Q':
					newMenu.terminateMenu();
					break;
				default:
					System.out.println("  Invalid choice.");
			}
		} while (choice != 'q' && choice != 'Q' && choice != '0');
	}
	
	private static void menuProfessors() {
		List list;
		try	{
			// read from serialized file the list of professors
			list = (ArrayList<?>)SerializeDB.readSerializedObject("professor.dat");
			
			 System.out.println("Professors Menu");
			 System.out.println("-----------------------");
			 Professor p = new Professor("Joseph Lay", "jos@ntu.edu.sg", 67909999);
			 
			 list.add(p);
			 list.remove(p);  // remove if p equals object in the list
			for (int i = 0 ; i < list.size() ; i++) {
				Professor p1 = (Professor)list.get(i);
				System.out.println(i+1 + ") " + p1.getName() + " (" + p1.getContact() + ")");
			}
			System.out.println("");
			System.out.println("0) Back to main menu");
			System.out.println("Q) Exit program");
			System.out.println("-----------------------");
			System.out.print("Select a professor: ");
			// write to serialized file - update/insert/delete
			// example - add one more professor


			// SerializeDB.writeSerializedObject("professor.dat", list);
		}
		catch ( Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
		}
	}
	
	private static void menuStudents() {
		char choice = '1';
		
		do {
			String MenuTitle="Student";
			newMenu.showMenu(MenuTitle);
			
			System.out.print("Enter choice: ");
			choice = GetTypeFc.getChar();
			
			switch (choice) {
				case '1':
					Student.printStudentList();
					break;
				case '2':
					System.out.println("\nAdding new student");
					System.out.println("-------------------------");		
					System.out.print("Enter student's name: ");		
					String _name = GetTypeFc.getString();
					System.out.print("Enter student's email address: ");			
					String _email = GetTypeFc.getString();
					System.out.print("Enter student's contact number: ");			
					int _contact = GetTypeFc.getInt();
					System.out.print("Enter student's gender: ");			
					String _gender = GetTypeFc.getString();		
					System.out.print("Enter student's address: ");			
					String _address = GetTypeFc.getString();
					
					String _matric = "";
					boolean matricError = true;
					
					do {
						System.out.print("Enter student's matriculation no.: ");
						_matric = GetTypeFc.getString();
						if (_matric.equals("q") || _matric.equals("Q")) break;
						if (Student.getStudentByMatric(_matric) != null) {
							System.out.println("  Error: Another student with that matric no. already exists. Please try again.");
						}
						else matricError = false;
					} while (matricError);
					
					if (!matricError) {
						System.out.print("Enter student's year of study: ");
						int _year = GetTypeFc.getInt(); 				
						List list = Student.getStudentList();
						Student s = new Student(_name, _email, _contact, _year, _matric, _gender, _address);								
						if (list == null) list = new ArrayList();
						list.add(s);
						s.save(list);			
						System.out.println("\n  Student " + s.getName() + " added!");
					}
					
					break;
				case '0':
					System.out.println("  Exiting to previous menu...");
					break;
				case 'q':
				case 'Q':
					newMenu.terminateMenu();
					break;
				default:
					System.out.println("  Invalid choice.");
			}
		} while (choice != '0' && choice != 'q' && choice != 'Q');
	}
}