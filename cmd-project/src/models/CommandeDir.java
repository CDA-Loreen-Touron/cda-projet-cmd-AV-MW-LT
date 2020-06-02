package models;

import java.io.File;

public final class CommandeDir extends Commande {

	private String params = "";

	public CommandeDir(String pNom) {
		super(pNom);
	}

	@Override
	public void executer() {
		listDirectory(params);
		System.out.println("----------");
		System.out.println("Analyse de " + params);
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

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
