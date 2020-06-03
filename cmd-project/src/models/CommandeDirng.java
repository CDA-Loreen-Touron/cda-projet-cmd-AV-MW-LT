package models;

import java.io.File;

public final class CommandeDirng extends Commande {

	public int filecount = 0;
	public int dircount = 0;

	public CommandeDirng(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override
	public void executer(String pParams) {

		listDirectory(pParams);
		System.out.println("----------");
		System.out.println("Analyse de " + pParams);
		System.out.println(dircount + " dossiers");
		System.out.println(filecount + " fichiers");
		this.filecount = 0;
		this.dircount = 0;
	}

	private void listDirectory(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					System.out.println("<DIV>		dir" + files[i].getAbsolutePath());
					this.dircount++;
				} else {
					System.out.println("						" + files[i].getName());
					this.filecount++;
				}
			}
		}
	}

	public int getFilecount() {
		return filecount;
	}

	public int getDircount() {
		return dircount;
	}

	@Override
	public void executer() {

	}

}
