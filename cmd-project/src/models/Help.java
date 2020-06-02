package models;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Help extends Commande {

	public Help(String pNom, String pDescription) {
		super(pNom, pDescription);

	}

	private HashMap<String, String> hm ;

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
	@Override
	public void executer() {

		afficherHmap(hm);

	}
	private void afficherHmap(HashMap<String, String> pHm) {
		
		System.out.println("Parcours de la liste des commandes: ");

		Set<Entry<String, String>> vMyEntry = this.hm.entrySet();
		for (Entry<String, String> monEntry : vMyEntry) {
			System.out.println(monEntry.getKey() +":\t" +monEntry.getValue());
		}
	}
}

