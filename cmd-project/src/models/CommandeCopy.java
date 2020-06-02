package models;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import tools.Menu;

public final class CommandeCopy extends Commande {

	public CommandeCopy(String pNom, String pDescription) {
		super(pNom, pDescription);
		// TODO Auto-generated constructor stub
	}

	private String param = "";


	@Override
	public void executer() {

		int index = 0;
		String vParamB = "";

		if (param.contains(" ")) {
			for (int i = 0; i < param.length(); i++) {
				if (param.charAt(i) == ' ') {
					index = i;
					break;
				} else if (param.charAt(i) == '-') {
					break;
				}
			}

			String vParamA = param.substring(0, index).trim();
			System.out.println(vParamA);
			vParamB = param.substring(index + 1, param.length()).trim();
			System.out.println(vParamB);

			File vFichierRecherche = new File(vParamA);

			if (!vFichierRecherche.exists()) {
				System.out.println("Le fichier spécifié est introuvable.");

			} else {

				File vFichierCible = new File(Menu.getCurrentDir() + "\\" + vParamB);

				if (vFichierCible.exists()) {
					System.out.println("Le fichier cible existe déjà.");
				} else {

					try (InputStream fichierSource = new FileInputStream(vFichierRecherche);
							OutputStream fichierSortie = new FileOutputStream(vFichierCible)) {
						byte[] vBufferDeTransfert = new byte[8024];
						int nbOctetsLus = fichierSource.read(vBufferDeTransfert);
						while (nbOctetsLus != -1) {
							fichierSortie.write(vBufferDeTransfert, 0, nbOctetsLus);
							nbOctetsLus = fichierSource.read(vBufferDeTransfert);
						}

						System.out.println("Copie faite avec succès (" + vFichierRecherche.length() + " octets).");

					} catch (IOException e) {
						System.out.println("La commande a rencontré un problème " + e.getMessage() + ".");
					}
				}
			}
		}else {
			System.out.println("Un paramètre est manquant.");
		}
	}

	public void setParam(String pParams) {

		this.param = pParams.trim();

	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}

}
