package tools;


import models.Cat;
import models.CommandeIsPrime;
import models.CommandeRiver;
import models.Help;
import models.Hystory;
import models.Pwd;


public class Menu {

	private static boolean verif;

	private static final Hystory historique = new Hystory("historique");
	private static final Cat commandeCat = new Cat("cat");
	private static String currentDir ="";
	private static String params = "";

	public static void menu() {
		while (!verif) {
			currentDir=System.getProperty("user.dir");
			System.out.println(currentDir);
			String choix = EntreeClavier.lireString(); 
			int indice = choix.indexOf(" ");
			if(indice!= -1) {
				params =choix.substring(indice+1);
				choix = choix.substring(0,indice);
			}
			switch (choix.toLowerCase()) {

			case "help":
				Help help = new Help ("help");
				help.executer();
				break;
			case "exit":
				System.out.println("Commande en cours de dev");
				break;
			case "pwd":
				Pwd pwd = new Pwd ("PWD");
				pwd.executer();
				break;
			case "quit":
				if (choix.equals("quit")) {
				System.out.println("Merci au revoir");
				}
				break;
			case "river":
				historique.ajouterElementList("river");
				CommandeRiver river= new CommandeRiver(null);
				river.executer();
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
				if(indice!=-1) {
					historique.ajouterElementList("cat");
					commandeCat.setParams(params);
					commandeCat.executer();
					
				}else {
					System.out.println("Cette commande prend un paramètre !");
				}
				
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
