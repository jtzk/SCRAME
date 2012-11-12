package scrame;

import java.util.*;

public class Professor extends Person implements Comparable<Professor>{
	private static final long serialVersionUID = 1L;

	public Professor(String _name, String _email , int _contact) {
		super(_name, _email, _contact);
	}

	public static void menuProfessors() {
		char choice = '1';
		
		do {
			String MenuTitle="Professor";
			Menu.showMenu2(MenuTitle);
			
			System.out.print("Enter choice: ");
			choice = GetType.getChar();
			
			switch (choice) {
				case '1':
					Professor.printProfessorList();
					break;

				case '2':
					System.out.print("Enter the professor's name: ");
					String name=GetType.getString();
					SearchProfessor(name);
					
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
	
	public boolean equals(Object o) {
		if (o instanceof Professor) {
			Professor p = (Professor)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}

	
	public static List getProfessorList() {
		return getProfessorList("professor.dat");
	}
	
	public static List getProfessorList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public int compareTo(Professor p) {
        int lastCmp = super.getName().compareTo(p.getName());
        return (lastCmp != 0 ? lastCmp : super.getName().compareTo(p.getName()));
	}
	
	public static void printProfessorList() {
		List list;
		String choice = "f";
		boolean skip = false;
		 
		do {
			System.out.println();
			System.out.println("Professor list");
			System.out.println("-----------------------");
			
			list = getProfessorList();
			Collections.sort(list);
			Professor.save(list);
			displayProfessor();	
			System.out.println();
			System.out.println("0) Back to professor menu");
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
	
	public static void SearchProfessor(String name)
	{
		List list=getProfessorList();
		String storeName = null,storeEmail = null;
		Boolean found=false;
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Professor p = (Professor)list.get(i);
				if (p.getName().compareTo(name)==0) {
					storeName=p.getName();
					storeEmail=p.getEmail();
					found=true;
					break;
				}
			}
		}

		if(found== true)
			System.out.println(storeName + " (" + storeEmail + ")");
		else
			System.out.println("There is no such professor.");
	}
	
	public static void displayProfessor()
	{
		List list=getProfessorList();
		for (int i = 0 ; i < list.size() ; i++) {
			Professor p = (Professor)list.get(i);
			System.out.println(i+1 + ") " + p.getName() + " (" + p.getEmail() + ")");
		}
	}
	
	public static void save(List list) {
		SerializeDB.writeSerializedObject("professsor.dat", list);
	}
}