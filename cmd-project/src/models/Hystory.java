package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Hystory extends Commande {
	
	private final ArrayList<String> historique;

	public Hystory(String pNom) {
		super(pNom);
		historique= new ArrayList<>();
	}

	@Override
	public void executer() {
		
	this.historique.forEach(System.out::println);	
	}
	
	public void ajouterElementList(String pCommande) {
		
		
		if(this.historique.size()==10) {
		this.historique.remove(0);	
			
		}
		LocalDateTime ldt = LocalDateTime.now()	;
		DateTimeFormatter dtfH = DateTimeFormatter.ofPattern("HH:mm:ss");	
		DateTimeFormatter dtfD = DateTimeFormatter.ofPattern(" dd/MM/yyyy");
		String y = String.format("%s utilisé à %s le %s ", pCommande,ldt.format(dtfH), pCommande,ldt.format(dtfD));
		this.historique.add(y);
		
		
		
	}
	public void clear() {
		this.historique.clear();
	}

}
