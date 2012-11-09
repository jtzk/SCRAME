package scrame;
import java.io.Serializable;
import java.util.Vector;
public class Class implements Serializable{

	private String name;
	private Course course;
	private int size;

	public Class(String _name, String _course, int _size) {
		name = _name;
		course = course.getCourseByTitle(_course);
		size = _size;
	}
	public String getName() { return name; }
	public String getCourse() { return course.getTitle(); }
	public int getSize() { return size; }
	

	public boolean equals(Object o) {
		if (o instanceof Class) {
			Class c = (Class)o;
			return (getName().equals(c.getClass()));
		}
		return false;
	}
}