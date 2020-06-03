package models;

public abstract class Commande implements IExecutable {

	protected String nom;
	protected String description;

	public Commande(String pNom, String pDescription) {
		this.nom = pNom;
		this.description = pDescription;
	}

	public String getNom() {
		return this.nom;
	}

	public String getDescription() {
		return this.description;
	}

}
