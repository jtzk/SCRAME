package scrame;

import java.util.Scanner;

public class GetType {
    
	public char getChar() {
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
	
	public int getInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = sc.nextInt();
		}
		catch (Exception e) {
		}
	
		return i;
	}
	
	public String getString() {
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
