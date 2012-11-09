package scrame;

public class Professor extends Person {
	public Professor(String _name, String _email , int _contact) {
		super(_name, _email, _contact);
	}

	public boolean equals(Object o) {
		if (o instanceof Professor) {
			Professor p = (Professor)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}
}