package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Hystory extends Commande {

	private final ArrayList<String> historique;

	public Hystory(String pNom, String pDescription) {
		super(pNom, pDescription);
		historique = new ArrayList<>();
	}

	@Override
	public void executer() {

		if (this.historique.size() == 0) {
			System.out.println("l'historique est vide !");
		}
		this.historique.forEach(System.out::println);
	}

	public void ajouterElementList(String pCommande) {

		if (this.historique.size() == 10) {
			this.historique.remove(0);

		}
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtfH = DateTimeFormatter.ofPattern("HH:mm:ss");
		DateTimeFormatter dtfD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String y = String.format(" commande :%s utilisée à %s le %s ", pCommande, ldt.format(dtfH), ldt.format(dtfD));
		this.historique.add(y);

	}

	public void clear() {
		this.historique.clear();
	}

	@Override
	public void executer(String pParams) {
		System.out.println("Cette commande ne prend pas de paramètre");
		
	}

}
