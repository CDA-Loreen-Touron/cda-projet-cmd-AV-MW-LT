package tools;

import models.CommandeCD;
import models.CommandeCRD;
import models.CommandeCat;
import models.CommandeCrf;
import models.CommandeDir;
import models.CommandeDirng;
import models.CommandeIsPrime;
import models.CommandeRiver;
import models.Help;
import models.Hystory;
import models.Pwd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Menu {

	private static boolean verif;// false par defaut
	
	private static final CommandeIsPrime commandeIsPrime = new CommandeIsPrime ("CommandeIsPrime","Cette commande prend en paramètre un entier et affiche yes si ce paramètre est un nombre premier non sinon");
	private static final CommandeRiver commandeRiver = new CommandeRiver ("CommandeRiver","Cette commande prend 2 paramètres en entrée et affiche la première intersection des rivières obtenues pour ces paramètres");
	private static final Hystory historique = new Hystory("historique", "Cette commande affiche ,en plus de la commande, les paramètres passés à la commande et la date de l’exécution de la commande avec ce format 11:40:22 03/10/2018.");
	private static final CommandeCat commandeCat = new CommandeCat("cat", "Cette commande prend en paramètre le nom d'un fichier dans le répertoire en cours et afficher son contenu à la console.");
	private static final CommandeCrf commandeCrf = new CommandeCrf("crf", "Cette commande prend un paramètre et crée un fichier avec ce nom dans le répertoire en cours ");
	private static final CommandeCRD commandeCRD = new CommandeCRD("crd", "Cette commande prend un paramètre et crée un répertoire avec ce nom dans le répertoire en cours");
	private static final CommandeCD commandeCd = new CommandeCD("cd", "Cette commande permet de se déplacer dans un répertoire qui existe dans le dossier en cours.");
	private static String currentDir = "c:\\";
	private static final CommandeDir commandeDir = new CommandeDir ("dir", "affiche le contenu du répertoire ", true);
	private static final CommandeDirng commandeDirng = new CommandeDirng("dirng", "Cette commande affiche le contenu du répertoire en cours,exactement comme la commande dir, mais en plus affiche le nombre de répertoire et le nombre de fichier.");
	//private static final CommandeGetVars commandeGetVars = new CommandeGetVars ("","");
	
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

			switch (choix.toLowerCase()) {//The method toLowerCase() converts the characters of a String into lower case characters

			case "help":
				Help help = new Help("help", "Cette commande affiche une description pour chaque commande");
				help.executer();
				break;
				
			case "exit":// le programme s'arrete, n'a plus de possibilitï¿½ d'ï¿½crire, le programme se
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
				if (indice != -1) {
					historique.ajouterElementList("river" +params);
					commandeRiver.setParam(currentDir + "\\" + params);
					commandeRiver.executer();
				} else {
					System.out.println("Cette commande prend un paramï¿½tre !");
				}
				
		
			case "isprime":
				if (indice != -1) {
					historique.ajouterElementList("isprime" +params);
					commandeIsPrime.setParam(currentDir + "\\" + params);
					commandeIsPrime.executer();
				} else {
					System.out.println("Cette commande prend un paramï¿½tre !");
				}
				
			case "history":
				historique.executer();
				break;
				
			case "histclear":
				historique.clear();
				break;
				
			case "dir":
				historique.ajouterElementList("dir");
				commandeDir.setParams(currentDir);
				commandeDir.executer();
				break;
				
			case "dirng":
				historique.ajouterElementList("dirng");
				commandeDirng.setParams(currentDir);
				commandeDirng.executer();
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
					System.out.println("Cette commande prend un paramï¿½tre !");
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
					System.out.println("Cette commande prend un paramï¿½tre !");
				}

				break;
				
			case "crd":
				if (indice != -1) {
					historique.ajouterElementList("crd");
					commandeCRD.setParams(currentDir + "/" + params);
					commandeCRD.executer();

				} else {
					System.out.println("Cette commande prend un paramï¿½tre !");
				}

				break;
				
			default:
				System.out.println("Commande inconnus");
				break;

			}
		}
	}

}
