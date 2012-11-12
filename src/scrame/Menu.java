package scrame;

public class Menu {
	private int max=100;
	private int balance=0;
	private int remain=0;
	public static void showMenu() {
		System.out.println();
		System.out.println("Please choose an option from the menu below:");
		System.out.println("--------------------------------------------");
		System.out.println("1) Professors");
		System.out.println("2) Students");
		System.out.println("3) Courses");
		System.out.println("4) Rawcases");
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
	

	public  void CourseComponentMenu(String _courseCode)
		{
			int componentAmount=0,choice=0,sumUp=0;
			System.out.print("Enter component amount: ");
			componentAmount=GetType.getInt();
			while(componentAmount>0)
			{
				System.out.println("Select the component");
				System.out.println("1)Assignment");
				System.out.println("2)Quiz");
				System.out.println("3)Report");
				System.out.println("4)Exam");	
				System.out.println("5)Tutorial");
				System.out.printf("\nEnter your choice => ");
				choice= GetType.getInt();
				switch (choice)
				{
					case 1:
//						System.out.print("coursecode "+_courseCode);
//						sumUp=Assignment.sumUp(_courseCode);
//						System.out.println("total"+sumUp);
//						if(sumUp<100)
//						{
//							remain=Assignment.add(_courseCode, max);
//							System.out.print("remain "+remain);
//							if (remain==-1){
//								//increase counter to request user add 1 more component
//								componentAmount+=1;
//								System.out.println("Component percent exceeded.");
//							}
//							else if(remain >0){
//								//increase counter to request user add 1 more component
//								componentAmount+=1;
//								System.out.println("Component percent not full.");
//							}
					//	}
						
						
						break;
						
					case 2:
						
						break;
						
					case 3:
						
						break;
						
					case 4: 
							
						break;
						
					case 5:
						System.out.print("coursecode "+_courseCode);
						
						sumUp=TutorialEx.sumUp(_courseCode);
						//System.out.println("total"+sumUp);
						if(sumUp<100)
						{
							remain=TutorialEx.addTutorial(_courseCode, max);
							//System.out.print("remain "+remain);
							if (remain==-1){
								//increase counter to request user add 1 more component
								componentAmount+=1;
								System.out.println("Component percent exceeded.");
							}
							else if(remain >0&&componentAmount==0){
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
		}
}