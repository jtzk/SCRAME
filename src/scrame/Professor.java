package scrame;

import java.util.*;

public class Professor extends Person implements Comparable<Professor>{
	private static final long serialVersionUID = 1L;

	public Professor(String _name, String _email , int _contact) {
		super(_name, _email, _contact);
	}

	public static void menuProfessors() {
		try	{
			List list = Professor.getProfessorList();
			Collections.sort(list);
			System.out.println("Professors List");
			System.out.println("-----------------------");
			for (int i = 0 ; i < list.size() ; i++) {
				Professor p = (Professor)list.get(i);
				System.out.println(i+1 + ") " + p.getName() + " (" + p.getEmail() + ")");
			}
		}
		catch ( Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Professor) {
			Professor p = (Professor)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}
	public void save(List list) {
		SerializeDB.writeSerializedObject("professsor.dat", list);
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
}