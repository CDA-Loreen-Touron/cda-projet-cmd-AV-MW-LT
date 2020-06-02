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
				System.out.println("Fichier créé!");
			} catch (IOException e) {
				System.out.println("Erreur lors de la création ");
			}

		} else {
			System.out.println("Fichier déjà présent !");

		}

	}

	public void setParams(String argument) {
		this.params = argument;
	}

}
