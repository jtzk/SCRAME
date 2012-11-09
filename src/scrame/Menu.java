package scrame;

public class Menu {
	public void showMenu() {
		System.out.println();
		System.out.println("Please choose an option from the menu below:");
		System.out.println("--------------------------------------------");
		System.out.println("1) Professors");
		System.out.println("2) Students");
		System.out.println("3) Courses");
		System.out.println("--------------------------------------------");
		System.out.print("Enter choice: ");
	}
	
	public void showMenu(String MenuTitle) {
		System.out.println();
		System.out.println(MenuTitle + " Menu");
		System.out.println("-----------------------");
		System.out.println("1) List " + MenuTitle);
		System.out.println("2) Add a "+ MenuTitle);
		System.out.println("3) Search for " + MenuTitle);
		System.out.println();
		System.out.println("0) Back to main menu");
		System.out.println("Q) Exit program");
		System.out.println("-----------------------");
	}
	
	public void terminateMenu() {
		System.out.println();
		System.out.println("Terminating application...");
		System.exit(0);
	}
}
