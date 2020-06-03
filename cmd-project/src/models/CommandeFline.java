package models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandeFline extends Commande {

	public CommandeFline(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	private String recherche = "";

	@Override
	public void executer() {

		System.out.println("Cette commande prend des paramètre !");

	}

	@Override
	public void executer(String pParams) {

		pParams = pParams.replace(" ", "/");

		Pattern p = Pattern.compile("/{2,}");
		Matcher m = p.matcher(pParams);

		while (m.find()) {
			pParams = m.replaceAll("/");

		}

		String[] tab = pParams.split("/");

		File file = new File(tab[0]);

		if (tab.length > 2 && tab[1].equals("-n")) {

			System.out.println("L'option N dois être utiliser seul !");
		} else if (tab.length == 1) {
			CommandeCat cat = new CommandeCat("", "");
			cat.executer(pParams);
		} else {
			int debut = 0;
			long fin = countLine(file);

			boolean juik = true;

			if (tab[1].equals("-n")) {

				System.out.println(countLine(file) + " lignes");
			} else {
				for (int i = 1; i < tab.length; i++) {
					try {
						if (tab[i].equals("-f")) {
							fin = Long.parseLong(tab[i + 1]);
						}
						if (tab[i].equals("-d")) {
							debut = Integer.parseInt(tab[i + 1]);
						}
						if (tab[i].equals("-s")) {
							recherche = tab[i + 1];
							juik = false;
						}

					} catch (IndexOutOfBoundsException e) {

						System.out.println("les options prennent une valeur chiffré !");
						return;
					} catch (NumberFormatException e) {
						System.out.println(
								"Erreur lors de la conversion ! veuillez rentrez un chiffre pour l'option d ou f");
						return;
					}

				}

				try (Stream<String> allLine = Files.lines(Paths.get(file.toURI()))) {

					if (juik) {
						allLine.skip(debut).limit(fin - debut).collect(Collectors.toList())
								.forEach(System.out::println);
					} else {
						allLine.skip(debut).limit(fin - debut).filter(x -> x.contains(recherche))
								.collect(Collectors.toList()).forEach(System.out::println);
					}

				} catch (Exception e) {

					System.out.println("Erreur lors de la lecture du fichier ");

				}

			}
		}
	}

	private long countLine(File vFile) {

		long result = 0;
		try {
			result = Files.lines(Paths.get(vFile.toURI())).count();
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture ");
		}
		return result;
	}

}
