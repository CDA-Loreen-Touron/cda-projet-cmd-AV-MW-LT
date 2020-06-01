package models;

import java.io.File;
import java.io.IOException;

public final class CommandeCrf extends Commande {
	
	public CommandeCrf(String pNom) {
		super(pNom);
	}

	private String params;

	@Override
	public void executer() {
		File file = new File(params);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Fichier cr�� !");
			} catch (IOException e) {
				System.out.println("Erreur lors de la creation ");
			}
			
		}else {
			System.out.println("Fichier d�j� pr�sent !");
		}	
	}
	

	public void setParams(String argument) {
		this.params = argument;
	}
	
	

}
/*
ajouter la commande "CRF" qui prend un param�tre et cr�e un fichier avec ce nom dans le r�pertoire en cours 
(r�pertoire en cours == le chemin qu'affiche la commande pwd)
> dir
 <DIR>  rep1
        f1.txt
> crf f2.txt
> dir
 <DIR>  rep1
        f1.txt
        f2.txt*/
