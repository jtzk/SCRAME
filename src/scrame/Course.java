package scrame;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {
	private String title;
	private String code;
	private int au;
	private int index;
	public static Menu newMenu = new Menu();
	public static GetType get = new GetType();

	public Course(String _title, String _code, int _au)
	{
		title = _title;
		code = _code;
		au = _au;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public int getAU()
	{
		return au;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course c = (Course) o;
			return (getCode().equals(c.getCode()));
		}
		return false;
	}
	
	public Course getCourseByTitle(String _title) {
		List list = getCourseList();
		for (int i = 0; i < list.size(); i++) {
			Course c = (Course) list.get(i);
			if (c.getTitle().equals(_title)) return c;
		}
		return null;
	}
	
	public Course getCourseByCode(String _code) {
		List list = getCourseList();
		for (int i = 0; i < list.size(); i++) {
			Course c = (Course) list.get(i);
			if (c.getCode().equals(_code)) return c;
		}
		return null;
	}
	
	public static List getCourseList() {
		return getCourseList("course.dat");
	}

	public static List getCourseList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public void printCourseList() {
		List list;
		String choice = "f";
		boolean skip = false;
		
		do {
			System.out.println();
			System.out.println("Courses");
			System.out.println("-----------------------");
			
			list = getCourseList();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Course c = (Course) list.get(i);
					System.out.println(i+1 + ") " + c.code + " " + c.title);
				}
			}
			else {
				System.out.println("There are no courses in the system.");
			}
			
			System.out.println();
			System.out.println("0) Back to courses menu");
			System.out.println("Q) Exit program");
			System.out.println("-----------------------");
			
			System.out.print("Enter choice: ");
			choice = get.getString();
			
			switch (choice) {
				case "0":
					System.out.println("  Exiting to previous menu...");
					break;
				case "q":
				case "Q":
					newMenu.terminateMenu();
					break;
				default:
					int choiceInt = 0;
					try {
						choiceInt = Integer.parseInt(choice);
					}
					catch (Exception e) {
						System.out.println("  Invalid choice.");
						break;
					}
					if (list == null || list.size() < choiceInt) {
						System.out.println("  That course does not exist.");
					}
					else {
						Course c = (Course) list.get(choiceInt-1);
						showCourse(c);
					}
			}
		} while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !skip);
	}
	
	private static boolean showCourse(Course c) {
		String choice = "";

		boolean deleted = false;
		List list = getCourseList();
		do {
			System.out.println();
			System.out.println("Course");
			System.out.println("---------------------");
			System.out.println("Code: " + c.getCode());
			System.out.println("Title: " + c.getTitle());
			System.out.println("AU: " + c.getAU());
			System.out.println();
			System.out.println("1) Edit course title");
			System.out.println("2) Edit course code");
			System.out.println("3) Edit course AU");
			System.out.println("D) Delete course");
			System.out.println();
			System.out.println("0) Back to course list");
			System.out.println("Q) Exit program");
			System.out.println("---------------------");
			System.out.print("Enter choice: ");
			String _title = "";
			choice = get.getString();
			
			switch (choice) {
				case "0":
					System.out.println("  Exiting to course list...");
					break;
					
				case "1":
					c.updateTitle();
					break;
					
				case "2":
					c.updateCode();
					break;

				case "3":
					c.updateAU();
					break;
					
				case "d":
				case "D":
					char confirm = 'n';
					System.out.println();
					System.out.println("  Are you sure you want to delete " +  c.getTitle() + "? This is irreversible.");
					System.out.print("  Enter \"y\" to confirm: ");
					confirm = get.getChar();
					if (confirm == 'y') {					
						String deletedTitle = c.getTitle();
						String deletedCode = c.getCode();
						deleted = list.remove(c);
						c.save(list);
						System.out.println("\n  Deleted " + deletedTitle + " (" + deletedCode + ")");
					}
					break;
				case "q":
				case "Q":
					newMenu.terminateMenu();
					break;
			}
		}  while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !choice.equals("d") && !choice.equals("D"));
		
		return deleted;
	}
	
	// Public setters
	// Update course title
	public void updateTitle() {
		System.out.print("\nEnter new title: ");
		String _title = get.getString();

		if (_title.length() > 0) {
			if (_title.equals(getTitle())) {
				System.out.println("\n  No change detected. Original title preserved.");
			}
			else {
				List list = getCourseList();
				int courseIndex = list.indexOf(this);
				if (courseIndex != -1) {
					setTitle(_title);
					list.set(courseIndex, this);
					save(list);
					System.out.println("\n  Changed title of course to: " + getTitle());
				}
			}
		}
		else System.out.println("\n  Invalid title.");
	}
	// Update course code
	public void updateCode() {
		System.out.print("\nEnter new course code: ");
		String _code = get.getString();

		if (_code.length() > 0) {
			if (_code.equals(code)) {
				System.out.println("\n  No change detected. Original course code preserved.");
			}
			else if (getCourseByCode(_code) == null) {
				List list = getCourseList();
				int courseIndex = list.indexOf(this);
				if (courseIndex != -1) {
					code = _code;
					list.set(courseIndex, this);
					save(list);
					System.out.println("\n  Changed code of course to: " + _code);
				}
			}
			else System.out.println("\n  Error: Another course with that code already exists.");
		}
		else System.out.println("\n  Invalid course code.");
	}
	// Update course AU
	public void updateAU() {
		System.out.print("\nEnter new course AU: ");
		int _au = get.getInt();

		if (_au == au) {
			System.out.println("\n  No change detected. Original year of study preserved.");
		}
		else if (_au > 0) {
			List list = getCourseList();
			int courseIndex = list.indexOf(this);
			if (courseIndex != -1) {
				au = _au;
				list.set(list.indexOf(this), this);
				save(list);
				System.out.println("\n  Changed AU of course to: " + _au);
			}
		}
		else System.out.println("\n  Invalid course AU.");
	}
	
	// Set course title
	public void setTitle(String _title)
	{
		title = _title;
	}
	
	// Set course code
	public void setCode(String _code)
	{
		code = _code;
	}
	
	public void setAU(int _au)
	{
		au = _au;
	}
	
	public void save(List list) {
		SerializeDB.writeSerializedObject("course.dat", list);
	}
}
