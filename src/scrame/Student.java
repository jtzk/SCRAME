package scrame;
import java.io.*;
import java.util.*;
public class Student extends Person  {
	private int year;
	private String matric;
	private String gender;
	private String address;
	
	private static Menu newMenu = new Menu();
	private static GetType get = new GetType();
	
	 
	// Public constructors
	public Student() {
		super("", "", 0);
		year = 1;
		matric = "";
		gender = "";
		address = "";
	}
	
	public Student(String _name, String _email, int _contact, int _year, 
			String _matric, String _gender, String _address) {
		
		super(_name, _email, _contact);
		year = _year;
		matric = _matric;
		gender = _gender;
		address = _address;
	}
	
	// Public getters
	public int getYear() 
	{ 
		return year;	
	}		// Get student year
	
	public int setYear(int Year) 
	{ 
		return year;	
	}		// set student year
	
	public String getMatric() 
	{ 
		return matric; 
	}	// Get student matric no

	
	public String getGender()
	{	
		return gender;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student s = (Student) o;
			return (getMatric().equals(s.getMatric()));
		}
		return false;
	}
	
	public static Student getStudentByMatric(String _matric) {
		return getStudentByMatric(_matric, "student.dat");
	}

	public static Student getStudentByMatric(String _matric, String file) {
		List list = getStudentList(file);
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				Student s = (Student)list.get(i);
				if (s.getMatric().equals(_matric)) return s;
			}
		}
		return null;
	}

	public static List getStudentList() {
		return getStudentList("student.dat");
	}

	public static List getStudentList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	// Public setters
	// Set student name
	public void updateName() {
		System.out.print("\nEnter new name: ");
		String _name = get.getString();

		if (_name.length() > 0) {
			if (_name.equals(getName())) {
				System.out.println("\n  No change detected. Original name preserved.");
			}
			else {
				List list = getStudentList();
				int studentIndex = list.indexOf(this);
				if (studentIndex != -1) {
					setName(_name);
					list.set(studentIndex, this);
					save(list);
					System.out.println("\n  Changed name of student to: " + getName());
				}
			}
		}
		else System.out.println("\n  Invalid name.");
	}
		
	// Set student matric no
	public void updateMatric() {
		System.out.print("\nEnter new matric no.: ");
		String _matric = get.getString();

		if (_matric.length() > 0) {
			if (_matric.equals(matric)) {
				System.out.println("\n  No change detected. Original matric no. preserved.");
			}
			else if (getStudentByMatric(_matric) == null) {
				List list = getStudentList();
				int studentIndex = list.indexOf(this);
				if (studentIndex != -1) {
					// Update registered course list
					StudentCourse.updateMatric(matric, _matric);
					matric = _matric;
					list.set(studentIndex, this);
					save(list);
					System.out.println("\n  Changed matric no. of student to: " + _matric);
				}
			}
			else System.out.println("\n  Error: Another student with that matric no. already exists.");
		}
		else System.out.println("\n  Invalid matric no.");
	}
	
	// Set student year
	public void updateYear() {
		System.out.print("\nEnter new year of study: ");
		int _year = get.getInt();

		if (_year == year) {
			System.out.println("\n  No change detected. Original year of study preserved.");
		}
		else if (_year > 0) {
			List list = getStudentList();
			int studentIndex = list.indexOf(this);
			if (studentIndex != -1) {
				year = _year;
				list.set(list.indexOf(this), this);
				save(list);
				System.out.println("\n  Changed year of student to: " + _year);
			}
		}
		else System.out.println("\n  Invalid year of study.");
	}
	
	// Enroll in course
	public void enroll(String _course) {
		StudentCourse r = new StudentCourse();
		r.register(matric, _course);
	}
	
	public static void printStudentList() {
		List list;
		String choice = "f";
		boolean skip = false;
		
		do {
			System.out.println();
			System.out.println("Students");
			System.out.println("-----------------------");
			
			list = getStudentList();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					Student s = (Student)list.get(i);
					System.out.println(i+1 + ") " + s.getName() + " (" + s.getMatric() + ")");
				}
			}
			else {
				System.out.println("There are no students in the system.");
			}
			
			System.out.println();
			System.out.println("0) Back to student menu");
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
						System.out.println("  That student does not exist.");
					}
					else {
						Student s = (Student) list.get(choiceInt-1);
						showStudent(s);
					}
			}
		} while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !skip);
	}
	
	private static boolean showStudent(Student s) {
		String choice = "";
		boolean deleted = false;
		
		List list = getStudentList();
		do {
			System.out.println();
			System.out.println("Student");
			System.out.println("---------------------");
			System.out.println("Name: " + s.getName());
			System.out.println("Matric: " + s.getMatric());
			System.out.println("Year: " + s.getYear());
			System.out.println();
			System.out.println("1) Edit name");
			System.out.println("2) Edit matric no.");
			System.out.println("3) Edit year of study");
			System.out.println("4) Register for a course");
			System.out.println("D) Delete student");
			System.out.println();
			System.out.println("0) Back to student list");
			System.out.println("Q) Exit program");
			System.out.println("---------------------");
			System.out.print("Enter choice: ");

			choice = get.getString();
			
			switch (choice) {
				case "0":
					System.out.println("  Exiting to student list...");
					break;
					
				case "1":
					s.updateName();
					break;
					
				case "2":
					s.updateMatric();
					break;

				case "3":
					s.updateYear();
					break;
					
				case "4":
					System.out.println("\nSelect a course from the list");
					System.out.println("-----------------------");
					
					List courseList = Course.getCourseList();
					Course c;
					
					if (courseList != null && courseList.size() > 0) {
						for (int i = 0; i < courseList.size(); i++) {
							c = (Course) courseList.get(i);
							System.out.println(i + 1 + ") " + c.getCode() + " " + c.getTitle());
						}
						
						System.out.println("-----------------------");
						System.out.print("Enter choice: ");
						
						int courseChoice = get.getInt() - 1;
						if ( courseChoice >= 0 && courseChoice < courseList.size() ) {
							c = (Course) courseList.get(courseChoice);
							StudentCourse.register(s.getMatric(), c.getCode());
						}
					}
					
					break;
					
				case "d":
				case "D":
					char confirm = 'n';
					System.out.println();
					System.out.println("  Are you sure you want to delete " +  s.getName() + "? This is irreversible.");
					System.out.print("  Enter \"y\" to confirm: ");
					confirm = get.getChar();
					if (confirm == 'y') {
						// Update registered course list
						StudentCourse.deleteStudent(s.getMatric());
						
						String deletedName = s.getName();
						String deletedMatric = s.getMatric();
						deleted = list.remove(s);
						s.save(list);
						System.out.println("\n  Deleted " + deletedName + " (" + deletedMatric + ")");
					}
					break;
				case "q":
				case "Q":
					newMenu.terminateMenu();
					break;
			}
		}  while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !deleted);
		
		return deleted;
	}
	
	public void save(List list) {
		SerializeDB.writeSerializedObject("student.dat", list);
	}
}
