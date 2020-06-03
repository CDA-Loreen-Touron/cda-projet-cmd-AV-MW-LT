package models;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.Menu;

public class CommandeCD extends Commande {

	public CommandeCD(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override

	public void executer() {
		System.out.println("cette commande prend un paramètre !");
	}

	@Override
	public void executer(String pParams) {
		Pattern p = Pattern.compile("^\\W{1,}$");
		Matcher m = p.matcher(pParams);

		if (m.find()) {
			if (pParams.equals("..")) {
				if (!Menu.getCurrentDir().equals("C:")) {
					int lastBackSlash = Menu.getCurrentDir().lastIndexOf('\\');
					Menu.setCurrentDir(Menu.getCurrentDir().substring(0, lastBackSlash));
				}

			} else {
				System.out.println("Le chemin d'accès spécifié est introuvable");
			}
		} else if (new File(pParams).isDirectory()) {
			pParams = pParams.replace('/', '\\');
			Menu.setCurrentDir(pParams);
		}

		else {

			pParams = pParams.replace("/", "\\");

			if (!Menu.getCurrentDir().equals("C:\\")) {
				File directory = new File(Menu.getCurrentDir() + "\\" + pParams);

				if (directory.isDirectory()) {
					Menu.setCurrentDir(Menu.getCurrentDir() + "\\" + pParams);
				} else {
					System.out.println("Le chemin d'accès spécifié est introuvable");
				}
			} else {
				File directory = new File(Menu.getCurrentDir() + pParams);

				if (directory.isDirectory()) {
					Menu.setCurrentDir(Menu.getCurrentDir() + pParams);
				} else {
					System.out.println("Le chemin d'accès spécifié est introuvable");
				}
			}

		}

	}

}
