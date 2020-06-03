package models;

import java.io.File;

public class CommandeCRD extends Commande {

	public CommandeCRD(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override
	public void executer() {
		System.out.println("Cette commande nécessite un argument");

	}

	@Override
	public void executer(String pParams) {
		File file = new File(pParams);

		if (!file.exists()) {

			if (file.mkdir()) {

				System.out.println("Le repertoire est créé!");

			} else {

				System.out.println("Erreur lors de la création!");
			}
		}

	}
}
