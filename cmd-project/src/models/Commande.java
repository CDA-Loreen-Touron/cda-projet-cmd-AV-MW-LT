package models;

public abstract class Commande implements IExecutable {

	private String nom;
	
<<<<<<< HEAD
	public Commande(String pNom) {
		this.nom=pNom;
	}
=======
	private String nom;

	public Commande (String pNom) {
	this.nom=pNom;
}
	
	
	
	
	
>>>>>>> dev-loreen

	public String getNom() {
		return nom;
	}
public void executer() {
	// TODO Auto-generated method stub
	
}
}
