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

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Fichier créé !");
			} catch (IOException e) {
				System.out.println("Erreur lors de la creation ");
			}

		} else {
			System.out.println("Fichier déjà présent !");
<<<<<<< HEAD
		}	
=======
		}

>>>>>>> 9c40d50e4674ef57c39ab366d67efd971dcfcb3d
	}
	

	public void setParams(String argument) {
		this.params = argument;
	}

}
/*
ajouter la commande "CRF" qui prend un paramètre et crée un fichier avec ce nom dans le répertoire en cours 
(répertoire en cours == le chemin qu'affiche la commande pwd)
> dir
 <DIR>  rep1
        f1.txt
> crf f2.txt
> dir
 <DIR>  rep1
        f1.txt
        f2.txt*/
