package tools;

import models.CommandeCD;
import models.CommandeCat;
import models.CommandeCrf;
import models.CommandeIsPrime;
import models.CommandeRiver;
import models.Help;
import models.Hystory;
import models.Pwd;

public final class Menu {

	private static boolean verif;// false par defaut

	private static final Hystory historique = new Hystory("historique");
	private static final CommandeCat commandeCat = new CommandeCat("cat");
	private static final CommandeCrf commandeCrf = new CommandeCrf("crf");
	private static final CommandeCD commandeCd = new CommandeCD("cd");
	private static String currentDir = "c:\\";

	public static String getCurrentDir() {
		return currentDir;
	}  

	public static void setCurrentDir(String currentDir) {
		Menu.currentDir = currentDir;
	}

	private static String params = "";

	public static void menu() {

		while (!verif) {
			System.out.println(currentDir);

			String choix = EntreeClavier.lireString();
			int indice = choix.indexOf(" ");
			if (indice != -1) {
				params = choix.substring(indice + 1);
				params = params.trim();
				choix = choix.substring(0, indice);
			}

			switch (choix.toLowerCase()) {

			case "help":
				Help help = new Help("help");
				help.executer();
				break;
			case "exit":// le programme s'arrete, n'a plus de possibilit� d'�crire, le programme se
						// ferme, on sort du while
				verif = true;
				System.out.println("Merci au revoir");
				break;
			case "pwd":
				Pwd pwd = new Pwd("PWD");
				pwd.executer();
				break;
			case "quit":// le programme s'arrete
				verif = true;
				System.out.println("Merci au revoir");
				break;
			case "river":
				historique.ajouterElementList("river");
				CommandeRiver river = new CommandeRiver(null);
				river.executer();
				break;
			case "isprime":
				historique.ajouterElementList("isprime" +params);
				CommandeIsPrime a = new CommandeIsPrime(null);
				a.setParam(params);
				a.executer();
				break;
			case "history":
				historique.executer();
				break;
			case "histclear":
				historique.clear();
				break;
			case "dir":
				historique.ajouterElementList("dir");
				break;
			case "dirng":
				historique.ajouterElementList("dirng");
				System.out.println("Commande en cours de dev");
				break;
			case "cd":

				if (indice != -1) {
					historique.ajouterElementList("cd" +params);
					commandeCd.setArgs(params);
					commandeCd.executer();
				}

				break;
			case "find":
				historique.ajouterElementList("find");
				System.out.println("Commande en cours de dev");
				break;
			case "cat":
				if (indice != -1) {
					historique.ajouterElementList("cd" +params);
					commandeCat.setParams(currentDir + "\\" + params);
					commandeCat.executer();

				} else {
					System.out.println("Cette commande prend un param�tre !");
				}

				break;
			case "copy":
				historique.ajouterElementList("copy" +params);
				System.out.println("Commande en cours de dev");
				break;
			case "crf":
				if (indice != -1) {
					historique.ajouterElementList("crf" +params);
					commandeCrf.setParams(currentDir + "\\" + params);
					commandeCrf.executer();

				} else {
					System.out.println("Cette commande prend un param�tre !");
				}

				break;
			case "crd":
				historique.ajouterElementList("crd" +params);
				System.out.println("Commande en cours de dev");
				break;
			default:
				System.out.println("Commande inconnus");
				break;

			}
		}
	}

}
