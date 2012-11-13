package scrame;

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
		 int max=100;
		 int remain=CourseComponent.sumUpAll(_courseCode);
		 int componentAmount=0,choice=0,sumUpAll=0;
		 
		 if (CourseComponent.sumUpAll(_courseCode)==max)
				System.out.println("Component percent completed");		
		 
		 while(CourseComponent.sumUpAll(_courseCode)<max)
		 {
			 	int remainR=100-CourseComponent.sumUpAll(_courseCode);
			 	System.out.println("Remain "+remainR);
				System.out.println("");
				System.out.println("Select the component");
				System.out.println("--------------------------------------------");
				System.out.println("1)Assignment");
				System.out.println("2)Quiz");
				System.out.println("3)Report");
				System.out.println("4)Exam");	
				System.out.println("5)Tutorial");
				System.out.print("\nEnter your choice => ");
				choice= GetType.getInt();
				
				sumUpAll=CourseComponent.sumUpAll(_courseCode);
				switch (choice)
				{
					
					case 1:
						if(sumUpAll<max)
							remain=Assignment.addAssignment(_courseCode, remainR);
						break;
						
					case 2:
						if(sumUpAll<max)
							remain=Quiz.addQuiz(_courseCode, remainR);
						break;
						
					case 3:
						if(sumUpAll<max)
							remain=Report.addReport(_courseCode, remainR);
						break;
						
					case 4: 
						if(sumUpAll<max)
							remain=Exam.addExam(_courseCode,remainR);

						break;
						
					case 5:
						if(sumUpAll<max)
							remain=TutorialEx.addTutorial(_courseCode, remainR);
						break;
						
					default:
						System.out.println("Invalid Choice");
						break;
				}//end switch
				if (remain==0)
					System.out.println("Component percent completed");
			}//end while
		}
}