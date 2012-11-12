package scrame;


public class Menu {
	private static int max=100;
	private static int balance=0;
	private static int remain=0;
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
	

	public static void CourseComponentMenu(String _courseCode)
		{
			int componentAmount=0,choice=0,sumUp1=0,sumUp2=0,sumUp3=0,sumUp4=0,sumUp5=0;
			System.out.print("Enter component amount: ");
			componentAmount=GetType.getInt();
			while(componentAmount>0)
			{
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
				System.out.println("");
				switch (choice)
				{
					case 1:
						System.out.print("coursecode "+_courseCode);
						sumUp1=Assignment.sumUp(_courseCode);
						System.out.println("total"+sumUp1);
						if(sumUp1<100)
						{
							remain=Assignment.addAssignment(_courseCode, max);
							System.out.print("remain "+remain);
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent not full.");
							}
						}
						
						break;
						
					case 2:
						System.out.print("coursecode "+_courseCode);
						sumUp2=Quiz.sumUp(_courseCode);
						System.out.println("total"+sumUp2);
						if(sumUp2<100)
						{
							remain=Quiz.addQuiz(_courseCode, max);
							System.out.print("remain "+remain);
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent not full.");
							}
						}
						break;
						
					case 3:
						System.out.print("coursecode "+_courseCode);
						sumUp3=Report.sumUp(_courseCode);
						System.out.println("total"+sumUp3);
						if(sumUp3<100)
						{
							remain=Report.addReport(_courseCode, max);
							System.out.print("remain "+remain);
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent not full.");
							}
						}
						break;
						
					case 4: 
						System.out.print("coursecode "+_courseCode);
						sumUp4=Exam.sumUp(_courseCode);
						System.out.println("total"+sumUp4);
						if(sumUp4<100)
						{
							remain=Report.addReport(_courseCode, max);
							System.out.print("remain "+remain);
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent not full.");
							}
						}
						break;
						
					case 5:
						System.out.print("coursecode "+_courseCode);
						
						sumUp5=TutorialEx.sumUp(_courseCode);
						//System.out.println("total"+sumUp);
						if(sumUp5<100)
						{
							remain=TutorialEx.addTutorial(_courseCode, max);
							System.out.println("Remain "+remain + "percent");
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0||componentAmount==0){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent not full.");
							}
						}
						
						break;
						
					default:
						System.out.println("Invalid Choice");
						//increase counter to request user add 1 more component
						componentAmount+=1;
						break;
				}//end switch
				componentAmount--;
			}
			if (remain==0)
			{
				System.out.println("Component percent completed");		
			}
		}
}