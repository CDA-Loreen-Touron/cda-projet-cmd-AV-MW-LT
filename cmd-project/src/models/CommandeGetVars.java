package models;

import java.util.Map;
import java.util.Properties;

public final class CommandeGetVars extends Commande {

	public CommandeGetVars(String pNom, String pDescription) {
		super(pNom, pDescription);
	}

	@Override
	public void executer() {

		try {
			Map<String, String> env = System.getenv();

			Properties properties = System.getProperties();

			System.out.println("============== VARIABLES D'ENVIRONNMEENT ==============");
			System.out.println();
			for (Map.Entry<String, String> entry : env.entrySet()) {
				System.out.println(entry.getKey() + " 		: " + entry.getValue());
			}
			System.out.println();
			System.out.println("=================   PROPRIETES DE LA JVM  =================");
			System.out.println();
			properties.forEach((k, v) -> System.out.println(k + "	:" + v));

		} catch (Exception e) {
			System.out.println("Erreur de saisie de paramètre");
		}

	}

	@Override
	public void executer(String pParams) {

		try {
			Map<String, String> env = System.getenv();

			Properties properties = System.getProperties();

			if (pParams.equals("-env")) {

				for (Map.Entry<String, String> entry : env.entrySet()) {
					System.out.println(entry.getKey() + " 		: " + entry.getValue());
				}
			} else if (pParams.equals("-prop")) {

				properties.forEach((k, v) -> System.out.println(k + "	:" + v));
			} else {
				System.out.println("Saisie incorrecte.");
			}
		} catch (Exception e) {
			System.out.println("Erreur de saisie de paramètre");
		}

	}

}
