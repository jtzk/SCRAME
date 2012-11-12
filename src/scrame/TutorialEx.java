package scrame;

import java.util.ArrayList;
import java.util.List;


public class TutorialEx extends CourseComponent{
	
	public TutorialEx(String _courseComponentCode, int _courseComponentPercent,int _index) {
		super(_courseComponentCode, _courseComponentPercent, _index);
		// TODO Auto-generated constructor stub
	}

	public static void menuTutorial()
	{
		char choice = '1';
			
			do {
				String MenuTitle="Tutorial Component";
				Menu.showMenu(MenuTitle);
				
				System.out.print("Enter choice: ");
				choice = GetType.getChar();
				
				switch (choice) {
					case '1':
						displayTutorialExAll();
						break;
	
					case '2':
						List list = getTutorialEx();
						System.out.println("\nAdding new Tutorial Component");
						System.out.println("-------------------------");	
						
						
						// Process name
						System.out.println("Enter course code");
						String _courseCode = GetType.getString().toUpperCase();
						// Process percent
						System.out.println("Enter tutorial percent");
						int  _percent = GetType.getInt();						
						int index=0;
						int storeNo=0;
						if (list != null && list.size() > 0) {
							for (int i = 0 ; i < list.size() ; i++) {
								TutorialEx tx1 = (TutorialEx)list.get(i);
								if (_courseCode.compareTo(tx1.getCourseComponentCode())==0){
									if(tx1.getIndex()==0)
										storeNo=1;
									else{
										storeNo=tx1.getIndex();
										
									}
									
								}
							}
						}
						index=storeNo+1;
						TutorialEx tx= new TutorialEx(_courseCode, _percent, index);
	
												
						if (list == null) list = new ArrayList();
						list.add(tx);
						TutorialEx.save(list);		
						System.out.println("\n "+tx.getCourseComponentCode() + tx.getCourseComponentPercent() + tx.getIndex() +" added!");
						displayTutorialEx(_courseCode);
						break;					
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

			displayTutorialExAll();	
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
	
	public static void displayTutorialEx(String _courseCode)
	{
		List list=getTutorialEx();
		String _courseTitle= Course.SearchCourse(_courseCode);
		System.out.println("Tutorial course -"+_courseTitle);
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					TutorialEx tx = (TutorialEx)list.get(i);
					if(tx.getCourseComponentCode().compareTo(_courseCode)==0)
					System.out.println("Tutorial excerise" + tx.getIndex() + " (" + tx.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no tutorial exercise for this " + _courseTitle);
			}

	}
	

	public static void displayTutorialExAll()
	{
		List list=getTutorialEx();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					TutorialEx tx = (TutorialEx)list.get(i);
					System.out.println(tx.getCourseComponentCode() + tx.getIndex() + " (" + tx.getCourseComponentPercent()+ ")");
				}
			}
			else {
				System.out.println("There are no tutorial exercise for this ");
			}

	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("tutorialex.dat", list);
	}
	
}
