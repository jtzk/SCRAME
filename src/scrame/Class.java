package scrame;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class Class implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String course;
	private int size;
	private ArrayList<Student> students;

	public Class(String _name, String _course, int _size) {
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
	public static List getClassList() {
		return getClassList("class.dat");
	}
	
	public void save(List list) {
		SerializeDB.writeSerializedObject("class.dat", list);
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
}