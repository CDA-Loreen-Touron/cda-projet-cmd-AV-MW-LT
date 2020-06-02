package models;

public class Help extends Commande {

	public Help(String pNom) {
		super(pNom);

	}

	@Override
	public void executer() {
		System.out.println("Bonjour de la part de la console CDA :)");
	}

	@Override
	public void executer(String pParams) {
		// TODO Auto-generated method stub
		
	}

}

// si la commande est �gale � "help" afficher le message "Bonjour sur la console cda
//La commande "Help" doit afficher une description pour chaque commande