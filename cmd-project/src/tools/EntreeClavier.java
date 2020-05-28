package tools;

import java.util.Scanner;

public class EntreeClavier {
	private static Scanner sc = new Scanner(System.in);
	
	
	public static String lireString() {
		
		System.out.print(">");
		String choix = sc.nextLine();
		choix = choix.trim();//supprime les espaces avant et apres lettres
		return choix;
	}
	
	
	public static int lireInt() {
		
		System.out.println(">");
		int value = 0;
		try {
			value = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Veuillez rentrez un chiffre !");
		}
		return value;
	}

}
