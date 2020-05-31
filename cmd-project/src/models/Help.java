package models;

public final class Help extends Commande {
	

	public Help(String pNom) {
		super(pNom);
		// TODO Auto-generated constructor stub
	}


	
	
	@Override
	public void executer() {
		System.out.println("Bonjour de la part de la console CDA :)");
	}

	
	
	
	

}

// si la commande est égale à "help" afficher le message "Bonjour sur la console cda
//La commande "Help" doit afficher une description pour chaque commande