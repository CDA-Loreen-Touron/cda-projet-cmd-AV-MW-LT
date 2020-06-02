package models;

import java.io.File;
import java.io.IOException;

public final class CommandeCrf extends Commande {

	public CommandeCrf(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override
	public void executer() {
		System.out.println("Cette commande prend un paramètre!");
	}

	@Override
	public void executer(String pParams) {

		File file = new File(pParams);

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

}
