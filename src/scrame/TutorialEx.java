package scrame;

import java.util.ArrayList;
import java.util.List;


public class TutorialEx extends CourseComponent{
	
	public TutorialEx(String _courseComponentCode, int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		// TODO Auto-generated constructor stub
	}

	public static void menu()
	{
		char choice = '1';
			
			do {
				String MenuTitle="Tutorial Component";
				Menu.showMenu(MenuTitle);
				
				System.out.print("Enter choice: ");
				choice = GetType.getChar();
				
				switch (choice) {
					case '1':
				//	    printTutorialList();
						break;
	
					case '2':
						System.out.println("\nAdding new Tutorial Component");
						System.out.println("-------------------------");	

						// Process percent
						int  _percent = processPercent("Tutorial Percent");
											
					case '0':
						System.out.println("  Exiting to previous menu...");
						break;
					case 'q':
					case 'Q':
						Menu.terminateMenu();
						break;
					default:
						System.out.println("  Invalid choice.");
				}
			} while (choice != '0' && choice != 'q' && choice != 'Q');		
	}
	public static void printTutorialExList() {
		List list;
		String choice = "f";
		boolean skip = false;
		 
		do {
			System.out.println();
			System.out.println("TutorialEx list");
			System.out.println("-----------------------");
			
			list = getTutorialEx();

			displayTutorialEx();	
			System.out.println();
			System.out.println("0) Back to TutorialEx menu");
			System.out.println("Q) Exit program");
			System.out.println("-----------------------");
			
			System.out.print("Enter choice: ");
			choice = GetType.getString();
			
			switch (choice) {
				case "0":
					System.out.println("  Exiting to previous menu...");
					break;
				case "q":
				case "Q":
					Menu.terminateMenu();
					break;
			}
		} while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !skip);
	}
	
	
	public static List getTutorialEx() {
		return getTutorialExList("tutorialex.dat");
	}
	
	public static List getTutorialExList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static void displayTutorialEx()
	{
		TutorialEx tx1 = null;
		String _courseCode= tx1.getCourseComponentCode();
		String _courseTitle= Course.SearchCourse(_courseCode);
		List list=getTutorialEx();
		for (int i = 0 ; i < list.size() ; i++) {
			TutorialEx tx = (TutorialEx)list.get(i);
			
			System.out.println("Tutorial excerise" + tx.getIndex() + " (" + tx.getCourseComponentPercent()+ ")");
		}
	}
	public static void save(List list) {
		SerializeDB.writeSerializedObject("tutorialex.dat", list);
	}
	
}

