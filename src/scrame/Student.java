package scrame;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Student extends Person implements Comparable<Student> {
	private static final long serialVersionUID = 1L;

	private int year;
	private String matric;
	private char gender;
	private String address;

	// Public constructors
	public Student() {
		super("", "", 0);
		year = 1;
		matric = "";
		gender = 'M';
		address = "";
	}

	public Student(String _name, String _email, int _contact, int _year, 
			String _matric, char _gender, String _address) {

		super(_name, _email, _contact);
		year = _year;
		matric = _matric;
		gender = _gender;
		address = _address;
	}

	// Public getters
	// Get student year
	public int getYear() 
	{ 
		return year;	
	}

	public String getMatric() 
	{ 
		return matric; 
	}	// Get student matric no


	public char getGender()
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

	// Internal processing
	// Methods should prompt and get inputs from user
	// 	 and return only when a valid input is provided.
	private static int processYear() {
		int _year = 0;
		do {
			System.out.print("Enter student's year of study: ");
			try {
				_year = GetType.getInt();
				return _year;
			}
			catch (NumberFormatException e) {
				System.out.println("\n  Error: Invalid year of study. Only digits are allowed.\n");
			}
		} while (true);
	}

	// Public setters
	// Set year of study
	public void setYear(int _year) { 
		year = _year;	
	}

	// Set gender
	public void setGender(char _gender) {
		gender = _gender;
	}

	// Set address
	public void setAddress(String _address) {
		address = _address;
	}

	// Update student name
	public void updateName() {
		System.out.print("\nEnter new name: ");
		String _name = GetType.getString();

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

	// Update student matric no
	public void updateMatric() {
		System.out.print("\nEnter new matric no.: ");
		String _matric = GetType.getString().toUpperCase();

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

					// Update student list
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
		int _year = processYear();

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
		StudentCourse.register(matric, _course);
	}

	public static void menuStudents() {
		char choice = '1';

		do {
			String MenuTitle="Student";
			Menu.showMenu(MenuTitle);

			System.out.print("Enter choice: ");
			choice = GetType.getChar();

			switch (choice) {
			case '1':
				Student.printStudentList();
				break;
			case '2':
				System.out.println("\nAdding new student");
				System.out.println("-------------------------");		

				// Process name
				String _name = processName("student");

				// Process email
				String _email = processEmail("student");

				// Process contact
				int _contact = processContact("student");

				// Process gender
				char _gender = processGender("student");

				// Process address
				System.out.print("Enter student's address: ");			
				String _address = GetType.getString();
				if (_address.length() == 0) _address = "NONE";

				// Process matric
				String _matric = "";
				boolean matricError = true;

				do {
					System.out.print("Enter student's matriculation no.: ");
					_matric = GetType.getString().toUpperCase();
					if (_matric.equals("q") || _matric.equals("Q")) break;
					if (_matric.length() == 0) System.out.println("\n  Error: Matric no. is required. 'Q' to exit adding student.\n");
					else if (Student.getStudentByMatric(_matric) != null) {
						System.out.println("\n  Error: Another student with that matric no. already exists. Please try again.");
					}
					else matricError = false;
				} while (matricError);

				if (!matricError) {
					int _year = processYear();

					List list = Student.getStudentList();
					Student s = new Student(_name, _email, _contact, _year, _matric, _gender, _address);								
					if (list == null) list = new ArrayList();
					list.add(s);
					s.save(list);			
					System.out.println("\n  Student " + s.getName() + " added!");
				}

				break;

			case '3':
				System.out.print("Enter the student's name: ");
				String name=GetType.getString();
				SearchStudent(name);
				break;

			case '0':
				System.out.println("  Exiting to previous menu...");
				break;
			case 'q':
			case 'Q':
				Menu.terminateMenu();
				break;
			default:
				System.out.println("  Invalid choice.");
			}
		} while (choice != '0' && choice != 'q' && choice != 'Q');
	}

	public static void printStudentList() {
		List list;
		String choice = "f";
		boolean skip = false;

		do {
			System.out.println();
			System.out.println("Students list");
			System.out.println("-----------------------");

			list = getStudentList();
			Collections.sort(list);
			Student.save(list);
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
			choice = GetType.getString();

			switch (choice) {
			case "0":
				System.out.println("  Exiting to previous menu...");
				break;
			case "q":
			case "Q":
				Menu.terminateMenu();
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

		do {
			System.out.println();
			System.out.println("Student profile");
			System.out.println("---------------------");
			System.out.println("Name: " + s.getName());
			System.out.println("Matric: " + s.getMatric());
			System.out.println("Year: " + s.getYear());
			System.out.println("Gender: " + s.getGender());
			System.out.println("Email: " + s.getEmail());
			System.out.println("Contact: " + s.getContact());
			System.out.println("Address: " + s.getAddress());
			System.out.println();
			System.out.println("1) Edit student");
			System.out.println("2) Register for a course");
			System.out.println("3) Show registered courses");
			System.out.println("4) Print transcript");
			System.out.println("D) Delete student");
			System.out.println();
			System.out.println("0) Back to student list");
			System.out.println("Q) Exit program");
			System.out.println("---------------------");
			System.out.print("Enter choice: ");

			choice = GetType.getString();

			switch (choice) {
			case "0":
				System.out.println("  Exiting to student list...");
				break;

			case "1":
				Student.editStudent(s);
				break;

			case "2":

				List<Course> courseList = Course.getCourseList();
				Collections.sort(courseList);
				if (courseList != null && courseList.size() > 0) {
					System.out.println("\nSelect a course from the list");
					System.out.println("-----------------------");

					Course c;

					for (int i = 0; i < courseList.size(); i++) {
						c = (Course) courseList.get(i);
						System.out.println(i + 1 + ") " + c.getCode() + " " + c.getTitle());
					}

					System.out.println("-----------------------");
					System.out.print("Enter choice: ");

					int courseChoice = GetType.getInt() - 1;
					if ( courseChoice >= 0 && courseChoice < courseList.size() ) {
						c = (Course) courseList.get(courseChoice);
						List<Class> classList = c.getClassList();

						if (classList.size() > 0) {
							StudentCourse.register(s.getMatric(), c.getCode());

							if (StudentCourse.isEnrolled(s.getMatric(), c.getCode())) {
								boolean studentFound = false;

								for (int i = 0; i < classList.size(); i++) {
									Class cl = (Class) classList.get(i);
									if (cl.inClass(s)) studentFound = true;
								}

								if (studentFound)
									System.out.println("\n  Student is already enrolled in a class.");

								else {
									System.out.println("Select class");
									System.out.println("-----------------------");
									for (int i = 0; i < classList.size(); i++) {
										Class cl = (Class) classList.get(i);
										System.out.println(i + 1 + ") " + cl.getName() + " (Size: " + cl.getSize() + ", Vacancy: " + cl.getVacancy() + ")");
									}
									System.out.println("-----------------------");
									System.out.print("Enter choice: ");
									int classChoice = GetType.getInt();

									switch (classChoice) {
									default:
										if (classChoice > 0 && classChoice <= classList.size()) {
											try {
												Class cl = classList.get(classChoice-1);
												if (cl.getVacancy() > 0) {
													cl.addStudent(s);
													Course.save(courseList);
												}
												else System.out.println("\n  Could not add student: class " + cl.getName() + " is full.");
											}
											catch (Exception e) {
												System.out.println("\n  Invalid choice.");
											}
										}
										else System.out.println("\n  Invalid choice.");
										break;
									}
								}
							}
						}
						else
							System.out.println("\nThere are no classes available for this course!");
					}
				}

				else {
					System.out.println("\nNo courses are available in the system.");
				}

				break;

			// Show registered courses
			case "3":
				System.out.println("\nRegistered courses:");
				System.out.println("-------------------------");

				courseList = StudentCourse.getStudentCourses(s.getMatric());

				if (courseList.size() > 0) {
					for (int i = 0; i < courseList.size(); i++) {
						Course c = (Course) courseList.get(i);
						System.out.print(i + 1 + ") " + c.getCode() + " " + c.getTitle());

						// Print student's class or 'No class'
						boolean found = false;
						List<Class> classList = c.getClassList();
						for (int o = 0; o < classList.size(); o++) {
							Class cl = classList.get(o);
							if (cl.inClass(s)) {
								System.out.print(" (" + cl.getName() + ")");
								found = true;
							}
						}
						if (!found) System.out.print(" (No class)");
						System.out.println();
					}
					System.out.println("-------------------------");
				}
				else {
					System.out.println("The student is not registered for any courses.");
				}
				break;

			// Print transcript
			case "4":
				s.printTranscript();
				break;
				
			case "d":
			case "D":
				char confirm = 'n';
				System.out.println();
				System.out.println("  Are you sure you want to delete " +  s.getName() + "? This is irreversible.");
				System.out.print("  Enter \"y\" to confirm: ");
				confirm = GetType.getChar();
				if (confirm == 'y') {
					// Update registered course list
					StudentCourse.deleteStudent(s.getMatric());
					// Update component list
					Component.deleteStudent(s);

					String deletedName = s.getName();
					String deletedMatric = s.getMatric();

					List list = getStudentList();
					deleted = list.remove(s);
					s.save(list);
					System.out.println("\n  Deleted " + deletedName + " (" + deletedMatric + ")");
				}
				break;
			case "q":
			case "Q":
				Menu.terminateMenu();
				break;
			}
		}  while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q") && !deleted);

		return deleted;
	}

	private void printTranscript() {
		System.out.println("");
		System.out.println("Academic Transcript");
		System.out.println("--------------------------------");
		System.out.println("Name:              " + getName());
		System.out.println("Matriculation no.: " + matric);
		System.out.println("Year of study:     " + year);
		System.out.println("");
		List courseList = StudentCourse.getStudentCourses(matric);
		// for each course, print score
		int max = 0;
		double totalAU = 0.0, totalGP = 0.0;
		double GPA = 0.0;
		for (int i = 0; i < courseList.size(); i++) {
			Course c = (Course) courseList.get(i);
			if ((c.getCode() + " " + c.getTitle()).length() + 3 > max) max = (c.getCode() + " " + c.getTitle()).length() + 3;
			totalAU += c.getAU();
		}
		for (int i = 0; i < courseList.size(); i++) {
			double score = 0.0;
			Course c = (Course) courseList.get(i);
			// for each component, add marks / weightage to score
			List componentList = Component.getComponentListByCourse(c.getCode());
			for (int o = 0; o < componentList.size(); o++) {
				Component cc = (Component) componentList.get(o);
				score += (double) (cc.getMarks(this) * cc.getWeightage() / 100);
				if (score >= 80) totalGP += 4 * c.getAU();
				else if (score >= 70) totalGP += 3 * c.getAU();
				else if (score >= 60) totalGP += 2 * c.getAU();
				else if (score >= 50) totalGP += c.getAU();
			}
			System.out.println(TextFormat.padRight(c.getCode() + " " + c.getTitle().toUpperCase() + ": ", max) + TextFormat.padRight(TextFormat.scoreToGrade(score), 7) + c.getAU() + " AUs");
		}
		GPA = (double) (totalGP / totalAU);
		NumberFormat df = DecimalFormat.getInstance();
		df.setMinimumFractionDigits(1);
		df.setMaximumFractionDigits(4);
		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println("\nTotal GP: " + totalGP);
		System.out.println("Total AU: " + totalAU);
		System.out.println("\nGPA: " + df.format(GPA));
		System.out.println("--------------------------------");
	}

	private static void editStudent(Student s) {
		String choice = "";

		do {
			System.out.println();
			System.out.println("Edit Student");
			System.out.println("---------------------");
			System.out.println("1) Name: " + s.getName());
			System.out.println("2) Matric: " + s.getMatric());
			System.out.println("3) Year: " + s.getYear());
			System.out.println("4) Gender: " + s.getGender());
			System.out.println("5) Email: " + s.getEmail());
			System.out.println("6) Contact: " + s.getContact());
			System.out.println("7) Address: " + s.getAddress());
			System.out.println();
			System.out.println("0) Back to student list");
			System.out.println("Q) Exit program");
			System.out.println("---------------------");
			System.out.print("Enter choice: ");

			choice = GetType.getString();

			switch (choice) {
			case "0":
				System.out.println("  Exiting to student list...");
				break;

				// Edit name
			case "1":
				s.updateName();
				break;

				// Edit matric no.
			case "2":
				s.updateMatric();
				break;

				// Edit year
			case "3":
				s.updateYear();
				break;

				// Edit gender
			case "4":
				char _gender = processGender("student");
				if (s.getGender() == _gender) System.out.println("\n  No change detected. Original gender preserved.");
				else {
					s.setGender(_gender);
					System.out.println("\n  Changed student's gender to: " + s.getGender());
				}
				break;

				// Edit email
			case "5":
				String _email = processEmail("student");
				if (s.getEmail().equals(_email)) System.out.println("\n  No change detected. Original email preserved.");
				else {
					s.setEmail(_email);
					System.out.println("\n  Changed student's email to: " + s.getEmail());
				}
				break;

				// Edit contact
			case "6":
				int _contact = processContact("student");
				if (s.getContact() == _contact) System.out.println("\n  No change detected. Original contact preserved.");
				else {
					s.setContact(_contact);
					System.out.println("\n  Changed student's contact to: " + s.getContact());
				}
				break;

				// Edit address
			case "7":
				System.out.print("Enter student's address: ");
				String _address = GetType.getString();
				if (_address.length() == 0) _address = "NONE";
				if (s.getAddress().equals(_address)) System.out.println("\n  No change detected. Original address preserved.");
				else {
					s.setAddress(_address);
					System.out.println("\n  Changed student's address to: " + s.getAddress());
				}
				break;

			case "q":
			case "Q":
				Menu.terminateMenu();
				break;
			}
		} while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q"));
	}

	public static void save(List list) {
		SerializeDB.writeSerializedObject("student.dat", list);
	}
	public int compareTo(Student s) {
		int lastCmp = super.getName().compareTo(s.getName());
		return (lastCmp != 0 ? lastCmp : super.getName().compareTo(s.getName()));
	}

	public static void SearchStudent(String searchStr)
	{
		List list=getStudentList();
		int count = 0;
		if (list != null && list.size() > 0) {
			System.out.println();
			System.out.println("Search results:");
			System.out.println("---------------------");
			for (int i = 0 ; i < list.size() ; i++) {
				Student s = (Student)list.get(i);
				if (s.getName().toLowerCase().contains(searchStr.toLowerCase()) || s.getMatric().toUpperCase().contains(searchStr.toUpperCase())) {
					System.out.println(count + 1 + ") " + s.getName() + " (" + s.getMatric() + ")");
					count++;
				}
			}
		}
		if (count > 0) System.out.println("\nTotal " + count + " results found.");
		else System.out.println("That search query return 0 results.");
	}
}
