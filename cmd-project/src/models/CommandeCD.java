package models;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

<<<<<<< HEAD
/*
public final class CommandeCD extends Commande {
=======
import tools.Menu;

public class CommandeCD extends Commande {
>>>>>>> 9c40d50e4674ef57c39ab366d67efd971dcfcb3d

	private String args;

	public CommandeCD(String pNom) {
		super(pNom);
<<<<<<< HEAD
	
	
		//File vFile = new File();
		
	
	
	
	
	

	
	/*@Override
=======
	}

	@Override
>>>>>>> 9c40d50e4674ef57c39ab366d67efd971dcfcb3d
	public void executer() {
		Pattern p = Pattern.compile("\\W{1,}");
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

			File directory = new File(Menu.getCurrentDir() + "\\" + args);

			if (directory.isDirectory()) {
				Menu.setCurrentDir(Menu.getCurrentDir() + "\\" + args);
			} else {
				System.out.println("Le chemin d'accès spécifié est introuvable");
			}
		}

	}

	public void setArgs(String args) {
		this.args = args;
	}

	
}
