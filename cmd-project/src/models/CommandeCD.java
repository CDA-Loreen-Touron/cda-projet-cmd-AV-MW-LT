package models;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.Menu;

public class CommandeCD extends Commande {

	private String args;

	public CommandeCD(String pNom, String pDescription) {
		super(pNom, pDescription);
		
	}

	@Override

	public void executer() {
		Pattern p = Pattern.compile("^\\W{1,}$");
		Matcher m = p.matcher(args);

		if (m.find()) {
			if (args.equals("..")) {
				if (!Menu.getCurrentDir().equals("c:\\")) {
					int lastBackSlash = Menu.getCurrentDir().lastIndexOf('\\');
					Menu.setCurrentDir(Menu.getCurrentDir().substring(0, lastBackSlash));
				}
			} else {
				System.out.println("Le chemin d'accès spécifié est introuvable");
			}
		} else {
			if (!Menu.getCurrentDir().equals("C:\\")) {
				File directory = new File(Menu.getCurrentDir() + "\\" + args);

				if (directory.isDirectory()) {
					Menu.setCurrentDir(Menu.getCurrentDir() + "\\" + args);
				} else {
					System.out.println("Le chemin d'accès spécifié est introuvable");
				}
			}else {
				File directory = new File(Menu.getCurrentDir() + args);

				if (directory.isDirectory()) {
					Menu.setCurrentDir(Menu.getCurrentDir() + args);
				} else {
					System.out.println("Le chemin d'accès spécifié est introuvable");
				}
			}
			
		}

	}

	public void setArgs(String args) {
		this.args = args;
	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}

}
