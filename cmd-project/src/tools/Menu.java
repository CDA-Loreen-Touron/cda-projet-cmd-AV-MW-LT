package tools;

import models.Hystory;

import models.CommandeIsPrime;

public class Menu {

	private static boolean verif;

	private static final Hystory historique = new Hystory("historique");

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
				historique.ajouterElementList("river");
				System.out.println("Commande en cours de dev");
				break;
			case "isprime":
				historique.ajouterElementList("isprime");
				CommandeIsPrime a=new CommandeIsPrime(null);
				a.executer();
				break;
			case "history":
				historique.executer();
				break;
			case "histclear":
				historique.clear();
				break;
			case "dir":
				System.out.println("Commande en cours de dev");
				break;
			case "dirng":
				historique.ajouterElementList("dirng");
				System.out.println("Commande en cours de dev");
				break;
			case "cd":
				historique.ajouterElementList("cd");
				System.out.println("Commande en cours de dev");
				break;
			case "find":
				historique.ajouterElementList("find");
				System.out.println("Commande en cours de dev");
				break;
			case "cat":
				historique.ajouterElementList("cat");
				System.out.println("Commande en cours de dev");
				break;
			case "copy":
				historique.ajouterElementList("copy");
				System.out.println("Commande en cours de dev");
				break;
			case "crf":
				historique.ajouterElementList("crf");
				System.out.println("Commande en cours de dev");
				break;
			case "crd":
				historique.ajouterElementList("crd");
				System.out.println("Commande en cours de dev");
				break;
			default:
				System.out.println("Commande inconnus");
				break;

			}
		}
	}

}
