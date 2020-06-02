package models;

import java.io.File;
import java.io.IOException;

public final class CommandeCrf extends Commande {

	public CommandeCrf(String pNom, String pDescription) {
		super(pNom, pDescription);
		
	}

	private String params;

	@Override
	public void executer() {
		File file = new File(params);

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Fichier cr�� !");
			} catch (IOException e) {
				System.out.println("Erreur lors de la creation ");
			}

		} else {
			System.out.println("Fichier d�j� pr�sent !");

		}	

		}

	

	public void setParams(String argument) {
		this.params = argument;
	}

}
