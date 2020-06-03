package tools;

import models.CommandeCD;
import models.CommandeCRD;
import models.CommandeCat;
import models.CommandeCopy;
import models.CommandeCount;
import models.CommandeCrf;
import models.CommandeDir;
import models.CommandeDirng;
import models.CommandeFind;
import models.CommandeGetVars;
import models.CommandeIsPrime;
import models.CommandeRiver;
import models.Help;
import models.Hystory;

public final class Menu {

	private static boolean verif;// false par defaut
	private static final Hystory historique = new Hystory("historique");
	private static final CommandeCat commandeCat = new CommandeCat("cat");
	private static final CommandeCrf commandeCrf = new CommandeCrf("crf");
	private static final CommandeCRD commandeCRD = new CommandeCRD("crd");
	private static final CommandeCD commandeCd = new CommandeCD("cd");
	private static final CommandeIsPrime commandeIsPrime= new CommandeIsPrime("isprime");
	private static final CommandeRiver commandeRiver= new CommandeRiver("river");
	private static String currentDir = "C:\\";
	private static final CommandeDir commandeDir = new CommandeDir("dir");
	private static final CommandeDirng commandeDirng = new CommandeDirng("dirng");
	private static final CommandeCopy commandeCopy= new CommandeCopy("copy");
	private static final CommandeFind commandeFind = new CommandeFind("find");
	private static final CommandeGetVars commandeGetVars = new CommandeGetVars("getvars");
	private static final CommandeCount commandeCount = new CommandeCount("getvars");
	public static String getCurrentDir() {
		return currentDir;
	}

	public static void setCurrentDir(String currentDir) {
		Menu.currentDir = currentDir;
	}

	private static String params = "";

	public static void menu() {

		while (!verif) {

			

			String choix = EntreeClavier.lireString();
			int indice = choix.indexOf(" ");
			if (indice != -1) {
				params = choix.substring(indice + 1);
				params = params.trim();

				choix = choix.substring(0, indice);
			}

			switch (choix.toLowerCase()) {// The method toLowerCase() converts the characters of a String into lower
											// case characters

			case "help":
				Help help = new Help("help");
				help.executer();
				break;
			case "exit":// le programme s'arrete, n'a plus de possibilité d'écrire, le programme se
						// ferme, on sort du while
				verif = true;
				System.out.println("Merci au revoir");
				break;

			case "pwd":
				System.out.println(currentDir);
				break;

			case "quit":// le programme s'arrete
				verif = true;
				System.out.println("Merci au revoir");
				break;
			case "river":
				if (indice != -1) {
					historique.ajouterElementList("river");				
					commandeRiver.executer(params);
				} else {
					System.out.println("Cette commande prend un paramètre !");
				}
				break;
			case "isprime":
				if (indice != -1) {
					historique.ajouterElementList("isprime" + params);
					commandeIsPrime.executer(params);
					
				} else {
					System.out.println("Cette commande prend un param�tre !");
				}
				break;
			case "history":
				historique.executer();
				break;
			case "histclear":
				historique.clear();
				break;
			case "dir":
				historique.ajouterElementList("dir");
				commandeDir.executer(currentDir);
				break;
			case "dirng":
				historique.ajouterElementList("dirng");
				commandeDirng.executer(currentDir);
				break;
			case "cd":

				if (indice != -1) {
					historique.ajouterElementList("cd" + params);
					commandeCd.setArgs(params);
					commandeCd.executer();
				}

				break;
			case "find":
				if(indice!=-1) {
					historique.ajouterElementList("find");
					commandeFind.determineOption(params);
					commandeFind.executer(currentDir);
					commandeFind.getCompteur();
				}else {
					commandeFind.executer();
				}
				
				break;
			case "cat":
				if (indice != -1) {
					historique.ajouterElementList("cd" + params);
					commandeCat.setParams(currentDir + "\\" + params);
					commandeCat.executer();

				} else {
					System.out.println("Cette commande prend un paramètre !");
				}

				break;
			case "copy":
				if (indice != -1) {
					historique.ajouterElementList("copy" + params);
					String paramètres = currentDir + "\\" + params;
					commandeCopy.executer(paramètres);
				} else {
					System.out.println("Cette commande prend un paramètre !");
				}
				break;
			case "crf":
				if (indice != -1) {
					historique.ajouterElementList("crf" + params);
					commandeCrf.setParams(currentDir + "\\" + params);
					commandeCrf.executer();

				} else {
					System.out.println("Cette commande prend un paramètre !");
				}

				break;
			case "crd":
				if (indice != -1) {
					historique.ajouterElementList("crd");
					commandeCRD.setParams(currentDir + "/" + params);
					commandeCRD.executer();

				} else {
					System.out.println("Cette commande prend un paramètre !");
				}

				break;
			case "getvars":
				if (indice != -1) {
					historique.ajouterElementList("getvars");
					commandeGetVars.executer(params); 

				} else {
					commandeGetVars.executer(); 
				}

				break;
			default:
				System.out.println("Commande inconnus");
				break;

			}
		}
	}

}
