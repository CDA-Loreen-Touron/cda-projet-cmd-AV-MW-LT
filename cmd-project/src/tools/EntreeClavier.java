package tools;

import java.util.Scanner;

public class EntreeClavier {
	private static Scanner sc = new Scanner(System.in);
	
	
	public static String lireString() {
		
		System.out.print(">");
		String choix = sc.nextLine();
		choix = choix.trim();
		
		return choix;
	}
	
	
	public static int lireInt() {
		
		System.out.println(">");

			int value = sc.nextInt();
			return value;
		
	}

}