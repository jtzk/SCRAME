package scrame;

import java.util.Scanner;

public class GetType {
    
	public static char getChar() {
		Scanner sc = new Scanner(System.in);
		char choice = '\u0000';//(NULL)
		try {
			String input = sc.nextLine();
			choice = input.charAt(0);
		}
		catch (Exception e) {
		}
		
		return choice;
		
	}
	
	public static int getInt() throws NumberFormatException {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = sc.nextInt();
		}
		catch (Exception e) {
			throw new NumberFormatException("Not an integer.");
		}
	
		return i;
	}
	
	public static String getString() {
		Scanner sc = new Scanner(System.in);
		String text = null;
		try {
			text = sc.nextLine();
		}
		catch (Exception e) {
		}		

		return text;
	}
	

}
