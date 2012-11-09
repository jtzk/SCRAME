package scrame;

import java.io.Serializable;

//default class Person
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private int contact;
	//constructor
	public Person(String _name, String _email, int _contact)
	{
		name = _name;
		email = _email;
		contact = _contact;
	}
	
	// Getter methods
	// Gets name
	public String getName()
	{
		return name; 
	}
	
	// Gets email
	public String getEmail()
	{
		return email;
	}
	
	// Gets contact no.
	public int getContact()
	{
		return contact;
	}
	
	// Setter methods
	// Sets name
	public void setName(String _name)
	{
		name = _name;
	}
	
	// Sets email
	public void setEmail(String _email)
	{
		email = _email;
	}
	
	// Sets contact no.
	public void setContact(int _contact)
	{
		contact = _contact;
	}
	
	// Processing methods
	// Prompts for and gets input for name
	public static String processName(String person) {
		String _name = "";
		do {
			System.out.print("Enter " + person + "'s name: ");		
			_name = GetType.getString();
			if (_name.length() == 0) {
				System.out.println("\n  Error: Invalid name. Name must contain at least one character.\n");
			}
			else if (_name.matches(".*\\d+.*")) {
				System.out.println("\n  Error: Invalid name. Name should not contain any numbers.\n");
			}
			else return _name;
		} while (true);
	}
	
	// Prompts for and gets input for contact no.
	public static int processContact(String person) {
		int _contact;
		do {
			try {
				System.out.print("Enter " + person + "'s contact number: ");			
				_contact = GetType.getInt();
				return _contact;
			}
			catch (NumberFormatException e) {
				System.out.println("\n  Error: Invalid contact number. Only digits are allowed.\n");
			}
		} while (true);
	}
	
	// Prompts for and gets input for gender
	public static char processGender(String person) {
		char _gender;
		
		do {
		System.out.print("Enter " + person + "'s gender (M/F): ");			
			_gender = GetType.getChar();
			if (_gender == 'f' || _gender == 'F') return 'F';
			else if (_gender == 'm' || _gender == 'M') return 'M';
			else {
				System.out.println("\n  Error; Invalid gender. Only 'M' or 'F' is allowed.\n");
			}
		} while (true);
	}
	
	// Prompts for and gets input for email
	public static String processEmail(String person) {
		String _email;
		
		do {
		System.out.print("Enter " + person + "'s email: ");			
			_email = GetType.getString();
			if (_email.length() > 0) return _email;
			else return "NONE";
		} while (true);
	}
}
