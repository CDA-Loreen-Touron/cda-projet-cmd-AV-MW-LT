package tools;

import java.util.HashMap;

import models.CommandeCD;
import models.CommandeCRD;
import models.CommandeCat;
import models.CommandeCopy;
import models.CommandeCount;
import models.CommandeCrf;
import models.CommandeDir;
import models.CommandeDirng;
import models.CommandeFind;
import models.CommandeFline;
import models.CommandeGetVars;
import models.CommandeIsPrime;
import models.CommandeRiver;
import models.Help;
import models.Hystory;

public final class Menu {
	private static HashMap<String, String> hm = new HashMap<>();

	private static boolean verif;// false par defaut

	private static String currentDir = "";
	private static final Help help = new Help("help", "Cette commande affiche une description pour chaque commande");
	private static final CommandeIsPrime commandeIsPrime = new CommandeIsPrime("CommandeIsPrime",
			"Cette commande prend en parametre un entier et affiche yes si ce parametre est un nombre premier non sinon");
	private static final CommandeRiver commandeRiver = new CommandeRiver("CommandeRiver",
			"Cette commande prend 2 parametres en entree et affiche la premiere intersection des rivieres obtenues pour ces parametres");
	private static final Hystory historique = new Hystory("historique",
			"Cette commande affiche ,en plus de la commande, les param�tres pass�s � la commande et la date de l�ex�cution de la commande avec ce format 11:40:22 03/10/2018.");
	private static final CommandeFind commandeFind = new CommandeFind("find",
			"cette commande prend en paramètre une chaine de caractère , il permet de retrouver un fichier contenant la chaine , si l'option -starts est utilisé , le fichier recherché commencera par la chaine et si l'option -ends est utilisée le fichier finira par cette chaîne    ");
	private static final CommandeCat commandeCat = new CommandeCat("cat",
			"Cette commande prend en param�tre le nom d'un fichier dans le r�pertoire en cours et afficher son contenu � la console.");
	private static final CommandeCrf commandeCrf = new CommandeCrf("crf",
			"Cette commande prend un param�tre et cr�e un fichier avec ce nom dans le r�pertoire en cours ");
	private static final CommandeCRD commandeCRD = new CommandeCRD("crd",
			"Cette commande prend un param�tre et cr�e un r�pertoire avec ce nom dans le r�pertoire en cours");
	private static final CommandeCD commandeCd = new CommandeCD("cd",
			"Cette commande permet de se d�placer dans un r�pertoire qui existe dans le dossier en cours.");
	private static final CommandeDir commandeDir = new CommandeDir("dir", "affiche le contenu du r�pertoire ", true);
	private static final CommandeDirng commandeDirng = new CommandeDirng("dirng",
			"Cette commande affiche le contenu du r�pertoire en cours,exactement comme la commande dir, mais en plus affiche le nombre de r�pertoire et le nombre de fichier.");
	private static final CommandeGetVars commandeGetVars = new CommandeGetVars("getVars",
			"cette commande pertmet d'afficher les variable d'environnement avec l'option : -env et les propriétés de la jvm avec l'option : -prop si pas d'option les propriétés et les variables d'environnement sont affichées");
	private static final CommandeCopy commandeCopy = new CommandeCopy("copy",
			" cette commande permet de copier un fichier grâce a un autre fichier source");
	private static final CommandeFline commandeFline = new CommandeFline("fline",
			"cette commande permet : d'afficher le nombre de lignes du fichier grâce à l'option -n , de débuter la recherhce à partir d'une certaine ligne grâce à l'option -d , finir la recherche à une certaine ligne grâce à l'option -f et de recherche un mot dans un ligne et de l'afficher grâce à l'option -s ");
	private static final CommandeCount commandeCount = new CommandeCount("count",
			" cette commande permet de  compter les dossiers et fichiers du  dossier en cours. Pour compter les dossiers et fichiers dans les sous-dossiers, entrer -r en option. -d affiche le nombre de dossiers et -f le nombre de fichiers. ");

	public static String getCurrentDir() {
		return currentDir;
	}

	public static void setCurrentDir(String currentDir) {
		Menu.currentDir = currentDir;
	}

	private static String params = "";

	public static void menu() {

		if (System.getProperty("cdi.default.folder") != null) {
			currentDir = System.getProperty("cdi.default.folder");
		} else {
			currentDir = System.getProperty("user.home");
		}

		hm.put(commandeCat.getNom(), commandeCat.getDescription());
		hm.put(commandeIsPrime.getNom(), commandeIsPrime.getDescription());
		hm.put(commandeRiver.getNom(), commandeRiver.getDescription());
		hm.put(historique.getNom(), historique.getDescription());
		hm.put(commandeCrf.getNom(), commandeCrf.getDescription());
		hm.put(commandeCRD.getNom(), commandeCRD.getDescription());
		hm.put(commandeCd.getNom(), commandeCd.getDescription());
		hm.put(commandeDir.getNom(), commandeDir.getDescription());
		hm.put(commandeDirng.getNom(), commandeDirng.getDescription());
		hm.put(commandeCount.getNom(), commandeCount.getDescription());
		hm.put(commandeCopy.getNom(), commandeCopy.getDescription());
		hm.put(commandeGetVars.getNom(), commandeGetVars.getDescription());
		hm.put(help.getNom(), help.getDescription());

		help.setHm(hm);

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
				help.executer();
				break;

			case "exit":// le programme s'arrete, n'a plus de possibilit� d'�crire, le programme se

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
					commandeCd.executer(params);
				} else {
					commandeCd.executer();
				}

				break;

			case "find":
				if (indice != -1) {
					historique.ajouterElementList("find");
					commandeFind.determineOption(params);
					commandeFind.executer(currentDir);
					commandeFind.getCompteur();
				} else {
					commandeFind.executer();
				}

				break;

			case "cat":
				if (indice != -1) {
					historique.ajouterElementList("cd" + params);
					commandeCat.executer(params);

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
					commandeCrf.executer(params);

				} else {
					commandeCrf.executer();
				}

				break;

			case "crd":
				if (indice != -1) {
					historique.ajouterElementList("crd");
					commandeCRD.executer(params);

				} else {
					commandeCRD.executer();
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
			case "fline":
				if (indice != -1) {
					historique.ajouterElementList("getvars");
					commandeFline.executer(currentDir + "\\" + params);

				} else {
					commandeFline.executer();
				}

				break;

			case "count":
				if (indice != -1) {
					historique.ajouterElementList("count");

					commandeCount.executer(params);

				} else {
					commandeCount.executer();
				}

				break;

			default:
				System.out.println("Commande inconnus");
				break;

			}

		}
	}

}
