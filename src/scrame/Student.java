package scrame;
import java.io.*;
import java.util.*;
public class Student extends Person  {
	//private static final long serialVersionUID = 1L
	private int year;
	private String matric;
	private String gender;
	private String address;
	
	public static GetType get = new GetType();
	 
	// Public constructor
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
	
	public void save(List list) {
		SerializeDB.writeSerializedObject("student.dat", list);
	}
}
