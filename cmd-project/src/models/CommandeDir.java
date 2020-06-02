package models;

import java.io.File;

public final class CommandeDir extends Commande{

		private String params = "";
	    private Boolean recursivePath = false;

	
	public CommandeDir(String pNom,String pDescription,boolean subFolder) {
		super(pNom, pDescription);
		this.params=getParams();
        this.recursivePath = subFolder;
	}

	@Override
	public void executer() {
//		  String pathToExplore = params;
//		CommandeDir diskFileExplorer = new CommandeDir(pathToExplore, true);
		  listDirectory(params);
		  System.out.println("----------");
		  System.out.println("Analyse de " + params );
		}
	


	
    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                    
                } else {
                    System.out.println("  Fichier: " + files[i].getName());
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
    }

	public String getParams() {
		return params;
	}

	public  void setParams(String params) {
		this.params = params;
	}

	public Boolean getRecursivePath() {
		return recursivePath;
	}

	public void setRecursivePath(Boolean recursivePath) {
		this.recursivePath = recursivePath;
	}



}
