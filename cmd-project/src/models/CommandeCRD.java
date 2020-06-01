package models;

import java.io.File;

public class CommandeCRD extends Commande {

	public CommandeCRD(String pNom) {
		super(pNom);
	}

	private String params = "C:\\Directory1";

	@Override
	public void executer() {

		File file = new File(params);

		if (!file.exists()) {

			if (file.mkdir()) {

				System.out.println("Le repertoire est créé!");

			} else {

				System.out.println("Erreur lors de la création!");
			}
		}

	}

	public void setParams(String argument) {
		this.params = argument;
	}
}
