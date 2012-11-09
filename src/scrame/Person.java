package scrame;

import java.io.Serializable;

//default class Person
public class Person implements Serializable{
	//variable
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
	
	public String getName()
	{
		return name; 
	}
	
	public void setName(String _name)
	{
		name = _name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public int getContact()
	{
		return contact;
	}	
}
