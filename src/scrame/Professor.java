package scrame;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Person {
	public Professor(String _name, String _email , int _contact) {
		super(_name, _email, _contact);
	}

	public static void menuProfessors() {
		List list;
		try	{
			// read from serialized file the list of professors
			list = (ArrayList<?>)SerializeDB.readSerializedObject("professor.dat");
			
			 System.out.println("Professors Menu");
			 System.out.println("-----------------------");
			 Professor p = new Professor("Joseph Lay", "jos@ntu.edu.sg", 67909999);
			 
			 list.add(p);
			 list.remove(p);  // remove if p equals object in the list
			for (int i = 0 ; i < list.size() ; i++) {
				Professor p1 = (Professor)list.get(i);
				System.out.println(i+1 + ") " + p1.getName() + " (" + p1.getContact() + ")");
			}
			System.out.println("");
			System.out.println("0) Back to main menu");
			System.out.println("Q) Exit program");
			System.out.println("-----------------------");
			System.out.print("Select a professor: ");
			// write to serialized file - update/insert/delete
			// example - add one more professor


			// SerializeDB.writeSerializedObject("professor.dat", list);
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
}