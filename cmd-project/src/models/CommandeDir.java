package models;

import java.io.File;

public final class CommandeDir extends Commande {


	public CommandeDir(String pNom, String pDescription, boolean subFolder) {
		super(pNom, pDescription);
	

	}

	public CommandeDir(String pNom, String pDescription) {
		super(pNom, pDescription);
	}

	@Override
	public void executer() {
		
	}

	@Override
	public void executer(String pParams) {
		listDirectory(pParams);
		System.out.println("----------");
		System.out.println("Analyse de " + pParams);
	}

	private void listDirectory(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					System.out.println("<DIV>		dir" + files[i].getAbsolutePath());

				} else {
					System.out.println("						" + files[i].getName());
				}
			}
		}
		
	}

}
