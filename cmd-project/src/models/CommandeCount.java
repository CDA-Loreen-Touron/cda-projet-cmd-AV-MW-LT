package models;

import java.io.File;

import tools.Menu;

public final class CommandeCount extends Commande {

	private int filecount = 0;
	private int dircount = 0;
	private Boolean recursivePath = false;

	public CommandeCount(String pNom, String pDescription) {
		super(pNom, pDescription);
		this.recursivePath = true;
	}

	@Override
	public void executer() {

		String RepEnCours = Menu.getCurrentDir();
		listDirectory(RepEnCours);
		System.out.println(filecount + " 	fichiers");
		System.out.println(dircount + " 	dossiers");
		this.filecount = 0;
		this.dircount = 0;

	}

	private void listDirectory(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					this.dircount++;
				} else {
					this.filecount++;
				}
			}
		}
	}

	private void listDirectoryOptionR(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					this.dircount++;
				} else {
					this.filecount++;
				}
				if (files[i].isDirectory() == true && this.recursivePath == true) {
					this.listDirectoryOptionR(files[i].getAbsolutePath());
				}
			}
		}
	}

	@Override
	public void executer(String pParams) {

		if (pParams.charAt(0) != '-') {
			System.out.println("L'ajout d'options doit commencer par -");
		} else {

			String RepEnCours = Menu.getCurrentDir();

			String param = "";

			for (int j = 0; j < pParams.length(); j++) {
				if (pParams.charAt(j) != ' ' && pParams.charAt(j) != '-') {
					param += pParams.charAt(j);
				}
			}

			try {

				if (param.length() > 3) {
					System.out.println("Nombre de paramètres incorrecte.");
				} else {

					switch (param) {
					case "f":
						listDirectory(RepEnCours);
						System.out.println(filecount + " 	fichiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "d":
						listDirectory(RepEnCours);
						System.out.println(dircount + " 	dossiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "fd":
						listDirectory(RepEnCours);
						System.out.println(filecount + " 	fichiers");
						System.out.println(dircount + " 	dossiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "df":
						listDirectory(RepEnCours);
						System.out.println(dircount + " 	dossiers");
						System.out.println(filecount + " 	fichiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "r":
						listDirectoryOptionR(RepEnCours);
						System.out.println(filecount + " 	fichiers");
						System.out.println(dircount + " 	dossiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "rd":
						listDirectoryOptionR(RepEnCours);
						System.out.println(dircount + " 	dossiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "rf":
						listDirectoryOptionR(RepEnCours);
						System.out.println(filecount + " 	fichiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "rdf":
						listDirectoryOptionR(RepEnCours);
						System.out.println(dircount + " 	dossiers");
						System.out.println(filecount + " 	fichiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					case "rfd":
						listDirectoryOptionR(RepEnCours);
						System.out.println(filecount + " 	fichiers");
						System.out.println(dircount + " 	dossiers");
						this.filecount = 0;
						this.dircount = 0;
						break;

					default:

						String unknown = "";
						for (int i = 0; i < param.length(); i++) {
							if (param.charAt(i) != 'f' && param.charAt(i) != 'r' && param.charAt(i) != 'd') {
								unknown += param.charAt(i);
							}
						}
						System.out.println("unknown option -" + unknown);
						break;
					}
				}

			} catch (Exception e) {
				System.out.println("Paramètre saisi incorrecte.");
			}
		}
	}

	public Boolean getRecursivePath() {
		return recursivePath;
	}

	public void setRecursivePath(Boolean recursivePath) {
		this.recursivePath = recursivePath;
	}
}
