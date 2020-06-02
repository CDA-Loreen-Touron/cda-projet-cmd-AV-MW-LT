package models;

import java.io.File;

public final class CommandeDirng extends Commande{

	
	private String params = "";
    public int filecount = 0;
    public int dircount = 0;


    public CommandeDirng(String pNom, String pDescription) {
		super(pNom, pDescription);
		
	}


@Override
public void executer() {

	  listDirectory(params);
	  System.out.println("----------");
	  System.out.println("Analyse de " + params );
	  System.out.println(dircount + " dossiers");
	  System.out.println(filecount + " fichiers");
	  this.filecount=0;
	  this.dircount=0;
	}


private void listDirectory(String dir) {
    File file = new File(dir);
    File[] files = file.listFiles();
    if (files != null) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory() == true) {
                System.out.println("Dossier: " + files[i].getAbsolutePath());
                this.dircount++;
            } else {
                System.out.println("  Fichier: " + files[i].getName());
                this.filecount++;
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


public int getFilecount() {
	return filecount;
}

public int getDircount() {
	return dircount;
}    



}


