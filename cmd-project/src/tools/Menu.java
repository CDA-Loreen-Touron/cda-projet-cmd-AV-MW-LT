package tools;

import java.util.Scanner;

public class Menu {

	private static boolean verif;

	public static void menu() {
		while (!verif) {

			String choix = EntreeClavier.lireString();

			switch (choix.toLowerCase()) {

			case "help":
				System.out.println("Commande en cours de dev");
				break;
			case "exit":
				System.out.println("Commande en cours de dev");
				break;
			case "pwd":
				System.out.println("Commande en cours de dev");
				break;
			case "quit":
				System.out.println("Commande en cours de dev");
				break;
			case "river":
				System.out.println("Commande en cours de dev");
				break;
			case "isprime":
				System.out.println("Commande en cours de dev");
				break;
			case "history":
				System.out.println("Commande en cours de dev");
				break;
			case "histclear":
				System.out.println("Commande en cours de dev");
				break;
			case "dir":
				System.out.println("Commande en cours de dev");
				break;
			case "dirng":
				System.out.println("Commande en cours de dev");
				break;
			case "cd":
				System.out.println("Commande en cours de dev");
				break;
			case "find":
				System.out.println("Commande en cours de dev");
				break;
			case "cat":
				System.out.println("Commande en cours de dev");
				break;
			case "copy":
				System.out.println("Commande en cours de dev");
				break;
			case "crf":
				System.out.println("Commande en cours de dev");
				break;
			case "crd":
				System.out.println("Commande en cours de dev");
				break;
			default:
				System.out.println("Commande inconnus");
				break;

			}
		}
	}

}
