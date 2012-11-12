package scrame;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class Class implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String professorName;
	private String name;
	private String course;
	private int size;
	private ArrayList<Student> students;

	public Class(String _name, String _course, int _size) {
		professorName = "";
		name = _name;
		course = Course.getCourseByCode(_course).getCode();
		size = _size;
		students = new ArrayList<Student>();
	}
	
	// Getters
	public String getName() { return name; }
	public String getCourse() { return course; }
	public int getSize() { return size; }
	public int getVacancy() {
		int vacancy = size - students.size();
		return vacancy;
	}
	
	// Setters
	public void setName(String _name) { name = _name; }
	public void setSize(int _size) { size = _size; }
	
	public void menuClass() {
		System.out.println("");
		System.out.println("Edit Class");
		System.out.println("------------------");
		System.out.println("1) Name: " + name);
		System.out.println("2) Size: " + size);
		System.out.println("D) Delete class");
		System.out.println("");
		System.out.println("0) Back to " + course + " class list");
		System.out.println("Q) Exit program");
		System.out.println("------------------");
		System.out.print("Enter choice: ");
	}

	public boolean equals(Object o) {
		if (o instanceof Class) {
			Class c = (Class)o;
			return (getName().equals(c.getName()));
		}
		return false;
	}
	
	// Check if student is already in this class
	public boolean inClass(Student s) {
		// Check if student exists in <students> array
		if (students != null && students.size() > 0) {
			for (int i = 0; i < students.size(); i++) {
				Student student = students.get(i);
				// Student is already in this class
				if (s.equals(student)) return true;
			}
		}
		return false;
	}
	
	// Add student to class
	public void addStudent(Student s) {
		// Check if student is already in this class
		if (inClass(s))	System.out.println(s.getName() + " (" + s.getMatric() + ") is already enrolled in this class.");
		
		// If not
		else {
			// Add student to <students> array
			students.add(s);
			System.out.println(s.getName() + " (" + s.getMatric() + ") has been enrolled in this class.");
		}
	}
	
	// Static methods
	public static List getClassList() {
		return getClassList("class.dat");
	}
	
	public static List getClassList(String file) {
		List list = null;
		try {
			list = (ArrayList) SerializeDB.readSerializedObject(file);
		}
		catch ( Exception e ) {
		}
		if (list == null) list = new ArrayList();
		return list;
	}
	
	public static Class getClassByName(String _name) {
		List list = getClassList();
		for (int i = 0; i < list.size(); i++) {
			Class cl = (Class) list.get(i);
			if (cl.getName().equals(_name)) {
				return cl;
			}
		}
		return null;
	}
	
	
	public void save(List list) {
		SerializeDB.writeSerializedObject("class.dat", list);
	}
}