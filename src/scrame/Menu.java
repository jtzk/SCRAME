package scrame;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

	public static void showMenu() {
		System.out.println();
		System.out.println("Please choose an option from the menu below:");
		System.out.println("--------------------------------------------");
		System.out.println("1) Professors");
		System.out.println("2) Students");
		System.out.println("3) Courses");
		System.out.println("4) Course components");
		System.out.println("5) Rawcases");
		System.out.println("--------------------------------------------");
		System.out.print("Enter choice: ");
	}

	public static void showMenu(String MenuTitle) {
		System.out.println();
		System.out.println(MenuTitle + " Menu");
		System.out.println("-----------------------");		
		System.out.println("1) List " + MenuTitle.toLowerCase() + "s");
		System.out.println("2) Add a "+ MenuTitle.toLowerCase());
		System.out.println("3) Search for " + MenuTitle.toLowerCase());
		System.out.println();
		System.out.println("0) Back to main menu");
		System.out.println("Q) Exit program");
		System.out.println("-----------------------");
	}

	public static void showMenu2(String MenuTitle) {
		System.out.println();
		System.out.println(MenuTitle + " Menu");
		System.out.println("-----------------------");
		System.out.println("1) List " + MenuTitle.toLowerCase() + "s");
		System.out.println("2) Search for " + MenuTitle.toLowerCase());
		System.out.println();
		System.out.println("0) Back to main menu");
		System.out.println("Q) Exit program");
		System.out.println("-----------------------");
	}
	public static void terminateMenu() {
		System.out.println();
		System.out.println("Terminating application...");
		System.exit(0);
	}


	public static void courseComponentMenu(String _courseCode)
	{
		String choice="";
		Course c = Course.getCourseByCode(_courseCode);
		boolean deleted = false;

		do {
			
			System.out.println("");
			System.out.println(c.getCode() + " (" + c.getTitle() + ") Components");
			System.out.println("----------------------");

			List componentList = Component.getComponentListByCourse(_courseCode);
			Collections.sort(componentList);
			
			if (componentList.size() > 0) {
				int totalWeightage = 0;
				
				for (int i = 0; i < componentList.size(); i++) {
					Component cc = (Component) componentList.get(i);
					System.out.println(i + 1 + ") " + TextFormat.capitalize(cc.getType()) + ": " + cc.getName() + " (" + cc.getWeightage() + "%)");
					totalWeightage += cc.getWeightage();
				}
				System.out.println("\nTotal weightage: " + totalWeightage + "%");
				if (totalWeightage > 100)
					System.out.println("WARNING: Total weightage is more than 100%");
				else if (totalWeightage < 100)
					System.out.println("WARNING: Total weightage is less than 100%");
			}
			else
				System.out.println("There are no components for this course.");
			
//			System.out.println("1) Assignment (" + Assignment.getPercent(_courseCode) + "%)");
//			System.out.println("2) Quiz (" + Quiz.getPercent(_courseCode) + "%)");
//			System.out.println("3) Report (" + Report.getPercent(_courseCode) + "%)");
//			System.out.println("4) Exam (" + Exam.getPercent(_courseCode) + "%)");	
//			System.out.println("5) Tutorial (" + TutorialEx.getPercent(_courseCode) + "%)");
//			System.out.println("");
//			System.out.println("Total: " + sumUpAll + "%");
			System.out.println("");
			System.out.println("a) Add a component");
			System.out.println("");
			System.out.println("0) Back to course list");
			System.out.println("Q) Exit program");
			System.out.println("----------------------");
			System.out.print("Enter choice: ");

			choice= GetType.getString();

			String componentChoice = "";

			switch (choice)
			{
			case "a":
				do {
					System.out.println("");
					System.out.println("Add component");
					System.out.println("----------------");
					System.out.println("1) Add assignment (for Tutorial/Lab assignments/reports)");
					System.out.println("2) Add attendance (for Tutorial/Lab/Lecture attendance marks)");
					System.out.println("3) Add quiz (for quizzes/tests)");
					System.out.println("4) Add exam (for exams)");
					System.out.println("");
					System.out.println("0) Back to " + c.getCode() + " components list");
					System.out.println("Q) Exit program");
					System.out.println("----------------");
					System.out.print("Enter choice: ");
					
					componentChoice = GetType.getString();
					
					String _type;
					
					switch (componentChoice) {
					case "1":
						_type = "assignment";
						Component newCC = new Component(c.getCode(), 0, _type, "");
						newCC.processNewComponent();
						break;
						
					case "2":
						_type = "attendance";
						newCC = new Component(c.getCode(), 0, _type, "");
						newCC.processNewComponent();
						break;
						
					case "3":
						_type = "quiz";
						newCC = new Component(c.getCode(), 0, _type, "");
						newCC.processNewComponent();
						break;
						
					case "4":
						_type = "exam";
						newCC = new Component(c.getCode(), 0, _type, "");
						newCC.processNewComponent();
						break;
						
					case "0":
						System.out.println("\n  Exiting to " + c.getCode() + " components list...");
						break;
						
					case "q":
					case "Q":
						Menu.terminateMenu();
						break;
						
					default:
						System.out.println("\n  Invalid choice.");
					}
				} while (!componentChoice.equals("0"));
				break;

			case "0":
				System.out.println("\n  Exiting to course list...");
				break;

			case "q":
			case "Q":
				Menu.terminateMenu();
				break;

			default:
				int choiceInt;
				try {
					choiceInt = Integer.parseInt(choice);
					if (choiceInt > 0 && choiceInt <= componentList.size()) {
						do {
							Component cc = (Component) componentList.get(choiceInt-1);
							int studentCount = StudentCourse.countStudentsByCourse(c.getCode());
							
							System.out.println("");
							System.out.println(c.getCode() + ": " + TextFormat.capitalize(cc.getType()) + " " + cc.getName());
							System.out.println("------------------");
							System.out.println("Weightage: " + cc.getWeightage() + "%");
							System.out.println("Average score: " + new DecimalFormat("#.##").format(cc.getTotalScore() / studentCount));
							System.out.println("");
							System.out.println("1) Edit " + cc.getType() + " name");
							System.out.println("2) Edit weightage");
							System.out.println("3) Student marks");
							System.out.println("D) Delete component");
							System.out.println("");
							System.out.println("0) Back to components menu");
							System.out.println("Q) Exit program");
							System.out.println("------------------");
							System.out.print("Enter choice: ");
							componentChoice = GetType.getString();
		
							switch (componentChoice) {
							case "1":
								System.out.println("");
								System.out.print("Enter new name: ");
								
								String _name = GetType.getString();
								
								if (_name.length() > 0) {
									if (cc.getName().equals(_name))
										System.out.println("\n  No change detected. Original name preserved.");
									else if (Component.componentExists(cc.getType(), _name)) {
										System.out.println("\n  " + TextFormat.capitalize(cc.getType()) + " " + _name + " already exists.");
									}
									else {
										cc.setName(_name);
										componentList.set(choiceInt-1, cc);
										Component.save(componentList);
									}
								}
								else
									System.out.println("\n  Invalid name.");
								
								break;
								
							case "2":
								System.out.println("");
								System.out.print("Enter new weightage: ");
		
								int _weightage = 0;
		
								try {
									_weightage = GetType.getInt();
									
									if (_weightage > 0) {
										cc.setWeightage(_weightage);
										componentList.set(choiceInt-1, cc);
										Component.save(componentList);
									}
									else {
										System.out.println("\n  Invalid weightage. Component weightage has to be more than 0%.");
									}
								}
								catch (Exception e) {
									System.out.println("\n  Invalid weightage. Only digits are allowed");
								}
								break;
								
							case "3":
								String marksChoice = "";
								do {
									List registerList = StudentCourse.getRegisterList();
									List studentList = new ArrayList();
									System.out.println("");
									System.out.println(TextFormat.capitalize(cc.getType()) + " " + cc.getName() + " Mark list");
									System.out.println("------------------------------");

									for (int i = 0; i < registerList.size(); i++) {
										StudentCourse r = (StudentCourse) registerList.get(i);
										if (r.getCourse().equals(c.getCode())) {
											Student s = Student.getStudentByMatric(r.getStudent());
											studentList.add(s);
											System.out.println(studentList.size() + ") " + s.getName() + " (" + s.getMatric() + "): " + cc.getMarks(s));
										}
									}
									System.out.println();
									System.out.println("0) Back to " + TextFormat.capitalize(cc.getType()) + " " + cc.getName() + " menu");
									System.out.println("Q) Exit program");
									System.out.println("------------------------------");
									System.out.print("Enter choice: ");
									
									marksChoice = GetType.getString();
									
									switch (marksChoice) {
									case "0":
										System.out.println("\n  Exiting to " + TextFormat.capitalize(cc.getType()) + " " + cc.getName() + " menu...");
										break;
										
									case "q":
									case "Q":
										Menu.terminateMenu();
										break;
										
									default:
										try {
											int studentChoice = Integer.parseInt(marksChoice);
											if (studentChoice > 0 && studentChoice <= studentList.size()) {
												Student s = (Student) studentList.get(studentChoice-1);
												
												System.out.println("");
												System.out.println(s.getName() + " (" + s.getMatric() + ")");
												System.out.println("----------------------");
												System.out.println(TextFormat.capitalize(cc.getType()) + " " + cc.getName() + " marks: " + cc.getMarks(s));
												System.out.println("");
												System.out.print("Enter new marks: ");
												
												try {
													int studentMarks = GetType.getInt();
													if (studentMarks > 100)
														System.out.println("\n  Invalid marks. Cannot be more than 100%");
													else if (studentMarks < 0)
														System.out.println("\n  Invalid marks. Cannot be less than 0%");
													else {
														cc.setMarks(s, studentMarks);
														componentList.set(choiceInt-1, cc);
														Component.save(componentList);
													}
												}
												catch (Exception e) {
													System.out.println("\n  Invalid mark. Only digits are allowed");
												}
												
											}
											else
												System.out.println("\n  Invalid choice.");
										}
										catch (Exception e) {
											System.out.println("\n  Invalid choice.");
										}
										break;
									}
								} while (!marksChoice.equals("0"));
								break;
								
							case "d":
							case "D":
								char confirm = 'n';
								System.out.println();
								System.out.println("  Are you sure you want to delete " +  TextFormat.capitalize(cc.getType()) + " " + cc.getName() + "? This is irreversible.");
								System.out.print("  Enter \"y\" to confirm: ");
								confirm = GetType.getChar();
								if (confirm == 'y') {
									String deletedType = TextFormat.capitalize(cc.getType());
									String deletedName = cc.getName();
									deleted = componentList.remove(cc);
									Component.save(componentList);
									System.out.println("\n  Deleted " + deletedType + " " + deletedName);
								}
								break;
		
							case "0":
								System.out.println("\n  Exiting to components menu...");
								break;
		
							case "q":
							case "Q":
								Menu.terminateMenu();
								break;
		
							default:
								System.out.println("\n  Invalid choice.");
								break;
							}
						} while (!componentChoice.equals("0") && !deleted);
					}
					else
						System.out.println("\n  Invalid choice.");
				}
				catch (Exception e) {
					System.out.println("\n  Invalid choice.");
				}
				break;
			}//end switch
		} while (!choice.equals("0") && !choice.equals("q") && !choice.equals("Q"));
	}
}