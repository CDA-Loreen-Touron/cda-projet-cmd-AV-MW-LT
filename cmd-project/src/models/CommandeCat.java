package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public final class CommandeCat extends Commande {

	public CommandeCat(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	@Override
	public void executer() {
		System.out.println("Cette commande prend un paramètre !");
	}

	@Override
	public void executer(String pParams) {
		File file = new File(pParams);

		if (!file.exists()) {
			System.out.println(" Le fichier n'existe pas ");
		} else {

			try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
				boolean verif = true;
				do {
					String line = bf.readLine();
					if (line != null) {
						System.out.println(line);
					} else {
						verif = false;
					}

				} while (verif);
			} catch (Exception e) {
				System.out.println("Erreur lors de la lecture du fichier");
			}

		}

	}

}
