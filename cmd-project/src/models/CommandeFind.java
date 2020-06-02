package models;

import java.io.File;

public class CommandeFind extends Commande {

	public CommandeFind(String pNom) {
		super(pNom);

	}

	private byte option;
	private boolean ordre;

	private String[] params;
	private int compteur;

	public void getCompteur() {
		System.out.println(String.format("nombre de fichiers trouvés : %s", compteur));
	}

	private String refactorString3000(String pParams) {
		boolean s = false;
		boolean e = false;
		String finale = "";
		int finaleIndS = pParams.length();
		int debutIndS = 0;
		int finaleIndE = pParams.length();
		int debutIndE = 0;

		for (int i = 0; i < pParams.length(); i++) {
			if (pParams.charAt(i) == '-') {
				if (pParams.charAt(i + 1) == 's') {
					if (!s) {
						s = true;
						debutIndS = i;
						if (finaleIndE == pParams.length() && debutIndS != 0) {
							finaleIndE = debutIndS;
						}
					} else {
						finaleIndS = i;
					}
				}
				if (pParams.charAt(i + 1) == 'e') {
					if (!e ) {
						e = true;
						debutIndE = i;
						if (finaleIndS == pParams.length() && debutIndE != 0) {
							finaleIndS = debutIndE;
						}
					} else {

						finaleIndE = i;
					}
				}

			}

		}
		finale = pParams.substring(debutIndS, finaleIndS) + pParams.substring(debutIndE, finaleIndE);

		return finale;
	}

	public void determineOption(String pParams) {
		this.compteur = 0;

		if (pParams.contains("-starts") && pParams.contains("-ends")) {
			refactorString3000(pParams);
			option = 1;
			for (int i = 0; i < pParams.length(); i++) {

			}

			int indice = pParams.indexOf('-');
			if (pParams.charAt(indice + 1) == 's') {
				ordre = true;
			}
			this.params = pParams.replace("-starts", "/").replace("-ends", "/").replace(" ", "").split("/");

		} else if (pParams.contains("-starts")) {
			option = 2;
			this.params = pParams.replace("-starts", "/").replace(" ", "").split("/");

		} else if (pParams.contains("-ends")) {
			option = 3;
			this.params = pParams.replace("-ends", "/").replace(" ", "").split("/");

		} else {
			option = 0;
			this.params = pParams.trim().split(" ");
		}

	}

	private boolean getFileFiltred(byte pOption, String pName) {
		switch (pOption) {
		case 1:

			if (ordre) {
				return pName.startsWith(params[1]) && pName.endsWith(params[2]);
			} else {
				return pName.startsWith(params[2]) && pName.endsWith(params[1]);
			}

		case 2:

			return pName.startsWith(this.params[1]);
		case 3:

			return pName.endsWith(this.params[1]);

		default:
			return pName.contains(this.params[0]);

		}

	}

	@Override
	public void executer() {

		System.out.println("cette commande prend un paramètre");
	}

	@Override
	public void executer(String pParams) {
		File file = new File(pParams);

		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {

				if (files[i].isDirectory()) {
					executer(files[i].getAbsolutePath());
				} else {
					if (getFileFiltred(option, files[i].getName())) {
						System.out.println(files[i].getPath());
						compteur++;
					}

				}

			}

		}

	}
}